<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="managerInquiryList" value="${map.managerInquiryList}"/>
<c:set var="pagination" value="${map.pagination}"/>

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

    <div class="main">

        <div id="question-list-title-area">

			<span id="question-list-title">문의 내역 </span> 
			<span class="select-area"> 
				<select class="select-area-input" name="inquiryStatus" id="processStatus" onchange="selectChange()">
					<option value="0">전체</option> 
                    <option value="1" ${inputValue1}>답변 완료</option> 
                    <option value="2" ${inputValue2}>답변 대기</option> 
				</select>
			</span>

		</div>

        <div id="question-list-table">
        
            <!-- 테이블 컬럼명 -->
            <div class="question-list-table-column">
                <div class="question-num">번호</div>
                <div class="question-title">제목</div>
                <div class="question-date">작성일</div>
                <div class="question-status">진행 상태</div>
            </div>
            
            <!-- 테이블 내용 -->
            <c:choose>   
                <c:when test="${empty managerInquiryList}">
                    <div class="contentList">게시글이 존재하지 않습니다.</div>
                </c:when>
                <c:otherwise>
                    <c:forEach var="managerInquiry" items="${managerInquiryList}">
                        <div class="question-list-table-content">
                            <div class="question-num">${managerInquiry.userInquiryNo}</div>
                            <div class="question-title"><a href="/managerInquiryDetail/${managerInquiry.userInquiryNo}?cp=${pagination.currentPage}${sURL}">${managerInquiry.userInquiryTitle}</a></div>
                            <div class="question-date">${managerInquiry.userInquiryCreateDate}</div>
                            <div class="question-status">
                            <c:choose>
                                <c:when test="${managerInquiry.inquiryRequest == null}">
                                    <span class="question-wating">답변 대기</span>
                                </c:when>
                                <c:when test="${managerInquiry.inquiryRequest != null}">
                                    <span class="question-answer">답변 완료</span>
                                </c:when>
                            </c:choose>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>  


        </div> 
        <div class="pagination-area">
            <ul class="pagination">
                <c:if test="${not empty managerInquiryList}">
                <!-- 첫 페이지로 이동 -->
                <li><a href="/manager/managerInquiryList?cp=1${sURL}">&lt;&lt;</a></li>

                <!-- 이전 목록 마지막 번호로 이동 -->
                <li><a href="/manager/managerInquiryList?cp=${pagination.prevPage}${sURL}">&lt;</a></li>

                    <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                        <c:choose>
                            <c:when test="${i == pagination.currentPage}">
                                <%-- 현재 보고있는 페이지 --%>
                                <li><a class="current">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                                <%-- 현재 페이지를 제외한 나머지  --%>
                                <li><a href="/manager/managerInquiryList?cp=${i}${sURL}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                
                <!-- 다음 목록 시작 번호로 이동 -->
                <li><a href="/manager/managerInquiryList?cp=${pagination.nextPage}${sURL}">&gt;</a></li>

                <!-- 끝 페이지로 이동 -->
                <li><a href="/manager/managerInquiryList?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
                </c:if>
            </ul>
        </div>

        <form action="/manager/managerInquiryList" id="inquirySearch" method="get"> 
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
    
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    <script src="/resources/js/manager/managerInquiryList.js"></script> 
</body>
</html>