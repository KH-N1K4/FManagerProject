package com.manager.freelancer.manager.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.manager.model.vo.FreelancerService;
import com.manager.freelancer.manager.model.vo.Member;
import com.manager.freelancer.manager.model.vo.MemberReport;
import com.manager.freelancer.manager.model.vo.Pagination;
import com.manager.freelancer.manager.model.vo.ProjectRequest;
import com.manager.freelancer.manager.model.vo.Settlement;
import com.manager.freelancer.manager.model.vo.TradeInfo;

@Repository
public class ManagerDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * 프리랜서 등급 조회
	 * 
	 * @param memberNo
	 * @return
	 */
	public String selectFreelancerGrade(int memberNo) {
		return sqlSession.selectOne("managerMapper.selectFreelancerGrade", memberNo);
	}

	/**
	 * 전체 회원 수 조회
	 * 
	 * @return
	 */
	public int getMemberListCount(String value2) {
		System.out.println("=======" + value2);
		return sqlSession.selectOne("managerMapper.getMemberListCount", value2);
	}

	/**
	 * 회원 목록 조회 + 페이징
	 * 
	 * @param pagination
	 * @return
	 */
	public List<Member> selectMemberList(String value2, Pagination pagination) {

		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("managerMapper.selectMemberList", value2, rowBounds);
	}

	/**
	 * 회원 관심분야 조회
	 * 
	 * @param memberNo
	 * @return
	 */
	public String selectMemberInterest(int memberNo) {
		return sqlSession.selectOne("managerMapper.selectMemberInterest", memberNo);
	}

	/**
	 * 회원 상세 조회
	 * 
	 * @param memberNo
	 * @return
	 */
	public Member selectMemberDetail(int memberNo) {
		return sqlSession.selectOne("managerMapper.selectMemberDetail", memberNo);
	}

	/**
	 * 프리랜서 상세 조회
	 * 
	 * @param memberNo
	 * @return
	 */
	public Member selectFreelancerDetail(int memberNo) {
		return sqlSession.selectOne("managerMapper.selectFreelancerDetail", memberNo);
	}

	/**
	 * 회원 탈퇴
	 * 
	 * @param memberNo
	 * @return
	 */
	public int managerMemberDelete(int memberNo) {
		return sqlSession.update("managerMapper.managerMemberDelete", memberNo);
	}

	/**
	 * 검색 조건 일치 회원 수 조회
	 * 
	 * @param pm
	 * @return
	 */
	public int getMemberListCount(Map<String, Object> pm) {
		return sqlSession.selectOne("managerMapper.getMemberListCount_search", pm);
	}

	/**
	 * 검색 조건 일치 회원 목록 조회
	 * 
	 * @param pagination
	 * @param pm
	 * @return
	 */
	public List<Member> selectMemberList(Pagination pagination, Map<String, Object> pm) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("managerMapper.selectMemberList_search", pm, rowBounds);
	}

	/**
	 * 서비스 수 조회
	 * 
	 * @param status
	 * @return
	 */
	public int getServiceListCount() {
		return sqlSession.selectOne("managerMapper.getServiceListCount");
	}

	/**
	 * 서비스 목록 조회
	 * 
	 * @param status
	 * @param pagination
	 * @return
	 */
	public List<FreelancerService> selectServiceList(Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("managerMapper.selectServiceList", null, rowBounds);
	}

	/**
	 * 서비스 상태별 수 조회
	 * 
	 * @param status
	 * @return
	 */
	public int getServiceListCount(int status) {
		return sqlSession.selectOne("managerMapper.getServiceListCount2", status);
	}

	/**
	 * 서비스 상태별 목록 조회
	 * 
	 * @param pagination
	 * @param status
	 * @return
	 */
	public List<FreelancerService> selectServiceList(Pagination pagination, int status) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("managerMapper.selectServiceList2", status, rowBounds);
	}

	/** 서비스 삭제
	 * @param serviceNo
	 * @return
	 */
	public int managerServiceDelete(int serviceNo) {
		return sqlSession.update("managerMapper.managerServiceDelete", serviceNo);
	}
	
	/** 서비스 상세보기
	 * @param serviceNo
	 * @return
	 */
	public FreelancerService managerServiceDetail(int serviceNo) {
		return sqlSession.selectOne("managerMapper.managerServiceDetail", serviceNo);
	}
	
	/** 서비스 승인
	 * @param serviceNo
	 * @return
	 */
	public int managerServiceApproval(int serviceNo) {
		return sqlSession.update("managerMapper.managerServiceApproval", serviceNo);
	}

	/** 서비스 반려
	 * @param serviceNo
	 * @return
	 */
	public int managerServiceRestore(int serviceNo) {
		return sqlSession.update("managerMapper.managerServiceRestore", serviceNo);
	}


	/** 계좌 내역 수 조회
	 * @param status
	 * @return
	 */
	public int getTradeListCount(int status) {
		return sqlSession.selectOne("managerMapper.getTradeListCount", status);
	}

	/** 계좌 내역 목록 조회
	 * @param status
	 * @param pagination
	 * @return
	 */
	public List<Settlement> selectTradeList(int status, Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("managerMapper.selectTradeList", status, rowBounds);
	}

	/** 검색 일치 계좌 내역 수 조회
	 * @param pm
	 * @return
	 */
	public int getTradeListCount(Map<String, Object> pm) {
		return sqlSession.selectOne("managerMapper.getTradeListCount_search", pm);
	}

	/** 검색 일치 계좌 내역 목록 조회
	 * @param pm
	 * @param pagination
	 * @return
	 */
	public List<Settlement> selectTradeList(Map<String, Object> pm, Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("managerMapper.selectTradeList_search", pm, rowBounds);
	}

	/** 거래 정보 조회
	 * @param tradeNo
	 * @return
	 */
	public TradeInfo selectTradeInfo(int tradeNo) {
		return sqlSession.selectOne("managerMapper.selectTradeInfo", tradeNo);
	}


	/** 거래번호로 프리랜서 번호 얻기
	 * @param pm
	 * @return
	 */
	public int getFreelancerNo(Map<String, Object> pm) {
		return sqlSession.selectOne("managerMapper.getFreelancerNo",pm);
	}

	/** 거래번호로 회원 번호 얻기
	 * @param pm
	 * @return
	 */
	public int getMemberNo(Map<String, Object> pm) {
		return sqlSession.selectOne("managerMapper.getMemberNo",pm);
	}
	
	/** 거래 번호로 가격 얻기
	 * @param pm
	 * @return
	 */
	public int getPaymentPrice(Map<String, Object> pm) {
		return sqlSession.selectOne("managerMapper.getPaymentPrice",pm);
	}

	/** 환불하기1
	 * @param pm
	 * @return
	 */
	public int managerRefund1(Map<String, Object> pm) {
		
		return sqlSession.insert("managerMapper.managerRefund1",pm);
	}
	
	/** 환불하기2
	 * @param pm
	 * @return
	 */
	public int managerRefund2(Map<String, Object> pm) {
		
		return sqlSession.insert("managerMapper.managerRefund2",pm);
	}
	
	/** 환불 후 작업 상태 변경
	 * @param pm
	 * @return 
	 */
	public int updateStatus(Map<String, Object> pm) {
		return sqlSession.update("managerMapper.updateStatus",pm);
	}

	/** 정산하기
	 * @param map
	 * @return
	 */
	public int managerCalculate(Map<String, Object> map) {
		return sqlSession.insert("managerMapper.managerCalculate",map);
	}

	/** 정산 후 작업 상태 변경
	 * @param tradeNo
	 * @return
	 */
	public int updateStatus(int tradeNo) {
		return sqlSession.update("managerMapper.updateStatusCal",tradeNo);
	}

	/** 정산을 위한 프리랜서 번호 얻기
	 * @param tradeNo
	 * @return
	 */
	public int getFreelancerNo2(int tradeNo) {
		return sqlSession.selectOne("managerMapper.getFreelancerNo2",tradeNo);
	}

	/** 정산을 위한 가격 얻기
	 * @param tradeNo
	 * @return
	 */
	public int getPaymentPrice2(int tradeNo) {
		return sqlSession.selectOne("managerMapper.getPaymentPrice2",tradeNo);
	}

	/** 프로젝트 의뢰 수
	 * @return
	 */
	public int getRequestCount() {
		return sqlSession.selectOne("managerMapper.getRequestCount");
	}

	/** 프로젝트 의뢰 목록 조회
	 * @param pagination
	 * @return
	 */
	public List<ProjectRequest> selectRequestList(Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("managerMapper.selectRequestList", null, rowBounds);
	}

	
	/** 상태별 프로젝트 의뢰 수
	 * @param status
	 * @return
	 */
	public int getRequestCount2(int status) {
		return sqlSession.selectOne("managerMapper.getRequestCount2", status);
	}


	/** 상태별 프로젝트 의뢰 목록
	 * @param pagination
	 * @param status
	 * @return
	 */
	public List<ProjectRequest> selectRequestList2(Pagination pagination, int status) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("managerMapper.selectRequestList2", status, rowBounds);
	}

	/** 프로젝트 의뢰 삭제
	 * @param projectRequestNo
	 * @return
	 */
	public int managerRequestDelete(int projectRequestNo) {
		return sqlSession.update("managerMapper.managerRequestDelete",projectRequestNo);
	}

	/** 프로젝트 의뢰 상세보기
	 * @param projectRequestNo
	 * @return
	 */
	public ProjectRequest managerRequestDetail(int projectRequestNo) {
		return sqlSession.selectOne("managerMapper.managerRequestDetail", projectRequestNo);
	}

	/** 프로젝트 의뢰 승인
	 * @param projectRequestNo
	 * @return
	 */
	public int managerRequestApproval(int projectRequestNo) {
		return sqlSession.update("managerMapper.managerRequestApproval",projectRequestNo);
	}

	/** 프로젝트 의뢰 반려
	 * @param projectRequestNo
	 * @return
	 */
	public int managerRequestRestore(int projectRequestNo) {
		return sqlSession.update("managerMapper.managerRequestRestore",projectRequestNo);
	}
 
	/** 회원 신고 수 
	 * @param status
	 * @return
	 */
	public int getMemberReportListCount(int status) {
		return sqlSession.selectOne("managerMapper.getMemberReportListCount",status);
	}

	/** 회원 신고 내역 목록
	 * @param status 
	 * @param pagination
	 * @return
	 */
	public List<MemberReport> selectMemberReportList(int status, Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("managerMapper.selectMemberReportList", status, rowBounds);
	}

	/** 검색 일치 회원 신고 수 
	 * @param pm
	 * @return
	 */
	public int getMemberReportListCount(Map<String, Object> pm) {
		return sqlSession.selectOne("managerMapper.getMemberReportListCount2",pm);
	}

	/** 검색 일치 회원 신고 내역 목록
	 * @param pagination
	 * @param pm
	 * @return
	 */
	public List<MemberReport> selectMemberReportList(Pagination pagination, Map<String, Object> pm) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());

		return sqlSession.selectList("managerMapper.selectMemberReportList2", pm, rowBounds);
	}

	/** 회원 신고 내역 상세 보기
	 * @param memberReportNo
	 * @return
	 */
	public MemberReport memberReportDetail(int memberReportNo) {
		return sqlSession.selectOne("managerMapper.memberReportDetail",memberReportNo);
	}

	/** 회원 신고 답변 등록
	 * @param map
	 * @return
	 */
	public int insertReportRequest(Map<String, Object> map) {
		return sqlSession.update("managerMapper.insertReportRequest",map);
	}

	
	



}
