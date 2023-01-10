<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="paymentList" value="${resultMap.paymentList}"/>
<c:set var="pagination" value="${resultMap.pagination}"/>
<c:set var="i" value="0"/>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>내 프로젝트 - 결제 내역</title>

  <link rel="stylesheet" href="/resources/css/myProject/paymentList.css">
  
</head>
<body>

 <%--  <jsp:include page="/WEB-INF/views/myProject/myProject_header.jsp"/> --%>
 <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
  <c:if test="${not empty param}">
        <c:forEach var="parameter" items="${param}">
            <c:if test="${parameter.key != 'cp'}">
                <c:set var="sURL" value="${sURL}&${parameter.key}=${parameter.value}"/>
            </c:if>
        </c:forEach>
    </c:if>
  <main>
    <!-- hearder -->
    <!-- <div id="header">
      <div id="header1">
          <div id="logo"><img src="../resources/images/final_logo.png" alt=""></div>
          <div class="header-top">
            <a><span>전문가 전환</span></a>
            <a><span>메세지</span></a>
            <a><span>홈으로</span></a>
            <a><img style="width: 32px; height: 32px;" src="../resources/images/프로필.PNG"></a>
          </div>
      </div>
    </div> -->
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
                <form action="/member/myProject/paymentList" method="GET" id="searchFrm">
                  <!-- 상단 내프로젝트 페이지 제목 -->
                  <div class="container_title"><span class="title">결제 내역</span>
                    <span>
                      <select class="selectType" name="type" id="selectType" title="${type}">
                        <option value="0">카테고리 선택</option>
                        <option value="1">디자인</option>
                        <option value="2">IT·프로그래밍</option>
                        <option value="3">영상</option>
                        <option value="4">사진</option>
                        <option value="5">음향</option>
                      </select>
                      <input type="date" name="searchDate1" id="searchDate1" title="${searchDate1}"> -
                      <input type="date" name="searchDate2" id="searchDate2" title="${searchDate2}">
                      <button class="dateSearchBtn">검색</button>
                    </span>
                  
                  </div>
                  <!--------------------------------->
                </form>
              </div>
            
              <table>
                <tr class="tableHeader">
                    <th style="width: 50px;">번호</th>
                    <th style="width: 150px;">구분</th>
                    <th style="width: 490px">서비스명</th>
                    <th style="width: 100px;">날짜</th>
                    <th style="width: 150px;">금액</th>
                </tr>
                <c:if test="${not empty paymentList}">
				          <c:forEach var="payment" items="${paymentList}"  varStatus="status">
                    <tr>
                    <c:set var="total" value="${pagination.currentPage-1 }" />
                     <c:set var="total1" value="${total*5 }" />
                      <td>${total1 + status.count}</td>
                      <td>${payment.paymentType}</td>
                      <td>${payment.serviceTitle}</td>
                      <td>${payment.paymentDate}</td>
                      <td><fmt:formatNumber value="${payment.paymentPrice}" /></td>
                    </tr>
                  </c:forEach>
                </c:if>
                <c:if test="${empty paymentList}">
                  <tr>
                    <td colspan="5"> 구매 내역이 존재하지 않습니다.
                  </tr>
                </c:if>

                
              </table>

            
                
            </div>
              <!-- pagination -->
          <div class="pagination-area">


              <ul class="pagination">
              <c:if test="${not empty paymentList}">

                <!-- 첫 페이지로 이동 -->
                <li><a href="/member/myProject/paymentList?cp=1${sURL}">&lt;&lt;</a></li>

                <!-- 이전 목록 마지막 번호로 이동 -->
                <li><a href="/member/myProject/paymentList?cp=${pagination.prevPage}${sURL}">&lt;</a></li>



                <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1" >
                
                  <!-- 특정 페이지로 이동 -->
                  <c:choose>
                  
                    <c:when test="${i==pagination.currentPage}">
                      <!-- 현재 보고있는 페이지 -->
                      <li>
                        <a class="current">${i}</a>
                      </li>
                    </c:when>
                    
                    <c:otherwise>
                      <!-- 현재 페이지를 제외한 나머지 -->
                      <li><a href="/member/myProject/paymentList?cp=${i}${sURL}">${i}</a></li>
                    </c:otherwise>
                  
                  </c:choose>
                  
                </c:forEach>
                
                
                
                <!-- 다음 목록 시작 번호로 이동 -->
                <li><a href="/member/myProject/paymentList?cp=${pagination.nextPage}${sURL}">&gt;</a></li>

                <!-- 끝 페이지로 이동 -->
                <li><a href="/member/myProject/paymentList?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
                </c:if>

              </ul>
            </div>
          
          </div>

          
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
  </main>

  <!-- **************************************footer*************************************-->
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  <!-- **************************************footer*************************************-->
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

  <script src="/resources/js/myProject/paymentList.js"></script>
</body>
</html>