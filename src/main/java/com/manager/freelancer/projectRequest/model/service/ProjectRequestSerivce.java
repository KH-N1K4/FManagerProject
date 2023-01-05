package com.manager.freelancer.projectRequest.model.service;

import java.util.List;
import java.util.Map;

import com.manager.freelancer.myProject.model.vo.myProjectFreelancerRequest;

public interface ProjectRequestSerivce {

	/**프로젝트 목록 조회
	 * @param cp
	 * @param mainCategoryNo
	 * @param subCategoryNo
	 * @param thirdCategoryNo
	 * @return
	 */
	Map<String, Object> getCategotyList(int cp, int mainCategoryNo, int subCategoryNo, int thirdCategoryNo);

	/**프로젝트 의뢰 상세보기
	 * @param serviceNo
	 * @return
	 */
	myProjectFreelancerRequest selectUserRequest(int projectRequestNo);

}
