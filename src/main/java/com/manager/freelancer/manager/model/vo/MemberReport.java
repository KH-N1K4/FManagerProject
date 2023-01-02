package com.manager.freelancer.manager.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberReport {
	
	private int memberReportNo;
	private String memberReportTitle;
	private String memberReportContent;
	private String memberReportRequest;
	private String memberReportCreateDate;
	private int reportMemberNo;
	private int reportedMemberNo;
	private String reportMemberName;
	private String reportedMemberName;
	private String memberReportAnswerDate;
	private int memberReportAnswerMemberNo;
	
	private String reportStatus;
	
	List<MemberReportImage> reportImageFileList;

}
