package com.manager.freelancer.manager.model.service;

import java.util.List;
import java.util.Map;

import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.manager.model.vo.FreelancerService;
import com.manager.freelancer.manager.model.vo.Member;
import com.manager.freelancer.manager.model.vo.MemberReport;
import com.manager.freelancer.manager.model.vo.ProjectRequest;
import com.manager.freelancer.manager.model.vo.ReviewReport;
import com.manager.freelancer.manager.model.vo.TradeInfo;
import com.manager.freelancer.manager.model.vo.TradeReport;

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
	
	/** 서비스 상세보기
	 * @param serviceNo
	 * @return
	 */
	FreelancerService managerServiceDetail(int serviceNo);
	
	/** 서비스 승인
	 * @param serviceNo
	 * @return
	 */
	int managerServiceApproval(int serviceNo);
	
	/** 서비스 반려
	 * @param serviceNo
	 * @return
	 */
	int managerServiceRestore(int serviceNo);

	/** 계좌 내역
	 * @param status
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectTradeList(int status, int cp);

	/** 검색 일치 계좌 내역
	 * @param pm
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectTradeList(Map<String, Object> pm, int cp);

	/** 작업 상태별 계좌 내역 조회
	 * @param status
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectTradeStatusList(int status, int cp);

	/** 거래 정보 조회
	 * @param tradeNo
	 * @return
	 */
	TradeInfo selectTradeInfo(int tradeNo);


	/** 환불하기
	 * @param pm
	 * @return
	 */
	int managerRefund(Map<String, Object> pm);

	/** 정산하기
	 * @param tradeNo
	 * @return
	 */
	int managerCalculate(int tradeNo);

	/** 프로젝트 의뢰 목록 조회
	 * @param cp
	 * @return
	 */
	Map<String, Object> managerprojectRequestList(int cp);

	/** 프로젝트 의뢰 상태 ajax
	 * @param status
	 * @param cp
	 * @return
	 */
	Map<String, Object> managerprojectRequestType(int status, int cp);

	/** 프로젝트 의뢰 삭제
	 * @param projectRequestNo
	 * @return
	 */
	int managerRequestDelete(int projectRequestNo);

	/** 프로젝트 의뢰 상세보기
	 * @param projectRequestNo
	 * @return
	 */
	ProjectRequest managerRequestDetail(int projectRequestNo);

	/** 프로젝트 의뢰 승인
	 * @param projectRequestNo
	 * @return
	 */
	int managerRequestApproval(int projectRequestNo);

	/** 프로젝트 의뢰 반려
	 * @param projectRequestNo
	 * @return
	 */
	int managerRequestRestore(int projectRequestNo);

	/** 회원 신고 내역
	 * @param status
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectMemberReportList(int status, int cp);

	/** 검색 일치 회원 신고 내역
	 * @param pm
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectMemberReportList(Map<String, Object> pm, int cp);

	/** 회원 신고 상세 보기
	 * @param memberReportNo
	 * @return
	 */
	MemberReport memberReportDetail(int memberReportNo);

	/** 회원 신고 내역 답변 등록
	 * @param map
	 * @return
	 */
	int insertReportRequest(Map<String, Object> map);

	/** 거래 신고 내역 조회
	 * @param status
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectMemberTradeList(int status, int cp);

	/** 검색 일치 거래 신고 내역 조회
	 * @param pm
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectMemberTradeList(Map<String, Object> pm, int cp);

	/** 상태별 거래 신고 조회
	 * @param map
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectReportStatusList(Map<String, Object> map, int cp);

	/** 거래 신고 상세 보기
	 * @param tradeReportNo
	 * @return
	 */
	TradeReport tradeReportDetail(int tradeReportNo);

	/** 리뷰 신고 목록
	 * @param cp 
	 * @return
	 */
	Map<String, Object> selectReviewReportList(int cp);

	

	

	


	
}
