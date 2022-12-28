<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문의 내역</title>

    <link rel="stylesheet" href="/resources/css/manager/managerInquiryList.css">

</head>
<body>
    
    <jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp"/>


    <div class="main">
        <div id="question-list-title-area">
            
                <div id="question-list-title">문의 내역</div><br>
                <div class="select-area">문의 유형
                    <select class="select-area-input" name="" id="">
                        <option value="전체">전체</option>
                        <option value="문의">문의</option>
                        <option value="신고">환불</option>
                    </select>
                </div>
            
        </div>

        <div id="question-list-table">
        
            <!-- 테이블 컬럼명 -->
            <div class="question-list-table-column">
                <div class="question-num">번호</div>
                <div class="question-type">문의 유형</div>
                <div class="question-title">제목</div>
                <div class="question-date">작성일</div>
                <div class="question-status">상태</div>
            </div>

            <!-- 테이블 내용 -->
            <div class="question-list-table-content">
                <div class="question-num">1</div>
                <div class="question-type">문의</div>
                <div class="question-title"><a href="">제목1</a></div>
                <div class="question-date">작성일</div>
                <div class="question-status">
                    <span class="question-answer">답변 완료</span>
                </div>
                
            </div>
            <div class="question-list-table-content">
                <div class="question-num">2</div>
                <div class="question-type">신고</div>
                <div class="question-title"><a href="">제목2</div>
                <div class="question-date">작성일</div>
                <div class="question-status">
                    <span class="question-wating">대기중</span>
                </div>
                
            </div>
        
        </div> <!-- buy-table -->
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

    </div> <!-- main -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    

</body>
</html>