package com.manager.freelancer.freelancer.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.freelancer.freelancer.model.dao.FreeLancerDAO;
import com.manager.freelancer.freelancer.model.vo.Career;
import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.freelancer.model.vo.License;
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
		
		String[] splitCareer = inputFreelancer.getCareer().split(",");
		Career temp2 = new Career();
		temp2.setCareerCompanyName(splitCareer[0]);
		temp2.setCareerCompanyDepartment(splitCareer[1]);
		temp2.setCareerCompanyPosition(splitCareer[2]);
		temp2.setCareerCompanyRegion(splitCareer[3]);
		temp2.setCareerCompanyPeriod1(splitCareer[4]);
		temp2.setCareerCompanyPeriod2(splitCareer[5]);
		temp2.setFreelancerNo(inputFreelancer.getFreelancerNo());
		
		String[] splitLicense = inputFreelancer.getLicense().split(",");
		License temp3 = new License();
		temp3.setLicenseName(splitLicense[0]);
		temp3.setLicenseDate(splitLicense[1]);
		temp3.setLicenseAgency(splitLicense[2]);
		temp3.setFreelancerNo(inputFreelancer.getFreelancerNo());
		
		
		int result = dao.enrollFreelancerSignup(inputFreelancer);
		// result = frelancerNo
		
		// Member 프리랜서_FL N-> Y로 변경
		result = dao.updateFreelancerFlag(inputFreelancer);
		
		if(result > 0) {
			result = dao.enrollFreelancerMajor(temp1);
		}
		if(result> 0) {
			result = dao.enrollFreelancerCareer(temp2);
		}
		if(result>0) {
			result = dao.enrollfreelancerLicense(temp3);
		}

		return result;
	}
}
