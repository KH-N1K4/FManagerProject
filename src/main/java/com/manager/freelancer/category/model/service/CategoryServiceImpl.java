package com.manager.freelancer.category.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.category.model.dao.CategoryDAO;
import com.manager.freelancer.category.model.vo.Category;

@Service
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
	public List<Category> selectBoardList(int mainCategoryNo) {
		List<Category> boardList=dao.selectBoardList(mainCategoryNo);
		return boardList;
	}

}
