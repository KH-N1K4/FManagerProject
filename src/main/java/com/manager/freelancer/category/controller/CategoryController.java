package com.manager.freelancer.category.controller;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.freelancer.category.model.service.CategoryService;
import com.manager.freelancer.category.model.vo.AskService;
import com.manager.freelancer.category.model.vo.Category;
import com.manager.freelancer.category.model.vo.Freelancer1;
import com.manager.freelancer.category.model.vo.Service;
import com.manager.freelancer.category.model.vo.Trade;
import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.vo.FreelancerService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	
	// 메인 목록 조회 
	@GetMapping("/")
	public String selectService(Model model,@RequestParam(value="cp", required=false, defaultValue="1") int cp,
			@SessionAttribute(value="loginMember",required=false) Member loginMember) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("cp", cp);
		if(loginMember!=null) {
			map.put("memberNo", loginMember.getMemberNo());
		}
		
		Map<String, Object> resultMap=service.serviceList(map);
		
		if(loginMember!=null) {
			
			model.addAttribute("memberNo", loginMember.getMemberNo());
		}
		
		model.addAttribute("resultMap", resultMap);
		
		return "common/main";
	}
	
	
	
	// 메인 카테고리 목록 조회
//	@GetMapping("/category/{mainCategoryNo}/0")
//	public String mainCategory(@PathVariable("mainCategoryNo") int mainCategoryNo, Model model,
//			@SessionAttribute(value="loginMember",required=false) Member loginMember,@RequestParam(value="cp", required=false, defaultValue="1") int cp) {
//		
//		
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		
//		if(loginMember!=null) {
//			
//			map.put("memberNo", loginMember.getMemberNo());
//		}
//		map.put("mainCategoryNo", mainCategoryNo);
//		map.put("cp", cp);
//		Map<String, Object> map2=service.selectBoardList(map);
//		
//		model.addAttribute("map",map2);
//			
//		return "/category/categoryList";
//	}
	
	
	// 세부 카테고리 목록 조회
	@GetMapping("/category/{mainCategoryNo}/{thirdCategoryNo}")
	public String subCategory(@PathVariable("mainCategoryNo") int mainCategoryNo,@PathVariable("thirdCategoryNo") int thirdCategoryNo,
			Model model, @SessionAttribute(value="loginMember",required=false) Member loginMember,
			@RequestParam(value="cp", required=false, defaultValue="1") int cp) {	
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		if(loginMember!=null) {
			
			map.put("memberNo", loginMember.getMemberNo());
		}
		
		System.out.println(thirdCategoryNo);
		map.put("mainCategoryNo", mainCategoryNo);
		map.put("thirdCategoryNo", thirdCategoryNo);
		map.put("cp", cp);
		Map<String, Object> map2=service.selectBoardList(map);
		
		model.addAttribute("map",map2);
			
		return "/category/categoryList";
	}
	
	
	
	
	@GetMapping("/selectCategoryList")
	@ResponseBody
	public Map<String, Object> selectCategoryList(@RequestParam(required = false) String order,@RequestParam String mainCategoryNo, 
			@RequestParam String thirdCategoryNo, 
			@RequestParam(required = false) String budget,@RequestParam(required = false) String grade, 
			Model model,@RequestParam(value="cp", required=false, defaultValue="1") int cp){
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		System.out.println("순서 : "+order+"예산 : "+budget+"전문가등급 : "+grade);
		
		map.put("order", order);
		map.put("budget", budget);
		map.put("grade", grade);
		map.put("mainCategoryNo", mainCategoryNo);
		map.put("thirdCategoryNo", thirdCategoryNo);
		map.put("cp", cp);
		
		
		
		Map<String, Object> serviceList=service.selectCategoryList(map);
		
		
//		Map<String, Object> resultMap=new HashMap<String, Object>();
//		
//		resultMap.put("serviceList", serviceList);
			
		return serviceList;
	
	}
	

	
	
	// 서비스 상세 조회
	@GetMapping("/category/{mainCategoryCode}/{subCategoryCode}/{lastCategoryCode}/{serviceNo}")
	public String viewService(@PathVariable("serviceNo") int serviceNo, Model model,
			@SessionAttribute(value="loginMember",required = false) Member loginMember) {	
		
		// 게시글 상세조회 서비스 호출 
		Service fService=service.viewService(serviceNo);
		
		
		// + 좋아요 수, 좋아요 여부
		if(fService!=null) {
			
			// BOARD_LIKE 테이블에 
			// 게시글번호, 로그인한 회원번호가 일치하는 행이 있는지 확인 
			if(loginMember!=null) { // 로그인 상태인 경우 
				
				Map<String, Object> map=new HashMap<String, Object>();
				
				map.put("serviceNo", fService.getServiceNo());
				map.put("memberNo", loginMember.getMemberNo());
				
				
				int result=service.serviceLikeCheck(map);
				
				if(result>0) {
					model.addAttribute("likeCheck","on");
				}
				
				
			}
		}
		
		
		
		model.addAttribute("fService",fService);
		
		
		return "/category/categoryDetail";
	}
	
	
	// 좋아요 수 증가 (INSERT)
	@GetMapping("/boardLikeUp")
	@ResponseBody
	public int boardLikeUp(@RequestParam Map<String,Object> paramMap) {
		// @RequestParam Map<String,Object>
		// -> 요청시 전달된 파라미터를 하나의 Map으로 반환
		
		return service.boardLikeUp(paramMap);
	}
	
	// 좋아요 수 감소 (DELETE)
	@GetMapping("/boardLikeDown")
	@ResponseBody
	public int boardLikeDown(@RequestParam Map<String,Object> paramMap) {
		// @RequestParam Map<String,Object>
		// -> 요청시 전달된 파라미터를 하나의 Map으로 반환
		
		return service.boardLikeDown(paramMap);
	}
		
		
	
	@PostMapping("/askService")
	public String askService(AskService as, 
			@SessionAttribute(value="loginMember", required = false) Member loginMember, // 회원번호 필요
			RedirectAttributes ra,@RequestHeader(value="referer") String referer  ) {
		
		
		String path=null;
		String message=null;
		
		
		if(loginMember!=null) {
			as.setMemberNo(loginMember.getMemberNo());
			int result=service.askService(as);
			path=referer;
			
			if(result>0) {
				message="문의 성공 ";
			}else {
				message="문의 실패 ";
			}
		}else {
			
			message="로그인 후 문의 가능합니다.";
			path="/member/login";
			
		}
		 	
		ra.addFlashAttribute("message",message);
		
		return "redirect:"+path;
	}
	
	
	@GetMapping("/freelancer/pauseSerivce")
	public String pauseService(int serviceNo,@RequestHeader(value="referer") String referer,RedirectAttributes ra) {
		
		String path=null;
		String message=null;
		
		int result=service.pauseService(serviceNo);
		
		
		if(result>0) {
			message="판매가 중지되었습니다. ";
			path="/";
		}else {
			message="판매 중지 실패 ";
			path=referer;
		}
		
		 	
		ra.addFlashAttribute("message",message);
		
		return "redirect:"+path;
	}
	
	
	
	
	@GetMapping("/service/{serviceNo}")
	public String viewService2(@PathVariable("serviceNo") int serviceNo, Model model) {	
		
		// 게시글 상세조회 서비스 호출 
		Service fService=service.viewService(serviceNo);
		
		
		model.addAttribute("fService",fService);
		
		
		return "/category/categoryDetail";
	}
	
	@PostMapping("/service/payment/{serviceNo}")
	public String buyService(@PathVariable("serviceNo") int serviceNo, Model model,
			@SessionAttribute(value="loginMember", required = false) Member loginMember,
			@RequestParam("serviceTitle") String serviceTitle,@RequestParam String serviceSummary,@RequestParam String servicePhoto
			,@RequestParam String servicePrice) {	
		
		System.out.println(serviceNo);

		model.addAttribute("serviceNo",serviceNo);
		model.addAttribute("serviceTitle",serviceTitle);
		model.addAttribute("serviceSummary",serviceSummary);
		model.addAttribute("servicePhoto",servicePhoto);
		model.addAttribute("servicePrice",servicePrice);
		
		return "/myProject/paying";
	}
	
	
	// 카카오 페이 결제 ajax
	@PostMapping("/service/payComplete/{serviceNo}")
	@ResponseBody
	public int tradeComplete(@PathVariable("serviceNo") int serviceNo, Model model,
			@SessionAttribute(value="loginMember", required = false) Member loginMember,
			@RequestParam("tradeRequest") String tradeRequest, @RequestParam("servicePrice") String servicePrice
			) {	
		
		Trade temp = new Trade();
		
		
		temp.setServiceNo(serviceNo);
		temp.setMemberNo(loginMember.getMemberNo());
		temp.setTradeRequest(tradeRequest);
		temp.setServicePrice(servicePrice);
		
		
		int tradeNo=service.tradeComplete(temp);
		
		System.out.println("tradeNo:"+tradeNo);
				
		return tradeNo;
	}
	
	// 결제 완료 페이지 이동
	@GetMapping("/service/payComplete/{tradeNo}")
	public String payComplete(@PathVariable("tradeNo") int tradeNo, Model model,
			@SessionAttribute(value="loginMember", required = false) Member loginMember
			) {	
		
		Map<String,Integer> map=new HashMap<String, Integer>();
		
		map.put("tradeNo", tradeNo);
	
		model.addAttribute(tradeNo);
		
		return "/myProject/paying_complete";
	}
	
	@GetMapping("/service/freelancerDetail/{freelancerNo}")
	public String freelancerDetail(@PathVariable("freelancerNo") int freelancerNo, Model model) {
		
		
		Freelancer1 freelancer =service.freelancerDetail(freelancerNo);
		
		System.out.println(freelancer);
		
		model.addAttribute("freelancer",freelancer);
		
		return "/member/freelancer/freelancerDetail";
	}
	
	


}
