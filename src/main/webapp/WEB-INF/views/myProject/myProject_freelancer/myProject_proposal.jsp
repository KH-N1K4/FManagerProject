<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<c:set var="maincategory" value="${maincategoryList}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>보낸 제안</title>
    <link rel="stylesheet" href="/resources/css/myProject/myProject_freelancer/myProject_proposal.css">    
</head>
<body>
    <!-- hearder -->
    <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myProject_header2.jsp"/>
    <!-- hearder -->
    <%-- 검색을 진행한 경우 --%>
    <c:if test="${not empty param}">
        <c:forEach var="parameter" items="${param}">
            <c:if test="${parameter.key != 'cp'}">
            
                <c:set var="sURL" value="${sURL}&${parameter.key}=${parameter.value}"/>
            </c:if>
        </c:forEach>
    </c:if>

    <div class="main">

        <!-- sideMenu -->
        <jsp:include page="/WEB-INF/views/myProject/myProject_freelancer/myProjectSide2.jsp"/>
        <!-- sideMenu -->

        <section class="mainMenu">
            <div id="titleSection">
                <div id="title">보낸 제안</div>
                <div id="titleSelect">
                    <form action ="/member/myProject/freelancer/myProposal" class="OptionfrmSearch" method="get" name="OptionfrmSearch" id="OptionfrmSearch">
                        <select  id = "srchOption1" class="srchOption box" name="mainCategoryNo" title="${mainCategoryNoInput}">
                            <option value="0" selected="">전체</option>
                            <c:if test="${not empty maincategory}">
                                <c:forEach items="${maincategory}" var="mainVar">
                                    <option value="${mainVar.mainCategoryNo}">${mainVar.mainCategoryName}</option>
                                </c:forEach> 
                            </c:if>
                        </select>
                    </form>
                </div>
            </div>
            <c:if test="${not empty myProposal}">
                <c:forEach items="${myProposal}" var="proposal">
                    <div id="contentSection">
                        <div id="proposalImage">
                            <img src="${proposal.projectRequestfile}" alt="">
                        </div>
                        <div id="proposalContent">
                            <div id="proposalTitle"><!-- ${proposal.proposalAdoptStatusString} --><c:choose>
                                    <c:when test="${proposal.proposalAdoptStatus == 1}">
                                        <a href="#" id="proposalName" class="proposalName" suggestionName="">${proposal.projectRequestTitle}</a>
                                    </c:when>
                                    <c:otherwise>
                                        <span id="proposalName" class="proposalName" suggestionName="">${proposal.projectRequestTitle}</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div id="proposalSummary">
                                <p>${proposal.projectRequestSummary}</p>
                            </div>
                            <div class="detail">
                                <div id="proposalCategory">
                                    <div>모집분야</div>
                                    <div>${proposal.mainCategotyName} > ${proposal.thirdCategotyName}</div>
                                </div>
                                <div id="proposalBubget">
                                    <div>예산</div>
                                    <div>${proposal.projectRequestBudgetString}원</div>
                                </div>
                                <div id="proposalEndDate">
                                    <div>모집 마감</div>
                                    <div>${proposal.projectRecruitDate}</div>
                                </div>
                            </div>
                            
                        </div>
                        <div id="proposalStatus">
                            <div>${proposal.proposalAdoptStatusString}</div><!-- 대기중 -->
                        </div>
                    </div>
                </c:forEach> 
            </c:if>
            <c:if test="${listCount != 0}">
                
                <div class="pagination-area">


                    <ul class="pagination">
                    
                        <!-- 첫 페이지로 이동 -->
                        <li><a href="/member/myProject/freelancer/myProposal?cp=1${sURL}">&lt;&lt;</a></li>
        
                        <!-- 이전 목록 마지막 번호로 이동 -->
                        <li><a href="/member/myProject/freelancer/myProposal?cp=${pagination.prevPage}${sURL}">&lt;</a></li>
        
            
                        <!-- 특정 페이지로 이동 -->
                        <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                        <c:choose>
                            <c:when test="${i== pagination.currentPage}">
                            <!-- 현재 페이지인 경우 -->
                            <li><a class="current">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                            <!-- 현재 페이지를 제외한 나머지 -->
                            <li><a href="/member/myProject/freelancer/myProposal?cp=${i}${sURL}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                        </c:forEach>
                        <!-- 다음 목록 시작 번호로 이동 -->
                        <li><a href="/member/myProject/freelancer/myProposal?cp=${pagination.nextPage}${sURL}">&gt;</a></li>
        
                        <!-- 끝 페이지로 이동 -->
                        <li><a href="/member/myProject/freelancer/myProposal?cp=${pagination.maxPage}${sURL}">&gt;&gt;</a></li>
        
                    </ul>
                </div>
            </c:if>
            
        </section>
        
    </div>
    <!-- **************************************footer*************************************-->
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    <!-- **************************************footer*************************************-->
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

    <script src="/resources/js/myProject/myProject_freelancer/myProject_proposal.js"></script>

</body>
</html>