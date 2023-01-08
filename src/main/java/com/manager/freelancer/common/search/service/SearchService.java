package com.manager.freelancer.common.search.service;

import java.util.List;
import java.util.Map;

import com.manager.freelancer.myProject.model.vo.FreelancerService;

public interface SearchService {

	/**추천 검색어
	 * @param keyword 
	 * @return
	 */
	List<FreelancerService> searchInput(String keyword);

	/**검색했을 때 출력되는 서비스 목록
	 * @param map
	 * @return
	 */
	Map<String, Object> searchService(Map<String, Object> map);

}
