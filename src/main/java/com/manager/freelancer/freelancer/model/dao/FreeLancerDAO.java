package com.manager.freelancer.freelancer.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.freelancer.model.vo.Major;

@Repository
public class FreeLancerDAO {

	@Autowired
	private SqlSession sqlSession;

	public int enrollFreelancerSignup(Freelancer inputFreelancer) {
		// TODO Auto-generated method stub
		return sqlSession.insert("freelancerMapper.enrollFreelancer", inputFreelancer);
	}

	

	public int enrollFreelancerMajor(Major temp1) {
		
		return sqlSession.insert("freelancerMapper.enrollFreelancerMajor", temp1);
	}


//	프리랜서 여부 > member테이블
	public int updateFreelancerFlag(Freelancer inputFreelancer) {
		// TODO Auto-generated method stub
		return sqlSession.update("freelancerMapper.updateFreelancerFlag",inputFreelancer);
	}


	
}
