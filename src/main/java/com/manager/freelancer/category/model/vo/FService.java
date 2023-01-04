package com.manager.freelancer.category.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class FService {
	
	private int serviceNo;				//SERVICE_NO 서비스 번호 SEQUENCE: SEQ_SERVICE_NO
	private String serviceTitle;		//SERVICE_TITLE 서비스 제목
	private String serviceSummary;		//SERVICE_SUMMARY 서비스 한 줄 요약
	
	private String serviceDeleteFL;	
	
	private String requestFilePath;	
	
	
	private int reviewCount;
	private int sellCount;
	private float servicePoint;
}
