<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>거래 신고 내역 상세보기­</title>
<link rel="stylesheet"
	href="/resources/css/manager/memberReportDetail.css">




</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp" />
	<div class="main">
		<div class="mainContent">
			<!-- 문의 내역 상세보기 -->
			<div id="question-list-title-area">
                <div id="question-list-title">거래 신고 내역 상세보기</div><br>
            </div>

            <%-- 테이블 제목 행 --%>
            <table>
                <tr id="tableHead">
                    <th style="width: 200px">${tradeReport.tradeReportNo}</th>
                    <th style="width: 600px">${tradeReport.tradeReportTypeName}</th>
                    <th style="width: 100px">상태 
                    <th id="requestStatusView">
                    <c:choose>
                        <c:when test="${tradeReport.refundFlag == 'N'}">
                            <span class="question-wating">답변 대기</span>
                        </c:when>
                        <c:when test="${tradeReport.refundFlag != 'N'}">
                            <span class="question-answer">해결 완료</span>
                        </c:when>
                    </c:choose>
                    </th>
                </tr>
            </table>

				<hr>
				<br>

				<div class="content">
					
					<table>
						<tr>
							<th style="width: 150px" class="firstTh">작성자</th>
							<td style="width: 850px">${tradeReport.tradeReportMemberName}</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td>${tradeReport.tradeReportCreateDate}</td>
						</tr>
						<tr>
							<th>내용</th>
							<td style="height: 150px">${tradeReport.tradeReportContent}</td>
						</tr>
						<tr>
							<th class="uploadImage">업로드<br>파일
							</th>
							<td class="imageBox">
                                <div class="img-box">
                                    <div class="boardImg">
                                        <label for="img1">
                                            <img class="preview" src="${tradeReport.tradeReportFilePath}">
                                        </label>
                                        <a href="/resources/images/${tradeReport.tradeReportFilePath}" download="${tradeReport.tradeReportFilePath}">다운로드</a>
                                    </div>
                                </div>    
							</td>
						</tr>
					</table>
				</div>
				<hr>
				<br>

				<!-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////a -->


				<div id="goToList">
					<button id="goToListbtn">목록으로</button>
				</div>
		</div>
	</div>
	<!-- main -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />


    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    <script src="/resources/js/manager/tradeReport.js"></script> 
</body>
</html>