package com.manager.freelancer.freelancer.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.common.Util;
import com.manager.freelancer.freelancer.model.dao.FreeLancerDAO;
import com.manager.freelancer.freelancer.model.vo.Bank;
import com.manager.freelancer.freelancer.model.vo.Career;
import com.manager.freelancer.freelancer.model.vo.Field;
import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.freelancer.model.vo.License;
import com.manager.freelancer.freelancer.model.vo.Major;
import com.manager.freelancer.freelancer.model.vo.Portfolio;
import com.manager.freelancer.freelancer.model.vo.PortfolioImage;
import com.manager.freelancer.freelancer.model.vo.Region;

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
		
	
		

	
		

		return result;
	}
	
	@Override
	public Freelancer freelancerInfo(int freelancerNo) {

		return dao.freelancerInfo(freelancerNo);
	}
	
	@Override
	public List<Region> getRegionList() {
		return dao.getRegionList();
	}
	
	@Override
	public List<Portfolio> getPortfolioList(Freelancer inputFreelancer) {
		// TODO Auto-generated method stub
		return dao.getPortfolioList(inputFreelancer);
	}
	@Override
	public List<Field> getFieldList(Freelancer inputFreelancer) {
		// TODO Auto-generated method stub
		return dao.getFieldList(inputFreelancer);
	}
	
	@Override
	public List<Bank> getBankList() {
		// TODO Auto-generated method stub
		return dao.getBankList();
	}
	 
	
	@Override
	public int updateFreelancerInfo(Freelancer inputFreelancer) {

		int result = dao.updateFreelancerInfo(inputFreelancer);
		
		
		if(inputFreelancer.getCareer()!=null) { // 수정하기의 경력사항 input값에 값이 담겨있다면
			String[] splitCareer = inputFreelancer.getCareer().split("/");
			Career temp1Career = new Career();
			temp1Career.setCareerCompanyName(splitCareer[0]);
			temp1Career.setCareerCompanyDepartment(splitCareer[1]);
			temp1Career.setCareerCompanyPosition(splitCareer[2]);
			temp1Career.setCareerCompanyRegion(splitCareer[3]);
			temp1Career.setCareerCompanyPeriod(splitCareer[4]);
			temp1Career.setFreelancerNo(inputFreelancer.getFreelancerNo());
			
			result = dao.updateFreelancerCareer(temp1Career);
		}
		if(inputFreelancer.getLicense()!=null) {
			String[] splitLicense = inputFreelancer.getLicense().split("/");
			License temp2License = new License();
			temp2License.setLicenseName(splitLicense[0]);
			temp2License.setLicenseDate(splitLicense[1]);
			temp2License.setLicenseAgency(splitLicense[2]);
			temp2License.setFreelancerNo(inputFreelancer.getFreelancerNo());
			
			result = dao.updatefreelancerLicense(temp2License);
		}
//			int inputBankCode = inputFreelancer.getBankCode();
//			long inputBankAccount = inputFreelancer.getBankAccountNumber();
//		if(inputBankCode != 0 && inputBankAccount != 0) {
//			//조건문 수정 필요
//			
//					
//		}
		if(result > 0 ) {
		result = dao.updateFreelancerBank(inputFreelancer);
		}
		
		return result;
	}
	
	// 포트폴리오 등록
	@Override
	public int addPortfolio(Portfolio inputPortfolio, List<MultipartFile> imageList, String webPath, String folderPath) {

		int portfolioNo = dao.addPortfolio(inputPortfolio);
		
		
		return portfolioNo;
	}
	

	
}
