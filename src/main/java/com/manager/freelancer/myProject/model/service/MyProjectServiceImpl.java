package com.manager.freelancer.myProject.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.myProject.model.dao.MyProjectDAO;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.myProject.model.vo.MyProject;
import com.manager.freelancer.myProject.model.vo.Pagination;


@Service
public class MyProjectServiceImpl implements MyProjectSerive{
	
	@Autowired
	private MyProjectDAO dao;

	/**
	 * 메인 카테고리 들고 오기
	 */
	@Override
	public List<MyProject> selectmaincategoryList() {
		return dao.selectmaincategoryList();
	}

	/**
	 * 나의 프로젝트 들고오기 페이지 처리
	 */
	@Override
	public Map<String, Object> selectMyProject(int memberNo, int mainCategoryNo, int cp) {
		int listCount = dao.getMyProjectListCount(memberNo,mainCategoryNo);
		
		Pagination pagination = new Pagination(listCount,cp); 
		
		List<MyProject> myProject = dao.selectMyProject(memberNo,mainCategoryNo,pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("myProject",myProject);
		map.put("listCount",listCount);
		
		
		return map;
	}

}
