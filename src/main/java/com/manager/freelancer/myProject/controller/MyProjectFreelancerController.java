package com.manager.freelancer.myProject.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.manager.freelancer.myProject.model.service.MyProjectFreelancerService;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancer;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancerProfit;
import com.manager.freelancer.member.model.vo.Member;

@SessionAttributes({"loginMember"})
@Controller
public class MyProjectFreelancerController {
	
	@Autowired
	private MyProjectFreelancerService service;
	
	// 내 프로젝트 전문가페이지 나의 서비스 이동 --정렬 완료
	@GetMapping("/member/myProject/freelancer/myService")
	public String myService(Model model, HttpSession session,
			@RequestParam(value="mainCategoryNo",required=false, defaultValue="0") int mainCategoryNo,
			@RequestParam(value="cp" , required = false, defaultValue = "1") int cp
					) {
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		List<FreelancerService> maincategoryList = service.selectmaincategoryList();
		//List<FreelancerService> myService
		Map<String, Object> map  = service.selectMyService(loginMember.getMemberNo(),mainCategoryNo,cp);
		model.addAttribute("maincategoryList",maincategoryList);
		model.addAttribute("myService",map.get("myService"));
		model.addAttribute("pagination",map.get("pagination"));
		model.addAttribute("listCount",map.get("listCount"));
		model.addAttribute("mainCategoryNoInput",mainCategoryNo);
		
		return "myProject/myProject_freelancer/myServiceFreelancer";
	}
	
	//나의 서비스 등록하기 페이지
	@GetMapping("/member/myProject/freelancer/myServiceInsert")
	public String myServiceInsert(Model model) {
		
		List<FreelancerService> maincategoryList = service.selectmaincategoryList();
		List<FreelancerService> categoryList = service.selectcategoryList();
		
		model.addAttribute("maincategoryList",maincategoryList);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("GsoncategoryList",new Gson().toJson(categoryList));
		
		return "myProject/myProject_freelancer/myServiceInsert";
	}
	
	//나의 서비스 등록--서비스 번호 맞게 등록되는 지 확인하기 --완료
	@PostMapping("/myProject/freelancer/serviceInsert")
	public String serviceInsert(@RequestParam(value="serviceFilePath") List<MultipartFile> serviceFile,
								@SessionAttribute("loginMember") Member loginMember,
								HttpServletRequest req, /* 저장할 서버 경로 */
								RedirectAttributes ra, /* 메세지 전달용 */
								Model model, FreelancerService freelancerVo) throws IOException {
		
		String webPath = "/resources/files/myProjectService/";
		
		// 실제 파일이 저장된 컴퓨터 상의 절대 경로
		String filePath = req.getSession().getServletContext().getRealPath(webPath);
		
		int result = service.insertService(webPath, filePath, serviceFile, loginMember, freelancerVo);
		
		String message = null;
		if(result > 0)	message = "서비스가 등록되었습니다.";
		else			message = "서비스 등록 실패";
		
		ra.addFlashAttribute("message", message);
			
		return "redirect:/member/myProject/freelancer/myService";
	}
	
	// 내 프로젝트 전문가페이지 서비스 판매 관리
	@GetMapping("/member/myProject/freelancer/myServiceSales")
	public String myServiceSales(Model model, HttpSession session,
				@RequestParam(value="mainCategoryNo",required=false, defaultValue="0") int mainCategoryNo,
				@RequestParam(value="freelancerFL",required=false, defaultValue="0") int freelancerFL,
				@RequestParam(value="searchInput",required=false) String searchInput,
				@RequestParam(value="cp" , required = false, defaultValue = "1") int cp
						) {
			
		Member loginMember = (Member) session.getAttribute("loginMember");
		List<FreelancerService> maincategoryList = service.selectmaincategoryList();
		Map<String, Object> map = service.selectSalesList(loginMember.getMemberNo(),mainCategoryNo,searchInput,freelancerFL,cp);
		//List<FreelancerService> salesList 
		List<FreelancerService> inpurMyService = service.selectMyService(loginMember.getMemberNo(),0); //나의 서비스 들고와서 자동완성
		
		model.addAttribute("maincategoryList",maincategoryList);
		model.addAttribute("mainCategoryNoInput",mainCategoryNo);
		
		model.addAttribute("salesList",map.get("salesList"));
		model.addAttribute("pagination",map.get("pagination"));
		model.addAttribute("listCount",map.get("listCount"));
		
		model.addAttribute("GsonsalesList",new Gson().toJson(map.get("salesList")));
		
		model.addAttribute("freelancerFL",freelancerFL);
		model.addAttribute("searchInput",searchInput);
		model.addAttribute("inpurMyService",new Gson().toJson(inpurMyService));
	
		return "myProject/myProject_freelancer/myServicerSalesManagement";
	}
	
	//신고하기 Ajax
	@PostMapping("/reportSubmit")
	@ResponseBody
	public String insertreportSubmit(
			FreelancerService freelancerReport,
			MultipartHttpServletRequest formData,
			HttpServletRequest req, /* 저장할 서버 경로 */
			HttpSession session) throws Exception {
			
			// 인터넷 주소로 접근할 수 있는 경로
			String webPath = "/resources/files/myProjectService/";
					
			// 실제 파일이 저장된 컴퓨터 상의 절대 경로
			String filePath = req.getSession().getServletContext().getRealPath(webPath);
			
			String tradeNo = new String(formData.getParameterValues("tradeNoIN")[0].getBytes("8859_1"),"utf-8");
			String reportPersonNo = new String(formData.getParameterValues("reportPersonNoIN")[0].getBytes("8859_1"),"utf-8");
			String reportedPersonNo = new String(formData.getParameterValues("reportedPersonNoIN")[0].getBytes("8859_1"),"utf-8");
			String reportContent = URLDecoder.decode( formData.getParameterValues("reportContentIN")[0], "UTF-8");
			
			
			Map<String, Object> resurt = new HashMap<String, Object>();						
			resurt = service.insertreportSubmit(webPath, filePath,Integer.parseInt(tradeNo),Integer.parseInt(reportPersonNo),Integer.parseInt(reportedPersonNo)
					,reportContent,formData.getFile("reportFile"));


			Map<String, Object> map = new HashMap<String, Object>();
			map.put("messageIN",resurt.get("messageIN"));
			map.put("tradeReportNo",resurt.get("tradeReportNo"));
			map.put("reportFilePath",resurt.get("reportFilePath"));
			//map.put("reportFilePath",reportFilePath);
			map.put("reportContent",reportContent);
		
			return new Gson().toJson(map);
	}
	
	
	//발송하기 Ajax
	@PostMapping("/sendworkSubmit")
	@ResponseBody
	public String insertsendworkSubmit(
			@RequestParam(value="tradeNo") int tradeNo) throws Exception{
		
		String message = service.insertsendworkSubmit(tradeNo);
		
		return new Gson().toJson(message);
	}
	
	
	/* --거래 테이블에서 의뢰인,프리랜서 둘다 작업 완료가 되면 정산 내역 테이블 같은 거래 번호일 떄 작업 상태 마감으로 변경 해주는 트리거 2개 
		--DROP TRIGGER DONEFL_WORK_STATUS;
		CREATE OR REPLACE TRIGGER DONEFL_WORK_STATUS
		AFTER 
		UPDATE OF MEMBER_DONE_FL,FREELANCER_DONE_FL ON TRADE
		FOR EACH ROW
		WHEN (OLD.FREELANCER_DONE_FL = 2 AND NEW.MEMBER_DONE_FL = 2)
		--WHEN (OLD.MEMBER_DONE_FL = 2 AND NEW.FREELANCER_DONE_FL = 2)
		BEGIN
			  UPDATE SETTLEMENT
			  SET WORK_STATUS = 4   --마감
			  WHERE TRADE_NO =:OLD.TRADE_NO;
		END;
		
		----------------------------------------------------------------------------
		CREATE OR REPLACE TRIGGER DONEFL_WORK_STATUS2
		AFTER 
		UPDATE OF MEMBER_DONE_FL,FREELANCER_DONE_FL ON TRADE
		FOR EACH ROW
		WHEN (OLD.MEMBER_DONE_FL = 2 AND NEW.FREELANCER_DONE_FL = 2)
		BEGIN
			  UPDATE SETTLEMENT
			  SET WORK_STATUS = 4   --마감
			  WHERE TRADE_NO =:OLD.TRADE_NO;
		END;
	   */
	
	//작업완료하기 Ajax  --- 거래테이블에서 의뢰자,프리랜서 작업상태가 두개 다 완료이면 정산 내역 테이블에 마감 상태로 상태값 변함
	//트리거 작성 완성해놓음 --트리거 이름:  DONEFL_WORK_STATUS /DONEFL_WORK_STATUS2
	@PostMapping("/finishSubmit")
	@ResponseBody
	public String insertfinishSubmit(
			@RequestParam(value="tradeNo") int tradeNo) throws Exception{
			
		String message = service.insertfinishSubmit(tradeNo);
			
		return new Gson().toJson(message);
	}
	
	// 내가 보낸 제안 페이지 이동 --메인 카테고리별 정렬 포함
	@GetMapping("/member/myProject/freelancer/myProposal")
	public String myProposal(Model model, HttpSession session,
			@RequestParam(value="mainCategoryNo",required=false, defaultValue="0") int mainCategoryNo,
			@RequestParam(value="cp" , required = false, defaultValue = "1") int cp
					) {
			
		Member loginMember = (Member) session.getAttribute("loginMember");
		List<FreelancerService> maincategoryList = service.selectmaincategoryList();
		Map<String, Object> map  = service.selectMyProposal(loginMember.getMemberNo(),mainCategoryNo,cp);
		model.addAttribute("maincategoryList",maincategoryList);
		model.addAttribute("myProposal",map.get("myProposalList"));
		model.addAttribute("pagination",map.get("pagination"));
		model.addAttribute("listCount",map.get("listCount"));
		model.addAttribute("mainCategoryNoInput",mainCategoryNo);
			
		return "myProject/myProject_freelancer/myProject_proposal";
	}
	
	//수익관리 페이지
	@GetMapping("/member/myProject/freelancer/profitManagerment")
	public String profitManagerment(Model model, HttpSession session,
			@RequestParam(value="cp" , required = false, defaultValue = "1") int cp,
			@RequestParam(value="endtDate" , required = false, defaultValue = "") String endtDate,
			@RequestParam(value="startDate" , required = false, defaultValue = "") String startDate) {
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		List<myProjectFreelancerProfit>	profitList = service.selectMonthMyProfit(loginMember.getMemberNo());//달별 총 수익 
		List<myProjectFreelancerProfit>	profit = service.selectMyProfit(loginMember.getMemberNo());//최근 1년간 예상수익 총수익
		Map<String, Object>	map = service.selectMyProfitEachList(loginMember.getMemberNo(),cp,startDate,endtDate);//거래별 정산 내역
		
		model.addAttribute("profitList",new Gson().toJson(profitList));	
		model.addAttribute("profit",profit);
		model.addAttribute("myProfitEachList",map.get("myProfitEachList"));
		model.addAttribute("pagination",map.get("pagination"));
		model.addAttribute("listCount",map.get("listCount"));
		model.addAttribute("endtDate",endtDate);
		model.addAttribute("startDate",startDate);
		return "myProject/myProject_freelancer/profitManagerment";
	}
	
	//서비스 문의 페이지
	@GetMapping("/member/myProject/freelancer/myServiceInquiry")
	public String myServiceInquiry(Model model, HttpSession session,
			@RequestParam(value="mainCategoryNo",required=false, defaultValue="0") int mainCategoryNo,
			@RequestParam(value="endtDate" , required = false, defaultValue = "") String endtDate,
			@RequestParam(value="startDate" , required = false, defaultValue = "") String startDate,
			@RequestParam(value="searchInput",required=false) String searchInput,
			@RequestParam(value="cp" , required = false, defaultValue = "1") int cp) {
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		List<FreelancerService> maincategoryList = service.selectmaincategoryList();
		List<FreelancerService> inputMyService = service.selectMyService(loginMember.getMemberNo(),0); //나의 서비스 들고와서 자동완성
		Map<String, Object> map = service.myServiceInquiry(loginMember.getMemberNo(),cp,startDate,endtDate,mainCategoryNo,searchInput);
		Map<String, Object> resurt = new HashMap<String, Object>();	
		
		model.addAttribute("maincategoryList",maincategoryList);
		model.addAttribute("mainCategoryNoInput",mainCategoryNo);
		
		model.addAttribute("inquiryList",map.get("inquiryList"));
		model.addAttribute("pagination",map.get("pagination"));
		model.addAttribute("listCount",map.get("listCount"));
		
		model.addAttribute("GsoninquiryList",new Gson().toJson(map.get("inquiryList")));

		model.addAttribute("searchInput",searchInput);
		model.addAttribute("inputMyService",new Gson().toJson(inputMyService));
		model.addAttribute("endtDate",endtDate);
		model.addAttribute("startDate",startDate);
		return "myProject/myProject_freelancer/myServiceInquiry";
	}
	
	//등급관리 페이지
	@GetMapping("/member/myProject/freelancer/myProjectGrade")
	public String myProjectGrade(HttpSession session,
			@SessionAttribute("loginMember") Member loginMember,Model model) {
		
		myProjectFreelancer freelancerGrade =service.selectMyProjectGrade(loginMember.getMemberNo(), 1); //타입: 1 프리랜서용(스케줄러용은 2번)
		List<myProjectFreelancer> BasicGrade =service.selectBasicGrade();
		model.addAttribute("freelancerGrade",freelancerGrade);
		model.addAttribute("BasicGrade",BasicGrade);
		return "myProject/myProject_freelancer/myProjectGrade";
	}
	
	
	//프리랜서 클럽 페이지(지도 api)
	@GetMapping("/member/myProject/freelancer/freelancerClub")
	public String freelancerClub() {
		
		return "myProject/myProject_freelancer/myProject_freelancerClub";
	}

}
