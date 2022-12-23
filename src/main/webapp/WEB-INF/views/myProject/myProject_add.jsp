<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>myProject_add</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_add.css">
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
    <jsp:include page="/WEB-INF/views/myProject/myProject_header.jsp"/>

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
                <!-- 상단 내프로젝트 페이지 제목 -->
                <div class="container_title"><span>내프로젝트 등록</span></div>
                <!-- 상단 내프로젝트 페이지 제목 -->
            </div>
            <!--  -->
            <form action ="" class="projectRequestfrm" method="get" name="projectRequestfrm" id="projectRequestfrm">
              <div class="container_myProjectadd">
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>카테고리</span></div>
                  <div class="list_content">
                    <div class="selectbox">
                      <select  id = "srchOption1" class="srchOption box" name="srchOption1" >
                        <option value="0" selected="">전체</option>
                        <option value="1">디자인</option>
                        <option value="2">IT·프로그래밍</option>
                        <option value="3">영상</option>
                        <option value="4">사진</option>
                        <option value="5">음향</option>
                      </select>
                    </div>
                    <div class="selectbox"> 
                      <select  id = "srchOption3" class="srchOption box" name="srchOption3" >
                        <option value="0" selected="">전체</option>
                        <option value="1">로고 디자인</option>
                        <option value="2">브랜드 디자인·가이드</option>
                        <option value="3">진단지·포스터·인쇄물</option>
                        <option value="4">현수막·X배너</option>
                        <option value="5">메뉴판</option>
                        <option value="6">홍보물 인쇄·출력</option>
                        <option value="7">스티커·봉투·초대장</option>
                        <option value="8">웹 디자인</option>
                        <option value="9">앱·모바일 디자인</option>
                        <option value="10">템플릿형 홈페이지</option>
                        <option value="11">아이콘·버튼</option>
                        <option value="12">블로그·카페 디자인</option>
                        <option value="13">SNS·썸네일 디자인</option>
                        <option value="14">배너·배달어플</option>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>제목</span></div>
                  <div class="list_content"><input type="text" class="inputBoxSize box"></div>
                </div>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>의뢰 한줄요약</span></div>
                  <div class="list_content"><textarea class="projectRequestOnecontent projectRequestContent box"></textarea></div>
                </div>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>의뢰사항</span></div>
                  <div class="list_content"><textarea class="projectRequestTotalContent projectRequestContent box"></textarea></div>
                </div>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>첨부파일</span></div>
                  <div class="list_content"><input type = "file" ></div>
                </div>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>예산</span></div>
                  <div class="list_content"><input type="text" id="budget" class="budget box" name="budget" placeholder="예산 금액" maxlength="30" autocomplete="off" value=""><span>원</span></div>
                </div>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>모집마감일</span></div>
                  <div class="list_content"><input type="date" class="Date recruitEndDate box" name="recruitEndDateInput" id="recruitEndDateInput"></div>
                </div>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>작업마감일</span></div>
                  <div class="list_content"><input type="date" class="Date workEndDate box" name="workEndDateInput" id="workEndDateInput"></div>
                </div>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>작업기간</span></div>
                  <div class="list_content">
                    <select  id = "dateOption" class="dateOption box" name="dateOption" >
                      <option value="1" selected="">1일</option><!-- 나중에 for문 돌리자 -->
                      <c:forEach var="i" begin="2" end="99" step="1">
                        <option value="${i}">${i}일</option>
                      </c:forEach>
                    </select>
                  </div>
                </div>
              </div>
              <div class="buttonArea">
                <button type="submit" class="submitButton">등록</button>
              </div>
            </form>
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