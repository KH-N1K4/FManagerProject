<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <link rel="stylesheet" href="/resources/css/common/header_ver1.css">

<div id="header">
        <div id="header1">

            <a id="logo" href="/"><img src="/resources/images/final_logo_color.png" alt=""></a>

            <div id="search">
                <input type="text" placeholder="검색어를 입력하세요" id="search-input">

                <span>▾</span>
            </div>

            <div class="header-top">
            
            <!-- 로그인한 경우/ 하지 않은 경우 나누기 -->
               <!--  <span><a href="/member/enrollFreelancer">관리자</a></span> -->
                <span><a href="/member/enrollFreelancer">전문가 등록</a></span>
                <span><a href="/manager/memberList">관리자</a></span>
                <span><a href="/member/signUp">회원가입</a></span>
                <span><a href="/member/login">로그인</a></span>
                <span><a href="/member/myProject/myRequestList">내프로젝트</a></span>

                
                 <label for="header-menu-toggle">
                           김금쪽
                     <i class="fa-solid fa-caret-down"></i>
                 </label>

                 <input type="checkbox" id="header-menu-toggle">

                 <div id="header-menu">
                     <a href="/member/myInfo">마이페이지</a>
                     <a href="/member/likeList">찜한목록</a>
                     <a href="/member/logout">로그아웃</a>
                 </div>
            </div>


        </div>

        
    </div>
    <div id="nav">
        <ul>
            <li><a href="/category/1">카테고리</a></li>
            <li><a href="/category/1">프리랜</a></li>
            <li><a href="/category/1">멤버 </a></li>
            <li><a href="/category/1">마이프로젝트</a></li>
            <li><a href="/category/1">서비스센터</a></li>
            <!-- <li><a href="#">IT 프로그래밍</a></li>
            <li><a href="#">영상</a></li>
            <li><a href="#">사진</a></li>
            <li><a href="#">음향</a></li> -->

            <div class="nav-project"><a href="/projectRequest/requestList">프로젝트 의뢰</a></div>
        </ul>
        
    </div>
