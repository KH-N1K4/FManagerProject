<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

    <link rel="stylesheet" href="/resources/css/myProject/modal/myproject_reportModal.css">

    

    <div class="reportModal_body">
      <span class="reportModal_close">x</span>
      <form action="/member/myProject/tradeReport" method="POST" id="tradeReportFrm"  enctype="multipart/form-data">
      <div class="myprojectReport">
          <div class="title">
          	<c:if test=""></c:if>
            <select  id = "selectType1" class="srchOption box" name="tradeReportTypeNo">
              <option value="0">선택</option>
              <option value="1">거래 신고</option>
              <option value="2">주문 취소</option>
            </select>
          </div>
          <div class="myprojectReport_list">
            <div class="list_title"><span>서비스명</span></div>
            <div class="list_content"><input id="serviceTitle" type="text" class="ReportBox readonly" name="serviceTitle" readonly></div>
          </div>
          <div class="myprojectReport_list">
            <div class="list_title"><span>거래번호</span></div>
            <div class="list_content"><input id="tradeNo" type="text" class="ReportBox readonly" name="tradeNo" readonly></div>
          </div>
          <input id="memberNo" type="hidden" class="ReportBox readonly" name="reportPersonNo" readonly>
          <div class="myprojectReport_list">
            <div class="list_title"><span>작성자</span></div>
            <div class="list_content"><input id="memberName" type="text" class="ReportBox readonly" name="reportPersonName" readonly></div>
          </div>
          <div class="myprojectReport_list">
            <div class="list_title"><span>내용</span></div>
            <div class="list_content"><textarea id="reportContent" class="myprojectReportTotalContent ReportBox" name="reportContent" required></textarea></div>
          </div>
          <div class="myprojectCancel_list">
            <div class="list_title2"><span>취소/환불 규정</span></div>
            <div class="list_content">
              <div id="reportContent" class="rule" name="reportContent" >
                  가. 기본 환불 규정 <br>
                  1. 전문가와 의뢰인의 상호 협의하에 청약 철회 및 환불이 가능합니다.<br>
                  2. 작업이 완료된 이후 또는 자료, 프로그램 등 서비스가 제공된 이후에는 환불이 불가합니다.<br>
                  ( 소비자보호법 17조 2항의 5조. 용역 또는 「문화산업진흥 기본법」 제2조 제5호의 디지털콘텐츠의 제공이 개시된 경우에 해당)<br>
                  <br>
                  나. 전문가 책임 사유<br>
                  1. 전문가의 귀책사유로 당초 약정했던 서비스 미이행 혹은 보편적인 관점에서 심각하게 잘못 이행한 경우 결제 금액 전체 환불이 가능합니다.<br>
                    <br>
                  다. 의뢰인 책임 사유<br>
                  1. 서비스 진행 도중 의뢰인의 귀책사유로 인해 환불을 요청할 경우, 사용 금액을 아래와 같이 계산 후 총 금액의 10%를 공제하여 환불합니다.<br>
                  총 작업량의 1/3 경과 전 : 이미 납부한 요금의 2/3해당액<br>
                  총 작업량의 1/2 경과 전 : 이미 납부한 요금의 1/2해당액<br>
                  총 작업량의 1/2 경과 후 : 반환하지 않음
              </div>
            </div>
          </div>
          <div class="myprojectReport_list" id="fileadd">
            <div class="list_title" style="margin-right:0;"><span>첨부파일</span></div>
            <div class="list_content fileRemove"><input type = "file" name="reportFilePath" id="reportFilePath1" accept="image/*" ></div>
          </div>
          <div class="btnDiv" ><button id="ajaxReview" class="ajaxReview">저장하기</button></div>
          </form>
    </div>
  </div>
