package com.manager.freelancer.category.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Trade {

	private int serviceNo;				//SERVICE_NO 서비스 번호 SEQUENCE: SEQ_SERVICE_NO
	private String serviceTitle;		//SERVICE_TITLE 서비스 제목
	private String serviceSummary;		//SERVICE_SUMMARY 서비스 한 줄 요약
	private String serviceContent;		//SERNICE_CONTENT 서비스 내용
	private int servicePrice;			//SERVICE_PRICE 서비스 가격
	private String requestFilePath;	
	
	
	private String memberName;
	private String memberProfile;
	private int freelancerNo;
	
	
	private int tradeNo;
	private int memberNo; // 주문자 번호

	private String tradeRequest;
	
	
}
