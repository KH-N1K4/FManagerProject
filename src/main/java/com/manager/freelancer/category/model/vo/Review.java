package com.manager.freelancer.category.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {
	private int reviewNo;
	
	private String reviewContent;
	private String reviewFilePath;
	private int reviewPoint;
	private String freelancerName;
	private String memberName;
	private String reviewCommentContent;
	private String reviewCreateTime;
	private String reviewCommentCreateTime;
	
	private int serviceNo;
	
}
