package com.manager.freelancer.common.message.model.vo;

import java.util.List;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberReport {
	private int reportNo;                   		//REPORT_NO
	private int membeReportNo;                   		//REPORT_NO
	private String memberReportTitle;             	//MEMBER_REPORT_TITLE
	private String memberReportContent;           	//MEMBER_REPORT_CONTENT
	private String memberReportRequest;           	//MEMBER_REPORT_REQUEST
	private String memberReportRequestStatus;           	//MEMBER_REPORT_REQUEST
	private String memberReportCreateDate;        	//MEMBER_REPORT_CREATE_DATE
	private String memberReportCreateDateString;  	//MEMBER_REPORT_CREATE_DATE
	private int memberReportNo;    					//REPORT_MEMBER
	private int memberReportedNo;    					//REPORTED_MEMBER
	private String memberReportAnswerDate;        	    //MEMBER_REPORT_ANSWER_DATE
	private String memberReportAnswerDateString;        //MEMBER_REPORT_ANSWER_DATE
	private int memberReportAnswerMemberNo;             //MEMBER_REPORT_ANSWER_MEMBER_NO
	private String memberNickname;             //MEMBER_REPORT_ANSWER_MEMBER_NO
	private String managerNickname;             //MEMBER_REPORT_ANSWER_MEMBER_NO
	private String managerProfile;             //MEMBER_REPORT_ANSWER_MEMBER_NO
	private int managerNo;             //MEMBER_REPORT_ANSWER_MEMBER_NO
	
	private List<MemberReportFile> fileList; 
}