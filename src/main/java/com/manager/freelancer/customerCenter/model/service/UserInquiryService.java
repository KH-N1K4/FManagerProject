package com.manager.freelancer.customerCenter.model.service;

import com.manager.freelancer.customerCenter.model.vo.UserInquiry;

public interface UserInquiryService {

	/** 이용문의 등록하기
	 * @param inputInquiry
	 * @return result
	 */
	int userInquiryInsert(UserInquiry inputInquiry);

}
