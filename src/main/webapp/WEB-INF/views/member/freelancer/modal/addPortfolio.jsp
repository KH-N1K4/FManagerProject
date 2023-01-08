<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


    <link rel="stylesheet" href="/resources/css/freelancer/portfolio.css">
<div class="modal_body">
    <span class="modal_close1" style="position: absolute; right: 50px;
    width : 20px;
    background-color: #538126;
    border: 3px solid #538126;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    cursor: pointer;
    text-align: center;">
    x
    </span>
    <form action="/member/freelancer/modal/addPortfolio" method="POST" enctype="multipart/form-data">

        <div id="content">포트폴리오 추가</div>
        <div class="itemArea">
            <div id="item">제목</div> 
            <div>
                <input style="width: 465px; border : 1px solid rgba(130, 130, 130); font-size: initial; border-radius: 20;" type="text" name="portfolioTitle" id="portfolioTitle" required>
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
                <label for="image-input1" class="fileSelect">파일 선택</label>
                <input type="file" name="portfolioFile" id="image-input1" accept="image/*" required>
                <%-- <input type="file" required> --%>
                <span id="fileName1">선택된 파일없음</span>
                
            </div>
        </div>
        <div class="itemArea">
            <div id="item">첨부파일</div> 
            <div>
                <label for="image-input2" class="fileSelect">파일 선택</label>
                <input type="file" name="portfolioFile" id="image-input2" accept="image/*" required>
                <span id="fileName2">선택된 파일없음</span>
            
            </div>
        </div>
        <div>
            <button id="addButton">등록</button>
        </div>
    </form>
        <script src="/resources/js/member/freelancer/addPortfolio.js"></script>

</div>
