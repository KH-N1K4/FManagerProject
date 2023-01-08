package com.manager.freelancer.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manager.freelancer.common.scheduling.LevelUPScheduling;
import com.manager.freelancer.member.model.vo.Member;

@WebFilter(filterName="managerFilter", // 필터 이름, 필터가 여러 개 존재할 때 순서 지정 시 사용
			urlPatterns = {"/manager/*"} ) // 필터링한 요청 주소(패턴 가능)
public class ManagerFilter implements Filter{
	
	
	private Logger logger = LoggerFactory.getLogger(ManagerFilter.class);
	
	public void init(FilterConfig fConfig) throws ServletException {
		// 필터 생성 시 수행
		System.out.println("관리자 로그인 필터 생성");
		logger.debug("*** : " + "관리자 로그인 필터 생성");
	}

	public void destroy() {
		// 서버 실행 중 필터 내용 변경 시 수행 후 init() 다시 수행
		System.out.println("관리자 로그인 필터 파괴");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// 필터는 클라이언트의 요청이 되자마자 또는 응답이 되기 직전에 필터링 코드를 추가할 수 있는 기능
		
		// 다운캐스팅 진행
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		// 로그인 여부 확인
		// -> session에 loginMember가 있는 지 확인
		HttpSession session = req.getSession();
		if(session.getAttribute("loginMember") == null) { // 로그인 X 상태
			logger.debug("*** : " + "관리자 로그인 필터 생성 *****로그인 안됨");
			resp.sendRedirect("/"); // 메인페이지로 redirect
		} else { // 로그인 O 상태 
			// 연결된 다음 필터로 이동(없으면 Servlet / JSP로 이동)
			if(((Member)session.getAttribute("loginMember")).getAuthority()==1) {
				resp.sendRedirect("/");
				logger.debug("*** : " + "관리자 로그인 필터 생성 *****관리자 아님");
			} else {
				chain.doFilter(request, response);			
				
			}
		}
		
	}

}
