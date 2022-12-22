package com.manager.freelancer.customerCenter.model.service;

import java.util.List;

import com.manager.freelancer.customerCenter.model.vo.UserInquiry;

public interface UserInquiryService {

	/** 이용문의 등록하기
	 * @param inputInquiry
	 * @return result
	 */
	int userInquiryInsert(UserInquiry inputInquiry);

	/** 이용문의 내역 조회하기 
	 * @param memberNo
	 * @return userInquiry
	 */
	List<UserInquiry> selectInquiryList(int memberNo);

}
