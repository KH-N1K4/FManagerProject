package com.manager.freelancer.projectRequest.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.myProject.model.vo.myProjectFreelancerRequest;

@Repository
public class ProjectRequestDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public List<myProjectFreelancerRequest> getCategotyList() {
		
		return SqlSession.selectOne();;
	}
	
}