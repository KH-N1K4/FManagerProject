package com.manager.freelancer.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.manager.model.service.ManagerInquiryService;
import com.manager.freelancer.member.model.vo.Member;

@SessionAttributes({"loginMember"})
@Controller
public class ManagerInquiryController {

	@Autowired
	private ManagerInquiryService service;
	
	// 관리자 페이지 이용문의 목록 조회
	@GetMapping("/manager/managerInquiryList")
	public String managerInquiryList(@RequestParam(value="cp", required=false, defaultValue = "1") int cp,
								     @RequestParam Map<String,Object> pm, Model model) {
		
		
		if(pm.get("key") == null) {
			
			Map<String, Object> map = service.selectManagerInquiryList(cp);
			model.addAttribute("map",map);
		} else {
			Map<String, Object> map = service.selectManagerInquiryList(pm, cp);
			model.addAttribute("map",map);
		}
		
		return "/manager/managerInquiryList";
	}
	
	// 관리자 페이지 이용문의 내역 상세 조회 
	@GetMapping("/managerInquiryDetail/{userInquiryNo}")
	public String viewInquiryDetail(@PathVariable(value="userInquiryNo") int userInquiryNo, Model model,
									@SessionAttribute("loginMember") Member loginMember) {
		
		UserInquiry managerInquiry = service.viewInquiryDetail(userInquiryNo);
		
		managerInquiry.setUserInquiryNo(userInquiryNo);
		
		
		
		
		model.addAttribute("managerInquiry",managerInquiry);
		model.addAttribute("loginMember",loginMember);
		
		
		return "/manager/managerInquiryDetail";
	}
	
	
	// 관리자 페이지 이용 문의 내역 답글 삽입
	@PostMapping("/managerInquiryDetail")
	@ResponseBody
	public String updateComment(@RequestParam(value="userInquiryNo") int userInquiryNo,
								@RequestParam(value="inputComment") String inputComment,
								@SessionAttribute("loginMember") Member loginMember) {
		
		int result = service.updateComment(userInquiryNo, inputComment,loginMember);

		return new Gson().toJson(result);
	}
	
	// 진행 상태 별 조회 ajax
	@GetMapping("/manager/inquiryStatus")
	@ResponseBody
	public Map<String, Object> managerServiceType(Model model,
			@RequestParam String value,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> map = new HashMap<String, Object>();

		map = service.selectInquiryStatusList(value, cp);
		model.addAttribute("map", map);

		return map;
	}
	

}
