package com.manager.freelancer.member.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
	
	private int memberNo;
	private String membereEmail;
	private String memberPw;
	private String memberPwCheck;
	private String memberTel;
	private String memberNickname;
	private String memberName;
	private String memberJob;
	private int memberAuthority;
}
