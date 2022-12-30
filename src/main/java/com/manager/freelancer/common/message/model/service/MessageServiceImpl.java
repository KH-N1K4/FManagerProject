package com.manager.freelancer.common.message.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.common.message.model.dao.MessageDAO;


@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageDAO dao;
}
