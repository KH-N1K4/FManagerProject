<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="myProject" value="${myProject}"/>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>myProject_UserPage</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_user/myProject_UserPage.css">
  
</head>
<body>
  <main>
    <!-- hearder -->
	  <%-- <jsp:include page="/WEB-INF/views/myProject/myProject_header.jsp"/> --%>
	  <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>

    <!-- 화면 크기 width: 1200px로 고정 -->
    <div class="mainInBody"> 

        <!-- sideMenu -->
        <jsp:include page="/WEB-INF/views/myProject/myProjectSide.jsp"/>

        <!-- sideMenu를 제외한 메인 내용 -->
        <section class="mainContent">
          <div class="container">

            <%-- container_header 시작 --%>
            <div class="container_header">

              <section class="container_header_left">
                <!-- 상단 내프로젝트 페이지 제목 -->
                <div class="container_title"><span>내 프로젝트</span></div>
                <!-- 상단 내프로젝트 페이지 제목 -->

                <!-- 상단 selectbox -->
                <div class="selectbox">
                  <select  id = "srchOption" class="srchOption" name="srchOption" onchange="selectChange()">
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

              <section class="container_header_right">
                <div>
                  <a class="myProject_register" href="/member/myProject/myRequestInsert"><span>등록하기</span></a>
                </div>
              </section>

            </div>
            <%-- container_header 끝 --%>
            <section class="contain">
            <!-- 프로젝트 의뢰 1번 -->
            <c:if test="${not empty myProject}">
	              <c:forEach items="${myProject}" var="myProject">
		                  <div class="myProject_content">
		                  
			                      <%-- 프로젝트 사진 --%>
			                      <div class="projuctContent_image">
			                        <img  src="${myProject.requestFilePath}">
			                        <%-- ${myProject.projectFileList} --%>
			                      </div>
			                      <%-- 프로젝트 사진 --%>
                            
			                      <div class="projuctContent_info">
			
				                        <%-- 프로젝트 제목 --%>
				                        <div class="info_title">
				                          <a href="/projectRequest/projectRequestDetail/${myProject.projectRequestNo}">
                                    <span>${myProject.projectRequestTitle}</span>
                                  </a>
				                        </div>
				                        <%-- 프로젝트 제목 --%>
					
				                        <diV class="info_content">
					                          <div class="info_content_left">

                                        <%-- 모집분야 --%>
						                            <div class="info_content_list"> 
						                              <div class="list_title"><span>모집분야</span></div> 
						                              <div class="list_content"> 
						                                <div class="main1category"><span>${myProject.mainCategoryName}</span></div>
						                                <span>></span>
						                                <div class="main3category"><span>${myProject.thirdCategoryName}</span></div> 
						                              </div>
						                            </div>
						                            
                                        <%-- 예산 --%>
						                            <div class="info_content_list"> 
						                              <div class="list_title"><span>예산</span></div>
						                              <div class="list_content">   
						                                <span><fmt:formatNumber value="${myProject.projectRequestBudget}"/>원</span> 
						                              </div>
						                            </div>
                                        <%-- 모집마감일 --%>
						                            <div class="info_content_list"> 
						                              <div class="list_title"><span>모집마감일</span></div> 
						                              <div class="list_content">
						                                <span>${myProject.projectRecruitDate}</span> 
						                              </div>
						                            </div>
					                          </div>
					                          
					                          <%-- 승인 상태 --%>
					                          <div class="info_content_right"> <%-- // 0000 --%>
					                            <div class="signState">
					                              <span>${myProject.projectRequestStatus}</span>
					                            </div>
					                          </div>
					                          <%-- 승인 상태 --%>

				                        </diV>
			                      </div>
		                  </div>
	              </c:forEach>
            </c:if>
            <c:if test="${empty myProject}"> 
                <div class="myProject_content">등록된 프로젝트가 없습니다.</div>
            </c:if>
            </section>
            <!-- 프로젝트 1번 -->

            <c:if test="${listCount != 0}">
                <div class="pagination-area">
                    <ul class="pagination">
                        <!-- 첫 페이지로 이동 -->
                        <li><a href="/member/myProject/myRequestList?cp=1${sURL}">&lt;&lt;</a></li>
                        <!-- 이전 목록 마지막 번호로 이동 -->
                        <li><a href="/member/myProject/myRequestList?cp=${pagination.prevPage}${sURL}">&lt;</a></li>
                        <!-- 특정 페이지로 이동 -->
                        <c:forEach var="countPage" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                          <c:choose>
                              <c:when test="${countPage== pagination.currentPage}">
                              <!-- 현재 페이지인 경우 -->
                              <li><a class="current">${countPage}</a></li>
                              </c:when>
                              <c:otherwise>
                              <!-- 현재 페이지를 제외한 나머지 -->
                              <li><a href="/member/myProject/myRequestList?cp=${countPage}${sURL}">${countPage}</a></li>
                              </c:otherwise>
                          </c:choose>
                        </c:forEach>
                        <!-- 다음 목록 시작 번호로 이동 -->
                        <li><a href="/member/myProject/myRequestList?cp=${pagination.nextPage}${sURL}">&gt;</a></li>
                        <!-- 끝 페이지로 이동 -->
                        <li><a href="/member/myProject/myRequestList?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
                    </ul>
                </div>
            </c:if>

          </div>
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->

  </main>
  <!-- **************************************footer*************************************-->

  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

  <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
  <script src="/resources/js/myProject/myProject_user/myProjectList.js"></script> 
</body>
</html>