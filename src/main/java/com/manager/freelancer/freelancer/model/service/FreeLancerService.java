package com.manager.freelancer.freelancer.model.service;

import java.util.List;

import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.freelancer.model.vo.Region;

public interface FreeLancerService {

	// 전문가 등록
	int enrollFreelancerSignup(Freelancer inputFreelancer);


//	// 전문가 정보 조회
	Freelancer freelancerInfo(int freelancerNo);
	
	List<Region> getRegionList();


}
