package com.manager.freelancer.freelancer.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class License {

	
	private String license; // input값전체 받을 부분
	
	private int licenseNo;  				// 자격증 번호
	private String licenseName;				// 자격증 이름
	private String licenseDate;				// 자격증 발급일
	private String licenseAgency;			// 자격증 발급 기관
	
	private int freelancerNo; 	
}
