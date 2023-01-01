package com.manager.freelancer.common.message.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.manager.freelancer.common.message.model.service.MessageService;
import com.manager.freelancer.common.message.model.vo.ChattingRoom;
import com.manager.freelancer.common.message.model.vo.Message;
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
        ChattingRoom chartRoom = service.checkChattingRoomNo(map); 
        
        int chatRoomNo = chartRoom.getChatRoomNo();
        
		if(chatRoomNo == 0) { // 기존 채팅방이 없다면
			// 새로운 채팅방 생성 후 채팅방 번호 반환 
			chatRoomNo = service.createChattingRoom(map); 
		}else {
			
			 ChattingRoom chartRoom2 = service.delectFLRoomNo(map);
		     String chatRoomMemDelFL = chartRoom2.getChatRoomDelFL();//채팅방 들어갈때 나기기 여부가 Y인지 조회
		     int chatRoomNo2 = chartRoom2.getChatRoomNo();
		     if(chatRoomMemDelFL.equals("Y") && chatRoomNo2 != 0) {
				int result = service.updateChattingRoom(chartRoom2);//채팅방 나가기 여부가 Y이면 N로 변경
				if(result>0) {
					System.out.println("업데이트 성공");
				}else {
					System.out.println("업데이트 실패");
				}
			}
		}
		
		
		  
		ra.addFlashAttribute("chatRoomNo", chatRoomNo);
		
			
		return "redirect:/member/message/chatting";
	}
	
	@GetMapping("/member/message/chatting")
    public String chatting(@SessionAttribute("loginMember") Member loginMember, Model model) {
        
        List<ChattingRoom> roomList = service.selectRoomList(loginMember.getMemberNo());
        model.addAttribute("roomList", roomList);
        return "common/message";
    }
	
    @GetMapping("/chatting/selectMessage")
    @ResponseBody
    public String selectMessageList(@RequestParam Map<String, Object> paramMap,@SessionAttribute("loginMember") Member loginMember) {
        System.out.println(paramMap);
        List<Message> messageList = service.selectMessageList(paramMap,loginMember.getMemberNo());
        return new Gson().toJson(messageList);
    }
    
    
    @GetMapping("/chatting/roomList")
    @ResponseBody
    public String selectRoomList(int memberNo) {
        
        List<ChattingRoom> roomList = service.selectRoomList(memberNo);
        return new Gson().toJson(roomList);
    }
    
    @GetMapping("/chatting/updateReadFlag")
    @ResponseBody
    public int updateReadFlag(@RequestParam Map<String, Object> paramMap) {
        return service.updateReadFlag(paramMap);
    }
    
    @GetMapping("/chatting/updateOutFL")
    @ResponseBody
    public int updateOutFL(@RequestParam Map<String, Object> paramMap) {
        return service.updateOutFL(paramMap);
    }
	
	
}
