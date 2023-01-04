package com.manager.freelancer.myProject.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.customerCenter.model.vo.Pagination;
import com.manager.freelancer.myProject.model.dao.MyProjectDAO_2;
import com.manager.freelancer.myProject.model.vo.MyProjectPayment;

@Service
public class MyProjectServiceImpl_2 implements MyProjectService_2{
	
	@Autowired
	private MyProjectDAO_2 dao;
	
	// 결제 내역
	@Override
	public Map<String, Object> selectPaymentList(Map<String, Object> option, int cp) {
		
		int listCount = dao.getPaymentListCount(option);
		Pagination pagination = new Pagination(listCount, cp);
		List<MyProjectPayment> paymentList = dao.selectPaymentList(option, pagination);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("paymentList", paymentList);
		resultMap.put("pagination", pagination);
		
		return resultMap;
	}

}
