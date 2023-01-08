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

         <form action="#" method="post" name="signUp-frm" id="signUp-frm">
            <span id="textSignUp">회원가입</span>
            
            <input type="text" placeholder="이메일" class="exception" name="memberEmail" id="memberEmail"><button id="sendAuthKeyBtn">인증</button><br>
            <span class="signUp-message" id="emailMessage">메일을 받을 수 있는 이메일을 입력해주세요.</span>
            <input type="text" placeholder="인증번호 입력" class="exception" name="authKey" id="authKey"><button id="checkAuthKeyBtn">확인</button><br>
            <span class="signUp-message" id="authKeyMessage"></span>
            
            <input type="password" placeholder="비밀번호" name="memberPw" id="memberPw"><br>
            <input type="password" placeholder="비밀번호 확인" name="memberPwConfirm" id="memberPwConfirm"><br>
            <span class="signUp-message" id="pwMessage">영어, 숫자, 특수문자(!,@,#,-,_) 6~20글자 사이로 입력해주세요.</span>
            
            <input type="text" placeholder="(- 없이 숫자만 입력)" name="memberTel" id="memberTel" maxlength="11" value="${tempMember.memberTel}"  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"><br>
            <span class="signUp-message" id="telMessage">전화번호를 입력해주세요(- 제외)</span>
            

            <input type="text" placeholder="닉네임" name="memberNickname" id="memberNickname"><br>
            <span class="signUp-message" id="nickMessage">한글, 영어, 숫자로만 2~10글자</span>
            <input type="text" placeholder="이름" name="memberName" id="memberName" required><br>
            <input type="text" placeholder="직업" name="memberJob" id="memberJob" required><br>
            <!-- <select name="" id="job">
                <option value="">무직</option>
            </select> -->
  
            
           <div id="signUpInterest"> <span id="textSignUpInterest">관심분야</span><br>
                    <input type="checkbox" name="memberInterest" id="design" value="1">
                    <label for="design" class="checkbox">
                        <span></span> <span class="checkboxText">디자인</span>
                    </label>
                    <input type="checkbox" name="memberInterest" id="it" value="2">
                    <label for="it" class="checkbox">
                        <span></span> <span class="checkboxText">IT.프로그래밍</span>
                    </label>
                    <input type="checkbox" name="memberInterest" id="video" value="3">
                    <label for="video" class="checkbox">
                        <span></span> <span class="checkboxText">영상</span>
                    </label><br>
                    <input type="checkbox" name="memberInterest" id="photo" value="4">
                    <label for="photo" class="checkbox">
                        <span></span> <span class="checkboxText">사진</span>
                    </label>
                    <input type="checkbox" name="memberInterest" id="sound" value="5">
                    <label for="sound" class="checkbox">
                        <span></span> <span class="checkboxText">음향</span>
                    </label>
                </div>
           <!--  <input type="checkbox" name="signUpagree" id="agree"><label for="agree"></label><span class="agreeText">개인정보 제공 동의</span> -->

			<input type="checkbox" name="signUpCheck" id="signUpCheck" value="5">
			<label for="signUpCheck" class="checkbox">
                        <span></span> <span class="checkboxText">개인정보 제공 동의</span>
                    </label>
                    

            <button id="signUpBtn">가입</button>


        </form>

    </div>
    
    
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

    <script src="/resources/js/member/signUp.js"></script>
   
</body>
</html>