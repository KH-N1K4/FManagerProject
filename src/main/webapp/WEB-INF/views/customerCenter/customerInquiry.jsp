<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fmanager - 고객센터 문의하기</title>
    <link rel="stylesheet" href="/resources/css/CustomerServiceCenter/customerInquiry.css">
    <link rel="stylesheet" href="/resources/css/CustomerServiceCenter/serviceCenter.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_black_ver2 customer.jsp"/>


    <!-- 메인 -->
    <section class="content">
        <div class="mainArea">
            <!-- 사이드 메뉴 -->
            <div class="sideMenu">
                <div id="inquiry"><a href="/userInquiry">문의하기</a></div>
                <div id="inquiryList"><a href="/userInquiryList">내 문의 내역</a></div>
            </div>

            <!-- 메인 콘텐츠 영역 -->
            <div class="mainContent">
                <form action="userInquiryInsert" class="inquirySubmit"  id="inquiryInsert" method="POST" enctype="multipart/form-data">
                    <h3 id="title">문의하기</h3>
                    <span id="tltleInfo">[중요] 작업 문의는 해당 전문가에게 직접 남겨주세요.</span>
                    <br><br>

                    <div>제목</div>
                    <input type="text" name="userInquiryTitle" id="titleInput" maxlength="20">
                    
                    <br><br>

                    <div>문의 내용</div>
                    <textarea name="userInquiryContent" id="contentInput" cols="30" rows="10"></textarea>

                    <br>

                    <%-- imageList에 존재하는 이미지 순서에 따라 변수 선언 --%>
                    <c:forEach items="${userInquiry.imageList}" var="img">
                        <c:choose>
                            <c:when test="${img.imageOrder == 0}">
                                <c:set var="thumbNail" value="${img.imagePath}"/>
                            </c:when>
                            <c:when test="${img.imageOrder == 1}">
                                <c:set var="img1" value="${img.imagePath}"/>
                            </c:when>
                            <c:when test="${img.imageOrder == 2}">
                                <c:set var="img2" value="${img.imagePath}"/>
                            </c:when>
                        </c:choose>
                    </c:forEach>

                    <br><br><br>

                    <div>첨부 파일</div>
                    <div class="img-box">

                        <div class="boardImg">
                            <label for="img1">
                                <img class="preview" src="">
                            </label>
                            <input type="file" name="images" class="inputImage" id="img1" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>

                        <div class="boardImg">
                            <label for="img2">
                                <img class="preview" src="">
                            </label>
                            <input type="file" name="images" class="inputImage" id="img2" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>

                        <div class="boardImg">
                            <label for="img3">
                                <img class="preview" src="">
                            </label>
                            <input type="file" name="images" class="inputImage" id="img3" accept="image/*">
                            <span class="delete-image">&times;</span>
                        </div>
                    </div><br>    

                    <div class="buttonArea">
                        <button class="inquiryInsert" id="inquiryInsert">제출</button>
                        <div id="goToMain">메인으로</div>
                    </div>

                    <%-- 삭제될 이미지 순서를 저장한 input 태그 --%>
                    <input type="hidden" name="deleteList" id="deleteList" value="">
                    <%-- 수정 완료 후 리다이렉트 시 사용 예정 --%>
                    <input type="hidden" name="cp" value="${param.cp}">


                </form>
            </div>

        </div>
    </section>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <script src="/resources/js/customerCenter/customerCenter.js"></script>
    
</body>
</html>