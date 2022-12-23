package com.manager.freelancer.freelancer.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Freelancer {

	private int freelancerNo; 				// 프리랜서 번호
	
	private int gradeNo;				// 등급번호
	private int regionNo;				// 지역이름
	private int mainCategoryNo; 			// 전문분야  이거 불확실.. String freelancerField?
	private int freelancerPeriod; 			// 총 경력기간
	private int contactTime1;				// 연락가능시간 시작
	private int contactTime2;				// 연락가능시간 끝
	private String bankName;				// 은행 이름
	private int    bankAccountNumber;		// 은행 이름
	private String freelancerIntroduction;	// 자기소개
	
	// 경력사항 부분
	private int careerNo;
	private char careerFlag; 				// 경력사항 유무
	private String careerCompanyName; 		// 회사명
	private String careerCompanyDepartment; // 근무부서
	private String careerCompanyPosition; 	// 직위
	private String careerCompanyRegion; 	// 근무지
	private String careerPeriod; 			// 근무기간
	
	// 자격증 부분
	private int licenseNo;  				// 자격증 번호
	private String licenseName;				// 자격증 이름
	private String licenseDate;				// 자격증 발급일
	private String licenseAgency;			// 자격증 발급 기관
	
	
}
