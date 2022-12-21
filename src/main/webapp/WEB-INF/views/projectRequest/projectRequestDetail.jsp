<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리</title>
    
     <link rel="stylesheet" href="/resources/css/category/projectRequestDetail.css">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_ver1.jsp"/>

       <div class="main">
        <div><a href="">디자인</a>><a href="">디자인 상세</a></div>

        <div class="detailHeader">
            <div class="servicePhoto"></div>
            <div class="serviceContent">
                <div class="serviceTitle">제목</div>
                <div class="serviceSummary">한줄요약</div>
                <div class="serviceInfo">
                    <span>예산 <span>10,000</span>원</span>
                    
                    <span>작업일수 <span>10</span>일</span>   
                </div>

              
                <a id="requestBtn" href="/category/1/1/1/1/payment">제안하기</a>
               <!--  <button id="buyBtn">구매하기</button> -->
            </div>
        </div>
        <div class="detailContent">

            <ul>
                <li>서비스 설명</li>
                <li>포트폴리오</li>
                <li>취소/환불</li>
                <li>서비스 평가</li>
            </ul>

        </div>

        <div class="detailInner"></div>
    </div>

   


    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
</body>
</html>