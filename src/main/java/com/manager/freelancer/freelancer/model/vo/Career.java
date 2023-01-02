package com.manager.freelancer.freelancer.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Career {

	
private String career; // input값 전체 받을 부분
	
	private int careerNo; // 시퀀스
	
	private char careerFlag; 				// 경력사항 유무
	private String careerCompanyName; 		// 회사명
	private String careerCompanyDepartment; // 근무부서
	private String careerCompanyPosition; 	// 직위
	private String careerCompanyRegion; 	// 근무지
	private String careerCompanyPeriod1; 			// 근무기간(년)
	private String careerCompanyPeriod2; 			// 근무기간(월)
	
	private String careerCompantPeriod; // 년(update용)
	
	private int freelancerNo; 				// 프리랜서 번호

}
