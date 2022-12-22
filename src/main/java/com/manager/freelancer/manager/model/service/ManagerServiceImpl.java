package com.manager.freelancer.manager.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.manager.model.dao.ManagerDAO;
import com.manager.freelancer.manager.model.vo.Member;
import com.manager.freelancer.manager.model.vo.Pagination;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ManagerDAO dao;
	
	// 회원 목록 조회 + 페이징
	@Override
	public Map<String, Object> selectMemberList(int cp) {
		int listCount = dao.getMemberListCount();
		Pagination pagination = new Pagination(listCount, cp);
		List<Member> memberList = dao.selectMemberList(pagination);
		
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("memberList", memberList);

		return map;
	}
	

}
























