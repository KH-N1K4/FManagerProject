package com.manager.freelancer.manager.model.service;

import java.util.List;
import java.util.Map;

import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.manager.model.vo.Member;

public interface ManagerService {

	/** 회원 목록 조회 + 페이징
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectMemberList(String value,int cp);

	/** 회원 상세 조회
	 * @param memberNo
	 * @return
	 */
	Member selectMemberDetail(int memberNo);

	/** 회원 유형별 조회 ajax
	 * @param value
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectMemberTypeList(String value, int cp);

	/** 회원 탈퇴
	 * @param memberNo
	 * @return
	 */
	int managerMemberDelete(int memberNo);


	/** 회원 검색
	 * @param pm
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectMemberList(Map<String, Object> pm, int cp);

	/** 회원 유형별 검색
	 * @param pm
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectMemberTypeList(Map<String, Object> pm, int cp);

	/** 문의 내역 조회 + 페이징
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectUserInquiryList(int cp);

	
}
