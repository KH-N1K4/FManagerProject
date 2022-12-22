package com.manager.freelancer.customerCenter.model.service;

import java.util.List;

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

	// 이용문의 내역 조회하기 
	@Override
	public List<UserInquiry> selectInquiryList(int memberNo) {
		return dao.selectInquiryList(memberNo);
	}

}
