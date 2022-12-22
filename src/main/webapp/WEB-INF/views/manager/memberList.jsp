<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="memberList" value="${memberList}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원관리</title>

<link rel="stylesheet" href="/resources/css/manager/memberList.css">

</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp" />

	<div class="main">
		<div id="member-manage-title-area">

			<span id="member-manage-title">회원 관리 </span> 
			<span class="search-area"> 
				<select class="member-select-input" name="" id=""> <!-- ajax로 해 -->
					<option value="">구분</option>
					<option value="">프리랜서</option>
					<option value="">일반 회원</option>
				</select>
			</span>
		</div>

		<div id="member-manage-table">

			<!-- 테이블 컬럼명 -->
			<div class="member-manage-table-column">
				<div class="member-num">회원번호</div>
				<div class="member-name">이름</div>
				<div class="member-division">구분</div>
				<div class="member-grade">등급</div>
				<div class="member-enrollDate">가입일</div>
			</div>

			<!-- 테이블 내용 -->
			<c:if test="${not empty memberList}">
				<c:forEach var="member" items="${memberList}">
					<div class="member-manage-table-content">
						<div class="member-num">${member.memberNo}</div>
						<div class="member-name">${member.memberName}</div>
						<div class="member-division">${member.memberType}</div>
						<div class="member-grade">${member.freelancerGrade}</div>
						<div class="member-enrollDate">${member.memberEnrollDate}</div>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${empty memberList}">
				<div class="member-manage-table-content">
					회원이 존재하지 않습니다.
				</div>
			</c:if>





		</div>
		<!-- buy-table -->
		
		<!-- 검색창 -->
			<form action="${boardCode}" method="get" id="memberSearch" onsubmit="return true">

				<select name="key" id="search-key">
					<option value="t">회원번호</option>
					<option value="c">회원 이름</option>
				</select> 
				<input type="text" name="query" id="search-query" placeholder="검색어를 입력해주세요.">
				<button>검색</button>
			</form>

	</div>
	<!-- main -->

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>
</html>