package com.manager.freelancer.customerCenter.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.customerCenter.model.vo.UserInquiry;

public interface UserInquiryService {

	/** 이용문의 등록하기
	 * @param inputInquiry
	 * @param folderPath 
	 * @param webPath 
	 * @param imageList 
	 * @param userInquiryImage 
	 * @return userInquiryNo
	 */
	int userInquiryInsert(UserInquiry userInquiry, List<MultipartFile> imageList, String webPath, String folderPath)throws IOException;

	
	/** 이용문의 내역 조회하기 
	 * @param memberNo
	 * @return userInquiry
	 */
	List<UserInquiry> selectInquiryList(int memberNo);

}
