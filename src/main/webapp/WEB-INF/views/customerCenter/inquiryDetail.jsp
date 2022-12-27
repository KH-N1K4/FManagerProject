<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <jsp:include page="/WEB-INF/views/common/header_black_ver2.jsp"/>

   
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
                <form action="" id="inquirySubmit">
                    <h3 id="title">문의내역</h3>

                    <hr>

                    <table>
                        <tr>
                            <th style="width:100px">${userInquiry.userInquiryNo}</th>
                            <th style="width:500px">${userInquiry.userInquiryTitle}</th>
                            <th style="width:100px">상태</th>
                            <th style="width:100px"><button>해결</button></th>
                        </tr>
                    </table>

                    <hr>

                    <table>
                        <tr>
                            <th style="width:100px">작성자</th>
                            <td style="width:700px">${userInquiry.memberName}</td>
                        </tr>
                        <tr>
                            <th>구분</th>
                            <td>문의</td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td><textarea name="" id="" cols="94" rows="10">${userInquiry.userInquiryContent}</textarea></td>
                        </tr>
                        <tr>
                            <th>첨부파일</th>
                            <td colspan="3">
                                <div class="container">
                                    <input type="text" class="upload-name" 
                                    value="${userInquiry.inquiryFilePath}" placeholder="파일을 업로드 하세요" readonly>
                                    <label for="upload-file">파일선택</label>
                                    <input type="file" id="upload-file">
                                </div>
                            </td>
                        </tr>
                    </table>
                    <hr><br>

                    <!-- ///////////////////////////////// -->
                    <!-- 댓글 남기기 -->
                    <section id="comment">
                        <img src="/1.jpg" alt="" class="myProfile">
                        <input type="text" placeholder="    댓글을 남겨주세요"  id="commentInput">&nbsp;
                        <button id="commentSumit">등록</button>
                    </section>
                </form>
            </div>


        </div>
    </section>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>


</body>
</html>