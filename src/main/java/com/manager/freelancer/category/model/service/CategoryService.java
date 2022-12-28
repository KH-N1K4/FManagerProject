package com.manager.freelancer.category.model.service;

import java.util.List;
import java.util.Map;

import com.manager.freelancer.category.model.vo.Category;

public interface CategoryService {

	List<Map<String, Object>> selectMainCategoryList();

	List<Map<String, Object>> selectSubCategoryList();

	List<Map<String, Object>> selectThirdCategoryList();

	List<Category> selectBoardList(int mainCategoryNo);

}
