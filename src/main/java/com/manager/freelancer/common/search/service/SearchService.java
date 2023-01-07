package com.manager.freelancer.common.search.service;

import java.util.List;

import com.manager.freelancer.myProject.model.vo.FreelancerService;

public interface SearchService {

	/**추천 검색어
	 * @param keyword 
	 * @return
	 */
	List<FreelancerService> searchInput(String keyword);

}
