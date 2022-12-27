package com.manager.freelancer.freelancer.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.freelancer.freelancer.model.dao.FreeLancerDAO;
import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.freelancer.model.vo.Major;

@Service
public class FreeLancerServiceImpl implements FreeLancerService{
	
	@Autowired
	private FreeLancerDAO dao;

	@Transactional
	@Override
	public int enrollFreelancerSignup(Freelancer inputFreelancer) {

		String[] splitMajor = inputFreelancer.getMajor().split(",");
		
		Major temp1 = new Major();
		temp1.setMajorAcademyName(splitMajor[0]);
		temp1.setMajorName(splitMajor[1]);
		temp1.setMajorGraduateStatus(Integer.parseInt(splitMajor[2]));
		temp1.setFreelancerNo(inputFreelancer.getFreelancerNo());
		
		
		int result = dao.enrollFreelancerSignup(inputFreelancer);
		// result = frelancerNo
		
		result = dao.updateFreelancerFlag(inputFreelancer);
		
		if(result > 0) {
			result = dao.enrollFreelancerMajor(temp1);
		}


		return result;
	}
}
