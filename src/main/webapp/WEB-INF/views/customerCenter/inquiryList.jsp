<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="userInquiryList" value="${map.userInquiryList}"/>
<c:set var="pagination" value="${map.pagination}"/>

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

    <jsp:include page="/WEB-INF/views/common/header_black_ver2 customer.jsp"/>

     <%-- 검색을 진행한 경우 --%>
    <c:if test="${not empty param.key}">
        <%-- /board/1?cp=3&key=t&query=테스트 --%>
        <c:set var="sURL" value="&key=${param.key}&query=${param.query}"/>
    </c:if>

    <section class="content">
        <div class="mainArea">
            <!-- 사이드 메뉴 -->
            <div class="sideMenu">
                <div id="inquiry"><a href="/userInquiry">문의하기</a></div>
                <div id="inquiryList"><a href="/userInquiryList">내 문의 내역</a></div>
            </div>

            <!-- 메인 콘텐츠 영역 -->
            <div class="mainContent">
                <div id="inquirySubmit">
                    <h3 id="title">내 문의 내역</h3>


                    <section class="formBox">
                        <form action="/userInquiryList" id="selectForm"> 
                            <div>진행 상태
                                <select name="inquiryTypeNo" id="division">
                                    <option value="0">전체</option> 
                                    <option value="1">답변 완료</option> 
                                    <option value="2">답변 대기중</option> 
                                </select>
                            </div>
                        </form>
                    </section>

                    <hr>

                    <table>
                        <tr>
                            <th style="width:100px">번호</th>
                            <th style="width:470px">제목</th>
                            <th style="width:150px">작성일</th>
                            <th style="width:150px">상태</th>
                        </tr>
                        <c:choose>
                            <c:when test="${empty userInquiryList}">
                                <!-- 게시글 목록 조회 결과가 비어있다면 -->
                                <tr>
                                    <th colspan="6"> 게시글이 존재하지 않습니다 .</th>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="userinquiry" items="${userInquiryList}">
                                    <tr>
                                        <td>${userinquiry.userInquiryNo}</td>
                                        <td><a href="/userInquiryDetail/${userinquiry.userInquiryNo}?cp=${pagination.currentPage}${sURL}">${userinquiry.userInquiryTitle}</a></td>
                                        <td>${userinquiry.userInquiryCreateDate}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${userinquiry.inquiryRequest == null}">
                                                    <span class="question-wating">답변 대기</span>
                                                </c:when>
                                                <c:when test="${userinquiry.inquiryRequest != null}">
                                                    <span class="question-answer">답변 완료</span>
                                                </c:when>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </table>
                    <hr>
                </div>

                    <div class="pagination-area">
                        <ul class="pagination">
                        
                            <!-- 첫 페이지로 이동 -->
                            <li><a href="/userInquiryList?cp=1${sURL}">&lt;&lt;</a></li>

                            <!-- 이전 목록 마지막 번호로 이동 -->
                            <li><a href="/userInquiryList?cp=${pagination.prevPage}${sURL}">&lt;</a></li>

                                <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                                    <c:choose>
                                        <c:when test="${i == pagination.currentPage}">
                                            <%-- 현재 보고있는 페이지 --%>
                                            <li><a class="current">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <%-- 현재 페이지를 제외한 나머지  --%>
                                            <li><a href="/userInquiryList?cp=${i}${sURL}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            
                            <!-- 다음 목록 시작 번호로 이동 -->
                            <li><a href="/userInquiryList?cp=${pagination.nextPage}${sURL}">&gt;</a></li>

                            <!-- 끝 페이지로 이동 -->
                            <li><a href="/userInquiryList?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>

                        </ul>
                    </div>
                    <form action="/userInquiryList" id="inquirySearch" method="get"> 
                        <select name="key" id="search-key">
                            <option value="t">제목</option> 
                            <option value="c">내용</option> 
                            <option value="tc">제목+내용</option> 
                        </select> 
                        <input type="text" name="query" id="search-query" placeholder=" 검색어를 입력해주세요" >  
                        <button>검색</button>
                    </form>
            </div>

        </div>
    </section>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <script src="/resources/js/customerCenter/inquiryList.js"></script>
</body>
</html>