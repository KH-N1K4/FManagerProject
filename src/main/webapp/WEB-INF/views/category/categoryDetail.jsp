<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리</title>
    
    <link rel="stylesheet" href="/resources/css/myProject/askService.css">
     <link rel="stylesheet" href="/resources/css/category/serviceDetail.css">
     
      <script src="https://kit.fontawesome.com/f7459b8054.js" crossorigin="anonymous"></script>
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_ver1.jsp"/>

       <div class="main">
        <div><a href="">${fService.mainCategoryName }</a>><a href="">${fService.thirdCategoryName }</a></div>

        <div class="detailHeader">
            <div class="servicePhoto" style="overflow:hidden;">	<img alt="" src="${fService.requestFilePath }" style="height:100%;" name="servicePhoto"></div>
            <div class="serviceContent">
            	
                <div class="serviceTitle">
                
                	<span name="serviceTitle">${fService.serviceTitle }</span>
                	<%-- 찜하기 --%>
                    <span class="like-area">
                        <%-- likeCheck가 없다면 == 로그인 x 또는 좋아요x --%>
                        <c:if test="${empty likeCheck}">
                            <%-- 빈 하트 --%>
                            <i class="fa-regular fa-heart" id="boardLike"></i>
                        </c:if>
                        <%-- likeCheck가 있다면 == 로그인 o, 좋아요o --%>
                        <c:if test="${not empty likeCheck}">
                            <%-- 찬 하트 --%>
                            <i class="fa-solid fa-heart" id="boardLike"></i>
                        </c:if>
                        <%-- 좋아요 수 --%>
                        <span>${board.likeCount}</span>
                    </span>
                
                </div>
                 
                
                <div class="serviceSummary" name="serviceSummary">${fService.serviceSummary }</div>
                <div class="serviceInfo">
                    <span>가격 <span name="servicePrice"> <fmt:formatNumber value="${fService.servicePrice }" /></span>원</span>
                    <span>수정횟수 <span>${fService.serviceEditNum }</span>회</span>
                    <span>작업일수 <span>${fService.serviceWorkPeriod }</span>일</span>   
                </div>

                <div class="expertPage">
                    <div class="expertPhoto"><img alt="" src="${fService.memberProfile }" style="width:100%;"></div>
                    <div class="expertContent">
                        <div class="expertName"><a href="/service/freelancerDetail/${fService.freelancerNo}">${fService.memberName }</a></div>
                        <div class="responseInfo">
                            <span>응답시간<span>${fService.freeContactTime1 } ~ ${fService.freeContactTime2 }</span></span>
                            <span>응답률<span>${fService.inquiryRate }</span></span>
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
							<form action="/service/payment/${fService.serviceNo }" method="POST">
								<input type="hidden" name="serviceNo" value="${fService.serviceNo }">
								<input type="hidden" name="serviceTitle" value="${fService.serviceTitle }">
								<input type="hidden" name="serviceSummary" value="${fService.serviceSummary }">
								<input type="hidden" name="servicePhoto" value="${fService.requestFilePath }">
								<input type="hidden" name="servicePrice" value="${fService.servicePrice }">
							
								<button id="buyBtn">구매하기</button>
							</form>
							
						</c:otherwise>
					</c:choose> 
				</c:if> 
              
            </div>
            
        </div>
        
        
        <!-- 서비스 설명 부분 -->
        <div id="serviceInfo">
            <div><a href="#serviceContent">서비스 설명</a></div>
            <div><a href="#portfolio">포트폴리오</a></div>
            <div><a href="#cancelrefund">취소/환불</a></div>
            <div><a href="#serviceReview">서비스 평가</a></div>
        </div>
        
        <div class="detailInner">
        
        	
        
        	<a id="serviceContent"></a>  
        	<h3>서비스 설명</h3>
        	${fService.serviceContent}
	        <c:forEach var="imageFile" items="${fService.imageFileList }">
	                	<img alt="" src="${imageFile.imageFilePath }" style="width:100%;">
	        </c:forEach>
	        
	        <a id="portfolio"></a>
	        <h3>포트폴리오</h3>
	        
	          <div class="portfolioSection">
	        	<c:forEach var="portfolio" items="${fService.portfolioList }">
		        	<a>
		                <div class="portfolioPhoto"> 
			                <img alt="" src="${portfolio.portfolioThumbnail }" style="width:100%;"> 
			            	<span class="hidden">${portfolio.portfolioTitle }</span>
			            	<span class="hidden">${portfolio.portfolioContent }</span>
			            	<span class="hidden">${portfolio.portfolioThumbnail }</span>
			            	<span class="hidden">${portfolio.portfolioFilePath }</span>
		            	</div>
		            
		            </a>
	        	</c:forEach>  
        </div>
	        
	        <a id="cancelrefund"></a>
	       	<div>
	        <h3>취소/환불 규정</h3>
	       	
	       	<pre>
가. 기본 환불 규정
1. 전문가와 의뢰인의 상호 협의하에 청약 철회 및 환불이 가능합니다.
2. 작업이 완료된 이후 또는 자료, 프로그램 등 서비스가 제공된 이후에는 환불이 불가합니다.
( 소비자보호법 17조 2항의 5조. 용역 또는 「문화산업진흥 기본법」 제2조 제5호의 디지털콘텐츠의 제공이 개시된 경우에 해당)

나. 전문가 책임 사유
1. 전문가의 귀책사유로 당초 약정했던 서비스 미이행 혹은 보편적인 관점에서 심각하게 잘못 이행한 경우 결제 금액 전체 환불이 가능합니다.

다. 의뢰인 책임 사유
1. 서비스 진행 도중 의뢰인의 귀책사유로 인해 환불을 요청할 경우, 사용 금액을 아래와 같이 계산 후 총 금액의 10%를 공제하여 환불합니다.
총 작업량의 1/3 경과 전 : 이미 납부한 요금의 2/3해당액
총 작업량의 1/2 경과 전 : 이미 납부한 요금의 1/2해당액
총 작업량의 1/2 경과 후 : 반환하지 않음
			</pre>
	       	</div>
	        
	        
	        <a id="serviceReview"></a>
	        
	        <div id="serviceReviewList">
	        	<h3>서비스 평가</h3>
	        	<c:forEach var="review" items="${fService.reviewList }">
	        	
	        		<div class="singleReview">
			        	<div class="serviceReviewContent">
					        <div class="contentTop">
					            <div class="userProfile"><img src="" alt=""></div>
					            <div class="person">
					                <span class="userName">${review.memberName }
					                </span><br>
					            
					                <div><span class="starReport">
					                <c:forEach var="i" begin="1" end="5">	
					                	<c:choose>
					                		<c:when test="${review.reviewPoint>=i }">
					                		★
					                		</c:when>
					                		<c:otherwise>
					                		☆
					                		</c:otherwise>
					                	</c:choose>
					                	
					                </c:forEach>
					                
					                ${review.reviewPoint }
					                </span>&nbsp;|&nbsp;<span class="createTime">2022.01.02</span></div>
					                
					            </div>
					             <c:if test="${loginMember.memberNo==fService.freelancerNo }">
							        <div class="reportTop" id="${review.reviewNo }">
										<a class="reportReview">신고하기</a>
										
										<c:if test="${empty review.reviewCommentContent}">		                
											<a class="writeResponse">답글적기</a>	
										</c:if>				                
							        </div>
				                </c:if>
					        </div>
					        <c:if test="${review.reviewStatus=='1' }">
					        	<div class="reviewContent">${review.reviewContent }</div>
					        </c:if>
					        <c:if test="${review.reviewStatus=='2' }">
					        	<div class="reviewContent">신고된 리뷰입니다.</div>
					        </c:if>
					       <!--  <div class="date"></div> -->
					        
					       
					
					       <!--  <div class="serviceDetail"><span class="price">작업일: 22일</span>
					        <span class="reviewPhoto">주문 금액: 100만원 ~ 200만원</span></div> -->
					        
							<c:if test="${not empty review.reviewFilePath }">
					        <div class="serviceImage" > <img alt="" src="${review.reviewFilePath }" style="width:100%;"> </div>
							
							</c:if>
					    </div>
					    
					  
					  <c:if test="${loginMember.memberNo==fService.freelancerNo }">
							<c:if test="${empty review.reviewCommentContent}">
							    <div class="reviewResponse">
							        <div class="writeResponse">
							           <textarea rows="5" cols="100"></textarea><button id="${review.reviewNo }" class="writeComment">답글 남기기</button>
							        </div>
							
							    </div>
							</c:if>
						</c:if>
						<c:if test="${not empty review.reviewCommentContent}">
						    <div class="reviewResponse">
						        <div> <span class="freelancerName">프리랜서 이름 </span><span class="createTime">2022.01.02</span> </div>
						        <div class="responseContent">
						            ${review.reviewCommentContent}
						        </div>
						
						    </div>
						</c:if>
			        </div>
			        
			   </c:forEach>
			   </div>

        </div>
        
       <div class="modal">
            <jsp:include page="/WEB-INF/views/myProject/askService.jsp" /> 
       </div>
       
          
     <div class="modal_portfolioDetail">
             <jsp:include page="/WEB-INF/views/member/freelancer/portfolioDetail.jsp" /> 
     </div>
       
        

    </div>

  
<%--  <div class="modal_portfolioDetail">
             <jsp:include page="/WEB-INF/views/member/freelancer/portfolioDetail.jsp" /> 
     </div> --%>
    
    
     <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    
     <script>
        
        const memberNo="${loginMember.memberNo}";
        const serviceNo="${fService.serviceNo}";
        
        const memberEmail="${loginMember.memberEmail}"; 

     
    </script>	
     <script src="/resources/js/category/modal.js"></script>
     
       <script src="/resources/js/category/portfolioModal.js"></script> 
       
     <script src="/resources/js/category/categoryDetail.js"></script>
     
     <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
</body>
</html>