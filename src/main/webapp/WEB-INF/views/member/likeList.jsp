<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>찜한 목록</title>

    <link rel="stylesheet" href="/resources/css/member/likeList.css">
     <link rel="stylesheet" href="/resources/css/member/projectRequest.css">
     
     <script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script>
</head>
<body>
   <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>

    <div class="main">

    
        <section class="content">
        <div class="mainArea">
            <!-- 사이드 메뉴 -->
            <jsp:include page="/WEB-INF/views/member/memberSide.jsp"/>

            <!-- 메인 콘텐츠 영역 -->
            <div class="mainContent">
                <form action="" id="inquirySubmit">
                     <div id="title">
                찜한 목록
                <select id="listOption">
                    <option value="">전체</option>
                    <option value="">최신순</option>
                    <option value="">오래된순</option>
                </select>
            </div>
                </form>
                

                <div id="imageContent">
                
                <c:forEach var="service" items="${map }">
                	<a href="/category/${service.mainCategoryNo}/${service.subCategoryNo }/${service.thirdCategoryNo }/${service.serviceNo }">
	                    <div id="image">
	                        <div>
	                        <img src="${service.requestFilePath }">
	                        
	                        	<span class="like-area">
			                            <i class="fa-solid fa-heart" id="boardLike"></i>
                   				 </span>
		                    	<%-- <span class="like-area">
			                        likeCheck가 없다면 == 로그인 x 또는 좋아요x
			                        <c:if test="${empty likeCheck}">
			                            빈 하트
			                            <i class="fa-regular fa-heart" id="boardLike"></i>
			                        </c:if>
			                        likeCheck가 있다면 == 로그인 o, 좋아요o
			                        <c:if test="${not empty likeCheck}">
			                            찬 하트
			                            <i class="fa-solid fa-heart" id="boardLike"></i>
			                        </c:if>
			                        좋아요 수
			                        <span>${board.likeCount}</span>
                   				 </span> --%>
	                        </div>
	                        <span>${service.serviceTitle }</span>
	                        <span>${service.serviceSummary }</span>
	                        <span>가격: ${service.servicePrice}원</span>
	                    </div>
                    </a>
                </c:forEach>
                </div>    
            </div>
	
        </div>
    </section>        
    </div>
    
   <!--   <script src="/resources/js/category/category.js"></script> -->
</body>
</html>