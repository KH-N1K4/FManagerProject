package com.manager.freelancer.customerCenter.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInquiry {

	private int userInquiryNo;                      // 이용문의 번호 
	private String userInquiryTitle;                // 이용문의 제목 
	private String userInquiryContent;              // 이용문의 내용
	private String inquiryRequest;                  // 이용문의 답변
	private String userInquiryCreateDate;           // 이용문의 작성 날짜 
	private int memberNo;                           // 회원 번호 
	private int inquiryFileNo;                      // 이용문의 첨부 파일 번호
	private String inquiryFilePath;                 // 이용문의 첨부 파일 경로
	private int inquiryFileOrder;                   // 이용문의 첨부 파일 순서
	private int inquiryTypeNo;                      // 이용문의 유형 번호
	private String memberName;                      // 회원 이름
	private String memberProfile;                   // 회원 프로필 
	
	
	
	// 이미지 목록
	private List<UserInquiryImage> imageList;                   
}
