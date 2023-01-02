package com.manager.freelancer.category.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.manager.freelancer.category.model.dao.CategoryDAO;
import com.manager.freelancer.category.model.vo.AskService;
import com.manager.freelancer.category.model.vo.Service;

@org.springframework.stereotype.Service
public class CategoryServiceImpl implements CategoryService{
	
	
	@Autowired
	private CategoryDAO dao;

	@Override
	public List<Map<String, Object>> selectMainCategoryList() {
		return dao.selectMainCategoryList();
	}

	@Override
	public List<Map<String, Object>> selectSubCategoryList() {
		return dao.selectSubCategoryList();
	}

	@Override
	public List<Map<String, Object>> selectThirdCategoryList() {
		return dao.selectThirdCategoryList();
	}

	@Override
	public List<Service> selectBoardList(Map<String, Integer> map) {
		return dao.selectBoardList(map);
	}

	@Override
	public Service viewService(int serviceNo) {
		return dao.viewService(serviceNo);
	}

	@Override
	public int askService(AskService as) {
		return dao.askService(as);
	}

	@Override
	public int pauseService(int serviceNo) {
		return dao.pauseService(serviceNo);
	}


	public int serviceLikeCheck(Map<String, Object> map) {
		return dao.serviceLikeCheck(map);
	}

	@Override
	public int boardLikeUp(Map<String, Object> paramMap) {
		return dao.boardLikeUp(paramMap);
	}

	@Override
	public int boardLikeDown(Map<String, Object> paramMap) {
		return dao.boardLikeDown(paramMap);
	}

	

}
