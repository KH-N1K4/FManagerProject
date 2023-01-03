package com.manager.freelancer.main.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.manager.freelancer.category.model.service.CategoryService;
import com.manager.freelancer.category.model.vo.Service;



@Controller
public class MainController {
	
	private CategoryService Cservice;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,@RequestParam(value="cp", required=false, defaultValue="1") int cp) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//Map<String, Object> map=Cservice.serviceList(cp);
		//Map<String, Object> map=Cservice.serviceList(cp);
		
		//model.addAttribute("map", map);
		
		
		return "common/main";
	}
	
	
}
