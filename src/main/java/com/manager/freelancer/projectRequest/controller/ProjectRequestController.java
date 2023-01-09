package com.manager.freelancer.projectRequest.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.google.gson.Gson;
import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.service.MyProjectFreelancerService;
import com.manager.freelancer.myProject.model.vo.MyProject;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancer;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancerRequest;
import com.manager.freelancer.projectRequest.model.service.ProjectRequestSerivce;

@Controller
public class ProjectRequestController {
	
	@Autowired
	private ProjectRequestSerivce service;
	
	/**프로젝트 목록 조회
	 * @param model
	 * @param cp
	 * @param mainNo
	 * @param subNo
	 * @param thirdNo
	 * @return
	 */
	@GetMapping("/projectRequest/requestList/{mainCategoryNo}/{subCategoryNo}/{thirdCategoryNo}")
	public String mainProjectRequest(Model model,
			@RequestParam(value="cp" , required = false, defaultValue = "1") int cp,
			@RequestParam(value="listOrder" , required = false, defaultValue = "3") int listOrder,
			@RequestParam(value="budget" , required = false, defaultValue = "0.0") String budget,
			@PathVariable(value="mainCategoryNo" , required = false) String mainNo,
			@PathVariable(value="subCategoryNo" , required = false) String subNo,
			@PathVariable(value="thirdCategoryNo" , required = false) String thirdNo
			) {
		
		int budgetInt0= 0; 
		int budgetInt1= 0;
		String[] budgetString;
		System.out.println(budget);
		if(!budget.equals("0.0") && !budget.equals("")) {
			budgetString =budget.split("\\.");
			System.out.println(budgetString[0]);
			System.out.println(budgetString[1]);
			budgetInt0 = Integer.parseInt(budgetString[0]+"0000");
			budgetInt1 = Integer.parseInt(budgetString[1]+"0000");
		}
		
		System.out.println(budgetInt0);
		System.out.println(budgetInt1);
		
		int mainCategoryNo;
		int subCategoryNo;
		int thirdCategoryNo;
		if(mainNo == null) { //&& mainNo.equals("")) {
			mainCategoryNo =0;
		}else {
			mainCategoryNo =Integer.parseInt(mainNo);
		}
		
		if(subNo == null) { //&& subNo.equals("")) {
			subCategoryNo =0;
		}else {
			subCategoryNo =Integer.parseInt(subNo);
		}
		
		if(thirdNo == null) { //&& thirdNo.equals("")) {
			thirdCategoryNo =0;
		}else {
			thirdCategoryNo =Integer.parseInt(thirdNo);
		}
		Map<String, Object> map = service.getCategotyList(cp,mainCategoryNo,subCategoryNo,thirdCategoryNo,budgetInt0,budgetInt1,listOrder);
		model.addAttribute("category", map);
		model.addAttribute("pagination",map.get("pagination"));
		model.addAttribute("listCount",map.get("listCount"));
		model.addAttribute("mainCategoryNo",mainCategoryNo);
		model.addAttribute("subCategoryNo",subCategoryNo);
		model.addAttribute("thirdCategoryNo",thirdCategoryNo);
		model.addAttribute("listOrder",listOrder);
		model.addAttribute("budget",budget);
		return "/projectRequest/projectRequestList";
	}
	
	/**프로젝트 의뢰 상세보기
	 * @param loginMember
	 * @param serviceNo
	 * @param model
	 * @return
	 */
	@GetMapping("/projectRequest/projectRequestDetail/{projectRequestNo}")
	public String projectRequest(@SessionAttribute(value="loginMember",required=false) Member loginMember,
			@PathVariable("projectRequestNo") int projectRequestNo, Model model) {
		
		myProjectFreelancer freelancerSalesCount = new myProjectFreelancer();
		myProjectFreelancer freelancerInfo = new myProjectFreelancer();
		if(loginMember != null && loginMember.getFreelancerFL().equals("Y")) {
			freelancerSalesCount =service.selectMyProjectGrade(loginMember.getMemberNo()); //판매 건수
			freelancerInfo =service.selectFreelancerInfo(loginMember.getMemberNo()); //등급이랑 전문분야
		}
		myProjectFreelancerRequest userRequest = service.selectUserRequest(projectRequestNo);
		List<MyProject> proposalList =userRequest.getProposalList();
		List<MyProjectFreelancerService> fieldList =freelancerInfo.getFieldList();
		model.addAttribute("userRequest", userRequest);
		model.addAttribute("proposalListJson", new Gson().toJson(proposalList));
		model.addAttribute("freelancerSalesCount", freelancerSalesCount);
		model.addAttribute("freelancerInfo", freelancerInfo);
		model.addAttribute("fieldList", fieldList);
		model.addAttribute("fieldListJson", new Gson().toJson(fieldList));
		return "/projectRequest/projectRequestDetail";
	}

	//프로젝트 상세 페이지에서 제안하기 버튼(모달)
	@PostMapping("/requestDetailSubmit")
	@ResponseBody
	public String requestDetailSubmit(
			@RequestParam(value="requestNO") int requestNO,
			@RequestParam(value="proposalpriceInput") int proposalpriceInput,
			@RequestParam(value="proposaleditInput") int proposaleditInput,
			@RequestParam(value="proposalMemberNo") int proposalMemberNo
			) throws Exception{
			
		String message = service.requestDetailSubmit(requestNO,proposalpriceInput,proposaleditInput,proposalMemberNo);
			
		return new Gson().toJson(message);
	}
	
	//프로젝트 상세 페이지에서 판매중지
	@PostMapping("/requestStopSubmit")
	@ResponseBody
	public String requestStopSubmit(
				@RequestParam(value="requestNO") int requestNO
				) throws Exception{
				
		String message = service.requestStopSubmit(requestNO);
				
		return new Gson().toJson(message);
	}
	
	//모집 마감입박순 /최신순
	@PostMapping("/listOrderSelect")
	@ResponseBody
	public String listOrderSelect(
				@RequestParam(value="listOrder") int listOrder,
				@RequestParam(value="budget" , required = false, defaultValue = "0.0") String budget,
				@RequestParam(value="mainCategoryNo") int mainCategoryNo,
				@RequestParam(value="subCategoryNo") int subCategoryNo,
				@RequestParam(value="thirdCategoryNo") int thirdCategoryNo,
				@RequestParam(value="cp" , required = false, defaultValue = "1") int cp
				) throws Exception{
		
		int budgetInt0= 0; 
		int budgetInt1= 0;
		String[] budgetString;
		if(!budget.equals("0.0") && !budget.equals("")) {
			budgetString =budget.split("\\.");
			budgetInt0 = Integer.parseInt(budgetString[0]+"0000");
			budgetInt1 = Integer.parseInt(budgetString[1]+"0000");
		}
		
		System.out.println(budgetInt0);
		System.out.println(budgetInt1);
					
		Map<String, Object> resultList = service.listOrderSelect(listOrder,mainCategoryNo,subCategoryNo,thirdCategoryNo,cp,budgetInt0,budgetInt1);
					
		return new Gson().toJson(resultList);
	}
}
