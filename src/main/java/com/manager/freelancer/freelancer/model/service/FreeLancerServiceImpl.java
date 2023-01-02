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

		
		int result = dao.enrollFreelancerSignup(inputFreelancer);
		
		System.out.println(inputFreelancer);
		
		
		if(inputFreelancer.getMajor()!=null) {
			
			String[] splitMajor = inputFreelancer.getMajor().split(",");
			
			int tempNum=0;
			for(int i=0;i<splitMajor.length;i++) {
				String[] singleMajor=splitMajor[i].split("/");
				
				Major temp1 = new Major();
				temp1.setMajorAcademyName(singleMajor[0]);
				temp1.setMajorName(singleMajor[1]);
				
				
				if(singleMajor[2].equals("재학")) {
					tempNum=1;
				}else if(singleMajor[2].equals("휴학")) {
					tempNum=2;
				}else if(singleMajor[2].equals("이수")) {
					tempNum=3;
				}else if(singleMajor[2].equals("졸업")) {
					tempNum=4;
				}
				
				temp1.setMajorGraduateStatus(tempNum);
				temp1.setFreelancerNo(inputFreelancer.getFreelancerNo());
				
				result = dao.enrollFreelancerMajor(temp1);
			}
			
		}
		
		
		
		
		if(inputFreelancer.getCareer()!=null) {
			String[] splitCareer = inputFreelancer.getCareer().split(",");
			
			for(int i=0;i<splitCareer.length;i++) {
				
				String[] singleCareer=splitCareer[i].split("/");
				
				Career temp2 = new Career();
				temp2.setCareerCompanyName(singleCareer[0]); // 회사명
				temp2.setCareerCompanyDepartment(singleCareer[1]); //회사부서
				temp2.setCareerCompanyPosition(singleCareer[2]); // 직급
				temp2.setCareerCompanyRegion(singleCareer[3]);  // 회사위치
				temp2.setCareerCompanyPeriod1(singleCareer[4]); //경력(년)
		//		temp2.setCareerCompanyPeriod2(splitCareer[5]); //경력(월)
				temp2.setFreelancerNo(inputFreelancer.getFreelancerNo()); 
				
				result=dao.enrollFreelancerCareer(temp2);
			}
			
			
		}
	
		
		
		if(inputFreelancer.getLicense()!=null) {
			
			String[] splitLicense = inputFreelancer.getLicense().split(",");
			
			for(int i=0;i<splitLicense.length;i++) {
				
				String[] singleCareer=splitLicense[i].split("/");
				License temp3 = new License();
				temp3.setLicenseName(singleCareer[0]);
				temp3.setLicenseDate(singleCareer[1]);
				temp3.setLicenseAgency(singleCareer[2]);
				temp3.setFreelancerNo(inputFreelancer.getFreelancerNo());
				
				result=dao.enrollfreelancerLicense(temp3);
			}
		}
		
		
		
		// result = frelancerNo
		
		// Member 프리랜서_FL N-> Y로 변경
		result = dao.updateFreelancerFlag(inputFreelancer);
		
		// 프리랜서 계좌등록(insert)
		result = dao.insertFreelancerAccount(inputFreelancer);
		
		
	
		

		return result;
	}
}
