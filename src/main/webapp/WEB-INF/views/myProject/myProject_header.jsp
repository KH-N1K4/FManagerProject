<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<link rel="stylesheet" href="/resources/css/myProject/myProject_header.css">

<div id="header">
  <div id="header1">
      <div id="logo"><img src="/resources/images/final_logo.png" alt=""></div>
      <div class="header-top">
        <c:choose>
          <c:when test="${loginMember.freelancerFL eq 'Y'}">
            <a href="/member/myProject/freelancer/myService"><span>전문가 전환</span></a>
          </c:when>
        </c:choose>
        <a href="/member/message"><span>메세지</span></a>
        <a href="/"><span>홈으로</span></a>
        <a><img style="width: 32px; height: 32px;" src="${loginMember.memberProfile}"></a>
      </div>
  </div>
</div>

