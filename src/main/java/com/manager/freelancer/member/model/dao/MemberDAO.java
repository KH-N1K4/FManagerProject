package com.manager.freelancer.member.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.member.model.vo.Member;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	/** 회원가입 DAO
	 * @param inputMember
	 * @return
	 */
	public int signUp(Member inputMember) {
		return sqlSession.insert("memberMapper.signUp",inputMember);
	}

	
	/** 회원가입 관심사 삽입
	 * @param map
	 * @return
	 */
	public int insertInterest(Map map) {
		return sqlSession.insert("memberMapper.insertInterest", map);
	}
	
	
	

	/** 로그인 DAO
	 * @param memberEmail
	 * @return loginMember
	 */
	public Member login(String memberEmail) {
	
		return sqlSession.selectOne("memberMapper.login", memberEmail);
	}


	public int updateMyInfo(Member inputMember) {
		return sqlSession.update("memberMapper.updateMyInfo", inputMember);
	}


	public int updateProfile(Member loginMember) {
		return sqlSession.update("memberMapper.updateProfile", loginMember);
	}
	
}
