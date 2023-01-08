<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>결제완료 </title>

    <link rel="stylesheet" href="/header_ver2.css">
    <link rel="stylesheet" href="/resources/css/myProject/paying_complete.css">

</head>
<body>
    
     <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>


    <div id="payingMain">

        <div id="payingTitle">결제 완료</div>
        <div action="">
        
       

        <div id="serviceSection">
        <div id="servicePhoto"> <img alt="" src=" ${trade.requestFilePath }" style="width:100%;"> </div>
        <div>

            <div id="serviceContent"><span> ${trade.serviceTitle }</span><br>
            <span> ${trade.serviceSummary }</span></div>
            <div id="serviceCost">총 결제 금액 <span><fmt:formatNumber value="${trade.servicePrice }" /></span>원</div>
        
        </div>
        </div>

        <textarea name="" id="" cols="30" rows="10" placeholder="요청사항" readonly>${trade.tradeRequest }</textarea>
        <div id="btnSection">

            <a id="paymentBtn" href="/member/myProject/myPurchaseList">구매 목록</a>
            <a id="paymentCancel" href="/">메인으로</a>
        </div>
        </div>
    </div>

    

</body>
</html>