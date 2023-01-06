package com.manager.freelancer.myProject.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.service.MyProjectService_2;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.myProject.model.vo.Review;
import com.manager.freelancer.myProject.model.vo.TradeReport;
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
	@GetMapping("/member/myProject/memberDone")
	@ResponseBody
	public Map<String, Object> memberDone(Model model, @SessionAttribute("loginMember") Member loginMember,
			@RequestParam(value="cp" , required = false, defaultValue = "1") int cp,
			@RequestParam(value="searchInput",required=false, defaultValue = "") String searchInput,
			@RequestParam(value="type" , required = false, defaultValue = "0") int type,
			@RequestParam(value="searchDate1" , required = false, defaultValue = "") String searchDate1,
			@RequestParam(value="searchDate2" , required = false, defaultValue = "") String searchDate2,
			@RequestParam int tradeNo) {
		
		int result = service.memberDone(tradeNo);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
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
			
			resultMap = service.selectPurchaseList(option, cp);
			resultMap.put("type", type);
			resultMap.put("searchDate1", searchDate1);
			resultMap.put("searchDate2", searchDate2);
			resultMap.put("searchInput", searchInput);
			model.addAttribute("resultMap",resultMap);
			
		}
		
		return resultMap;
	}
	
	// 거래 신고
	@PostMapping("/member/myProject/tradeReport")
	public String tradeReport(Model model, @SessionAttribute("loginMember") Member loginMember,
			@RequestParam(value="cp" , required = false, defaultValue = "1") int cp,
			@RequestParam(value="searchInput",required=false, defaultValue = "") String searchInput,
			@RequestParam(value="type" , required = false, defaultValue = "0") int type,
			@RequestParam(value="searchDate1" , required = false, defaultValue = "") String searchDate1,
			@RequestParam(value="searchDate2" , required = false, defaultValue = "") String searchDate2,
			@RequestParam(value="reportFilePath", required = false, defaultValue = "") MultipartFile reportFile,
			RedirectAttributes ra, /* 메세지 전달용 */
			HttpServletRequest req, /* 저장할 서버 경로 */
			TradeReport inputTradeReport) throws IOException {
		
		String webPath = "/resources/files/tradeReport/";
		// 실제 파일이 저장된 컴퓨터 상의 절대 경로
		String realPath = req.getSession().getServletContext().getRealPath(webPath);
		
		
		int result = service.insertTradeReport(inputTradeReport,webPath, realPath, reportFile);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String message = null;
		if(result>0) {
			int loginMemberNo = loginMember.getMemberNo();
			Map<String, Object> option = new HashMap<String, Object>();
			option.put("loginMemberNo", loginMemberNo);
			option.put("type", type);
			option.put("searchDate1", searchDate1);
			option.put("searchDate2", searchDate2);
			option.put("searchInput", searchInput);
			
			resultMap = service.selectPurchaseList(option, cp);
			
			model.addAttribute("resultMap",resultMap);
			model.addAttribute("type", type);
			model.addAttribute("searchDate1", searchDate1);
			model.addAttribute("searchDate2", searchDate2);
			model.addAttribute("searchInput", searchInput);
			message = "신고 등록";
		} else {
			message = "신고 등록 실패";
			
		}
		ra.addFlashAttribute("message", message);
		
		return "redirect:myProject/myPurchaseList";
	}
	
	
	// 주문 취소
	@PostMapping("/member/myProject/tradeReportCancel")
	public String tradeReportCancel(Model model, @SessionAttribute("loginMember") Member loginMember,
			@RequestParam(value="cp" , required = false, defaultValue = "1") int cp,
			@RequestParam(value="searchInput",required=false, defaultValue = "") String searchInput,
			@RequestParam(value="type" , required = false, defaultValue = "0") int type,
			@RequestParam(value="searchDate1" , required = false, defaultValue = "") String searchDate1,
			@RequestParam(value="searchDate2" , required = false, defaultValue = "") String searchDate2,
			@RequestParam(value="reportFilePath", required = false, defaultValue = "") MultipartFile reportFile,
			RedirectAttributes ra, /* 메세지 전달용 */
			HttpServletRequest req, /* 저장할 서버 경로 */
			TradeReport inputTradeReport) throws IOException {
		
		String webPath = "/resources/files/tradeReport/";
		// 실제 파일이 저장된 컴퓨터 상의 절대 경로
		String realPath = req.getSession().getServletContext().getRealPath(webPath);
		
		
		int result = service.insertTradeReportCancel(inputTradeReport,webPath, realPath, reportFile);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String message = null;
		if(result>0) {
			int loginMemberNo = loginMember.getMemberNo();
			Map<String, Object> option = new HashMap<String, Object>();
			option.put("loginMemberNo", loginMemberNo);
			option.put("type", type);
			option.put("searchDate1", searchDate1);
			option.put("searchDate2", searchDate2);
			option.put("searchInput", searchInput);
			
			resultMap = service.selectPurchaseList(option, cp);
			
			model.addAttribute("resultMap",resultMap);
			model.addAttribute("type", type);
			model.addAttribute("searchDate1", searchDate1);
			model.addAttribute("searchDate2", searchDate2);
			model.addAttribute("searchInput", searchInput);
			message = "주문 취소 등록";
		} else {
			message = "주문 취소 등록 실패";
			
		}
		ra.addFlashAttribute("message", message);
		
		return "redirect:myProject/myPurchaseList";
	}
	
	
	// 리뷰하기
	@PostMapping("/member/myProject/review")
	public String myProjectReview(Model model, @SessionAttribute("loginMember") Member loginMember,
			@RequestParam(value="cp" , required = false, defaultValue = "1") int cp,
			@RequestParam(value="searchInput",required=false, defaultValue = "") String searchInput,
			@RequestParam(value="type" , required = false, defaultValue = "0") int type,
			@RequestParam(value="searchDate1" , required = false, defaultValue = "") String searchDate1,
			@RequestParam(value="searchDate2" , required = false, defaultValue = "") String searchDate2,
			@RequestParam(value="reviewFilePath", required = false, defaultValue = "") MultipartFile reviewFile,
			RedirectAttributes ra, /* 메세지 전달용 */
			HttpServletRequest req, /* 저장할 서버 경로 */
			Review inputReview) throws IOException {
		
		String webPath = "/resources/files/review/";
		// 실제 파일이 저장된 컴퓨터 상의 절대 경로
		String realPath = req.getSession().getServletContext().getRealPath(webPath);
		
		
		int result = service.insertReview(inputReview,webPath, realPath, reviewFile);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String message = null;
		int loginMemberNo = loginMember.getMemberNo();
		Map<String, Object> option = new HashMap<String, Object>();
		option.put("loginMemberNo", loginMemberNo);
		option.put("type", type);
		option.put("searchDate1", searchDate1);
		option.put("searchDate2", searchDate2);
		option.put("searchInput", searchInput);
		
		resultMap = service.selectPurchaseList(option, cp);
		
		model.addAttribute("resultMap",resultMap);
		model.addAttribute("type", type);
		model.addAttribute("searchDate1", searchDate1);
		model.addAttribute("searchDate2", searchDate2);
		model.addAttribute("searchInput", searchInput);
		
		if(result>0) {
			message = "리뷰 등록";
		} else {
			message = "리뷰가 이미 존재합니다.";
			
		}
		ra.addFlashAttribute("message", message);
		
		return "redirect:myProject/myPurchaseList";
	}
	
	
	
	

}
