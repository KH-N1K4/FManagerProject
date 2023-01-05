<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <link rel="stylesheet" href="/resources/css/category/modal/requestModal.css">

    

<div class="requestModal_body">
		<span class="requestModal_close">x</span>
		<div id="requestModalMain">
					<div id="userSection">
						<div id="userPhoto"><img alt="" src="${loginMember.memberProfile}" style="width:100%;">
						</div>
						<div>
							<div id="userContent">
								<span>${loginMember.memberNickname}</span>
							</div>
							<div id="userContent">
								<div>
									<span>총 작업수</span>
								</div>
								<div>
									<span>등급</span>
								</div>
							</div>
							<div id="userContent">
								<div>
									<span>전문분야</span>
								</div>
							</div>
						</div>
					</div>
					<input type="hidden" name="serviceNo" id="serviceNo" value=""/>
					<span>제안하기</span>
					<textarea name="serviceInquiryContent" id="serviceInquiryContent" id="" cols="30" rows="10"></textarea>
					<button>제안보내기</button>
		</div>
</div>

