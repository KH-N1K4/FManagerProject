package com.manager.freelancer.category.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Service {
	private int mainCategoryNo;			//MAIN_CATEGORY_NO 메인 1카테고리
	private String mainCategoryName;	//MAIN_CATEGORY_NAME 메인 1카테고리 이름
	private int subCategoryNo;			//SUB_CATEGORY_NO 메인 2카테고리
	private String subCategoryName;		//SUB_CATEGORY_NAME 메인 2카테고리 이름
	private int thirdCategoryNo;		//THIRD_CATEGORY_NO 메인 3카테고리
	private String thirdCategoryName;	//THIRD_CATEGORY_NAME 메인 3카테고리 이름
	
	private int serviceNo;				//SERVICE_NO 서비스 번호 SEQUENCE: SEQ_SERVICE_NO
	private String serviceTitle;		//SERVICE_TITLE 서비스 제목
	private String serviceSummary;		//SERVICE_SUMMARY 서비스 한 줄 요약
	private String serviceContent;		//SERNICE_CONTENT 서비스 내용
	private int servicePrice;			//SERVICE_PRICE 서비스 가격
	private String servicePriceString;	//SERVICE_PRICE_STRING 서비스 가격
	private int serviceEditNum;			//SERVICE_EDIT_NUM 서비스 수정 횟수
	private int serviceWorkPeriod;		//SERVICE_WORK_PERIOD 서비스 작업 일수
	private String serviceCreateDate;	//SERVICE_CREATE_DATE 서비스 등록일
	
	
	private String serviceDeleteFL;	
	
	private String requestFilePath;	
	private String memberName;
	private String memberProfile;
	private int freelancerNo;
	private String likeCheckFL;
	
	private List<ImageFile> imageFileList;
	private List<Review> reviewList;
	
	
}
