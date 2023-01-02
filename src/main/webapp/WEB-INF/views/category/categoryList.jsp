<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리</title>
    
    <link rel="stylesheet" href="/resources/css/category/projectRequest.css">
    
     <script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script>
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_ver1.jsp"/>


    <section class="content">
        <div class="mainArea">
            <!-- 사이드 메뉴 -->
            <jsp:include page="/WEB-INF/views/category/categorySide.jsp"/>
            <!-- 메인 콘텐츠 영역 -->
            <div class="mainContent">
                <form action="" id="inquirySubmit">
                    <span>예산</span>
                    <select name="" id="budget"> 
                        <option value="">예산</option>
                        <option value="">1만원 미만</option>
                        <option value="">1만원 - 5만원 이하</option>
                        <option value="">5만원 - 10만원 이하</option>
                        <option value="">10만원 - 20만원 이하</option>
                        <option value="">20만원 - 30만원 이하</option>
                        <option value="">30만원 - 50만원 이하</option>
                        <option value="">50만원 - 70만원 이하</option>
                        <option value="">70만원 - 100만원 이하</option>
                        <option value="">100만원 초과</option>
                    </select>

                    <span>전문가 등급</span>
                    <select name="" id="grade">
                        <option value="">전문가 등급</option>
                        <option value="">New</option>
                        <option value="">Master</option>
                    </select>

                    <select name="" id="index">
                        <option value="">최신순</option>
                        <option value="">마감 임박순</option>
                    </select>
                </form>
                
                <div id="imageContent">
                <c:forEach var="service" items="${map }">
                	<div>
                	<%-- <a href="/category/${service.mainCategoryNo}/${service.subCategoryNo }/${service.thirdCategoryNo }/${service.serviceNo }"> --%>
	                 
	                    <div id="image">
	                        <div><img src="${service.requestFilePath }">
	                        <span class="like-area">
	                        		<c:if test="${empty loginMember }">
	                        			<i class="fa-regular fa-heart boardLike" ></i> 
	                        		</c:if>
	                        		<c:if test="${not empty loginMember }">
		                        		<c:if test="${service.likeCheckFL=='N'}">
				                            <i class="fa-regular fa-heart boardLike" id="${service.serviceNo }"></i>
				                        </c:if>
				                        <c:if test="${service.likeCheckFL=='Y'}">
				                            <i class="fa-solid fa-heart boardLike" id="${service.serviceNo }"></i>
				                        </c:if>
	                        		</c:if>
	                        </span>
  
	                        </div>
	                        <a href="/category/${service.mainCategoryNo}/${service.subCategoryNo }/${service.thirdCategoryNo }/${service.serviceNo }" class="imageTitle">
	                        ${service.serviceTitle }
	                           <span class="imageOthers">${service.serviceSummary }</span>
	                        <span class="imageOthers">가격: ${service.servicePrice}원</span>
	                        </a>
	                     
	                    </div>
                    <!-- </a> -->
                	</div>
                </c:forEach>
                </div>    
            </div>
	
        </div>
    </section>


	
     <script>
        
        const memberNo="${loginMember.memberNo}";
     
    </script>	


 	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>	
	 <script src="/resources/js/category/categoryList.js"></script>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
   
</body>
</html>