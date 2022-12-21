<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인페이지</title>
    
    
    <link rel="stylesheet" href="/resources/css/common/mainPage.css">
    
    
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header_ver1.jsp"/>
        

    <section class="content">
        <div class="mainArea">

            <!-- 메인 콘텐츠 영역 -->
            <div class="mainContent">
                <div id="imageContent">
                	<%-- <c:forEach var="i" begin="0" end="19" step="1"> --%>
	                	<a href="/category/1/1">
		                    <div id="image">
		                        <div><img src="/resources/images/강민경.jpg"></div>
		                        <!-- 하트버튼 추가 예정 -->
		                        <span>강밍경</span>
		                        <span>이제 나도 될 수 있다. 유튜버</span>
		                        <span>가격: 100,000원</span>
		                    </div>
	                    </a>
	                	<a href="/category/1/2">
		                    <div id="image">
		                        <div><img src="/resources/images/정채연.jpg"></div>
		                        <!-- 하트버튼 추가 예정 -->
		                        <span>채연찡</span>
		                        <span>나만의 프로필을 만들어 보아요</span>
		                        <span>가격: 150,000원</span>
		                    </div>
	                    </a>
	                	<a href="/category/1/3">
		                    <div id="image">
		                        <div><img src="/resources/images/무파마.jpg"></div>
		                        <!-- 하트버튼 추가 예정 -->
		                        <span>무파마</span>
		                        <span>라면먹고갈래? 개존맛 라면만들기</span>
		                        <span>가격: 10,000원</span>
		                    </div>
	                    </a>
	                	<a href="/category/1/3">
		                    <div id="image">
		                        <div><img src="/resources/images/유럽흔남.jpg"></div>
		                        <!-- 하트버튼 추가 예정 -->
		                        <span>유럽흔남</span>
		                        <span>외국어 자신감을 가져보아요</span>
		                        <span>가격: 108,000원</span>
		                    </div>
	                    </a>
	                	<a href="/category/1/4">
		                    <div id="image">
		                        <div><img src="/resources/images/조규성.jpg"></div>
		                        <!-- 하트버튼 추가 예정 -->
		                        <span>조규성</span>
		                        <span>월드컵 영웅, 개발 조규성 헤딩 강의법</span>
		                        <span>가격: 200,000원</span>
		                    </div>
	                    </a>
	                	<a href="/category/1/4">
		                    <div id="image">
		                        <div><img src="/resources/images/최우식.jpg"></div>
		                        <!-- 하트버튼 추가 예정 -->
		                        <span>최우식</span>
		                        <span>그날 우리 행복했잖아</span>
		                        <span>가격: 100,000원</span>
		                    </div>
	                    </a>
	                	<a href="/category/1/5">
		                    <div id="image">
		                        <div><img src="/resources/images/태연.jpg"></div>
		                        <!-- 하트버튼 추가 예정 -->
		                        <span>태연</span>
		                        <span>노래잘하는법 알려드립</span>
		                        <span>가격: 100,000원</span>
		                    </div>
	                    </a>
	                	<a href="/category/1/5">
		                    <div id="image">
		                        <div><img src="/resources/images/태연.jpg"></div>
		                        <!-- 하트버튼 추가 예정 -->
		                        <span>태연</span>
		                        <span>노래잘하는법 알려드립</span>
		                        <span>가격: 100,000원</span>
		                    </div>
	                    </a>
	                	<a href="/category/1/5">
		                    <div id="image">
		                        <div><img src="/resources/images/태연.jpg"></div>
		                        <!-- 하트버튼 추가 예정 -->
		                        <span>태연</span>
		                        <span>노래잘하는법 알려드립</span>
		                        <span>가격: 100,000원</span>
		                    </div>
	                    </a>
	                	<a href="/category/1/5">
		                    <div id="image">
		                        <div><img src="/resources/images/태연.jpg"></div>
		                        <!-- 하트버튼 추가 예정 -->
		                        <span>태연</span>
		                        <span>노래잘하는법 알려드립</span>
		                        <span>가격: 100,000원</span>
		                    </div>
	                    </a>
	                	<a href="/category/1/5">
		                    <div id="image">
		                        <div><img src="/resources/images/태연.jpg"></div>
		                        <!-- 하트버튼 추가 예정 -->
		                        <span>태연</span>
		                        <span>노래잘하는법 알려드립</span>
		                        <span>가격: 100,000원</span>
		                    </div>
	                    </a>
                    <%-- </c:forEach> --%>
                </div>
            </div>

        </div>
    </section>   

	
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>