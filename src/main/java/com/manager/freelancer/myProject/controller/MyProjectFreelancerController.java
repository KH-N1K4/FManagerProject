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
import com.manager.freelancer.member.model.vo.Member;

@SessionAttributes({"loginMember"})
@Controller
public class MyProjectFreelancerController {
	
	@Autowired
	private MyProjectFreelancerService service;
	
	// 내 프로젝트 전문가페이지 나의 서비스 이동 --정렬 완료
	@GetMapping("/member/myProject/freelancer/myService")
	public String myService(Model model, HttpSession session,
			@RequestParam(value="mainCategoryNo",required=false, defaultValue="0") int mainCategoryNo
					) {
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		List<FreelancerService> maincategoryList = service.selectmaincategoryList();
		List<FreelancerService> myService = service.selectMyService(loginMember.getMemberNo(),mainCategoryNo);
		model.addAttribute("maincategoryList",maincategoryList);
		model.addAttribute("myService",myService);
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
			
		return "redirect:/member/myProject/freelancer/myServiceInsert";
	}
	
	// 내 프로젝트 전문가페이지 서비스 판매 관리
	@GetMapping("/member/myProject/freelancer/myServiceSales")
	public String myServiceSales(Model model, HttpSession session,
				@RequestParam(value="mainCategoryNo",required=false, defaultValue="0") int mainCategoryNo,
				@RequestParam(value="freelancerFL",required=false, defaultValue="0") int freelancerFL,
				@RequestParam(value="searchInput",required=false) String searchInput
						) {
			
		Member loginMember = (Member) session.getAttribute("loginMember");
		List<FreelancerService> maincategoryList = service.selectmaincategoryList();
		List<FreelancerService> salesList = service.selectSalesList(loginMember.getMemberNo(),mainCategoryNo,searchInput,freelancerFL);
		List<FreelancerService> inpurMyService = service.selectMyService(loginMember.getMemberNo(),0); //나의 서비스 들고와서 자동완성
		
		model.addAttribute("maincategoryList",maincategoryList);
		model.addAttribute("mainCategoryNoInput",mainCategoryNo);
		model.addAttribute("salesList",salesList);
		model.addAttribute("GsonsalesList",new Gson().toJson(salesList));
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
			map.put("reportContent",reportContent);
		
			return new Gson().toJson(map);
	}

}
