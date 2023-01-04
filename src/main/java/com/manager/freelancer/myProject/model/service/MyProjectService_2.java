package com.manager.freelancer.myProject.model.service;

import java.util.Map;

public interface MyProjectService_2 {

	/** 결제 내역
	 * @param option
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectPaymentList(Map<String, Object> option, int cp);

}
