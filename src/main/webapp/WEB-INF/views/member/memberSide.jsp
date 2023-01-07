<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



 <section class="sideMenu">
    <div class="aside">
      <a class="myProject_User_side" href="/member/myInfo">내 정보</a>
  
       <c:if test="${loginMember.freelancerFL=='Y'}">
      		<a class="myProject_User_side" href="/member/freelancer/freelancerInfo">전문가 정보</a>
       </c:if>
     
      
      <a class="myProject_User_side" href="/member/myInfo/sendServiceInquiry">보낸 서비스 문의</a>
      <a class="myProject_User_side" href="/member/myInfo/likeList">찜한 목록</a>
      <a class="myProject_User_side" href="/member/myInfo/changePw">비밀번호 변경</a>
      <a class="myProject_User_side" href="/member/myInfo/deleteMember">회원 탈퇴</a>
    </div>
</section>

