<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>프리랜서 클럽</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_freelancer/myProject_freelancerClub.css">
</head>
<body>
  <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myProject_header2.jsp"/>
    <!-- 화면 크기 width: 1200px로 고정 -->
    <div class="mainInBody"> 
        <!-- sideMenu -->
        <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myProjectSide2.jsp"/>
        <section class="mainContent">
          <section class="container_header_left">
            <!-- 상단 내프로젝트 페이지 제목 -->
            <div class="container_title"><span>프리랜서 클럽</span></div>
            <!-- 상단 내프로젝트 페이지 제목 -->
          </section>
          <div class="map_wrap">
            <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
        
            <div id="menu_wrap" class="bg_white">
                <div class="option">
                    <div>
                        <form onsubmit="searchPlaces(); return false;">
                            키워드 : <input type="text" value="공유오피스" id="keyword" size="15"> 
                            <button type="submit">검색하기</button> 
                        </form>
                    </div>
                </div>
                <hr>
                <ul id="placesList"></ul>
                <div id="pagination"></div>
            </div>
          </div>
        </section>
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=61e115db9c366219c2adb394708a5c88&libraries=services,clusterer,drawing"></script>

    <script src="/resources/js/myProject/myProject_freelancer/myProject_freelancerClub.js"></script>
</body>
</html>