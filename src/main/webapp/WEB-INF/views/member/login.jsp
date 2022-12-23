<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
        <form action="/member/login" method="POST">

       <img src="/resources/images/final_logo_color.png" id="signInLogo">

       <input type="text" placeholder="이메일" name="memberEmail" required value="${cookie.saveId.value}"><br>
       <input type="password" placeholder="비밀번호" name="memberPw" required><br>
       
       <%-- 쿠키에 saveId가 있는 경우 변수 생성 --%>
      <c:if test="${!empty cookie.saveId.value}">
          <c:set var="temp" value="checked"/>
      </c:if>

       <%-- <input type="checkbox" id="saveId" name="saveId" ${temp}><label for="saveId"></label><span class="saveIdText">아이디 저장</span>  --%>
       
       <input type="checkbox" name="saveId" id="saveId" value="5" ${temp}>
       <label for="saveId" class="checkbox">
           <span></span> <span class="checkboxText">아이디 저장</span>
       </label>
       
       
       <a href="">아이디/비밀번호 찾기</a><br>
       
       <button id="signInBtn">로그인</button>

        </form>
       <a id="signUpBtn" href="/member/signUp">회원가입</a>


    </div>
    
     <c:if test="${not empty message}">
        <script>
        alert("${message}");
        </script>

        <%-- message 1회 출력 후 삭제 --%>
        <c:remove var="message"/>
     </c:if>
    
</body>
</html>