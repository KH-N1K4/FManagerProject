package com.manager.freelancer.manager.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.manager.model.vo.FreelancerService;
import com.manager.freelancer.manager.model.vo.Member;
import com.manager.freelancer.manager.model.vo.Pagination;

@Repository
public class ManagerDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * 프리랜서 등급 조회
	 * 
	 * @param memberNo
	 * @return
	 */
	public String selectFreelancerGrade(int memberNo) {
		return sqlSession.selectOne("managerMapper.selectFreelancerGrade", memberNo);
	}

	/**
	 * 전체 회원 수 조회
	 * 
	 * @return
	 */
	public int getMemberListCount(String value2) {
		System.out.println("=======" + value2);
		return sqlSession.selectOne("managerMapper.getMemberListCount", value2);
	}

	/**
	 * 회원 목록 조회 + 페이징
	 * 
	 * @param pagination
	 * @return
	 */
	public List<Member> selectMemberList(String value2, Pagination pagination) {

		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("managerMapper.selectMemberList", value2, rowBounds);
	}

	/**
	 * 회원 관심분야 조회
	 * 
	 * @param memberNo
	 * @return
	 */
	public String selectMemberInterest(int memberNo) {
		return sqlSession.selectOne("managerMapper.selectMemberInterest", memberNo);
	}

	/**
	 * 회원 상세 조회
	 * 
	 * @param memberNo
	 * @return
	 */
	public Member selectMemberDetail(int memberNo) {
		return sqlSession.selectOne("managerMapper.selectMemberDetail", memberNo);
	}

	/**
	 * 프리랜서 상세 조회
	 * 
	 * @param memberNo
	 * @return
	 */
	public Member selectFreelancerDetail(int memberNo) {
		return sqlSession.selectOne("managerMapper.selectFreelancerDetail", memberNo);
	}

	/**
	 * 회원 탈퇴
	 * 
	 * @param memberNo
	 * @return
	 */
	public int managerMemberDelete(int memberNo) {
		return sqlSession.update("managerMapper.managerMemberDelete", memberNo);
	}

	/**
	 * 검색 조건 일치 회원 수 조회
	 * 
	 * @param pm
	 * @return
	 */
	public int getMemberListCount(Map<String, Object> pm) {
		return sqlSession.selectOne("managerMapper.getMemberListCount_search", pm);
	}

	/**
	 * 검색 조건 일치 회원 목록 조회
	 * 
	 * @param pagination
	 * @param pm
	 * @return
	 */
	public List<Member> selectMemberList(Pagination pagination, Map<String, Object> pm) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("managerMapper.selectMemberList_search", pm, rowBounds);
	}

	/**
	 * 서비스 수 조회
	 * 
	 * @param status
	 * @return
	 */
	public int getServiceListCount(String status) {
		return sqlSession.selectOne("managerMapper.getServiceListCount", status);
	}

	/**
	 * 서비스 목록 조회
	 * 
	 * @param status
	 * @param pagination
	 * @return
	 */
	public List<FreelancerService> selectServiceList(String status, Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("managerMapper.selectServiceList", status, rowBounds);
	}

}
