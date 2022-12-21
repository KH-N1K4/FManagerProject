package chatting.controller;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import chatting.model.service.ChattingService;
import chatting.model.vo.ChattingRoom;

@Controller
public class ChattingController {
	
	@Autowired
	private ChattingService service;
	
	// 채팅방 입장
    @GetMapping("/chatting/enter")
    public String chattingEnter(int targetNo, RedirectAttributes ra,
            @SessionAttribute("loginMember") Member loginMember) {
     
    	// targetNo : 상대방 회원 번호
    	// loginMember : 현재 로그인한 회원 번호
    	
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        map.put("targetNo", targetNo);
//        map.put("loginMemberNo", loginMember.getMemberNo());
        
        // 기존 채팅방이 있는지 확인
        int chattingNo = service.checkChattingNo(map); 
        
        // 기존 채팅방이 없다면 새로운 채팅방 생성 후 채팅방 번호 반환
        if(chattingNo == 0) {
            chattingNo = service.createChattingRoom(map);
        }
        
        ra.addFlashAttribute("chattingNo", chattingNo);
        System.out.println(chattingNo);
        
        return "redirect:/chatting";
    }
    
      // 채팅 화면
//    @GetMapping("/chatting")
//    public String chatting(@SessionAttribute("loginMember") Member loginMember, Model model) {
//        
//        List<ChattingRoom> roomList = service.selectRoomList(loginMember.getMemberNo());
//        model.addAttribute("roomList", roomList);
//        return "chatting/chatting";
//    }

}
