package com.manager.freelancer.freelancer.model.vo;

import lombok.Data;

@Data
public class Portfolio {

	private int portfolioNo;
	private String portfolioTitle;
	private String portfolioContent;
	private String portfolioFilePath;
	private String portfolioThumbnail;
	private int freelancerNo;
	
	// 포트폴리오 상세조회용
	private int memberNo;
	private String memberName;
	private String memberProfile;
}
