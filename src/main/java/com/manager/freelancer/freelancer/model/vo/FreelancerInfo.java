package com.manager.freelancer.freelancer.model.vo;

public class FreelancerInfo {

	private int freelancerNo;
	private int memberNo;
	
	private int regionNo;
	private String freelancerIntro;
	private int freelancerPeriod;
	private int freeContactTime1;
	private int freeContactTime2;
	
	private int freelancerField; // 전문분야
	
	private String careerCompanyName; 		// 회사명
	private String careerCompanyDepartment; // 근무부서
	private String careerCompanyPosition; 	// 직위
	private String careerCompanyRegion; 	// 근무지
	private String careerCompanyPeriod; 	// 근무기간(년) + 월
	
	private String licenseName;				// 자격증 이름
	private String licenseDate;				// 자격증 발급일
	private String licenseAgency;			// 자격증 발급 기관
	
	private int bankCode; // 은행 이름
	private long bankAccountNumber; // 은행 계좌번호
}
