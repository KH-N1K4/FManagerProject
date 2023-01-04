package com.manager.freelancer.myProject.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class myProjectFreelancer {
	
	private int freelancerNo;				//FREELANCER_NO 프리랜서 번호(PK+FK(회원번호))
	private int freelancerPeriod;			//FREELANCER_PERIOD 프리랜서 기간
	private int freeContactSTime;			//FREE_CONTACT_TIME1 연락가능시간시작
	private int freeContactEndTime;			//FREE_CONTACT_TIME2 연락가능시간끝
	private String FreelancerIntroduction;	//FREELACER_INTRODUCTION 프리랜서 자기소개
	private int regionNo;					//REGION_NO 지역 번호(FK)
	private int gradeNo;					//GRADE_NO 등급 번호(FK)
	
	private String gradeName;				//GRADE_NAME 등급 이름
	private float gradeSatisfaction;			//SATISFACTION 만족도
	private int gradeInquityRate;			//INQUIRY_RATE 메세지 응답률
	private int gradeCompletionRate;		//COMPLETION_RATE 작업일 준수율
	private int gradeSaleProceeds;			//SALE_PROCEEDS 누적 판매 금액
	private String gradeSaleProceedsString;			//SALE_PROCEEDS 누적 판매 금액
	private int gradeSaleCount;				//SALE_COUNT 누적 판매 건수
}
