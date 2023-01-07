package com.manager.freelancer.common.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.common.search.dao.SearchDAO;
import com.manager.freelancer.myProject.model.vo.FreelancerService;

@Service
public class SearchServiceImpl implements SearchService{
	@Autowired
	private SearchDAO dao;

	@Override
	public List<FreelancerService> searchInput(String keyword) {
		
		return dao.searchInput(keyword);
	}
}
