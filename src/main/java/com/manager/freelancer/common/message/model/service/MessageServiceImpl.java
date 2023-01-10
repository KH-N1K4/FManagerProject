package com.manager.freelancer.common.message.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.common.Util;
import com.manager.freelancer.common.message.model.dao.MessageDAO;
import com.manager.freelancer.common.message.model.vo.ChattingRoom;
import com.manager.freelancer.common.message.model.vo.MemberReport;
import com.manager.freelancer.common.message.model.vo.MemberReportFile;
import com.manager.freelancer.common.message.model.vo.Message;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.myProject.model.vo.Pagination;
import com.manager.freelancer.myProject.model.vo.myProjectServiceInquiry;


@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageDAO dao;

	/**
	 *채팅방 있는 지 확인
	 */
	@Override
	public ChattingRoom checkChattingRoomNo(Map<String, Integer> map) {
		return dao.checkChattingRoomNo(map);
	}

	/**
	 *없으면 채팅방 생성
	 */
	@Override
	public int createChattingRoom(Map<String, Integer> map) {
		return dao.createChattingRoom(map);
	}

	/**
	 *참여중인 채팅방
	 */
	@Override
	public List<ChattingRoom> selectRoomList(int memberNo) {
		return dao.selectRoomList(memberNo);
	}

	/**채팅방 나가기 여부가 Y이면 N로 변경
	 *
	 */
	@Override
	public int updateChattingRoom(ChattingRoom chatRoom) {
		return dao.updateChattingRoom(chatRoom);
		
	}

	/**
	 *채팅방 나가기 여부 확인
	 */
	@Override
	public ChattingRoom delectFLRoomNo(Map<String, Integer> map) {
		return dao.delectFLRoomNo(map);
	}
	
    /**
     *메세지 삽입
     */
    @Override
    public int insertMessage(Message msg) {
    	//msg.setMessageContent(Util.XSSHandling(msg.getMessageContent()));
        msg.setChatMessage(Util.newLineHandling(msg.getChatMessage()));
        return dao.insertMessage(msg);
    }

    /**
     *읽음 처리로 변경
     */
    @Override
    public int updateReadFlag(Map<String, Object> paramMap) {
        return dao.updateReadFlag(paramMap);
    }

    /**
     *채팅방에 들어갔을 때 메세지 다 들고 오기 
     */
    @Override
    public List<Message> selectMessageList( Map<String, Object> paramMap, int memberNo) {
        System.out.println(paramMap);
        List<Message> messageList = dao.selectMessageList(  Integer.parseInt( String.valueOf(paramMap.get("chatRoomNo") )) , memberNo);
        
        if(!messageList.isEmpty()) {
            int result = dao.updateReadFlag(paramMap);
        }
        return messageList;
    }

	/**
	 *채팅방 나가기
	 */
	@Override
	public int updateOutFL(Map<String, Object> paramMap) {
		int result = dao.updateOutFL(paramMap);
		if(result ==0) {
			result = dao.updateOutClientFL(paramMap);
		}
		return result;
	}

	/**
	 *채팅방 나가기 여부 확인: 상대방
	 */
	@Override
	public ChattingRoom delectFLRoomNoClient(Map<String, Integer> map) {

		return dao.delectFLRoomNoClient(map);
	}

	/**
	 *채팅방 신고하기
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String memberReportUpdate(String webPath, String filePath, String reportedMemberNo, String reportMemberNo,
			String reportContent, List<MultipartFile> file, MemberReport memberReport, String reportTitle) throws IOException {
		
		// 1) XSS(크로스 사이트 스크립트 공격), 개행문자 처리
		reportTitle=(  Util.XSSHandling(reportTitle));
		reportContent= (  Util.XSSHandling(reportContent));
				
				int reportNo = dao.memberReportUpdate(Integer.parseInt(reportedMemberNo),Integer.parseInt(reportMemberNo),
						reportTitle,reportContent);
				
				String message = "";
				// 2. 첨부만 삽입
				if(reportNo > 0) {
						message ="신고가 접수되었습니다.";
						// file : 실제 파일이 담겨있는 리스트
						// reportFileList : DB에 삽입할 이미지 정보만 담겨있는 리스트
						// reNameList : 변경된 파일명만 담겨있는 리스트
							
						List<MemberReportFile> reportFileList = new ArrayList<MemberReportFile>();
						List<String> reNameList = new ArrayList<String>();
							
						// serviceFile에 담겨있는 파일 중
						// 실제로 업로드된 파일만 분류하는 작업 진행
						for(int i=0 ; i<file.size() ; i ++) {
								
							// i번째 파일의 크기가 0보다 크다 == 업로드된 파일이 있다
							if(file.get(i).getSize() > 0) {
									
								// MemberReportFile 객체 생성
								MemberReportFile fileVal = new MemberReportFile();
									
								// MemberReportFile 값 세팅  (webPath);
								fileVal.setMemberReportfilePath(webPath);
									
								// 원본 파일명 -> 변경된 파일명
								String reName = Util.fileRename(file.get(i).getOriginalFilename());
								fileVal.setMemberReportfilePath(webPath+reName);
								reNameList.add(reName); // 변경파일명 리스트에 추가
									
					
								fileVal.setReportNo(reportNo);; // 첨부된 게시글 번호
								fileVal.setMemberReportfileOther(i);	
								// servicefileList에 추가
								reportFileList.add(fileVal);
							} // if 끝
						} // for 끝
							
							
						// servicefileList가 비어있지 않다면
						// == 업로드된 파일이 있어서 분류된 내용이 존재
						if(!reportFileList.isEmpty()) {
								
							// DB에 업로드된 파일 정보 INSERT
							int result = dao.insertReportFileList(reportFileList);
								
							// 삽입 결과 행의 수 == DB에 삽입하려고 분류한 리스트의 크기
							// 전부 다 삽입된 경우
							if( result == reportFileList.size() ) {
									
								// 파일 변환 작업
								for(int i=0 ; i<reportFileList.size() ; i++) {
										
									// 실제 파일로 변환
									file.get(i).transferTo(new File(filePath + reNameList.get(i)));    
								}
							}
						}
					}else {
						message ="신고 접수 실패하셨습니다.";
					}
				
				
		return message;
	}

	/**채빙탕에서 신고한 신고내역보기(고객센터에 회원 신고 내역)
	 *
	 */
	@Override
	public Map<String, Object> selectUserReportList(int memberNo, int cp, int inquiryStatus, String searchKey, String searchQuery) {

		int listCount = dao.getUserReportListCount(memberNo,inquiryStatus,searchKey,searchQuery);
		
		Pagination pagination = new Pagination(listCount,cp,10,10); //게시판 게시글 몇개 정렬인지도 매개변수 정해줌
		List<MemberReport> memberReport = dao.selectUserReportList(memberNo,inquiryStatus,pagination,searchKey,searchQuery);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("memberReport",memberReport);
		map.put("listCount",listCount);
		
		return map;
	}

	/**
	 *회원 신고 상세보기
	 */
	@Override
	public MemberReport viewUserReportDetail(int membeReportNo) {

		return dao.viewUserReportDetail(membeReportNo);
	}
}
