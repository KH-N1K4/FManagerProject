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
}
