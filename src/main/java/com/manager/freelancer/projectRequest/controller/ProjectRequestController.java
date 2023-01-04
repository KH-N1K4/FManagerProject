package com.manager.freelancer.projectRequest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.manager.freelancer.projectRequest.model.service.ProjectRequestSerivce;

@Controller
public class ProjectRequestController {
	
	@Autowired
	private ProjectRequestSerivce service;
	
	@GetMapping("/projectRequest/requestList")
	public String mainProjectRequest(Model model) {
		
		Map<String, Object> map = service.getCategotyList();
		model.addAttribute("category", map);
		return "/projectRequest/projectRequestList";
	}
	@GetMapping("/projectRequest/requestList/1/1/1/1")
	public String projectRequest() {
		
		
		
		return "/projectRequest/projectRequestDetail";
	}

}
