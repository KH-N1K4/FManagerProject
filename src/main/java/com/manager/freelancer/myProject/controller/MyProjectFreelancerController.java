package com.manager.freelancer.myProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyProjectFreelancerController {
	
	// 내 프로젝트 전문가페이지 나의 서비스 이동
	@GetMapping("/member/myProject/freelancer/myService")
	public String likeList() {
		return "myProject/myProject_freelancer/myServiceFreelancer";
	}

}
