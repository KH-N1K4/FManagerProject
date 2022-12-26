<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 탈퇴</title>

    <link rel="stylesheet" href="/resources/css/member/updatePw.css">


</head>
<body>

<jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
    

    <div class="main">

        <jsp:include page="/WEB-INF/views/member/memberSide.jsp"/>

       <section>
            <div id="title">비밀번호 변경</div>
            <form action="/member/changePw" method="POST" name="myPage-frm" id="changePwForm">
                <div id="inputArea">
                    <div>
                        <div class="item">비밀번호</div>
                        <div>
                            <input type="password" name="currentPw" id="currentPw" class="input">
                        </div>
                    </div>
                    <div>
                        <div class="item">새 비밀번호</div>
                        <div>
                            <input type="password" name="newPw" id="newPw" class="input">
                        </div>
                    </div>
                    <div>
                        <div class="item">새 비밀번호 확인</div>
                        <div>
                            <input type="password" name="newPwConfirm" id="newPwConfirm" class="input">
                        </div>
                    </div>
                    <span class="signUp-message" id="pwMessage">영어, 숫자, 특수문자(!,@,#,-,_) 6~20글자 사이로 입력해주세요.</span>
                    
                    <div>
                        <button>변경</button>
                    </div>
                </div>
            </form>
        
        </section>

        
    </div>
    
    
     <script src="/resources/js/member/changePw.js"></script>
    
     <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
</body>
</html>