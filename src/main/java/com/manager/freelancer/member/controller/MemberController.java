package com.manager.freelancer.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	
	//회원가입 페이지 이동
	@GetMapping("/member/signUp")
	public String signUp() {
		return "member/signUp";
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 전문가등록 이동
	@GetMapping("/member/enrollFreelancer")
	public String enrollFreelancer() {
		return "member/enrollFreelancer";
	}
	
	
}
