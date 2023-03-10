<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="serviceInquiryList" value="${map.serviceInquiryList}" />
<c:set var="pagination" value="${map.pagination}" />
<c:set var="i" value="0"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>보낸 서비스 문의</title>

<link rel="stylesheet" href="/resources/css/myProject/sendSuggestion.css">

</head>
<body>


	<jsp:include page="/WEB-INF/views/common/header_ver2.jsp" />

	<c:if test="${not empty param}">
        <c:forEach var="parameter" items="${param}">
            <c:if test="${parameter.key != 'cp'}">
                <c:set var="sURL" value="${sURL}&${parameter.key}=${parameter.value}"/>
            </c:if>
        </c:forEach>
    </c:if>
	<c:if test="${not empty param}">
            <c:choose>
                <c:when test="${param.type == 1}">
                    <c:set var="inputType1" value="selected" />
                </c:when>
                <c:when test="${param.type == 2}">
                    <c:set var="inputType2" value="selected" />
                </c:when>
                <c:when test="${param.type == 3}">
                    <c:set var="inputType3" value="selected" />
                </c:when>
                <c:when test="${param.type == 4}">
                    <c:set var="inputType4" value="selected" />
                </c:when>
                <c:when test="${param.type == 5}">
                    <c:set var="inputType5" value="selected" />
                </c:when>
            </c:choose>
    </c:if>
	<div class="main">
	
	<jsp:include page="/WEB-INF/views/member/memberSide.jsp" />
	
	<section>
		<div id="service-list-title-area">

			<span id="service-list-title">
			보낸 서비스 문의
			</span> 
				<form action="/member/myInfo/sendServiceInquiry" method="GET" id="searchFrm">
                  <!-- 상단 내프로젝트 페이지 제목 -->
                  <div class="container_title">
                    <span>
                      <select class="selectType" name="type" id="selectType" title="${type}">
                        <option value="0">카테고리 선택</option>
                        <option value="1" ${inputType1}>디자인</option>
                        <option value="2" ${inputType2}>IT·프로그래밍</option>
                        <option value="3" ${inputType3}>영상</option>
                        <option value="4" ${inputType4}>사진</option>
                        <option value="5" ${inputType5}>음향</option>
                      </select>
                      <input type="date" name="searchDate1" id="searchDate1" title="${searchDate1}" value="${param.searchDate1}"> -
                      <input type="date" name="searchDate2" id="searchDate2" title="${searchDate2}" value="${param.searchDate2}">
                      <button class="dateSearchBtn">검색</button>
                    </span>
                  
                  </div>
                  <!--------------------------------->
                </form>
		</div>

		<div id="service-list-table">

			<!-- 테이블 컬럼명 -->
			<div class="service-list-table-column">
				<div class="service-num">번호</div>
				<div class="service-title">제목</div>
				<div class="service-date">작성일</div>
				<div class="service-button"> </div>
			</div>



			<!-- 테이블 내용 -->
			<c:if test="${not empty serviceInquiryList}">
				<c:forEach var="serviceInquiry" items="${serviceInquiryList}"  varStatus="status">
				
					<div class="service-list-table-content">
					 <c:set var="total" value="${pagination.currentPage-1 }" />
                     <c:set var="total1" value="${total*5 }" />
						<div class="service-num">${total1 + status.count}</div>
						<div class="service-title"><a class="detailBtn" href="/service/${serviceInquiry.serviceNo}" target="_blank">${serviceInquiry.serviceTitle}</a></div>
						<div class="service-date">${serviceInquiry.serviceInquiryCreateDate}</div>
						<div class="service-button">
						
							<a class="service-button-value askService">문의 보기</a>
							<input type="hidden" value="${serviceInquiry.serviceTitle }"/>
							<input type="hidden" value="${serviceInquiry.serviceSummary }"/>
							<input type="hidden" value="${serviceInquiry.serviceInquiryContent }"/>
						</div>
					</div>
					
					
				</c:forEach>
			</c:if>
			<c:if test="${empty serviceInquiryList}">
				<div class="service-list-table-content center">보낸 서비스 문의가 존재하지 않습니다.</div>
			</c:if>


		</div>
		<!-- buy-table -->
		
		<!-- pagination -->
		<div class="pagination-area">


				<ul class="pagination">

					<!-- 첫 페이지로 이동 -->
					<li><a href="/member/myInfo/sendServiceInquiry?cp=1${sURL}">&lt;&lt;</a></li>

					<!-- 이전 목록 마지막 번호로 이동 -->
					<li><a href="/member/myInfo/sendServiceInquiry?cp=${pagination.prevPage}${sURL}">&lt;</a></li>



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
								<li><a href="/member/myInfo/sendServiceInquiry?cp=${i}${sURL}">${i}</a></li>
							</c:otherwise>
						
						</c:choose>
						
					</c:forEach>
					
					
					
					
					<!-- 다음 목록 시작 번호로 이동 -->
					<li><a href="/member/myInfo/sendServiceInquiry?cp=${pagination.nextPage}${sURL}">&gt;</a></li>

					<!-- 끝 페이지로 이동 -->
					<li><a href="/member/myInfo/sendServiceInquiry?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>

				</ul>
			</div>
			</section>
			
			 <div class="modal">
			            <jsp:include page="/WEB-INF/views/myProject/askServiceView.jsp" /> 
			         </div>
					

	</div>
	<!-- main -->

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
	<script src="/resources/js/category/modal2.js"></script>
	<script src="/resources/js/member/sendSuggestion.js"></script>

</body>
</html>