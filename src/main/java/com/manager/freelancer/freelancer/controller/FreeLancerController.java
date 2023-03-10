package com.manager.freelancer.freelancer.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.freelancer.category.model.vo.Freelancer1;
import com.manager.freelancer.common.Util;
import com.manager.freelancer.freelancer.model.service.FreeLancerService;
import com.manager.freelancer.freelancer.model.vo.Bank;
import com.manager.freelancer.freelancer.model.vo.Field;
import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.freelancer.model.vo.License;
import com.manager.freelancer.freelancer.model.vo.Portfolio;
import com.manager.freelancer.freelancer.model.vo.Region;
import com.manager.freelancer.member.model.vo.Member;


@Controller
@SessionAttributes({"loginMember"})
public class FreeLancerController {
	
	@Autowired
	private FreeLancerService service;
	
	// 전문가 등록 페이지로 이동
		@GetMapping("/member/enrollFreelancer")
		public String enrollFreelancer() {
			return "member/enrollFreelancer";
		}

		// 전문가 정보 이동 (전문가 정보 조회)
		@GetMapping("/member/myInfo/freelancerInfo")
		public String freelancerInfo(Model model, 
				@SessionAttribute("loginMember") Member loginMember) {
				
			Freelancer inputFreelancer = new Freelancer();
			inputFreelancer.setFreelancerNo(loginMember.getMemberNo()); // 회원번호 세팅
			
//			Freelancer freelancer = service.freelancerInfo(loginMember.getMemberNo());
//			model.addAttribute("freelancer", freelancer); 
			
			Freelancer1  freelancer1 = service.freelancerInfo1(loginMember.getMemberNo());
			
			freelancer1.setFreelancerIntro(Util.newLineClear(freelancer1.getFreelancerIntro()));
	
			model.addAttribute("freelancer1",freelancer1);
			
			
			List<Region> regionList = service.getRegionList();
			model.addAttribute("regionList",regionList);
						
			List<Portfolio> portfolioList = service.getPortfolioList(inputFreelancer);
			model.addAttribute("portfolioList" ,portfolioList);

			return "member/freelancer/freelancerInfo";
		}
		

		// 전문가 정보 수정 페이지로 이동
		@GetMapping("/member/myInfo/updateFreelancerInfo")
		public String updateFreelancerInfo(Model model, 
				@SessionAttribute("loginMember") Member loginMember) {
			
	
			Freelancer1  freelancer1 = service.freelancerInfo1(loginMember.getMemberNo());
			freelancer1.setFreelancerIntro(Util.newLineClear(freelancer1.getFreelancerIntro()));
			model.addAttribute("freelancer1",freelancer1);
			
			return "/member/freelancer/updateFreelancerInfo";
		}
		
		// 전문가 정보 수정 페이지 -> 수정
		@PostMapping("/member/myInfo/updateFreelancerInfo")
		public String updateFreelancerInfo(@SessionAttribute("loginMember") Member loginMember,//회원번호 == 프리랜서번호
				String major, // major input태그에 적힌 값들
				String career,
				String license,
				Freelancer inputFreelancer,
				String[] freelancerField , RedirectAttributes ra,
				@RequestHeader(value="referer") String referer,
				int bankCode,
				String bankAccountNumber, Model model) {
			String message = null;
			String path=null;
			int result = 0;

			inputFreelancer.setFreelancerNo(loginMember.getMemberNo()); // 회원번호 세팅
			inputFreelancer.setCareer(career);
			inputFreelancer.setLicense(license);
			inputFreelancer.setMajor(major);
			
			
			inputFreelancer.setBankCode(bankCode);
			Long num = Long.parseLong(bankAccountNumber); // int자료형길이 초과 10자 -> long
			inputFreelancer.setBankAccountNumber(num);
			
			result = service.updateFreelancerInfo(inputFreelancer);
			model.addAttribute("freelancer1",inputFreelancer);

			if(result>0) {
				path="/member/myInfo/freelancerInfo";
				message="수정완료";
			}else {
				path=referer;
				message="수정실패";
			}
			ra.addFlashAttribute("message", message);
			
			return "redirect:"+path;
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
				String bankAccountNumber
				) {

		
			String message=null;
			String path=null;
			
		// major > 학교명,전공,1
			

		inputFreelancer.setFreelancerNo(loginMember.getMemberNo()); // 로그인한 회원번호를 inputFreelancer에 세팅
		inputFreelancer.setMajor(major);
		inputFreelancer.setCareer(career);
		inputFreelancer.setLicense(license);
		
		// input의 은행, 계좌번호
		inputFreelancer.setBankCode(bankCode);
		Long num = Long.parseLong(bankAccountNumber); // int자료형길이 초과 10자 -> long
		inputFreelancer.setBankAccountNumber(num);
		
		
			
			int result = service.enrollFreelancerSignup(inputFreelancer);
		

		
		
			if(result > 0) {
				path="/";
				message="전문가등록성공";
				loginMember.setFreelancerFL("Y");
				
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
				@RequestHeader(value="referer") String referer,
				@RequestParam(value="portfolioFile", required = false) List<MultipartFile> portfolioFilePath,
				Freelancer inputFreelancer, Portfolio inputPortfolio,
				HttpServletRequest req,RedirectAttributes ra)throws Exception {
			
			String message = null;
			String path = null;
			int result = 0;

			inputPortfolio.setFreelancerNo(loginMember.getMemberNo());

			String webPath = "/resources/images/freelancerPortfolioImage/"; // 만들어야함
			String folderPath = req.getSession().getServletContext().getRealPath(webPath);

			result =  service.addPortfolio(inputPortfolio, webPath, folderPath,portfolioFilePath);


			
			
			
			
			
			if(result > 0) {
				message = "포트폴리오가 성공적으로  등록되었습니다.";
			} else {
				path=referer;
				message = "포트폴리오가 등록 실패.";
				

			}
			ra.addFlashAttribute("message",message);
			
			return "redirect:/member/myInfo/freelancerInfo";
		}
		
		// 포트폴리오 삭제
		@GetMapping("/member/freelancer/deletePortfolio")
		@ResponseBody
		public int DeletePortfolio(@RequestParam("fNo") int freelancerNo, @RequestParam("pNo") int portfolioNo,
				Freelancer1 freelancer1) {
			
			int result = service.DeletePortfolio(freelancer1, freelancerNo, portfolioNo);
			
			return result;
		}
		
		
		
		//포트폴리오 상세 페이지로 이동
//		@GetMapping("/portfolioDetail/{portfolioNo}")
//		public String portfolioDetail(@PathVariable(value="portfolioNo") int portfolioNo,
//			Model model, @SessionAttribute("loginMember") Member loginMember
//			) {
//			// 포트폴리오 번호, 회원번호, 포트폴리오 제목 포트폴리오내용, =portfolio 
//			
//			Portfolio portfolio = new Portfolio();
//			
//			portfolio.setFreelancerNo(loginMember.getMemberNo());
//			portfolio.setPortfolioNo(portfolioNo);
//			portfolio = service.viewPortfolioDetail(portfolio);
//			
////			portfolio.setPortfolioNo(portfolioNo);
//			
//			model.addAttribute("portfolio", portfolio);
//			
//			return "/member/freelancer/portfolioDetail";
//		}
		
		
}
