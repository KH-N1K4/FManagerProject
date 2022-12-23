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

    <jsp:include page="/WEB-INF/views/common/header_black_ver2.jsp"/>


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
                <form action="userInquiryInsert" id="inquirySubmit" method="POST">
                    <h3 id="title">문의하기</h3>
                    <span id="tltleInfo">[중요] 작업 문의는 해당 전문가에게 직접 남겨주세요.</span>
                    <br><br>

                    <div>문의 유형</div>
                    <select name="" id="division">
                        <option value="">문의</option> 
                        <option value="">환불</option> 
                    </select>

                    <br><br>

                    <div>제목</div>
                    <input type="text" id="titleInput" maxlength="20">
                    
                    <br><br>

                    <div>문의 내용</div>
                    <textarea name="" id="" cols="30" rows="10"></textarea>

                    <br><br>
<%-- 
                    <div>첨부파일</div>
                    <div class="container">
                        <input type="text" class="upload-name" 
                        value="" placeholder="파일을 업로드 하세요" disabled>
                        <label for="upload-file">파일선택</label>
                        <input type="file" id="upload-file">
                    </div> --%>

                    <div>첨부파일</div>

                    <div class="insert">
                        <form action="./boardInsert" method="POST">
                            <input class="title" type="text" name="title" placeholder="Title"/>
                            <textarea class="content" name="content" placeholder="Content"></textarea>
                            <div class="file-hidden-list"></div>
                        </form>
                        <button id="addFile" class="add-button">Add File</button>
                        <div class="file-list"></div>
                    </div>


                   <br>

                    <button id="inquiryInsert"><a href="">제출</a></button>
                    <button id="goToMain"><a href="/">메인으로</a></button>

                </form>
            </div>

        </div>
    </section>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <script src="/resources/js/customerCenter/customerCenter.js"></script>
    
</body>
</html>