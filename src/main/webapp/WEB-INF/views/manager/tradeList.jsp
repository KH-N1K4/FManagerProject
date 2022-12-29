<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="tradeList" value="${map.tradeList}" />
<c:set var="pagination" value="${map.pagination}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>계좌 내역</title>

<link rel="stylesheet" href="/resources/css/manager/tradeList.css">

</head>
<body id="mainBody">

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
		<div id="manager-buy-title-area">

			<span id="manager-buy-title">계좌 관리</span>
			<span class="search-area"> 
				<select class="member-select-input" name="selectWorkStatus" id="selectWorkStatus" onchange="selectChange()">
					<option value="0">작업 상태</option>
					<option value="1" ${inputStatus1}>진행중</option>
					<option value="2" ${inputStatus2}>정산 완료</option>
					<option value="3" ${inputStatus3}>환불 완료</option>
					<option value="4" ${inputStatus4}>마감</option>
				</select>
			</span>
		</div>

		<div id="manager-buy-table">

			<!-- 테이블 컬럼명 -->
			<div class="manager-buy-table-column">
				<div class="manager-num">날짜</div>
				<div class="manager-trade-num">거래번호</div>
				<div class="manager-service-name">서비스 명</div>
				<div class="manager-expert">거래자</div>
				<div class="manager-work-status">작업 상태</div>
				<div class="manager-division">구분</div>
				<div class="manager-division">금액</div>
				<div class="manager-option"></div>
			</div>

			<!-- 테이블 내용 -->

			<c:if test="${not empty tradeList}">
				<c:forEach var="trade" items="${tradeList}">
					<div class="manager-buy-table-content">
						<div class="manager-num">${trade.paymentDate}</div>
						<div class="manager-trade-num">${trade.tradeNo}</div>
						<div class="manager-service-name"><a class="detailBtn">${trade.serviceTitle}</a></div>
						<div class="manager-expert">${trade.userName}</div>
						<div class="manager-work-status">${trade.workStatusString}</div>
						<div class="manager-division">${trade.paymentTypeString}</div>
						<div class="manager-division">${trade.paymentPrice}</div>
						<div class="manager-option">
							<c:if test="${trade.workStatus == 1}">
							<a class="btn refund">환불</a>
							</c:if>
							<c:if test="${trade.workStatus == 4}">
							<a class="btn" href="/manager/settlement/calculate">정산</a>
							</c:if>
						</div>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${empty tradeList}">
				<div class="manager-buy-table-content center">
					거래 내역이 존재하지 않습니다.
				</div>
			</c:if>

		</div>
		<!-- buy-table -->
		
		<!-- pagination -->
		<div class="pagination-area">


				<ul class="pagination">

					<c:if test="${not empty tradeList}">

					<!-- 첫 페이지로 이동 -->
					<li><a href="/manager/tradeList?cp=1${sURL}">&lt;&lt;</a></li>

					<!-- 이전 목록 마지막 번호로 이동 -->
					<li><a href="/manager/tradeList?cp=${pagination.prevPage}${sURL}">&lt;</a></li>



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
								<li><a href="/manager/tradeList?cp=${i}${sURL}">${i}</a></li>
							</c:otherwise>
						
						</c:choose>
						
					</c:forEach>
					
					
					
					<!-- 다음 목록 시작 번호로 이동 -->
					<li><a href="/manager/tradeList?cp=${pagination.nextPage}${sURL}">&gt;</a></li>

					<!-- 끝 페이지로 이동 -->
					<li><a href="/manager/tradeList?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>

					</c:if>


				</ul>
			</div>
			
			<!-- 검색창 -->
			<form action="/manager/tradeList" method="get" id="tradeSearch" onsubmit="return true">

				<input type="text" name="query" id="search-query" placeholder="거래 번호를 입력해주세요.">
				<input type="hidden" name="status" id="inputStatus">
				<button id="frmBtn">검색</button>
			</form>



			<div class="trade-modal">
            	<jsp:include page="/WEB-INF/views/manager/refundModal.jsp" /> 
       		</div>

	</div>
	<!-- main -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
	
	<script src="/resources/js/manager/tradeList.js"></script>
</body>
</html>