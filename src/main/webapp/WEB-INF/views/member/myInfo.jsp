<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 정보</title>

    <link rel="stylesheet" href="/resources/css/member/myInfo.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
    

    <div class="main">

        <jsp:include page="/WEB-INF/views/member/memberSide.jsp"/>

        <section>
            <div id="title">프로필</div>
            <form action="#" name="myPage-frm">
                <div>
                    <div id="content">
                        <div class="profile-image-area">
                            <img id="profile-image" src="" alt="">
                            <span id="delete-image">&times;</span>
                        </div>
                        <div class="profile-btn-area">
                            <label for="image-input">프로필 변경</label>
                            <!-- accept 속성 : 업로드 가능한 파일의 타입을 제한하는 속성 -->
                            <input type="file" name="profile-image" id="image-input" accept="image/*">

                        </div>
                    </div>
                </div>
                <div id="inputArea">
                    <div>
                        <div class="item">닉네임</div>
                        <div>
                            <input type="text" name="" id="" class="input">
                        </div>
                    </div>
                    <div>
                        <div class="item">이메일</div>
                        <div>
                            <input type="text" name="" id="" class="input">
                        </div>
                    </div>
                    <div>
                        <div class="item">휴대폰</div>
                        <div>
                            <input type="text" name="" id="" class="input">
                        </div>
                    </div>
                    <div>
                        <div class="item">직업</div>
                        <div>
                            <input type="text" name="" id="" class="input">
                        </div>
                    </div>
                    <div>
                        <div class="item">관심사 선택</div>
                        <div id="checkbox">
                            <input type="checkbox" name="" id="design">
                            <label for="design" class="checkbox">
                                <span></span>디자인
                            </label>
                            <input type="checkbox" name="" id="it">
                            <label for="it" class="checkbox">
                                <span></span>IT.프로그래밍
                            </label> <br>
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
                        <button>수정</button>
                        <button type="reset">취소</button>
                    </div>
                </div>
            </form>
        
        </section>

        
    </div>
</body>
</html>