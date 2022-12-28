package com.manager.freelancer.manager.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manager.freelancer.manager.model.service.ManagerInquiryService;

@Controller
public class ManagerInquiryController {

	@Autowired
	private ManagerInquiryService service;
	
	
	@GetMapping("/manager/managerInquiryList")
	public String managerInquiryList(@RequestParam(value="cp", required=false, defaultValue = "1") int cp,
								     @RequestParam Map<String,Object> pm, Model model) {
		
		
		if(pm.get("key") == null) {
			
			Map<String, Object> map = service.selectManagerInquiryList(cp);
			model.addAttribute("map",map);
		} else {
			Map<String, Object> map = service.selectManagerInquiryList(pm, cp);
			model.addAttribute("map",map);
		}
		
		
		
		return "/manager/managerInquiryList";
	}
	
}
