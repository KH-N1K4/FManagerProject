<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    
      <link rel="stylesheet" href="/resources/css/member/signIn.css">
</head>
<body>

<jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>


<div id="signInMain">
        <form action="">

       <img src="/resources/images/final_logo_color.png" id="signInLogo">

       <input type="text" placeholder="이메일" name="emailInput"><br>
       <input type="password" placeholder="비밀번호" name="pwInput"><br>

       <input type="checkbox" id="saveId"><label for="saveId"></label><span class="saveIdText">아이디 저장</span> 
       <a href="">아이디/비밀번호 찾기</a><br>
       
       <button id="signInBtn">로그인</button>

        </form>
       <button id="signUpBtn">회원가입</button>


    </div>
    
</body>
</html>