package com.manager.freelancer.manager.model.service;

import java.util.Map;

public interface ManagerInquiryService {

	
	/** 이용문의 내역 조회하기 
	 * @param cp
	 * @return Map
	 */
	Map<String, Object> selectManagerInquiryList(int cp);

	/** 검색 결과에 일치하는 이용문의 내역 조회하기
	 * @param pm
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectManagerInquiryList(Map<String, Object> pm, int cp);

}
