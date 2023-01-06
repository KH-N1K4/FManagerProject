<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

    <link rel="stylesheet" href="/resources/css/myProject/modal/myproject_cancelModal.css">

    

    <div class="cancelModal_body">
      <span class="cancelModal_close">x</span>
      <form action="/member/myProject/tradeReportCancel" method="POST" id="tradeReportCancelFrm"  enctype="multipart/form-data">
      <div class="myprojectCancel">
          <div class="title"><span>취소하기</span></div>
          <div class="myprojectCancel_list">
            <div class="list_title2"><span>서비스명</span></div>
            <div class="list_content"><input id="serviceTitle2" type="text" class="ReportBox readonly" name="serviceTitle" readonly></div>
          </div>
          <input id="tradeNo2" type="hidden" class="ReportBox readonly" name="tradeNo" readonly>
          <input id="memberNo2" type="hidden" class="ReportBox readonly" name="reportPersonNo" readonly>
          <div class="myprojectCancel_list">
            <div class="list_title2"><span>신고자</span></div>
            <div class="list_content"><input id="memberName2" type="text" class="ReportBox readonly" name="reportPersonName" readonly></div>
          </div>
          <div class="myprojectCancel_list">
            <div class="list_title2"><span>취소사유</span></div>
            <div class="list_content"><textarea id="reportContent2" class="myprojectReportTotalContent ReportBox" name="reportContent" required></textarea></div>
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
            <div class="list_title2"><span>첨부파일</span></div>
            <div class="list_content fileRemove"><input type = "file" name="reportFilePath" id="reportFilePath2"  accept="image/*"></div>
          </div>
          <div class="btnDiv" ><button id="ajaxReview">취소하기</button></div>
          </form>
    </div>
  </div>
