package com.manager.freelancer.manager.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.manager.model.dao.ManagerDAO;
import com.manager.freelancer.manager.model.vo.Member;
import com.manager.freelancer.manager.model.vo.Pagination;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDAO dao;

	// 회원 목록 조회
	@Override
	public Map<String, Object> selectMemberList(String value, int cp) {

		Map<String, Object> map = new HashMap<String, Object>();

		int listCount = dao.getMemberListCount(value);
		Pagination pagination = new Pagination(listCount, cp);

		List<Member> memberList = dao.selectMemberList(value, pagination);

		if (memberList != null) {
			for (Member m : memberList) {
				if (m.getFreelancerFlag().equals("N")) {
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

		return map;

	}

	// 회원 상세 조회
	@Override
	public Member selectMemberDetail(int memberNo) {

		Member member = dao.selectMemberDetail(memberNo);

		if (member.getFreelancerFlag().equals("Y")) {
			Member freelancer = dao.selectFreelancerDetail(memberNo);
			member.setFreeContactTime1(freelancer.getFreeContactTime1());
			member.setFreeContactTime2(freelancer.getFreeContactTime2());
			member.setRegionName(freelancer.getRegionName());
			member.setFreelancerPeriod(freelancer.getFreelancerPeriod());
			member.setFreelancerIntroduction(freelancer.getFreelancerIntroduction());
			member.setFreelancerBankName(freelancer.getFreelancerBankName());
			member.setFreelancerAccountNo(freelancer.getFreelancerAccountNo());
		}

		return member;
	}

	//회원 유형별 조회 ajax
	@Override
	public Map<String, Object> selectMemberTypeList(String value, int cp) {
		Map<String, Object> map = new HashMap<String, Object>();

		int listCount = dao.getMemberListCount(value);
		Pagination pagination = new Pagination(listCount, cp);

		List<Member> memberList = dao.selectMemberList(value, pagination);

		if (memberList != null) {
			for (Member m : memberList) {
				if (m.getFreelancerFlag().equals("N")) {
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

		return map;

	}
	
	
	// 회원 탈퇴
	@Override
	public int managerMemberDelete(int memberNo) {
		return dao.managerMemberDelete(memberNo);
	}

	// 회원 검색 목록 조회
	@Override
	public Map<String, Object> selectMemberList(Map<String, Object> pm, int cp) {
		int listCount = dao.getMemberListCount(pm);
		Pagination pagination = new Pagination(listCount, cp);
		List<Member> memberList = dao.selectMemberList(pagination, pm);

		if (memberList != null) {
			for (Member m : memberList) {
				if (m.getFreelancerFlag().equals("N")) {
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

	// 회원 유형별 검색 목록 조회
	@Override
	public Map<String, Object> selectMemberTypeList(Map<String, Object> pm, int cp) {
		int listCount = dao.getMemberListCount2(pm);
		Pagination pagination = new Pagination(listCount, cp);
		List<Member> memberList = dao.selectMemberList2(pagination, pm);

		if (memberList != null) {
			for (Member m : memberList) {
				if (m.getFreelancerFlag().equals("N")) {
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

	// 이용문의 내역 조회 + 페이징
	@Override
	public Map<String, Object> selectUserInquiryList(int cp) {

		int listCount = dao.getUserInguiryListCount();
		Pagination pagination = new Pagination(listCount, cp);
		List<UserInquiry> userInquiryList = dao.selectUserInquiryList(pagination);
		/*
		 * if(memberList!=null) { for(Member m : memberList) {
		 * if(m.getFreelancerFlag().equals("N")) { m.setMemberType("일반 회원");
		 * m.setFreelancerGrade(""); } else { m.setMemberType("프리랜서"); String gradeName
		 * = dao.selectFreelancerGrade(m.getMemberNo());
		 * m.setFreelancerGrade(gradeName); } }
		 * 
		 * }
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		/* map.put("memberList", memberList); */

		return map;
	}

}
