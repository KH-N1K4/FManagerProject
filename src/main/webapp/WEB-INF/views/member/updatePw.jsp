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
            <form action="#" name="myPage-frm">
                <div id="inputArea">
                    <div>
                        <div class="item">비밀번호</div>
                        <div>
                            <input type="text" name="" id="" class="input">
                        </div>
                    </div>
                    <div>
                        <div class="item">새 비밀번호</div>
                        <div>
                            <input type="text" name="" id="" class="input">
                        </div>
                    </div>
                    <div>
                        <div class="item">비밀번호 변경</div>
                        <div>
                            <input type="text" name="" id="" class="input">
                        </div>
                    </div>
                    
                    <div>
                        <button>변경</button>
                    </div>
                </div>
            </form>
        
        </section>

        
    </div>
    
</body>
</html>