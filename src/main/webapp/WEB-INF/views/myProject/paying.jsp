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
        <form>

        <div id="serviceSection">
        <div id="servicePhoto"> <img src="${param.servicePhoto }" style="width:100%;"> </div>
        <div>

            <div id="serviceContent"><span>${param.serviceTitle }</span><br>
            <span>${param.serviceSummary }</span></div>
            <div id="serviceCost">총 결제 금액 <span>${param.servicePrice }</span>원</div>
        
        </div>
        </div>

        <textarea name="tradeRequest" id="tradeRequest" cols="30" rows="10" placeholder="요청사항"></textarea>
        <div id="btnSection">

            <a id="paymentBtn" onclick="iamport()" >결제</a>
            <a id="paymentCancel" href="/service/${param.serviceNo }">취소</a>
        </div>
        </form>
    </div>


  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
 
     <script>
        
        const memberNo="${loginMember.memberNo}";
        const serviceNo="${param.serviceNo}";
        
        const memberEmail="${loginMember.memberEmail}"; 

     
    </script>	
    
     <script src="/resources/js/category/pay.js"></script>

</body>
</html>