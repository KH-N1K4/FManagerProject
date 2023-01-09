<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <link rel="stylesheet" href="/resources/css/common/footer.css">


<div id="footer">
        <div id="footer-in">

            <div id="footer-left">
                <a>이용약관</a>
                <a>개인정보처리방침</a>
                <a">사업자 정보 확인</a>
                <br><br>
                <div>
                    (주)은 통신판매중개자로서 통신판매의 당사자가 아니며 개별 판매자가 제공하는 서비스에 대한 이행, 계약사항 등과 관련한 의무와 책임은 거래당사자에게 있습니다. <br>
                    상호명:(주)브레이브모바일 · 대표이사:KIM ROBIN H · 개인정보책임관리자:김태우 · 주소:서울특별시 강남구 테헤란로 415, L7 강남타워 5층
                    사업자등록번호:120-88-22325 · 통신판매업신고증:제 2021-서울강남-00551 호 · 직업정보제공사업 신고번호:서울청 제 2019-21호 <br>
                    고객센터:1599-5319 · 이메일:support@soomgo.com
                    Copyright ©Brave Mobile Inc. All Rights Reserved.

                </div>


            </div>
            <div id="footer-right">

                <span>02-0000-0000</span>    
                <br>
                평일 10:00 - 18:00
                <br>
                점심시간 13:00 - 14:00



                <br><br><br>
                    <%-- <a href="/manager/memberList">문의하기</a> --%>
                    <%-- <br> --%>
                    <a href="/userInquiryList" id="customerCenter">고객센터</a>
            </div>

        </div>
    </div>
    
    
    <c:if test="${not empty message}">
        <script>
        alert("${message}");
        </script>

        <%-- message 1회 출력 후 모든 scope 삭제 --%>
        <c:remove var="message"/>
    </c:if>

    <c:if test="${empty loginMember}">
        <script>
            document.getElementById("customerCenter").addEventListener("click",()=>{
                    alert("로그인 후 이용해주세요.");
            });
        </script>
    </c:if>