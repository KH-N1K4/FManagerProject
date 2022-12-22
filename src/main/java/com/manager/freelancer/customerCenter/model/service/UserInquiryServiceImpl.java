package com.manager.freelancer.customerCenter.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.customerCenter.model.dao.UserInquiryDAO;
import com.manager.freelancer.customerCenter.model.vo.UserInquiry;

@Service
public class UserInquiryServiceImpl implements UserInquiryService{
	
	@Autowired
	private UserInquiryDAO dao;

	// 이용문의 등록하기 
	@Override
	public int userInquiryInsert(UserInquiry inputInquiry) {
		return dao.userInquiryInsert(inputInquiry);
	}

}
