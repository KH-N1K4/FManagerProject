
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_user/suggestion_modal.css">

  <div class="suggestionModal_body">
          <section class="head">
            <div id="title">
              <h3>결제 중...</h3>
            </div >
            <div id="box">
              <button class="deleteBox">
              <span class="delete-image">&times;</span>
              </button>
            </div>
          </section>

          <section class="body">
              <div id="content">
                    <div id="content1">채택정보</div>
                    <div id="content2">
                        <div class="text">프로젝트명</div>
                        <div class="text">프리랜서명</div>
                        <div class="text">작업기간</div>
                        <div class="text">결제금액</div>
                    </div>
                    <div id="content3">
                        <div id="text1"></div>
                        <div id="text2"></div>
                        <div id="text3"></div>
                        <div id="text4"></div>
                        <div class="hidden" id="varProposalNo"></div>
                    </div>
              </div>
              <div id="title2">
                <div id="request">요구사항</div>
                <div id="requestBox">
                  <textarea name="tradeRequest" id="tradeRequest" cols="84" rows="4" placeholder="요구사항을 입력해주세요"></textarea>
                </div>
              </div>
              
          </section>

          <section class="foot">
              <button id="payButton" onclick="iamport()">구매</button>
          </section>
  </div>

