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
    <c:if test="${not empty param}">
        <c:forEach var="parameter" items="${param}">
            <c:if test="${parameter.key != 'cp'}">
            
                <c:set var="sURL" value="${sURL}&${parameter.key}=${parameter.value}"/>
            </c:if>
        </c:forEach>
    </c:if>
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
              <section class="container_header_right"><!-- 버튼 -->
                <div class="container_button">
                  <div id="container_button">전환</a>
                </div>
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
              <form action="/member/myProject/freelancer/profitManagerment" method="get" name="startDatebtn">
                <input type="date" class="startDate DateBox" name="startDate" id="startDate" title="${startDate}">
                <input type="date" class="endtDate DateBox" name="endtDate" id="endtDate" title="${endtDate}">
                <button class="selectbtn">조회</button>
              </form>
            </div>
          </div>
          <div  class="contentBox">
            <table cellspacing="0" class="tbl_lst_type">	
              <caption><span class="blind">수임금 내역</span></caption>				
              <colgroup>
                <col width="40"><col width="*"><col width="200"><col width="200">
              </colgroup>
              <thead>
                <tr>
                  <th scope="col" class="frst"><strong class="line_n">번호</strong></th>
                  <th scope="col" class=""><strong class="line_r">정산 날짜</strong></th>   
                  <th scope="col" class=""><strong class="line_r">정산금</strong></th>  
                  <th scope="col" class=""><strong class="line_n">서비스 판매금액</strong></th>                 
                </tr>
              </thead>
              <tbody id = "selecttbody">
                <c:if test="${not empty myProfitEachList}">
                      <c:forEach items="${myProfitEachList}" var="myProfitEach">
                        <tr class="myProfitnTable" suggestionNumeber="">
                          <td class="tc">
                            <span class="num">${myProfitEach.num}</span>
                          </td>
                          <td  class="tc">
                            <span class="num">${myProfitEach.paymentDateString}</span>
                          </td>
                          <td class="tc">
                            <span class="num">${myProfitEach.paymentPriceString}</span>
                          </td>
                          <td class="tc">
                            <span class="num">${myProfitEach.servicePriceString}</span>
                          </td>              
                        </tr>
                      </c:forEach>
                </c:if>
              </tbody>
            </table>
          </div>
          <c:if test="${listCount != 0}">
                
                <div class="pagination-area">


                    <ul class="pagination">
                    
                        <!-- 첫 페이지로 이동 -->
                        <li><a href="/member/myProject/freelancer/profitManagerment?cp=1${sURL}">&lt;&lt;</a></li>
        
                        <!-- 이전 목록 마지막 번호로 이동 -->
                        <li><a href="/member/myProject/freelancer/profitManagerment?cp=${pagination.prevPage}${sURL}">&lt;</a></li>
        
            
                        <!-- 특정 페이지로 이동 -->
                        <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                        <c:choose>
                            <c:when test="${i== pagination.currentPage}">
                            <!-- 현재 페이지인 경우 -->
                            <li><a class="current">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                            <!-- 현재 페이지를 제외한 나머지 -->
                            <li><a href="/member/myProject/freelancer/profitManagerment?cp=${i}${sURL}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                        </c:forEach>
                        <!-- 다음 목록 시작 번호로 이동 -->
                        <li><a href="/member/myProject/freelancer/profitManagerment?cp=${pagination.nextPage}${sURL}">&gt;</a></li>
        
                        <!-- 끝 페이지로 이동 -->
                        <li><a href="/member/myProject/freelancer/profitManagerment?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
        
                    </ul>
                </div>
            </c:if>
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