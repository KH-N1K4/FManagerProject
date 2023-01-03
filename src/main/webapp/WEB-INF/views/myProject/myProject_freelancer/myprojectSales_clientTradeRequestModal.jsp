<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

    <link rel="stylesheet" href="/resources/css/myProject/myProject_freelancer/myprojectSales_clientTradeRequestModal.css">

    

    <div class="clientTradeRequestModal_body">
      <span class="clientTradeRequestModal_close">x</span>
      <div class="clientTradeRequestDiv">
          <div class="title"><span>요청사항</span></div>
          <div class="clientTradeRequestDiv_list">
            <div class="list_title"><span>서비스명</span></div>
            <div class="list_content"><input id="tradeRequestServiceTitle" type="text" class="tradeRequestBox readonly" name="tradeRequestServiceTitle" readonly></div>
          </div>
          <div class="clientTradeRequestDiv_list">
            <div class="list_title"><span>거래번호</span></div>
            <div class="list_content"><input id="tradeRequestTradeNo" type="text" class="tradeRequestBox readonly" name="tradeRequestTradeNo" readonly></div>
          </div>
          <div class="clientTradeRequestDiv_list">
            <div class="list_title"><span>의뢰인</span></div>
            <div class="list_content"><input id="tradeRequestMemberName" type="text" class="tradeRequestBox readonly" name="tradeRequestPersonNo" readonly></div>
          </div>
          <div class="clientTradeRequestDiv_list">
            <div class="list_title"><span>요청사항</span></div>
            <div class="list_content"><textarea id="tradeRequestContent" class="clientTradeRequestTotalContent tradeRequestBox" name="tradeRequestContent" readonly></textarea></div>
          </div>
      </div>
    </div>
