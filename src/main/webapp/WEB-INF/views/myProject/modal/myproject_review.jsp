<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

    <link rel="stylesheet" href="/resources/css/myProject/modal/myproject_review.css">

    

    <div class="modal_body">
      <span class="modal_close">x</span>
      <div class="myprojectReview">
        <form action ="" class="myprojectReviewfrm" method="get" name="myprojectReviewfrm" id="myprojectReviewfrm">
          <div class="title"><span>리뷰하기</span></div>
          <div class="myprojectReview_list">
            <div class="list_title"><span>제목</span></div>
            <div class="list_content"><input type="text" class="reviewBox"></div>
          </div>
          <div class="myprojectReview_list">
            <div class="list_title"><span>의뢰사항</span></div>
            <div class="list_content"><textarea class="myprojectReviewTotalContent reviewBox"></textarea></div>
          </div>
          <div class="myprojectReview_list">
            <div class="list_title"><span>평점</span></div>
            <div class="list_content">
              <select  id = "scoreOption" class="scoreOption reviewBox" name="scoreOption" >
                <option value="1" selected="">1점</option><!-- 나중에 for문 돌리자 -->
                <c:forEach var="i" begin="2" end="10" step="1">
                  <option value="${i}">${i}점</option>
                </c:forEach>
              </select>
            </div>
          </div>
          <div class="myprojectReview_list">
            <div class="list_title"><span>첨부파일</span></div>
            <div class="list_content"><input type = "file" ></div>
          </div>
          <div class="btnDiv"><button>등록</button></div>
        </form>
    </div>
  </div>
