package com.manager.freelancer.myProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyProjectContorller {
	
	// 내 프로젝트 이동
	@GetMapping("/member/myProject/myRequestList")
	public String likeList() {
		return "myProject/myProject_UserPage";
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
