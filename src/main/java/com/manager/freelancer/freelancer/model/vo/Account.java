package com.manager.freelancer.freelancer.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Account {

	private String bankCode; // 뱅크코드 전체
	private int bankAccountNumber; // 계좌번호
	
	private int freelancerNo;
}
