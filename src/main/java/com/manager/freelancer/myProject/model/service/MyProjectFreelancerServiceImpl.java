package com.manager.freelancer.myProject.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.myProject.model.dao.MyProjectFreelancerDAO;
import com.manager.freelancer.myProject.model.vo.FreelancerService;


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
}
