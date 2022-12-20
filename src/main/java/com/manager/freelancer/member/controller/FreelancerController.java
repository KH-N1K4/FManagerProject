package com.manager.freelancer.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FreelancerController {

	

	// 전문가 정보 이동
	@GetMapping("/member/freelancer/freelancerInfo")
	public String freelancerInfo() {
		return "member/freelancer/freelancerInfo";
	}
	
	// 전문가 정보 수정 페이지 이동
	@GetMapping("/member/freelancer/updateFreelancerInfo")
	public String updateFreelancerInfo() {
		return "member/freelancer/updateFreelancerInfo";
	}
	
	// 전문가 정보 수정
//	@PostMapping("/member/freelancer/updateFreelancerInfo")
//	public String updateFreelancerInfo() {
//		return "member/freelancer/updateFreelancerInfo";
//	}
	
	
}
