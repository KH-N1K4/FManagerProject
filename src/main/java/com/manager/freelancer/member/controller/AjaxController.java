package com.manager.freelancer.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.manager.freelancer.member.model.service.AjaxService;
import com.manager.freelancer.member.model.vo.Member;

@Controller
public class AjaxController {
	
	@Autowired
	private AjaxService service;
	
	
	// 이메일 중복 검사 
	@GetMapping("/emailDupCheck")
	@ResponseBody // 반환되는 값을 jsp 경로가 아난 값 자체로 인식 
	public int emailDupCheck(String memberEmail) {
							// data : { "memberEamil":memberEmail.value }
		
//		System.out.println(memberEmail);
		
		int result=service.emailDupCheck(memberEmail);
		
		// @ResposeBody 어노테이션 덕분에
		// result가 View Resolver로 전달되지 않고
		// 호출했던 ajax 함수로 반환됨
		return result;
	}
	
	// 닉네임 중복검사
	@GetMapping("/nicknameDupCheck")
	@ResponseBody
	public int nicknameDupCheck(String memberNickname) {
		int result=service.nicknameDupCheck(memberNickname);
		
		return result;
	}
	

}
