package com.manager.freelancer.manager.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectRequest {
	
	private int projectRequestNo;
	private String projectRequestTitle;
	private String projectRequestSummary;
	private String projectRequestContent;
	
	private int projectRequestStatus;
	private String projectRequestStatusString;
	
	private int projectRequestBudget;
	private String requestRecruitDate;
	private String requestWorkDate;
	private int projectWorkPeriod;
	private int MemberNo;
	private String MemberName;

}
