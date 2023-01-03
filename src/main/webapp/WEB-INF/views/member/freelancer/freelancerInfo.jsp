<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- <c:set var="freelancerIntro" value="${freelancer.freelancerIntro}"/> --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>전문가 정보</title>

    <link rel="stylesheet" href="/resources/css/freelancer/expertInfo.css">
</head>

<body>
    <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
    <div class="main">
        
        <jsp:include page="/WEB-INF/views/member/memberSide.jsp"/>
        
            <section class="mainMenu">
                <div id="title">전문가 정보</div>
                <div>
                    <div id="updateArea"><a href="/member/freelancer/updateFreelancerInfo" id="update">수정하기</a></div>
                    <div>
                        <div class="item">자기소개</div>
                        <div>
                            <input type="text" name="" id="" class="input" value="${freelancer.freelancerIntro}" readonly> 
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">지역</div>
                        <div>
                            <%-- <select>
                            <c:forEach var="list" items="${regionList}">
                                <option value="${list.regionNumber}" 
                                <c:if test ="${freelancer.regionNo eq list.regionNumber}">selected="selected"</c:if>
                                >${list.regionName}
                                </option>
                            </c:forEach> 
                            </select>  --%>

                            <%-- <c:if test ="${freelancer.regionNo eq list.regionNumber}"></c:if> --%>
                            <input type="text" value="${freelancer.regionName}"> 

                                
                        

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
                            <input type="text" name="" id="" value="${freelancer.freelancerCont}"class="number"> 년
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">경력 사항</div>
                        <div>
                            <input type="text" name="" id=""value="${freelancer.careerCompanyName}/${freelancer.careerCompanyDepartment}/${freelancer.careerCompanyPosition}/${freelancer.careerCompanyRegion}/${freelancer.careerCompanyPeriod}">
                            <%-- <input type="text" name="" id="" value="${freelancer.careerCompanyDepartment}">
                            <input type="text" name="" id="" value="${freelancer.careerCompanyPosition}">
                            <input type="text" name="" id="" value="${freelancer.careerCompanyRegion}">
                            <input type="text" name="" id="" value="${freelancer.careerPeriod}"> --%>
                        
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">자격증</div>
                        <div>
                            <input type="text" name="" id="" value="${freelancer.licenseName}/${freelancer.licenseDate}/${freelancer.licenseAgency}">

                        
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">연락 가능 시간</div>
                        <div>
                            <input type="text" name="" id="" class="number" value="${freelancer.contactTime1}"> 시 ~ <input type="text" name="" id="" class="number" value="${freelancer.contactTime2}"> 시
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">수익금 출금 은행</div>
                        <div>
                            <input type="text" value="${freelancer.bankName}"> 

                            <input type="text" value="${freelancer.bankAccountNumber}"name="" id="account">
                        </div>
                    </div>
                </div>
                <div id="addArea">
                    <div class="item">포트폴리오</div>
                    <div><a href="/member/freelancer/modal/addPortfolio" id="add">추가하기</a></div>
                </div>
                <div id="serviceArea">
                    <c:if test = "${not empty portfolioList}">
                        <c:forEach var="portfolio" items="${portfolioList}">
                        <span>
                        
                            <span class="service">
                            <span><img src="/resources/images/무파마.jpg"></span>
                            ${portfolio.portfolioTitle}<br>${portfolio.portfolioContent}
                            </span>
                            
                        </span>
                        </c:forEach>
                    </c:if>
                    <c:if test ="${empty portfolioList}">
                        <div>포트폴리오가 존재하지 않습니다!!</div>
                    
                    </c:if>
                   
                </div>
                
            </section>
    </div>
</body>
</html>