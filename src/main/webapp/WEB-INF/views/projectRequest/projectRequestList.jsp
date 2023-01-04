<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="maincategory" value="${category.mainCategotyList}"/>
<c:set var="subcategory" value="${category.subCategotyList}"/>
<c:set var="thirdcategory" value="${category.categotyList}"/>
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

      <section class="content">
        <div class="mainArea">
            <!-- 사이드 메뉴 -->
            <div class="sideMenu">
                <c:forEach var="mainVar" items="${maincategory}">
                    <div class="design" id="main${mainVar.mainCategotyNo}"><a href="/projectRequest/requestList/${mainVar.mainCategotyNo}">${mainVar.mainCategotyName}</a></div>
                    <c:forEach var="subVar" items="${subcategory}">
                        <c:if test="${mainVar.mainCategotyNo eq subVar.mainCategotyNo}">
                            <div class="subCategori" id="sub${subVar.subCategoryNo}"><a href="/projectRequest/requestList/${mainVar.mainCategotyNo}/${subVar.subCategoryNo}">${subVar.subCategoryName}</a><button class="detailMenu" title="${subVar.subCategoryNo}">▼</button></div>
                            <div class="subMenu" id="sub${subVar.subCategoryNo}Box">
                                <c:forEach var="categoryVar" items="${thirdcategory}">
                                    <c:if test="${subVar.subCategoryNo eq categoryVar.subCategoryNo}">
                                        <div id="category${categoryVar.thirdCategotyNo}"><a href="/projectRequest/requestList/${mainVar.mainCategotyNo}/${subVar.subCategoryNo}/${categoryVar.thirdCategotyNo}">${categoryVar.thirdCategotyName}</a></div>
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

                   

                    <select name="" id="listOrder">
                        <option value="0">최신순</option>
                        <option value="1">마감 임박순</option>
                    </select>
                </form>

                <div id="imageContent">
                <c:forEach var="projectRequestVar" items="${projectRequest}">
                	<a href="/projectRequest/requestList/${projectRequestVar.mainCategotyNo}/${projectRequestVar.subCategoryNo}/${projectRequestVar.thirdCategotyNo}/${projectRequestVar.thirdCategotyNo}/${projectRequestVar.projectRequestNo}">
	                    <div id="image">
	                        <div><img src="${projectRequestVar.projectRequestfile}"></div>
	                        <!-- 하트버튼 추가 예정 -->
	                        <span>${projectRequestVar.projectRequestTitle}</span><br>
	                        <span>${projectRequestVar.projectRequestSummary}</span><br>
	                        <span>가격: ${projectRequestVar.projectRequestBudgetString}원</span>
	                    </div>
                    </a> 
              </c:forEach>
                </div>    
            </div>

        </div>
    </section>



    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>


    <script src="/resources/js/category/projectRequest.js"></script>
    
</body>
</html>