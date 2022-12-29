package com.manager.freelancer.myProject.model.service;

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
import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.dao.MyProjectFreelancerDAO;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.myProject.model.vo.Pagination;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancerProfit;
import com.manager.freelancer.myProject.model.vo.myProjectServiceInquiry;



/**
 * @author USER
 *
 */
@Service
public class MyProjectFreelancerServiceImpl implements MyProjectFreelancerService{
	
	@Autowired
	private MyProjectFreelancerDAO dao;

	
	/**
	 * 메인 카테고리 들고 오기
	 */
	@Override
	public List<FreelancerService> selectmaincategoryList() {
		return dao.selectmaincategoryList();
	}

	/**
	 * 카테고리3 들고 오기
	 */
	@Override
	public List<FreelancerService> selectcategoryList() {
		return dao.selectcategoryList();
	}

	/**
	 * 서비스 등록하기 서비스 번호 맞게 등록되는 지 확인하기
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertService(String webPath, String filePath, List<MultipartFile> serviceFile, Member loginMember,
			FreelancerService freelancerVo) throws IOException {
		
		// 1) XSS(크로스 사이트 스크립트 공격), 개행문자 처리
		freelancerVo.setServiceTitle(  Util.XSSHandling(freelancerVo.getServiceTitle())  );
		freelancerVo.setServiceSummary(  Util.XSSHandling(freelancerVo.getServiceSummary())  );
		freelancerVo.setServiceContent( Util.newLineHandling(freelancerVo.getServiceContent()));
		
		int serviceNo = dao.insertService(freelancerVo,loginMember);
		
		// 2. 첨부만 삽입
		if(serviceNo > 0) {
					
				// serviceFile : 실제 파일이 담겨있는 리스트
				// servicefileList : DB에 삽입할 이미지 정보만 담겨있는 리스트
				// reNameList : 변경된 파일명만 담겨있는 리스트
					
				List<myProjectServiceInquiry> servicefileList = new ArrayList<myProjectServiceInquiry>();
				List<String> reNameList = new ArrayList<String>();
					
				// serviceFile에 담겨있는 파일 중
				// 실제로 업로드된 파일만 분류하는 작업 진행
				for(int i=0 ; i<serviceFile.size() ; i ++) {
						
					// i번째 파일의 크기가 0보다 크다 == 업로드된 파일이 있다
					if(serviceFile.get(i).getSize() > 0) {
							
						// myProjectServiceInquiry 객체 생성
						myProjectServiceInquiry file = new myProjectServiceInquiry();
							
						// myProjectServiceInquiry 값 세팅
						file.setServiceFilePath(webPath);
							
						// 원본 파일명 -> 변경된 파일명
						String reName = Util.fileRename(serviceFile.get(i).getOriginalFilename());
						file.setServiceFilePath(webPath+reName);
						reNameList.add(reName); // 변경파일명 리스트에 추가
							
			
						file.setServiceNo(serviceNo); // 첨부된 게시글 번호
							
						// servicefileList에 추가
						servicefileList.add(file);
					} // if 끝
				} // for 끝
					
					
				// servicefileList가 비어있지 않다면
				// == 업로드된 파일이 있어서 분류된 내용이 존재
				if(!servicefileList.isEmpty()) {
						
					// DB에 업로드된 파일 정보 INSERT
					int result = dao.insertFileImageList(servicefileList);
						
					// 삽입 결과 행의 수 == DB에 삽입하려고 분류한 리스트의 크기
					// 전부 다 삽입된 경우
					if( result == servicefileList.size() ) {
							
						// 파일 변환 작업
						for(int i=0 ; i<servicefileList.size() ; i++) {
								
							// 실제 파일로 변환
							serviceFile.get(i).transferTo(new File(filePath + reNameList.get(i)));    
						}
					}
				}
			}
		
		return serviceNo;
	}
	
	/**
	 * 페이지 처리 안함
	 */
	@Override
	public List<FreelancerService> selectMyService(int memberNo, int i) {
		
		return dao.selectMyService(memberNo,i);
	}

	/**
	 * 나의 서비스 들고오기 페이지 처리
	 */
	@Override
	public Map<String, Object> selectMyService(int memberNo,int mainCategoryNo, int cp) {
		
		int listCount = dao.getMyServiceListCount(memberNo,mainCategoryNo);
		
		Pagination pagination = new Pagination(listCount,cp); //게시판 게시글 몇개 정렬인지도 매개변수 정해줌
		
		List<FreelancerService> myService = dao.selectMyService(memberNo,mainCategoryNo,pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("myService",myService);
		map.put("listCount",listCount);
		
		
		return map;
	}

	/**
	 *판매내역 들고오기loginMember.getMemberNo(),mainCategoryNo,searchInput,freelancerFL
	 */
	@Override
	public Map<String, Object> selectSalesList(int memberNo, int mainCategoryNo, String searchInput,
			int freelancerFL,int cp) {
		
		int listCount = dao.getSalesListCount(memberNo,freelancerFL,searchInput, mainCategoryNo);
		
		Pagination pagination = new Pagination(listCount,cp); //게시판 게시글 몇개 정렬인지도 매개변수 정해줌
		List<FreelancerService> salesList = dao.selectSalesList(memberNo,freelancerFL,searchInput, mainCategoryNo,pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("salesList",salesList);
		map.put("listCount",listCount);
		
		return map;
	}

	/**
	 *신고하기
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Map<String, Object> insertreportSubmit(String webPath, String filePath,int tradeNo, int reportPersonNo, int reportedPersonNo,
			String reportContent, MultipartFile reportFile) throws Exception {
		

		reportContent = ( Util.newLineHandling(reportContent));
		
		// 실패를 대비해서 이전 이미지 경로 저장
		//String temp = reportFile;
		
		// 중복 파일명 업로드를 대비하기 위해서 파일명 변경
		String rename = null;
		String reportFilePath = null;
		
		if(reportFile == null) { // 업로드된 파일이 없는 경우
			reportFilePath = null;
		}else { // 업로드된 파일이 있을 경우
			
			// 원본파일명을 이용해서 새로운 파일명 생성
			rename = Util.fileRename( reportFile.getOriginalFilename() );
			
			reportFilePath = (webPath + rename);
			// /resources/images/memberProfile/변경된파일명
		}
		
		int tradeReportNo = dao.insertreportSubmit(reportFilePath,tradeNo,reportPersonNo,reportedPersonNo,reportContent);
		String message = null;
		if( tradeReportNo > 0 ) { // DB 수정 성공 시 -> 실제로 서버에 파일 저장
			
			if(rename != null) { 
				// 변경된 이미지명이 있다 == 새로운 파일이 업로드 되었다
				
				reportFile.transferTo(new File(filePath +  rename));
				// 메모리에 임시 저장된 파일을 지정된 경로에 파일 형태로 변환 
				// == 서버 파일 업로드
			}
			
			message = "신고가 접수되었습니다.";
			
		}else {
			message = "신고 접수를 실패하셨습니다.";
			throw new Exception("파일 업로드 실패"); // 예외 강제 발생
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("messageIN",message);
		map.put("tradeReportNo",tradeReportNo);
		map.put("reportFilePath",reportFilePath);
		
		return map;
	}

	/**
	 *작업물 발송하기
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String insertsendworkSubmit(int tradeNo) throws Exception{
		
		String message ="";
		int result = dao.insertsendworkSubmit(tradeNo);
		if(result > 0) {
			message = "작업물 발송이 완료되었습니다.";
					
		}else {
			message = "작업물 발송 실패했습니다.";
			throw new Exception("작업물 발송 실패");
		}
		return message;
	}

	/**
	 *거래 프리랜서 작업 상태 완료로 변경하기
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String insertfinishSubmit(int tradeNo) throws Exception{

		String message ="";
		int result = dao.insertfinishSubmit(tradeNo);
		if(result > 0) {
			message = "작업상태가 완료로 변경되었습니다.";
					
		}else {
			message = "작업상태 변경 실패했습니다.";
			throw new Exception("작업상태 변경");
		}
		return message;
	}

	/**
	 *프리랜서가 한 프로젝트 의뢰 제안 들고오기
	 */
	@Override
	public Map<String, Object> selectMyProposal(int memberNo, int mainCategoryNo, int cp) {
		
		int listCount = dao.getMyProposalListCount(memberNo,mainCategoryNo);
		
		Pagination pagination = new Pagination(listCount,cp); //게시판 게시글 몇개 정렬인지도 매개변수 정해줌
		
		List<FreelancerService> myProposalList = dao.selectMyProposal(memberNo,mainCategoryNo,pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("myProposalList",myProposalList);
		map.put("listCount",listCount);
		
		return map; 
	}

	/**
	 *나의 달별 총 수익 들고오기
	 */
	@Override
	public List<myProjectFreelancerProfit> selectMonthMyProfit(int memberNo) {
		return dao.selectMonthMyProfit(memberNo);
	}

	/**
	 *검색해오는 시검의 1년간 총 수익이랑 예상 수익 들고오기
	 */
	@Override
	public List<myProjectFreelancerProfit> selectMyProfit(int memberNo) {
		return dao.selectMyProfit(memberNo);
	}

	/**
	 *거래별 정산 내역 출력
	 */
	@Override
	public Map<String, Object> selectMyProfitEachList(int memberNo, int cp) {
		
		int listCount = dao.getMyProfitEachListCount(memberNo);
		
		Pagination pagination = new Pagination(listCount,cp); //게시판 게시글 몇개 정렬인지도 매개변수 정해줌
		
		List<myProjectFreelancerProfit> myProfitEachList =  dao.selectMyProfitEachList(memberNo,pagination);//return dao.selectMyProfitEachList(memberNo);
				
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("myProfitEachList",myProfitEachList);
		map.put("listCount",listCount);
		
		return map; 
	}

	
}
