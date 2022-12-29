package com.manager.freelancer.category.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.freelancer.category.model.service.CategoryService;
import com.manager.freelancer.category.model.vo.AskService;
import com.manager.freelancer.category.model.vo.Category;
import com.manager.freelancer.category.model.vo.Service;
import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.vo.FreelancerService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	// /category/{mainCategoryNo}
	@GetMapping("/category/{mainCategoryNo}")
	public String mainCategory(@PathVariable("mainCategoryNo") int mainCategoryNo, Model model) {
		
		List<Service> map=service.selectBoardList(mainCategoryNo);
		
		model.addAttribute("map",map);
			
		return "/category/categoryList";
	}
	


	@GetMapping("/category/{mainCategoryCode}/{subCategoryCode}")
	public String subCategory() {	
		return "/category/categoryDetail";
	}
	
	
	@GetMapping("/category/{mainCategoryCode}/{subCategoryCode}/{lastCategoryCode}/{serviceNo}")
	public String viewService(@PathVariable("serviceNo") int serviceNo, Model model) {	
		
		// 게시글 상세조회 서비스 호출 
		Service fService=service.viewService(serviceNo);
		
		
		model.addAttribute("fService",fService);
		
		
		return "/category/categoryDetail";
	}
	
	@GetMapping("/service/{serviceNo}")
	public String viewService2(@PathVariable("serviceNo") int serviceNo, Model model) {	
		
		// 게시글 상세조회 서비스 호출 
		Service fService=service.viewService(serviceNo);
		
		
		model.addAttribute("fService",fService);
		
		
		return "/category/categoryDetail";
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


}
