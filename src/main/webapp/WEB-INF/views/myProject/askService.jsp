<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <link rel="stylesheet" href="/resources/css/myProject/askService.css">

    

<div class="ask_modal_body">
    	<span class="modal_close1">x</span>
   		<div id="askServiceMain">
	        <form action="/askService" method="POST">
	    
	        <div id="serviceSection">
	        <div id="servicePhoto"><img alt="" src="${fService.requestFilePath }" style="width:100%;"></div>
	            <div>
	
	                <div id="serviceContent"><span>${fService.serviceTitle }</span><br>
	                <span>${fService.serviceSummary }</span></div>
	               
	            
	            </div>
	        </div>
			<input type="hidden" name="serviceNo" id="serviceNo" value="${fService.serviceNo }"/>
	        <span>서비스 문의 남기기</span>
	        <textarea name="serviceInquiryContent" id="serviceInquiryContent" id="" cols="30" rows="10"></textarea>
	        <button>문의보내기</button>
	        </form>
 	  	</div>
    </div>

