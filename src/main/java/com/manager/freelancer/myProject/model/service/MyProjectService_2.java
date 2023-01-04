package com.manager.freelancer.myProject.model.service;

import java.util.List;
import java.util.Map;

import com.manager.freelancer.myProject.model.vo.FreelancerService;

public interface MyProjectService_2 {

	/** 결제 내역
	 * @param option
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectPaymentList(Map<String, Object> option, int cp);

	/**메인 카테고리 들고오기
	 * @return
	 */
	List<FreelancerService> selectmaincategoryList();

	/**메인3 카테고리 들고오기 
	 * @return
	 */
	List<FreelancerService> selectcategoryList();

	/** 구매 내역 
	 * @param option
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectPurchaseList(Map<String, Object> option, int cp);

}
