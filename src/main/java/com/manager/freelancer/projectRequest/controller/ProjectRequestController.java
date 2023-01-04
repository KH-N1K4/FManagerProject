package com.manager.freelancer.projectRequest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manager.freelancer.projectRequest.model.service.ProjectRequestSerivce;

@Controller
public class ProjectRequestController {
	
	@Autowired
	private ProjectRequestSerivce service;
	
	@GetMapping("/projectRequest/requestList/{mainCategotyNo}/{subCategoryNo}/{thirdCategotyNo}")
	public String mainProjectRequest(Model model,
			@RequestParam(value="cp" , required = false, defaultValue = "1") int cp,
			@RequestParam(value="mainCategotyNo" , required = false, defaultValue = "0") int mainCategotyNo,
			@RequestParam(value="subCategoryNo" , required = false, defaultValue = "0") int subCategoryNo,
			@RequestParam(value="thirdCategotyNo" , required = false, defaultValue = "0") int thirdCategotyNo) {
		
		Map<String, Object> map = service.getCategotyList(cp,mainCategotyNo,subCategoryNo,thirdCategotyNo);
		model.addAttribute("category", map);
		model.addAttribute("pagination",map.get("pagination"));
		model.addAttribute("listCount",map.get("listCount"));
		return "/projectRequest/projectRequestList";
	}
	
	@GetMapping("/projectRequest/requestList/1/1/1/1")
	public String projectRequest() {
		
		return "/projectRequest/projectRequestDetail";
	}

}
