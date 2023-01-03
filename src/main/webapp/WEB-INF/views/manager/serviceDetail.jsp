<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>서비스 관리 상세보기</title>
    
    <link rel="stylesheet" href="/resources/css/myProject/askService.css">
    <link rel="stylesheet" href="/resources/css/category/serviceDetail.css">
    <style>
    .main>*{
        width: 1200px;
        margin: auto;
    }

    
    .expertPage{
        margin-bottom: 20px;
    }
    #approvalBtn{
        display : inline-block;
        width: 345px;
        height: 50px;
        background-color: #538126;
        border-radius:5px;
        text-align:center;
        color: white;
        font-size:20px;
        line-height:50px;
    }
    #restoreBtn{
        display : inline-block;
        width: 345px;
        height: 50px;
        background-color: #538126;
        border-radius:5px;
        text-align:center;
        color: white;
        font-size:20px;
        line-height:50px;
    }
    #btnA{
        display:inline-block;
        text-align:center;
        width: 695px;
        height: 50px;
        font-size: 20px;
        background-color: lightgray;
        border:1px solid lightgray;
        border-radius: 5px;
        color:white;
        line-height:50px;
        font-weight: bold;
    }

    #goToList{
        width: 1100px;
        height: 200px;
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 200px;
    }
    #goToList button{
        width: 300px;
        height: 60px;
        background-color: black;
        color: white;
        border-radius: 5px;
        border: 1px solid black;
        cursor: pointer;
        font-size: 18px;
    } 


    </style>
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp" />
    

       <div class="main">

        

        <div class="detailHeader">
            <div class="servicePhoto" style="overflow:hidden;">	<img alt="" src="${freelancerService.requestFilePath }" style="height:100%;"></div>
            <div class="serviceContent">
                <div class="serviceTitle">${freelancerService.serviceTitle }</div>
                <div class="serviceSummary">${freelancerService.serviceSummary }</div>
                <div class="serviceInfo">
                    <span>가격 <span>${freelancerService.servicePrice }</span>원</span>
                    <span>수정횟수 <span>${freelancerService.serviceEditNum }</span>회</span>
                    <span>작업일수 <span>${freelancerService.serviceWorkPeriod }</span>일</span>   
                </div>

                <div class="expertPage">
                    <div class="expertPhoto"><img alt="" src="${freelancerService.freelancerImage }" style="width:100%;"></div>
                    <div class="expertContent">
                        <div class="expertName"><a href="/category/viewFreelancerDetail">${freelancerService.freelancerName }</a></div>
                        <div class="responseInfo">
                            <span>응답시간<span>00</span></span>
                            <span>응답률<span>00</span></span>
                        </div>
                                    
                    </div>
                </div>
     
                <c:if test="${freelancerService.serviceStatus==1}">
                    <a id="approvalBtn" href="/manager/${freelancerService.serviceNo}/serviceApproval">승인</a>
                    <a id="restoreBtn" href="/manager/${freelancerService.serviceNo}/serviceRestore">반려</a>
              	</c:if>
                <c:if test="${freelancerService.serviceStatus==2 }">
              		<a id="btnA">판매 중인 상품입니다.</a>
              	</c:if>
                <c:if test="${freelancerService.serviceStatus==3 }">
              		<a id="btnA">미승인 상품입니다.</a>
              	</c:if>
                <c:if test="${freelancerService.serviceStatus==4 }">
              		<a id="btnA">판매 중지된 상품입니다.</a>
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
        
	        <c:forEach var="imageFile" items="${freelancerService.serviceImageFileList }">
	                	<img src="/resources/images/${imageFile.imageFilePath }" style="width:100%;">
	        </c:forEach>

        </div>
        
        <div id="goToList">
            <button id="goToListbtn">목록으로</button>
        </div>
        

    </div>

  

    
    
     <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    <script src="/resources/js/manager/serviceDetail.js"></script>
     
     <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
</body>
</html>