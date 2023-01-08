<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<c:set var="purchaseList" value="${resultMap.purchaseList}"/>
<c:set var="pagination" value="${resultMap.pagination}"/>
<c:set var="loginMember" value="${sessionScope.loginMember}"/>
<c:set var="message" value="${message}"/>
<c:set var="i" value="0"/>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>myPurchaseList</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_myPurchaseList.css">
  
</head>
<body id="mainBody">
  <main>
    <!-- hearder -->
    <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
    <c:if test="${not empty param}">
        <c:forEach var="parameter" items="${param}">
            <c:if test="${parameter.key != 'cp'}">
                <c:set var="sURL" value="${sURL}&${parameter.key}=${parameter.value}"/>
            </c:if>
        </c:forEach>
    </c:if>

    <!-- hearder -->
    <!-- 화면 크기 width: 1200px로 고정 -->
    <div class="mainInBody"> 
        <!-- sideMenu -->
        <jsp:include page="/WEB-INF/views/myProject/myProjectSide.jsp"/>
        <!-- sideMenu -->

        <!-- sideMenu를 제외한 메인 내용 -->
        <section class="mainContent">
          <div class="container">
            <div class="container_header">
              <form action ="" class="myPurchaseListfrm" method="get" name="myPurchaseListfrm" id="myPurchaseListfrm">
                <section class="container_header">
                  <!-- 상단 내프로젝트 페이지 제목 -->
                  <div class="container_title"><span>구매 관리</span></div>
                  <!-- 상단 내프로젝트 페이지 제목 -->
                  <!-- 상단 selectbox -->
                  <div class="selectbox">
                    <select  id = "selectType" class="srchOption box" name="type" title="${type}">
                      <option value="0">카테고리 선택</option>
                      <option value="1">디자인</option>
                      <option value="2">IT·프로그래밍</option>
                      <option value="3">영상</option>
                      <option value="4">사진</option>
                      <option value="5">음향</option>
                    </select>
                  </div>
                  <div class="selectbox">
                    <input type="date" class="startDate box" name="searchDate1" id="searchDate1" title="${searchDate1}">- 
                  </div>
                  <div class="selectbox">
                    <input type="date" class="endtDate box" name="searchDate2" id="searchDate2" title="${searchDate2}">
                  </div>
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
                  <colgroup>
                    <col width="40"><col width="*"><col width="100"><col width="95"><col width="95"><col width="180">
                  </colgroup>
                  <thead>
                    <tr>
                      <th scope="col" class="frst"><strong class="line_n">번호</strong></th>
                      <th scope="col" class=""><strong class="line_r">서비스명</strong></th>   
                      <th scope="col" class=""><strong class="line_r">프리랜서</strong></th>  
                      <th scope="col" class=""><strong class="line_n">수정횟수</strong></th>
                      <th scope="col" class=""><strong class="line_n">작업상태</strong></th>
                      <!-- 작업 상태가 진행중일때 버튼으로 쓰일 컬럼들 -->
                      <th scope="col" class="last"><strong class="line_n"></strong></th>                  
                    </tr>
                  </thead>
                  <tbody id = "selecttbody">


                    <c:if test="${empty purchaseList}">
                      <tr class="suggestionTable" suggestionNumeber="">
                        <td colspan="6" style="text-align:center;"> 구매한 서비스가 없습니다. </td>
                      </tr>
                    </c:if>


                    <c:if test="${not empty purchaseList}">
                      <c:forEach var="purchase" items="${purchaseList}">
                        <tr class="suggestionTable" suggestionNumeber="">
                          <td class="tc">
                            <span class="num">${i=i+1}</span>
                          </td>
                          <td class="tl">
                            <div class="suggestion_name_area td_link">
                              <c:choose>
                                <c:when test="${purchase.seviceDeleteFlag eq 'N' && purchase.serviceStatus == 2}"><a href="/category/${purchase.mainCategoryNo}/${purchase.subCategoryNo}/${purchase.thirdCategoryNo}/${purchase.serviceNo}" id="serviceName" class="serviceName serviceNameAtag" serviceName="" target="_blank">${purchase.serviceTitle}</a></c:when>
                                <c:otherwise><span id="serviceName" class="serviceName noSalesSevice" serviceName="">${purchase.serviceTitle}</span></c:otherwise>
                              </c:choose>
                            </div>
                          </td>
                          <td  class="tc">
                            <div class="expert_name_area td_link">
                              <a href="#" id="expertName" class="expertName" expertName="">${purchase.freelancerName}</a>
                            </div>
                          </td>
                          <td class="tc">
                            <span class="num">
                              <c:choose>
                                <c:when test="${purchase.workCount>purchase.serviceEditNum}">${purchase.serviceEditNum}/${purchase.serviceEditNum}</c:when>
                                <c:otherwise>${purchase.workCount}/${purchase.serviceEditNum}</c:otherwise>
                              </c:choose>
                              </span>
                          </td>
                          <td class="tc">
                            <span class="text">${purchase.workProgress}</span>
                          </td>
                          <td class="tc">
                            <c:if test="${purchase.workCount==0 && purchase.memberDoneFL==1 && purchase.workStatus!=3}">
                              <a id="cancelBtn" title="" class="cancelBtn btn_type">취소</a>
                              <a id="reportBtn" title="" class="reportBtn btn_type">신고</a>
                            </c:if>
                            <c:if test="${purchase.workCount>=1 && purchase.memberDoneFL==1 && purchase.workStatus!=3}">
                              <a id="${purchase.tradeNo}" title="" class="finishBtn btn_type">완료</a>
                              <a id="cancelBtn" title="" class="cancelBtn btn_type">취소</a>
                              <a id="reportBtn" title="" class="reportBtn btn_type">신고</a>
                            </c:if>
                            <c:if test="${purchase.workStatus==2 && purchase.memberDoneFL==2}">
                              <a id="reviewCreateBtn" title="" class="reviewCreateBtn">리뷰하기</a>
                            </c:if>

                          </td>
                          <input type="hidden" id="hiddenTradeNo" value="${purchase.tradeNo}">                
                          <input type="hidden" id="hiddenMemberName" value="${purchase.memberName}">                
                          <input type="hidden" id="hiddenMemberNo" value="${purchase.memberNo}">                
                        </tr>
                      </c:forEach>
                    </c:if>
                    


                  </tbody>
                </table>
              </div>

            </div>
          </div>

          <div class="report-modal">
            <jsp:include page="/WEB-INF/views/myProject/modal/myproject_report.jsp" /> 
          </div>
          <div class="cancel-modal">
            <jsp:include page="/WEB-INF/views/myProject/modal/myproject_cancel.jsp" /> 
          </div>
          <div class="review-modal">
            <jsp:include page="/WEB-INF/views/myProject/modal/myproject_review.jsp" /> 
          </div>


              <!-- pagination -->
          <div class="pagination-area">


              <ul class="pagination">
              <c:if test="${not empty purchaseList}">

                <!-- 첫 페이지로 이동 -->
                <li><a href="/member/myProject/myPurchaseList?cp=1${sURL}">&lt;&lt;</a></li>

                <!-- 이전 목록 마지막 번호로 이동 -->
                <li><a href="/member/myProject/myPurchaseList?cp=${pagination.prevPage}${sURL}">&lt;</a></li>



                <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1" >
                
                  <!-- 특정 페이지로 이동 -->
                  <c:choose>
                  
                    <c:when test="${i==pagination.currentPage}">
                      <!-- 현재 보고있는 페이지 -->
                      <li>
                        <a class="current">${i}</a>
                      </li>
                    </c:when>
                    
                    <c:otherwise>
                      <!-- 현재 페이지를 제외한 나머지 -->
                      <li><a href="/member/myProject/myPurchaseList?cp=${i}${sURL}">${i}</a></li>
                    </c:otherwise>
                  
                  </c:choose>
                  
                </c:forEach>
                
                
                
                <!-- 다음 목록 시작 번호로 이동 -->
                <li><a href="/member/myProject/myPurchaseList?cp=${pagination.nextPage}${sURL}">&gt;</a></li>

                <!-- 끝 페이지로 이동 -->
                <li><a href="/member/myProject/myPurchaseList?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
                </c:if>

              </ul>
            </div>
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
       
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
  </main>
  <c:if test="${not empty message}">
        <script>
        alert("${message}");
        </script>

        <%-- message 1회 출력 후 삭제 --%>
        <c:remove var="message"/>
     </c:if>

  <!-- **************************************footer*************************************-->
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  <!-- **************************************footer*************************************-->
  
  <!-- jQuery  -->
  <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
  
  <script src="/resources/js/myProject/myPurchaseList.js"></script>
</body>
</html>