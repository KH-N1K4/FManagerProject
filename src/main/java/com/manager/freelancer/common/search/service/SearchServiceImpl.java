package com.manager.freelancer.common.search.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.common.search.dao.SearchDAO;
import com.manager.freelancer.manager.model.vo.Pagination;
import com.manager.freelancer.myProject.model.vo.FreelancerService;

@Service
public class SearchServiceImpl implements SearchService{
	@Autowired
	private SearchDAO dao;

	@Override
	public List<FreelancerService> searchInput(String keyword) {
		
		return dao.searchInput(keyword);
	}

	@Override
	public Map<String, Object> searchService(Map<String, Object> map) {
		// 1. 특정 게시판의 전체 게시글 수 조회(단, 삭제 제외)
		int listCount=dao.getSearchServiceCount(map);
				
		// 2. 전체 게시글 수 + cp(현재 페이지)를 이용해서 
		// 페이징 처리 객체 생성 
		Pagination pagination =new Pagination(listCount, (int) map.get("cp"));
				
		// 3. 페이징 처리 객체를 이용해서 게시글 목록 조회
		List<Service> serviceList=dao.selectSearchServiceList(pagination,map);
				
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("pagination", pagination);
		resultMap.put("serviceList",serviceList);
		
		return resultMap;
	}
}
