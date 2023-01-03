<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="reviewReportList" value="${map.reviewReportList}" />
<c:set var="pagination" value="${map.pagination}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>리뷰 관리</title>

<link rel="stylesheet" href="/resources/css/manager/reviewList.css">

</head>
<body id="mainBody">

	<jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp" />


	<div class="main">
		<div id="review-manage-title-area">
			<div id="review-manage-title">리뷰 관리</div>
		</div>

		<div id="review-manage-table">

			<!-- 테이블 컬럼명 -->
			<div class="review-manage-table-column">
				<div class="review-num">댓글번호</div>
				<div class="review-content">리뷰 내용</div>
				<div class="review-writer">작성자</div>
				<div class="review-delete"></div>
			</div>

			<!-- 테이블 내용 -->
			<c:choose>
				<c:when test="${empty reviewReportList}">
					<div class="question-list-table-content center">
						<div class="contentList">리뷰가 존재하지 않습니다.</div>
					</div>
				</c:when>
				<c:otherwise>
					<c:forEach var="reviewReport" items="${reviewReportList}">
						<div class="review-manage-table-content">
							<div class="review-num">${reviewReport.reviewReportNo}</div>
							<div class="review-content">
								<a class="reviewDetail">${reviewReport.reviewContent}</a>
							</div>
							<div class="review-writer">${reviewReport.memberName}</div>
							<div class="review-delete">
								<a class="deleteBtn" href="/manager/reviewReport/${reviewReport.reviewReportNo}/delete">삭제</a> 
                                <a class="holdBtn" href="/manager/reviewReport/${reviewReport.reviewReportNo}/hold">보류</a>
							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>

		</div>
		<!-- buy-table -->
		<c:if test="${not empty reviewReportList}">
			<div class="pagination-area">
				<ul class="pagination">

					<!-- 첫 페이지로 이동 -->
					<li><a href="/manager/reviewList?cp=1${sURL}">&lt;&lt;</a></li>

					<!-- 이전 목록 마지막 번호로 이동 -->
					<li><a href="/manager/reviewList?cp=${pagination.prevPage}${sURL}">&lt;</a></li>

					<c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
						<c:choose>
							<c:when test="${i == pagination.currentPage}">
								<%-- 현재 보고있는 페이지 --%>
								<li><a class="current">${i}</a></li>
							</c:when>
							<c:otherwise>
								<%-- 현재 페이지를 제외한 나머지  --%>
								<li><a href="/manager/reviewList?cp=${i}${sURL}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<!-- 다음 목록 시작 번호로 이동 -->
					<li><a href="/manager/reviewList?cp=${pagination.nextPage}${sURL}">&gt;</a></li>

					<!-- 끝 페이지로 이동 -->
					<li><a href="/manager/reviewList?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>

				</ul>
			</div>
		</c:if>

		<div class="review-modal">
			<jsp:include page="/WEB-INF/views/manager/reviewModal.jsp" />
		</div>

	</div>
	</div>
	<!-- main -->

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
	<script src="/resources/js/manager/reviewReportList.js"></script>

</body>
</html>