package com.manager.freelancer.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.manager.freelancer.manager.model.service.ManagerService;
import com.manager.freelancer.manager.model.vo.FreelancerService;
import com.manager.freelancer.manager.model.vo.Member;
import com.manager.freelancer.manager.model.vo.MemberReport;
import com.manager.freelancer.manager.model.vo.ProjectRequest;
import com.manager.freelancer.manager.model.vo.TradeInfo;

@SessionAttributes({"loginMember"})
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

	// 서비스 상세보기
	@GetMapping("/manager/serviceDetail/{serviceNo}")
	public String managerServiceDetail(@PathVariable("serviceNo") int serviceNo, Model model) {

		FreelancerService freelancerService = service.managerServiceDetail(serviceNo);
		model.addAttribute("freelancerService", freelancerService);

		return "/manager/serviceDetail";
	}

	// 서비스 승인
	@GetMapping("/manager/{serviceNo}/serviceApproval")
	public String managerServiceApproval(@PathVariable("serviceNo") int serviceNo, Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		int result = service.managerServiceApproval(serviceNo);

		if (result > 0) {
			Map<String, Object> map = service.selectServiceList(cp);
			model.addAttribute("map", map);
		}

		return "redirect:/manager/serviceList";
	}

	// 서비스 반려
	@GetMapping("/manager/{serviceNo}/serviceRestore")
	public String managerServiceRestort(@PathVariable("serviceNo") int serviceNo, Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		int result = service.managerServiceRestore(serviceNo);

		if (result > 0) {
			Map<String, Object> map = service.selectServiceList(cp);
			model.addAttribute("map", map);
		}

		return "redirect:/manager/serviceList";
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
	public String managerRefund(Model model, @RequestParam int tradeNo,
			@RequestParam(value = "refundPercent", required = false) int refundPercent,
			@RequestParam(value = "status", required = false, defaultValue = "0") int status,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> pm = new HashMap<String, Object>();
		pm.put("tradeNo", tradeNo);
		pm.put("refundPercent", refundPercent);

		int result = service.managerRefund(pm);

		if (result > 0) {
			Map<String, Object> map = service.selectTradeList(status, cp);
			model.addAttribute("map", map);
		}

		return "/manager/tradeList";
	}

	// 정산하기
	@GetMapping("/manager/settlement/calculate")
	@ResponseBody
	public Map<String, Object> managerCalculate(Model model, @RequestParam int tradeNo,
			@RequestParam(value = "status", required = false, defaultValue = "0") int status,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		int result = service.managerCalculate(tradeNo);

		Map<String, Object> map = new HashMap<String, Object>();

		if (result > 0) {
			map = service.selectTradeList(status, cp);
		}

		return map;
	}

//=================================================================================
	// 프로젝트 의뢰 목록
	@GetMapping("/manager/projectRequestList")
	public String managerprojectRequestList(Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> map = service.managerprojectRequestList(cp);
		model.addAttribute("map", map);

		return "/manager/projectRequestList";
	}

	// 프로젝트 의뢰 상태
	@GetMapping("/manager/requestType")
	@ResponseBody
	public Map<String, Object> managerprojectRequestType(Model model,
			@RequestParam(value = "status", required = false) int status,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(status);

		map = service.managerprojectRequestType(status, cp);
		model.addAttribute("map", map);
		System.out.println(map);

		return map;
	}

	// 프로젝트 의뢰 삭제
	@GetMapping("/manager/requestDelete")
	@ResponseBody
	public int managerRequestDelete(@RequestParam int projectRequestNo) {

		System.out.println(projectRequestNo);

		int result = service.managerRequestDelete(projectRequestNo);

		return result;
	}

	// 프로젝트 의뢰 상세보기
	@GetMapping("/manager/requestDetail/{projectRequestNo}")
	public String managerRequestDetail(@PathVariable("projectRequestNo") int projectRequestNo, Model model) {

		ProjectRequest projectRequest = service.managerRequestDetail(projectRequestNo);
		model.addAttribute("projectRequest", projectRequest);

		return "/manager/requestDetail";
	}

	// 프로젝트 의뢰 승인
	@GetMapping("/manager/{projectRequestNo}/requestApproval")
	public String managerRequestApproval(@PathVariable("projectRequestNo") int projectRequestNo, Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		int result = service.managerRequestApproval(projectRequestNo);

		if (result > 0) {
			Map<String, Object> map = service.managerprojectRequestList(cp);
			model.addAttribute("map", map);
		}

		return "redirect:/manager/projectRequestList";
	}

	// 프로젝트 의뢰 반려
	@GetMapping("/manager/{projectRequestNo}/requestRestore")
	public String managerRequestRestore(@PathVariable("projectRequestNo") int projectRequestNo, Model model,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		int result = service.managerRequestRestore(projectRequestNo);

		if (result > 0) {
			Map<String, Object> map = service.managerprojectRequestList(cp);
			model.addAttribute("map", map);
		}

		return "redirect:/manager/projectRequestList";
	}
	
	//=======================================================
	
	// 회원 신고 목록 조회
	@GetMapping("/manager/memberReportList")
	public String managerMemberReport(Model model, @RequestParam(value = "status", required = false, defaultValue = "0") int status,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp,
			@RequestParam Map<String, Object> pm) {

		if (pm.get("key") == null) {
			Map<String, Object> map = service.selectMemberReportList(status, cp);
			model.addAttribute("map", map);
		} else {
			pm.put("status", status);
			Map<String, Object> map = service.selectMemberReportList(pm, cp);
			model.addAttribute("map", map);
		}

		return "/manager/memberReportList";
	}
	
	//회원 신고 상세보기
	@GetMapping("/manager/memberReportDetail/{memberReportNo}")
	public String managerMemberReportDetail(
			@PathVariable(value="memberReportNo") int memberReportNo, Model model,
			@SessionAttribute("loginMember") com.manager.freelancer.member.model.vo.Member loginMember) {
		
		MemberReport memberReport = service.memberReportDetail(memberReportNo);
		
		model.addAttribute("memberReport",memberReport);
		model.addAttribute("loginMember",loginMember);
		
		return "/manager/memberReportDetail";
	}
	
	// 상태별 회원 신고 내역
	@GetMapping("/manager/memberReportType")
	@ResponseBody
	public Map<String, Object> memberReportType(Model model, 
			@RequestParam(value = "status", required = false, defaultValue = "0") int status,
			@RequestParam(value = "cp", required = false, defaultValue = "1") int cp) {

		Map<String, Object> map = new HashMap<String, Object>();

		map = service.selectMemberReportList(status, cp);
		model.addAttribute("map", map);
		
		return map;
	}
	
	
	// 신고 내역 답변 등록
	@PostMapping("/manager/memberReportRequest")
	@ResponseBody
	public int memberReportRequest(Model model, 
			@RequestParam(value = "memberReportNo", required = false) int memberReportNo,
			@RequestParam(value = "memberReportRequest", required = false) String memberReportRequest,
			@SessionAttribute("loginMember") com.manager.freelancer.member.model.vo.Member loginMember) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberReportNo", memberReportNo);
		map.put("memberReportRequest", memberReportRequest);
		map.put("loginMember", loginMember);
		
		int result = service.insertReportRequest(map);
		
		return result;
	}
	
	
	
	

	@GetMapping("/manager/reviewList")
	public String managerReview() {
		return "/manager/reviewList";
	}
	
	
	
	
	@GetMapping("/manager/tradeReportList")
	public String managerTradeReport() {
		return "/manager/tradeReportList";
	}
	
	

}
