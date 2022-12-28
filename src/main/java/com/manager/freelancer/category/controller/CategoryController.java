package com.manager.freelancer.category.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.manager.freelancer.category.model.service.CategoryService;
import com.manager.freelancer.category.model.vo.Category;
import com.manager.freelancer.myProject.model.vo.FreelancerService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	// /category/{mainCategoryNo}
	@GetMapping("/category/{mainCategoryNo}")
	public String mainCategory(@PathVariable("mainCategoryNo") int mainCategoryNo, Model model) {
		
		List<Category> map=service.selectBoardList(mainCategoryNo);
		
		model.addAttribute("map",map);
			
		return "/category/categoryList";
	}
	


	@GetMapping("/category/{mainCategoryCode}/{subCategoryCode}")
	public String subCategory() {	
		return "/category/categoryDetail";
	}
	
	@GetMapping("/category/{mainCategoryCode}/{subCategoryCode}/{lastCategoryCode}/{serviceNo}")
	public String viewService(@PathVariable("serviceNo") int serviceNo) {	
		
		// 게시글 상세조회 서비스 호출 
//		FreelancerService fService=service.selectFService(serviceNo);
		
		
		return "/category/categoryDetail";
	}


}
