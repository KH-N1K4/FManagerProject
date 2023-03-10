<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="serviceList" value="${map.serviceList}" />
<c:set var="pagination" value="${map.pagination}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>서비스 관리</title>

<link rel="stylesheet" href="/resources/css/manager/serviceList.css">


</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp" />

	<%-- 검색을 진행한 경우 --%>
		<c:if test="${not empty param}">
        	<c:forEach var="parameter" items="${param}">
				<c:if test="${parameter.key != 'cp'}">
					<c:set var="sURL" value="${sURL}&${parameter.key}=${parameter.value}"/>
				</c:if>
			</c:forEach>
			<c:if test="${not empty param.value}">
					<c:choose>
						<c:when test="${param.value == 1}">
							<c:set var="inputStatus1" value="selected" />
						</c:when>
						<c:when test="${param.value == 2}">
							<c:set var="inputStatus2" value="selected" />
						</c:when>
						<c:when test="${param.value == 3}">
							<c:set var="inputStatus3" value="selected" />
						</c:when>
						<c:when test="${param.value == 4}">
							<c:set var="inputStatus4" value="selected" />
						</c:when>
					</c:choose>
			</c:if>
			<c:if test="${empty param.value}">
					<c:choose>
						<c:when test="${map.status == 1}">
							<c:set var="inputStatus1" value="selected" />
						</c:when>
						<c:when test="${map.status == 2}">
							<c:set var="inputStatus2" value="selected" />
						</c:when>
						<c:when test="${map.status == 3}">
							<c:set var="inputStatus3" value="selected" />
						</c:when>
						<c:when test="${map.status == 4}">
							<c:set var="inputStatus4" value="selected" />
						</c:when>
					</c:choose>
			</c:if>
    	</c:if>

	<div class="main">
		<div id="service-list-title-area">

			<span id="service-list-title">서비스 등록 관리</span> 
				<span class="select-area"> 
					<select class="select-area-input" name="selectServiceStatus" id="selectServiceStatus" onchange="selectChange()">
						<option value="0">전체</option>
						<option value="1" ${inputStatus1}>승인대기중</option>
						<option value="2" ${inputStatus2}>판매중</option>
						<option value="3" ${inputStatus3}>미승인</option>
						<option value="4" ${inputStatus4}>판매 중지</option>
					</select>
				</span>
		</div>

		<div id="service-list-table">

			<!-- 테이블 컬럼명 -->
			<div class="service-list-table-column">
				<div class="service-num">번호</div>
				<div class="service-title">제목</div>
				<div class="service-status">상태</div>
				<div class="service-button"> </div>
			</div>

			<!-- 테이블 내용 -->
			<c:if test="${not empty serviceList}">
				<c:forEach var="service" items="${serviceList}">
					<div class="service-list-table-content">
						<div class="service-num">${service.serviceNo}</div>
						<div class="service-title"><a class="detailBtn" href="/manager/serviceDetail/${service.serviceNo}?cp=${pagination.currentPage}${sURL}">${service.serviceTitle}</a></div>
						<div class="service-status">${service.serviceStatusString}</div>
						<div class="service-button">
							<a class="service-button-value">삭제</a>
						</div>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${empty serviceList}">
				<div class="service-list-table-content center">서비스가 존재하지 않습니다.</div>
			</c:if>


		</div>
		<!-- buy-table -->


		<!-- pagination -->
		<div class="pagination-area">


				<ul class="pagination">
		<c:if test="${not empty serviceList}">

					<!-- 첫 페이지로 이동 -->
					<li><a href="/manager/serviceList?cp=1${sURL}">&lt;&lt;</a></li>

					<!-- 이전 목록 마지막 번호로 이동 -->
					<li><a href="/manager/serviceList?cp=${pagination.prevPage}${sURL}">&lt;</a></li>



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
								<li><a href="/manager/serviceList?cp=${i}${sURL}">${i}</a></li>
							</c:otherwise>
						
						</c:choose>
						
					</c:forEach>
					
					
					
					<!-- 다음 목록 시작 번호로 이동 -->
					<li><a href="/manager/serviceList?cp=${pagination.nextPage}${sURL}">&gt;</a></li>

					<!-- 끝 페이지로 이동 -->
					<li><a href="/manager/serviceList?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>

			</c:if>
				</ul>
			</div>

			<!-- 검색창 -->
			<form action="/manager/serviceList" method="get" id="serviceSearch" onsubmit="return true">

				<select name="key" id="search-key">
					<option value="no">서비스 번호</option>
					<option value="t">서비스 제목</option>
					<option value="c">서비스 내용</option>
					<option value="tc">서비스 제목 + 내용</option>
				</select> 
				<input type="text" name="query" id="search-query" placeholder="검색어를 입력해주세요.">
				<input type="hidden" name="value" id="inputStatus" value="${param.value}">
				<button id="frmBtn">검색</button>
			</form>

	</div>
	<!-- main -->

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
	<script src="/resources/js/manager/serviceList.js"></script>

</body>
</html>