<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>myProject_UserPage</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_UserPage.css">
  <style>
    body{
        margin:0;
    }

    #logo{
        width: 200px;
        height: 100px; 
        position: absolute;
        left: 60px;
        top:40px;
        /* border:1px solid black; */
    }

    #header{
        background-color: #538126;
    }

    #logo>img{
        width: 100%;
    }

    #header1{
        width: 1200px;
        height: 160px;
        margin:auto;
        position: relative;    
    }

    .header-top{
        position: absolute;
        right:0;
        top:20px;
        align-items: center;
        display: flex;
    }
    
    .header-top span{
        margin:0 12px;
        cursor: pointer;
        color:white !important;
    }
    .header-top img{
        border-radius: 45%;
    }

</style>
</head>
<body>
  <main>
    <!-- hearder -->
    <%-- <div id="header">
      <div id="header1">
          <div id="logo"><img src="../resources/images/final_logo.png" alt=""></div>
          <div class="header-top">
            <a><span>전문가 전환</span></a>
            <a><span>메세지</span></a>
            <a><span>홈으로</span></a>
            <a><img style="width: 32px; height: 32px;" src="../resources/images/프로필.PNG"></a>
          </div>
      </div>
    </div> --%>

	  <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>

    <!-- hearder -->
    <!-- 화면 크기 width: 1200px로 고정 -->
    <div class="mainInBody"> 
        <!-- sideMenu -->
        <jsp:include page="/WEB-INF/views/myProject/myProjectSide.jsp"/>
        <!-- sideMenu -->

        <!-- sideMenu를 제외한 메인 내용 -->
        <section class="mainContent">
          <div class="container">
            <div class="container_header">
              <section class="container_header_left">
                <!-- 상단 내프로젝트 페이지 제목 -->
                <div class="container_title"><span>내프로젝트</span></div>
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
            <!--  -->
            <!-- 프로젝트 의뢰 1번 -->
            <div class="myProject_content">
              <a class="myProject_link" href="">
                <div class="projuctContent_image">
                  <img  src="../resources/images/projectImage01.PNG">
                </div>
                <div class="projuctContent_info">
                  <div class="info_title">
                    <span>로고 디자인 제작 요청</span>
                  </div>
                  <diV class="info_content">
                    <div class="info_content_left">
                      <div class="info_content_list">
                        <div class="list_title"><span>모집분야</span></div>
                        <div class="list_content">
                          <div class="main1category"><span>디자인</span></div>
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
                    <div class="info_content_right">
                      <div class="signState">
                        <span>승인대기중</span>
                      </div>
                    </div>
                  </diV>
                </div>
              </a>
            </div>
            <!-- 프로젝트 의뢰 1번 -->
            <!-- 프로젝트 의뢰 2번 -->
            <div class="myProject_content">
              <a class="myProject_link" href="">
                <div class="projuctContent_image">
                  <img  src="../resources/images/projectImage02.PNG">
                </div>
                <div class="projuctContent_info">
                  <div class="info_title">
                    <span>프리랜서 마켓 웹사이트 제작 요청</span>
                  </div>
                  <diV class="info_content">
                    <div class="info_content_left">
                      <div class="info_content_list">
                        <div class="list_title"><span>모집분야</span></div>
                        <div class="list_content">
                          <div class="main1category"><span>IT·프로그래밍</span></div>
                          <span>></span>
                          <div class="main3category"><span>홈페이지</span></div>
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
                    <div class="info_content_right">
                      <div class="signState">
                        <span>승인대기중</span>
                      </div>
                    </div>
                  </diV>
                </div>
              </a>
            </div>
            <!-- 프로젝트 의뢰 2번 -->
          </div>
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
  </main>
  <!-- **************************************footer*************************************-->

	  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>