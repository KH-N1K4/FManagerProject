package com.manager.freelancer.myProject.model.service;

import java.util.List;
import java.util.Map;

import com.manager.freelancer.myProject.model.vo.MyProject;

public interface MyProjectSerive {

	/** 메인 카테고리 들고오기
	 * @return
	 */
	List<MyProject> selectmaincategoryList();

	/** 내 프로젝트 들고오기 + 페이징 처리 
	 * @param memberNo
	 * @param mainCategoryNo
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectMyProject(int memberNo, int mainCategoryNo, int cp);

}
