package com.manager.freelancer.freelancer.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.freelancer.model.dao.FreeLancerDAO;
import com.manager.freelancer.freelancer.model.vo.FreeLancer;

@Service
public class FreeLancerServiceImpl implements FreeLancerService{
	
	@Autowired
	private FreeLancerDAO dao;

	@Override
	public int enrollFreelancer(FreeLancer inputFreeLancer) {

		int result = dao.enrollFreelancer(inputFreeLancer);
		
		return result;
	}
}
