<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>수익관리</title>

  <link rel="stylesheet" href="/resources/css/profitManagement.css">
  
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
    <!-- 화면 크기 width: 1200px로 고정 -->
    <div class="mainInBody"> 
        <!-- sideMenu -->
        <section class="sideMenu">
          <div class="aside">
            <a class="myProject_User_side" href="">나의 서비스</a>
            <a class="myProject_User_side" href="">판매 관리</a>
            <a class="myProject_User_side" href="">보낸 제안</a>
            <a class="myProject_User_side" href="">서비스 문의 내역</a>
            <a class="myProject_User_side" href="">수익 관리</a>
            <a class="myProject_User_side" href="">등급 관리</a>
            <a class="myProject_User_side" href="">프리랜서 클럽</a>
          </div>
        </section>
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
            <div>대충 통계 부분</div>
            <div>made in sungchan </div>
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

</body>
</html>