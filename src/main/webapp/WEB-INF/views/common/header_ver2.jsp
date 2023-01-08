<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

 <link rel="stylesheet" href="/resources/css/common/header_ver2.css">
<c:set var="path" value="${requestScope['javax.servlet.forward.servlet_path']}" /> 
 <div id="header">
        <div id="header1">

    
 			<a id="logo" href="/"><img src="/resources/images/final_logo.png" alt=""></a>
            <div class="header-top">
                <c:choose>
                    <%-- 로그인 X인 경우 --%>
                    <c:when test="${empty sessionScope.loginMember}">
		                <span><a href="/member/signUp">회원가입</a></span>
                    
                    
                    	<c:if test="${path=='/member/login' }">
                    		<span><a href="/">홈으로</a></span>
                    	</c:if>
                    	<c:if test="${path!='/member/login' }">
		                	<span><a href="/member/login">로그인</a></span>
                    	</c:if>

                    </c:when>

                    <%-- 로그인 O인 경우 --%>
                    <c:otherwise>
        				<span><a href="/">홈으로</a></span>
        				
        				<!-- 전문가가 아닌 경우 -->
                    	<c:if test="${loginMember.freelancerFL=='N' }">
                    		<span><a href="/member/enrollFreelancer">전문가 등록</a></span>
                    	</c:if>
                    	
                    	<!-- 내정보 페이지 -->
                    	<c:if test="${fn:startsWith(path,'/member/myInfo') }">
                    		<span><a href="/member/myProject/myRequestList">내프로젝트</a></span>
                    	</c:if>
                    	
                    	
                    	<c:if test="${fn:startsWith(path,'/member/myProject/') }">
	                    	<c:choose>
	                    		<c:when test="${fn:startsWith(path,'/member/myProject/freelancer') }">
		                    		<span><a href="/member/myProject/myRequestList">의뢰인 전환</a></span>
	                    		</c:when>
	                    		<c:otherwise>
	                    		<c:if test="${loginMember.freelancerFL=='Y' }">
		                    		<span><a href="/member/myProject/freelancer/myService">전문가 전환</a></span>
		                    	</c:if>
	                    		</c:otherwise>
	                    	</c:choose>
                    	</c:if>
                    	
                    	
            
                     	<span><a href="/member/message/chatting">메세지</a></span>
                    
                        <label for="header-menu-toggle">
                            ${loginMember.memberNickname}
                            <!-- <i class="fa-solid fa-caret-down"></i> -->
                        </label>
                        
                        <a><img style="width: 32px; height: 32px; border-radius:100%; border:1px solid black;" src="${loginMember.memberProfile}"></a>

                        <input type="checkbox" id="header-menu-toggle">

                        <div id="header-menu">
                            <a href="/member/myInfo">내정보</a>
                            <a href="/member/logout">로그아웃</a>
                        </div>
                    </c:otherwise>
                
                </c:choose>
            </div>


        </div>

        
    </div>