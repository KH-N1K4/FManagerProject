<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리</title>
    
    <link rel="stylesheet" href="/resources/css/category/projectRequest.css">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_ver1.jsp"/>



    <section class="content">
        <div class="mainArea">
            <!-- 사이드 메뉴 -->
            <jsp:include page="/WEB-INF/views/category/categorySide.jsp"/>
            <!-- 메인 콘텐츠 영역 -->
            <div class="mainContent">
                <form action="" id="inquirySubmit">
                    <span>예산</span>
                    <select name="" id="budget"> 
                        <option value="">예산</option>
                        <option value="">1만원 미만</option>
                        <option value="">1만원 - 5만원 이하</option>
                        <option value="">5만원 - 10만원 이하</option>
                        <option value="">10만원 - 20만원 이하</option>
                        <option value="">20만원 - 30만원 이하</option>
                        <option value="">30만원 - 50만원 이하</option>
                        <option value="">50만원 - 70만원 이하</option>
                        <option value="">70만원 - 100만원 이하</option>
                        <option value="">100만원 초과</option>
                    </select>

                    <span>전문가 등급</span>
                    <select name="" id="grade">
                        <option value="">전문가 등급</option>
                        <option value="">New</option>
                        <option value="">Master</option>
                    </select>

                    <select name="" id="index">
                        <option value="">최신순</option>
                        <option value="">마감 임박순</option>
                    </select>
                </form>
                

                <div id="imageContent">
                
                <c:forEach var="service" items="${map }">
                	<a href="/category/${service.mainCategoryNo}/${service.subCategoryNo }/${service.thirdCategoryNo }/${service.serviceNo }">
	                    <div id="image">
	                        <div><img src="${service.serviceFilePath2 }"></div>
	                        <!-- 하트버튼 추가 예정 -->
	                        <span>${service.serviceTitle }</span>
	                        <span>${service.serviceSummary }</span>
	                        <span>가격: ${servicePrice}원</span>
	                    </div>
                    </a>
                </c:forEach>
                </div>    
            </div>
	
        </div>
    </section>



    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
   
</body>
</html>