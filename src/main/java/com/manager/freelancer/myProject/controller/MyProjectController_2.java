package com.manager.freelancer.myProject.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.service.MyProjectService_2;

@Controller
@SessionAttributes({"loginMember"})
public class MyProjectController_2 {
	
	@Autowired
	private MyProjectService_2 service;
	
	// 결제내역이동
	@GetMapping("/member/myProject/paymentList")
	public String paymentList(Model model, @SessionAttribute("loginMember") Member loginMember,
			@RequestParam(value="cp" , required = false, defaultValue = "1") int cp,
			@RequestParam(value="type" , required = false, defaultValue = "0") int type,
			@RequestParam(value="searchDate1" , required = false, defaultValue = "") String searchDate1,
			@RequestParam(value="searchDate2" , required = false, defaultValue = "") String searchDate2) {
		
		int loginMemberNo = loginMember.getMemberNo();
		
		Map<String, Object> option = new HashMap<String, Object>();
		option.put("loginMemberNo", loginMemberNo);
		option.put("type", type);
		option.put("searchDate1", searchDate1);
		option.put("searchDate2", searchDate2);
		
		Map<String, Object> resultMap = service.selectPaymentList(option,cp);
		
		model.addAttribute("resultMap", resultMap);
		model.addAttribute("type", type);
		model.addAttribute("searchDate1", searchDate1);
		model.addAttribute("searchDate2", searchDate2);
		
		return "myProject/paymentList";
	}

}
