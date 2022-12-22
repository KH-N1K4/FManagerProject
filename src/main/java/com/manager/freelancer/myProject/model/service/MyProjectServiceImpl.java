package com.manager.freelancer.myProject.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.myProject.model.dao.MyProjectDAO;


@Service
public class MyProjectServiceImpl implements MyProjectSerive{
	
	@Autowired
	private MyProjectDAO dao;

}
