package com.manager.freelancer.customerCenter.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.common.Util;
import com.manager.freelancer.customerCenter.model.dao.UserInquiryDAO;
import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.customerCenter.model.vo.UserInquiryImage;

@Service
public class UserInquiryServiceImpl implements UserInquiryService {
	
	@Autowired
	private UserInquiryDAO dao;

	
	
	// 이용문의 등록하기
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int userInquiryInsert(UserInquiry userInquiry, List<MultipartFile> imageList, String webPath,
			String folderPath) throws IOException{
		
		
		// 1. 게시글만 삽입
		// 1) XSS(크로스 사이트 스크립트 공격), 개행문자 처리 
		userInquiry.setUserInquiryTitle(Util.XSSHandling(userInquiry.getUserInquiryTitle()));
		userInquiry.setUserInquiryContent(Util.XSSHandling(userInquiry.getUserInquiryContent()));
		userInquiry.setUserInquiryContent(Util.newLineHandling(userInquiry.getUserInquiryContent()));
		
		// 2) 게시글 삽입 DAO 호출 후 결과로 삽입된 게시글 번호 반환 받기
		int userInquiryNo = dao.Inquiryinsert(userInquiry);
		
		
		// 2. 이미지 삽입 
		if (userInquiryNo > 0) {

			// imageList : 실제 파일이 담겨있는 리스트
			// inquiryImageList : DB에 삽입할 이미지 정보만 담기
			List<UserInquiryImage> inquiryImageList = new ArrayList<UserInquiryImage>();
			List<String> reNameList = new ArrayList<String>();

			// imageList에 담겨있는 파일 중

			// imageList에 담겨있는 파일 중 실제로 업로드된 파일만 분류하는 작업 진행

			for (int i = 0; i < imageList.size(); i++) {

				// i번째 파일의 크기가 0보다 크다 == 업로드된 파일이 있다.
				if (imageList.get(i).getSize() > 0) {

					// UserInquiryImage 객체 생성
					UserInquiryImage img = new UserInquiryImage();

					// UserInquiryImage 값 세팅
					img.setInquiryFilePath(webPath);

					String reNameImg = Util.fileRename(imageList.get(i).getOriginalFilename());
					img.setInquiryFilePath(reNameImg);
					img.setUserInquiryNo(userInquiryNo); // 첨부된 게시글 번호
					img.setInquiryFileOrder(i); // 이미지 순서

					// BoardImageList에 추가
					inquiryImageList.add(img);
					reNameList.add(reNameImg);

				} // if 끝
			} // for 끝
			
			// boardImageList가 비어있지 않다면
			// == 업로드된 파일이 있어서 분류된 내용이 존재
			if (!inquiryImageList.isEmpty()) {

				// DB에 업로드된 파일 정보 INSERT
				int result = dao.insertInquiryImageList(inquiryImageList);

				// 삽입 결과 행의 수 == DB에 삽입하려고 분류한 리스트의 크기
				// 전부 다 삽입된 경우
				if (result == inquiryImageList.size()) {

					// 파일 변환 작업
					for (int i = 0; i < inquiryImageList.size(); i++) {

						// 순서 == imageList의 인덱스
						int index = inquiryImageList.get(i).getInquiryFileOrder();

						// 실제 파일로 변환
						imageList.get(index).transferTo(new File(folderPath + reNameList.get(i)));
					}
				}
			}
			
		}

		return userInquiryNo;
	}
	
	
	// 이용문의 내역 조회하기 
	@Override
	public List<UserInquiry> selectInquiryList(int memberNo) {
		return dao.selectInquiryList(memberNo);
	}


	

	

}
