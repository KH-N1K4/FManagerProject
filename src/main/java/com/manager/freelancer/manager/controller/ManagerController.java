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
									@RequestParam(value="value", required=false) String value,
									@RequestParam(value="cp", required=false, defaultValue = "1") int cp,
									@RequestParam Map<String, Object> pm) {
		
		if(pm.get("key")==null) {
			Map<String, Object> map=service.selectMemberList(value,cp);
			model.addAttribute("map", map);
		} else {
			System.out.println(value);
			pm.put("value2", value);
			Map<String, Object> map=service.selectMemberList(pm, cp);
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
	
	//회원 유형별 목록 조회 ajax
	@GetMapping("/manager/memberType")
	@ResponseBody
	public Map<String, Object> managerMemberType(Model model, 
									@RequestParam String value,
									@RequestParam(value="cp", required=false, defaultValue = "1") int cp,
									@RequestParam Map<String, Object> pm) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(value);
		
		if(pm.get("key")==null) {
			map=service.selectMemberTypeList(value,cp);
			model.addAttribute("map", map);
		}
		System.out.println(map);
		return map;
	}
	
	// 회원 탈퇴
	@GetMapping("/manager/memberDelete")
	@ResponseBody
	public int managerMemberDelete(@RequestParam int memberNo) {
		
		System.out.println(memberNo);
		
		int result = service.managerMemberDelete(memberNo);
		
		return result;
	}
	
	
	
	// 서비스 등록 내역 관리
	@GetMapping("/manager/serviceList")
	public String managerServiceList(Model model, 
			@RequestParam(value="value", required=false) String value,
			@RequestParam(value="cp", required=false, defaultValue = "1") int cp) {
		return "/manager/serviceList";
	}
	
	
	
	
	
	
	
	@GetMapping("/manager/tradeList")
	public String managerTradeList() {
		return "/manager/tradeList";
	}
	@GetMapping("/manager/projectRequestList")
	public String managerprojectRequestList() {
		return "/manager/projectRequestList";
	}
	
	@GetMapping("/manager/reviewList")
	public String managerReport() {
		return "/manager/reviewList";
	}
	
	
	
	
	
	
	

	
}
