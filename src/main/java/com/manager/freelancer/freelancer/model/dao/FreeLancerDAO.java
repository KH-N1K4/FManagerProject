package com.manager.freelancer.freelancer.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.freelancer.model.vo.Career;
import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.freelancer.model.vo.License;
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


//	프리랜서 여부 변경> member테이블 ( N -> Y)
	public int updateFreelancerFlag(Freelancer inputFreelancer) {
		return sqlSession.update("freelancerMapper.updateFreelancerFlag",inputFreelancer);
	}
	// 경력 등록
	public int enrollFreelancerCareer(Career temp2) {
		return sqlSession.insert("freelancerMapper.enrollFreelancerCareer", temp2);
	}

	// 자격증 등록
	public int enrollfreelancerLicense(License temp3) {
		return sqlSession.insert("freelancerMapper.enrollFreelancerLicense", temp3);
	}


	// 프리랜서 계좌등록(insert)
	public int insertFreelancerAccount(Freelancer inputFreelancer) {
		return sqlSession.insert("freelancerMapper.insertinsertFreelancerAccount", inputFreelancer);
	}


	
}
