package com.manager.freelancer.myProject.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class myProjectFreelancerRequest {//지윤
	
	private int projectRequestNo;				//PROJECT_REQUEST_NO 프로젝트 의뢰 번호 SEQUENCE: SEQ_PROJECT_REQUEST_NO
	private String projectRequestTitle;			//PROJECT_REQUEST_TITLE 프로젝트 의뢰 제목
	private String projectRequestSummary;		//PROJECT_REQUEST_SUMMARY 프로젝트 의뢰 요약
	private String projectRequestContent;		//PROJECT_REQUEST_CONTENT 프로젝트 의뢰 사항
	private int projectRequestBudget;			//PROJECT_REQUEST_BUDGET 프로젝트 의뢰 예산
	private String projectRequestBudgetString;			//PROJECT_REQUEST_BUDGET 프로젝트 의뢰 예산
	private String projectRecruitDate;			//REQUEST_RECRUIT_DATE 프로젝트 모집 마감일
	private String projectWorkDate;				//REQUEST_WORK_DATE 프로젝트 작업 마감일
	private int projectWorkPeriod;				//PROJECT_WORK_PERIOD 프로젝트 작업기간
	private String projectCreateDate;			//PROJECT_REQUEST_CREATE_DATE 프로젝트 의뢰 등록일
	private int mainCategotyNo;					//MAIN_CATEGORY_NO 카테고리1 번호(FK)
	private String mainCategotyName;			//MAIN_CATEGORY_NAME
	private int thirdCategotyNo;				//THIRD_CATEGORY_NO 카테고리3 번호(FK)
	private String thirdCategotyName;			//THIRD_CATEGORY_NAME 
	private int clientNo;						//MEMBER_NO 회원 번호(FK)-의뢰인 회원번호
	private String projectRequestfile;						//MEMBER_NO 회원 번호(FK)-의뢰인 회원번호
	
	private int proposalNo;						//PROJECT_PROPOSAL_NO 프로젝트 제안 번호 SEQUENCE :SEQ_PROJECT_PROPOSAL_NO
	private int proposalAdoptStatus;			//PROPOSAL_ADOPT_STATUS 프로젝트 채택 상태 1:대기중 2:채택 3: 모집마감
	private String proposalAdoptStatusString;	//PROPOSAL_ADOPT_STATUS_STRING
	private int proposalPrice;					//PROPOSAL_PRICE 프로젝트 제안 가격
	private String proposalPriceString;			//PROPOSAL_PRICE_STRING
	private int proposalEditNum;				//PROPOSAL_EDIT_NUM 프로젝트 수정 횟수
	private String proposalCreateDate;			//PROPOSAL_CREATE_DATE 프로젝트 제안 등록일
	private int freelancerNo;					//FREELANCER_NO 프리랜서 번호(FK)
	
	
}
