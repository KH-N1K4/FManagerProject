package com.manager.freelancer.category.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.category.model.dao.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	
	@Autowired
	private CategoryDAO dao;

	@Override
	public List<Map<String, Object>> selectBoardType() {
		return dao.selectBoardType();
	}

}
