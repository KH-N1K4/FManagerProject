package com.manager.freelancer.manager.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TradeInfo {
	private int tradeNo;				// 거래번호
	private String tradeDate;			// 거래날짜 (=작업 시작일)
	private int workPeriod;				// 작업 기간
	private int serviceEditNum;			// 최대 수정횟수
	private int workEditNum;			// 지금까지 수정 횟수
	private String cancelInquiryDate;	// 취소문의 날짜
	
}
