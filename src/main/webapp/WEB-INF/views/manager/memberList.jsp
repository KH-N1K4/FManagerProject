<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원관리</title>

    <link rel="stylesheet" href="/resources/css/manager/memberList.css">

</head>
<body>
    
    <jsp:include page="/WEB-INF/views/common/header_black_ver1.jsp"/>

    <div class="main">
        <div id="member-manage-title-area">
        
            <span id="member-manage-title">회원 관리 </span>
            <span class="search-area">
                <select class="member-select-input" name="" id="">
                    <option value="whole">전체</option>
                </select>
                <input type="text" class="member-text-input" name="member-search-input" id ="search-input">
            </span>
        </div>

        <div id="member-manage-table">
        
            <!-- 테이블 컬럼명 -->
            <div class="member-manage-table-column">
                <div class="member-num">회원번호</div>
                <div class="member-name">이름</div>
                <div class="member-division">구분</div>
                <div class="member-grade">등급</div>
                <div class="member-delete">탈퇴
                

                </div>
            </div>

            <!-- 테이블 내용 -->
            <div class="member-manage-table-content">
                <div class="member-num">1</div>
                <div class="member-name">홍길동</div>
                <div class="member-division">전문가</div>
                <div class="member-grade">레벨1</div>
                <div class="member-delete">
                    <span>탈퇴</span>
                </div>
                
            </div>
            <div class="member-manage-table-content">
                <div class="member-num">1</div>
                <div class="member-name">홍길동</div>
                <div class="member-division">전문가</div>
                <div class="member-grade">레벨1</div>
                <div class="member-delete">
                    <span>탈퇴</span>
                </div>
                
            </div>
        
            

        </div> <!-- buy-table -->

    </div> <!-- main -->
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>