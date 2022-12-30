package com.manager.freelancer.common.message.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Message {
	//회원 정보
	private int memberNo; 					//MEMBER_NO 회원 번호 SEQUENCE: SEQ_MEMBER_NO
	private String memberEmail;				//MEMBER_EMAIL 회원 이메일(중복 불가)
	private String memberNick;				//MEMBER_NICKNAME 회원 닉네임(중복 불가)
	private String memberName;				//MEMBER"."MEMBER_NAME 회원 이름

	private String memberAuthority;			//AUTHORITY 회원 권한(1:회원, 2: 관리자)
	private String memberEnrollDate;		//MEMBER_ENROLL_DATE 회원 가입일
	private String memberDeleteFL;          //MEMBER_DELETE_FL 회원 탈퇴 여부 탈퇴:Y 회원:N
	private String freelancerFL; 			//FREELANCER_FL 프리랜서 등록 여부 등록:Y 미등록:N
	
	//채팅방
	private int chatRoomNo; 				//"CHAT_ROOM"."CHAT_ROOM_NO" 채팅방 번호 SEQUENCE: SEQ_CHAT_ROOM_NO
	private String chatRoomDelFL; 			//"CHAT_ROOM"."CHAT_ROOM_DEL_FL 채팅방 삭제 여부 Y :삭제 N: 개설
	private String chatRoomCreateDate; 		//"CHAT_ROOM"."CHAT_ROOM_CREATE_DATE 채팅방 개설일
	private int chatFounderNo;				//"CHAT_ROOM"."CHAT_FOUNDER_NO 채팅방 개설자(FREELANCER_NO FK)
	private int clientNo;					//"CHAT_ROOM"."CLIENT_NO" 채팅방 참여자(회원번호 FK)
	
	//채팅방 메세지
	private int chatNo;						//"CHAT"."CHAT_NO" '채팅 메세지 번호 SEQUENCE: SEQ_CHAT_NO'
	private String chatMessage;				//"CHAT"."CHAT_MESSAGE" 작성한 메세지
	private String chatSendTime;			//"CHAT"."CHAT_SEND_TIME" 작성 시간 SYSDATE
	private int senderNo;					//"CHAT"."SENDER_NO" 작성자(회원번호)(FK)
	
	//회원 신고
	private int memberReportNo;				//"MEMBER_REPORT"."MEMBER_REPORT_NO" 회원 신고 번호 SEQ_MEMBER_REPORT_NO
	private String memberReportTitle;		//"MEMBER_REPORT"."MEMBER_REPORT_TITLE" 회원 문의 제목
	private String memberReportContent;		//"MEMBER_REPORT"."MEMBER_REPORT_CONTENT" 회원 문의 내용
	private String memberReportRequest;		//"MEMBER_REPORT"."MEMBER_REPORT_REQUEST" 회원 문의 답변
	private String memberReportCreateDate;  //"MEMBER_REPORT"."MEMBER_REPORT_CREATE_DATE" 회원 작성 날짜
	private int reportMemberNo;				//"MEMBER_REPORT"."REPORT_MEMBER" 회원 신고자(FK)
	private int reportedMemberNo;			//"MEMBER_REPORT"."REPORTED_MEMBER" 신고 당한 회원
	
	//회원 신고 첨부파일
	private int memberReportfileNo;			//"MEMBER_REPORT_FILE"."MEMBER_REPORT_FILE_NO" 회원 신고 첨부파일 번호
	private String memberReportfilePath;		//"MEMBER_REPORT_FILE"."MEMBER_REPORT_FILE_PATH" 회원 신고 첨부파일 경로
	private int memberReportfileOrder;		//"MEMBER_REPORT_FILE"."MEMBER_REPORT_FILE_ORDER" 회원 신고 첨부파일 순서
}
