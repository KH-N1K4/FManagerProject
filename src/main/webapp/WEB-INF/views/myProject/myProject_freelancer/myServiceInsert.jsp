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
  <title>나의 서비스 등록</title>
  <link rel="stylesheet" href="/resources/css/myProject/myProject_freelancer/myServiceInsert.css">
</head>
<body>
  <main>
     <!-- hearder -->
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
                <!-- 상단 내프로젝트 페이지 제목 -->
                <div class="container_title"><span>나의 서비스</span></div>
                <!-- 상단 내프로젝트 페이지 제목 -->
            </div>
            <!--  -->
            <form action ="/myProject/freelancer/serviceInsert" class="projectRequestfrm" method="post" name="projectRequestfrm" id="projectRequestfrm" enctype="multipart/form-data">
              <div class="container_myProjectadd">
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>카테고리</span></div>
                  <div class="list_content">
                    <div class="selectbox">
                      <select  id = "srchOption1" class="srchOption box" name="mainCategoryNo">
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
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>제목</span></div>
                  <div class="list_content"><input type="text" class="inputBoxSize box" name="serviceTitle" maxlength="20" autocomplete="off" required></div>
                </div>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>한줄요약</span></div>
                  <div class="list_content"><textarea class="projectRequestOnecontent projectRequestContent box" id="projectRequestOnecontent" maxlength="50"  name="serviceSummary" required></textarea>
                  </div>
                </div>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>상세 설명</span></div>
                  <div class="list_content"><textarea class="projectRequestTotalContent projectRequestContent box" id="projectRequestTotalContent" maxlength="1300" name="serviceContent" required></textarea>
                  </div>
                </div>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>가격 정보</span></div>
                  <div class="list_content"><input type="number" id="budget" class="budget box" name="servicePrice" placeholder="서비스 금액" value="" required><span>원</span></div>
                </div>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>작업일 수</span></div>
                  <div class="list_content">
                    <select  id = "dateOption" class="dateOption box" name="serviceWorkPeriod" required>
                      <option value="1" selected="">1일</option><!-- 나중에 for문 돌리자 -->
                      <c:forEach var="i" begin="2" end="99" step="1">
                        <option value="${i}">${i}일</option>
                      </c:forEach>
                    </select>
                  
                  </div>
                </div>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>수정 횟수</span></div>
                  <div class="list_content">
                    <select  id = "dateOption" class="dateOption box" name="serviceEditNum" required>
                      <option value="1" selected="">1회</option><!-- 나중에 for문 돌리자 -->
                      <c:forEach var="i" begin="2" end="99" step="1">
                        <option value="${i}">${i}회</option>
                      </c:forEach>
                    </select>
                    
                  </div>
                </div>
                <div class="myProjectadd_info_list">
                  <div class="list_title"><span>첨부파일</span></div>
                  <div class="list_content">
                    <input type = "file" name="serviceFilePath" accept="image/*" required>
                  </div>
                  <div class="list_content">
                    <input type = "file" name="serviceFilePath" accept="image/*" multiple="multiple">
                  </div>
                </div>
                
              </div>
              <div class="buttonArea">
                <button type="submit" class="submitButton">등록</button>
              </div>
            </form>
          </div>
        </section>
        <!-- sideMenu를 제외한 메인 내용 multiple="multiple"-->
    </div>
    <!-- 화면 크기 width: 1200px로 고정 -->
  </main>

  <!-- **************************************footer*************************************-->
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  <!-- **************************************footer*************************************-->
  <script>
    var maincategoryList1 = "${maincategoryList}";
    var categoryList1 = "${categoryList}";
    var list = JSON.parse('${GsoncategoryList}');
    const listSize = "${categoryList.size()}";
  </script>

  <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

  <script src="/resources/js/myProject/myProject_freelancer/myServiceInsert.js"></script>

</body>
</html>

