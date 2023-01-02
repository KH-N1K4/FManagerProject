package com.manager.freelancer.freelancer.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.freelancer.freelancer.model.service.FreeLancerService;
import com.manager.freelancer.freelancer.model.vo.Field;
import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.freelancer.model.vo.Portfolio;
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
			
			Freelancer freelancer = service.freelancerInfo(loginMember.getMemberNo());
			model.addAttribute("freelancer", freelancer); 
			
			List<Region> regionList = service.getRegionList();
			model.addAttribute("regionList",regionList);
			
//			System.out.println(regionList);
			
			List<Portfolio> portfolioList = service.getPortfolioList(inputFreelancer);
			model.addAttribute("portfolioList" ,portfolioList);

//			List<Field> fieldList = service.getFieldList(inputFreelancer);  // Field vo도만듬..
//			model.addAttribute("fieldList",fieldList);
			
			return "member/freelancer/freelancerInfo";
		}
		// 전문가 정보 수정 페이지로 이동
		@GetMapping("/member/freelancer/updateFreelancerInfo")
		public String updateFreelancerInfo(Model model, 
				@SessionAttribute("loginMember") Member loginMember) {
			
			Freelancer inputFreelancer = new Freelancer();
			inputFreelancer.setFreelancerNo(loginMember.getMemberNo()); // 회원번호 세팅
			
			Freelancer freelancer = service.freelancerInfo(loginMember.getMemberNo());
			model.addAttribute("freelancer", freelancer); 
			
			List<Region> regionList = service.getRegionList();
			model.addAttribute("regionList", regionList);
			
			return "/member/freelancer/updateFreelancerInfo";
		}
		
//		// 전문가 정보 수정 페이지 -> 수정
		@PostMapping("/member/freelancer/updateFreelancerInfo")
		public String updateFreelancerInfo(Model model,
				Freelancer inputFreelancer, // input 값
				@SessionAttribute("loginMember") Member loginMember,
				String career,
				RedirectAttributes ra) {
			String message = null;
			int result = 0;

			inputFreelancer.setFreelancerNo(loginMember.getMemberNo()); // 회원번호 세팅
			inputFreelancer.setCareer(career);
//			int freelancerNo = loginMember.getMemberNo(); // 0101 테스트! 회원번호->포트폴리오 조회하기 -> 실패
//			Freelancer freelancer = service.freelancerInfo(loginMember.getMemberNo());
//			model.addAttribute("freelancer", freelancer);
			List<Region> regionList = service.getRegionList();
			model.addAttribute("regionList", regionList);
			
			result = service.updateFreelancerInfo(inputFreelancer);

			if(result>0) {
				message="수정완료";
				
				
				
			}else {
				message="수정실패";
			}
			ra.addFlashAttribute("message", message);
			
			return "redirect:/member/freelancer/freelancerInfo";
		}
		
		@PostMapping("/member/freelancer/enrollFreelancerSignUp")
		public String enrollFreelancerSignup(@SessionAttribute("loginMember") Member loginMember,//회원번호 == 프리랜서번호
				String major, // major input태그에 적힌 값들
				String career,
				String license,
				
				Freelancer inputFreelancer,
				String[] freelancerField , RedirectAttributes ra,
				@RequestHeader(value="referer") String referer,
				int bankCode,
				String bankAccountNumber3
				) {

		
			String message=null;
			String path=null;
			
		// major > 학교명,전공,1
			

		inputFreelancer.setFreelancerNo(loginMember.getMemberNo()); // 로그인한 회원번호를 inputFreelancer에 세팅
		inputFreelancer.setMajor(major);
		inputFreelancer.setCareer(career);
		inputFreelancer.setLicense(license);
		
		inputFreelancer.setBankCode(bankCode);
		Long num = Long.parseLong(bankAccountNumber3); // int자료형길이 초과 10자 -> long
		inputFreelancer.setBankAccountNumber(num);
		
		
			
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
		
		// 포트폴리오 페이지 이동
		@GetMapping("/member/freelancer/modal/addPortfolio")
		public String addPortfolio() {
			
			return "/member/freelancer/modal/addPortfolio";
		}
		
		// 포트폴리오 등록
		@PostMapping("/member/freelancer/modal/addPortfolio")
		public String addPortfolio(Model model, 
				@SessionAttribute("loginMember") Member loginMember,
				Freelancer inputFreelancer, Portfolio inputPortfolio,
				@RequestParam(value="images", required = false) List<MultipartFile> imageList,
				HttpSession session,RedirectAttributes ra) {
			
			String message = null;
			String path = null;
			
			inputPortfolio.setFreelancerNo(loginMember.getMemberNo());
			
			String webPath = "/resources/images/freelancerPortfolioImage/"; // 만들어야함
			String folderPath = session.getServletContext().getRealPath(webPath);
			
			inputPortfolio.setFreelancerNo(loginMember.getMemberNo());
			int result = 0;
			
			result =  service.addPortfolio(inputPortfolio, imageList, webPath, folderPath);
			
			if(result > 0) {
				message = "포트폴리오가 성공적으로  등록되었습니다.";
			} else {
				message = "포트폴리오가 등록 실패.";

			}
//			ra.addFlashAttribute("message",message);
			
			return "/member/freelancer/modal/addPortfolio";
		}
		
		
}
