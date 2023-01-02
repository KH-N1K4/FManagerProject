package com.manager.freelancer.freelancer.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.freelancer.model.vo.Field;
import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.freelancer.model.vo.Portfolio;
import com.manager.freelancer.freelancer.model.vo.Region;

public interface FreeLancerService {

	// 전문가 등록
	int enrollFreelancerSignup(Freelancer inputFreelancer);


//	// 전문가 정보 조회
	Freelancer freelancerInfo(int freelancerNo);
	
	// 지역목록
	List<Region> getRegionList();
	
	//포트폴리오 목록 호출
	List<Portfolio> getPortfolioList(Freelancer inputFreelancer);

	// 프리랜서- 전문분야가져오기
	List<Field> getFieldList(Freelancer inputFreelancer);


	//전문자 정보 수정
	int updateFreelancerInfo(Freelancer inputFreelancer);

	// 포트폴리오 등록
	int addPortfolio(Portfolio inputPortfolio, List<MultipartFile> imageList, String webPath, String folderPath);

	
	

	



}
