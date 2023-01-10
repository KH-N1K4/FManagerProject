package com.manager.freelancer.manager.model.service;

import java.util.Map;

import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.member.model.vo.Member;

public interface ManagerInquiryService {

	
	/** 이용문의 내역 조회하기 
	 * @param cp
	 * @return Map
	 */
	Map<String, Object> selectManagerInquiryList(int optionVal,int cp);

	/** 검색 결과에 일치하는 이용문의 내역 조회하기
	 * @param optionVal
	 * @param cp
	 * @return Map
	 */
	Map<String, Object> selectManagerInquiryList(Map<String, Object> pm, int cp);

	/** 이용문의 내역 상세보기 
	 * @param userInquiryNo
	 * @return userInquiry
	 */
	UserInquiry viewInquiryDetail(int userInquiryNo);

	/** 이용문의 답글 삽입
	 * @param userInquiryNo
	 * @param inputComment 
	 * @return
	 */
	int updateComment(int userInquiryNo, String inputComment, Member loginMember);

	/** 관리자 진행상태별 이용문의 조회
	 * @param optionVal
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectChangeStatusManager(int optionVal, int cp);


	

}
