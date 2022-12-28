package com.manager.freelancer.customerCenter.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

	////////////////////////////////////////////////////////////
	/** 이용문의 내역 조회하기 
	 * @param memberNo
	 * @return userInquiry
	 */
	List<UserInquiry> selectInquiryList(int memberNo);

	/** 이용문의 내역 조회하기 (+ 특정 게시판 목록 조회 + 페이징 처리 계산)
	 * @param memberNo
	 * @param cp
	 * @return map
	 */
	Map<String, Object> selectInquiryList(int memberNo, int cp);

	/** 이용문의 내역 상세보기 
	 * @param userInquiryNo
	 * @return userInquiry
	 */
	////////////////////////////////////////////////////////////
	UserInquiry viewInquiryDetail(int userInquiryNo);

	/** 검색 목록 조회 
	 * @param pm
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectInquiryList(Map<String, Object> pm, int cp);



}
