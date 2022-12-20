<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>전문가수정하기</title>

    <link rel="stylesheet" href="/resources/css/freelancer/updateExpertInfo.css">

</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
   

    <div class="main">
        
        <section class="sideMenu">
            <div class="aside">
                <a class="myProject_User_side" href="">내 정보</a>
                <a class="myProject_User_side" href="">전문가 정보</a>
                <a class="myProject_User_side" href="">찜한 목록</a>
                <a class="myProject_User_side" href="">비밀번호 변경</a>
                <a class="myProject_User_side" href="">회원 탈퇴</a>
            </div>
        </section>
        
        <section class="mainMenu">
            <div id="title">수정하기</div>
            <form action="">
                <div>
                    <div class="itemTitle">
                        <div class="item">지역</div>
                        <div>
                            <select name="" id="area">
                                <option value="">전체</option>
                                <option value="">서울</option>
                                <option value="">경기</option>
                                <option value="">부산</option>
                                <option value="">대구</option>
                                <option value="">인천</option>
                                <option value="">광주</option>
                                <option value="">대전</option>
                                <option value="">울산</option>
                                <option value="">강원</option>
                                <option value="">충북</option>
                                <option value="">충남</option>
                                <option value="">전북</option>
                                <option value="">전남</option>
                                <option value="">경북</option>
                                <option value="">경남</option>
                                <option value="">제주</option>
                                <option value="">해외</option>
                            </select>
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">전문 분야</div>
                        <div>
                            <input type="checkbox" name="" id="design">
                            <label for="design" class="checkbox">디자인</label>
                            <input type="checkbox" name="" id="it">
                            <label for="it" class="checkbox">IT.프로그래밍</label>
                            <input type="checkbox" name="" id="video">
                            <label for="video" class="checkbox">영상</label>
                            <input type="checkbox" name="" id="photo">
                            <label for="photo" class="checkbox">사진</label>
                            <input type="checkbox" name="" id="sound">
                            <label for="sound" class="checkbox">음향</label>
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">기간</div>
                        <div>
                            <input type="text" name="" id="" class="number"> 년
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">경력 사항</div>
                        <div></div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">자격증</div>
                        <div></div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">연락 가능 시간</div>
                        <div>
                            <input type="text" name="" id="" class="number"> 시 ~ <input type="text" name="" id="" class="number"> 시
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">수익금 출금 은행</div>
                        <div>
                            <select name="" id="bankName">
                                <option value="">전체</option>
                                <option value="">신한</option>
                                <option value="">국민</option>
                                <option value="">우리</option>
                                <option value="">기업</option>
                            </select>
                            <input type="text" name="" id="account">
                        </div>
                    </div>
                    <div class="itemTitle">
                        <div class="item">자기소개</div>
                        <div>
                            <textarea name="" id="" cols="72" rows="10"></textarea>
                        </div>
                    </div>
                    <div id="btnArea">
                        <button id="updateBtn">수정</button>
                    </div>
                </div>
            </form>
        </section>
    </div>
</body>
</html>