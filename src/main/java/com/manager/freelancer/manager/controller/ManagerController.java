package com.manager.freelancer.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.manager.freelancer.manager.model.service.ManagerService;
import com.manager.freelancer.manager.model.vo.Member;

@Controller
public class ManagerController {
	
	@Autowired
	private ManagerService service;

	@GetMapping("/manager/main")
	public String managerMain() {
		return "";
	}
	
	// 회원 관리 - 회원 목록 조회
	@GetMapping("/manager/memberList")
	public String managerMemberList(Model model) {
		
		List<Member> memberList = service.selectMemberList();
		if(memberList!=null) {
			model.addAttribute("memberList", memberList);
		}
		
		return "/manager/memberList";
	}
	
	@GetMapping("/manager/tradeList")
	public String managerTradeList() {
		return "/manager/tradeList";
	}
	
	@GetMapping("/manager/serviceList")
	public String managerServiceList() {
		return "/manager/serviceList";
	}
	
	@GetMapping("/manager/projectRequestList")
	public String managerprojectRequestList() {
		return "/manager/projectRequestList";
	}
	
	@GetMapping("/manager/reviewList")
	public String managerReport() {
		return "/manager/reviewList";
	}
	
	@GetMapping("/manager/userInquiry")
	public String managerUserInquiry() {
		return "/manager/userInquiryList";
	}
	
	@GetMapping("/manager/userInquiry/1")
	public String managerUserInquiryDetail() {
		return "/manager/userInquiryDetail";
	}
	
}
