<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
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
        <div><a href="/projectRequest/requestList/${userRequest.mainCategoryNo}/0/0">${userRequest.mainCategoryName}</a> > <a href="/projectRequest/requestList/${userRequest.mainCategoryNo}/${userRequest.subCategoryNo}/0">${userRequest.subCategoryName}</a></div>

        <div class="detailHeader">
            <div class="requestPhoto"><img src="${userRequest.requestfileList[0].requestFilePath}"></div>
            <div class="requestContent">
                <div class="requestContentTOP">
                    <div class="requestTitle">${userRequest.projectRequestTitle}</div>
                    <div class="requestSummary">${userRequest.projectRequestSummary}</div>
                    <div class="userNickName">${userRequest.memberNickName}</div>
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
                    <div class="buttonBox" id="buttonBox">
                        <a id="stopBtn" class="BtnTag"  href="#">의뢰중지</a>
                        <div class="ly_type layerStopRequest" id="layerStopRequest">
                            <div class="ly_cont">
                                <p>
                                내 프로젝트 의뢰 중지를 하시면<em class="c_gn"> 해당 의뢰를 다시 등록</em>하실 수 없습니다.<br>
                                <strong><span class="c_og">의뢰를 중지</span> 하시겠습니까?</strong>
                                </p>
                                <div class="btn">
                                    <a id="realStopBtn" class="btn_type2 layerStopRequestBtn"  href="#"><span class="_hideLayer">의뢰중지하기</span></a>
                                    <a href="#" class="btn_type3 _hideLayer"><span class="_hideLayer">취소</span></a>
                                </div>
                            </div>
                            <a href="#" class="clse _hideLayer"><span class="blind">닫기</span></a>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
        <div class="detailContent">

            

        </div>

        <div class="detailInner">
        <h3>서비스 설명</h3>
            <div>${userRequest.projectRequestContent}</div>
            <div>
                <c:forEach items="${userRequest.requestfileList}" var="requestfile">
                    <div class="requestPhotos"><img src="${requestfile.requestFilePath}"></div>
                </c:forEach>
            </div>
        </div>

        <div class="requestModal">
            <jsp:include page="/WEB-INF/views/projectRequest/modal/requestModal.jsp" /> 
       </div>
    </div>
    <!-- **************************************footer*************************************-->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <!-- **************************************footer*************************************-->
    <script>
        var proposalList = JSON.parse('${proposalListJson}');
        var loginMemberNickname = '${loginMember.memberNickname}';
        var loginMemberNo = '${loginMember.memberNo}';
        var loginMemberProfile = '${loginMember.memberProfile}';
        var freelancerFL = '${loginMember.freelancerFL}';
        var freelancerSalesCount = '${freelancerSalesCount}';
        var freelancerInfo = '${freelancerInfo}';
        var requestNoVar = '${userRequest.projectRequestNo}';
    </script>
    <!-- jQuery  -->
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>


    <script src="/resources/js/category/projectRequestDetail.js"></script>
    <script src="/resources/js/category/modal/requsetModal.js"></script>
    
</body>
</html>

