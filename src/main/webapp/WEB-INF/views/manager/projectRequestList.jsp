<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="requestList" value="${map.requestList}" />
<c:set var="pagination" value="${map.pagination}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로젝트 의뢰 등록 관리</title>

    <link rel="stylesheet" href="/resources/css/manager/projectRequestList.css">

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
    	</c:if>
		<c:forEach var="inputStatus" items="${param.status}">
			<c:choose>
				<c:when test="${inputStatus == 1}">
					<c:set var="inputStatus1" value="selected" />
				</c:when>
				<c:when test="${inputStatus == 2}">
					<c:set var="inputStatus2" value="selected" />
				</c:when>
				<c:when test="${inputStatus == 3}">
					<c:set var="inputStatus3" value="selected" />
				</c:when>
				<c:when test="${inputStatus == 4}">
					<c:set var="inputStatus4" value="selected" />
				</c:when>
			</c:choose>
		</c:forEach>


	<div class="main">
		<div id="service-list-title-area">

			<span id="service-list-title">프로젝트 의뢰 등록 관리</span> 
				<span class="select-area"> 
					<select class="select-area-input" name="selectServiceStatus" id="selectServiceStatus" onchange="selectChange()">
						<option value="0">전체</option>
						<option value="1" ${inputStatus1}>승인대기중</option>
						<option value="2" ${inputStatus2}>모집중</option>
						<option value="3" ${inputStatus3}>미승인</option>
						<option value="4" ${inputStatus4}>모집 마감</option>
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
			<c:if test="${not empty requestList}">
				<c:forEach var="request" items="${requestList}">
					<div class="service-list-table-content">
						<div class="service-num">${request.projectRequestNo}</div>
						<div class="service-title"><a class="detailBtn" href="/manager/requestDetail/${request.projectRequestNo}">${request.projectRequestTitle}</a></div>
						<div class="service-status">${request.projectRequestStatusString}</div>
						<div class="service-button">
							<a class="service-button-value">삭제</a>
						</div>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${empty requestList}">
				<div class="service-list-table-content center">의뢰가 존재하지 않습니다.</div>
			</c:if>


		</div>
		<!-- buy-table -->
		

		<!-- pagination -->
		<div class="pagination-area">


				<ul class="pagination">
		<c:if test="${not empty requestList}">

					<!-- 첫 페이지로 이동 -->
					<li><a href="/manager/projectRequestList?cp=1${sURL}">&lt;&lt;</a></li>

					<!-- 이전 목록 마지막 번호로 이동 -->
					<li><a href="/manager/projectRequestList?cp=${pagination.prevPage}${sURL}">&lt;</a></li>



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
								<li><a href="/manager/projectRequestList?cp=${i}${sURL}">${i}</a></li>
							</c:otherwise>
						
						</c:choose>
						
					</c:forEach>
					
					
					
					<!-- 다음 목록 시작 번호로 이동 -->
					<li><a href="/manager/projectRequestList?cp=${pagination.nextPage}${sURL}">&gt;</a></li>

					<!-- 끝 페이지로 이동 -->
					<li><a href="/manager/projectRequestList?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
			</c:if>

				</ul>
			</div>

			<!-- 검색창 -->
			<form action="/manager/projectRequestList" method="get" id="requestSearch" onsubmit="return true">

				<select name="key" id="search-key">
					<option value="no">프로젝트 의뢰 번호</option>
					<option value="t">프로젝트 의뢰 제목</option>
					<option value="c">프로젝트 의뢰 내용</option>
					<option value="tc">프로젝트 의뢰 제목 + 내용</option>
				</select> 
				<input type="text" name="query" id="search-query" placeholder="검색어를 입력해주세요.">
				<input type="hidden" name="status" id="inputStatus">
				<button id="frmBtn">검색</button>
			</form>

	</div>
	<!-- main -->

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
	<script src="/resources/js/manager/projectRequestList.js"></script>

</body>
</html>