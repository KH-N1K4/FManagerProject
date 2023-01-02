<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로젝트 의뢰 관리 상세보기</title>
    
    <link rel="stylesheet" href="/resources/css/myProject/askService.css">
    <link rel="stylesheet" href="/resources/css/category/serviceDetail.css">
    <style>
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

    </style>
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_ver1.jsp"/>
    

       <div class="main">
        

        <div class="detailHeader">
            <div class="servicePhoto" style="overflow:hidden;">	<img alt="" src="" style="height:100%;"></div>
            <div class="serviceContent">
                <div class="serviceTitle">${projectRequest.projectRequestTitle }</div>
                <div class="serviceSummary">${projectRequest.projectRequestSummary}</div>
                <div class="serviceInfo">
                    <span>예산 <span>${projectRequest.projectRequestBudget }</span>원</span>
                    <span>모집 마감일 <span>${projectRequest.requestRecruitDate }</span>회</span>
                    <span>작업 마감일 <span>${projectRequest.requestWorkDate }</span>일</span>   
                </div>

                <%-- <div class="expertPage">
                    <div class="expertPhoto"><img alt="" src="${freelancerService.freelancerImage }" style="width:100%;"></div>
                    <div class="expertContent">
                        <div class="expertName"><a href="/category/viewFreelancerDetail">${freelancerService.freelancerName }</a></div>
                        <div class="responseInfo">
                            <span>응답시간<span>00</span></span>
                            <span>응답률<span>00</span></span>
                        </div>
                                    
                    </div>
                </div> --%>
     
                <c:if test="${projectRequest.projectRequestStatus==1}">
                    <a id="approvalBtn" href="/manager/${projectRequest.projectRequestNo}/requestApproval">승인</a>
                    <a id="restoreBtn" href="/manager/${projectRequest.projectRequestNo}/requestRestore">반려</a>
              	</c:if>
                <c:if test="${projectRequest.projectRequestStatus==2 }">
              		<a id="pauseService1">모집 중인 상품입니다.</a>
              	</c:if>
                <c:if test="${projectRequest.projectRequestStatus==3 }">
              		<a id="pauseService1">미승인 상품입니다.</a>
              	</c:if>
                <c:if test="${projectRequest.projectRequestStatus==4 }">
              		<a id="pauseService1">모집 마감된 상품입니다.</a>
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
        
	        <%-- <c:forEach var="imageFile" items="${projectRequest.imageFileList }">
	                	<img alt="" src="" style="width:100%;">
	        </c:forEach> --%>

        </div>
        
        

    </div>

  

    
    
     <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    
     
     <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
</body>
</html>