package com.manager.freelancer.freelancer.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.manager.freelancer.freelancer.model.service.FreeLancerService;
import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.freelancer.model.vo.Region;
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

		// 전문가 정보 이동 (전문가 정보 조회)
		@GetMapping("/member/freelancer/freelancerInfo")
		public String freelancerInfo(Model model, 
				@SessionAttribute("loginMember") Member loginMember) {
				
			Freelancer inputFreelancer = new Freelancer();
			
			inputFreelancer.setFreelancerNo(loginMember.getMemberNo()); // 회원번호 세팅
			

			System.out.println("확인 : "+inputFreelancer); // 세팅된 회원번호 확인
			Freelancer freelancer = service.freelancerInfo(loginMember.getMemberNo());
			model.addAttribute("freelancer", freelancer); 
//			List<Region> regionList = service.getRegionList();
			model.addAttribute("regionList",service.getRegionList());

			// model.addAttribute("regionList",service.getRegionList());
			return "member/freelancer/freelancerInfo";
		}
	
		
//		// 전문가 정보 수정 페이지 이동
//		@GetMapping("/member/freelancer/updateFreelancerInfo")
//		public String updateFreelancerInfo() {
//			return "member/freelancer/updateFreelancerInfo";
//		}
		
		//1228 2032
//		 전문가 정보 수정 > 삭제해야할지
		@PostMapping("/member/freelancer/updateFreelancerInfo")
		public String updateFreelancerInfo(Freelancer inputFreelancer,
				@SessionAttribute("loginMember")Member loginMember // 회원번호필요
				) {
			
			
			
			return "member/freelancer/updateFreelancerInfo";
		}
		
		@PostMapping("/member/freelancer/enrollFreelancerSignUp")
		public String enrollFreelancerSignup(@SessionAttribute("loginMember") Member loginMember,//회원번호 == 프리랜서번호
				String major, // major input태그에 적힌 값들
				String career,
				int majorStatus, // major에서 재학상태값
				String license,
				int bankCode,
				String bankAccountNumber3,
				Freelancer inputFreelancer
				/*String[] freelancerField */ ) {
		
		// major > 학교명,전공,1
			
		inputFreelancer.setFreelancerNo(loginMember.getMemberNo()); // 로그인한 회원번호를 inputFreelancer에 세팅
		inputFreelancer.setMajor(major);
		inputFreelancer.setMajorGraduateStatus(majorStatus);
		inputFreelancer.setCareer(career);
		inputFreelancer.setLicense(license);
		
		inputFreelancer.setBankCode(bankCode);
		Long num = Long.parseLong(bankAccountNumber3); // int자료형길이 초과 10자 -> long
		inputFreelancer.setBankAccountNumber(num);
		
		
			
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
