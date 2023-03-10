<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

    <link rel="stylesheet" href="/resources/css/myProject/modal/myproject_review.css">

    

    <div class="reviewModal_body">
      <span class="reviewModal_close">x</span>
      <div class="myprojectReview">
        <form action ="/member/myProject/review" class="myprojectReviewfrm" method="POST" id="reviewfrm" enctype="multipart/form-data">
          <div class="title"><span>리뷰하기</span></div>
          <div class="myprojectReview_list">
            <div class="list_title"><span>서비스명</span></div>
            <div class="list_content"><input type="text" class="reviewBox" id="serviceTitle3"></div>
          </div>
          <input id="tradeNo3" type="hidden" name="tradeNo" readonly>
          <div class="myprojectReview_list">
            <div class="list_title"><span>내용</span></div>
            <div class="list_content"><textarea name="reviewContent" class="myprojectReviewTotalContent reviewBox" id="reviewContent" required></textarea></div>
          </div>
          <div class="myprojectReview_list">
            <div class="list_title"><span>평점</span></div>
            <div class="list_content">
              <select  id = "reviewPoint" class="scoreOption reviewBox" name="reviewPoint" >
                <option value="1" selected="">1점</option><!-- 나중에 for문 돌리자 -->
                <c:forEach var="i" begin="2" end="5" step="1">
                  <option value="${i}">${i}점</option>
                </c:forEach>
              </select>
            </div>
          </div>
          <div class="myprojectReview_list">
            <div class="list_title"><span>첨부파일</span></div>
            <div class="list_content"><input type = "file" name="reviewFilePath" id="reviewFilePath" accept="image/*" ></div>
          </div>
          <div class="btnDiv"><button>등록</button></div>
        </form>
    </div>
  </div>
