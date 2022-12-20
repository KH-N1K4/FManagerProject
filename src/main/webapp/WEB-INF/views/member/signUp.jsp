<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>

    <link rel="stylesheet" href="/resources/css/member/signUp.css">

</head>
<body>

<jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>

        <div class="signUp">

        <form action="">
            <span id="textSignUp">회원가입</span>
            
            <input type="text" placeholder="이메일" class="exception"><button id="emailCheck">인증</button><br>
            <input type="text" placeholder="비밀번호"><br>
            <input type="text" placeholder="비밀번호 확인"><br>
            <select name="" id="bank">
                <option value="">농협</option>
                <option value="">신한</option>
                <option value="">우리</option>
            </select>
            <input type="text" placeholder="계좌번호" class="exception"><br>
            <input type="text" placeholder="휴대폰번호"><br>
            <input type="text" placeholder="닉네임"><br>
            <input type="text" placeholder="이름"><br>
            <select name="" id="job">
                <option value="">무직</option>
            </select>

            
            <div id="signUpInterest"> <span id="textSignUpInterest">관심분야</span><br>
                <div>
                    <input type="checkbox" name="design" id="design" class="checkbox"><label for="design"></label><span>디자인</span> 
                    <input type="checkbox" name="programming" id="programming" class="checkbox"><label for="programming"></label><span>IT 프로그래밍</span><br>
                </div>
                <div>
                    <input type="checkbox" name="video" id="video" class="checkbox"><label for="video"></label><span>영상</span>
                    <input type="checkbox" name="photo" id="photo" class="checkbox"><label for="photo"></label><span>사진</span>
                    <input type="checkbox" name="sound" id="sound" class="checkbox"><label for="sound"></label><span>음향</span>

                </div>
            </div>

            <input type="checkbox" name="agree" id="agree"><label for="agree"></label><span class="agreeText">개인정보 제공 동의</span>

            <button id="signUpBtn">가입</button>


        </form>

    </div>
   
</body>
</html>