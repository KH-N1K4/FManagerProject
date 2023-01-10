package com.manager.freelancer.customerCenter.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.manager.freelancer.customerCenter.model.service.UserInquiryService;
import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.member.model.vo.Member;

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
			
			String webPath = "/resources/images/customerCenterImage/";
			String folderPath = sessoin.getServletContext().getRealPath(webPath);
			
			
			// 이용문의 등록 서비스 
			int userInquiryNo = service.userInquiryInsert(userInquiry,imageList, webPath,folderPath);
			
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
	public String viewInquiryList(@SessionAttribute(value="loginMember",required=false) Member loginMember, Model model,
								  @RequestParam(value = "value", required = false) String optionVal,
								  @RequestParam(value="cp", required=false, defaultValue = "1") int cp,
								  @RequestParam Map<String,Object> pm, RedirectAttributes ra) {
		String message = null;
		String path = null;
		
			
		// 로그인이 되었을 때
		if(loginMember != null) {
			
			// 로그인 정보가 관리자일 때
			if(loginMember.getAuthority()==2) {
				
				path = "redirect:/";
			
			// 로그인 정보가 회원일 때
			} else {
				
				// 검색이 없을 때
				if(pm.get("key")==null) {
					
					Map<String, Object> map = service.selectInquiryList(loginMember.getMemberNo(), optionVal, cp);
					model.addAttribute("map",map);
				
				// 검색이 있을 때
				} else {
					pm.put("memberNo", loginMember.getMemberNo());
					pm.put("optionVal", optionVal);
					Map<String, Object> map = service.selectInquiryList(pm, cp);
					model.addAttribute("map",map);
				}
			
				path="customerCenter/inquiryList"; 
			}
			
			
		} else {
			message = "로그인 후 이용바랍니다.";
			path="redirect:/member/login";
			ra.addFlashAttribute("message",message);
		}
		
		return path;
	}

	
	// 이용문의 상세 보기로 이동 
	@GetMapping("/userInquiryDetail/{userInquiryNo}")
	public String viewInquiryDetail(@PathVariable(value="userInquiryNo") int userInquiryNo, Model model) {
		
		UserInquiry userInquiry = service.viewInquiryDetail(userInquiryNo);
		
		userInquiry.setUserInquiryNo(userInquiryNo);
		
		
		model.addAttribute("userInquiry",userInquiry);
		
		System.out.println(userInquiry.getImageList());
		
		return "customerCenter/inquiryDetail";
	}
	
	// 이용문의 내역 조회 (진행상태 변경 시)
	@GetMapping("/member/statusType")
	@ResponseBody
	public Map<String, Object> selectChangeStatus(@SessionAttribute("loginMember") Member loginMember, Model model,
									 @RequestParam(value="cp", required=false, defaultValue = "1") int cp,
									 @RequestParam String optionVal) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = service.selectChangeStatus(loginMember.getMemberNo(), optionVal ,cp);
		
		model.addAttribute("map", map);
		
		
		return map;
	}
	

}