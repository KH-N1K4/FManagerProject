package com.manager.freelancer.freelancer.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.freelancer.model.dao.FreeLancerDAO;
import com.manager.freelancer.freelancer.model.vo.Freelancer;

@Service
public class FreeLancerServiceImpl implements FreeLancerService{
	
	@Autowired
	private FreeLancerDAO dao;

	@Override
	public int enrollFreelancerSignup(Freelancer inputFreelancer) {

		int result = dao.enrollFreelancerSignup(inputFreelancer);
		
//		if(result > 0) {
//			result = dao.insertGrade(inputFreelancer);
//		}
		return result;
	}
}
