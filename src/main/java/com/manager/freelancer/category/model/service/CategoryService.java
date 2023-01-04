package com.manager.freelancer.category.model.service;

import java.util.List;
import java.util.Map;

import com.manager.freelancer.category.model.vo.AskService;
import com.manager.freelancer.category.model.vo.Category;
import com.manager.freelancer.category.model.vo.ImageFile;
import com.manager.freelancer.category.model.vo.Service;
import com.manager.freelancer.category.model.vo.Trade;
import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.myProject.model.vo.FreelancerService;

public interface CategoryService {

	List<Map<String, Object>> selectMainCategoryList();

	List<Map<String, Object>> selectSubCategoryList();

	List<Map<String, Object>> selectThirdCategoryList();

	

	Service viewService(int serviceNo);

	int askService(AskService as);

	int pauseService(int serviceNo);

	// 서비스 찜 
	int serviceLikeCheck(Map<String, Object> map);

	int boardLikeUp(Map<String, Object> paramMap);

	int boardLikeDown(Map<String, Object> paramMap);

	
	// ajax
	Map<String, Object> selectCategoryList(Map map);

	// 카테고리 조회
	Map selectBoardList(Map<String, Integer> map);
	
	// 메인 전체 조회
	Map serviceList(Map<String, Integer> map);

	// 거래 완료 ajax
	int tradeComplete(Trade temp);

	Freelancer freelancerDetail(int freelancerNo);
	

}
