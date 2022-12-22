package com.manager.freelancer.myProject.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyProjectDAO {

	@Autowired
	private SqlSession sqlSession;
	
}
