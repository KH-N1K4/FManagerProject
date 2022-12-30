<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<c:set var="maincategory" value="${maincategoryList}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>나의 서비스</title>
    <link rel="stylesheet" href="/resources/css/myProject/myProject_freelancer/myproject_myService.css">    
</head>
<body>
    <!-- hearder -->
    <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myProject_header2.jsp"/>
    <!-- hearder -->
    <%-- 검색을 진행한 경우 --%>
    <c:if test="${not empty param}">
        <c:forEach var="parameter" items="${param}">
            <c:if test="${parameter.key != 'cp'}">
            
                <c:set var="sURL" value="${sURL}&${parameter.key}=${parameter.value}"/>
            </c:if>
        </c:forEach>
    </c:if>

    <div class="main">

        <!-- sideMenu -->
        <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myProjectSide2.jsp"/>
        <!-- sideMenu -->

        <section class="mainMenu">
            <div id="titleSection">
                <div id="title">나의 서비스</div>
                <div id="titleSelect">
                    <form action ="/member/myProject/freelancer/myService" class="OptionfrmSearch" method="get" name="OptionfrmSearch" id="OptionfrmSearch">
                        <select  id = "srchOption1" class="srchOption box" name="mainCategoryNo" title="${mainCategoryNoInput}">
                            <option value="0" selected="">전체</option>
                            <c:if test="${not empty maincategory}">
                                <c:forEach items="${maincategory}" var="mainVar">
                                    <option value="${mainVar.mainCategoryNo}">${mainVar.mainCategoryName}</option>
                                </c:forEach> 
                            </c:if>
                        </select>
                    </form>
                </div>
                <div id="serviceInsert"><a href="/member/myProject/freelancer/myServiceInsert">등록하기</a></div>
            </div>
            <c:if test="${not empty myService}">
                <c:forEach items="${myService}" var="service">
                    <div id="contentSection">
                        <div id="serviceImage">
                            <img src="${service.serviceFilePath2}" alt="">
                        </div>
                        <div id="serviceContent">
                            <div>
                                <div id="serviceTitle">
                                    <c:choose>
                                        <c:when test="${service.serviceDelFL eq 'N' && service.serviceStatus == 2}"><a href="#" id="serviceName" class="serviceName" suggestionName="">
                                            ${service.serviceTitle}
                                        </a></c:when>
                                        <c:otherwise><span id="serviceName" class="serviceName" suggestionName="">${service.serviceTitle}</span></c:otherwise>
                                    </c:choose>
                                </div>
                                <div id="serviceSummary">
                                    <p>${service.serviceSummary}</p>
                                </div>
                            </div>
                            <div class="detail">
                                <div id="servicePrice">
                                    <div>가격</div>
                                    <div>${service.servicePriceString}원</div>
                                </div>
                                <div id="serviceEdit">
                                    <div>수정 횟수</div>
                                    <div>${service.serviceEditNum}회</div>
                                </div>
                                <div id="serviceWorkDate">
                                    <div>작업 일수</div>
                                    <div>${service.serviceWorkPeriod}일</div>
                                </div>
                            </div>
                            
                        </div>
                        <div id="serviceStatus">
                            <div>${service.serviceStatusString}</div>
                        </div>
                    </div>
                </c:forEach> 
            </c:if>
            <c:if test="${listCount != 0}">
                
                <div class="pagination-area">


                    <ul class="pagination">
                    
                        <!-- 첫 페이지로 이동 -->
                        <li><a href="/member/myProject/freelancer/myService?cp=1${sURL}">&lt;&lt;</a></li>
        
                        <!-- 이전 목록 마지막 번호로 이동 -->
                        <li><a href="/member/myProject/freelancer/myService?cp=${pagination.prevPage}${sURL}">&lt;</a></li>
        
            
                        <!-- 특정 페이지로 이동 -->
                        <c:forEach var="countPage" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                        <c:choose>
                            <c:when test="${countPage== pagination.currentPage}">
                            <!-- 현재 페이지인 경우 -->
                            <li><a class="current">${countPage}</a></li>
                            </c:when>
                            <c:otherwise>
                            <!-- 현재 페이지를 제외한 나머지 -->
                            <li><a href="/member/myProject/freelancer/myService?cp=${countPage}${sURL}">${countPage}</a></li>
                            </c:otherwise>
                        </c:choose>
                        </c:forEach>
                        <!-- 다음 목록 시작 번호로 이동 -->
                        <li><a href="/member/myProject/freelancer/myService?cp=${pagination.nextPage}${sURL}">&gt;</a></li>
        
                        <!-- 끝 페이지로 이동 -->
                        <li><a href="/member/myProject/freelancer/myService?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
        
                    </ul>
                </div>
            </c:if>
        </section>

        
    </div>
    <!-- **************************************footer*************************************-->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <!-- **************************************footer*************************************-->
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

    <script src="/resources/js/myProject/myProject_freelancer/myServiceFreelancer.js"></script>
</body>
</html>