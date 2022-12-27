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
import com.manager.freelancer.manager.model.vo.FreelancerService;

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

	
	
	//서비스 목록 조회
	@Override
	public Map<String, Object> selectServiceList(String status, int cp) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int listCount = dao.getServiceListCount(status);
		Pagination pagination = new Pagination(listCount, cp);

		List<FreelancerService> serviceList = dao.selectServiceList(status, pagination);
		
		if(serviceList!=null) {
			for(FreelancerService s : serviceList) {
				if(s.getServiceStatus()==1) s.setServiceStatusString("승인 대기중");
				else if(s.getServiceStatus()==2) s.setServiceStatusString("판매중");
				else if(s.getServiceStatus()==3) s.setServiceStatusString("미승인");
				else s.setServiceStatusString("판매 중지");
			}
		}
		map.put("serviceList", serviceList);
		map.put("pagination", pagination);
		
		return map;
	}
	
	
	
	
	
	

}
