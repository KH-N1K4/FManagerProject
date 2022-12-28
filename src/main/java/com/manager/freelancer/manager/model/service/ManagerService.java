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

	/** 서비스 목록 조회
	 * @param status
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectServiceList(int cp);

	/** 서비스 상태별 조회 ajax
	 * @param listType
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectServiceTypeList(int status, int cp);

	/** 서비스 삭제
	 * @param serviceNo
	 * @return
	 */
	int managerServiceDelete(int serviceNo);

	/** 계좌 내역
	 * @param status
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectTradeList(String status, int cp);


	
}
