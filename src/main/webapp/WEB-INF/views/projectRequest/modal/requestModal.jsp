<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

    <link rel="stylesheet" href="/resources/css/category/modal/requestModal.css">

    

<div class="requestModal_body">
		<span class="requestModal_close">x</span>
		<div id="requestModalMain">
					<div id="userSection">
						<div id="userPhoto"><img alt="" src="${loginMember.memberProfile}">
						</div>
						<div  class="userContentBox">
							<div id="userTitle">
								<span>${userRequest.projectRequestTitle}</span>
							</div>
							<div class="userContent">
								<span>${loginMember.memberNickname}</span>
							</div>
							<div class="userContent">
								<div>
									<span>총 작업수</span>
									<span>${freelancerSalesCount.gradeSaleCount}</span>
								</div>
								<div>
									<span>등급</span>
									<span>${freelancerInfo.gradeName}</span>
								</div>
							</div>
							<div class="userContent">
								<div>
									<span>전문분야</span>
									<span>
										<!-- ${freelancerSalesCount.fieldList} -->
										<c:forEach var="fieldListVal" items="${fieldList}">
											${fieldListVal.mainCategoryName}
										</c:forEach>
									</span>
								</div>
							</div>
						</div>
					</div>
					<span>제안하기</span>
					<div class="proposalContent">
						<div><span>수정 횟수:</span><input type="number" id="proposalEditInput" required></input ></div>
						<div><span>제안 가격:</span><input id="proposalpriceInput" type="text" placeholder="금액 입력" required></input>원</div>
					</div>
					<button id ="sendRequestBtn">제안보내기</button>
		</div>
</div>

