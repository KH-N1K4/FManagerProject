package com.manager.freelancer.category.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.category.model.vo.AskService;
import com.manager.freelancer.category.model.vo.Category;
import com.manager.freelancer.category.model.vo.ImageFile;
import com.manager.freelancer.category.model.vo.Service;
import com.manager.freelancer.myProject.model.vo.FreelancerService;

@Repository
public class CategoryDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public List<Map<String, Object>> selectMainCategoryList() {
		
		return sqlSession.selectList("categoryMapper.selectMainCategoryList");
	}

	public List<Map<String, Object>> selectSubCategoryList() {
		return sqlSession.selectList("categoryMapper.selectSubCategoryList");
	}

	public List<Map<String, Object>> selectThirdCategoryList() {
		return sqlSession.selectList("categoryMapper.selectThirdCategoryList");
	}

	public List<Service> selectBoardList(int mainCategoryNo) {
		return sqlSession.selectList("categoryMapper.selectBoardList",mainCategoryNo);
	}

	public Service viewService(int serviceNo) {
		return sqlSession.selectOne("categoryMapper.viewService",serviceNo);
	}

	public int askService(AskService as) {
		return sqlSession.insert("categoryMapper.askService",as);
	}


}
