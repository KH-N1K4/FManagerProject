<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<link rel="stylesheet" href="/resources/css/manager/refundModal.css">



	<div class="modalMain">
        <div class="tradeInfoArea">
            <div>
                <div class="infoTitle">작업 시작일</div>
                <div>2022-10-10</div>
            </div>
            <div>
                <div class="infoTitle">작업 기간</div>
                <div>30 <span>일</span></div>
            </div>
            <div>
                <div class="infoTitle">수정 횟수</div>
                <div>2 <span> / </span> 4</div>
            </div>
            <div>
                <div class="infoTitle">취소 문의일</div>
                <div>2022-10-20</div>
            </div>
        </div>
        <form action="/manager/settlement/refund" method="GET" id="">
            <div class="selectPercent">
                <div class="refundPercent">의뢰인 환불 금액</div>
                <div>
                    <select class="refund-select-input" name="refundPercent" id="selectRefundPercent">
                        <option value="0">0%</option>
                        <option value="0.3">30%</option>
                        <option value="0.7">70%</option>
                        <option value="1">100%</option>
                    </select>
                </div>
            </div>
            <div class="btnArea">
                <button class="modalBtn">환불</button>
                <button type="button" class="modalBtn modalClose">취소</button>
            </div>
        </form>
	</div>