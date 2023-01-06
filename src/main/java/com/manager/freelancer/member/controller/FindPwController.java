package com.manager.freelancer.member.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.freelancer.member.model.service.FindPwService;
import com.manager.freelancer.member.model.vo.Member;

@Controller
public class FindPwController {
	
	@Autowired
	private FindPwService service;
	
	
	@GetMapping("/member/findPw")
	public String FindPw() {
	
		return "/member/findPw";
	}
	
	@PostMapping("/member/findPw")
	@ResponseBody
	public int SendPw(Member inputMember) {
		
		int result=0;
		int memberNo=service.findInfo(inputMember);
		
		System.out.println(memberNo);
		// 조회는 됐고!
		
		Map<String, Object> map=new HashMap<String, Object>();
		String randomString=randomString();
		
		
		if(memberNo>0) {
			// 0보다크면 == 해당하는 회원정보가 있으면 비밀번호 변경
			map.put("memberNo", memberNo);
			map.put("memberName", inputMember.getMemberName());
			map.put("memberEmail", inputMember.getMemberEmail());
			map.put("memberTel", inputMember.getMemberTel());
			map.put("randomString", randomString);
			
			result=service.changeRanPw(map);
			
		}
		
		return result;
	}
	
	private String randomString() {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 8;
		Random random = new Random();

		String generatedString = random.ints(leftLimit,rightLimit + 1)
		  .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		  .limit(targetStringLength)
		  .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		  .toString();

		return generatedString;
	}
	
	
	

}
