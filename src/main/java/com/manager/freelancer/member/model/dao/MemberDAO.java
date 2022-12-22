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

	public int signUp(Member inputMember) {
		return sqlSession.insert("memberMapper.signUp",inputMember);
	}

	public int insertInterest(Map map) {
		return sqlSession.insert("memberMapper.insertInterest", map);
	}
	
}
