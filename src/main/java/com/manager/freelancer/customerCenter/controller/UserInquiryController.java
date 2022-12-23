package com.manager.freelancer.customerCenter.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.freelancer.customerCenter.model.service.UserInquiryService;
import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.member.model.vo.Member;

@SessionAttributes({"loginMember"})
@Controller
public class UserInquiryController {
	
	@Autowired
	private UserInquiryService service;
	
	// 문의하기 페이지로 이동 
	@GetMapping("/userInquiry")
	public String userInquiry() {

		return "customerCenter/customerInquiry";
	}
	
	
	
	// 문의하기 작성
	@PostMapping("/userInquiryInsert")
	public String userInquiryInsert(UserInquiry userInquiry, 
			                        @RequestHeader("referer") String referer, 
			                        @SessionAttribute("loginMember") Member loginMember,
			                        @RequestParam(value="images", required = false) List<MultipartFile> imageList,
			                        HttpSession sessoin, RedirectAttributes ra) throws IOException{
			
			String message = null;
			String path = null; 
			
			userInquiry.setMemberNo(loginMember.getMemberNo());
			
			String webPath = "/resources/images/";
			String folderPath = sessoin.getServletContext().getRealPath(webPath);
			
			System.out.println(userInquiry);
			
			// 이용문의 등록 서비스 
			int userInquiryNo = service.userInquiryInsert(userInquiry,imageList, webPath,folderPath);
			System.out.println(userInquiryNo);
			
			if(userInquiryNo > 0){ 
				
				// 성공 시 
				path = "userInquiryList";
				message = "이용 문의가 성공적으로 등록되었습니다.";
				
			} else {
				
				// 실패 시 
				path = "referer";
				message = "이용문의 등록이 실패하였습니다. 다시 문의해주시기 바랍니다.";
			}
			
			ra.addFlashAttribute("message",message);
		
		return "redirect:" + path;
		
	}
	
	// 이용문의 내역으로 이동 및 조회
	@GetMapping("/userInquiryList")
	public String viewInquiryList(@SessionAttribute("loginMember") Member loginMember, Model model) {
		
		List<UserInquiry> userInquiry = service.selectInquiryList(loginMember.getMemberNo());
		System.out.println(userInquiry);
		
		model.addAttribute("userInquiry",userInquiry);
		
		return "customerCenter/inquiryList";
	}
	
	
	// 이용문의 상세 보기로 이동 
	@GetMapping("/userInquiryDetail")
	public String viewInquiryDetail() {
		
		return "customerCenter/inquiryDetail";
	}

}