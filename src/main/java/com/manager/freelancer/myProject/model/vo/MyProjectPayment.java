package com.manager.freelancer.myProject.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyProjectPayment {
	
	private int memberNo;
	private String serviceTitle;
	private String mainCategoryName;
	private String paymentDate;
	private int paymentPrice;

}
