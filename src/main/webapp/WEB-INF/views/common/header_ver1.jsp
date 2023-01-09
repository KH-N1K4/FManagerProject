<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

 <link rel="stylesheet" href="/resources/css/common/header_ver1.css">
 <link rel="stylesheet" href="/resources/css/common/headerSelect.css">
 
 
    <c:set var="path" value="${requestScope['javax.servlet.forward.servlet_path']}" /> 
<div id="header">
        <div id="header1">

            <a id="logo" href="/"><img src="/resources/images/final_logo_color.png" alt=""></a>

        <form action ="/searchService" class="SearchfrmMain" method="get" name="SearchfrmMain" id="SearchfrmMain">
            <div id="search">
                
                    <input type="text" placeholder="서비스명를 입력하세요" id="search-input" name="searchInput" autocomplete="off">

                    <span id="searchButton">▾</span>
                    <div id="suggestion_box" style="display: none;"></div>
                
            </div>
        </form>


            <div class="header-top">

            	<c:choose>
                    <%-- 로그인 X인 경우 --%>
                    <c:when test="${empty sessionScope.loginMember}">

		                <span><a href="/member/signUp">회원가입</a></span>
		                <span><a href="/member/login">로그인</a></span>

                    </c:when>

                    <%-- 로그인 O인 경우 --%>
                    <c:otherwise>
                        <c:if test="${sessionScope.loginMember.authority==1}">
                        
                        	<!-- 전문가가 아닌 경우 -->
	                    	<c:if test="${loginMember.freelancerFL=='N' }">
	                    		<span><a href="/member/enrollFreelancer">프리랜서 등록</a></span>
	                    	</c:if>
                            <span><a href="/member/myProject/myRequestList">내프로젝트</a></span>
                       		
                       		<span><a href="/member/message/chatting">메세지</a></span>
                            
                            <label for="header-menu-toggle" class="label">
                                ${loginMember.memberNickname}
                               <!--  <i class="fa-solid fa-caret-down"></i> -->
                            </label>
                            
                            <a><img class="profileArea" style="width: 32px; height: 32px; border-radius:100%; border:1px solid black;" src="${loginMember.memberProfile}"></a>

                            <input type="checkbox" id="header-menu-toggle">

                            <div id="header-menu">
                                <a href="/member/myInfo">내 정보</a>
                                <a href="/member/logout">로그아웃</a>
                            </div>
                        </c:if>
                        <c:if test="${sessionScope.loginMember.authority==2}">
                            <span><a href="/manager/memberList">관리자 페이지</a></span>
                            <label for="header-menu-toggle" class="label">
                                ${loginMember.memberNickname}
                               <!--  <i class="fa-solid fa-caret-down"></i> -->
                            </label>
                            
                            <a><img class="profileArea" style="width: 32px; height: 32px; border-radius:100%; border:1px solid black;" src="${loginMember.memberProfile}"></a>

                            <input type="checkbox" id="header-menu-toggle">

                            <div id="header-menu">
                                <a href="/member/myInfo">내 정보</a>
                                <a class="logout" href="/member/logout">로그아웃</a>
                            </div>
                        </c:if>
                    </c:otherwise>
                
                </c:choose>
            </div>


        </div>

        
    </div>
    <div id="nav">
    
    	 <ul>
    	 	<c:if test="${not fn:startsWith(path,'/projectRequest/requestList/') }">
                <c:forEach var="boardType" items="${boardTypeList}">
                    <li>
                        <a href="/category/${boardType.MAIN_CATEGORY_NO}/0">${boardType.MAIN_CATEGORY_NAME}</a>
                    </li>
                </c:forEach>
                </c:if>
                
                
                 <div class="nav-project"><a href="/projectRequest/requestList/0/0/0">프로젝트 의뢰</a></div>
            </ul>
    
      
    </div>
    

      <!-- jQuery  -->
  <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

    <script src="/resources/js/common/logout.js"></script>
    <script src="/resources/js/common/headerSelect.js"></script>
