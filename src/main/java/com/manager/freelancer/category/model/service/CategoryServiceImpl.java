package com.manager.freelancer.category.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.manager.freelancer.category.model.dao.CategoryDAO;
import com.manager.freelancer.category.model.vo.AskService;
import com.manager.freelancer.category.model.vo.Service;
import com.manager.freelancer.category.model.vo.Trade;
import com.manager.freelancer.manager.model.vo.Pagination;

@org.springframework.stereotype.Service
public class CategoryServiceImpl implements CategoryService{
	
	
	@Autowired
	private CategoryDAO dao;

	@Override
	public List<Map<String, Object>> selectMainCategoryList() {
		return dao.selectMainCategoryList();
	}

	@Override
	public List<Map<String, Object>> selectSubCategoryList() {
		return dao.selectSubCategoryList();
	}

	@Override
	public List<Map<String, Object>> selectThirdCategoryList() {
		return dao.selectThirdCategoryList();
	}

	@Override
	public Service viewService(int serviceNo) {
		return dao.viewService(serviceNo);
	}

	@Override
	public int askService(AskService as) {
		return dao.askService(as);
	}

	@Override
	public int pauseService(int serviceNo) {
		return dao.pauseService(serviceNo);
	}


	public int serviceLikeCheck(Map<String, Object> map) {
		return dao.serviceLikeCheck(map);
	}

	@Override
	public int boardLikeUp(Map<String, Object> paramMap) {
		return dao.boardLikeUp(paramMap);
	}

	@Override
	public int boardLikeDown(Map<String, Object> paramMap) {
		return dao.boardLikeDown(paramMap);
	}

	@Override
	public List<Service> selectCategoryList(Map map) {
		
		return dao.selectCategoryList(map);
	}

	@Override
	public Map serviceList(Map<String, Integer> map) {
		
		// 1. 특정 게시판의 전체 게시글 수 조회(단, 삭제 제외)
		int listCount=dao.getListCount(map);
		
		// 2. 전체 게시글 수 + cp(현재 페이지)를 이용해서 
		// 페이징 처리 객체 생성 
		Pagination pagination =new Pagination(listCount, map.get("cp"));
		
		// 3. 페이징 처리 객체를 이용해서 게시글 목록 조회
		List<Service> serviceList=dao.serviceList(pagination,map);
		
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("pagination", pagination);
		resultMap.put("serviceList",serviceList);
		//System.out.println(serviceList);
		
		return resultMap;
	}
	
	
	@Override
	public Map selectBoardList(Map<String, Integer> map) {
		
		// 1. 특정 게시판의 전체 게시글 수 조회(단, 삭제 제외)
		int listCount=dao.getListCount(map);
		
		// 2. 전체 게시글 수 + cp(현재 페이지)를 이용해서 
		// 페이징 처리 객체 생성 
		Pagination pagination =new Pagination(listCount, map.get("cp"));
		
		// 3. 페이징 처리 객체를 이용해서 게시글 목록 조회
		List<Service> serviceList=dao.selectBoardList(map,pagination);
		
		Map<String, Object> boardListmap=new HashMap<String, Object>();
		boardListmap.put("pagination", pagination);
		boardListmap.put("serviceList",serviceList);
		System.out.println(serviceList);
		
		return boardListmap;
		
		
	}

	@Override
	public int tradeComplete(Trade temp) {
		return dao.tradeComplete(temp);
	}

	

}
