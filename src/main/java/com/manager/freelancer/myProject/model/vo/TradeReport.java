package com.manager.freelancer.myProject.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TradeReport {
	
	private int tradeReportNo;
	private int tradeNo;
	private int reportPersonNo;
	private String reportPersonName;
	private int reportedPersonNo;
	private String reportContent;
	private String filePath;

}
