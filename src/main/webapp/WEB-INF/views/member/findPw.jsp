<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 찾기</title>
    
      <link rel="stylesheet" href="/resources/css/member/findPw.css">
</head>
<body>

<jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>


<div id="signInMain">

       <%-- <img src="/resources/images/final_logo_color.png" id="signInLogo"> --%>

        <div class="titleArea">
            <div class="title">비밀번호 찾기</div>
            <div class="guide">
            가입 시 등록하신 이메일 주소, 이름, 전화번호를 입력해 주세요.<br> 
            새 비밀번호를 보내드립니다.</div>
        </div>
        

       <input type="text" placeholder="이메일" name="memberEmail" required}"><br>
       <input type="text" placeholder="이름" name="memberName" required><br>
       <input type="text" placeholder="전화번호 (- 제외)" name="memberTel" required><br>
       
       
       <div class="btnArea">
       <button id="signInBtn">새 비밀번호 전송</button><a class="goTo" href="/">돌아가기</a>
       </div>

       


    </div>
    
     <c:if test="${not empty message}">
        <script>
        alert("${message}");
        </script>

        <%-- message 1회 출력 후 삭제 --%>
        <c:remove var="message"/>
     </c:if>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
     <script src="/resources/js/member/findPw.js"></script>
    
</body>
</html>