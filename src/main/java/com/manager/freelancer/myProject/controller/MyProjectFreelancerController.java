package com.manager.freelancer.myProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.manager.freelancer.myProject.model.service.MyProjectFreelancerService;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.member.model.vo.Member;

@SessionAttributes({"loginMember"})
@Controller
public class MyProjectFreelancerController {
	
	@Autowired
	private MyProjectFreelancerService service;
	
	// 내 프로젝트 전문가페이지 나의 서비스 이동
	@GetMapping("/member/myProject/freelancer/myService")
	public String myService() {
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
	
	//나의 서비스 등록
	@GetMapping("/myProject/freelancer/serviceInsert")
	public String serviceInsert(@RequestParam(value="serviceFilePath") MultipartFile serviceFile,
								@SessionAttribute("loginMember") Member loginMember,
								Model model, FreelancerService freelancerVo) {
			
		List<FreelancerService> maincategoryList = service.selectmaincategoryList();
		List<FreelancerService> categoryList = service.selectcategoryList();
			
		model.addAttribute("maincategoryList",maincategoryList);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("GsoncategoryList",new Gson().toJson(categoryList));
			
		return "myProject/myProject_freelancer/myServiceInsert";
	}

}
