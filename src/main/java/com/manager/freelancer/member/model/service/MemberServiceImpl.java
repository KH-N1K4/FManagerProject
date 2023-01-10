package com.manager.freelancer.member.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.category.model.vo.AskService;
import com.manager.freelancer.member.model.dao.MemberDAO;
import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.member.model.vo.Pagination;
import com.manager.freelancer.member.model.vo.Util;
import com.manager.freelancer.myProject.model.vo.MyProjectPayment;


@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	// spring-security.xml에서 등록한 bean을 의존성 주입(DI) 
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	// 회원가입 서비스 
	@Override
	@Transactional(rollbackFor=Exception.class)//모든 예외 발생 시 롤백 
	public int signUp(Member inputMember) {
		// 비밀번호 암호화 
		int result=0;
		String interestList=inputMember.getMemberInterest();
		String encPw=bcrypt.encode(inputMember.getMemberPw());
		inputMember.setMemberPw(encPw);
		
		if(interestList!=null) {
			String[] interest=interestList.split(",");
			
			// DAO 호출 후 결과 반환 받기 
			result=dao.signUp(inputMember);
			
			Map<String, String> map=new HashMap<String, String>();
			
			map.put("memberNo", inputMember.getMemberNo()+"");
			
			for(int i=0;i<interest.length;i++) {
				map.put("memberInterest",interest[i]);
				
				result=dao.insertInterest(map);
			}
			
		}else {
			result=dao.signUp(inputMember);
		}
		
			
		return result;
	}
	
	
	
	@Override
	public Member login(Member inputMember) {
		
		// bcrypt 이용시 로그인 방법 
		// 1. 이메일이 일치하는 회원 정보를 DB에서 조회 
		// 	반드시 비밀번호(MEMBER_PW) 포함되어야 함. 
		Member loginMember=dao.login(inputMember.getMemberEmail());
		
		// 2. 입력 받은 비밀번호(평문)
		// 	조회한 암호화된 비밀번호 비교 
		//   --> BCryptPasswordEncoder.matches(평문, 암호문) 이용
		//		--> 같으면 true, 아니면 false 
		
		if(loginMember!=null) { // 아이디 정상 입력 
			if(bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) {
				// 3-1. 비밀번호가 일치하면 조회된 회원 정보 반환
				// 		단, 비밀번호는 제거 
				
				loginMember.setMemberPw(null);
				
			}else {
				// 3-2. 비밀번호가 일치하지 않으면 null을 반환 
				loginMember=null;
				
			}
		}
	
		return loginMember;
	}



	@Transactional(rollbackFor = Exception.class)
	@Override
	public int updateMyInfo(String webPath, String filePath, MultipartFile profileImage,Member inputMember) throws Exception {

		// 실패를 대비해서 이전 이미지 경로 저장 
		String temp=inputMember.getMemberProfile();
		
		// 중복 파일명 업로드를 대비하기 위해서 파일명 변경 
		String rename=null;
		
		if(profileImage.getSize()==0) { // 업로드된 파일이 없는 경우 
			inputMember.setMemberProfile(null);
		}else {
			rename=Util.fileRename(profileImage.getOriginalFilename());
			
			inputMember.setMemberProfile(webPath+rename);
			// /resources/images/memberProfile/변경된파일명 
		}
		
		
		int result=dao.updateMyInfo(inputMember); // 0 또는 1 
		
		if(result>0) { // DB 수정 성공시 -> 실제로 서버에 파일 저장 
			if(rename!=null) {
				// 변경된 이미지명이 있다 == 새로운 파일이 업로드 되었다 
				
				profileImage.transferTo(new File(filePath+rename));
				// 메모리에 임시 저장된 파일을 지정된 경로에 파일 형태로 변환
				// == 서버 파일 업로드 
			}else { 
				// 실패시 다시 이전 이미지를 세팅 
				inputMember.setMemberProfile(temp);
				throw new Exception("파일 업로드 실패"); // 예외 강제 발생
			}
		}
		
		return result; // 결과 반환
	}



	



		@Override
		public int updateMyInfoNonPhoto(Member inputMember) {
			
			return dao.updateMyInfoNonPhoto(inputMember);
		}



		@Override
		public int updateInterest(Member inputMember) {
			int result=dao.updateInterest(inputMember); // 기존에 있던거 지우고
			
			String interestList=inputMember.getMemberInterest();
		
			if(interestList!=null) {
				String[] interest=interestList.split(",");
				
				Map<String, String> map=new HashMap<String, String>();
				
				map.put("memberNo", inputMember.getMemberNo()+"");
				
				for(int i=0;i<interest.length;i++) {
					map.put("memberInterest",interest[i]);
					
					result=dao.insertInterest(map); // 삽입
				}
				
			}
			return result;
		}



		@Override
		public int deleteMember(int memberNo, String memberPw) {

			// 1. 회원번호를 이용해서 DB에서 암호화된 비밀번호를 조회
			String encPw=dao.selectEncPw(memberNo);
			
			// 2. matches(입력PW, 암호화 PW) matches 결과가 true인 경우 
			if(bcrypt.matches(memberPw, encPw)) {
				
				// 회원 상태(MEMBER_DEL_FL)를 바꿈
				int result=dao.changeDelFl(memberNo);
				
				return result;
			}
			
			return 0;// 비밀번호 불일치시 0 반환 
		}
		
		
		
		// 비밀번호 변경 서비스 
		@Override
		public int changePw(Map<String, Object> paramMap) {
			// 비밀번호 일치 시 새 비밀번호로 변경 
			
			// 1. 회원번호를 이용해서 DB에서 암호화된 비밀번호를 조회
			String encPw=dao.selectEncPw((int)paramMap.get("memberNo"));
			
			// 2. matches(입력PW, 암호화 PW) matches 결과가 true인 경우 
			if(bcrypt.matches((String)paramMap.get("currentPw"), encPw)) {
				// 새 비밀번호 암호화 
				String newPw=bcrypt.encode((String)paramMap.get("newPw"));
				
				paramMap.put("newPw", newPw);
				//Param맴베 존재하는 기존 newPw를 덮어쓰기 
				
				
				// 새 비밀번호로 UPDATE하는 DAO코드 호출 
				int result=dao.changePw(paramMap);
				
				return result;
			}
			
			
			
			return 0;// 비밀번호 불일치시 0 반환 
		}


		// 보낸 서비스 문의 내역 
		@Override
		public Map<String, Object> selectSendServiceInquiry(Map<String, Object> option, int cp) {
			
			int listCount = dao.getServiceInquiryListCount(option);
			Pagination pagination = new Pagination(listCount, cp);
			List<AskService> serviceInquiryList = dao.selectServiceInquiryList(option, pagination);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("serviceInquiryList", serviceInquiryList);
			resultMap.put("pagination", pagination);
			
			return resultMap;
			
		}



		@Override
		public AskService selectSendSuggesionContent(String serviceInquiryNo) {
			return dao.selectSendSuggesionContent(serviceInquiryNo);
		}


		// 찜 목록
		@Override
		public Map<String, Object> selectLikeList(int memberNo, int cp, int category) {
			
			Map<String, Object> option = new HashMap<String, Object>();
			option.put("memberNo", memberNo);
			option.put("category", category);
			
//			int likeListCount = dao.getLikeListCount(memberNo);
			int likeListCount  = dao.getLikeListCount2(option);
			
			Pagination pagination = new Pagination(likeListCount, cp);
			
			List<com.manager.freelancer.category.model.vo.Service> likeList = dao.selectLikeList2(option,pagination);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("likeList", likeList);
			map.put("pagination", pagination);
			
			return map;
		}

		// 카테고리 선택 찜 목록
		@Override
		public Map<String, Object> selectLikeListType(int memberNo, int cp, int category) {
			
			Map<String, Object> option = new HashMap<String, Object>();
			option.put("memberNo", memberNo);
			option.put("category", category);
			
			int likeListCount = dao.getLikeListCount2(option);
			
			Pagination pagination = new Pagination(likeListCount, cp);
			
			List<com.manager.freelancer.category.model.vo.Service> likeList = dao.selectLikeList2(option, pagination);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("likeList", likeList);
			map.put("pagination", pagination);
			map.put("category", category);
			
			return map;
		}

	
	
}
