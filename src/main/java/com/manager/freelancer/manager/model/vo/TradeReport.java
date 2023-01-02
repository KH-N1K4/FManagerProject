package com.manager.freelancer.manager.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TradeReport {
	
	private int tradeReportNo;
	private int tradeNo;
	private int tradeReportMemberNo;
	private int tradeReportedMemberNo;
	private String tradeReportContent;
	private String tradeReportFilePath;
	private String tradeReportCreateDate;
	private String refundFlag;
	

}
