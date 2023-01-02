<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>


<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>myProject_UserPage</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_UserPage.css">
  
</head>
<body>
  <main>
    <!-- hearder -->
	  <jsp:include page="/WEB-INF/views/myProject/myProject_header.jsp"/>

    <!-- 화면 크기 width: 1200px로 고정 -->
    <div class="mainInBody"> 

        <!-- sideMenu -->
        <jsp:include page="/WEB-INF/views/myProject/myProjectSide.jsp"/>

        <!-- sideMenu를 제외한 메인 내용 -->
        <section class="mainContent">
          <div class="container">

            <%-- container_header 시작 --%>
            <div class="container_header">

              <section class="container_header_left">
                <!-- 상단 내프로젝트 페이지 제목 -->
                <div class="container_title"><span>내 프로젝트</span></div>
                <!-- 상단 내프로젝트 페이지 제목 -->

                <!-- 상단 selectbox -->
                <div class="selectbox">
                  <select  id = "srchOption" class="srchOption" name="srchOption" >
                    <option value="0" selected="">전체</option>
                    <option value="1">디자인</option>
                    <option value="2">IT·프로그래밍</option>
                    <option value="3">영상</option>
                    <option value="4">사진</option>
                    <option value="5">음향</option>
                  </select>
                </div>
                <!-- 상단 selectbox -->

              </section>

              <section class="container_header_right">
                <div>
                  <a class="myProject_register" href="/member/myProject/myRequestInsert"><span>등록하기</span></a>
                </div>
              </section>

            </div>
            <%-- container_header 끝 --%>

            <!-- 프로젝트 의뢰 1번 -->
            <div class="myProject_content">
              <a class="myProject_link" href="">
              
                <%-- 서비스 사진 --%>
                <div class="projuctContent_image">
                  <img  src="/resources/images/projectImage01.PNG">
                </div>
                <%-- 서비스 사진 --%>
                
                ${map}
                <div class="projuctContent_info">

                  <%-- 서비스 제목 --%>
                  <div class="info_title">
                    <span>로고 디자인 제작 요청</span>
                  </div>
                  <%-- 서비스 제목 --%>



                  <diV class="info_content">
                    <div class="info_content_left">
                      <div class="info_content_list">
                        <div class="list_title"><span>모집분야</span></div>
                        <div class="list_content">
                          <div class="main1category"><span>${maincategory}</span></div>
                          <span>></span>
                          <div class="main3category"><span>브랜드 디자인·가이드</span></div>
                        </div>
                      </div>
                      <div class="info_content_list">
                        <div class="list_title"><span>예산</span></div>
                        <div class="list_content">
                          <span>1000원</span>
                        </div>
                      </div>
                      <div class="info_content_list">
                        <div class="list_title"><span>모집마감일</span></div>
                        <div class="list_content">
                          <span>2022.02.01</span>
                        </div>
                      </div>
                    </div>
                    <%-- 승인 상태 --%>
                    <div class="info_content_right">
                      <div class="signState">
                        <span>승인 대기중</span>
                      </div>
                    </div>
                    <%-- 승인 상태 --%>
                  </diV>
                </div>
              </a>
            </div>
          </div>
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->

    1. 현재 페이지에서 필요한 테이블 
      - 프로젝트  / 프로젝트 첨부 / 카테고리 1
    2. 조회해야 하는 것 
     ${myProject}

  </main>
  <!-- **************************************footer*************************************-->

	  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>