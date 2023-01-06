<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="pagination" value="${map.pagination}"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>찜한 목록</title>

<link rel="stylesheet" href="/resources/css/member/likeList.css">

<script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header_ver2.jsp" />
	<c:if test="${not empty param}">
		<c:forEach var="parameter" items="${param}">
			<c:if test="${parameter.key != 'cp'}">
				<c:set var="sURL" value="${sURL}&${parameter.key}=${parameter.value}" />
			</c:if>
		</c:forEach>
	</c:if>

	<div class="main">


		<section class="content">
			<div class="mainArea">
				<!-- 사이드 메뉴 -->
				<jsp:include page="/WEB-INF/views/member/memberSide.jsp" />

				<!-- 메인 콘텐츠 영역 -->
				<div class="mainContent">
					<div id="title">
						찜한 목록 <select id="listOption" name="category" onchange="selectChange()">
							<option value="0">카테고리 선택</option>
							<option value="1">디자인</option>
							<option value="2">IT·프로그래밍</option>
							<option value="3">영상</option>
							<option value="4">사진</option>
							<option value="5">음향</option>
						</select>
					</div>


					<div id="imageContent">

						<c:forEach var="service" items="${map.likeList }">
							<div id="image">
								<div>
									<img src="${service.requestFilePath }"> 
                                    <span class="like-area"> 
                                        <i class="fa-solid fa-heart boardLike" id="${service.serviceNo }"></i>
									</span>
								</div>
								<a href="/service/${service.serviceNo }" class="imageTitle">${service.serviceTitle }
                                    <span class="imageOthers">${service.serviceSummary }</span> 
                                    <span class="imageOthers">가격: ${service.servicePrice}원</span>
								</a>
							</div>
						</c:forEach>
					</div>
				</div>


			</div>
				<div class="pagination-area">


					<ul class="pagination">
                    <c:if test="${not empty map.likeList}">

						<!-- 첫 페이지로 이동 -->
						<li><a href="/member/myInfo/likeList?cp=1${sURL}">&lt;&lt;</a></li>

						<!-- 이전 목록 마지막 번호로 이동 -->
						<li><a href="/member/myInfo/likeList?cp=${pagination.prevPage}${sURL}">&lt;</a></li>

						<c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">

							<c:choose>
								<c:when test="${i == pagination.currentPage}">
									<%-- 현재 페이지인 경우 --%>
									<!-- 현재 보고있는 페이지 -->
									<li><a class="current">${i}</a></li>
								</c:when>

								<c:otherwise>
									<li><a href="/member/myInfo/likeList?cp=${i}${sURL}">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<!-- 다음 목록 시작 번호로 이동 -->
						<li><a href="/member/myInfo/likeList?cp=${pagination.nextPage}">&gt;</a></li>

						<!-- 끝 페이지로 이동 -->
						<li><a href="/member/myInfo/likeList?cp=${pagination.maxPage}">&gt;&gt;</a></li>
                    </c:if>
					</ul>
				</div>
		</section>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<!--   <script src="/resources/js/category/category.js"></script> -->
	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
	<script>
		const memberNo = "${loginMember.memberNo}";
	</script>
	<script src="/resources/js/member/likeList.js"></script>
</body>
</html>