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
                	<c:forEach var="i" begin="0" end="20" step="1">
	                	<a href="/category/1/1">
		                    <div id="image">
		                        <div><img src="/강밍경.jfif"></div>
		                        <!-- 하트버튼 추가 예정 -->
		                        <span>강밍경</span><br>
		                        <span>이제 나도 될 수 있다. 유튜버</span><br>
		                        <span>가격: 100,000원</span>
		                    </div>
	                    </a>
                    </c:forEach>
                </div>
            </div>
            

        </div>
    </section>   
   
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>