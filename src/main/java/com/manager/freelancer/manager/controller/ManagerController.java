package com.manager.freelancer.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {

	@GetMapping("/manager/main")
	public String managerMain() {
		return "";
	}
	
	@GetMapping("/manager/memberList")
	public String managerMemberList() {
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
