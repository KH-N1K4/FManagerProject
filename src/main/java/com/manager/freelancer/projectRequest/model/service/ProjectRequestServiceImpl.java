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
	public Map<String, Object> getCategotyList(int cp, int mainCategoryNo, int subCategoryNo, int thirdCategoryNo, int budgetInt0, int budgetInt1, int listOrder) {
		int listCount = dao.getProjectRequestListCount(mainCategoryNo,subCategoryNo,thirdCategoryNo,budgetInt0,budgetInt1,listOrder);
		
		Pagination pagination = new Pagination(listCount,cp,20,10);
		
		Map<String, Object> map = new HashMap<String, Object>();
		 
		List<myProjectFreelancerRequest> categoryList = dao.getCategoryList();
		List<myProjectFreelancerRequest> subCategoryList = dao.getSubCategoryList();
		List<myProjectFreelancerRequest> mainCategoryList = dao.getMainCategoryList();
		List<myProjectFreelancerRequest> projectRequestList = dao.getProjectRequestList(pagination,mainCategoryNo,subCategoryNo,thirdCategoryNo,budgetInt0,budgetInt1,listOrder);
		
		map.put("categoryList",categoryList);
		map.put("subCategoryList",subCategoryList);
		map.put("mainCategoryList",mainCategoryList);
		map.put("projectRequestList",projectRequestList);
		map.put("pagination",pagination);
		map.put("listCount",listCount);
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

	/**
	 *프로젝트 상세 페이지에서 판매중지
	 */
	@Override
	public String requestStopSubmit(int requestNO) {
		int result = dao.requestStopSubmit(requestNO);
		String message = "";
		if(result>0) {
			message = "내 의뢰 내리기가 완료되었습니다.";
		}else {
			message = "내 의뢰 내리기가 실패했습니다.";
		}
		return message;
	}

	/**
	 *모집 마감입박순 /최신순
	 */
	@Override
	public Map<String, Object> listOrderSelect(int listOrder, int mainCategoryNo, int subCategoryNo, int thirdCategoryNo,int cp,int budgetInt0, int budgetInt1) {
		int listCount = dao.listOrderSelectCount(listOrder,mainCategoryNo,subCategoryNo,thirdCategoryNo, budgetInt0, budgetInt1);
		
		Pagination pagination = new Pagination(listCount,cp,20,10);
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<myProjectFreelancerRequest> resultList = dao.listOrderSelect(pagination,mainCategoryNo,subCategoryNo,thirdCategoryNo,listOrder, budgetInt0, budgetInt1);
		
		map.put("resultList",resultList);
		map.put("pagination",pagination);
		map.put("listCount",listCount);
		return map;
	}
}
