package com.manager.freelancer.freelancer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.manager.freelancer.freelancer.model.service.FreeLancerService;
import com.manager.freelancer.freelancer.model.vo.Freelancer;


@Controller
public class FreeLancerController {
	
	@Autowired
	private FreeLancerService service;
	
	// 전문가 등록 페이지로 이동
		@GetMapping("/member/enrollFreelancer")
		public String enrollFreelancer() {
			return "member/enrollFreelancer";
		}
		
		//전문가등록페이지 -> 자격증 팝업창 이동
		@GetMapping("/freelancer/modal/license")
		public String licensePopup() {
			return "member/freelancer/modal/license";
		}
		

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
//		@PostMapping("/member/freelancer/updateFreelancerInfo")
//		public String updateFreelancerInfo() {
//			return "member/freelancer/updateFreelancerInfo";
//		}
		
		@PostMapping("/member/freelancer/enrollFreelancerSignUp")
		public String enrollFreelancerSignup(Freelancer inputFreelancer,
				String[] freelancerField  ) {
		int result = service.enrollFreelancerSignup(inputFreelancer);
		
//		String path = null;
		
			if(result > 0) {
//				path="/";
				System.out.println("전문가등록성공");
				
			} else {
//				path="/";
				System.out.println("전문가등록실패");
				


			}
			return "/";
		}
		

}
