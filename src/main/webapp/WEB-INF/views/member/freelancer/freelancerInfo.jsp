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
                    <div id="updateArea"><a href="" id="update">수정하기</a></div>
                    <div>
                        <div class="item">자기소개</div>
                        <div>
                            <input type="text" name="" id="" class="input" value="${freelancer.freelancerIntro}"> 
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">지역</div>
                        <div>
                            <select>
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
                            <input type="checkbox" name="" id="design">
                            <label for="design" class="checkbox">디자인</label>
                            <input type="checkbox" name="" id="it">
                            <label for="it" class="checkbox">IT.프로그래밍</label>
                            <input type="checkbox" name="" id="video">
                            <label for="video" class="checkbox">영상</label>
                            <input type="checkbox" name="" id="photo">
                            <label for="photo" class="checkbox">사진</label>
                            <input type="checkbox" name="" id="sound">
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
                        <div></div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">자격증</div>
                        <div></div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">연락 가능 시간</div>
                        <div>
                            <input type="text" name="" id="" class="number"> 시 ~ <input type="text" name="" id="" class="number"> 시
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">수익금 출금 은행</div>
                        <div>
                            <select name="" id="bankName">
                                <option value="">전체</option>
                                <option value="">신한</option>
                                <option value="">국민</option>
                                <option value="">우리</option>
                                <option value="">기업</option>
                            </select>
                            <input type="text" name="" id="account">
                        </div>
                    </div>
                </div>
                <div id="addArea">
                    <div class="item">포트폴리오</div>
                    <div><a href="" id="add">추가하기</a></div>
                </div>
                <div id="serviceArea">
                    <div class="service">g</div>
                    <div class="service">g</div>
                    <div class="service">g</div>
                    <div class="service">g</div>
                    <div class="service">g</div>
                </div>
                
            </section>
    </div>
</body>
</html>