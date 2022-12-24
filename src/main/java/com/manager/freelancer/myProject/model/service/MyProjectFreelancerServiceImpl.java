package com.manager.freelancer.myProject.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.common.Util;
import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.dao.MyProjectFreelancerDAO;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.myProject.model.vo.myProjectServiceInquiry;



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
	 * 나의 서비스 들고오기
	 */
	@Override
	public List<FreelancerService> selectMyService(int memberNo,int mainCategoryNo) {
		return dao.selectMyService(memberNo, mainCategoryNo);
	}
}
