<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
            
            
            <form action="/member/myInfo/updateMyInfo" enctype="multipart/form-data" method="POST" name="myPage-frm"  onsubmit="return profileValidate();">
                <div>
                    <div id="content">
                        <div class="profile-image-area">
                           <c:if test="${empty loginMember.memberProfile}">
		                        <img id="profile-image" src="/resources/images/루피.jpg">
		                    </c:if>
		                    <c:if test="${not empty loginMember.memberProfile}">
		                        <img id="profile-image" src="${loginMember.memberProfile}">
		                    </c:if>
                        </div>
                            <span id="delete-image">&times;</span>
                        <div class="profile-btn-area">
                            <label for="image-input">프로필 변경</label>
                            <!-- accept 속성 : 업로드 가능한 파일의 타입을 제한하는 속성 -->
                            <input type="file" name="profileImage" id="image-input" accept="image/*">
                        </div>
         
                    </div>
                </div>
                <div id="inputArea">
                	<div>
                        <div class="item">이메일</div>
                        <div>
                            <input type="text" name="" id="" class="input"  value="${loginMember.memberEmail}" readonly>
                        </div>
                    </div>
                    <div>
                        <div class="item">닉네임</div>
                        <div>
                            <input type="text" name="memberNickname" id="memberNickname" class="input" value="${loginMember.memberNickname}"><br>
                        	 <span class="signUp-message" id="nickMessage">한글, 영어, 숫자로만 2~10글자</span>
                        </div>
                    </div>
                    <div>
                        <div class="item">휴대폰</div>
                        <div>
                            <input type="text" name="memberTel" id="memberTel" class="input" value="${loginMember.memberTel}"><br>
                        	<span class="signUp-message" id="telMessage">전화번호를 입력해주세요(- 제외)</span>
                        </div>
                    </div>
                    <div>
                        <div class="item">직업</div>
                        <div>
                            <input type="text" name="memberJob" id="" class="input"  value="${loginMember.memberJob}" required>
                            
                        </div>
                    </div>
                    <div>
                        <div class="item">관심사 선택</div>
                        
                        
                        <div id="checkbox"> 
                        	<c:forEach var="interest" items="${fn:split(loginMember.memberInterest,',') }" >
				            	<c:choose>
									<c:when test="${interest == 1}">
										<c:set var="interest1" value="checked" />
									</c:when>
									<c:when test="${interest == 2}">
										<c:set var="interest2" value="checked" />
									</c:when>
									<c:when test="${interest == 3}">
										<c:set var="interest3" value="checked" />
									</c:when>
									<c:when test="${interest == 4}">
										<c:set var="interest4" value="checked" />
									</c:when>
									<c:when test="${interest == 5}">
										<c:set var="interest5" value="checked" />
									</c:when>
								</c:choose>
				            </c:forEach>
				            
                            <input type="checkbox" name="memberInterest" id="design" value="1" ${interest1}>
                            <label for="design" class="checkbox">
                                <span></span>디자인
                            </label>
                            <input type="checkbox" name="memberInterest" id="it" value="2" ${interest2}>
                            <label for="it" class="checkbox">
                                <span></span>IT.프로그래밍
                            </label> <br>
                            <input type="checkbox" name="memberInterest" id="video" value="3" ${interest3}>
                            <label for="video" class="checkbox">
                                <span></span>영상
                            </label>
                            <input type="checkbox" name="memberInterest" id="photo" value="4" ${interest4}>
                            <label for="photo" class="checkbox">
                                <span></span>사진
                            </label>
                            <input type="checkbox" name="memberInterest" id="sound" value="5" ${interest5}>
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
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
    
    <script src="/resources/js/member/myInfo.js"></script>
    
</body>
</html>