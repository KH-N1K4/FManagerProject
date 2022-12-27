package com.manager.freelancer.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String managerMemberList(Model model, 
									@RequestParam(value="cp", required=false, defaultValue = "1") int cp,
									@RequestParam Map<String, Object> pm) {
		
		if(pm.get("key")==null) {
			Map<String, Object> map=service.selectMemberList(cp);
			model.addAttribute("map", map);
		}
		
		
		return "/manager/memberList";
	}
	
	// 회원 상세조회
	@GetMapping("/manager/memberDetail")
	@ResponseBody
	public Member managerMemberDetail(@RequestParam int memberNo ) {
		
		Member member = service.selectMemberDetail(memberNo);
		
		return member;
	}
	
	//회원 유형별 목록 조회
	@GetMapping("/manager/memberType")
	@ResponseBody
	public Map<String, Object> managerMemberType(Model model, 
									@RequestParam String value,
									@RequestParam(value="cp", required=false, defaultValue = "1") int cp,
									@RequestParam Map<String, Object> pm) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(pm.get("key")==null) {
			map=service.selectMemberTypeList(value,cp);
			model.addAttribute("map", map);
		}
		System.out.println(map);
		return map;
	}
	
	//회원 유형별 목록 조회
	@GetMapping("/manager/memberType2")
	public String managerMemberType2(Model model, 
								@RequestParam String value,
								@RequestParam(value="cp", required=false, defaultValue = "1") int cp,
								@RequestParam Map<String, Object> pm) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(pm.get("key")==null) {
			map=service.selectMemberTypeList(value,cp);
			model.addAttribute("map", map);
		}
		System.out.println(map);
		return "/manager/memberList";
	}
	
	
	
	
	
	
	// 회원 탈퇴
	@GetMapping("/manager/memberDelete")
	@ResponseBody
	public int managerMemberDelete(@RequestParam int memberNo) {
		
		System.out.println(memberNo);
		
		int result = service.managerMemberDelete(memberNo);
		
		return result;
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
	
	
	
	
	
	// 이용문의 관리 - 문의 내역
	@GetMapping("/manager/userInquiry")
	public String managerUserInquiry(Model model, 
									@RequestParam(value="cp", required=false, defaultValue = "1") int cp) {
		
		Map<String, Object> userInquiryList = service.selectUserInquiryList(cp);
		
		return "/manager/userInquiryList";
	}
	
	
	
	
	
	
	
	
	@GetMapping("/manager/userInquiry/1")
	public String managerUserInquiryDetail() {
		return "/manager/userInquiryDetail";
	}
	
}
