package com.manager.freelancer.projectRequest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.myProject.model.vo.myProjectFreelancerRequest;
import com.manager.freelancer.projectRequest.model.dao.ProjectRequestDAO;



@Service
public class ProjectRequestServiceImpl implements ProjectRequestSerivce{
	
	@Autowired
	private ProjectRequestDAO dao;

	@Override
	public List<myProjectFreelancerRequest> getCategotyList() {
		
		return dao.getCategotyList();
	}
}
