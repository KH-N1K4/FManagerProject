package com.manager.freelancer.freelancer.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Freelancer {

	private int freelancerNo; 				// 프리랜서 번호
	
	private int gradeNo;					// 등급번호
	private int regionNo;					// 지역이름(번호)
	private String regionName;
	private String mainCategoryNo;//int->String 			// 전문분야  이거 불확실.. String freelancerField?
	private int freelancerCont; 			// 총 경력기간
	private int contactTime1;				// 연락가능시간 시작
	private int contactTime2;				// 연락가능시간 끝
		
	private String freelancerIntro;			// 자기소개
	
	//학력 전공부분
	private String major; // input값 전체 받을 부분
	
	private int majorStatus;// input의 hidden값(재학상태, 숫자)
	private String majorAcademyName;
	private String majorName;
	private int majorGraduateStatus;
	
	
	// 경력사항 부분
	private String career; // input값 전체 받을 부분
	
	private int careerNo;
	private char careerFlag; 				// 경력사항 유무
	private String careerCompanyName; 		// 회사명
	private String careerCompanyDepartment; // 근무부서
	private String careerCompanyPosition; 	// 직위
	private String careerCompanyRegion; 	// 근무지
	private String careerPeriod; 			// 근무기간
	
	// 자격증 부분
	private String license; // input값전체 받을 부분
	
	private int licenseNo;  				// 자격증 번호
	private String licenseName;				// 자격증 이름
	private String licenseDate;				// 자격증 발급일
	private String licenseAgency;			// 자격증 발급 기관
	
	private String bankName; // 은행 이름
	private int bankCode; // 은행 이름
	private long bankAccountNumber; // 은행 계좌번호
	
	//프리랜서 전문분야
	private String freelancerField;
	
	// 포트폴리오
	private int portfolioNo;
	private String portfolioTitle;
	private String portfolioContent;
	private String portfolioFilePath;
}
