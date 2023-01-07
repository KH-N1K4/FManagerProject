package com.manager.freelancer.common.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.manager.freelancer.common.search.service.SearchService;
import com.manager.freelancer.myProject.model.vo.FreelancerService;

@Controller
public class SearchController {
	@Autowired
	private SearchService service;
	
	@GetMapping("/common/searchInput")
	@ResponseBody
	public String searchInput(
			@RequestParam(value="keyword",required=false, defaultValue="")String keyword) {
		List<FreelancerService> searchInput = service.searchInput(keyword);

		return new Gson().toJson(searchInput);
	}
}
