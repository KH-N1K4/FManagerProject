package com.manager.freelancer.manager.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Settlement {

	private int settlementNo;
	private int tradeNo;
	private int workStatus;
	private String workStatusString;
	private int paymentType;
	private String paymentTypeString;
	private String paymentDate;
	private String paymentPrice;
	
	private String serviceTitle;
	private String userName;
	
	private int reportCount;
}
