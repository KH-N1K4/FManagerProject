package com.manager.freelancer.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.member.model.vo.Member;

@Repository
public class FindPwDAO {
		
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 입력된 정보로 회원 찾기
	 * @param inputMember
	 * @return
	 */
	public int findInfo(Member inputMember) {
		return sqlSession.selectOne("memberMapper2.findInfo",inputMember);
	}

	/** 새 비밀번호
	 * @param map
	 * @return
	 */
	public int changeRanPw(Map<String, Object> map) {
		return sqlSession.update("memberMapper2.changeRanPw",map);
	}

}
