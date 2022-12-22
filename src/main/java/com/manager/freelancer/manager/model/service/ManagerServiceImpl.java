package com.manager.freelancer.manager.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.manager.model.dao.ManagerDAO;
import com.manager.freelancer.manager.model.vo.Member;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ManagerDAO dao;
	
	//회원 목록 조회
	@Override
	public List<Member> selectMemberList() {
		
		List<Member> memberList = dao.selectMemberList();
		
		if(memberList!=null) {
			for(Member m : memberList) {
				if(m.getFreelancerFlag().equals("N")) {
					m.setMemberType("일반 회원");
					m.setFreelancerGrade("");
				} else {
					m.setMemberType("프리랜서");
					String gradeName = dao.selectFreelancerGrade(m.getMemberNo());
					m.setFreelancerGrade(gradeName);
				}
			}
		}
		return memberList;
	}

}
