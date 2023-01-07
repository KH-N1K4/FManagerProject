<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>

  <link rel="stylesheet" href="/resources/css/common/modaless/messageReportModal.css">

  
</head>
<body>
  <div class="reportModal_body">
    <span class="reportModal_close" id="reportModal_close">x</span>
    <div class="myprojectReport">
        <div class="title"><span>신고하기</span></div>
        <div class="myprojectReport_list">
          <div class="list_title"><span>피신고자</span></div>
          <div class="list_content">
            <img src="">
            <span></span>
          </div>
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
          <div class="list_content fileRemove"><input type = "file" name="reportFilePath" id="reportFilePath"></div>
        </div>
        <div class="btnDiv" ><button id="ajaxReview">신고하기</button></div>
    </div>
  </div>

  <script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/showModalDialog.js'/>" ></script>
  <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

  <script src="/resources/js/common/modaless/messageReportModal.js"></script>
</body>
</html>
    

    

   


  
