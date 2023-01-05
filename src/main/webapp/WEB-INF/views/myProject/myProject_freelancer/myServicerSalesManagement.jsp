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
  <title>판매내역</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_freelancer/myProject_salesManagement.css">

</head>
<body>
  <main>
    <!-- hearder salesList-->
    <%-- <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myProject_header2.jsp"/> --%>
     <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
    <!-- hearder -->
    <c:if test="${not empty param}">
        <c:forEach var="parameter" items="${param}">
            <c:if test="${parameter.key != 'cp'}">
            
                <c:set var="sURL" value="${sURL}&${parameter.key}=${parameter.value}"/>
            </c:if>
        </c:forEach>
    </c:if>
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
                    <col width="40"><col width="0"><col width="*"><col width="130"><col width="95"><col width="80"><col width="80"><col width="180">
                  </colgroup>
                  <thead>
                    <tr>
                      <th scope="col" class="frst"><strong class="line_n">번호</strong></th>
                      <th scope="col" class=""><strong class="line_n">거래번호</strong></th>
                      <th scope="col" class=""><strong class="line_r">서비스명</strong></th>   
                      <th scope="col" class=""><strong class="line_r">요청사항</strong></th>   
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
                              <c:choose>
                                <c:when test="${sales.serviceDelFL eq 'N' && sales.serviceStatus == 2}"><a href="/category/${sales.mainCategoryNo}/${sales.subCategoryNo}/${sales.thirdCategoryNo}/${sales.serviceNo}" id="suggestionName" class="suggestionName suggestionNameAtag" suggestionName="" target="_blank">${sales.serviceTitle}</a></c:when>
                                <c:otherwise><span id="suggestionName" class="suggestionName suggestionNameNo" suggestionName="">${sales.serviceTitle}</span></c:otherwise>
                              </c:choose>
                              
                            </div>
                          </td>
                          <td  class="tl">
                            <div class="client_tradeRequest td_link">
                              <span id="clientTradeRequest" class="clientTradeRequest" expertName="" title="${sales.tradeNo}">${sales.tradeRequestString}</span>
                            </div>
                          </td>
                          <td  class="tc">
                            <div class="client_name_area td_link">
                              <span id="clientName" class="clientName" expertName="">${sales.memberName}</span>
                            </div>
                          </td>
                          <td class="tc">
                            <span class="num" id="serviceEditNum${sales.tradeNo}"><c:choose><c:when test="${sales.workCount == sales.serviceEditNum+1}">${sales.workCount-1}/${sales.serviceEditNum}</c:when><c:otherwise>${sales.workCount}/${sales.serviceEditNum}</c:otherwise></c:choose></span>
                          </td>
                          <td class="tc">
                            <c:choose>
                                <c:when test="${sales.workStatus == 2 || sales.workStatus == 3}">
                                  <span class="text">${sales.workStatusString}</span></c:when>
                                <c:otherwise><span class="text">${sales.freelancerFLString}</span></c:otherwise>
                              </c:choose>
                            
                          </td>
                          <td class="tc" id="tdBtn${sales.tradeNo}">
                            <c:choose>
                              <c:when test="${sales.freelancerFLString eq '진행 중' && (sales.workStatus != 2 && sales.workStatus != 3)}">
                                <c:if test="${sales.workCount ge 1}">
                                  <a href="#" id="finishBtn${sales.tradeNo}" title="${sales.tradeNo}" class="finishBtn btn_type"><span>완료</span></a>
                                </c:if>
                                <c:if test="${sales.workCount le sales.serviceEditNum}">
                                  <a href="#" id="sendBtn${sales.tradeNo}" title="${sales.tradeNo}" class="sendBtn btn_type"><span>발송</span></a>
                                </c:if>
                                <a href="#" id="reportBtn${sales.tradeNo}" title="${sales.tradeNo}" class="reportBtn btn_type"><span>신고</span></a>
                              </c:when>
                              <c:otherwise>
                                <c:if test="${sales.tradeReportNo != 0}">
                                  <a href="#" id="reportBtn${sales.tradeNo}" title="${sales.tradeNo}" class="reportBtn btn_type" style="width: 80px; background-color: white!important;"><span>신고내역</span></a>
                                </c:if>
                              </c:otherwise>
                            </c:choose>
                            
                          </td>                
                        </tr>
                      </c:forEach>
                    </c:if> 
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <c:if test="${listCount != 0}">
                
                <div class="pagination-area">


                    <ul class="pagination">
                    
                        <!-- 첫 페이지로 이동 -->
                        <li><a href="/member/myProject/freelancer/myServiceSales?cp=1${sURL}">&lt;&lt;</a></li>
        
                        <!-- 이전 목록 마지막 번호로 이동 -->
                        <li><a href="/member/myProject/freelancer/myServiceSales?cp=${pagination.prevPage}${sURL}">&lt;</a></li>
        
            
                        <!-- 특정 페이지로 이동 -->
                        <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                        <c:choose>
                            <c:when test="${i== pagination.currentPage}">
                            <!-- 현재 페이지인 경우 -->
                            <li><a class="current">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                            <!-- 현재 페이지를 제외한 나머지 -->
                            <li><a href="/member/myProject/freelancer/myServiceSales?cp=${i}${sURL}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                        </c:forEach>
                        <!-- 다음 목록 시작 번호로 이동 -->
                        <li><a href="/member/myProject/freelancer/myServiceSales?cp=${pagination.nextPage}${sURL}">&gt;</a></li>
        
                        <!-- 끝 페이지로 이동 -->
                        <li><a href="/member/myProject/freelancer/myServiceSales?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
        
                    </ul>
                </div>
            </c:if>
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
        <div class="reportModal">
          <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myprojectSales_reportModal.jsp" /> 
        </div>
        <div class="clientTradeRequestModal">
          <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myprojectSales_clientTradeRequestModal.jsp" /> 
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