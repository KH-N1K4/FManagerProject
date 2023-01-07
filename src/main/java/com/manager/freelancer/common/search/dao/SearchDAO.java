package com.manager.freelancer.common.search.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.manager.freelancer.manager.model.vo.Pagination;
import com.manager.freelancer.myProject.model.vo.FreelancerService;

@Repository
public class SearchDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<FreelancerService> searchInput(String keyword) {
		return sqlSession.selectList("myProjectFreelancerSerive.searchInput", keyword); //myProjectFreelancerService-mapper.xml
	}

	public int getSearchServiceCount(Map<String, Object> map) {

		return sqlSession.selectOne("myProjectFreelancerSerive.getSearchServiceCount", map);
	}

	public List<Service> selectSearchServiceList(Pagination pagination, Map<String, Object> map) {

		int offset=(pagination.getCurrentPage()-1)*pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("myProjectFreelancerSerive.selectSearchServiceList",map,rowBounds);
	}
}
