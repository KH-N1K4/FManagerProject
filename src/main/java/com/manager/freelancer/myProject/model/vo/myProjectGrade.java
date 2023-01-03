package com.manager.freelancer.myProject.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class myProjectGrade {
	
	private int allGradeNo;			//GRADE_NO 등급 번호
	private String allGradeName;	//GRADE_NAME 등급 이름
	private float allSatisfaction;	//SATISFACTION 만족도
	private int allInquiryRate;		//INQUIRY_RATE 메세지 응답률
	private int allCompletionRate;	//COMPLETION_RATE 작업일 준수율
	private int allSaleProceeds;	//SALE_PROCEEDS 누적 판매 금액
	private String allSaleProceedsString;	//SALE_PROCEEDS 누적 판매 금액
	private int allSaleCount;		//SALE_COUNT 누적 판매 건수
	
}
