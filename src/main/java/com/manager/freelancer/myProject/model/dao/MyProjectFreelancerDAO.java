package com.manager.freelancer.myProject.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyProjectFreelancerDAO {
	@Autowired
	private SqlSession sqlSession;
}
