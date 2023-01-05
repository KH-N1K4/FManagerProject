package com.manager.freelancer.projectRequest.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.myProject.model.vo.Pagination;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancerRequest;
import com.manager.freelancer.projectRequest.model.dao.ProjectRequestDAO;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancerRequest;


@Service
public class ProjectRequestServiceImpl implements ProjectRequestSerivce{
	
	@Autowired
	private ProjectRequestDAO dao;

	/**
	 *프로젝트 목록 조회
	 */
	@Override
	public Map<String, Object> getCategotyList(int cp, int mainCategoryNo, int subCategoryNo, int thirdCategoryNo) {
		int listCount = dao.getProjectRequestListCount(mainCategoryNo,subCategoryNo,thirdCategoryNo);
		
		Pagination pagination = new Pagination(listCount,cp,20,10);
		
		Map<String, Object> map = new HashMap<String, Object>();
		 
		List<myProjectFreelancerRequest> categoryList = dao.getCategoryList();
		List<myProjectFreelancerRequest> subCategoryList = dao.getSubCategoryList();
		List<myProjectFreelancerRequest> mainCategoryList = dao.getMainCategoryList();
		List<myProjectFreelancerRequest> projectRequestList = dao.getProjectRequestList(pagination,mainCategoryNo,subCategoryNo,thirdCategoryNo);
		
		map.put("categoryList",categoryList);
		map.put("subCategoryList",subCategoryList);
		map.put("mainCategoryList",mainCategoryList);
		map.put("projectRequestList",projectRequestList);
		map.put("pagination",pagination);
		return map;
	}

	/**
	 *프로젝트 의뢰 상세보기
	 */
	@Override
	public myProjectFreelancerRequest selectUserRequest(int projectRequestNo) {
		
		return dao.selectUserRequest(projectRequestNo);
	}
}
