<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="member" value="${map.member}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>일반 회원 정보</title>


<link rel="stylesheet" href="/resources/css/manager/memberDetail.css">
<style>
</style>
</head>
<body>


	<jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp" />



	<div class="main">
		<div id="expertDetailTitle">일반 회원 정보</div>
		<div class="expertSummary">
			<div class="expertPhoto">
				<img alt="" src="${member.memberProfile }">
			</div>
			<div class="expertName">
				<div>${member.memberName }</div>
				<div class="expertOther">
					<div class="ee">
						<div class="eeTitle"><span class="eeTT">이메일</span> 	<span class="eeContent">${member.memberEmail}</span></div>
					
					</div>
					<div class="ee">
						<div class="eeTitle"><span class="eeTT">전화번호</span> <span class="eeContent">${member.memberTel}</span></div>
						
					</div>
					<div class="ee">
						<div class="eeTitle"><span class="eeTT">직업</span> <span class="eeContent">${member.memberJob}</span></div>
						
					</div>
					
					
					<div class="ee">
						<div class="eeTitle">
						<div><span class="eeTT">관심 분야</span> 
							<c:forEach var="interest" items="${fn:split(member.memberInterest,',') }">
								<c:choose>
									<c:when test="${interest == 1}">
										<span class="interest">디자인</span>
									</c:when>
									<c:when test="${interest == 2}">
										<span class="interest">IT.프로그래밍</span>
									</c:when>
									<c:when test="${interest == 3}">
										<span class="interest">영상</span>
									</c:when>
									<c:when test="${interest == 4}">
										<span class="interest">사진</span>
									</c:when>
									<c:when test="${interest == 5}">
										<span class="interest">음향</span>
									</c:when>
								</c:choose>
							</c:forEach>
						</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>





	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="/resources/js/category/portfolioModal.js"></script>

</body>
</html>