<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메세지</title>
    
    
    <link rel="stylesheet" href="/resources/css/common/message.css">
    
    
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header_ver1.jsp"/>
        

  <section class="content">
    <div class="mainArea">
        <!-- 메인 콘텐츠 영역 -->
        <div class="list"><!-- 스크롤 추가 --> 
            <ul class="chatting-list">
                <c:forEach var="room" items="${roomList}">
                        <%--  id == 채팅방 번호 --%>
                            <li class="chatting-item chattingList" id="${room.chatRoomNo}-${room.clientNo}">
                                    <div class="item-header">
                                        <div class="">
                                            <c:if test="${not empty room.clientProfile}">
                                                <img class="list-profile" src="${room.clientProfile}">
                                            </c:if>
                                            <c:if test="${empty room.clientProfile}">
                                                <img class="list-profile" src="/resources/images/프로필.PNG">
                                            </c:if>
                                        </div>
                                        <div id="info">
                                                <span class="target-name">${room.clientNickName}</span><br>
                                                <span class="recent-send-time">${room.sendTime}</span>
                                        </div>
                                    </div>
                                    <div class="item-body">
                                        <div class="item-content">
                                            <p class="recent-message">${room.lastMessage}</p>
                                            <c:if test="${room.notReadCount > 0}">
                                                <p class="not-read-count">${room.notReadCount}</p>
                                            </c:if>
                                        </div>
                                        <input type="hidden" id="${room.clientGrade}">
                                        <input type="hidden" id="${room.clientFreeContactTime}">
                                    </div>
                            </li>
                </c:forEach>
            </ul>
        </div>    
        <!-- <div class="chat chatting-content">  -->
        <div class="chatting-content"> 
            <!-- 채팅창 -->
            <div id="chatBox" class=""><!-- 스크롤 추가 -->
                <ul class="display-chatting">
					<%-- <li class="my-chat">
						<span class="chatDate">14:01</span>
						<p class="chat">가나다라마바사</p>
					</li>
					<li class="target-chat">
						<img src="/resources/images/user.png">
						<div>
							<b>이번유저</b>	<br>
                            <div>
                                <p class="chat">
                                    안녕하세요?? 반갑습니다.<br>
                                    ㅎㅎㅎㅎㅎ
                                </p>
                                <span class="chatDate">14:05</span>
                            </div>
						</div>
					</li> --%>
				</ul>
            </div>
            <div id="messageInput">
                <textarea id="inputChatting" rows="3" placeholder="메세지를 입력해주세요."></textarea>
                <div id="insert">
                	<button id="send">전송</button>
                	 <div id="addFile">
	                    <label for="img0" class="preview">
	                        첨부파일 전송
	                    </label>
	                    <input type="file" id="img0" name="img0">
                	</div>
                </div>
            </div>
            <!-- 메세지 입력창 -->
           <!--  <div id="messageButton">
                <div id="addFile">
                    <label for="img0" class="preview">
                        첨부파일 전송
                    </label>
                    <input type="file" id="img0" name="img0">
                </div>
            </div> -->
        </div>    
        <!-- 오른쪽 전문가 프로필 -->
        <div class="expert">
            <div><img src=""></div>
            <div><h3><%--전문가 닉네임--%></h3></div>
            <div>
                <span><%--연락 가능 시간--%></span> <a><%--14:00-18:00--%></a><br>
                <span><%--회원 등급--%></span>      <a><%--Master--%></a><br>
            </div>
            <div class="outbtn"><button id="outbtnID">채팅방 나가기</button></div>
            <input type="hidden" id="">
        </div>    
    </div>
  </section> 

	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
	<!-- https://github.com/sockjs/sockjs-client -->
	<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
	<script>
		// 로그인한 회원 번호
		const loginMemberNo = "${loginMember.memberNo}";
		// 게시판에서 사용자 닉네임을 눌러서 채팅 화면으로 넘어온 경우
		// 그 때 전달된 채팅방 번호를 저장하는 변수
		const tempNo = "${chatRoomNo}"; 
	</script>
    <script src="/resources/js/common/message.js"></script>
</body>
</html>