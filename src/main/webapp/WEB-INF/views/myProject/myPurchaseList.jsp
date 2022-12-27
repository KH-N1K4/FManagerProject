<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>myPurchaseList</title>

  <link rel="stylesheet" href="/resources/css/header.css">
  <link rel="stylesheet" href="/resources/css/footer.css">
  <link rel="stylesheet" href="/resources/css/myProject/myProject_myPurchaseList.css">
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
              <form action ="" class="myPurchaseListfrm" method="get" name="myPurchaseListfrm" id="myPurchaseListfrm">
                <section class="container_header">
                  <!-- 상단 내프로젝트 페이지 제목 -->
                  <div class="container_title"><span>구매 관리</span></div>
                  <!-- 상단 내프로젝트 페이지 제목 -->
                  <!-- 상단 selectbox -->
                  <div class="selectbox">
                    <select  id = "srchOption" class="srchOption box" name="srchOption" >
                      <option value="0" selected="">전체</option>
                      <option value="1">디자인</option>
                      <option value="2">IT·프로그래밍</option>
                      <option value="3">영상</option>
                      <option value="4">사진</option>
                      <option value="5">음향</option>
                    </select>
                  </div>
                  <div class="selectbox">
                    <input type="date" class="startDate box" name="startDate" id="startDate">
                  </div>
                  <div class="selectbox">
                    <input type="date" class="endtDate box" name="endtDate" id="endtDate">
                  </div>
                  <div class="searchbox">
                    <input type="text" class="searchInput" name="searchInput" id="searchInput" placeholder="상품명" maxlength="50" autocomplete="off" value="">
                  </div>
                  <!-- 상단 selectbox -->
                  <div class="buttonArea">
                    <button type="submit" class="submitButton">검색</button>
                  </div>
                </section>
              </form>
            </div>
            <!--  -->
            <div class="tableArea">
              <div id="tableContent">
                <table cellspacing="0" class="tbl_lst_type">	
                  <caption><span class="blind">받은 제안 정보</span></caption>				
                  <colgroup>
                    <col width="40"><col width="*"><col width="100"><col width="95"><col width="95"><col width="180">
                  </colgroup>
                  <thead>
                    <tr>
                      <th scope="col" class="frst"><strong class="line_n">번호</strong></th>
                      <th scope="col" class=""><strong class="line_r">서비스명</strong></th>   
                      <th scope="col" class=""><strong class="line_r">전문가</strong></th>  
                      <th scope="col" class=""><strong class="line_n">수정횟수</strong></th>
                      <th scope="col" class=""><strong class="line_n">작업상태</strong></th>
                      <!-- 작업 상태가 진행중일때 버튼으로 쓰일 컬럼들 -->
                      <th scope="col" class="last"><strong class="line_n"></strong></th>                  
                    </tr>
                  </thead>
                  <tbody id = "selecttbody">
                    <tr class="suggestionTable" suggestionNumeber="">
                      <td class="tc">
                        <span class="num">1</span>
                      </td>
                      <td class="tl">
                        <div class="suggestion_name_area td_link">
                          <a href="#" id="suggestionName" class="suggestionName" suggestionName="">로고 디자인 제작</a>
                        </div>
                      </td>
                      <td  class="tc">
                        <div class="expert_name_area td_link">
                          <a href="#" id="expertName" class="expertName" expertName="">홍길동</a>
                        </div>
                      </td>
                      <td class="tc">
                        <span class="num">1/3</span>
                      </td>
                      <td class="tc">
                        <span class="text">진행중</span>
                      </td>
                      <td class="tc">
                        <a href="#" id="finishBtn" title="" class="finishBtn btn_type"><span>완료</span></a>
                        <a href="#" id="cancelBtn" title="" class="cancelBtn btn_type"><span>최소</span></a>
                        <a href="#" id="reportBtn" title="" class="reportBtn btn_type"><span>신고</span></a>
                      </td>                
                    </tr>
                    <tr class="suggestionTable" suggestionNumeber="">
                      <td class="tc">
                        <span class="num">2</span>
                      </td>
                      <td class="tl">
                        <div class="suggestion_name_area td_link">
                          <a href="#" id="suggestionName" class="suggestionName" suggestionName="">프리랜서 마켓 웹사이트 제작</a>
                        </div>
                      </td>
                      <td  class="tc">
                        <div class="expert_name_area td_link">
                          <a href="#" id="expertName" class="expertName" expertName="">김이듀</a>
                        </div>
                      </td>
                      <td class="tc">
                        <span class="num">1/5</span>
                      </td>
                      <td class="tc">
                        <span class="text">완료</span>
                      </td>
                      <td class="tc">
                        <a id="reviewBtn" title="" class="reviewBtn oneBtn_type"><span>리뷰하기</span></a>
                      </td>                
                    </tr>
                    <tr class="suggestionTable" suggestionNumeber="">
                      <td class="tc">
                        <span class="num">3</span>
                      </td>
                      <td class="tl">
                        <div class="suggestion_name_area td_link">
                          <a href="#" id="suggestionName" class="suggestionName" suggestionName="">웨딩 촬영 디자인</a>
                        </div>
                      </td>
                      <td  class="tc">
                        <div class="expert_name_area td_link">
                          <a href="#" id="expertName" class="expertName" expertName="">최사진</a>
                        </div>
                      </td>
                      <td class="tc">
                        <span class="num">1/4</span>
                      </td>
                      <td class="tc">
                        <span class="text">주문 취소</span>
                      </td>
                      <td class="tc">
                      </td>                
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
        <div class="modal">
          <jsp:include page="/WEB-INF/views/myProject/modal/myproject_review.jsp" /> 
        </div>
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
  </main>

  <!-- **************************************footer*************************************-->
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  <!-- **************************************footer*************************************-->
  <!-- jQuery  -->
  <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

  <script src="/resources/js/myProject/myPurchaseList.js"></script>
</body>
</html>