package com.manager.freelancer.freelancer.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.freelancer.model.vo.Freelancer;

@Repository
public class FreeLancerDAO {

	@Autowired
	private SqlSession sqlSession;

	public int enrollFreelancer(Freelancer inputFreeLancer) {
		// TODO Auto-generated method stub
		return sqlSession.insert("freelancerMapper.enrollFreelancer", inputFreeLancer);
	}
	
	
}
