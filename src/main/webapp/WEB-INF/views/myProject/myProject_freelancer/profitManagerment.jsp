<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
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
            <c:forEach var="profitval" items="${profit}">
              <c:if test="${profitval.profitType == 2}"><div>정산예상 수익금&nbsp;&nbsp;&nbsp;${profitval.paymentPriceString}원</div></c:if>
              <c:if test="${profitval.profitType == 1}"><div>총 수익&nbsp;&nbsp;&nbsp;${profitval.paymentPriceString}원</div></c:if>
            </c:forEach>
          </div>
          <div id="middleBox">
            <canvas id="myChart"></canvas>
          </div>
          <div id="selectBox">
            <div>
              <span>수익금 내역</span> 
            </div>
            <div class="selectdiv">
              <form>
                <input type="date" class="startDate DateBox" name="startDate" id="startDate">
                <input type="date" class="endtDate DateBox" name="endtDate" id="endtDate">
                <button class="selectbtn">조회</button>
              </form>
            </div>
          </div>
          <div  class="contentBox">
            <table cellspacing="0" class="tbl_lst_type">	
              <caption><span class="blind">수임금 내역</span></caption>				
              <colgroup>
                <col width="40"><col width="*"><col width="100"><col width="95"><col width="95"><col width="180">
              </colgroup>
              <thead>
                <tr>
                  <th scope="col" class="frst"><strong class="line_n">번호</strong></th>
                  <th scope="col" class=""><strong class="line_r">서비스명</strong></th>   
                  <th scope="col" class=""><strong class="line_r">의뢰인</strong></th>  
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
                    <a href="#" id="sendBtn" title="" class="sendBtn btn_type"><span>발송</span></a>
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
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script>
      var profitList = JSON.parse('${profitList}');
    </script>

    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
	  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>


    <script src="/resources/js/myProject/myProject_freelancer/profitManagerment.js"></script>
</body>
</html>