package com.manager.freelancer.manager.model.vo;


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
	

}
