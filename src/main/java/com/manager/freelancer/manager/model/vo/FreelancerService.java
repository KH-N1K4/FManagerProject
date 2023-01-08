package com.manager.freelancer.manager.model.vo;


import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FreelancerService {
	
	private int serviceNo;
	private String serviceTitle;
	private int serviceStatus;
	
	private String serviceStatusString;
	
	private String requestFilePath;
	private String serviceSummary;
	private String serviceContent;
	private int servicePrice;
	private int serviceEditNum;
	private int serviceWorkPeriod;
	
	private String serviceCreateDate;
	
	private String thirdCategoryName;
	private String subCategoryName;
	private String mainCategoryName;
	
	private int freelancerNo;
	private String freelancerName;
	private String freelancerImage;
	private String freelancerIntro;
	
	List<ServiceImageFile> serviceImageFileList;

}
