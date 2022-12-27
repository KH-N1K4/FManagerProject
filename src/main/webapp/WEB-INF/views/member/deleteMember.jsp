<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 탈퇴</title>

    <link rel="stylesheet" href="/resources/css/member/deleteMember.css">

</head>
<body>

<jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
    

    <div class="main">

       <jsp:include page="/WEB-INF/views/member/memberSide.jsp"/>
       
       
        <section>
            <div id="title">회원 탈퇴</div>
            <form action="/member/myInfo/deleteMember" name="myPage-frm" method="POST" id="memberDeleteForm">
                <div id="inputArea">
                    <div>
                        <div class="item">이메일</div>
                        <div>
                            <input type="text" name="memberEmail" id="memberEmail" class="input">
                        </div>
                    </div>
                    <div>
                        <div class="item">비밀번호</div>
                        <div>
                            <input type="text" name="memberPw" id="memberPw" class="input">
                        </div>
                    </div>
                    <div class="agree-content">
                        <ul>
                            <li> 현재 사용중인 계정 정보는 회원 탈퇴 후 복구가 불가합니다.</li>
                            <li> 진행 중인 거래건이 있거나 페널티 조치 중인 경우 탈퇴 신청이 불가합니다.</li>
                            <li> 탈퇴 후 회원님의 정보는 전자상거래 소비자보호법에 의거한 프매니저 개인정보처리방침에 따라 관리됩니다. </li>
                            <li> 구매후기 및 답글은 탈퇴 시 자동 삭제되지 않습니다. 탈퇴 후에는 계정 정보가 삭제되어 본인 확인이 불가하므로, 탈퇴 신청 전에 게시글 삭제를 요청해 주시기 바랍니다.</li>
                        </ul>
                    </div>
                    <div>
                        <input type="checkbox" id="agree"> <label for="agree">위 사실을 확인했습니다.</label>
                    </div>
                    <div>
                        <button>탈퇴</button>
                    </div>
                </div>
            </form>
        
        </section>

        
    </div>
    
    <script src="/resources/js/member/changePw.js"></script>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>