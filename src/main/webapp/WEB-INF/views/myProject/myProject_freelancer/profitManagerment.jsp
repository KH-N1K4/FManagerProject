<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>수익관리</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_freelancer/profitManagerment.css">
  
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
                <div class="container_title"><span>수익 관리</span></div>
                <!-- 상단 내프로젝트 페이지 제목 -->
              </section>
            </div>
          </div>
          <div id="topBox">
            <div>예상 수익금</div>
            <div>총 수익</div>
          </div>
          <div id="middleBox">
            <canvas id="myChart"></canvas>
          </div>
          <div id="selectBox">
            <span>수익금 내역</span> 
            <select>
              <option value="0">진행 중</option>
              <option value="1">완료</option>
              <option value="2">취소</option>
            </select>
          </div>

        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
	  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="/resources/js/myProject/myProject_freelancer/profitManagerment.js"></script>
</body>
</html>