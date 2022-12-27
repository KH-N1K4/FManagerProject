package com.manager.freelancer.myProject.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class myProjectServiceInquiry {
	
	private int serviceInquiryNo;			//SERVICE_INQUIRY_NO 서비스 문의 번호 SEQUENCE: SEQ_SERVICE_INQUIRY_NO
	private String serviceInquiryContent;	//SERVICE_INQUIRY_CONTENT 서비스 문의 내용
	private String serviceInquiryDate;		//SERVICE_INQUIRY_CREATE_DATE 서비스 문의 작성 날짜
	private int memberNo;					//MEMBER_NO 작성 회원 번호(FK)
	private int serviceNo;					//SERVICE_NO 서비스 번호(FK)
	
	private int serviceFileNo;			//REQUEST_FILE_NO 서비스 첨부파일 번호 SEQUENCE: SEQ_SERVICE_FILE_NO
	private String serviceFilePath;		//REQUEST_FILE_PATH 서비스 첨부파일 경로

}
