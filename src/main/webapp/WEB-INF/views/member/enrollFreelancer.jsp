<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프리랜서 등록</title>

    <link rel="stylesheet" href="/resources/css/freelancer/registerExpert.css">


</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>


    <div class="main">

        <form method ="post" action="/member/freelancer/enrollFreelancerSignUp" id="registerFrm">
            <span id="title">프리랜서 등록</span>
            
            <span style="color:red;">*</span> 항목은 필수 항목입니다.
            <div>
                <div class="item"><span style="color:red;">*</span>지역</div>
                <div>
                    <select name="regionNo" id="area" class="select">
                        <option value="0">전체</option>
                        <option value="1">서울</option>
                        <option value="2">경기</option>
                        <option value="3">부산</option>
                        <option value="4">대구</option>
                        <option value="5">인천</option>
                        <option value="6">광주</option>
                        <option value="7">대전</option>
                        <option value="8">울산</option>
                        <option value="9">강원</option>
                        <option value="10">충북</option>
                        <option value="11">충남</option>
                        <option value="12">전북</option>
                        <option value="13">전남</option>
                        <option value="14">경북</option>
                        <option value="15">경남</option>
                        <option value="16">제주</option>
                        <option value="17">해외</option>
                    </select>
                </div>
            </div>
            <div>
                <div class="item"><span style="color:red;">*</span>전문 분야</div>
                <div>
                    <input type="checkbox" name="freelancerField" id="design" value="1">
                    <label for="design" class="checkbox">
                        <span></span>디자인
                    </label>
                    <input type="checkbox" name="freelancerField" id="it" value="2">
                    <label for="it" class="checkbox">
                        <span></span>IT.프로그래밍
                    </label>
                    <input type="checkbox" name="freelancerField" id="video" value="3">
                    <label for="video" class="checkbox">
                        <span></span>영상
                    </label>
                    <input type="checkbox" name="freelancerField" id="photo" value="4">
                    <label for="photo" class="checkbox">
                        <span></span>사진
                    </label>
                    <input type="checkbox" name="freelancerField" id="sound" value="5">
                    <label for="sound" class="checkbox">
                        <span></span>음향
                    </label>
                </div>
            </div>
            <div>
                <div class="item"><span style="color:red;">*</span>기간</div>
                <div>
               		<select  name="freelancerCont" id="freelancerCont" class="number">
                		<c:forEach var="cont" begin="0" end="60">
                			<option value="${cont }">${cont }</option>
                		</c:forEach>
                	</select>년
                    <!-- <input type="text" name="freelancerCont" id="freelancerCont" class="number"> 년 -->
                </div>
            </div>
            <div>
                <div class="item additional">학력/전공 &nbsp;<span id="majorPopup" class="modal" >+</span></div> 
                <div>
                   <!--  <input type="text" id="majorPopup" class="modal" autocomplete="off" readonly size="1" placeholder="+"> -->
                </div>
            </div>
            <div>
                <div class="item additional">경력 사항 &nbsp;<span id="careerPopup" class="modal" >+</span></div>
                <div>
                   <!--  <input type="text" id="careerPopup" class="modal" autocomplete="off" readonly> -->
                </div>
            </div>
            <div>
                <div class="item additional">자격증 &nbsp;<span id="licensePopup" class="modal" >+</span></div>
                <div>
                   <!--  <input type="text" id="licensePopup" class="modal" autocomplete="off" readonly> -->
                </div>
            </div>
            <div>
                <div class="item"><span style="color:red;">*</span>연락 가능 시간</div>
                <div>
                	<select name="contactTime1" id="contactTime1" class="number">
                		<c:forEach var="hour1" begin="0" end="24">
                			<option value="${hour1 }">${hour1 }</option>
                		</c:forEach>
                	</select>시 ~
                	<select name="contactTime2" id="contactTime2" class="number">
                		<c:forEach var="hour2" begin="0" end="24">
                			<option value="${hour2 }">${hour2 }</option>
                		</c:forEach>
                	</select>시
                    <!-- <input type="text" name="contactTime1" id="contactTime1" class="number"> 시 ~
                    <input type="text" name="contactTime2" id="contactTime2" class="number"> 시 -->
                </div>
            </div>
            <div>
                <div class="item"><span style="color:red;">*</span>수익금 입금 계좌</div>
                <div>
                    <select name="bankCode" id="bankCode" class="select">
                        <option value="0">전체</option>
                        <option value="1">신한</option>
                        <option value="2">국민</option>
                        <option value="3">우리</option>
                        <option value="4">기업</option>
                    </select>

                    <input type="text" name="bankAccountNumber" id="bankAccountNumber" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">

                </div>
            </div>
            <div>
                <div class="item"><span style="color:red;">*</span>자기 소개</div>
                <div> 
                    <textarea name="freelancerIntro" id="freelancerIntro" cols="66" rows="10" required></textarea>
                </div>
            </div>
            
            <div id="btnArea">
                <button id="signUpBtn">등록</button>
            </div>


        </form>

            <div class="modal_major">
                    <jsp:include page="/WEB-INF/views/member/freelancer/modal/major.jsp" /> 
            </div>
            <div class="modal_license">
                    <jsp:include page="/WEB-INF/views/member/freelancer/modal/license.jsp" /> 
            </div>
            <div class="modal_career">
                    <jsp:include page="/WEB-INF/views/member/freelancer/modal/career.jsp" /> 
            </div>

    

    </div>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

    <script src="/resources/js/member/freelancer/enrollFreelancerPopup.js"></script> 

</body>
</html>