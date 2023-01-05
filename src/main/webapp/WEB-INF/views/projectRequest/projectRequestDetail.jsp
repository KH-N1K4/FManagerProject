<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="requestfileList" value="${userRequest.requestfileList}"/>
<c:set var="proposalList" value="${userRequest.proposalList}"/>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리</title>
    
     <link rel="stylesheet" href="/resources/css/category/projectRequestDetail.css">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_ver1.jsp"/>

       <div class="main">
        <div><a href="">디자인</a>><a href="">디자인 상세</a></div>

        <div class="detailHeader">
            <div class="requestPhoto"><img src="${userRequest.requestfileList[0].requestFilePath}"></div>
            <div class="requestContent">
                <div class="requestContentTOP">
                    <div class="requestTitle">${userRequest.projectRequestTitle}</div>
                    <div class="userNickName">${userRequest.memberNickName}</div>
                    <div class="requestSummary">${userRequest.projectRequestSummary}</div>
                    <div class="requestInfo">
                        <div class="requestTop">
                            <span>예산 <span>${userRequest.projectRequestBudgetString}</span>원</span>
                            <span>작업일수 <span>${userRequest.projectWorkPeriod}</span>일</span>  
                        </div>
                        <div class="requestBottom">
                            <span>작업마감일 <span>${userRequest.projectRecruitDateString}</span></span>
                            <span>모집마감일 <span>${userRequest.projectWorkDateString}</span></span> 
                        </div>
                    </div>
                </div>
                <c:if test="${loginMember.memberNo ne userRequest.memberNo}">
                    <a id="requestBtn" class="BtnTag" href="#">제안하기</a>
                </c:if>
                <c:if test="${loginMember.memberNo eq userRequest.memberNo}">
                    <a id="stopBtn" class="BtnTag"  href="#">판매중지</a>
                </c:if>
                
               <!--  <button id="buyBtn">구매하기</button> -->
            </div>
        </div>
        <div class="detailContent">

            <ul>
                <li>의뢰사항</li>
            </ul>

        </div>

        <div class="detailInner"></div>

        <div class="requestModal">
            <jsp:include page="/WEB-INF/views/projectRequest/modal/requestModal.jsp" /> 
       </div>
    </div>
    <!-- **************************************footer*************************************-->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <!-- **************************************footer*************************************-->
    <script>
        var proposalListJson = JSON.parse('${userRequest.proposalList}');
        var loginMemberNickname = '${loginMember.memberNickname}';
        var loginMemberNo = '${loginMember.memberNo}';
        var loginMemberProfile = '${loginMember.memberProfile}';
        var freelancerFL = '${loginMember.freelancerFL}';
        var freelancerGrade = '${freelancerGrade}';
    </script>
    <!-- jQuery  -->
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>


    <script src="/resources/js/category/projectRequestDetail.js"></script>
    
</body>
</html>

