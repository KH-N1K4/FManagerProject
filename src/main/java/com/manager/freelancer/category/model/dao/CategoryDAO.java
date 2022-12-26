package com.manager.freelancer.category.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public List<Map<String, Object>> selectBoardType() {
		
		return sqlSession.selectList("selectBoardType");
	}

}
