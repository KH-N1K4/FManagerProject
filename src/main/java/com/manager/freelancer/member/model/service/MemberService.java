package com.manager.freelancer.member.model.service;

import org.springframework.stereotype.Service;

import com.manager.freelancer.member.model.vo.Member;


public interface MemberService {

	int signUp(Member inputMember);

}
