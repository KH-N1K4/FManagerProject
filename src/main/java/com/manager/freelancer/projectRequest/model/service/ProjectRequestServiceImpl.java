package com.manager.freelancer.projectRequest.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.myProject.model.vo.Pagination;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancer;
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

	/**
	 *프로젝트 의뢰 페이지에서 제안하면 프리랜서 판매건수 들고 옴
	 */
	@Override
	public myProjectFreelancer selectMyProjectGrade(int memberNo) {
		return dao.selectMyProjectGrade(memberNo);
	}

	/**
	 *프로젝트 의뢰 페이지에서 제안하면 프리랜서 본인 정보
	 */
	@Override
	public myProjectFreelancer selectFreelancerInfo(int memberNo) {
		
		return  dao.selectFreelancerInfo(memberNo);
	}

	/**프로젝트 상세 페이지에서 제안하기 버튼(모달)
	 *
	 */
	@Override
	public String requestDetailSubmit(int requestNO, int proposalpriceInput, int proposaleditInput,
			int proposalMemberNo) {
		int result = dao.requestDetailSubmit(requestNO,proposalpriceInput,proposaleditInput,proposalMemberNo);
		String message = "";
		if(result>0) {
			message = "제안하기 등록되었습니다.";
		}else {
			message = "제안하기 등록되지 않았습니다.";
		}
		return message;
	}
}
