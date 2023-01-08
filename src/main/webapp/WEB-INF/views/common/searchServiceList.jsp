<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>


<c:set var="serviceList" value="${resultMap.serviceList}"/>
<c:set var="pagination" value="${resultMap.pagination}"/>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인페이지</title>
    
    
    <link rel="stylesheet" href="/resources/css/common/mainPage.css">
    <script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script>
    
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header_ver1.jsp"/>
    <c:if test="${not empty param}">
        <c:forEach var="parameter" items="${param}">
            <c:if test="${parameter.key != 'cp'}">
            
                <c:set var="sURL" value="${sURL}&${parameter.key}=${parameter.value}"/>
            </c:if>
        </c:forEach>
    </c:if>
        
    <section class="content">
        <div class="mainArea">

            <!-- 메인 콘텐츠 영역 -->
            <div class="mainContent">
                <div id="imageContent">
                	 <c:forEach var="service" items="${serviceList }" > 
	                    <div>
	                 
	                    <div id="image">
	                        <div><img src="${service.serviceFilePath2 }">
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
	                        <a href="/service/${service.serviceNo }" class="imageTitle">
	                        ${service.serviceTitle }
	                        <span class="imageOthers">${service.serviceSummary }</span>
	                        <span class="imageOthers">가격: ${service.servicePriceString}원</span>
	                        </a>
	                     
	                    </div>
                    <!-- </a> -->
                	</div>
	                	
                     </c:forEach> 
                </div>
            </div>

        </div>
    </section>   
    
    
    
    
    <div class="pagination-area">


                <ul class="pagination">
                
                    <!-- 첫 페이지로 이동 -->
                    <li><a href="/searchService?cp=1${sURL}">&lt;&lt;</a></li>

                    <!-- 이전 목록 마지막 번호로 이동 -->
                    <li><a href="/searchService?cp=${pagination.prevPage}${sURL}">&lt;</a></li>

					<c:forEach var="i" begin="${pagination.startPage}" 
                        end="${pagination.endPage}" step="1">
                        
                        <c:choose>
                            <c:when test="${i == pagination.currentPage}">
                                <%-- 현재 페이지인 경우 --%>
                                <!-- 현재 보고있는 페이지 -->
                                <li><a class="current">${i}</a></li>
                            </c:when>

                            <c:otherwise>
                                 <li><a href="/searchService?cp=${i}${sURL}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    
                    <!-- 다음 목록 시작 번호로 이동 -->
                    <li><a href="/searchService?cp=${pagination.nextPage}${sURL}">&gt;</a></li>

                    <!-- 끝 페이지로 이동 -->
                    <li><a href="/searchService?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>

                </ul>
            </div>
            
            
            <script>
        
        const memberNo="${loginMember.memberNo}";
     
    </script>	

		<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>	
	<script src="/resources/js/category/categoryList.js"></script> 
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>