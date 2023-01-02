<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>포트폴리오 추가</title>
    <link rel="stylesheet" href="/resources/css/freelancer/portfolio.css">
</head>
<body>
    <form action="/member/freelancer/modal/addPortfolio" method="POST">

        <div id="content">포트폴리오 추가</div>
        <div class="itemArea">
            <div id="item">제목</div> 
            <div>
                <input type="text" name="portfolioTitle" id="portfolioTitle">
            </div>
        </div>
        <div class="itemArea">
            <div id="item">상세 설명</div> 
            <div>
                <textarea name="portfolioContent" id="portfolioContent" cols="50" rows="10"></textarea>
            </div>
        </div>
        <div class="itemArea">
            <div id="item">첨부파일</div> 
            <div>
                <label for="image-input">파일 선택</label>
                <input type="file" name="portfolioContent" id="image-input" accept="image/*">
                <%-- <input type="text" name="portfolioFilePath"> --%> <%-- 테스트 --%>
            </div>
        </div>
        <div>
            <button>등록</button>
        </div>
    </form>
    
</body>
</html>

<c:if test="${not empty message}">
        <script>
         alert("${message}");
        </script>

        <%-- message 1회 출력 후 모든 scope 삭제 --%>
        <c:remove var="message"/>
</c:if>