<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리</title>
    
     <link rel="stylesheet" href="/resources/css/category/projectRequest.css">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header_ver1.jsp"/>

      <section class="content">
        <div class="mainArea">
            <!-- 사이드 메뉴 -->
            <div class="sideMenu">
                <div id="design">IT·프로그래밍</div>
                <div id="subCategori"><a href="">UX기획</a><button>▼</button></div>
                <div id="subCategori"><a href="">웹</a><button>▼</button></div>
                <div id="subCategori"><a href="">커머스</a><button>▼</button></div>
                <div id="subCategori"><a href="">모바일</a><button>▼</button></div>
            </div>

            <!-- 메인 콘텐츠 영역 -->
            <div class="mainContent">
                <form action="" id="inquirySubmit">
                    <span>예산</span>
                    <select name="" id="budget"> 
                        <option value="">예산</option>
                        <option value="">1만원 미만</option>
                        <option value="">1만원 - 5만원 이하</option>
                        <option value="">5만원 - 10만원 이하</option>
                        <option value="">10만원 - 20만원 이하</option>
                        <option value="">20만원 - 30만원 이하</option>
                        <option value="">30만원 - 50만원 이하</option>
                        <option value="">50만원 - 70만원 이하</option>
                        <option value="">70만원 - 100만원 이하</option>
                        <option value="">100만원 초과</option>
                    </select>

                    <span>전문가 등급</span>
                    <select name="" id="grade">
                        <option value="">전문가 등급</option>
                        <option value="">New</option>
                        <option value="">Master</option>
                    </select>

                    <select name="" id="">
                        <option value="">최신순</option>
                        <option value="">마감 임박순</option>
                    </select>
                </form>

                <div id="imageContent">
                
                <c:forEach var="i" begin="0" end="20" step="1">
                	<a href="/category/1/1">
	                    <div id="image">
	                        <div><img src="/정채연.jfif"></div>
	                        <!-- 하트버튼 추가 예정 -->
	                        <span>프로스튜디오</span><br>
	                        <span>개인 프로필 사진 촬영하기</span><br>
	                        <span>가격: 140,000원</span>
	                    </div>
                    </a>
                    
              </c:forEach>
                </div>    
            </div>

        </div>
    </section>



    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
</body>
</html>