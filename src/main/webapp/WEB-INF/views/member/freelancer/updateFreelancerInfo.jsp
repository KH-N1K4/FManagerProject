<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>전문가수정하기</title>

    <link rel="stylesheet" href="/resources/css/freelancer/updateExpertInfo.css">

</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
   

    <div class="main">
        
        <section class="sideMenu">
            <div class="aside">
                <a class="myProject_User_side" href="">내 정보</a>
                <a class="myProject_User_side" href="">전문가 정보</a>
                <a class="myProject_User_side" href="">찜한 목록</a>
                <a class="myProject_User_side" href="">비밀번호 변경</a>
                <a class="myProject_User_side" href="">회원 탈퇴</a>
            </div>
        </section>
        <div>
</div>
        <section class="mainMenu">
            <div id="title">수정하기</div>
            <form action="/member/freelancer/updateFreelancerInfo" enctype="multipart/form-data" method="POST">
                <div>
                    <div class="itemTitle">
                        <div class="item">지역</div>
                        <div>
                            <select name="regionNo">
                            <c:forEach var="list" items="${regionList}">
                                <option value="${list.regionNumber}" 
                                <c:if test ="${freelancer.regionNo eq list.regionNumber}">selected="selected"</c:if>>${list.regionName}</option>
                            </c:forEach> 
                            </select> 
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">전문 분야</div>
                        <div>
                              <c:forEach var="field" items="${fn:split(freelancer.mainCategoryNo,',') }">
                                <c:choose>
                                    <c:when test="${field == 1}">
                                        <c:set var="field1" value="checked"/>
                                    </c:when>
                                    <c:when test="${field == 2}">
                                        <c:set var="field2" value="checked"/>
                                    </c:when>
                                    <c:when test="${field == 3}">
                                        <c:set var="field3" value="checked"/>
                                    </c:when>
                                    <c:when test="${field == 4}">
                                        <c:set var="field4" value="checked"/>
                                    </c:when>
                                    <c:when test="${field == 5}">
                                        <c:set var="field5" value="checked"/>
                                    </c:when>               
                                </c:choose> 
                            </c:forEach>

                            <input type="checkbox" name="mainCategoryNo" id="design" value="1" ${field1}>
                            <label for="design" class="checkbox">디자인</label>
                            <input type="checkbox" name="mainCategoryNo" id="it" value="2" ${field2}>
                            <label for="it" class="checkbox">IT.프로그래밍</label>
                            <input type="checkbox" name="mainCategoryNo" id="video" value="3" ${field3}>
                            <label for="video" class="checkbox">영상</label>
                            <input type="checkbox" name="mainCategoryNo" id="photo" value="4" ${field4}>
                            <label for="photo" class="checkbox">사진</label>
                            <input type="checkbox" name="mainCategoryNo" id="sound"value="5" ${field5}>
                            <label for="sound" class="checkbox">음향</label>
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">기간</div>
                        <div>
                            <input type="text" name="freelancerCont" id="" class="number" value="${freelancer.freelancerCont}"> 년
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">경력 사항</div>
                        <div>
                            <input style="width :300px;" type="text" name="career" id="" value="${freelancer.careerCompanyName}/${freelancer.careerCompanyDepartment}/${freelancer.careerCompanyPosition}/${freelancer.careerCompanyRegion}/${freelancer.careerCompanyPeriod}">
                            <%-- <input type="text" name="careerCompanyDepartment" id="" value="${freelancer.careerCompanyDepartment}">
                            <input type="text" name="careerCompanyPosition" id="" value="${freelancer.careerCompanyPosition}">
                            <input type="text" name="careerCompanyRegion" id="" value="${freelancer.careerCompanyRegion}">
                            <input type="text" name="careerPeriod" id="" value="${freelancer.careerPeriod}"> --%>
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">자격증</div>
                        <div>
                            <input style="width :300px;" type="text" name="license" id="" value="${freelancer.licenseName}/${freelancer.licenseDate}/${freelancer.licenseAgency}">

                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">연락 가능 시간</div>
                        <div>
                            <input type="text" name="contactTime1" id="" class="number" value="${freelancer.contactTime1}"> 시 ~ 
                            <input type="text" name="contactTime2" id="" class="number" value="${freelancer.contactTime2}"> 시
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">수익금 출금 은행</div>
                        <div>
                            <select name="bankCode">
                            <c:forEach var="list" items="${bankList}">
                                <option value="${list.bankCode}" 
                                <c:if test ="${freelancer.bankCode eq list.bankCode}">selected="selected"</c:if>>${list.bankName}</option>
                            </c:forEach> 
                            </select> 
                            <input type="text" value="${freelancer.bankAccountNumber}"name="bankAccountNumber" id="account">
                        </div>
                    </div>
                    <div class="itemTitle"> 
                        <div class="item">자기소개</div>
                        <div>
                            <%-- <input type="text" name="freelancerIntro" id="freelancerIntro" class="input" >  --%>

                            <textarea name="freelancerIntro" id="freelancerIntro" cols="72" rows="10" >${freelancer.freelancerIntro}</textarea>
                        </div>
                    </div>
                    <div id="btnArea">
                        <button id="updateBtn">수정</button>
                    </div>
                </div>
            </form>
        </section>
    </div>
</body>
</html>