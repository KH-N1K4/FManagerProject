package com.manager.freelancer.common.search.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.google.gson.Gson;
import com.manager.freelancer.common.search.service.SearchService;
import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.vo.FreelancerService;

@Controller
public class SearchController {
	@Autowired
	private SearchService service;
	
	/**추천 검색어 들고 오기
	 * @param keyword
	 * @return
	 */
	@GetMapping("/common/searchInput")
	@ResponseBody
	public String searchInput(
			@RequestParam(value="keyword",required=false, defaultValue="")String keyword) {
		List<FreelancerService> searchInput = service.searchInput(keyword);

		return new Gson().toJson(searchInput);
	}
	
	//   /searchService
	/**검색했을 때 출력되는 서비스 목록
	 * @param model
	 * @param cp
	 * @param loginMember
	 * @param searchInput
	 * @return
	 */
	@GetMapping("/searchService")
	public String searchService(Model model,@RequestParam(value="cp", required=false, defaultValue="1") int cp,
				@SessionAttribute(value="loginMember",required=false) Member loginMember,
				@RequestParam(value="searchInput",required=false) String searchInput
				) {
			
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		map.put("cp", cp);
		map.put("searchInput", searchInput);
		if(loginMember!=null) {
			map.put("memberNo", loginMember.getMemberNo());
		}
			
		resultMap=service.searchService(map);

		model.addAttribute("resultMap", resultMap);
		model.addAttribute("searchInput", searchInput);
			
		return "common/searchServiceList";
	}
}
