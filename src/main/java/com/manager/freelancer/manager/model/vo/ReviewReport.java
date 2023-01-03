package com.manager.freelancer.manager.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewReport {
	private int reviewReportNo;
	private int reviewNo;
	private String reviewContent;
	private String reviewImage;
	private int reviewPoint;
	private String reviewDeleteFlag;
	private int memberNo;
	private String memberName;
}
