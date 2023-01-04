package com.manager.freelancer.myProject.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.service.MyProjectSerive;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.myProject.model.vo.MyProject;



@Controller
@SessionAttributes({"loginMember"})
public class MyProjectContorller {
	
	@Autowired
	private MyProjectSerive service;
	
	//------------------------------------------------------------------------
	// 내 프로젝트 이동
	@GetMapping("/member/myProject/myRequestList")
	public String likeList(Model model, HttpSession session,
			 			   @RequestParam(value="mainCategoryNo",required=false, defaultValue="0") int mainCategoryNo,
			               @RequestParam(value="cp" , required = false, defaultValue = "1") int cp,
			               @SessionAttribute("loginMember") Member loginMember) {
		
 		List<MyProject> maincategoryList = service.selectmaincategoryList();
		
		Map<String, Object> map  = service.selectMyProject(loginMember.getMemberNo(), mainCategoryNo, cp);
		
		model.addAttribute("maincategoryList",maincategoryList);
		model.addAttribute("myProject",map.get("myProject"));
		model.addAttribute("pagination",map.get("pagination"));
		model.addAttribute("listCount",map.get("listCount"));
		model.addAttribute("mainCategoryNoInput",mainCategoryNo);
		
		
		return "myProject/myProject_user/myProject_UserPage";
	}
	//------------------------------------------------------------------------
	// 내 프로젝트 등록하기 페이지 이동
	@GetMapping("/member/myProject/myRequestInsert")
	public String myReceiveList(Model model) {
		
		List<MyProject> maincategoryList = service.selectmaincategoryList();
		List<MyProject> categoryList = service.selectcategoryList();
		
		model.addAttribute("maincategoryList",maincategoryList);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("GsoncategoryList",new Gson().toJson(categoryList));
		
		return "myProject/myProject_user/myProject_add";
	}
	
	//------------------------------------------------------------------------
	// 내 프로젝트 등록
	@PostMapping("/myProject/user/myProjectInsert")
	public String myProjectInsert(@RequestParam(value="myProjectFile") List<MultipartFile> myProjectFile,
								  @SessionAttribute("loginMember") Member loginMember,
								  @RequestHeader("referer") String referer,
								  HttpServletRequest req, RedirectAttributes ra, Model model, MyProject myProject) throws IOException {
	
		String webPath = "/resources/files/myProjectRequest/";
		
		// 실제 파일이 저장된 컴퓨터 상의 절대 경로
		String filePath = req.getSession().getServletContext().getRealPath(webPath);
				
		int result = service.insertMyProject(webPath, filePath, myProjectFile, loginMember,myProject );
		
		String message = null;
		if(result > 0)	message = "프로젝트가 등록되었습니다.";
		else			message = "프로젝트 등록 실패";
		
		ra.addFlashAttribute("message", message);
		
		return "redirect: /member/myProject/myRequestInsert";
	}
	//------------------------------------------------------------------------
	// 받은 제안 페이지 이동 
	@GetMapping("/member/myProject/myReceiveList")
	public String myRequestInsert(Model model,
								  @RequestParam(value="mainCategoryNo",required=false, defaultValue="0") int mainCategoryNo,
								  @SessionAttribute("loginMember") Member loginMember,
								  @RequestParam(value="cp" , required = false, defaultValue = "1") int cp) {
		
		
		List<MyProject> maincategoryList = service.selectmaincategoryList();
		
		Map<String, Object> map = service.selectProposal(loginMember.getMemberNo(), cp, mainCategoryNo);
		
		model.addAttribute("maincategoryList",maincategoryList);
		model.addAttribute("proposal",map.get("proposal"));
		model.addAttribute("pagination",map.get("pagination"));
		model.addAttribute("listCount",map.get("listCount"));
		model.addAttribute("mainCategoryNoInput",mainCategoryNo);
		
		
		return "myProject/myProject_user/myProject_suggestion";
	}
	//------------------------------------------------------------------------
	
	
	// 내 프로젝트 조회 ajax
	@GetMapping("/member/categoryTypeSelect")
	@ResponseBody
	public Map<String, Object> categoryTypeSelect(Model model, @RequestParam String optionVal, @SessionAttribute("loginMember") Member loginMember,
												  @RequestParam(value="cp" , required = false, defaultValue = "1") int cp) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = service.categoryTypeSelect(optionVal,cp, loginMember.getMemberNo());
		
		model.addAttribute("map", map);
		
		return map;
	}
	
	
	

}
