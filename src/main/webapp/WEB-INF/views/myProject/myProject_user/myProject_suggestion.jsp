<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="proposal" value="${proposal}"/>
<c:set var="i" value="0"/>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>내프로젝트 - 받은 제안</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_user/myProject_suggestion.css">
  
</head>
<body >
  <main id="mainBody">
    <!-- hearder -->
  <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>
  <%-- 검색을 진행한 경우 --%>
    <c:if test="${not empty param}">
        <c:forEach var="parameter" items="${param}">
				<c:if test="${parameter.key != 'cp'}">
					<c:set var="sURL" value="${sURL}&${parameter.key}=${parameter.value}"/>
				</c:if>
		</c:forEach>
    </c:if>
    <c:if test="${not empty param.value}">      
        <c:forEach var="inputValue" items="${param.value}">
            <c:choose>
                <c:when test="${inputValue == '1'}">
                    <c:set var="inputValue1" value="selected" />
                </c:when>
                <c:when test="${inputValue == '2'}">
                    <c:set var="inputValue2" value="selected" />
                </c:when>
                <c:when test="${inputValue == '3'}">
                    <c:set var="inputValue3" value="selected" />
                </c:when>
                <c:when test="${inputValue == '4'}">
                    <c:set var="inputValue4" value="selected" />
                </c:when>
                <c:when test="${inputValue == '5'}">
                    <c:set var="inputValue5" value="selected" />
                </c:when>
            </c:choose>
        </c:forEach>
    </c:if>
    <c:if test="${empty param.value}">
      <c:choose>
          <c:when test="${optionVal == '1'}">
              <c:set var="inputValue1" value="selected" />
          </c:when>
          <c:when test="${optionVal == '2'}">
              <c:set var="inputValue2" value="selected" />
          </c:when>
          <c:when test="${optionVal == '3'}">
              <c:set var="inputValue3" value="selected" />
          </c:when>
          <c:when test="${optionVal == '4'}">
              <c:set var="inputValue4" value="selected" />
          </c:when>
          <c:when test="${optionVal == '5'}">
              <c:set var="inputValue5" value="selected" />
          </c:when>
      </c:choose>
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
              <section class="container_header_left">
                <!-- 상단 내프로젝트 페이지 제목 -->
                <div class="container_title"><span>받은 제안</span></div>
                <!-- 상단 내프로젝트 페이지 제목 -->
                <!-- 상단 selectbox -->
                <div class="selectbox">
                  <select  id = "srchOption" class="srchOption" name="srchOption" onchange="selectChange()">
                    <option value="0">카테고리 선택</option>
                    <option value="1" ${inputValue1}>디자인</option>
                    <option value="2" ${inputValue2}>IT·프로그래밍</option>
                    <option value="3" ${inputValue3}>영상</option>
                    <option value="4" ${inputValue4}>사진</option>
                    <option value="5" ${inputValue5}>음향</option>
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
                      <th scope="col" class=""><strong class="line_r">프리랜서</strong></th>  
                      <th scope="col" class=""><strong class="line_n">등급</strong></th>
                      <th scope="col" class=""><strong class="line_n">금액</strong></th>
                      <th scope="col" class=""><strong class="line_n">수정횟수</strong></th>
                      <th scope="col" class=""><strong class="line_n">상태</strong></th>
                      <th scope="col" class="last"><strong class="line_n">채택</strong></th>
                    </tr>
                  </thead>
                  <tbody id = "selecttbody">
                      <c:if test="${empty proposal}">
                        <tr class="suggestionTable" >
                          <td colspan="8"> 받은 제안이 없습니다. </td>
                        </tr>
                      </c:if>
                      <c:if test="${not empty proposal}">
                        <c:forEach items="${proposal}" var="proposal" varStatus="status">
                              <tr class="suggestionTable" id="suggestionTable">
                                <td class="tc">   
                                <c:set var="total" value="${pagination.currentPage-1 }" />
                    			 <c:set var="total1" value="${total*5 }" />                    
                                  <span class="num">${total1 + status.count}</span>
                                </td>
                                <td class="tl">                           
                                  <div class="suggestion_name_area td_link">
                                    <c:if test="${proposal.proposalAdoptStatus =='대기 중'}">
                                      <a href="/projectRequest/projectRequestDetail/${proposal.projectRequestNo}" id="suggestionName" class="suggestionName">${proposal.projectRequestTitle}</a>
                                    </c:if>
                                    <c:if test="${proposal.proposalAdoptStatus !='대기 중'}">
                                      <a id="suggestionName" class="suggestionName">${proposal.projectRequestTitle}</a>
                                    </c:if>
                                  </div>
                                </td>
                                <td  class="tc">                       
                                  <div class="expert_name_area td_link">
                                    <a href="/service/freelancerDetail/${proposal.freelancerNo}" id="expertName" class="expertName" expertName="">${proposal.freelancerName}</a>
                                  </div>
                                </td>
                                <td class="tc">                      
                                  <span class="text">${proposal.gradeName}</span>
                                </td>
                                <td class="tc">
                                  <span class="text"><fmt:formatNumber value="${proposal.proposalPrice}"/>원</span>
                                </td>
                                <td class="tc">                        
                                  <span class="num">${proposal.proposalEditNum}</span>
                                </td>
                                <td class="tc" id="proposalStatus">    
                                  <span class="text">${proposal.proposalAdoptStatus}</span>
                                </td>
                                <td class="tc">                           
                                    <c:if test="${proposal.proposalAdoptStatus == '대기 중'}">
                                      <button id="chooseBtn" class="chooseBtn" title="${proposal.proposalNo}">채택</button>
                                    </c:if>
                                    <div class="hidden" id="projectRequestTitle${proposal.proposalNo}">${proposal.projectRequestTitle}</div>
                                    <div class="hidden" id="freelancerName${proposal.proposalNo}">${proposal.freelancerName}</div>
                                    <div class="hidden" id="projectWorkPeriod${proposal.proposalNo}">${proposal.projectWorkPeriod}</div>
                                    <div class="hidden" id="proposalPrice${proposal.proposalNo}">${proposal.proposalPrice}</div>
                                    <div class="hidden" id="projectRequestStatus${proposal.proposalNo}">${proposal.projectRequestStatus}</div>
                                    <div class="hidden" id="proposalEditNum${proposal.proposalNo}">${proposal.proposalEditNum}</div>
                                    <div class="hidden" id="freelancerNo${proposal.proposalNo}">${proposal.freelancerNo}</div>
                                    <div class="hidden" id="proposalNo${proposal.proposalNo}">${proposal.proposalNo}</div>
                                    <div class="hidden" id="memberEmail${proposal.proposalNo}">${loginMember.memberEmail}</div>
                                    <div class="hidden" id="memberName${proposal.proposalNo}">${loginMember.memberName}</div>
                                    <div class="hidden" id="memberTel${proposal.proposalNo}">${loginMember.memberTel}</div>
                                    <div class="hidden" id="projectRequestNo${proposal.proposalNo}">${proposal.projectRequestNo}</div>
                                    <div class="hidden" id="projectRequestSummary${proposal.proposalNo}">${proposal.projectRequestSummary}</div>
                                    <div class="hidden" id="projectRequestContent${proposal.proposalNo}">${proposal.projectRequestContent}</div>
                                    <div class="hidden" id="projectCreateDate${proposal.proposalNo}">${proposal.projectCreateDate}</div>
                                    <div class="hidden" id="thirdCategoryNo${proposal.proposalNo}">${proposal.thirdCategoryNo}</div>
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
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  <div class="suggestionModal">
    <jsp:include page="/WEB-INF/views/myProject/myProject_user/suggestion_modal.jsp"/> 
  </div>
  </main>
  <!-- **************************************footer*************************************-->

  
    <script>
        var memberNo = '${loginMember.memberNo}';
        var proposalAdoptStatus = '${proposal[0].proposalAdoptStatus}';
    </script>

  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
  <script src="/resources/js/myProject/myProject_user/myProject_suggestion.js"></script> 
</body>
</html>