<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>등급관리</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_freelancer/myProjectGrade.css">
  
</head>
<body>

    <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myProject_header2.jsp"/>
    <!-- 화면 크기 width: 1200px로 고정 -->
    <div class="mainInBody"> 
        <!-- sideMenu -->
        <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myProjectSide2.jsp"/>
        <!-- sideMenu -->

        <!-- sideMenu를 제외한 메인 내용 -->
        <section class="mainContent">
          <div class="container">
            <div class="container_header">
              <section class="container_header_left">
                <!-- 상단 내프로젝트 페이지 제목 -->
                <div class="container_title"><span>등급 관리</span></div>
                <!-- 상단 내프로젝트 페이지 제목 -->
              </section>
            </div>
          </div>
          <div class="topBox">
            <div class="leftBox">
              <div class="leftContentTop">
                <h2>누적 판매 건수</h2>
              </div>
              <div class="leftContentbottom">
                <h2>누적 판매 금액</h2>
              </div>
            </div>
            <div class="rightBox">
              <div class="satisfaction">
                <div class="barTitle">만족도</div>
                <progress class="progress" id="satisfactionBar" value="50" min="0" max="100"></progress>
                <div class="barValue"></div>
              </div>
              <div class="responseRate">
                <div class="barTitle">메세지 응답률</div>
                <progress class="progress" id="responseRateBar" value="50" min="0" max="100"></progress>
                <div class="barValue"></div>
              </div>
              <div class="WorkdayRate">
                <div class="barTitle">작업일 준수율</div>
                <progress class="progress" id="WorkdayRateBar" value="50" min="0" max="100"></progress>
                <div class="barValue"></div>
              </div>
            </div>
          </div>
          <div id="selectBox">
            
          <div  class="contentBox">
            
          </div>
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script>
    </script>

    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>


    <script src="/resources/js/myProject/myProject_freelancer/myProjectGrade.js"></script>
</body>
</html>