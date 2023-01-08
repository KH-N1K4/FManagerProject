<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<c:set var="maincategory" value="${maincategoryList}"/>
<c:set var="category" value="${categoryList}"/>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>myProject_add</title>

  <link rel="stylesheet" href="/resources/css/myProject/myProject_user/myProject_add.css">
</head>
<body>
  <main>
    <!-- hearder -->
    <%-- <jsp:include page="/WEB-INF/views/myProject/myProject_header.jsp"/> --%>
    <jsp:include page="/WEB-INF/views/common/header_ver2.jsp"/>

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
                <!-- 상단 내프로젝트 페이지 제목 -->
                <div class="container_title"><span>내 프로젝트 등록</span></div>
                <!-- 상단 내프로젝트 페이지 제목 -->
            </div>
            <!--  -->
            <br><br>
<%-- 폼태그 --%>
            <form action ="/myProject/user/myProjectInsert" class="projectRequestfrm" method="POST" name="projectRequestfrm" id="projectRequestfrm" enctype="multipart/form-data">
              <div class="container_myProjectadd">
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>카테고리</span></div>
                  <div class="list_content">
                    <div class="selectbox">
                      <select  id = "srchOption1" class="srchOption box" name="mainCategoryNo" >
                        <option value="" selected="">전체</option>
                        <c:if test="${not empty maincategory}">
                          <c:forEach items="${maincategory}" var="mainVar">
                            <option value="${mainVar.mainCategoryNo}">${mainVar.mainCategoryName}</option>
                          </c:forEach> 
                        </c:if>
                      </select>
                    </div>
                    <div class="selectbox"> 
                      <select  id = "srchOption3" class="srchOption box" name="thirdCategoryNo" required>
                        <option value="" selected="" disabled>전체</option>
                        <c:if test="${not empty category}">
                          <c:forEach items="${category}" var="cateVar">
                            <option value="${cateVar.thirdCategoryNo}" mainNo="${cateVar.mainCategoryNo}">${cateVar.thirdCategoryName}</option>
                          </c:forEach> 
                        </c:if>
                      </select>
                    </div>
                  </div>
                </div>
                <br>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>제목</span></div>
                  <div class="list_content">
                    <input type="text" class="inputBoxSize box" name="projectRequestTitle" id="projectRequestTitle">
                  </div>
                </div>
                <br>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>의뢰 한줄요약</span></div>
                  <div class="list_content">
                    <input class="projectRequestOnecontent projectRequestContent box" name="projectRequestSummary" id="projectRequestSummary">
                  </div>
                </div>
                <br>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>의뢰사항</span></div>
                  <div class="list_content">
                    <textarea class="projectRequestTotalContent projectRequestContent box" name="projectRequestContent" id="projectRequestContent"></textarea>
                  </div>
                </div>
                <br>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>첨부파일</span></div>
                  <div class="list_content"><input type = "file" name="myProjectFile" id="myProjectFile"></div>
                  <div class="list_content"><input type = "file" name="myProjectFile" id="myProjectFile2"></div>
                </div>
                <br>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>예산</span></div>
                  <div class="list_content">
                    <input type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" 
                          class="budget box" name="projectRequestBudget" placeholder="예산 금액" maxlength="30" autocomplete="off" value="" id="budget"><span>원</span>
                  </div>
                </div>
                <br>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>모집마감일</span></div>
                  <div class="list_content"><input type="date" class="Date recruitEndDate box" name="projectRecruitDate" id="recruitEndDateInput"></div>
                </div>
                <br>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>작업마감일</span></div>
                  <div class="list_content"><input type="date" class="Date workEndDate box" name="projectWorkDate" id="workEndDateInput"></div>
                </div>
                <br>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>작업기간</span></div>
                  <div class="list_content">
                    <select  id = "dateOption" class="dateOption box" name="projectWorkPeriod" >
                      <option value="1" selected="">1일</option><!-- 나중에 for문 돌리자 -->
                      <c:forEach var="i" begin="2" end="90" step="1">
                        <option value="${i}">${i}일</option>
                      </c:forEach>
                    </select>
                  </div>
                </div>
              </div>
              <br><br>
              <div class="buttonArea">
                <button type="submit" class="submitButton">등록</button>
              </div>
            </form>
<%-- 폼태그 --%>
          </div>
        </section>
        <!-- sideMenu를 제외한 메인 내용 -->
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
  </main>

 
  <!-- **************************************footer*************************************-->
  <script>
    var maincategoryList1 = "${maincategoryList}";
    var categoryList1 = "${categoryList}";
    var list = JSON.parse('${GsoncategoryList}');
    const listSize = "${categoryList.size()}";
  </script>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
  <script src="/resources/js/myProject/myProject_user/myProjectInsert.js"></script> 

</body>
</html>