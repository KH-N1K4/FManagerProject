package com.manager.freelancer.member.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
	
	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberTel;
	private String memberNickname;
	private String memberName;
	
	
	
   private String memberJob;
   private int authority;
   private String memberProfile;
   private String freelancerFL;
	
	// 관심사 삽입용 
	private String memberInterest;

}
