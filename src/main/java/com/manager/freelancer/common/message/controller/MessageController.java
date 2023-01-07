package com.manager.freelancer.common.message.controller;

import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.manager.freelancer.common.Util;
import com.manager.freelancer.common.message.model.service.MessageService;
import com.manager.freelancer.common.message.model.vo.ChattingRoom;
import com.manager.freelancer.common.message.model.vo.Message;
import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.vo.FreelancerService;


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
        
        String pattern = ".+.(jpg|png|gif|bmp|JPG|PNG|BMP|GIF|jfif)"; // 이미지
        String patternFile = ".+.(xls|xlsx|txt|html|htm|pdf|mp4|mpeg|mpg|avi|pptx|hwp|docx|doc|ppt)"; //파일 업로드
        for(int i = 0; i < roomList.size(); i++) {
        	
        	if(roomList.get(i).getLastMessage() != null) {
        		if(Pattern.matches(pattern, roomList.get(i).getLastMessage())) {
            		roomList.get(i).setLastMessage("사진");
            	}
            	if(Pattern.matches(patternFile, roomList.get(i).getLastMessage())) {
            		roomList.get(i).setLastMessage("파일");
            	}
        	}
        	
        }
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
        String pattern = ".+.(jpg|png|gif|bmp|JPG|PNG|BMP|GIF|jfif)"; // 이미지
        String patternFile = ".+.(xls|xlsx|txt|html|htm|pdf|mp4|mpeg|mpg|avi|pptx|hwp|docx|doc|ppt)"; //파일 업로드
        for(int i = 0; i < roomList.size(); i++) {
        	
        	if(roomList.get(i).getLastMessage() != null) {
        		if(Pattern.matches(pattern, roomList.get(i).getLastMessage())) {
            		roomList.get(i).setLastMessage("사진");
            	}
            	if(Pattern.matches(patternFile, roomList.get(i).getLastMessage())) {
            		roomList.get(i).setLastMessage("파일");
            	}
        	}
        	
        }
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
    
    @PostMapping("/chatting/updatefiles")
	@ResponseBody
	public String updatefiles(
			MultipartHttpServletRequest formData,
			HttpServletRequest req, /* 저장할 서버 경로 */
			HttpSession session) throws Exception {
			
			// 인터넷 주소로 접근할 수 있는 경로
			String webPath = "/resources/files/common/";
					
			// 실제 파일이 저장된 컴퓨터 상의 절대 경로
			String filePath = req.getSession().getServletContext().getRealPath(webPath);
			
			Map<String, Object> resurt = new HashMap<String, Object>();						
			MultipartFile file = formData.getFile("img0");
			String rename = null;
			String reportFilePath = null;
			if(file != null) { 
				rename = Util.fileRename( file.getOriginalFilename() );
				reportFilePath = (webPath + rename);
				
				file.transferTo(new File(filePath +  rename));
			}
			
		
			return new Gson().toJson(reportFilePath);
	}
    
    
    
    @GetMapping("/member/message/chatting/report")
    public String messageReportModal() {
        return "common/modaless/messageReportModal";
    }
	
}
