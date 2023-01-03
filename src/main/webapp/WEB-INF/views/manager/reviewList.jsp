<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리뷰 관리</title>

    <link rel="stylesheet" href="/resources/css/manager/reviewList.css">

</head>
<body>
    
        <jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp"/>


    <div class="main">
        <div id="review-manage-title-area">
            <div id="review-manage-title">리뷰 관리
           
            </div>
        </div>

        <div id="review-manage-table">
        
            <!-- 테이블 컬럼명 -->
            <div class="review-manage-table-column">
                <div class="review-num">댓글번호</div>
                <div class="review-content">리뷰 내용</div>
                <div class="review-writer">작성자</div>
                <div class="review-delete">
                </div>
            </div>

            <!-- 테이블 내용 -->
            <c:choose>   
                <c:when test="${empty reviewReportList}">
                    <div class="question-list-table-content">
                        <div class="contentList">게시글이 존재하지 않습니다.</div>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach var="reviewReport" items="${reviewReportList}">
                        <div class="review-manage-table-content">
                            <div class="review-num">1</div>
                            <div class="review-content"><a class="reviewDetail">리뷰 내용</a></div>
                            <div class="review-writer">김이박</div>
                            <div class="review-delete">
                                <span class="deleteBtn">삭제</span>
                                <span class="holdBtn">보류</span>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>    

        </div> <!-- buy-table -->

    </div> <!-- main -->
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <script src="/resources/js/manager/reviewReportList.js"></script>

</body>
</html>