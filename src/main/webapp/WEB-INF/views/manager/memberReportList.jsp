<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="memberReportList" value="${map.memberReportList}"/>
<c:set var="pagination" value="${map.pagination}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 신고 내역</title>

    <link rel="stylesheet" href="/resources/css/manager/memberReportList.css">

</head>
<body>
    
    <jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp"/>

    <c:if test="${not empty param.key}">
        <c:set var="sURL" value="&key=${param.key}&query=${param.query}"/>
    </c:if>

    <div class="main">

        <div id="question-list-title-area">

			<span id="question-list-title">회원 신고 내역 </span> 
			<span class="select-area"> 
				<select class="select-area-input" name="status" id="selectStatus" onchange="selectChange()">
					<option value="">진행 상태</option>
					<option value="1">답변 대기</option>
					<option value="2">해결 완료</option>
				</select>
			</span>

		</div>

        <div id="question-list-table">
        
            <!-- 테이블 컬럼명 -->
            <div class="question-list-table-column">
                <div class="question-num">번호</div>
                <div class="question-date">작성일</div>
                <div class="question-title">제목</div>
                <div class="question-report">신고자</div>
                <div class="question-reported">피신고자</div>
                <div class="question-status">진행 상태</div>
            </div>
            
            <!-- 테이블 내용 -->
            <c:choose>   
                <c:when test="${empty memberReportList}">
                    <div class="question-list-table-content center">
                        게시글이 존재하지 않습니다.
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach var="memberReport" items="${memberReportList}">
                        <div class="question-list-table-content">
                            <div class="question-num">${memberReport.memberReportNo}</div>
                            <div class="question-date">${memberReport.memberReportCreateDate}</div>
                            <div class="question-title"><a href="/manager/memberReportDetail/${memberReport.memberReportNo}?cp=${pagination.currentPage}${sURL}">${memberReport.memberReportTitle}</a></div>
                            <div class="question-report">${memberReport.reportMemberName}</div>
                            <div class="question-reported">${memberReport.reportedMemberName}</div>
                            <div class="question-status">
                            <c:choose>
                                <c:when test="${memberReport.memberReportRequest == null}">
                                    <span class="question-wating">답변 대기</span>
                                </c:when>
                                <c:when test="${memberReport.memberReportRequest != null}">
                                    <span class="question-answer">해결 완료</span>
                                </c:when>
                            </c:choose>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>    

        
        </div> <!-- buy-table -->
        <div class="pagination-area">
                        <ul class="pagination">
                        
                            <!-- 첫 페이지로 이동 -->
                            <li><a href="/manager/memberReportList?cp=1${sURL}">&lt;&lt;</a></li>

                            <!-- 이전 목록 마지막 번호로 이동 -->
                            <li><a href="/manager/memberReportList?cp=${pagination.prevPage}${sURL}">&lt;</a></li>

                                <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                                    <c:choose>
                                        <c:when test="${i == pagination.currentPage}">
                                            <%-- 현재 보고있는 페이지 --%>
                                            <li><a class="current">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <%-- 현재 페이지를 제외한 나머지  --%>
                                            <li><a href="/manager/memberReportList?cp=${i}${sURL}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            
                            <!-- 다음 목록 시작 번호로 이동 -->
                            <li><a href="/manager/memberReportList?cp=${pagination.nextPage}${sURL}">&gt;</a></li>

                            <!-- 끝 페이지로 이동 -->
                            <li><a href="/manager/memberReportList?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>

                        </ul>
                    </div>
                    <form action="/manager/memberReportList" id="inquirySearch" method="get"> 
                        <select name="key" id="search-key">
                            <option value="t">제목</option> 
                            <option value="c">내용</option> 
                            <option value="tc">제목+내용</option>
                            <option value="report">신고자명</option> 
                            <option value="reported">피신고자명</option> 
                        </select> 
                        <input type="text" name="query" id="search-query" placeholder=" 검색어를 입력해주세요" >  
                        <input type="hidden" name="status" id="inputStatus">
                        <button>검색</button>
                    </form>

    </div> <!-- main -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
 <script src="/resources/js/manager/memberReportList.js"></script>
</body>
</html>