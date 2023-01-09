<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="maincategory" value="${category.mainCategoryList}"/>
<c:set var="subcategory" value="${category.subCategoryList}"/>
<c:set var="thirdcategory" value="${category.categoryList}"/>
<c:set var="projectRequest" value="${category.projectRequestList}"/>

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
    <c:if test="${not empty param}">
        <c:forEach var="parameter" items="${param}">
            <c:if test="${parameter.key != 'cp'}">
            
                <c:set var="sURL" value="${sURL}&${parameter.key}=${parameter.value}"/>
            </c:if>
        </c:forEach>
    </c:if>
      <section class="content">
        <div class="mainArea">
            <!-- 사이드 메뉴 -->
            <div class="sideMenu">
                <c:forEach var="mainVar" items="${maincategory}">
                    <div class="design" id="main${mainVar.mainCategoryNo}"><a href="/projectRequest/requestList/${mainVar.mainCategoryNo}/0/0">${mainVar.mainCategoryName}</a></div>
                    <c:forEach var="subVar" items="${subcategory}">
                        <c:if test="${mainVar.mainCategoryNo eq subVar.mainCategoryNo}">
                            <div class="subCategori" id="sub${subVar.subCategoryNo}"><a href="/projectRequest/requestList/${mainVar.mainCategoryNo}/${subVar.subCategoryNo}/0">${subVar.subCategoryName}</a><button class="detailMenu" title="${subVar.subCategoryNo}">▼</button></div>
                            <div class="subMenu" id="sub${subVar.subCategoryNo}Box">
                                <c:forEach var="categoryVar" items="${thirdcategory}">
                                    <c:if test="${subVar.subCategoryNo eq categoryVar.subCategoryNo}">
                                        <div id="category${categoryVar.thirdCategoryNo}"><a href="/projectRequest/requestList/${mainVar.mainCategoryNo}/${subVar.subCategoryNo}/${categoryVar.thirdCategoryNo}">${categoryVar.thirdCategoryName}</a></div>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </c:if>
                    </c:forEach>
                </c:forEach>
            </div>

            <!-- 메인 콘텐츠 영역 -->
            <div class="mainContent">
                <form action="" id="inquirySubmit">
                    <span>예산</span>
                    <select name="budget" id="budget" title="${budget}"> 
                        <option value="0.0" selected>예산</option>
                        <option value="0.1">1만원 미만</option>
                        <option value="1.5">1만원 - 5만원 미만</option>
                        <option value="5.10">5만원 - 10만원 미만</option>
                        <option value="10.20">10만원 - 20만원 미만</option>
                        <option value="20.30">20만원 - 30만원 미만</option>
                        <option value="30.50">30만원 - 50만원 미만</option>
                        <option value="50.70">50만원 - 70만원 미만</option>
                        <option value="70.100">70만원 - 100만원 미만</option>
                        <option value="-1.100">100만원 이상</option>
                    </select>

                   

                    <select name="listOrder" id="listOrder" title="${listOrder}">
                        <option value="0" selected>최신순</option>
                        <option value="1">마감 임박순</option>
                    </select>
                </form>

                <div id="imageContent">
                    <c:forEach var="projectRequestVar" items="${projectRequest}">
                        <div class="box">
                            <div id="image">
                                <div><img src="${projectRequestVar.projectRequestfile}">
                                </div>
                                <a href="/projectRequest/projectRequestDetail/${projectRequestVar.projectRequestNo}" class="imageTitle">
                                    <div class="projectRequestTitle">${projectRequestVar.projectRequestTitle}</div>
                                    <span class="imageOthers">${projectRequestVar.projectRequestSummary}</span>
                                    <span class="imageOthers">예산 : ${projectRequestVar.projectRequestBudgetString}원</span>
                                </a>
                            </div>
                        <!-- </a> -->
                        </div>
                    </c:forEach>
                </div>    
            </div>

        </div>
        <c:if test="${listCount != 0}">
                
                <div class="pagination-area">


                    <ul class="pagination">
                    
                        <!-- 첫 페이지로 이동 -->
                        <li><a href="/projectRequest/requestList/${mainCategoryNo}/${subCategoryNo}/${thirdCategoryNo}?cp=1${sURL}">&lt;&lt;</a></li>
        
                        <!-- 이전 목록 마지막 번호로 이동 -->
                        <li><a href="/projectRequest/requestList/${mainCategoryNo}/${subCategoryNo}/${thirdCategoryNo}?cp=${pagination.prevPage}${sURL}">&lt;</a></li>
        
            
                        <!-- 특정 페이지로 이동 -->
                        <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                        <c:choose>
                            <c:when test="${i== pagination.currentPage}">
                            <!-- 현재 페이지인 경우 -->
                            <li><a class="current">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                            <!-- 현재 페이지를 제외한 나머지 -->
                            <li><a href="/projectRequest/requestList/${mainCategoryNo}/${subCategoryNo}/${thirdCategoryNo}?cp=${i}${sURL}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                        </c:forEach>
                        <!-- 다음 목록 시작 번호로 이동 -->
                        <li><a href="/projectRequest/requestList/${mainCategoryNo}/${subCategoryNo}/${thirdCategoryNo}?cp=${pagination.nextPage}${sURL}">&gt;</a></li>
        
                        <!-- 끝 페이지로 이동 -->
                        <li><a href="/projectRequest/requestList/${mainCategoryNo}/${subCategoryNo}/${thirdCategoryNo}?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
        
                    </ul>
                </div>
            </c:if>
    </section>



    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <script>
        var mainCategoryNo = '${mainCategoryNo}';
        var subCategoryNo = '${subCategoryNo}';
        var thirdCategoryNo = '${thirdCategoryNo}';
    </script>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>


    <script src="/resources/js/category/projectRequest.js"></script>
    
</body>
</html>