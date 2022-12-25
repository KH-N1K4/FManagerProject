package com.manager.freelancer.myProject.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class FreelancerService {
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
	private int serviceStatus;			//SERVICE_STATUS 1:승인 대기 중, 2:판매 중, 3:미승인, 4:판매 중지,5: 의뢰용일회성서비스
	private String serviceStatusString;	//SERVICE_STATUS_STRING 1:승인 대기 중, 2:판매 중, 3:미승인, 4:판매 중지,5: 의뢰용일회성서비스
	private String serviceCreateDate;	//SERVICE_CREATE_DATE 서비스 등록일

	private int serviceFileNo;			//REQUEST_FILE_NO 서비스 첨부파일 번호 SEQUENCE: SEQ_SERVICE_FILE_NO
	private String serviceFilePath2;	//REQUEST_FILE_PATH 서비스 첨부파일 경로
	
	private List<myProjectServiceInquiry> inquiryList; 		//서비스 문의 리스트
	private List<myProjectTrade> tradeList; 				//서비스 거래번호
	
	//거래내역
	private int tradeNo;					//TRADE_NO 거래 번호 SEQUENCE: SEQ_TRADE_NO
	private int memberDoneFL;				//MEMBER_DONE_FL 1:진행 중, 2: 작업 완료
	private int freelancerFL;				//FREELANCER_DONE_FL 1:진행 중, 2: 작업 완료
	private String freelancerFLString;		//FREELANCER_DONE_FL_STRING 1:진행 중, 2: 작업 완료
	//private int serviceNo;				//SERVICE_NO 서비스 번호(FK)
	private int memberNo;					//MEMBER_NO 회원 번호-의뢰인(FK)
	private String memberName;				//MEMBER_NAME 
	private String memberNickName;			//MEMBER_NICKNAME 
	private int freelancerNo;
	private String freelancerNickName;
	private int workCount;       			//WORK_COUNT 발송물 발송 횟수
	
	//거래 작업물 발송
	private int workNo;						//WORK_NO 작업물 번호 SEQUENCE: SEQ_WORK_NO
	private String workSendDate;			//WORK_SEND_DATE 작업물 발송 날짜
		
	//서비스 문의 내역 들고 오기
	private int serviceInquiryNo;			//SERVICE_INQUIRY_NO 서비스 문의 번호 SEQUENCE: SEQ_SERVICE_INQUIRY_NO
	private String serviceInquiryContent;	//SERVICE_INQUIRY_CONTENT 서비스 문의 내용
	private String serviceInquiryDate;		//SERVICE_INQUIRY_CREATE_DATE 서비스 문의 작성 날짜
}
