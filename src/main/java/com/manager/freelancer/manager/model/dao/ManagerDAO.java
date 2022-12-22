package com.manager.freelancer.manager.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.manager.model.vo.Member;

@Repository
public class ManagerDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 회원 목록 조회
	 * @return
	 */
	public List<Member> selectMemberList() {
		return sqlSession.selectList("managerMapper.selectMemberList");
	}

	/** 프리랜서 등급 조회
	 * @param memberNo
	 * @return
	 */
	public String selectFreelancerGrade(int memberNo) {
		return sqlSession.selectOne("managerMapper.selectFreelancerGrade", memberNo);
	}

}
