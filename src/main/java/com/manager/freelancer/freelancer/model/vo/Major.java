package com.manager.freelancer.freelancer.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Major {

	private String major; // input값 전체 받을 부분
	
	private int majorNo;
	
	private String majorAcademyName;
	private String majorName;
	private int majorGraduateStatus;
	
	private int freelancerNo; 				// 프리랜서 번호

}
