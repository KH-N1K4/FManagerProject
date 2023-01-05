package com.manager.freelancer.myProject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.service.MyProjectService_2;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.myProject.model.vo.myProjectTrade;

@Controller
@SessionAttributes({"loginMember"})
public class MyProjectController_2 {
	
	@Autowired
	private MyProjectService_2 service;
	
	// 결제내역이동
	@GetMapping("/member/myProject/paymentList")
	public String paymentList(Model model, @SessionAttribute("loginMember") Member loginMember,
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
		
		Map<String, Object> resultMap = service.selectPaymentList(option,cp);
		
		model.addAttribute("resultMap", resultMap);
		model.addAttribute("type", type);
		model.addAttribute("searchDate1", searchDate1);
		model.addAttribute("searchDate2", searchDate2);
		
		return "myProject/paymentList";
	}
	
	// 구매 관리 이동
	@GetMapping("/member/myProject/myPurchaseList")
	public String purchaseList(Model model, @SessionAttribute("loginMember") Member loginMember,
			@RequestParam(value="cp" , required = false, defaultValue = "1") int cp,
			@RequestParam(value="searchInput",required=false, defaultValue = "") String searchInput,
			@RequestParam(value="type" , required = false, defaultValue = "0") int type,
			@RequestParam(value="searchDate1" , required = false, defaultValue = "") String searchDate1,
			@RequestParam(value="searchDate2" , required = false, defaultValue = "") String searchDate2) {
		
		List<FreelancerService> maincategoryList = service.selectmaincategoryList();
		
		model.addAttribute("maincategoryList",maincategoryList);
		model.addAttribute("mainCategoryNoInput",type);
		
		int loginMemberNo = loginMember.getMemberNo();
		Map<String, Object> option = new HashMap<String, Object>();
		option.put("loginMemberNo", loginMemberNo);
		option.put("type", type);
		option.put("searchDate1", searchDate1);
		option.put("searchDate2", searchDate2);
		option.put("searchInput", searchInput);
		
		Map<String, Object> resultMap = service.selectPurchaseList(option, cp);
		
		model.addAttribute("resultMap",resultMap);
		model.addAttribute("type", type);
		model.addAttribute("searchDate1", searchDate1);
		model.addAttribute("searchDate2", searchDate2);
		model.addAttribute("searchInput", searchInput);
		
		
		return "myProject/myPurchaseList";
	}
	
	// 회원 작업 완료 버튼 누르면
	@GetMapping("/myProject/memberDone/{tradeNo}")
	@ResponseBody
	public String memberDone(Model model, @SessionAttribute("loginMember") Member loginMember,
			@RequestParam(value="cp" , required = false, defaultValue = "1") int cp,
			@RequestParam(value="searchInput",required=false, defaultValue = "") String searchInput,
			@RequestParam(value="type" , required = false, defaultValue = "0") int type,
			@RequestParam(value="searchDate1" , required = false, defaultValue = "") String searchDate1,
			@RequestParam(value="searchDate2" , required = false, defaultValue = "") String searchDate2,
			@RequestParam int tradeNo) {
		
		int result = service.memberDone(tradeNo);
		
		if(result>0) {
			List<FreelancerService> maincategoryList = service.selectmaincategoryList();
			
			model.addAttribute("maincategoryList",maincategoryList);
			model.addAttribute("mainCategoryNoInput",type);
			
			int loginMemberNo = loginMember.getMemberNo();
			Map<String, Object> option = new HashMap<String, Object>();
			option.put("loginMemberNo", loginMemberNo);
			option.put("type", type);
			option.put("searchDate1", searchDate1);
			option.put("searchDate2", searchDate2);
			option.put("searchInput", searchInput);
			
			Map<String, Object> resultMap = service.selectPurchaseList(option, cp);
			
		}
		
		return "redirect:";
	}
	
	
	
	
	
	
	

}
