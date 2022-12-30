package com.manager.freelancer.common.message.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.freelancer.common.message.model.service.MessageService;
import com.manager.freelancer.member.model.vo.Member;


@Controller
public class MessageController {

	@Autowired
	private MessageService service;
	
	
	// 메세지창 이동
	@GetMapping("/member/message")
	public String myService(Model model, HttpSession session,
			RedirectAttributes ra,int clientNo,//clientNo 채팅 상대방
			@SessionAttribute("loginMember") Member loginMember
						) {
		
		// clientNo : 상대방 회원 번호
    	// loginMemberNo : 현재 로그인한 회원 번호
     
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        map.put("clientNo", clientNo);
        map.put("loginMemberNo", loginMember.getMemberNo());
        
        // 기존 채팅방이 있는지 확인
        //int chattingNo = service.checkChattingRoomNo(map); 
        
		/*
		 * if(chattingNo == 0) { // 기존 채팅방이 없다면
		 * 
		 * // 새로운 채팅방 생성 후 채팅방 번호 반환 chattingNo = service.createChattingRoom(map); }
		 * 
		 * ra.addFlashAttribute("chattingNo", chattingNo);
		 */
			
		return "common/message";
	}
	
	
	
}
