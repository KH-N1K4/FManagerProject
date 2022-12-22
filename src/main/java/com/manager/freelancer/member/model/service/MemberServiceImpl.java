package com.manager.freelancer.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.manager.freelancer.member.model.dao.MemberDAO;

public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
}
