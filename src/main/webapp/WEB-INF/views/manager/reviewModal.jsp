<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<link rel="stylesheet" href="/resources/css/manager/reviewModal.css">



	<div class="modalMain">
        <div class="x">&times;</div>
        <div class="tradeInfoArea">
            <div>
                <div class="infoTitle">작업 시작일</div>
                <div id="tradeDate"></div>
            </div>
            <div>
                <div class="infoTitle">작업 기간</div>
                <div><span id="workPeriod"></span> <span class="bold">일</span></div>
            </div>
            <div>
                <div class="infoTitle">수정 횟수</div>
                <div><span id="workEditNum"></span> <span class="bold"> / </span> <span id="serviceEditNum"></span></div>
            </div>
            <div>
                <div class="infoTitle">취소 문의일</div>
                <div id="cancaleInquiryDate"></div>
            </div>
        </div>
        <form action="/manager/settlement/refund" method="GET" id="refundFrm">
            <div class="selectPercent">
                <div class="refundPercent">의뢰인 환불 금액</div>
                <div>
                    <select class="refund-select-input" name="refundPercent" id="selectRefundPercent">
                        <option value="0">0%</option>
                        <option value="30">30%</option>
                        <option value="70">70%</option>
                        <option value="100">100%</option>
                    </select>
                </div>
            </div>
            <div class="btnArea">
                <button class="modalBtn">환불</button>
                <button type="button" class="modalBtn modalClose">취소</button>
            </div>
        </form>
	</div>