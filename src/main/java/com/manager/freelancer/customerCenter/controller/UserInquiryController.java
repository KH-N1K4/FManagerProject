package com.manager.freelancer.customerCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.freelancer.customerCenter.model.service.UserInquiryService;
import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.manager.model.vo.Member;

@Controller
public class UserInquiryController {
	
	@Autowired
	private UserInquiryService service;
	
	// 문의하기 페이지로 이동 
	@GetMapping("/customerInquiry")
	public String userInquiry() {

		return "customerCenter/customerInquiry";
	}
	
	// 문의하기 등록
	@PostMapping("/customerInquiryInsert")
	public String userInquiryInsert(UserInquiry inputInquiry, 
			                        @RequestHeader("referer") String referer, 
			                        @SessionAttribute("loginMember") Member loginMember, 
			                        RedirectAttributes ra) {
			
			String message = null;
			String path = null; 
			
			inputInquiry.setMemberNo(loginMember.getMemberNo());
			
			int result =  service.userInquiryInsert(inputInquiry);
			
			
			if(result > 0){ 
				
				// 성공 시 
				path = "serviceCenter/customerInquiry";
				message = "이용 문의가 성공적으로 등록되었습니다.";
				
			} else {
				
				// 실패 시 
				path = "referer";
				message = "이용문의 등록이 실패하였습니다. 다시 문의해주시기 바랍니다.";
			}
			
			ra.addFlashAttribute("message",message);
		
		return "redirect:" + path;
		
	}
	
	
	// 이용문의 내역으로 이동 
	@GetMapping("/customerInquiryList")
	public String viewInquiryList() {
		
		return "customerCenter/inquiryList";
	}
	
	@GetMapping("/customerInquiryDetail")
	public String viewInquiryDetail() {
		
		return "customerCenter/inquiryDetail";
	}

}