<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>포트폴리오 모달</title>

    <link rel="stylesheet" href="/resources/css/freelancer/portfolioDetail.css">


    
</head>
<body>



    <div id="portfolioDetailMain">
        <button id="">x</button>

        <div id="writerInfo">
            <div id="writerPhoto">
            <img src="${portfolio.memberProfile}" alt="">
            </div>
            <div id="writerName">${portfolio.memberName}</div>
        </div>

        <div id="portfolioSection">
            <div id="portfolioTitle">${portfolio.portfolioTitle}</div>
            <div id="portfolioContent">${portfolio.portfolioContent}</div>


            <div class="portfolioPhoto">
            <img src="${portfolio.portfolioFilePath}" alt="">
            </div>

        </div>



    </div>
    
    <script src="/resources/js/member/freelancer/portfolioDetail.js"></script>

</body>
</html>