package com.manager.freelancer.projectRequest.model.service;

import java.util.List;
import java.util.Map;

import com.manager.freelancer.myProject.model.vo.myProjectFreelancerRequest;

public interface ProjectRequestSerivce {

	Map<String, Object> getCategotyList(int cp, int mainCategotyNo, int subCategoryNo, int thirdCategotyNo);

}
