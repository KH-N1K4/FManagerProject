<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fmanager - 문의내역 상세보기</title>
    <link rel="stylesheet" href="/resources/css/CustomerServiceCenter/inquiryDetail.css">

</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_black_ver2 customer.jsp"/>

   
    <section class="content">
        <div class="mainArea">
            <!-- 사이드 메뉴 -->
            <div class="sideMenu">
                <div id="inquiry"><a href="/userInquiry">문의하기</a></div>
                <div id="inquiryList"><a href="/userInquiryList">내 문의 내역</a></div>
            </div>

            <!-- 메인 콘텐츠 영역 -->
            <!-- ///////////////////////////////// -->
            <div class="mainContent">
                <!-- 문의 내역 상세보기 -->
                <div id="inquirySubmit">
                    <h3 id="title">문의내역</h3>

                    <hr>

                    <table>
                        <tr>
                            <th style="width:150px">${userInquiry.userInquiryNo}번</th>
                            <th style="width:500px">${userInquiry.userInquiryTitle}</th>
                            <th style="width:150px">상태</th>
                            <th style="width:200px">
                                <c:choose>
                                    <c:when test="${userInquiry.inquiryRequest == null}">
                                        <span class="question-wating">답변 대기</span>
                                    </c:when>
                                    <c:when test="${userInquiry.inquiryRequest != null}">
                                        <span class="question-answer">답변 완료</span>
                                    </c:when>
                                </c:choose>
                            </th>
                        </tr>
                    </table>

                    <hr><br>

                    <div class="content">
                        <c:choose>
                            <c:when test="${userInquiry.memberProfile == null}">
                                <a href="/member/myInfo"><img src="/resources/images/프로필.PNG" class="myProfile"></a>
                            </c:when>
                            <c:when test="${userInquiry.memberProfile != null}">
                                <a href="/member/myInfo"><img src="${userInquiry.memberProfile}" class="myProfile"></a>
                            </c:when>
                        </c:choose>
                        <table>
                            <tr>
                                <th style="width:150px">작성자</th>
                                <td style="width:650px">${userInquiry.memberNickname}</td>
                            </tr>
                            <tr>
                                <th>작성일</th>
                                <td>${userInquiry.userInquiryCreateDate}</td>
                            </tr>
                            <tr>
                                <th>내용</th>
                                <td class="textArea"><br>${userInquiry.userInquiryContent}<br><br></td>
                            </tr>
                            <tr>
                                <th class="uploadImage">업로드<br>파일</th>
                                <td class="imageBox">
                                    <c:if test="${not empty userInquiry.imageList}">
                                        <c:if test="${fn:length(userInquiry.imageList)>0}">
                                            <c:forEach var="i" begin="0" end="${fn:length(userInquiry.imageList)-1}">
                                            <div class="img-box">
                                                    <div class="boardImg">
                                                        <label for="img1">
                                                            <img class="preview" src="/resources/images/customerCenterImage/${userInquiry.imageList[i].inquiryFilePath}">
                                                        </label>
                                                        <a href="/resources/images/customerCenterImage/${userInquiry.imageList[i].inquiryFilePath}" download="/resources/images/customerCenterImage/${userInquiry.imageList[i].inquiryFilePath}">다운로드</a>
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
                    <hr><br>

                    <!-- ///////////////////////////////// -->
                    <c:if test="${not empty userInquiry.inquiryRequest}">
                        <!-- 댓글 남기기 -->
                        <section id="comment">
                            <div>
                                <img src="${userInquiry.managerProfile}" class="myProfile">
                            </div>
                            <div>
                            <table>
                                <tr>
                                    <th style="width:150px">작성자</th>
                                    <td style="width:650px">${userInquiry.managerNickname}</td>
                                </tr>
                                <tr>
                                    <th>작성일</th>
                                    <td>${userInquiry.inquiryRequestDate}</td>
                                </tr>
                                <tr>
                                    <th>답변</th>
                                    <td class="textArea">${userInquiry.inquiryRequest}</td>
                                </tr>
                            </table>
                        </section>
                    </c:if>
                    <div id="goToList">
                        <button id="goToListbtn">목록으로</button>
                    </div>
                </div>

            </div>


        </div>
    </section>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    <script src="/resources/js/customerCenter/inquiryDetail.js"></script>   
</body>
</html>