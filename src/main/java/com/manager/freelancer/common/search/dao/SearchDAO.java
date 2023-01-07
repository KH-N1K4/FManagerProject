package com.manager.freelancer.common.search.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.myProject.model.vo.FreelancerService;

@Repository
public class SearchDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<FreelancerService> searchInput(String keyword) {
		return sqlSession.selectList("myProjectFreelancerSerive.searchInput", keyword); //myProjectFreelancerService-mapper.xml
	}
}
