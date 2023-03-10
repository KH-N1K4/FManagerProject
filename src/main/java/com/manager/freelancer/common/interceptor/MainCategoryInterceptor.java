package com.manager.freelancer.common.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.manager.freelancer.category.model.service.CategoryService;


// 인터셉터 
// 클라이언트 <-> 필터 <-> Dispatcher Servlet <-> 인터셉터 <-> 컨트롤러 

// Dispatcher Servlet <-> 컨트롤러 사이에 
// 요청/응답을 가로채서 특정 코드를 수행하는 기능 
// ** Dispatcher Servlet 이후에 동작하므로 
// 각종 Spring 어노테이션을 인식하고 bean을 DI할 수 있다. **

public class MainCategoryInterceptor implements HandlerInterceptor {
	
	@Autowired
	private CategoryService service;
	

	// preHandle(전처리) : 컨트롤러 호출 전에 수행 
	
	// postHandle(후처리) : 컨트롤러 리턴 후 수행 
	
	// afterComplition(뷰단 처리 후) 
	// 모든 뷰에서 최종 결과를 생성하는 일을 포함한 모든 작업이 완료된 후 수행
	// (forward를 통해 응답화면이 생성 완료된 후 수행)
	// (보통 요청 처리 중에 사용한 자원을 반환(close())하는데 많이 사용)
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// application scope에 게시판 이름 목록(boardTypeList)이
		// 있는지 확인하여 없을 경우 DB에서 조회하여 세팅 
		
		// aplication scope 내장 객체 얻어오기 
		ServletContext application=request.getSession().getServletContext();
//		System.out.println("application : "+application.getAttribute("mainCategoryList"));
//		System.out.println("확인  : "+ application.getAttribute("mainCategoryList")==null);
		if(application.getAttribute("mainCategoryList")==null) {
			
			// boardTypeList 조회하는 Service 호출
			List<Map<String,Object>> mainCategoryList=service.selectMainCategoryList();
//			System.out.println("mainCategoryList : "+mainCategoryList);
			// application scope에 세팅 
			application.setAttribute("mainCategoryList", mainCategoryList);	
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}



















