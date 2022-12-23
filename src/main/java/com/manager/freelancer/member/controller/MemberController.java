package com.manager.freelancer.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.freelancer.member.model.service.MemberService;
import com.manager.freelancer.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;

	
	//회원가입 페이지 이동
	@GetMapping("/member/signUp")
	public String signUp() {
		return "member/signUp";
	}
	
	@PostMapping("/member/signUp")
	public String signUp(Member inputMember, 
			RedirectAttributes ra, 
			@RequestHeader(value="referer") String referer) {
		
		String path=null;
		String message=null;
		
		
		System.out.println(inputMember);
		
		
		int result=service.signUp(inputMember);
		
		if(result>0){ // 성공시 
			path="/";
			message="회원 가입 성공!";
		}else { // 실패시 
			path=referer;
			message="회원 가입 실패...";
			
			// 이전 페이지로 돌아갔을 때 입력했던 값을 같이 전달
			inputMember.setMemberPw(null); // 비밀번호 삭제 
			ra.addFlashAttribute("tempMember", inputMember);
		}
		
		ra.addFlashAttribute("message", message);
		

		return "redirect:"+path;
	}
	
	// 로그인 페이지 이동
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	// 마이페이지 이동
	@GetMapping("/member/myInfo")
	public String myInfo() {
		return "member/myInfo";
	}
	
	// 비밀번호 변경  이동
	@GetMapping("/member/updatePw")
	public String updatePw() {
		return "member/updatePw";
	}
	
	// 회원 탈퇴 이동
	@GetMapping("/member/deleteMember")
	public String deleteMember() {
		return "member/deleteMember";
	}
	
	// 찜목록 이동
	@GetMapping("/member/likeList")
	public String likeList() {
		return "member/likeList";
	}
	
	
	
	
	
	
	

	
	
}
