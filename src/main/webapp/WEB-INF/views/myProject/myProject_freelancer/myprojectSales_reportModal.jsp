<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

    <link rel="stylesheet" href="/resources/css/myProject/myProject_freelancer/myprojectSales_reportModal.css">

    

    <div class="reportModal_body">
      <span class="reportModal_close">x</span>
      <div class="myprojectReport">
        <form action ="" class="myprojectReportfrm" method="get" name="myprojectReportfrm" id="myprojectReportfrm">
          <div class="title"><span>신고하기</span></div>
          <div class="myprojectReport_list">
            <div class="list_title"><span>서비스명</span></div>
            <div class="list_content"><input id="serviceTitle" type="text" class="ReportBox readonly" name="serviceTitle" readonly></div>
          </div>
          <div class="myprojectReport_list">
            <div class="list_title"><span>거래번호</span></div>
            <div class="list_content"><input id="tradeNo" type="text" class="ReportBox readonly" name="tradeNo" readonly></div>
          </div>
          <div class="myprojectReport_list">
            <div class="list_title"><span>신고자</span></div>
            <div class="list_content"><input id="memberName" type="text" class="ReportBox readonly" name="reportPersonNo" readonly></div>
          </div>
          <div class="myprojectReport_list">
            <div class="list_title"><span>신고사유</span></div>
            <div class="list_content"><textarea id="reportContent" class="myprojectReportTotalContent ReportBox" name="reportContent" required></textarea></div>
          </div>
          <div class="myprojectReport_list" id="fileadd">
            <div class="list_title"><span>첨부파일</span></div>
            <div class="list_content"><input type = "file" multiple="multiple" name="reportFilePath" id="reportFilePath"></div>
          </div>
          <div class="btnDiv" ><button id="ajaxReview">신고하기</button></div>
        </form>
    </div>
  </div>
