<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>등급관리</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_freelancer/myProjectGrade.css">
  
</head>
<body>

   <%--  <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myProject_header2.jsp"/> --%>
    <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
    <!-- 화면 크기 width: 1200px로 고정 -->
    <div class="mainInBody"> 
        <!-- sideMenu -->
        <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myProjectSide2.jsp"/>
        <!-- sideMenu -->

        <!-- sideMenu를 제외한 메인 내용 -->
        <section class="mainContent">
          <div class="container">
            <div class="container_header">
              <section class="container_header_left">
                <!-- 상단 내프로젝트 페이지 제목 -->
                <div class="container_title"><span>등급 관리</span></div>
                <!-- 상단 내프로젝트 페이지 제목 -->
              </section>
            </div>
            <div class="myGradeBox">
              <span>${loginMember.memberNickname}님의 전문가 등급은 <h1>${freelancerGrade.gradeName}</h1>입니다.</span>
            </div>
          </div>
          <div class="topBox">
            <div class="leftBox">
              <div class="leftContentTop">
                <h2>누적 판매 건수</h2>
                <div><h1>${freelancerGrade.gradeSaleCount}건</h1></div>
              </div>
              <div class="leftContentbottom">
                <h2>누적 판매 금액</h2>
                <div><h1>${freelancerGrade.gradeSaleProceedsString}원</h1></div>
              </div>
            </div>
            <div class="rightBox">
              <div class="satisfaction">
                <div class="barTitle">만족도</div>
                <progress class="progress" id="satisfactionBar" value="${freelancerGrade.gradeSatisfaction}" min="0" max="5"></progress>
                <div class="barValue">${freelancerGrade.gradeSatisfaction}</div>
              </div>
              <div class="responseRate">
                <div class="barTitle">메세지 응답률</div>
                <progress class="progress" id="responseRateBar" value="${freelancerGrade.gradeInquityRate}" min="0" max="100"></progress>
                <div class="barValue">${freelancerGrade.gradeInquityRate}%</div>
              </div>
              <div class="WorkdayRate">
                <div class="barTitle">작업일 준수율</div>
                <progress class="progress" id="WorkdayRateBar" value="${freelancerGrade.gradeCompletionRate}" min="0" max="100"></progress>
                <div class="barValue">${freelancerGrade.gradeCompletionRate}%</div>
              </div>
            </div>
          </div>
          <div class="contentBox">
            <table cellspacing="0" class="tbl_lst_type">	
              <caption><span class="blind">등급 안내</span></caption>				
              <colgroup>
                <col width="150"><col width="*"><col width="150"><col width="150"><col width="150">
              </colgroup>
              <thead>
                <tr>
                  <th scope="col" class="frst"><strong class="line_n">등급</strong></th>
                  <th scope="col" class=""><strong class="line_n">누적판매 건수/금액</strong></th>
                  <th scope="col" class=""><strong class="line_r">만족도</strong></th>   
                  <th scope="col" class=""><strong class="line_r">메시지 응답률</strong></th>   
                  <th scope="col" class=""><strong class="line_r">작업일 준수율</strong></th>                  
                </tr>
              </thead>
              <tbody id = "selecttbody">
                <c:if test="${not empty BasicGrade}">
                  <c:forEach items="${BasicGrade}" var="basicGrade">
                    <tr class="basicGrade" basicGradeNumeber="">
                      <th class="tc">
                        <span class="num">${basicGrade.gradeName}</span>
                      </th>
                      <td class="tc">
                        <span class="num">${basicGrade.gradeSaleCount}건 이상/${basicGrade.gradeSaleProceedsString}원</span>
                      </td>
                      <td class="tc">
                        <span class="num">${basicGrade.gradeSatisfaction}</span>
                      </td> 
                      <td class="tc">
                        <span class="num">${basicGrade.gradeInquityRate}%</span>
                      </td> 
                      <td class="tc">
                        <span class="num">${basicGrade.gradeCompletionRate}%</span>
                      </td>            
                    </tr>
                  </c:forEach>
                </c:if> 
              </tbody>
            </table>
          </div>
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script>
    </script>

    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>


    <script src="/resources/js/myProject/myProject_freelancer/myProjectGrade.js"></script>
</body>
</html>