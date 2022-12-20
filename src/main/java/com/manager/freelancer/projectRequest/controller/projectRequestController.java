package com.manager.freelancer.projectRequest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class projectRequestController {
	
	@GetMapping("/projectRequest/requestList")
	public String mainProjectRequest() {
	
		return "/projectRequest/projectRequestList";
	}
	@GetMapping("/projectRequest/requestList/1/1/1/1")
	public String projectRequest() {
		
		
		
		return "/projectRequest/projectRequestDetail";
	}

}
