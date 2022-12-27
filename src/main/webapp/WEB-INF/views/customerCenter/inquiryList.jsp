<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="userInquiry" value="${userInquiry}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fmanager - 문의내역</title>
    <link rel="stylesheet" href="/resources/css/CustomerServiceCenter/inquiryList.css">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_black_ver2.jsp"/>


    <section class="content">
        <div class="mainArea">
            <!-- 사이드 메뉴 -->
            <div class="sideMenu">
                <div id="inquiry"><a href="/userInquiry">문의하기</a></div>
                <div id="inquiryList"><a href="/userInquiryList">내 문의 내역</a></div>
            </div>

            <!-- 메인 콘텐츠 영역 -->
            <div class="mainContent">
                <form action="" id="inquirySubmit">
                    <h3 id="title">내 문의 내역</h3>

                    <div>문의 유형 
                        <select name="inquiryTypeNo" id="division">
                            <option value="0">전체</option> 
                            <option value="1">문의</option> 
                            <option value="2">환불</option> 
                            <option value="3">신고</option> 
                        </select>
                    </div>

                    <hr>

                    <table>
                        <tr>
                            <th style="width:100px">번호</th>
                            <th style="width:100px">문의 유형</th>
                            <th style="width:350px">제목</th>
                            <th style="width:120px">작성일</th>
                            <th style="width:100px">상태</th>
                        </tr>
                        <c:forEach var="inquiry" begin="0" end="9" step="1" items="${userInquiry}">
                            <tr>
                                <td>${inquiry.userInquiryNo}</td>
                                <td>
                                <c:choose>
                                    <c:when test="${inquiry.inquiryTypeNo == 1}">문의</c:when>
                                    <c:when test="${inquiry.inquiryTypeNo == 2}">환불</c:when>
                                    <c:when test="${inquiry.inquiryTypeNo == 3}">신고</c:when>
                                </c:choose>
                                </td>
                                <td><a href="/userInquiryDetail/${inquiry.userInquiryNo}">${inquiry.userInquiryTitle}</a></td>
                                <td>${inquiry.userInquiryCreateDate}</td>
                                <td><button>해결</button></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <hr>
                </form>

                
                <br><br>
                <div id="pageList">
                    <a href=""> << </a> &nbsp;&nbsp;
                    <a href=""> < </a> &nbsp;&nbsp;
                    <a href="">페이지</a> &nbsp;&nbsp;
                    <a href="">></a> &nbsp;&nbsp;
                    <a href="">>></a>
                </div>
            </div>

        </div>
    </section>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>