<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


    <link rel="stylesheet" href="/resources/css/freelancer/portfolio.css">
<div class="modal_body">
    <span class="modal_close1">x</span>
    <form action="/member/freelancer/modal/addPortfolio" method="POST" enctype="multipart/form-data">

        <div id="content">포트폴리오 추가</div>
        <div class="itemArea">
            <div id="item">제목</div> 
            <div>
                <input type="text" name="portfolioTitle" id="portfolioTitle" required>
            </div>
        </div>
        <div class="itemArea">
            <div id="item">상세 설명</div> 
            <div>
                <textarea name="portfolioContent" id="portfolioContent" cols="50" rows="10" required></textarea>
            </div>
        </div>
        <div class="itemArea">
            <div id="item">썸네일파일</div> 
            <div>
                <label for="image-input1" >파일 선택</label>
                <input type="file" name="portfolioFile" id="image-input1" accept="image/*" required>
                <%-- <input type="file" required> --%>
                <span id="fileName1">선택된 파일없음</span>
                
            </div>
        </div>
        <div class="itemArea">
            <div id="item">첨부파일</div> 
            <div>
                <label for="image-input2">파일 선택</label>
                <input type="file" name="portfolioFile" id="image-input2" accept="image/*" required>
                <span id="fileName2">선택된 파일없음</span>
            
            </div>
        </div>
        <div>
            <button>등록</button>
        </div>
    </form>
        <script src="/resources/js/member/freelancer/addPortfolio.js"></script>

</div>
