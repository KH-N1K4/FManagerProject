package com.manager.freelancer.myProject.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.myProject.model.dao.MyProjectFreelancerDAO;


@Service
public class MyProjectFreelancerServiceImpl implements MyProjectFreelancerService{
	
	@Autowired
	private MyProjectFreelancerDAO dao;
}
