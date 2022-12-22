package com.manager.freelancer.member.model.service;

public interface AjaxService {
	
	int emailDupCheck(String memberEmail);


	int nicknameDupCheck(String memberNickname);

}
