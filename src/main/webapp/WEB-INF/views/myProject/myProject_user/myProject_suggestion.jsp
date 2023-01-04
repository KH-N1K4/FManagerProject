<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<c:set var="proposal" value="${proposal}"/>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>myProject_suggestion</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_user/myProject_suggestion.css">
  
</head>
<body>
  <main>
    <!-- hearder -->
    <jsp:include page="/WEB-INF/views/myProject/myProject_header.jsp"/>

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
              <section class="container_header_left">
                <!-- 상단 내프로젝트 페이지 제목 -->
                <div class="container_title"><span>받은 제안</span></div>
                <!-- 상단 내프로젝트 페이지 제목 -->
                <!-- 상단 selectbox -->
                <div class="selectbox">
                  <select  id = "srchOption" class="srchOption" name="srchOption" >
                    <option value="0" selected="">전체</option>
                    <option value="1">디자인</option>
                    <option value="2">IT·프로그래밍</option>
                    <option value="3">영상</option>
                    <option value="4">사진</option>
                    <option value="5">음향</option>
                  </select>
                </div>
                <!-- 상단 selectbox -->
              </section>
            </div>
            <!--  -->
            <div class="tableArea">
              <div id="tableContent">
                <table cellspacing="0" class="tbl_lst_type">	
                  <caption><span class="blind">받은 제안 정보</span></caption>
                  <colgroup>
                    <col width="50"><col width="*"><col width="95"><col width="95"><col width="95"><col width="95"><col width="95"><col width="95">
                  </colgroup>
                  <thead>
                    <tr>
                      <th scope="col" class="frst"><strong class="line_n">번호</strong></th>
                      <th scope="col" class=""><strong class="line_r">프로젝트명</strong></th>   
                      <th scope="col" class=""><strong class="line_r">전문가</strong></th>  
                      <th scope="col" class=""><strong class="line_n">등급</strong></th>
                      <th scope="col" class=""><strong class="line_n">금액</strong></th>
                      <th scope="col" class=""><strong class="line_n">수정횟수</strong></th>
                      <th scope="col" class=""><strong class="line_n">상태</strong></th>
                      <th scope="col" class="last"><strong class="line_n">채택</strong></th>
                    </tr>
                  </thead>
                  <tbody id = "selecttbody">
                      <c:if test="${empty proposal}">
                        <tr class="suggestionTable" suggestionNumeber="">
                          <td colspan="8"> 받은 제안이 없습니다. </td>
                        </tr>
                      </c:if>
                      <c:if test="${not empty proposal}">
                        <c:forEach items="${proposal}" var="proposal">
                              <tr class="suggestionTable" id="suggestionTable">
                                <td class="tc">
                                  <span class="num">${proposal.proposalNo}</span>
                                </td>
                                <td class="tl">
                                  <div class="suggestion_name_area td_link">
                                    <a href="#" id="suggestionName" class="suggestionName">${proposal.projectRequestTitle}</a>
                                  </div>
                                </td>
                                <td  class="tc">
                                  <div class="expert_name_area td_link">
                                    <a href="#" id="expertName" class="expertName" expertName="">${proposal.freelancerName}</a>
                                  </div>
                                </td>
                                <td class="tc">                  
                                  <span class="text">${proposal.gradeName}</span>
                                </td>
                                <td class="tc">
                                  <span class="text">${proposal.proposalPrice}원</span>
                                </td>
                                <td class="tc">
                                  <span class="num">${proposal.proposalEditNum}/5</span>
                                </td>
                                <td class="tc" id="proposalStatus">
                                  <span class="text">${proposal.proposalAdoptStatus}</span>
                                </td>
                                <td class="tc">
                                  <button id="chooseBtn" title="" class="chooseBtn btn_type">채택</button>
                                </td>                
                              </tr>
                        </c:forEach>
                      </c:if>
                  </tbody>
                </table>

                <c:if test="${listCount != 0}">
                  <div class="pagination-area">
                    <ul class="pagination">
                        <!-- 첫 페이지로 이동 -->
                        <li><a href="/member/myProject/myReceiveList?cp=1${sURL}">&lt;&lt;</a></li>
                        <!-- 이전 목록 마지막 번호로 이동 -->
                        <li><a href="/member/myProject/myReceiveList?cp=${pagination.prevPage}${sURL}">&lt;</a></li>
                        <!-- 특정 페이지로 이동 -->
                        <c:forEach var="countPage" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                        <c:choose>
                            <c:when test="${countPage== pagination.currentPage}">
                            <!-- 현재 페이지인 경우 -->
                            <li><a class="current">${countPage}</a></li>
                            </c:when>
                            <c:otherwise>
                            <!-- 현재 페이지를 제외한 나머지 -->
                            <li><a href="/member/myProject/myReceiveList?cp=${countPage}${sURL}">${countPage}</a></li>
                            </c:otherwise>
                        </c:choose>
                        </c:forEach>
                        <!-- 다음 목록 시작 번호로 이동 -->
                        <li><a href="/member/myProject/myReceiveList?cp=${pagination.nextPage}${sURL}">&gt;</a></li>
                        <!-- 끝 페이지로 이동 -->
                        <li><a href="/member/myProject/myReceiveList?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
                    </ul>
                  </div>
                </c:if>

              </div>
            </div>
          </div>
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
  </main>

  
  <!-- **************************************footer*************************************-->

	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  
    <script>
        var memberNo = '${loginMember.memberNo}';
        var proposalAdoptStatus = '${proposal[0].proposalAdoptStatus}';
    </script>

  <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
  <script src="/resources/js/myProject/myProject_user/myProjectSuggestion.js"></script> 
</body>
</html>