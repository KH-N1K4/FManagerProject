package com.manager.freelancer.common.message.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.manager.freelancer.common.message.model.service.MessageService;


@Controller
public class MessageController {

	@Autowired
	private MessageService service;
	
	
	// 메세지창 이동
	@GetMapping("/member/message")
	public String myService(Model model, HttpSession session
						) {
			
			return "common/message";
	}
}
