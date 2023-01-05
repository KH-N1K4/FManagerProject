package com.manager.freelancer.myProject.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class myProjectTrade {
	
	private int tradeNo;			//TRADE_NO 거래 번호 SEQUENCE: SEQ_TRADE_NO
	private int memberDoneFL;		//MEMBER_DONE_FL 1:진행 중, 2: 작업 완료
	private int freelancerDoneFL;		//FREELANCER_DONE_FL 1:진행 중, 2: 작업 완료
	private int serviceNo;			//SERVICE_NO 서비스 번호(FK)
	private String serviceTitle;
	private int memberNo;			//MEMBER_NO 회원 번호-의뢰인(FK)
	private String memberName;			//MEMBER_NO 회원 번호-의뢰인(FK)
	private int freelancerNo;
	private String freelancerName;
	
	private int workNo;				//WORK_NO 작업물 번호 SEQUENCE: SEQ_WORK_NO
	private String workSendDate;	//WORK_SEND_DATE 작업물 발송 날짜
	
	private String workProgress;
	private int workStatus;
	private int workCount;
	private int serviceEditNum;

	private String seviceDeleteFlag;
	private int serviceStatus;
	
	
	private int mainCategoryNo;
	private int subCategoryNo;
	private int thirdCategoryNo;
	
	private int reviewCount;
	
	
}
