package com.manager.freelancer.myProject.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class myProjectFreelancerProfit {
		private int settlementNo;		//SETTLEMENT_NO 거래 내역 번호 SEQUENCE: SEQ_SETTLEMENT_NO
		private int paymentType;		//PAYMENT_TYPE 거래 종류(1:입금, 2:출금, 3:환불)
		private int userNo;				//USER_NO 거래 회원 번호 
										//--3: 수익 내역은 거래 회원 번호가 내번호랑 일치하는 것중에서 출금인거 다 들고 오면 됨(정산된 수익)*****
		
		private int workStatus;			//WORK_STATUS 1: 진행중, 2: 정산 완료, 3:환불 완료, 4:마감  
										//--2. 입금된거 중에서 진행중이면 예상수익 / 정산완료,진행중 총수익*****
		
		private String paymentDate;		//PAYMENT_DATE 거래 날짜
		private String paymentDateString;		//PAYMENT_DATE 거래 날짜
		private int paymentPrice;		//PAYMENT_PRICE 거래 금액
		private int profitType;		//1. 총수익 2. 정산예정 금액
		private String paymentPriceString;		//PAYMENT_PRICEString 거래 금액
		private int tradeNo;			//TRADE_NO 거래 번호(FK) 
										//-- 1. 내 서비스 등록 가져오기 *****
		
		private int serviceNo;           //"SERVICE_NO"서비스 번호 
		private int servicePrice;           //"SERVICE_PRICE"서비스 번호 
		private String servicePriceString;        //"SERVICE_PRICE_STRING"서비스 가격 
		private int freelancerNo;        //"FREELANCER_NO"전문가 번호
		private int num;        //행 번호
}
