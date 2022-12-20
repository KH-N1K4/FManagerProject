package com.manager.freelancer.category.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
	
	
	
	// /category/{mainCategoryNo}
	@GetMapping("/category/1")
	public String mainCategory() {
		return "/category/categoryList";
	}
	
	
	
	// /category/{mainCategoryNo}/{subCategoryNo}/{thirdCategoryNo}/{serviceNo}

	@GetMapping("/category/1/1")
	public String subCategory() {	
		return "/category/categoryDetail";
	}
	
	// /category/{mainCategoryNo}/{subCategoryNo}/{thirdCategoryNo}/{serviceNo}/freelancer

	@GetMapping("/category/viewFreelancerDetail")
	public String viewFreelancerDetail() {	
		return "/member/freelancer/freelancerDetail";
	}

}
