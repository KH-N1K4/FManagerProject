<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- <c:set var="freelancerIntro" value="${freelancer.freelancerIntro}"/> --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                            <input type="text" name="" id="" class="input" value="${freelancer1.freelancerIntro}" readonly> 
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
                            <input type="text" value="${freelancer1.regionName}"> 

                                
                        

                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">전문 분야</div>
                        <div>
                            <c:forEach var="field" items="${fn:split(freelancer1.freelancerField,',') }">
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
                            <input type="text" name="" id="" value="${freelancer1.freelancerPeriod}"class="number"> 년
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">경력 사항</div>
                        <div>
                            <%-- <input type="text" name="" id=""value="${freelancer.careerCompanyName}/${freelancer.careerCompanyDepartment}/${freelancer.careerCompanyPosition}/${freelancer.careerCompanyRegion}/${freelancer.careerCompanyPeriod}"> --%>
                            
                            <c:forEach var ="career" items="${freelancer1.careerList}">
                                <%-- <input type="text" name="" id="" value="${freelancer.licenseName}/${freelancer.licenseDate}/${freelancer.licenseAgency}"> --%>
                                <input type="text" name="" id="" value="${career.careerCompanyName}/${career.careerCompanyDepartment}/${career.careerCompanyPosition}/${career.careerCompanyRegion}/${career.careerCompanyPeriod1}">
                            </c:forEach>
                        
                        
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">자격증</div>
                        <div>
                            <c:forEach var ="license" items="${freelancer1.licenseList}">
                        
                                <input type="text" name="" id="" value="${license.licenseName}/${license.licenseDate}/${license.licenseAgency}">

                            </c:forEach>
                        
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">연락 가능 시간</div>
                        <div>
                            <input type="text" name="" id="" class="number" value="${freelancer1.contactTime1}"> 시 ~ <input type="text" name="" id="" class="number" value="${freelancer1.contactTime2}"> 시
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">수익금 출금 은행</div>
                        <div>
                            <input type="text" value="${freelancer1.bankName}"> 

                            <input type="text" value="${freelancer1.bankAccountNo}"name="" id="account">
                        </div>
                    </div>
                </div>
                <div id="addArea">
                    <div class="item">포트폴리오</div>
                    <div><a  id="addPortfolioPopupBtn">추가하기</a></div>
                </div>
                <div id="serviceArea">
                    <c:if test = "${not empty freelancer1.portfolioList}">
                        <c:forEach var="portfolio" items="${freelancer1.portfolioList}">
                            <%-- <a href="/portfolioDetail/${portfolio.portfolioNo}" id="portfolioDetailPopupBtn">
                            
                                <span class="service">
                                <span><img  style="width: 100%; height:100%; background-color:skyblue;"src="${portfolio.portfolioThumbnail}"></span>
                                    ${portfolio.portfolioTitle}<br>${portfolio.portfolioContent}
                                </span>
                                
                            </a> --%>
                            <span class="service">
                                <a>
                                    <div class="portfolioSection"> 
                                        <span>
                                        <img  style="width: 100%; height:100%; background-color:skyblue;"src="${portfolio.portfolioThumbnail}">
                                        </span>
                                        <span>${portfolio.portfolioTitle}</span>
                                        <br>
                                        <span>${portfolio.portfolioContent}</span>

                                        <span class="hidden">${portfolio.portfolioTitle }</span>      <%-- 4 --%>
		            	                <span class="hidden">${portfolio.portfolioContent }</span>    <%-- 5 --%>
                                        <span class="hidden">${portfolio.portfolioThumbnail}</span>    <%-- 6 --%>
		            	                <span class="hidden">${portfolio.portfolioFilePath }</span>    <%-- 7 --%>                              
                                    </div>
                                </a>
                            </span>
                        </c:forEach>
                    </c:if>
                    <c:if test ="${empty portfolioList}">
                        <div>포트폴리오가 존재하지 않습니다!!</div>
                    
                    </c:if>
                
                </div>
            <div class="modal_addPortfolio">
                    <jsp:include page="/WEB-INF/views/member/freelancer/modal/addPortfolio.jsp" /> 
            </div>
            <div class="modal_portfolioDetail">
                    <jsp:include page="/WEB-INF/views/member/freelancer/portfolioDetail.jsp" /> 
            </div>


            </section>
    </div>
        <script src="/resources/js/member/freelancer/freelancerInfo.js"></script> 

</body>
</html>