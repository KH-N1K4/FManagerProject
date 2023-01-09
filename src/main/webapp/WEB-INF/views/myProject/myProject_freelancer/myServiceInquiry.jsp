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
  <title>서비스 문의 내역</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_freelancer/myServiceInquiry.css">

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
              <form action ="/member/myProject/freelancer/myServiceInquiry" class="myServiceInquiryfrm" method="get" name="myServiceInquiryfrm" id="myServiceInquiryfrm">
                <section class="container_header">
                  <!-- 상단 내프로젝트 페이지 제목 -->
                  <div class="container_title"><span>서비스 문의</span></div>
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
                    <input type="date" class="startDate DateBox" name="startDate" id="startDate" title="${startDate}"> - 
                  </div> 
                  <div class="selectbox">
                    <input type="date" class="endtDate DateBox" name="endtDate" id="endtDate" title="${endtDate}">
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
                  <caption><span class="blind">서비스 문의</span></caption>				
                  <colgroup>
                    <col width="40"><col width="200"><col width="*"><col width="100"><col width="150">
                  </colgroup>
                  <thead>
                    <tr>
                      <th scope="col" class="frst"><strong class="line_n">번호</strong></th>
                      <th scope="col" class=""><strong class="line_n">서비스명</strong></th>
                      <th scope="col" class=""><strong class="line_r">문의 내역</strong></th>   
                      <th scope="col" class=""><strong class="line_r">의뢰인</strong></th>
                      <!-- 채팅하기 버튼 --> 
                      <th scope="col" class="last"><strong class="line_n"></strong></th>                     
                    </tr>
                  </thead>
                  <tbody id = "selecttbody">
                    <c:if test="${not empty inquiryList}">
                      <c:forEach items="${inquiryList}" var="inquiry">
                        <tr class="myServiceInquiryTable" myServiceInquiryNumeber="">
                          <td class="tc">
                            <span class="num">${i=i+1}</span>
                          </td>
                          <td class="tl">
                            <div class="service_name_area td_link">
                              <c:choose>
                                <c:when test="${inquiry.serviceDelFL eq 'N' && inquiry.serviceStatus == 2}"><a href="/category/${inquiry.mainCategoryNo}/${inquiry.subCategoryNo}/${inquiry.thirdCategoryNo}/${inquiry.serviceNo}" id="serviceName" class="serviceName serviceNameAtag" serviceName="" target="_blank">${inquiry.serviceTitle}</a></c:when>
                                <c:otherwise><span id="serviceName" class="serviceName noSalesSevice" serviceName="">${inquiry.serviceTitle}</span></c:otherwise>
                              </c:choose>
                            </div>
                          </td>
                          <td  class="tl">
                              <span class="text serviceInquiryContent">${inquiry.serviceInquiryContent}</span>
                          </td>
                          <td class="tc">
                            <span class="text">${inquiry.memberName}</span>
                          </td>
                          <td class="tc">
                            <a href="/member/message?clientNo=${inquiry.memberNo}" id="cattingRoom${inquiry.memberNo}" title="${inquiry.memberNo}" class="chattingBtn btn_type"><span>채팅하기</span></a>
                          </td>                
                        </tr>
                      </c:forEach>
                    </c:if>
                    <c:if test="${empty inquiryList}">
                          <tr>
                            <td colspan="5" class="tc"> 서비스 문의 내역이 없습니다. </td>
                          </tr>
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
                        <li><a href="/member/myProject/freelancer/myServiceInquiry?cp=1${sURL}">&lt;&lt;</a></li>
        
                        <!-- 이전 목록 마지막 번호로 이동 -->
                        <li><a href="/member/myProject/freelancer/myServiceInquiry?cp=${pagination.prevPage}${sURL}">&lt;</a></li>
        
            
                        <!-- 특정 페이지로 이동 -->
                        <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                        <c:choose>
                            <c:when test="${i== pagination.currentPage}">
                            <!-- 현재 페이지인 경우 -->
                            <li><a class="current">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                            <!-- 현재 페이지를 제외한 나머지 -->
                            <li><a href="/member/myProject/freelancer/myServiceInquiry?cp=${i}${sURL}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                        </c:forEach>
                        <!-- 다음 목록 시작 번호로 이동 -->
                        <li><a href="/member/myProject/freelancer/myServiceInquiry?cp=${pagination.nextPage}${sURL}">&gt;</a></li>
        
                        <!-- 끝 페이지로 이동 -->
                        <li><a href="/member/myProject/freelancer/myServiceInquiry?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
        
                    </ul>
                </div>
            </c:if>
        </section>
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
  </main>

  <!-- **************************************footer*************************************-->
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  <!-- **************************************footer*************************************-->
  <script>
    var list = JSON.parse('${inputMyService}');
    /* var saleslist = JSON.parse('${GsonsalesList}'); */
    var loginMemberName = '${loginMember.memberName}';
    var loginMemberNo = '${loginMember.memberNo}';
  </script>
  <!-- jQuery  -->
  <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

  <script src="/resources/js/myProject/myProject_freelancer/myServiceInquiry.js"></script>
</body>
</html>