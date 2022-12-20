<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>myProject_suggestion</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_suggestion.css">
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
                <div class="container_title"><span>받은 제안</span></div>
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
            </div>
            <!--  -->
            <div class="tableArea">
              <div id="tableContent">
                <table cellspacing="0" class="tbl_lst_type">	
                  <caption><span class="blind">받은 제안 정보</span></caption>				
                  <colgroup>
                    <col width="40"><col width="*"><col width="100"><col width="81"><col width="81"><col width="86"><col width="86"><col width="85">
                  </colgroup>
                  <thead>
                    <tr>
                      <th scope="col" class="frst"><strong class="line_n">번호</strong></th>
                      <th scope="col" class=""><strong class="line_r">프로젝트명</strong></th>   
                      <th scope="col" class=""><strong class="line_r">전문가</strong></th>  
                      <th scope="col" class=""><strong class="line_n">번호</strong></th>
                      <th scope="col" class=""><strong class="line_n">금액</strong></th>
                      <th scope="col" class=""><strong class="line_n">수정횟수</strong></th>
                      <th scope="col" class=""><strong class="line_n">상태</strong></th>
                      <th scope="col" class="last"><strong class="line_n">채택</strong></th>
                    </tr>
                  </thead>
                  <tbody id = "selecttbody">
                    <tr class="suggestionTable" suggestionNumeber="">
                      <td class="tc">
                        <span class="num">1</span>
                      </td>
                      <td class="tl">
                        <div class="suggestion_name_area td_link">
                          <a href="#" id="suggestionName" class="suggestionName">로고 디자인 제작 요청</a>
<%--                           <a href="#" id="suggestionName${}" class="suggestionName" suggestionName="">로고 디자인 제작 요청</a> --%>
                        </div>
                      </td>
                      <td  class="tc">
                        <div class="expert_name_area td_link">
                          <a href="#" id="expertName" class="expertName" expertName="">홍길동</a>
<%--                           <a href="#" id="expertName${}" class="expertName" expertName="">홍길동</a> --%>
                        </div>
                      </td>
                      <td class="tc">                  
                        <span class="text">Level1</span>
                      </td>
                      <td class="tc">
                        <span class="text">100,000원</span>
                      </td>
                      <td class="tc">
                        <span class="num">3</span>
                      </td>
                      <td class="tc">
                        <span class="text">구매완료</span>
                      </td>
                      <td class="tc">
                        <a href="#" id="chooseBtn" title="" class="chooseBtn btn_type"><span>채택</span></a>
<%--                         <a href="#" id="chooseBtn" title="${}" class="chooseBtn btn_type"><span>채택</span></a> --%>
                      </td>                
                    </tr>
                    <tr class="suggestionTable" suggestionNumeber="">
                      <td class="tc">
                        <span class="num">2</span>
                      </td>
                      <td class="tl">
                        <div class="suggestion_name_area td_link">
                          <a href="#" id="suggestionName" class="suggestionName" suggestionName="">프리랜서 마켓 웹사이트 제작 요청</a>
<%--                           <a href="#" id="suggestionName${}" class="suggestionName" suggestionName="">프리랜서 마켓 웹사이트 제작 요청</a> --%>
                        </div>
                      </td>
                      <td  class="tc">
                        <div class="expert_name_area td_link">
                          <a href="#" id="expertName" class="expertName" expertName="">김이듀</a>
<%--                           <a href="#" id="expertName${}" class="expertName" expertName="">김이듀</a> --%>
                        </div>
                      </td>
                      <td class="tc">                  
                        <span class="text">Level3</span>
                      </td>
                      <td class="tc">
                        <span class="text">250,000원</span>
                      </td>
                      <td class="tc">
                        <span class="num">5</span>
                      </td>
                      <td class="tc">
                        <span class="text">채택마감</span><!-- 채택마감일 때 비활성 -->
                      </td>
                      <td class="tc">
                        <a href="#" id="chooseBtn" title="" class="chooseBtn btn_type"><span>채택</span></a>
<%--                         <a href="#" id="chooseBtn" title="${}" class="chooseBtn btn_type"><span>채택</span></a> --%>
                      </td>                
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
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