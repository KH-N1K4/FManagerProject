<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리</title>
    
    <link rel="stylesheet" href="/resources/css/myProject/askService.css">
     <link rel="stylesheet" href="/resources/css/category/serviceDetail.css">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_ver1.jsp"/>
    

       <div class="main">
        <div><a href="">${fService.mainCategoryName }</a>><a href="">${fService.thirdCategoryName }</a></div>

        <div class="detailHeader">
            <div class="servicePhoto" style="overflow:hidden;">	<img alt="" src="${fService.requestFilePath }" style="height:100%;"></div>
            <div class="serviceContent">
                <div class="serviceTitle">${fService.serviceTitle }</div>
                <div class="serviceSummary">${fService.serviceSummary }</div>
                <div class="serviceInfo">
                    <span>가격 <span>${fService.servicePrice }</span>원</span>
                    <span>수정횟수 <span>${fService.serviceEditNum }</span>회</span>
                    <span>작업일수 <span>${fService.serviceWorkPeriod }</span>일</span>   
                </div>

                <div class="expertPage">
                    <div class="expertPhoto"><img alt="" src="${fService.memberProfile }" style="width:100%;"></div>
                    <div class="expertContent">
                        <div class="expertName"><a href="/category/viewFreelancerDetail">${fService.memberName }</a></div>
                        <div class="responseInfo">
                            <span>응답시간<span>00</span></span>
                            <span>응답률<span>00</span></span>
                        </div>
                        
                        <c:if test="${loginMember.memberNo!=fService.freelancerNo }"> 
                        	<a id="askService">서비스 문의 남기기></a>       
                        </c:if>              
                    </div>
                </div>
     
              	<c:if test="${fService.serviceDeleteFL=='Y' }">
              		<a id="pauseService1">판매가 중지된 상품입니다.</a>
              	</c:if>
              	<c:if test="${fService.serviceDeleteFL=='N' }">
	          		<c:choose>  
	          			
						<c:when test="${loginMember.memberNo==fService.freelancerNo }"> 
							<form action="/freelancer/pauseSerivce">
								<input type="hidden" name="serviceNo"value="${fService.serviceNo }">
							
								<button id="pauseService">판매중지</button>
							</form>
							
						</c:when> 
						<c:otherwise>
							<a id="buyBtn" href="/category/1/1/1/1/payment">구매하기</a>
						</c:otherwise>
					</c:choose> 
				</c:if> 
              
            </div>
            
        </div>
        
        
        <!-- 서비스 설명 부분 -->
        <div id="serviceInfo">
            <div><button>서비스 설명</button></div>
            <div><button>포트폴리오</button></div>
            <div><button>취소/환불</button></div>
            <div><button>서비스 평가</button></div>
        </div>
        
        <div class="detailInner">
        
	        <c:forEach var="imageFile" items="${fService.imageFileList }">
	                	<img alt="" src="${imageFile.imageFilePath }" style="width:100%;">
	        </c:forEach>

        </div>
        
       <div class="modal">
            <jsp:include page="/WEB-INF/views/myProject/askService.jsp" /> 
       </div>
        

    </div>

  

    
    
     <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    
     <script>
        
        const memberNo="${loginMember.memberNo}";
        const serviceNo="${fService.serviceNo}";
     
    </script>	
     <script src="/resources/js/category/modal.js"></script>
     <script src="/resources/js/category/category.js"></script>
     
     <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
</body>
</html>