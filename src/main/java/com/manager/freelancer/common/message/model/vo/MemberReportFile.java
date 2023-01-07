package com.manager.freelancer.common.message.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberReportFile {
	private int memberReportfileNo;         //MEMBER_REPORT_FILE_NO
	private String memberReportfilePath; 	//MEMBER_REPORT_FILE_PATH
	private int memberReportfileOther; 		//MEMBER_REPORT_FILE_ORDER
	private int reportNo;		        //MEMBER_REPORT_NO
}
