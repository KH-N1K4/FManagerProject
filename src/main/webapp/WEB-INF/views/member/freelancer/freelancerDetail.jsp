<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <div class="expertName">김금쪽</div>
            <div class="expertOther">
                <div>총 작업수 <span>00</span></div>
                <div>등급 <span>00</span></div>
                <div>전문분야 <span>00</span></div>
            </div>
        </div>

        <div class="expertIntroduceTitle">자기소개</div>
        <div class="expertIntroduce"></div>

        <div class="portfolioTitle">포트폴리오</div>
        <div class="portfolioSection">
            <a href="">
                <div class="portfolioPhoto"></div>
            </a>
        </div>

        <div class="serviceTitle">서비스들</div>
        <div class="serviceSection">
            <a href="">
                <div class="serviceOne">
                    <div class="servicePhoto"></div>
                    <div class="serviceOneTitle">서비스 제목1</div>
                    <div class="serviceSubTitle">서비스 부제목1</div>
                    <div class="serviceOther">
                        <div>평점 ★<span> 4.7</span></div>
                        <div>리뷰수 <span>00</span></div>
                        <div>판매수 <span>00</span></div>
                    </div>
                </div>
            </a>

    	</div>

     <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>