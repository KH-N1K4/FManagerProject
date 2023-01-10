<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="userInquiryList" value="${map.userInquiryList}"/>
<c:set var="pagination" value="${map.pagination}"/>
<c:set var="i" value="0"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fmanager - 문의 내역</title>
    <link rel="stylesheet" href="/resources/css/CustomerServiceCenter/inquiryList.css">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_black_ver2 customer.jsp"/>

    <%-- 검색을 진행한 경우 --%>
    <c:if test="${not empty param}">
        <c:forEach var="parameter" items="${param}">
				<c:if test="${parameter.key != 'cp'}">
					<c:set var="sURL" value="${sURL}&${parameter.key}=${parameter.value}"/>
				</c:if>
		</c:forEach>
    </c:if>

    <c:if test="${not empty param.value}">      
        <c:forEach var="inputValue" items="${param.value}">
            <c:choose>
                <c:when test="${inputValue == '1'}">
                    <c:set var="inputValue1" value="selected" />
                </c:when>
                <c:when test="${inputValue == '2'}">
                    <c:set var="inputValue2" value="selected" />
                </c:when>
            </c:choose>
        </c:forEach>
    </c:if>
    <c:if test="${empty param.value}">
            <c:choose>
                <c:when test="${map.optionVal == '1'}">
                    <c:set var="inputValue1" value="selected" />
                </c:when>
                <c:when test="${map.optionVal == '2'}">
                    <c:set var="inputValue2" value="selected" />
                </c:when>
            </c:choose>
    </c:if>


    <section class="content">
        <div class="mainArea">
            <!-- 사이드 메뉴 -->
            <div class="sideMenu">
                <div id="inquiry"><a href="/userInquiry">문의하기</a></div>
                <div id="inquiryList"><a href="/userInquiryList">내 문의 내역</a></div>
                <div id="userReportList"><a href="/userInquiryList/userReportList">회원 신고 내역</a></div>
            </div>

            <!-- 메인 콘텐츠 영역 -->
            <div class="mainContent">
                <div id="inquirySubmit">
                    <h3 id="title">내 문의 내역</h3>


                    <section class="formBox">
                        <form action="/userInquiryList" id="selectForm"> 
                            <div> 
                                <span id="processStatusTitle">진행 상태</span>
                                <select name="inquiryStatus" id="processStatusSelect" onchange="selectChange()">
                                    <option value="0">전체</option> 
                                    <option value="1" ${inputValue1}>답변 완료</option> 
                                    <option value="2" ${inputValue2}>답변 대기</option> 
                                </select>
                            </div>
                        </form>
                    </section>

                    <hr>
                    <table id="table">
                        <tr>
                            <th style="width:100px">번호</th>
                            <th style="width:470px">제목</th>
                            <th style="width:150px">작성일</th>
                            <th style="width:150px">상태</th>
                        </tr>
                        <c:choose>
                            <c:when test="${empty userInquiryList}">
                                <!-- 게시글 목록 조회 결과가 비어있다면 -->
                                <tr class="contentArea">
                                    <td colspan="6"> 게시글이 존재하지 않습니다 .</td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="userinquiry" items="${userInquiryList}" varStatus="status">
                                    <tr class="contentArea">
                                     <c:set var="total" value="${pagination.currentPage-1 }" />
                                     <c:set var="total1" value="${total*5 }" />
                                        <td>${total1 + status.count}</td>
                                        <%-- <td>${userinquiry.userInquiryNo}</td> --%>
                                        <td><a href="/userInquiryDetail/${userinquiry.userInquiryNo}?cp=${pagination.currentPage}${sURL}">${userinquiry.userInquiryTitle}</a></td>
                                        <td>${userinquiry.userInquiryCreateDate}</td>
                                        <td><%-- <span class="question-answer">${userinquiry.inquiryStatus}</span> --%>
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
                        <c:if test="${not empty userInquiryList}">
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
                        </c:if>
                        </ul>
                    </div>
                    
                    <form action="/userInquiryList" id="inquirySearch" method="get"> 
                        <select name="key" id="search-key">
                            <option value="t">제목</option> 
                            <option value="c">내용</option> 
                            <option value="tc">제목+내용</option> 
                        </select> 
                        <input type="text" name="query" id="search-query" placeholder=" 검색어를 입력해주세요" <c:if test="${not empty param.key}">value='${param.query}'</c:if>>  
                        <button>검색</button>
                    </form>
            </div>

        </div>
    </section>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
    <script>
            var userInquiryNo = "${userinquiry.userInquiryNo}";
            var currentPage = "${pagination.currentPage}";
            var sURL = "${sURL}";
            var userInquiryTitle = "${userinquiry.userInquiryTitle}";
            var userInquiryCreateDate = "${userinquiry.userInquiryCreateDate}";
            var inquiryRequest = "${userinquiry.inquiryRequest}";
    </script>

    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    <script src="/resources/js/customerCenter/inquiryList.js"></script>
</body>
</html>