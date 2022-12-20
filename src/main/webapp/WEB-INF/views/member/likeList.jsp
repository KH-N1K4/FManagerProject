<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>찜한 목록</title>

    <link rel="stylesheet" href="/resources/css/member/likeList.css">
</head>
<body>
   <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>

    <div class="main">

        <jsp:include page="/WEB-INF/views/member/memberSide.jsp"/>

        <section>
            <div id="title">
                찜한 목록
                <select id="listOption">
                    <option value="">전체</option>
                    <option value="">전체</option>
                    <option value="">전체</option>
                </select>
            </div>
            <div id="serviceArea">
                <div class="service">g</div>
                <div class="service">g</div>
                <div class="service">g</div>
                <div class="service">g</div>
                <div class="service">g</div>
            </div>
            </div>
            
        
        </section>

        
    </div>
</body>
</html>