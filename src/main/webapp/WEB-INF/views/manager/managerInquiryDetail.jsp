<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>문의 내역 상세보기­</title>
<link rel="stylesheet"
	href="/resources/css/manager/managerInquiryDetail.css">




</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp" />
	<div class="main">
		<div class="mainContent">
			<!-- 문의 내역 상세보기 -->
			<div id="question-list-title-area">
                <div id="question-list-title">이용문의 상세 보기</div><br>
            </div>

            <%-- 테이블 제목 행 --%>
            <table>
                <tr id="tableHead">
                    <th style="width: 200px">${managerInquiry.userInquiryNo}번</th>
                    <th style="width: 600px">${managerInquiry.userInquiryTitle}</th>
                    <th style="width: 100px">상태 
                    <th id="requestStatusView">
                    <c:choose>
                        <c:when test="${managerInquiry.inquiryRequest == null}">
                            <span class="question-wating">답변 대기</span>
                        </c:when>
                        <c:when test="${managerInquiry.inquiryRequest != null}">
                            <span class="question-answer">답변 완료</span>
                        </c:when>
                    </c:choose>
                    </th>
                </tr>
            </table>

				<hr>
				<br>

				<div class="content">
					<c:choose>
                        <c:when test="${managerInquiry.memberProfile == null}">
                            <img src="/resources/images/프로필.PNG" class="myProfile">
                        </c:when>
                        <c:when test="${managerInquiry.memberProfile != null}">
                            <img src="${managerInquiry.memberProfile}" class="myProfile">
                        </c:when>
                    </c:choose>
					<table>
						<tr>
							<th style="width: 150px" class="firstTh">작성자</th>
							<td style="width: 850px">${managerInquiry.memberNickname}</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td>${managerInquiry.userInquiryCreateDate}</td>
						</tr>
						<tr>
							<th>내용</th>
							<td style="height: 150px">${managerInquiry.userInquiryContent}</td>
						</tr>
						<tr>
							<th class="uploadImage">업로드<br>파일
							</th>
							<td class="imageBox">
								<c:if test="${not empty managerInquiry.imageList}">
                                    <c:if test="${fn:length(managerInquiry.imageList)>0}">
                                        <c:forEach var="i" begin="0" end="${fn:length(managerInquiry.imageList)-1}">
                                        <div class="img-box">
                                            <div class="boardImg">
                                                <label for="img1">
                                                    <img class="preview" src="${managerInquiry.imageList[i].inquiryFilePath}">
                                                </label>
                                                <a href="${managerInquiry.imageList[i].inquiryFilePath}" download="${userInquiry.imageList[i].inquiryFilePath}">다운로드</a>
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

				<c:if test="${not empty managerInquiry.inquiryRequest}">
                        <!-- 댓글 남기기 -->
                        <section id="comment">
                                <c:if test="${managerInquiry.managerProfile == null}">
                                    <a href="/member/myInfo"><img src="/resources/images/관리자 프로필.PNG" class="myProfile"></a>
                                </c:if>
                                <c:if test="${managerInquiry.managerProfile != null}">
                                    <a href="/member/myInfo"><img src="${managerInquiry.managerProfile}" class="myProfile"></a>
                                </c:if>
                            <table>
                                <tr>
                                    <th class="writer">작성자</th>
                                    <td class="writerContent">${managerInquiry.managerNickname}</td>
                                </tr>
                                <tr>
                                    <th>답변 내용</th>
                                    <td class="textArea">${managerInquiry.inquiryRequest}</td>
                                </tr>
                            </table>
                        </section>
                </c:if>
                <c:if test="${empty managerInquiry.inquiryRequest}">
                    <section id="comment">
                        <div class="profileImage">
                        <c:choose>
                            <c:when test="${loginMember.memberProfile == null}">
                                <a href="/member/myInfo"><img src="/resources/images/프로필.PNG" class="myProfile"></a>
                            </c:when>
                            <c:when test="${loginMember.memberProfile != null}">
                                <a href="/member/myInfo"><img src="${loginMember.memberProfile}" class="myProfile"></a>
                            </c:when>
                        </c:choose>
                        </div>
                        <div id="commentInput">
                            <input type="text" name="inquiryRequest" class="inputComment" id="inputComment" maxlength="100" placeholder="100자 이내로 작성해주세요.">
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
        var memberName = '${loginMember.memberName}';
        var userInquiryNo = '${managerInquiry.userInquiryNo}';
    </script>

    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    <script src="/resources/js/manager/managerInquiry.js"></script> 
</body>
</html>