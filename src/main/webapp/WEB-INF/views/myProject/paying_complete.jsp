<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        
        ${trade }

        <div id="serviceSection">
        <div id="servicePhoto"></div>
        <div>

            <div id="serviceContent"><span>결제중 상품 제목</span><br>
            <span>결제중 상품 내용입니다.</span></div>
            <div id="serviceCost">총 결제 금액 <span>100,000</span>원</div>
        
        </div>
        </div>

        <textarea name="" id="" cols="30" rows="10" placeholder="요청사항" readonly></textarea>
        <div id="btnSection">

            <a id="paymentBtn" href="/member/myProject/myPurchaseList">구매 목록</a>
            <a id="paymentCancel" href="/">메인으로</a>
        </div>
        </div>
    </div>

    

</body>
</html>