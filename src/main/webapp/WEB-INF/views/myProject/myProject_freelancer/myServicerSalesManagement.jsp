<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<c:set var="maincategory" value="${maincategoryList}"/>
<c:set var="i" value="0"/>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>salesManagement</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_freelancer/myProject_salesManagement.css">

</head>
<body>
  <main>
    <!-- hearder salesList-->
    <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myProject_header2.jsp"/>
    <!-- hearder -->
    <!-- 화면 크기 width: 1200px로 고정 -->
    <div class="mainInBody"> 
        <!-- sideMenu -->
        <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myProjectSide2.jsp"/>
        <!-- sideMenu -->

        <!-- sideMenu를 제외한 메인 내용 -->
        <section class="mainContent">
          <div class="container">
            <div class="container_header">
              <form action ="/member/myProject/freelancer/myServiceSales" class="mySerivceSalesfrm" method="get" name="mySerivceSalesfrm" id="mySerivceSalesfrm">
                <section class="container_header">
                  <!-- 상단 내프로젝트 페이지 제목 -->
                  <div class="container_title"><span>판매 관리</span></div>
                  <!-- 상단 내프로젝트 페이지 제목 -->
                  <!-- 상단 selectbox -->
                  <div class="selectbox">
                    <select  id = "srchOption1" class="srchOption box" name="mainCategoryNo" title="${mainCategoryNoInput}">
                      <option value="0" selected="">전체</option>
                      <c:if test="${not empty maincategory}">
                          <c:forEach items="${maincategory}" var="mainVar">
                              <option value="${mainVar.mainCategoryNo}">${mainVar.mainCategoryName}</option>
                          </c:forEach> 
                      </c:if>
                    </select>
                  </div>
                  <div class="selectbox">
                    <select  id = "srchOption2" class="srchOption box" name="freelancerFL" title="${freelancerFL}">
                      <option value="0" selected="">전체</option>
                      <option value="1">진행 중</option>
                      <option value="2">작업 완료</option>
                    </select>
                  </div><!-- 1:진행 중, 2: 작업 완료 -->
                  <!-- <div class="selectbox">
                    <input type="date" class="startDate box" name="startDate" id="startDate">
                  </div> -->
                  <!-- <div class="selectbox">
                    <input type="date" class="endtDate box" name="endtDate" id="endtDate">
                  </div> -->
                  <div class="searchbox" id="searchboxRelative">
                    <input type="text" class="searchInput" name="searchInput" id="searchInput" placeholder="상품명" maxlength="50" autocomplete="off" <c:if test="${not empty searchInput}">value="${searchInput}"</c:if>>
                    <div id="searchboxInclude"></div>
                  </div>
                  <!-- 상단 selectbox -->
                  <div class="buttonArea">
                    <button type="submit" class="submitButton">검색</button>
                  </div>
                </section>
              </form>
            </div>
            <!--  -->
            <div class="tableArea">
              <div id="tableContent">
                <table cellspacing="0" class="tbl_lst_type">	
                  <caption><span class="blind">판매 서비스 관리</span></caption>				
                  <colgroup>
                    <col width="40"><col width="100"><col width="*"><col width="100"><col width="95"><col width="95"><col width="180">
                  </colgroup>
                  <thead>
                    <tr>
                      <th scope="col" class="frst"><strong class="line_n">번호</strong></th>
                      <th scope="col" class=""><strong class="line_n">거래번호</strong></th>
                      <th scope="col" class=""><strong class="line_r">서비스명</strong></th>   
                      <th scope="col" class=""><strong class="line_r">의뢰인</strong></th>  
                      <th scope="col" class=""><strong class="line_n">수정횟수</strong></th>
                      <th scope="col" class=""><strong class="line_n">작업상태</strong></th>
                      <!-- 작업 상태가 진행중일때 버튼으로 쓰일 컬럼들 -->
                      <th scope="col" class="last"><strong class="line_n"></strong></th>                  
                    </tr>
                  </thead>
                  <tbody id = "selecttbody">
                    <c:if test="${not empty salesList}">
                      <c:forEach items="${salesList}" var="sales">
                        <tr class="suggestionTable" suggestionNumeber="">
                          <td class="tc">
                            <span class="num">${i=i+1}</span>
                          </td>
                          <td class="tc">
                            <span class="num">${sales.tradeNo}</span>
                          </td>
                          <td class="tl">
                            <div class="suggestion_name_area td_link">
                              <a href="#" id="suggestionName" class="suggestionName" suggestionName="">${sales.serviceTitle}</a>
                            </div>
                          </td>
                          <td  class="tc">
                            <div class="client_name_area td_link">
                              <a href="#" id="clientName" class="clientName" expertName="">${sales.memberName}</a>
                            </div>
                          </td>
                          <td class="tc">
                            <span class="num">${sales.workCount}/${sales.serviceEditNum}</span>
                          </td>
                          <td class="tc">
                            <span class="text">${sales.freelancerFLString}</span>
                          </td>
                          <td class="tc">
                            <c:if test="${sales.freelancerFL == 1}">
                              <a href="#" id="finishBtn" title="${sales.tradeNo}" class="finishBtn btn_type"><span>완료</span></a>
                              <a href="#" id="sendBtn" title="${sales.tradeNo}" class="sendBtn btn_type"><span>발송</span></a>
                              <a href="#" id="reportBtn${sales.tradeNo}" title="${sales.tradeNo}" class="reportBtn btn_type"><span>신고</span></a>
                            </c:if>
                          </td>                
                        </tr>
                      </c:forEach>
                    </c:if> 
                    <tr class="suggestionTable" suggestionNumeber="">
                      <td class="tc">
                        <span class="num">2</span>
                      </td>
                      <td class="tc">
                        <span class="num">2</span>
                      </td>
                      <td class="tl">
                        <div class="suggestion_name_area td_link">
                          <a href="#" id="suggestionName" class="suggestionName" suggestionName="">프리랜서 마켓 웹사이트 제작</a>
                        </div>
                      </td>
                      <td  class="tc">
                        <div class="expert_name_area td_link">
                          <a href="#" id="expertName" class="expertName" expertName="">김이듀</a>
                        </div>
                      </td>
                      <td class="tc">
                        <span class="num">1/5</span>
                      </td>
                      <td class="tc">
                        <span class="text">완료</span>
                      </td>
                      <td class="tc">
                      </td>                
                    </tr>
                    <tr class="suggestionTable" suggestionNumeber="">
                      <td class="tc">
                        <span class="num">3</span>
                      </td>
                      <td class="tc">
                        <span class="num">3</span>
                      </td>
                      <td class="tl">
                        <div class="suggestion_name_area td_link">
                          <a href="#" id="suggestionName" class="suggestionName" suggestionName="">웨딩 촬영 디자인</a>
                        </div>
                      </td>
                      <td  class="tc">
                        <div class="expert_name_area td_link">
                          <a href="#" id="expertName" class="expertName" expertName="">최사진</a>
                        </div>
                      </td>
                      <td class="tc">
                        <span class="num">1/4</span>
                      </td>
                      <td class="tc">
                        <span class="text">주문 취소</span>
                      </td>
                      <td class="tc">
                      </td>                
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
        <div class="reportModal">
          <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myprojectSales_reportModal.jsp" /> 
        </div>
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
  </main>

  <!-- **************************************footer*************************************-->
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  <!-- **************************************footer*************************************-->
  <script>
    var list = JSON.parse('${inpurMyService}');
    var saleslist = JSON.parse('${GsonsalesList}');
    var loginMemberName = '${loginMember.memberName}';
    var loginMemberNo = '${loginMember.memberNo}';
  </script>
  <!-- jQuery  -->
  <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

  <script src="/resources/js/myProject/myProject_freelancer/myServicerSalesManagement.js"></script>
  <script src="/resources/js/myProject/myProject_freelancer/myprojectSales_reportModal.js"></script>
</body>
</html>