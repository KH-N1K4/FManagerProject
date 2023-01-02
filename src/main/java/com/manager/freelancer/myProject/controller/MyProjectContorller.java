package com.manager.freelancer.myProject.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.service.MyProjectSerive;
import com.manager.freelancer.myProject.model.vo.MyProject;



@Controller
public class MyProjectContorller {
	
	@Autowired
	private MyProjectSerive service;
	
	// 내 프로젝트 이동
	@GetMapping("/member/myProject/myRequestList")
	public String likeList(Model model, HttpSession session,
			 			   @RequestParam(value="mainCategoryNo",required=false, defaultValue="0") int mainCategoryNo,
			               @RequestParam(value="cp" , required = false, defaultValue = "1") int cp ) {
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		List<MyProject> maincategoryList = service.selectmaincategoryList();
		
		Map<String, Object> map  = service.selectMyProject(loginMember.getMemberNo(),mainCategoryNo,cp);
		model.addAttribute("maincategoryList",maincategoryList);
		model.addAttribute("myProject",map.get("myProject"));
		model.addAttribute("pagination",map.get("pagination"));
		model.addAttribute("listCount",map.get("listCount"));
		model.addAttribute("mainCategoryNoInput",mainCategoryNo);
		
		return "myProject/myProject_user/myProject_UserPage";
	}
	
	
	
	
	
	
	
	
	
	// 받은 제안 이동
	@GetMapping("/member/myProject/myReceiveList")
	public String myRequestInsert() {
		return "myProject/myProject_suggestion";
	}
	
	
	// 등록하기 이동
	@GetMapping("/member/myProject/myRequestInsert")
	public String myReceiveList() {
		return "myProject/myProject_add";
	}

	// 구매 관리 이동
	@GetMapping("/member/myProject/myPurchaseList")
	public String myPurchaseList() {
		return "myProject/myPurchaseList";
	}
	
	// 결제내역이동
	@GetMapping("/member/myProject/paymentList")
	public String paymentList() {
		return "myProject/paymentList";
	}
	
}
