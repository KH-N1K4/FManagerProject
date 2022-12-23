package com.manager.freelancer.myProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.manager.freelancer.myProject.model.service.MyProjectFreelancerService;


@Controller
public class MyProjectFreelancerController {
	
	@Autowired
	private MyProjectFreelancerService service;
	
	// 내 프로젝트 전문가페이지 나의 서비스 이동
	@GetMapping("/member/myProject/freelancer/myService")
	public String myService() {
		return "myProject/myProject_freelancer/myServiceFreelancer";
	}
	
	@GetMapping("/member/myProject/freelancer/myServiceInsert")
	public String myServiceInsert() {
		return "myProject/myProject_freelancer/myServiceInsert";
	}

}
