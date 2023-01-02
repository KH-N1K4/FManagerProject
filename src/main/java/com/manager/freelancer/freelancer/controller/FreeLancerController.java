package com.manager.freelancer.freelancer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.freelancer.freelancer.model.service.FreeLancerService;
import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.member.model.vo.Member;


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
		public String enrollFreelancerSignup(@SessionAttribute("loginMember") Member loginMember,//회원번호 == 프리랜서번호
				String major, // major input태그에 적힌 값들
				String career,
				String license,
				Freelancer inputFreelancer,
				String[] freelancerField , RedirectAttributes ra,
				@RequestHeader(value="referer") String referer
				) {
		
			String message=null;
			String path=null;
			
		// major > 학교명,전공,1
			
			inputFreelancer.setFreelancerNo(loginMember.getMemberNo()); // 로그인한 회원번호를 inputFreelancer에 세팅
			inputFreelancer.setMajor(major);
			inputFreelancer.setCareer(career);
			inputFreelancer.setLicense(license);
			int result = service.enrollFreelancerSignup(inputFreelancer);
		
		
			if(result > 0) {
				path="/";
				message="전문가등록성공";
				
			} else {
				path=referer;
				message="전문가등록실패";

			}
			ra.addFlashAttribute("message",message);
			return "redirect:"+path;
		}
		

}
