<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

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
                    <select name="" id="select">
                        <option>전체</option>
                        <option>디자인</option>
                        <option>IT/프로그래밍</option>
                        <option>영상</option>
                        <option>사진</option>
                        <option>음향</option>
                    </select>
                </div>
                <div id="serviceInsert"><a href="/member/myProject/freelancer/myServiceInsert">등록하기</a></div>
            </div>
            <div id="contentSection">
                <div id="serviceImage">
                    <img src="/resources/images/projectImage02.PNG" alt="">
                </div>
                <div id="serviceContent">
                    <div id="serviceTitle">서비스 제목</div>
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
                    <div>승인 대기중</div>
                </div>
            </div>
            <div id="contentSection">
                <div id="serviceImage">
                    <img src="/resources/images/projectImage01.PNG" alt="">
                </div>
                <div id="serviceContent">
                    <div id="serviceTitle">서비스 제목</div>
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
</body>
</html>