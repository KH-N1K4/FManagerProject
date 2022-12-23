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
	
	// 회원 상세 조회
	@Override
	public Member selectMemberDetail(int memberNo) {
		
		Member member = dao.selectMemberDetail(memberNo);
		
		if(member.getFreelancerFlag().equals("Y")) {
			Member freelancer = dao.selectFreelancerDetail(memberNo);
			member.setFreeContactTime1(freelancer.getFreeContactTime1());
			member.setFreeContactTime2(freelancer.getFreeContactTime2());
			member.setRegionName(freelancer.getRegionName());
			member.setFreelancerPeriod(freelancer.getFreelancerPeriod());
			member.setFreelancerIntroduction(freelancer.getFreelancerIntroduction());
		}
		
		return member;
	}
	
	// 유형별 회원 목록 조회
	@Override
	public Map<String, Object> selectMemberTypeList(String value, int cp) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(!value.equals("")) {
			int listCount = dao.getMemberListCount2(value);
			Pagination pagination = new Pagination(listCount, cp);
			
			List<Member> memberList = dao.selectMemberList2(value, pagination);
			
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
			
			map.put("pagination", pagination);
			map.put("memberList", memberList);
			
		} else {
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
			map.put("pagination", pagination);
			map.put("memberList", memberList);
		}
		

		return map;
	}
	

}
























