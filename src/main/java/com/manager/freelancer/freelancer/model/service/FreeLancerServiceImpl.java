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
import com.manager.freelancer.freelancer.model.vo.Career;
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
	public int updateFreelancerInfo(Freelancer inputFreelancer) {

		int result = dao.updateFreelancerInfo(inputFreelancer);
		
		if(result > 0) {
			result = dao.updateFreelancerCareer(inputFreelancer);
		}
		
		return result;
	}
	
	// 포트폴리오 등록
	@Override
	public int addPortfolio(Portfolio inputPortfolio, List<MultipartFile> imageList, String webPath, String folderPath) {

		int portfolioNo = dao.addPortfolio(inputPortfolio);
		
		// 이미지 삽입
		//  포트폴리오 번호
		if(portfolioNo > 0) {
			List<PortfolioImage> portfolioImageList = new ArrayList<PortfolioImage>();
			List<String> reNameList = new ArrayList<String>();
			
			// imageList : 파일이 담겨있는 리스트
			// portfolioImageList : DB에 삽입할 이미지 정보만 담기
			
			// imageList에 담겨잇는 파일 중 실제로 업로드될 파일만 분류하는 작업 진행
			for(int i = 0 ; i < imageList.size(); i++) {
				if(imageList.get(i).getSize() > 0) {
					PortfolioImage portfolioImage = new PortfolioImage();
					
					portfolioImage.setPotfolioImagePath(webPath);
					
					String reNameImage = Util.fileRename(imageList.get(i).getOriginalFilename());
					portfolioImage.setPotfolioImagePath(reNameImage);
					portfolioImage.setFreelancerNo(portfolioNo);
					portfolioImage.setPortfolioImageOrder(i);
					
					
					portfolioImageList.add(portfolioImage);
					reNameList.add(reNameImage);
				}
			}//for문
			//비어있지 않다면
			if(!imageList.isEmpty()) {
				
				int result = dao.insertPortfolioImageList(imageList);
				
				if(result == imageList.size()) {
					
				}
			}
		}
		
		return portfolioNo;
	}
	

	
}
