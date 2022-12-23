package com.manager.freelancer.myProject.model.service;

import java.util.List;

import com.manager.freelancer.myProject.model.vo.FreelancerService;

public interface MyProjectFreelancerService {

	List<FreelancerService> selectmaincategoryList();

	List<FreelancerService> selectcategoryList();

}
