<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>전문가 등록</title>

    <link rel="stylesheet" href="/resources/css/freelancer/registerExpert.css">

  
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>


    <div class="main">

        <form action="" id="registerFrm">
            <span id="title">전문가 등록</span>
            <div>
                <div class="item">지역</div>
                <div>
                    <select name="" id="area" class="select">
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
            <div>
                <div class="item">전문 분야</div>
                <div>
                    <input type="checkbox" name="" id="design">
                    <label for="design" class="checkbox">
                        <span></span>디자인
                    </label>
                    <input type="checkbox" name="" id="it">
                    <label for="it" class="checkbox">
                        <span></span>IT.프로그래밍
                    </label>
                    <input type="checkbox" name="" id="video">
                    <label for="video" class="checkbox">
                        <span></span>영상
                    </label>
                    <input type="checkbox" name="" id="photo">
                    <label for="photo" class="checkbox">
                        <span></span>사진
                    </label>
                    <input type="checkbox" name="" id="sound">
                    <label for="sound" class="checkbox">
                        <span></span>음향
                    </label>
                </div>
            </div>
            <div>
                <div class="item">기간</div>
                <div>
                    <input type="text" name="" id="" class="number"> 년
                </div>
            </div>
            <div>
                <div class="item">학력/전공</div>
                <div>
                	<input type="text" name="" id="" class="modal">
                </div>
            </div>
            <div>
                <div class="item">경력 사항</div>
                <div>
                	<input type="text" name="" id="" class="modal">
                </div>
            </div>
            <div>
                <div class="item">자격증</div>
                <div>
                	<input type="text" name="" id="" class="modal">
                </div>
            </div>
            <div>
                <div class="item">연락 가능 시간</div>
                <div>
                    <input type="text" name="" id="" class="number"> 시 ~ <input type="text" name="" id="" class="number"> 시
                </div>
            </div>
            <div>
                <div class="item">수익금 입금 계좌</div>
                <div>
                    <select name="" id="bankName" class="select">
                        <option value="">전체</option>
                        <option value="">신한</option>
                        <option value="">국민</option>
                        <option value="">우리</option>
                        <option value="">기업</option>
                    </select>
                    <input type="text" name="" id="account">
                </div>
            </div>
            <div>
                <div class="item">자기소개</div>
                <div>
                    <textarea name="" id="" cols="66" rows="10"></textarea>
                </div>
            </div>
            
            <div id="btnArea">
                <button id="signUpBtn">가입</button>
            </div>


        </form>

    </div>

</body>
</html>