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
                            <div id="serviceTitle">
                                <a href="#" id="serviceName" class="serviceName" suggestionName="">
                                    ${service.serviceTitle}
                                </a>
                            </div>
                            <div id="serviceSummary">
                                <p>${service.serviceSummary}</p>
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

            
            <div id="contentSection">
                <div id="serviceImage">
                    <img src="/resources/images/projectImage01.PNG" alt="">
                </div>
                <div id="serviceContent">
                    <div id="serviceTitle">
                        <a href="#" id="serviceName" class="serviceName" suggestionName="">
                            서비스 제목
                        </a>
                    </div>
                    <div id="serviceSummary">
                        <p>서비스요약입니댜흐흐하핳하ㅏㅎ훟ㅎ흐흫훟하하후라아리ㅏ아ㅏㅎㅏ하하</p>
                    </div>
                    <div class="detail">
                        <div id="servicePrice">
                            <div>가격</div>
                            <div>10,000원</div>
                        </div>
                        <div id="serviceEdit">
                            <div>수정 횟수</div>
                            <div>2회</div>
                        </div>
                        <div id="serviceWorkDate">
                            <div>작업 일수</div>
                            <div>10일</div>
                        </div>
                    </div>
                    
                </div>
                <div id="serviceStatus">
                    <div>미승인</div>
                </div>
            </div>
        </section>

        
    </div>
    <!-- **************************************footer*************************************-->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <!-- **************************************footer*************************************-->
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

    <script src="/resources/js/myProject/myProject_freelancer/myServiceFreelancer.js"></script>
</body>
</html>