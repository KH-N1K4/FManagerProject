<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <link rel="stylesheet" href="/resources/css/common/header_black_ver2 customer.css">

<div id="header">
        <div id="header1">

            <a id="logo" href="/"><img src="../resources/images/final_logo.png" alt=""></a>

            <div class="header-top">
                <c:choose>
                    <%-- 로그인 X인 경우 --%>
                    <c:when test="${empty sessionScope.loginMember}">
		                <span><a href="/member/signUp">회원가입</a></span>
		                <span><a href="/member/login">로그인</a></span>
                    </c:when>

                    <%-- 로그인 O인 경우 --%>
                    <c:otherwise>
                    	<span><a href="/member/message/chatting">메세지</a></span>
                    	<span><a href="/">홈으로</a></span>
                    
                        <label for="header-menu-toggle">
                            ${loginMember.memberNickname}
                            <i class="fa-solid fa-caret-down"></i>
                        </label>
                        
                        <a><img style="width: 32px; height: 32px; border-radius:100%; border:1px solid black;" src="${loginMember.memberProfile}"></a>

                        <input type="checkbox" id="header-menu-toggle">

                        <div id="header-menu">
                            <a href="/member/myInfo">내 정보</a>
                            <a href="/member/logout">로그아웃</a>
                        </div>
                    </c:otherwise>
                
                </c:choose>

            </div>


        </div>

        
    </div>