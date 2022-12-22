package com.manager.freelancer.serviceCenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceCenterController {
	
	
	@GetMapping("/userInquiry")
	public String userInquiry() {

		return "serviceCenter/customerInquiry";
	}
	
	@GetMapping("/userInquiryList")
	public String viewInquiryList() {
		
		return "serviceCenter/inquiryList";
	}
	
	@GetMapping("/userInquiryDetail")
	public String viewInquiryDetail() {
		
		return "serviceCenter/inquiryDetail";
	}

}