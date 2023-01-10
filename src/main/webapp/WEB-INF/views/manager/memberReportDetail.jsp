<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원 신고 내역 상세보기­</title>
<link rel="stylesheet"
	href="/resources/css/manager/memberReportDetail.css">




</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp" />
	<div class="main">
		<div class="mainContent">
			<!-- 문의 내역 상세보기 -->
			<div id="question-list-title-area">
                <div id="question-list-title">회원 신고 내역 상세보기</div><br>
            </div>

            <%-- 테이블 제목 행 --%>
            <table>
                <tr id="tableHead">
                    <th style="width: 200px">${memberReport.memberReportNo}</th>
                    <th style="width: 600px">${memberReport.memberReportTitle}</th>
                    <th style="width: 100px">상태 
                    <th id="requestStatusView">
                    <c:choose>
                        <c:when test="${memberReport.memberReportRequest == null}">
                            <span class="question-wating">답변 대기</span>
                        </c:when>
                        <c:when test="${memberReport.memberReportRequest != null}">
                            <span class="question-answer">답변 완료</span>
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
							<td style="width: 850px">${memberReport.reportMemberName}</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td>${memberReport.memberReportCreateDate}</td>
						</tr>
						<tr>
							<th>내용</th>
							<td style="height: 150px">${memberReport.memberReportContent}</td>
						</tr>
						<tr>
							<th class="uploadImage">업로드<br>파일
							</th>
							<td class="imageBox">
								<c:if test="${not empty memberReport.reportImageFileList}">
                                    <c:if test="${fn:length(memberReport.reportImageFileList)>0}">
                                        <c:forEach var="i" begin="0" end="${fn:length(memberReport.reportImageFileList)-1}">
                                        <div class="img-box">
                                            <div class="boardImg">
                                                <label for="img1">
                                                    <img class="preview" src="${memberReport.reportImageFileList[i].memberReportFilePath}">
                                                </label>
                                                <a href="${memberReport.reportImageFileList[i].memberReportFilePath}" download="/resources/images/${memberReport.reportImageFileList[i].memberReportFilePath}">다운로드</a>
                                            </div>
                                        </div>    
                                        <br>
                                        </c:forEach>
                                    </c:if>
                                </c:if>
							</td>
						</tr>
					</table>
				</div>
				<hr>
				<br>

				<!-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////a -->

				<c:if test="${not empty memberReport.memberReportRequest}">
                        <!-- 댓글 남기기 -->
                        <section id="comment">
                        <div id="commentInput">
                            <input type="text" name="memberReportRequest" class="inputComment" id="memberReportRequest" value="${memberReport.memberReportRequest}"readonly>
                        </div>
                    </section>
                </c:if>
                <c:if test="${empty memberReport.memberReportRequest}">
                    <section id="comment">
                        <div id="commentInput">
                            <input type="text" name="memberReportRequest" class="inputComment" id="inputComment">
                            <button id="commentBtn">등록</button>
                        </div>
                    </section>
                </c:if>


				<div id="goToList">
					<button id="goToListbtn">목록으로</button>
				</div>
		</div>
	</div>
	<!-- main -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script>
        var memberNo = '${loginMember.memberNo}';
        var memberReportNo = '${memberReport.memberReportNo}';
    </script>

    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    <script src="/resources/js/manager/memberReport.js"></script> 
</body>
</html>