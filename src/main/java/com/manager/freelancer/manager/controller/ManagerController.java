package com.manager.freelancer.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.freelancer.manager.model.service.ManagerService;
import com.manager.freelancer.manager.model.vo.Member;
import com.manager.freelancer.manager.model.vo.TradeInfo;

@Controller
public class ManagerController {

	@Autowired
	private ManagerService service;

	@GetMapping("/manager/main")
	public String managerMain() {
		return "";
	}

	// 회원 관리 - 회원 목록 조회
	@GetMapping("/manager/memberList")
	public String managerMemberList(Model model, @RequestParam(value = "value", required = false) String value,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp,
			@RequestParam Map<String, Object> pm) {

		if (pm.get("key") == null) {
			Map<String, Object> map = service.selectMemberList(value, cp);
			model.addAttribute("map", map);
		} else {
			System.out.println(value);
			pm.put("value2", value);
			Map<String, Object> map = service.selectMemberList(pm, cp);
			model.addAttribute("map", map);
		}

		return "/manager/memberList";
	}

	// 회원 상세조회
	@GetMapping("/manager/memberDetail")
	@ResponseBody
	public Member managerMemberDetail(@RequestParam int memberNo) {

		Member member = service.selectMemberDetail(memberNo);

		return member;
	}

	// 회원 유형별 목록 조회 ajax
	@GetMapping("/manager/memberType")
	@ResponseBody
	public Map<String, Object> managerMemberType(Model model, @RequestParam String value,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(value);

		map = service.selectMemberTypeList(value, cp);
		model.addAttribute("map", map);
		
		return map;
	}

	// 회원 탈퇴
	@GetMapping("/manager/memberDelete")
	@ResponseBody
	public int managerMemberDelete(@RequestParam int memberNo) {

		System.out.println(memberNo);

		int result = service.managerMemberDelete(memberNo);

		return result;
	}

	// ======================================================================================

	// 서비스 등록 내역 관리
	@GetMapping("/manager/serviceList")
	public String managerServiceList(Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> map = service.selectServiceList(cp);
		model.addAttribute("map", map);

		return "/manager/serviceList";
	}

	// 서비스 상태별 목록 조회 ajax
	@GetMapping("/manager/serviceType")
	@ResponseBody
	public Map<String, Object> managerServiceType(Model model,
			@RequestParam(value = "status", required = false) int status,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(status);

		map = service.selectServiceTypeList(status, cp);
		model.addAttribute("map", map);
		System.out.println(map);

		return map;
	}

	// 서비스 삭제
	@GetMapping("/manager/serviceDelete")
	@ResponseBody
	public int managerServiceDelete(@RequestParam int serviceNo) {

		System.out.println(serviceNo);

		int result = service.managerServiceDelete(serviceNo);

		return result;
	}

	// ======================================================================================

	// 계좌 관리
	@GetMapping("/manager/tradeList")
	public String managerTradeList(Model model,
			@RequestParam(value = "status", required = false, defaultValue = "0") int status,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp,
			@RequestParam Map<String, Object> pm) {

		if (pm.get("query") == null) {
			Map<String, Object> map = service.selectTradeList(status, cp);
			model.addAttribute("map", map);
		} else {
			pm.put("status", status);
			Map<String, Object> map = service.selectTradeList(pm, cp);
			model.addAttribute("map", map);
		}

		return "/manager/tradeList";
	}

	
	
	// 작업 상태별 계좌 내역 조회 ajax
	@GetMapping("/manager/tradeStatus")
	@ResponseBody
	public Map<String, Object> managerTradeStatus(Model model, 
			@RequestParam(value = "status", required = false, defaultValue = "0") int status,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> map = new HashMap<String, Object>();

		map = service.selectTradeStatusList(status, cp);
		model.addAttribute("map", map);

		return map;
	}
	
	// 환불하기 모달 오픈하면 나오는 거래 정보
	@GetMapping("/manager/tradeInfo")
	@ResponseBody
	public TradeInfo managerTradeInfo(Model model, @RequestParam int tradeNo) {
		
		TradeInfo tradeInfo = service.selectTradeInfo(tradeNo);
				
		model.addAttribute("tradeInfo", tradeInfo);
		
		return tradeInfo;
	}

	
	// 환불하기
	@GetMapping("/manager/settlement/refund")
	public String managerRefund(Model model,
					@RequestParam int tradeNo, @RequestParam(value="refundPercent", required = false) int refundPercent,
					@RequestParam(value = "status", required = false, defaultValue = "0") int status,
					@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {
		
		Map<String, Object> pm = new HashMap<String, Object>();
		pm.put("tradeNo", tradeNo);
		pm.put("refundPercent", refundPercent);

		int result = service.managerRefund(pm);
		
		if(result>0) {
			Map<String, Object> map = service.selectTradeList(status, cp);
			model.addAttribute("map", map);
		}
		
		
		return "/manager/tradeList";
	}
		
	
	// 정산하기
	@GetMapping("/manager/settlement/calculate")
	@ResponseBody
	public Map<String, Object> managerCalculate(Model model,
			@RequestParam int tradeNo,
			@RequestParam(value = "status", required = false, defaultValue = "0") int status,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {
		
		int result = service.managerCalculate(tradeNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(result>0) {
			map = service.selectTradeList(status, cp);
		}
		
		return map;
	}
	
	
	

	@GetMapping("/manager/projectRequestList")
	public String managerprojectRequestList() {
		return "/manager/projectRequestList";
	}

	@GetMapping("/manager/reviewList")
	public String managerReport() {
		return "/manager/reviewList";
	}

}
