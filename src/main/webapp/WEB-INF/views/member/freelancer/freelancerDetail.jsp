<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>헤더</title>


    <link rel="stylesheet" href="/resources/css/freelancer/expertDetail.css">
</head>
<body>
    
    
    <jsp:include page="/WEB-INF/views/common/header_ver1.jsp"/>

  

    <div class="main">
     

        <div id="expertDetailTitle">판매자 정보</div>
        <div class="expertSummary">
            <div class="expertPhoto"></div>
            <div class="expertName">${freelancer.freelancerName }</div>
            <div class="expertOther">
                <div>총 작업수 <span>00</span></div>
                <div>등급 <span>00</span></div>
                <div>전문분야 <span>00</span></div>
            </div>
        </div>

        <div class="expertIntroduceTitle">자기소개</div>
        <div class="expertIntroduce">
        ${freelancer.freelancerIntro }
        </div>
        
        ${freelancer.careerList }
        ${freelancer.majorList }
        ${freelancer.licenseList }

        <div class="portfolioTitle">포트폴리오</div>
        <div class="portfolioSection">
        	<c:forEach var="portfolio" items="${freelancer.portfolioList }">
	        	<a href="">
	                <div class="portfolioPhoto"></div>
	            </a>
        	</c:forEach>  
        </div>
        <div class="serviceTitle">서비스들</div>
        <div class="serviceSection">
        	 <c:forEach var="service" items="${freelancer.fserviceList}">
	        	 <a href="/service/${service.serviceNo }">
	                <div class="serviceOne">
	                    <div class="servicePhoto"></div>
	                    <div class="serviceOneTitle">${service.serviceTitle}</div>
	                    <div class="serviceSubTitle">${service.serviceSummary}</div>
	                    <div class="serviceOther">
	                        <div>평점 ★<span> 4.7</span></div>
	                        <div>리뷰수 <span>00</span></div>
	                        <div>판매수 <span>00</span></div>
	                    </div>
	                </div>
	            </a>
        	</c:forEach>   
    	</div>

     <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>