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
public class FreeLancerController2 {
	
	@Autowired
	private FreeLancerService service;
	
	
		// 전문가 정보 수정 페이지로 이동
		@GetMapping("/member/freelancer/updateFreelancerInfo1")
		public String updateFreelancerInfo(Model model, 
				@SessionAttribute("loginMember") Member loginMember) {
			
			List<Region> regionList = service.getRegionList();
			model.addAttribute("regionList",regionList);
			
			Freelancer inputFreelancer = new Freelancer();
			inputFreelancer.setFreelancerNo(loginMember.getMemberNo()); // 회원번호 세팅
			

			
			Freelancer1  freelancer1 = service.freelancerInfo1(loginMember.getMemberNo());
			model.addAttribute("freelancer1",freelancer1);
			
			return "/member/freelancer/updateFreelancerInfo";
		}
		
//		// 전문가 정보 수정 페이지 -> 수정
		@PostMapping("/member/freelancer/updateFreelancerInfo1")
		public String updateFreelancerInfo(Model model,
				Freelancer inputFreelancer, // input 값
				@SessionAttribute("loginMember") Member loginMember,
				String career, String license, 
				int bankCode,
				String bankAccountNumber,
				RedirectAttributes ra) {
			String message = null;
			int result = 0;

			inputFreelancer.setFreelancerNo(loginMember.getMemberNo()); // 회원번호 세팅
			inputFreelancer.setCareer(career);
			inputFreelancer.setLicense(license);
			
			List<Field> fieldList = service.getFieldList(inputFreelancer);
			model.addAttribute("fieldList", fieldList);
			
//			if(!inputFreelancer.getFreelancerField().equals(fieldList))
			
			List<Region> regionList = service.getRegionList();
			model.addAttribute("regionList", regionList);
			
			List<Bank> bankList = service.getBankList();
			model.addAttribute("bankList", bankList);

			inputFreelancer.setBankCode(bankCode);
			Long num = Long.parseLong(bankAccountNumber); // int자료형길이 초과 10자 -> long
			inputFreelancer.setBankAccountNumber(num);
			
			result = service.updateFreelancerInfo(inputFreelancer);

			if(result>0) {
				message="수정완료";
				
				
				
			}else {
				message="수정실패";
			}
			ra.addFlashAttribute("message", message);
			
			return "redirect:/member/freelancer/freelancerInfo";
		}
	
		
}
