package com.manager.freelancer.freelancer.model.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.category.model.vo.Freelancer1;
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
import com.manager.freelancer.myProject.model.vo.myProjectServiceInquiry;

@Service
public class FreeLancerServiceImpl implements FreeLancerService{
	
	@Autowired
	private FreeLancerDAO dao;

	
	@Transactional
	@Override
	public int enrollFreelancerSignup(Freelancer inputFreelancer) {

		inputFreelancer.setFreelancerIntro(Util.XSSHandling(inputFreelancer.getFreelancerIntro()));
		inputFreelancer.setFreelancerIntro(Util.newLineHandling(inputFreelancer.getFreelancerIntro()));

		int result = dao.enrollFreelancerSignup(inputFreelancer);

		if(inputFreelancer.getMajor()!=null) {
			
			String[] splitMajor = inputFreelancer.getMajor().split(",");
			
			int tempNum=0;
			for(int i=0;i<splitMajor.length;i++) {
				String[] singleMajor=splitMajor[i].split("/");
				
				Major temp1 = new Major();
				temp1.setMajorAcademyName(singleMajor[0]);
				temp1.setMajorName(singleMajor[1]);
				
				
				if(singleMajor[2].equals("??????")) {
					tempNum=1;
				}else if(singleMajor[2].equals("??????")) {
					tempNum=2;
				}else if(singleMajor[2].equals("??????")) {
					tempNum=3;
				}else if(singleMajor[2].equals("??????")) {
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
				temp2.setCareerCompanyName(singleCareer[0]); // ?????????
				temp2.setCareerCompanyDepartment(singleCareer[1]); //????????????
				temp2.setCareerCompanyPosition(singleCareer[2]); // ??????
				temp2.setCareerCompanyRegion(singleCareer[3]);  // ????????????
				temp2.setCareerCompanyPeriod1(singleCareer[4]); //??????(???)
		//		temp2.setCareerCompanyPeriod2(splitCareer[5]); //??????(???)
				temp2.setFreelancerNo(inputFreelancer.getFreelancerNo()); 
				
				result=dao.enrollFreelancerCareer(temp2);
			}
			
			
		}
	
		
		
		if(inputFreelancer.getLicense()!=null) {
			
			String[] splitLicense = inputFreelancer.getLicense().split(",");
			
			for(int i=0;i<splitLicense.length;i++) {
				
				String[] singleCareer=splitLicense[i].split("/");
				License temp3 = new License();
				
//				SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
//				System.out.println(singleCareer[1]);
				temp3.setLicenseName(singleCareer[0]);
				temp3.setLicenseDate(singleCareer[1]);
				temp3.setLicenseAgency(singleCareer[2]);
				temp3.setFreelancerNo(inputFreelancer.getFreelancerNo());
				
				result=dao.enrollfreelancerLicense(temp3);
			}
		}
		
		
		
		// result = frelancerNo
		String freelancerFieldList = inputFreelancer.getFreelancerField();
		if(freelancerFieldList !=null) {
			String[] freelancerField = freelancerFieldList.split(",");

			Map<String, String> map = new HashMap<String, String>();
			map.put("freelancerNo", inputFreelancer.getFreelancerNo()+""); // "" > String????????? ??????????????????

			for(int i =0; i<freelancerField.length; i++) {
				map.put("freelancerField",  freelancerField[i]);

				result = dao.insertFreelancerField(map);
			}

		}
		
		// Member ????????????_FL N-> Y??? ??????
		result = dao.updateFreelancerFlag(inputFreelancer);
		
		// ???????????? ????????????(insert)
		result = dao.insertFreelancerAccount(inputFreelancer);
		

	
		

		return result;
	}
	
	@Override
	public Freelancer freelancerInfo(int freelancerNo) {

		return dao.freelancerInfo(freelancerNo);
	}
	@Override
	public Freelancer1 freelancerInfo1(int freelancerNo) {

		
		return dao.freelancerInfo1(freelancerNo);
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
		inputFreelancer.setFreelancerIntro(Util.XSSHandling(inputFreelancer.getFreelancerIntro()));
		inputFreelancer.setFreelancerIntro(Util.newLineHandling(inputFreelancer.getFreelancerIntro()));


		int result = dao.updateFreelancerInfo(inputFreelancer);
		
		if(result>0) {
			result = dao.deleteMajor(inputFreelancer.getFreelancerNo());
			result = dao.deleteLicense(inputFreelancer.getFreelancerNo());
			result = dao.deleteCareer(inputFreelancer.getFreelancerNo());
			result = dao.deleteField(inputFreelancer.getFreelancerNo());
		}
		
		if(inputFreelancer.getMajor()!=null) {
			
			String[] splitMajor = inputFreelancer.getMajor().split(",");
			
			int tempNum=0;
			for(int i=0;i<splitMajor.length;i++) {
				String[] singleMajor=splitMajor[i].split("/");
				
				Major temp1 = new Major();
				temp1.setMajorAcademyName(singleMajor[0]);
				temp1.setMajorName(singleMajor[1]);
				
				
				if(singleMajor[2].equals("??????")) {
					tempNum=1;
				}else if(singleMajor[2].equals("??????")) {
					tempNum=2;
				}else if(singleMajor[2].equals("??????")) {
					tempNum=3;
				}else if(singleMajor[2].equals("??????")) {
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
				temp2.setCareerCompanyName(singleCareer[0]); // ?????????
				temp2.setCareerCompanyDepartment(singleCareer[1]); //????????????
				temp2.setCareerCompanyPosition(singleCareer[2]); // ??????
				temp2.setCareerCompanyRegion(singleCareer[3]);  // ????????????
				temp2.setCareerCompanyPeriod1(singleCareer[4]); //??????(???)
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
		String freelancerFieldList = inputFreelancer.getFreelancerField();
		if(freelancerFieldList !=null) {
			String[] freelancerField = freelancerFieldList.split(",");

			Map<String, String> map = new HashMap<String, String>();
			map.put("freelancerNo", inputFreelancer.getFreelancerNo()+""); // "" > String????????? ??????????????????

			for(int i =0; i<freelancerField.length; i++) {
				map.put("freelancerField",  freelancerField[i]);

				result = dao.insertFreelancerField(map);
			}

		}
		
		
		result = dao.updateFreelancerBank(inputFreelancer);
		

		
		
		return result;
	}
	
	// ??????????????? ??????
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int addPortfolio(Portfolio inputPortfolio, String webPath, String folderPath, List<MultipartFile> portfolioFilePath) throws Exception {
		
		inputPortfolio.setPortfolioContent(Util.newLineClear(inputPortfolio.getPortfolioContent())); 
		
		
		List<String> reNameList = new ArrayList<String>();
		for(int i=0 ; i<portfolioFilePath.size() ; i ++) {
			if(portfolioFilePath.get(i).getSize() > 0) {
				if(i ==0) {
					inputPortfolio.setPortfolioThumbnail(webPath);
					String reName = Util.fileRename(portfolioFilePath.get(i).getOriginalFilename());
					inputPortfolio.setPortfolioThumbnail(webPath+reName);
					reNameList.add(reName); // ??????????????? ???????????? ??????
				}else {
					inputPortfolio.setPortfolioFilePath(webPath);
					String reName = Util.fileRename(portfolioFilePath.get(i).getOriginalFilename());
					inputPortfolio.setPortfolioFilePath(webPath+reName);
					reNameList.add(reName); // ??????????????? ???????????? ??????
				}
			}
		}
		
		int result = dao.addPortfolio(inputPortfolio);
		if(result>0) {
			// ?????? ?????? ??????
			for(int i=0 ; i<portfolioFilePath.size() ; i++) {
					
				// ?????? ????????? ??????
				portfolioFilePath.get(i).transferTo(new File(folderPath + reNameList.get(i)));    
			}
		}
		return result;
	}
	
	//??????????????? ????????????
	@Override
	public Portfolio viewPortfolioDetail(Portfolio portfolio) {
		
		return dao.viewPortfolioDetail(portfolio);
	}

	@Override
	public int DeletePortfolio(Freelancer1 freelancer1, int freelancerNo, int portfolioNo) {
		// TODO Auto-generated method stub
		return dao.DeletePortfolio(freelancer1,freelancerNo, portfolioNo);
	}
	
	
}
