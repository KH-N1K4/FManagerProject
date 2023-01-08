<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<link rel="stylesheet" href="/resources/css/myProject/myProject_header.css">
 <link rel="stylesheet" href="/resources/css/common/header_ver2.css">

<div id="header">
  <div id="header1">
      <div id="logo"><img src="/resources/images/final_logo.png" alt=""></div>
      <div class="header-top">
      
      <c:choose><%-- 로그인 X인 경우 --%>   
		<c:when test="${empty sessionScope.loginMember}">
            <span><a href="/member/signUp">회원가입</a></span>
            <span><a href="/member/login">로그인</a></span>
	    </c:when>

                    
       <c:otherwise><%-- 로그인 O인 경우 --%>
       	<span><a href="/manager/memberList">관리자</a></span>
       	<span><a href="/member/enrollFreelancer">프리랜서 등록</a></span>
        	<span><a href="/member/myProject/myRequestList">내프로젝트</a></span>
       
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
       
       
       
        <c:choose>
          <c:when test="${loginMember.freelancerFL eq 'Y'}">
            <a href="/member/myProject/freelancer/myService"><span>프리랜서 전환</span></a>
          </c:when>
        </c:choose>
        <a href="/member/message/chatting"><span>메세지</span></a>
        <a href="/"><span>홈으로</span></a>
        <a><img style="width: 32px; height: 32px;" src="${loginMember.memberProfile}"></a>
      </div>
  </div>
</div>

