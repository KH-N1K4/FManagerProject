package com.manager.freelancer.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.freelancer.category.model.vo.AskService;
import com.manager.freelancer.category.model.vo.Service;
import com.manager.freelancer.member.model.service.MemberService;
import com.manager.freelancer.member.model.vo.Member;

@Controller
@SessionAttributes({"loginMember"})
public class MemberController {
	
	@Autowired
	private MemberService service;

	
	//회원가입 페이지 이동
	@GetMapping("/member/signUp")
	public String signUp() {
		return "member/signUp";
	}
	
	@PostMapping("/member/signUp")
	public String signUp(Member inputMember, 
			RedirectAttributes ra, 
			@RequestHeader(value="referer") String referer) {
		
		String path=null;
		String message=null;
		
		
		System.out.println(inputMember);
		
		
		int result=service.signUp(inputMember);
		
		if(result>0){ // 성공시 
			path="/";
			message="회원 가입 성공!";
		}else { // 실패시 
			path=referer;
			message="회원 가입 실패...";
			
			// 이전 페이지로 돌아갔을 때 입력했던 값을 같이 전달
			inputMember.setMemberPw(null); // 비밀번호 삭제 
			ra.addFlashAttribute("tempMember", inputMember);
		}
		
		ra.addFlashAttribute("message", message);
		

		return "redirect:"+path;
	}
	
	// 로그인 페이지 이동
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String login(Member inputMember,
						Model model,
						RedirectAttributes ra,
						@RequestParam(value="saveId", required=false) String saveId, // 체크박스 값 얻어오기 
						HttpServletResponse resp,  // 쿠키 전달용 
						@RequestHeader(value="referer") String referer // 요청 이전 주소 
						) {
		
		// 서비스 호출 후 결과 반환 받기 
		Member loginMember=service.login(inputMember);
	
		// 로그인 성공 시 세션에 아이디 추가
		// 로그인 실패시 "아이디 또는 비밀번호가 일치하지 않습니다." 세션에 추가 
		
		String path=null; // 리다이렉트 경로를 저장할 변수 
		
		if(loginMember!=null) {
			path="/"; // 메인페이지 주소 
			
			// 로그인 성공시 loginMember를 세션에 추가
			model.addAttribute("loginMember",loginMember);
			
			// **********************************************
			// 쿠키 생성
			
			Cookie cookie=new Cookie("saveId", loginMember.getMemberEmail());
			
			// 쿠키 유지 시간 지정 
			
			if(saveId!=null) { // 체크 되었을 때 
				
				// 1년동안 쿠키 유지 
				cookie.setMaxAge(60*60*24*365); 
				
			}else { // 체크 안되었을 때 
				
				// 0초 동안 쿠키 유지 -> 생성과 동시에 삭제 
				// --> 클라이언트의 쿠키 파일을 삭제 
				cookie.setMaxAge(0);
				
			}
			
			// 쿠키가 사용되는 경로 지정 
			cookie.setPath("/"); // localhost 밑에 모든 경로에서 사용
			
			// 생성된 쿠키를 응답 객체에 담아서 클라이언트에게 전달 
			resp.addCookie(cookie);
			
			
			// **********************************************
			
			
			
		}else {
			path=referer; // 로그인 요청 전 페이지 주소(referer)
			
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다");
		}
		
		return "redirect:"+path;
	}
	
	
	// 로그아웃 
	@GetMapping("/member/logout")
	public String logout(SessionStatus status) {
		
		// 왜? @SessionAttributes로 session scope에 등록된 값을 무효화 시키려면 
		// SessionStatus라는 별도의 객체를 이용해야 한다. 
		
		status.setComplete();

		
		return "redirect:/";
	}
	
	
	
	// 마이페이지 이동
	@GetMapping("/member/myInfo")
	public String myInfo() {
		return "member/myInfo";
	}
	
	
	
	@PostMapping("/member/myInfo/updateMyInfo")
	public String updateProfile(Member inputMember, // input값 
			@RequestParam(value="profileImage") MultipartFile profileImage, // 업로드된 파일 
			@SessionAttribute("loginMember") Member loginMember, // 회원번호 필요
			RedirectAttributes ra, // 메세지 전달용
			HttpServletRequest req // 저장할 서버 경로 
			) throws Exception {
		

		int result=0;
		inputMember.setMemberNo(loginMember.getMemberNo());
		
		if(!inputMember.getMemberInterest().equals(loginMember.getMemberInterest())){ // 관심사가 변경된 경우 
			result=service.updateInterest(inputMember);
		}
		
		if(profileImage.getSize()>0) { // 변경된 사진이 있는 경우
			
			// 업로드된 이미지를 프로젝트 폴더 내부에 저장하는 방법 
			// 1) server -> 지정된 서버 설정 -> Server modules without publishing 체크
			// 2) 파일을 저장할 폴더 생성 
			// 3) HttpServletResponse를 이용해서 저장 폴더 절대 경로 얻어오기 
			// 4) MultipartFile.transferTo()를 이용해서 지정도니 경로에 파일 저장 
			
			// 인터넷 주소로 접근할 수 있는 경로 
			String webPath="/resources/images/memberProfile/";
			
			// 실제 파일이 저장된 컴퓨터 상의 절대 경로 
			String filePath=req.getSession().getServletContext().getRealPath(webPath);
			
			
			
			
			//int result=service.updateProfile(webPath, filePath, memberProfile, loginMember);
			result=service.updateMyInfo(webPath, filePath, profileImage, inputMember);
			
		}else { // 프로필 사진 변경 안한 경우
			
			result=service.updateMyInfoNonPhoto(inputMember);
		}
		
		
		String message=null;
		if(result>0) {
			message="내 정보가 수정되었습니다. ";
			
			// DB - session 동기화 
			if(profileImage.getSize()>0) {
				loginMember.setMemberProfile(inputMember.getMemberProfile());
				
			}
			loginMember.setMemberNickname(inputMember.getMemberNickname());
			loginMember.setMemberTel(inputMember.getMemberTel());
			loginMember.setMemberJob(inputMember.getMemberJob());
			loginMember.setMemberInterest(inputMember.getMemberInterest());
		}
		else		 {
			message="내 정보 수정 실패 ";
		}
		
		ra.addFlashAttribute("message",message);
		
		return "redirect:/member/myInfo";
	}
	
	
	
	
	
	// 비밀번호 변경  이동
	@GetMapping("/member/myInfo/changePw")
	public String changePw() {
		return "member/changePw";
	}
	
	
	@PostMapping("/member/myInfo/changePw")
	public String changePw(
			@SessionAttribute("loginMember") Member loginMember,
			@RequestParam Map<String, Object> paramMap,
			RedirectAttributes ra
			) {
		// @RequestParam Map<String, Object> paramMap
		// - 모든 파라미터를 맵 형식으로 얻어와 저장 
		
		// 1. loginMember에서 회원번호를 얻어와 paramMap에 추가 
		paramMap.put("memberNo", loginMember.getMemberNo());
		
		// 2. 서비스 호출 후 결과 반환 받기 
		int result=service.changePw(paramMap);
		
		String path=null;
		String message=null;
		
		if(result>0) {
			path="/member/myInfo";
			message="비밀번호가 변경되었습니다.";
		}else {
			path="changePw";
			message="현재 비밀번호가 일치하지 않습니다. ";
		}
		
		ra.addFlashAttribute("message",message);
		
		return "redirect:"+path;
	}
	
	// 회원 탈퇴 이동
	@GetMapping("/member/myInfo/deleteMember")
	public String deleteMember() {
		return "member/deleteMember";
	}
	
	// 회원 탈퇴
	@PostMapping("/member/myInfo/deleteMember")
	public String deleteMember(String memberEmail, String memberPw,@SessionAttribute("loginMember") Member loginMember,RedirectAttributes ra, SessionStatus status) {
		
		int result=0;
		String message;
		String path;
		
		if(loginMember.getMemberEmail().equals(memberEmail)) {
			result=service.deleteMember(loginMember.getMemberNo(),memberPw);
			
			if(result>0) {
				message="탈퇴 되었습니다..";
				status.setComplete(); // 로그아웃 코드 추가 
				
			}else {
				message="탈퇴 실패";
			}
		}else {
			message="이메일이 일치하지 않습니다. ";
		}
		
		
		path="/";
		
		
		
		ra.addFlashAttribute("message",message);
		
		
		return "redirect:"+path;
	}
	
	// 찜목록 이동
	@GetMapping("/member/myInfo/likeList")
	public String likeList(@SessionAttribute("loginMember") Member loginMember, Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp,
			@RequestParam(value = "category", required = false, defaultValue = "0") int category) {
		
		System.out.println(category);
		Map<String, Object> map =service.selectLikeList(loginMember.getMemberNo(),cp,category);
		
		model.addAttribute("map",map);
		model.addAttribute("category",category);
		
		return "member/likeList";
	}
	
	//찜 select ajax
	@GetMapping("/member/myInfo/likeList/type")
	@ResponseBody
	public Map<String, Object> likeListType(@SessionAttribute("loginMember") Member loginMember, Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp,
			@RequestParam(value = "category", required = false, defaultValue = "0") int category) {
		
		Map<String, Object> map =service.selectLikeListType(loginMember.getMemberNo(),cp,category);
		
		
		return map;
	}
	
	
	
	
	// 내가 보낸 제안 보기
	@GetMapping("/member/myInfo/sendServiceInquiry")
	public String sendSuggestion(@SessionAttribute("loginMember") Member loginMember, Model model,
			@RequestParam(value="cp" , required = false, defaultValue = "1") int cp,
			@RequestParam(value="type" , required = false, defaultValue = "0") int type,
			@RequestParam(value="searchDate1" , required = false, defaultValue = "") String searchDate1,
			@RequestParam(value="searchDate2" , required = false, defaultValue = "") String searchDate2) {
		
		int loginMemberNo = loginMember.getMemberNo();
		
		Map<String, Object> option = new HashMap<String, Object>();
		option.put("loginMemberNo", loginMemberNo);
		option.put("type", type);
		option.put("searchDate1", searchDate1);
		option.put("searchDate2", searchDate2);
		
		Map<String, Object> map =service.selectSendServiceInquiry(option,cp);
		
		model.addAttribute("map",map);
		model.addAttribute("type", type);
		model.addAttribute("searchDate1", searchDate1);
		model.addAttribute("searchDate2", searchDate2);
		
		return "member/sendSuggestion";
	}
	
	@GetMapping("/member/myInfo/sendSuggestionContent")
	@ResponseBody
	public AskService sendSuggestionContent(String serviceInquiryNo) {
		
		AskService askView=service.selectSendSuggesionContent(serviceInquiryNo);
		
		
		return askView;
	}

	
	
}
