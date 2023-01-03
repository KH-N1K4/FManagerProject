package com.manager.freelancer.myProject.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyProject {

	// 카테고리  
	private int mainCategoryNo;			    // MAIN_CATEGORY_NO 메인 1카테고리
	private String mainCategoryName;	    // MAIN_CATEGORY_NAME 메인 1카테고리 이름
	private int subCategoryNo;			    // SUB_CATEGORY_NO 메인 2카테고리
	private String subCategoryName;		    // SUB_CATEGORY_NAME 메인 2카테고리 이름
	private int thirdCategoryNo;		    // THIRD_CATEGORY_NO 메인 3카테고리
	private String thirdCategoryName;	    // THIRD_CATEGORY_NAME 메인 3카테고리 이름
	
	// 프로젝트 의뢰 
	private int projectRequestNo;		    // PROJECT_REQUEST_NO 프로젝트 의뢰 번호
	private String projectRequestTitle;	    // PROJECT_REQUEST_TITLE 프로젝트 의뢰 제목
	private String projectRequestSummary;	// PROJECT_REQUEST_SUMMARY 프로젝트 의뢰 요약
	private String projectRequestContent;	// PROJECT_REQUEST_CONTENT 프로젝트 의뢰 내용
	private int projectRequestBudget;	    // PROJECT_REQUEST_BUDGET 프로젝트 의뢰 예산
	private String projectRecruitDate;	    // REQUEST_RECRUIT_DATE 프로젝트 모집 마감일
	private String projectWorkDate;	        // REQUEST_WORK_DATE 프로젝트 작업 마감일
	private String projectWorkPeriod;	    // PROJECT_WORK_PERIOD 프로젝트 작업 기간
	private String projectCreateDate;       // PROJECT_REQUEST_CREATE_DATE 프로젝트 의뢰 등록일
	private int memberNo;                   // MEMBER_NO 회원 번호
	private String projectRequestStatus;    // PROJECT_REQUEST_STATUS 프로젝트 의뢰 상태
	
	// 의뢰 첨부파일
	private int requestFileNo;		        // REQUEST_FILE_NO 프로젝트 첨부 파일 번호 
	private String requestFilePath;		    // REQUEST_FILE_PATH 프로젝트 첨부 파일 경로
	private int requestFileOrder;		    // REQUEST_FILE_ORDER 프로젝트 첨부 파일 순서
	
	// 프로젝트 제안 
	private int proposalNo;		            // PROJECT_PROPOSAL_NO 프로젝트 제안 번호 
	private String proposalAdoptStatus;		// PROPOSAL_ADOPT_STATUS 프로젝트 채택 상태
	private int proposalPrice;		        // PROPOSAL_PRICE 프로젝트 제안 가격
	private int proposalEditNum;		    // PROPOSAL_EDIT_NUM 프로젝트 수정 횟수
	private String proposalCreateDate;		// PROPOSAL_CREATE_DATE 프로젝트 제안 등록일
	private int freelancerNo;		        // FREELANCER_NO 프리랜서 번호
	private String freelancerName;		    // FREELANCER_NAME 프리랜서 이름
	private int gradeNo;		            // GRADE_NO 프리랜서 등급
	private String gradeName;		        // GRADE_NAME 프리랜서 등급명
	
	
	
	
}
