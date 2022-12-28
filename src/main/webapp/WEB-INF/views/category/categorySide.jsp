<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 


    	<c:set var="path" value="${requestScope['javax.servlet.forward.servlet_path']}" /> 
    	<c:set var="mainCategoryNo" value="${fn:split(path, '/')}" />
    	<c:set var="currentCategoryNo" value="${mainCategoryNo[fn:length(mainCategoryNo)-1]}" />
		
		 <c:forEach var="boardType" items="${boardTypeList}">
            <c:if test="${currentCategoryNo eq boardType.MAIN_CATEGORY_NO}">
                <c:set var="currentCategoryName" value="${boardType.MAIN_CATEGORY_NAME}" />
         	</c:if>
         </c:forEach>
		 
		
        <div class="sideMenu">
        	<div id="design">${currentCategoryName }</div>
         <c:forEach var="subCategory" items="${subCategoryList }">
         	<c:if test="${currentCategoryNo eq subCategory.MAIN_CATEGORY_NO}">
	         	<ul>
	         	<!-- 두번째 카테고리 a태그 없애고 category/메인/마지막 으로 되게? -->
	                <li id="subCategori"><a href="/category/${currentCategoryNo}/${subCategory.SUB_CATEGORY_NO}">${subCategory.SUB_CATEGORY_NAME}</a><button>▼</button></li>
	                
	                <ul id="thirdCategory">
	                	 <c:forEach var="thirdCategory" items="${thirdCategoryList }">
		                	 <c:if test="${subCategory.SUB_CATEGORY_NO eq thirdCategory.SUB_CATEGORY_NO}">
		                		<li id="thirdCategory"><a href="/category/${currentCategoryNo}/${subCategory.SUB_CATEGORY_NO}/${thirdCategory.THIRD_CATEGORY_NO}">${thirdCategory.THIRD_CATEGORY_NAME}</a></li>
		                	</c:if>
	                	</c:forEach>
	                </ul>
	            </ul>
         	</c:if>
         </c:forEach>
      
       </div>
       
      
        