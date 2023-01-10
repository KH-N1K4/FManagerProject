<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="serviceList" value="${map.serviceList}"/>
<c:set var="pagination" value="${map.pagination}"/>
<c:set var="mainCategoryNo" value="${map.mainCategoryNo}"/>
<c:set var="thirdCategoryNo" value="${map.thirdCategoryNo}"/>



<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리</title>
    
    <link rel="stylesheet" href="/resources/css/category/categoryList.css">
    
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
                    <select name="" id="budget" class="select"> 
                        <option value="0">예산</option>
                        <option value="1"<c:if test="${budget==1 }"> selected="selected"</c:if>>1만원 미만</option>
                        <option value="5"<c:if test="${budget==5 }"> selected="selected"</c:if>>1만원 - 5만원 이하</option>
                        <option value="10"<c:if test="${budget==10 }"> selected="selected"</c:if>>5만원 - 10만원 이하</option>
                        <option value="20"<c:if test="${budget==20 }"> selected="selected"</c:if>>10만원 - 20만원 이하</option>
                        <option value="30"<c:if test="${budget==30 }"> selected="selected"</c:if>>20만원 - 30만원 이하</option>
                        <option value="50"<c:if test="${budget==50 }"> selected="selected"</c:if>>30만원 - 50만원 이하</option>
                        <option value="70"<c:if test="${budget==70 }"> selected="selected"</c:if>>50만원 - 70만원 이하</option>
                        <option value="100"<c:if test="${budget==100 }"> selected="selected"</c:if>>70만원 - 100만원 이하</option>
                        <option value="999"<c:if test="${budget==999 }"> selected="selected"</c:if>>100만원 초과</option>
                    </select>

                    <span>프리랜서 등급</span>
                    <select name="" id="grade" class="select">
                        <option value="0">프리랜서 등급</option>
                        <option value="1"<c:if test="${grade==1 }"> selected="selected"</c:if>>NEW</option>
                        <option value="2"<c:if test="${grade==2 }"> selected="selected"</c:if>>LEVEL1</option>
                        <option value="3"<c:if test="${grade==3 }"> selected="selected"</c:if>>LEVEL2</option>
                        <option value="4"<c:if test="${grade==4 }"> selected="selected"</c:if>>MASTER</option>
                    </select>

                    <select name="index" id="index" class="select">
                        <option value="0"<c:if test="${order==0 }"> selected="selected"</c:if>>최신순</option>
                        <option value="1"<c:if test="${order==1}"> selected="selected"</c:if>>평점순</option>
                    </select>
                </form>
                
                
                <div id="imageContent">
                <c:forEach var="service" items="${serviceList }">
                
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
	                        <a href="/service/${service.serviceNo }" class="imageTitle">
	                        <span class="aaa" style="font-size:16px;">${service.serviceTitle }</span>
	                        <span class="imageOthers aaa">${service.serviceSummary }</span>
	                        <span class="imageOthers" style="margin-bottom:0px; text-align:end; font-size:16px;">${service.servicePriceString} 원</span>
                            <span class="imageOthers right"><strong>평점</strong>  <strong>★ ${service.reviewPoint}</strong> </span>
	                        <span class="imageOthers right"><strong>판매수</strong> <strong>${service.sellCount} 회</strong></span>
	                        </a>
	                     
	                    </div>
                    <!-- </a> -->
                	</div>
                </c:forEach>
                </div>    
            </div>
	
        </div>
        
        
        
        
        <div class="pagination-area">


                <ul class="pagination">
                
                    <!-- 첫 페이지로 이동 -->
                    <li><a href="/category/${mainCategoryNo}/${thirdCategoryNo}?cp=1${sURL}">&lt;&lt;</a></li>

                    <!-- 이전 목록 마지막 번호로 이동 -->
                    <li><a href="/category/${mainCategoryNo}/${thirdCategoryNo}?cp=${pagination.prevPage}${sURL}">&lt;</a></li>

					<c:forEach var="i" begin="${pagination.startPage}" 
                        end="${pagination.endPage}" step="1">
                        
                        <c:choose>
                            <c:when test="${i == pagination.currentPage}">
                                <%-- 현재 페이지인 경우 --%>
                                <!-- 현재 보고있는 페이지 -->
                                <li><a class="current">${i}</a></li>
                            </c:when>

                            <c:otherwise>
                                 <li><a href="/category/${mainCategoryNo}/${thirdCategoryNo}?cp=${i}${sURL}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    
                    <!-- 다음 목록 시작 번호로 이동 -->
                    <li><a href="/category/${mainCategoryNo}/${thirdCategoryNo}?cp=${pagination.nextPage}">&gt;</a></li>

                    <!-- 끝 페이지로 이동 -->
                    <li><a href="/category/${mainCategoryNo}/${thirdCategoryNo}?cp=${pagination.maxPage}">&gt;&gt;</a></li>
                </ul>
            </div>
    </section>
    
    
    


     <script>
        
        const memberNo="${loginMember.memberNo}";
        const main1="${map.mainCategoryNo}";
        const third1="${map.thirdCategoryNo}";
     
    </script>	
	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>	


 	
	 <script src="/resources/js/category/categoryList.js"></script>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
   
</body>
</html>