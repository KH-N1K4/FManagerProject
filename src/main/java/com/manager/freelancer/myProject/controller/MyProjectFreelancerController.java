package com.manager.freelancer.myProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String myService(Model model, HttpSession session) {
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		List<FreelancerService> maincategoryList = service.selectmaincategoryList();
		List<FreelancerService> myService = service.selectMyService(loginMember.getMemberNo());
		model.addAttribute("maincategoryList",maincategoryList);
		model.addAttribute("myService",myService);
		
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
	
	//나의 서비스 등록--서비스 번호 맞게 등록되는 지 확인하기
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
			
		return "redirect:/member/myProject/freelancer/myServiceInsert";
	}

}
