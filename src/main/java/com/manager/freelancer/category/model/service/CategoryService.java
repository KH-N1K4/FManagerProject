package com.manager.freelancer.category.model.service;

import java.util.List;
import java.util.Map;

import com.manager.freelancer.category.model.vo.AskService;
import com.manager.freelancer.category.model.vo.Category;
import com.manager.freelancer.category.model.vo.ImageFile;
import com.manager.freelancer.category.model.vo.Service;
import com.manager.freelancer.myProject.model.vo.FreelancerService;

public interface CategoryService {

	List<Map<String, Object>> selectMainCategoryList();

	List<Map<String, Object>> selectSubCategoryList();

	List<Map<String, Object>> selectThirdCategoryList();

	List<Service> selectBoardList(Map<String, Integer> map);

	Service viewService(int serviceNo);

	int askService(AskService as);

	int pauseService(int serviceNo);

	// 서비스 찜 
	int serviceLikeCheck(Map<String, Object> map);

	int boardLikeUp(Map<String, Object> paramMap);

	int boardLikeDown(Map<String, Object> paramMap);
	

}
