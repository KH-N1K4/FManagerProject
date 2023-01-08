<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="freelancer" value="${map.freelancer}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프리랜서 정보</title>


    <link rel="stylesheet" href="/resources/css/manager/expertDetail.css">
</head>
<body class="mainBody">
    
    
    <jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp" />

  

    <div class="main" style="width:1200px; margin:auto;">

        <div id="expertDetailTitle">판매자 정보</div>
        <div class="expertSummary">
            <div class="expertPhoto"><img alt="" src="${freelancer.memberProfile }"> </div>
            <div class="expertName">${freelancer.freelancerName }</div>
            <div class="expertOther">
                <div>총 작업수 <span>00</span></div>
                <div>등급 <span>${freelancer.gradeName }</span></div>
                <div>전문분야 
                <c:forEach var="interest" items="${fn:split(freelancer.freelancerField,',') }" >
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

        <div class="expertIntroduceTitle">자기소개</div>
        <div class="expertIntroduce">
        ${freelancer.freelancerIntro }
        </div>
        
        <c:if test="${not empty freelancer.careerList}">
        <h4>경력</h4>
	       <c:forEach var="career1" items="${freelancer.careerList }">
	       	<span class="plus">${career1.careerCompanyName }/${career1.careerCompanyDepartment }/
	       	${career1.careerCompanyPosition }/${career1.careerCompanyRegion }/${career1.careerCompanyPeriod1 }</span>
	       </c:forEach>
        </c:if>
        
        <c:if test="${not empty freelancer.majorList}">
        <h4>학력</h4>
	       <c:forEach var="major" items="${freelancer.majorList }">
	       	<span class="plus">${major.majorAcademyName }/${major.majorName }/
	       	${major.majorGraduateStatus }</span>
	       </c:forEach>
        </c:if>
        
        <c:if test="${not empty freelancer.licenseList}">
        <h4>자격증</h4>
	       <c:forEach var="license" items="${freelancer.licenseList }">
	       	<span class="plus">${license.licenseName }/${license.licenseDate }/
	       	${license.licenseAgency }</span>
	       </c:forEach>
        </c:if>
       
       

        <div class="portfolioTitle">포트폴리오</div>
        <div class="portfolioSection">
        	<c:forEach var="portfolio" items="${freelancer.portfolioList }">
	        	<a>
	                <div class="portfolioPhoto"> 
		                <img alt="" src="${portfolio.portfolioThumbnail }" > 
		            	<span class="hidden">${portfolio.portfolioTitle }</span>
		            	<span class="hidden">${portfolio.portfolioContent }</span>
		            	<span class="hidden">${portfolio.portfolioThumbnail }</span>
		            	<span class="hidden">${portfolio.portfolioFilePath }</span>
	            	</div>
	            
	            </a>
        	</c:forEach>  
        </div>
        <div class="serviceTitle">서비스들</div>
        <div class="serviceSection">
        	 <c:forEach var="service" items="${freelancer.fserviceList}">
	        	 <a href="/service/${service.serviceNo }">
	                <div class="serviceOne">
	                    <div class="servicePhoto"><img alt="" src="${service.requestFilePath }"> </div>
	                    <div class="serviceOneTitle">${service.serviceTitle}</div>
	                    <div class="serviceSubTitle">${service.serviceSummary}</div>
	                    <div class="serviceOther">
	                        <div>평점 ★<span> 4.7</span></div>
	                        <div>리뷰수 <span>${service.reviewCount}</span></div>
	                        <div>판매수 <span>${service.sellCount}</span></div>
	                    </div>
	                </div>
	            </a>
        	</c:forEach>   
    	</div>
    </div>
    
     <div class="modal_portfolioDetail">
             <jsp:include page="/WEB-INF/views/member/freelancer/portfolioDetail.jsp" /> 
     </div>

     <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
     
      <script src="/resources/js/category/portfolioModal.js"></script> 

</body>
</html>