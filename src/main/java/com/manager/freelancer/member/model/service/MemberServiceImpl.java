package com.manager.freelancer.member.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.freelancer.member.model.dao.MemberDAO;
import com.manager.freelancer.member.model.vo.Member;


@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	// spring-security.xml에서 등록한 bean을 의존성 주입(DI) 
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	// 회원가입 서비스 
	@Override
	@Transactional(rollbackFor=Exception.class)//모든 예외 발생 시 롤백 
	public int signUp(Member inputMember) {
		
		// 비밀번호 암호화 
		String encPw=bcrypt.encode(inputMember.getMemberPw());
		inputMember.setMemberPw(encPw);
		
		String[] interest=inputMember.getMemberInterest().split(",");
		
		// DAO 호출 후 결과 반환 받기 
		int result=dao.signUp(inputMember);
		
		
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("memberNo", inputMember.getMemberNo()+"");
		
		for(int i=0;i<interest.length;i++) {
			map.put("memberInterest",interest[i]);
			
			result=dao.insertInterest(map);
		}
		
		
		return result;
	}
}
