<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>계좌 내역</title>

<link rel="stylesheet" href="/resources/css/manager/tradeList.css">

</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp" />


	<div class="main">
		<div id="manager-buy-title-area">

			<span id="manager-buy-title">계좌 관리</span>
			<span class="search-area"> 
				<select class="member-select-input" name="selectmemberType" id="selectmemberType" onchange="selectChange()">
					<option value="0">구분</option>
					<option value="1">진행중</option>
					<option value="2">정산 완료</option>
					<option value="3">환불 완료</option>
					<option value="4">마감</option>
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
				<div class="manager-division">가격</div>
				<div class="manager-option"></div>
			</div>

			<!-- 테이블 내용 -->
			<div class="manager-buy-table-content">
				<div class="manager-num">2022-12-28</div>
				<div class="manager-trade-num">456</div>
				<div class="manager-service-name">로고 디자인 제작 로고 디자인 제작 로고 디자</div>
				<div class="manager-expert">김지윤</div>
				<div class="manager-work-status">환불 완료</div>
				<div class="manager-division">입금</div>
				<div class="manager-division">10,000</div>
				<div class="manager-option">
					<span>정산</span> <span>환불</span>
				</div>
			</div>


		</div>
		<!-- buy-table -->
		
		<!-- pagination -->
		<div class="pagination-area">


				<ul class="pagination">

					<!-- 첫 페이지로 이동 -->
					<li><a href="/manager/memberList?cp=1${sURL}">&lt;&lt;</a></li>

					<!-- 이전 목록 마지막 번호로 이동 -->
					<li><a href="/manager/memberList?cp=${pagination.prevPage}${sURL}">&lt;</a></li>



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
								<li><a href="/manager/memberList?cp=${i}${sURL}">${i}</a></li>
							</c:otherwise>
						
						</c:choose>
						
					</c:forEach>
					
					
					
					<!-- 다음 목록 시작 번호로 이동 -->
					<li><a href="/manager/memberList?cp=${pagination.nextPage}${sURL}">&gt;</a></li>

					<!-- 끝 페이지로 이동 -->
					<li><a href="/manager/memberList?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>

				</ul>
			</div>
			
			<!-- 검색창 -->
			<form action="/manager/memberList" method="get" id="memberSearch" onsubmit="return true">

				<input type="text" name="query" id="search-query" placeholder="계좌 번호를 입력해주세요.">

				<button id="frmBtn">검색</button>
			</form>

	</div>
	<!-- main -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />


</body>
</html>