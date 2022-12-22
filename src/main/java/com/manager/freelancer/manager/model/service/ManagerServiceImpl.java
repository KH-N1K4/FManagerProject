package com.manager.freelancer.manager.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.manager.model.dao.ManagerDAO;
import com.manager.freelancer.manager.model.vo.Member;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ManagerDAO dao;
	
	@Override
	public List<Member> selectMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

}
