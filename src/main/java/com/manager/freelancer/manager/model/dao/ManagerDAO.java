package com.manager.freelancer.manager.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.manager.model.vo.Member;
import com.manager.freelancer.manager.model.vo.Pagination;

@Repository
public class ManagerDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;


	/** 프리랜서 등급 조회
	 * @param memberNo
	 * @return
	 */
	public String selectFreelancerGrade(int memberNo) {
		return sqlSession.selectOne("managerMapper.selectFreelancerGrade", memberNo);
	}

	/** 전체 회원 수 조회
	 * @return
	 */
	public int getMemberListCount() {
		return sqlSession.selectOne("managerMapper.getMemberListCount");
	}

	/** 회원 목록 조회 + 페이징
	 * @param pagination
	 * @return
	 */
	public List<Member> selectMemberList(Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("managerMapper.selectMemberList",null,rowBounds);
	}

	/** 회원 관심분야 조회
	 * @param memberNo
	 * @return
	 */
	public String selectMemberInterest(int memberNo) {
		return sqlSession.selectOne("managerMapper.selectMemberInterest",memberNo);
	}

	/** 회원 상세 조회
	 * @param memberNo
	 * @return
	 */
	public Member selectMemberDetail(int memberNo) {
		return sqlSession.selectOne("managerMapper.selectMemberDetail",memberNo);
	}

	/** 프리랜서 상세 조회
	 * @param memberNo
	 * @return
	 */
	public Member selectFreelancerDetail(int memberNo) {
		return sqlSession.selectOne("managerMapper.selectFreelancerDetail",memberNo);
	}

	/** 유형별 회원 수 조회
	 * @param value
	 * @return
	 */
	public int getMemberListCount2(String value) {
		return sqlSession.selectOne("managerMapper.getMemberListCount2",value);
	}

}
























