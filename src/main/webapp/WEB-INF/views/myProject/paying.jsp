<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>결제중 </title>

    <link rel="stylesheet" href="/header_ver2.css">
    <link rel="stylesheet" href="/resources/css/myProject/paying.css">

</head>
<body>
    
     <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>


    <div id="payingMain">
	
        <div id="payingTitle">결제 중...</div>
        <form action="/">
		
		
		
        <div id="serviceSection">
        <div id="servicePhoto"> <img src="${param.servicePhoto }" style="width:100%;"> </div>
        <div>

            <div id="serviceContent"><span>${param.serviceTitle }</span><br>
            <span>${param.serviceSummary }</span></div>
            <div id="serviceCost">총 결제 금액 <span>${param.servicePrice }</span>원</div>
        
        </div>
        </div>

        <textarea name="" id="" cols="30" rows="10" placeholder="요청사항"></textarea>
        <div id="btnSection">

            <button id="paymentBtn">결제</button>
            <button id="paymentCancel">취소</button>
        </div>
        </form>
    </div>

    

</body>
</html>