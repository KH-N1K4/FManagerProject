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

import com.manager.freelancer.member.model.vo.Member;


//필터 등록 + 필터링 할 주소 매핑 
@WebFilter(filterName="loginFilter",
			urlPatterns= {"/member/myInfo/*", "/member/logOut","/member/myProject/*"})
public class LoginFilter implements Filter {

	
	public void init(FilterConfig fConfig) throws ServletException {
		// 필터 생성 시 수행 
		System.out.println("로그인 필터 생성");
	}

	public void destroy() {
		// 서버 실행 중 필터 내용 변경 시 수행 후 init()다시 수행
		System.out.println("로그인  필터 파괴");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 필터는 클라이언트의 요청이 되자마자
		// 또는 응답이 되기 직전에 필터ㅇ링 코드를 추가할 수 있는 기능 
		
		// 다운캐스팅 진행 
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		
		
		// 로그인 여부 확인 
		// -> session에 loginMember가 있는지 확
		
		HttpSession session=req.getSession();
		if(session.getAttribute("loginMember")==null) {// 로그인 X
			
			resp.sendRedirect("/");
			
		}else { // 로그인O
			
			// 연결된 다음 필터로 이동 
			chain.doFilter(request, response);
		}
		
	}

}
