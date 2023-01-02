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

		String[] splitMajor = inputFreelancer.getMajor().split(",");
		Major temp1 = new Major();
		temp1.setMajorAcademyName(splitMajor[0]);
		temp1.setMajorName(splitMajor[1]);
		
//		if(splitMajor[2].equals("재학")) {
//			splitMajor[2] ;
//		}
//		temp1.setMajorGraduateStatus(Integer.parseInt(splitMajor[2]));
		
		temp1.setMajorGraduateStatus(inputFreelancer.getMajorStatus());
		temp1.setFreelancerNo(inputFreelancer.getFreelancerNo());
		
		String[] splitCareer = inputFreelancer.getCareer().split(",");
		Career temp2 = new Career();
			temp2.setCareerCompanyName(splitCareer[0]); // 회사명
			temp2.setCareerCompanyDepartment(splitCareer[1]); //회사부서
			temp2.setCareerCompanyPosition(splitCareer[2]); // 직급
			temp2.setCareerCompanyRegion(splitCareer[3]);  // 회사위치
			temp2.setCareerCompanyPeriod1(splitCareer[4]); //경력(년)
	//		temp2.setCareerCompanyPeriod2(splitCareer[5]); //경력(월)
			temp2.setFreelancerNo(inputFreelancer.getFreelancerNo()); 
			
		String[] splitLicense = inputFreelancer.getLicense().split(",");
		License temp3 = new License();
			temp3.setLicenseName(splitLicense[0]);
			temp3.setLicenseDate(splitLicense[1]);
			temp3.setLicenseAgency(splitLicense[2]);
			temp3.setFreelancerNo(inputFreelancer.getFreelancerNo());
		
		
		int result = dao.enrollFreelancerSignup(inputFreelancer);
		// result = freelancerNo
		
		String freelancerFieldList = inputFreelancer.getFreelancerField();
		if(freelancerFieldList !=null) {
			String[] freelancerField = freelancerFieldList.split(",");
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("freelancerNo", inputFreelancer.getFreelancerNo()+""); // "" > String형으로 바꿔주기위해
			
			for(int i =0; i<freelancerField.length; i++) {
				map.put("freelancerField",  freelancerField[i]);
				
				result = dao.insertFreelancerField(map);
			}
			
		}
		
		
		// 계좌정보 insert
		if(result > 0) {
			result = dao.insertFreelancerAccount(inputFreelancer);

		}
		
		
		// Member 프리랜서_FL N-> Y로 변경
		result = dao.updateFreelancerFlag(inputFreelancer);
		
	
		
		// 프리랜서 전공분야, 경력, 자격증 insert
		
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
