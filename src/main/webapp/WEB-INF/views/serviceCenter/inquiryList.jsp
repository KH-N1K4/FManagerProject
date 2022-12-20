<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fmanager - 문의내역</title>
    <link rel="stylesheet" href="/resources/css/CustomerServiceCenter/inquiryList.css">

</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp"/>



    <section class="content">
        <div class="mainArea">
            <!-- 사이드 메뉴 -->
            <div class="sideMenu">
                <div id="inquiry"><a href="">문의하기</a></div>
                <div id="inquiryList"><a href="">내 문의 내역</a></div>
            </div>

            <!-- 메인 콘텐츠 영역 -->
            <div class="mainContent">
                <form action="" id="inquirySubmit">
                    <h3 id="title">내 문의 내역</h3>

                    <div>문의 유형 
                        <select name="" id="division">
                            <option value="">전체</option> 
                            <option value="">문의</option> 
                            <option value="">신고</option> 
                        </select>
                    </div>

                    <hr>

                    <table>
                        <tr>
                            <th style="width:100px ">번호</th>
                            <th style="width:200px">구분</th>
                            <th style="width:370px">제목</th>
                            <th style="width:100px">상태</th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>문의</td>
                            <td><a href="/userInquiryDetail">제목 1</a></td>
                            <td><button>해결</button></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>신고</td>
                            <td><a href="">제목 2</a></td>
                            <td><button>해결</button></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>신고</td>
                            <td><a href="">제목 3</a></td>
                            <td><button>대기중</button></td>
                        </tr>
                    </table>
                    <hr>
                </form>

                <br><br>
                <div id="pageList">
                    <a href=""> << </a> &nbsp;&nbsp;
                    <a href=""> < </a> &nbsp;&nbsp;
                    <a href="">페이지</a> &nbsp;&nbsp;
                    <a href="">></a> &nbsp;&nbsp;
                    <a href="">>></a>
                </div>
            </div>

        </div>
    </section>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>