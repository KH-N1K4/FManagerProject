package com.manager.freelancer.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.member.model.dao.MemberDAO;
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
}
