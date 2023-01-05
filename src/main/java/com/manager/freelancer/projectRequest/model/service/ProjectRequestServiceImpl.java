package com.manager.freelancer.projectRequest.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.myProject.model.vo.myProjectFreelancerRequest;
import com.manager.freelancer.projectRequest.model.dao.ProjectRequestDAO;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancerRequest;


@Service
public class ProjectRequestServiceImpl implements ProjectRequestSerivce{
	
	@Autowired
	private ProjectRequestDAO dao;

	@Override
	public Map<String, Object> getCategotyList() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		 
		List<myProjectFreelancerRequest> categotyList = dao.getCategotyList();
		List<myProjectFreelancerRequest> subCategotyList = dao.getSubCategotyList();
		List<myProjectFreelancerRequest> mainCategotyList = dao.getMainCategotyList();
		
		map.put("categotyList",categotyList);
		map.put("subCategotyList",subCategotyList);
		map.put("mainCategotyList",mainCategotyList);
		return map;
	}
}
