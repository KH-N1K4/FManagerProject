package com.manager.freelancer.manager.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.customerCenter.model.vo.Pagination;
import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.manager.model.dao.ManagerInquiryDAO;

@Service
public class ManagerInquiryServiceImpl implements ManagerInquiryService{

	@Autowired
	private ManagerInquiryDAO dao;

	// 이용문의 내역 조회하기 
	@Override
	public Map<String, Object> selectManagerInquiryList(int cp) {
		
			// 1. 특정 게시판의 전체 게시글 수 조회 
			int listCount = dao.getListCount();
			
			// 2. 전체 게시글 수 + cp(현재 페이지) 이용해서 페이징 처리 객체 생성
			Pagination pagination = new Pagination(listCount, cp);
			
			// 3. 페이징 처리객체를 이용해서 게시글 목록 조회 
			List<UserInquiry> managerInquiryList = dao.selectManagerInquiryList(pagination);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pagination", pagination);
			map.put("managerInquiryList", managerInquiryList);
			
			return map;
	}

	// 검색 결과에 일치하는 이용문의 내역 조회하기 
	@Override
	public Map<String, Object> selectManagerInquiryList(Map<String, Object> pm, int cp) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
