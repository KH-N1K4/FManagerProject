package com.manager.freelancer.manager.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.manager.model.dao.ManagerDAO;
import com.manager.freelancer.manager.model.vo.Member;
import com.manager.freelancer.manager.model.vo.MemberReport;
import com.manager.freelancer.manager.model.vo.Pagination;
import com.manager.freelancer.manager.model.vo.ProjectRequest;
import com.manager.freelancer.manager.model.vo.Settlement;
import com.manager.freelancer.manager.model.vo.TradeInfo;
import com.manager.freelancer.manager.model.vo.TradeReport;
import com.manager.freelancer.manager.model.vo.FreelancerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDAO dao;

	// 회원 목록 조회
	@Override
	public Map<String, Object> selectMemberList(String value, int cp) {

		Map<String, Object> map = new HashMap<String, Object>();

		int listCount = dao.getMemberListCount(value);
		Pagination pagination = new Pagination(listCount, cp);

		List<Member> memberList = dao.selectMemberList(value, pagination);

		if (memberList != null) {
			for (Member m : memberList) {
				if (m.getFreelancerFlag().equals("N")) {
					m.setMemberType("일반 회원");
					m.setFreelancerGrade("");
				} else {
					m.setMemberType("프리랜서");
					String gradeName = dao.selectFreelancerGrade(m.getMemberNo());
					m.setFreelancerGrade(gradeName);
				}
			}

		}
		map.put("pagination", pagination);
		map.put("memberList", memberList);

		return map;

	}

	// 회원 상세 조회
	@Override
	public Member selectMemberDetail(int memberNo) {

		Member member = dao.selectMemberDetail(memberNo);

		if (member.getFreelancerFlag().equals("Y")) {
			Member freelancer = dao.selectFreelancerDetail(memberNo);
			member.setFreeContactTime1(freelancer.getFreeContactTime1());
			member.setFreeContactTime2(freelancer.getFreeContactTime2());
			member.setRegionName(freelancer.getRegionName());
			member.setFreelancerPeriod(freelancer.getFreelancerPeriod());
			member.setFreelancerIntroduction(freelancer.getFreelancerIntroduction());
			member.setFreelancerBankName(freelancer.getFreelancerBankName());
			member.setFreelancerAccountNo(freelancer.getFreelancerAccountNo());
		}

		return member;
	}

	//회원 유형별 조회 ajax
	@Override
	public Map<String, Object> selectMemberTypeList(String value, int cp) {
		Map<String, Object> map = new HashMap<String, Object>();

		int listCount = dao.getMemberListCount(value);
		Pagination pagination = new Pagination(listCount, cp);

		List<Member> memberList = dao.selectMemberList(value, pagination);

		if (memberList != null) {
			for (Member m : memberList) {
				if (m.getFreelancerFlag().equals("N")) {
					m.setMemberType("일반 회원");
					m.setFreelancerGrade("");
				} else {
					m.setMemberType("프리랜서");
					String gradeName = dao.selectFreelancerGrade(m.getMemberNo());
					m.setFreelancerGrade(gradeName);
				}
			}

		}
		map.put("pagination", pagination);
		map.put("memberList", memberList);

		return map;

	}
	
	
	// 회원 탈퇴
	@Override
	public int managerMemberDelete(int memberNo) {
		return dao.managerMemberDelete(memberNo);
	}

	// 회원 검색 목록 조회
	@Override
	public Map<String, Object> selectMemberList(Map<String, Object> pm, int cp) {
		int listCount = dao.getMemberListCount(pm);
		Pagination pagination = new Pagination(listCount, cp);
		List<Member> memberList = dao.selectMemberList(pagination, pm);

		if (memberList != null) {
			for (Member m : memberList) {
				if (m.getFreelancerFlag().equals("N")) {
					m.setMemberType("일반 회원");
					m.setFreelancerGrade("");
				} else {
					m.setMemberType("프리랜서");
					String gradeName = dao.selectFreelancerGrade(m.getMemberNo());
					m.setFreelancerGrade(gradeName);
				}
			}

		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("memberList", memberList);

		return map;
	}

	
	
	//서비스 목록 조회
	@Override
	public Map<String, Object> selectServiceList(int cp) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int listCount = dao.getServiceListCount();
		Pagination pagination = new Pagination(listCount, cp);

		List<FreelancerService> serviceList = dao.selectServiceList(pagination);
		
		if(serviceList!=null) {
			for(FreelancerService s : serviceList) {
				if(s.getServiceStatus()==1) s.setServiceStatusString("승인 대기중");
				else if(s.getServiceStatus()==2) s.setServiceStatusString("판매중");
				else if(s.getServiceStatus()==3) s.setServiceStatusString("미승인");
				else s.setServiceStatusString("판매 중지");
			}
		}
		map.put("serviceList", serviceList);
		map.put("pagination", pagination);
		
		return map;
	}
	
	
	// 서비스 상태별 조회
	@Override
	public Map<String, Object> selectServiceTypeList(int status, int cp) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<FreelancerService> serviceList = new ArrayList<FreelancerService>();
		Pagination pagination;
		
		if(status !=0) {
			int listCount = dao.getServiceListCount(status);
			pagination = new Pagination(listCount, cp);
			serviceList = dao.selectServiceList(pagination,status);
		} else {
			int listCount = dao.getServiceListCount();
			pagination = new Pagination(listCount, cp);
			serviceList = dao.selectServiceList(pagination);
		}
		
		if(serviceList!=null) {
			for(FreelancerService s : serviceList) {
				if(s.getServiceStatus()==1) s.setServiceStatusString("승인 대기중");
				else if(s.getServiceStatus()==2) s.setServiceStatusString("판매중");
				else if(s.getServiceStatus()==3) s.setServiceStatusString("미승인");
				else s.setServiceStatusString("판매 중지");
			}
		}
		map.put("serviceList", serviceList);
		map.put("pagination", pagination);
		
		return map;
	}
	
	
	// 서비스 삭제
	@Override
	public int managerServiceDelete(int serviceNo) {
		return dao.managerServiceDelete(serviceNo);
	}
	
	// 서비스 상세보기
	@Override
	public FreelancerService managerServiceDetail(int serviceNo) {
		return dao.managerServiceDetail(serviceNo);
	}
	
	// 서비스 승인
	@Override
	public int managerServiceApproval(int serviceNo) {
		return dao.managerServiceApproval(serviceNo);
	}
	
	// 서비스 반려
	@Override
	public int managerServiceRestore(int serviceNo) {
		return dao.managerServiceRestore(serviceNo);
	}
	
	
	// 계좌 내역 목록
	@Override
	public Map<String, Object> selectTradeList(int status, int cp) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		int listCount = dao.getTradeListCount(status);
		Pagination pagination = new Pagination(listCount, cp);

		List<Settlement> tradeList = dao.selectTradeList(status, pagination);
		
		if(tradeList!=null) {
			for(Settlement t : tradeList) {
				if(t.getWorkStatus()==1) t.setWorkStatusString("진행중");
				else if(t.getWorkStatus()==2) t.setWorkStatusString("정산 완료");
				else if(t.getWorkStatus()==3) t.setWorkStatusString("환불 완료");
				else t.setWorkStatusString("마감");
				
				if(t.getPaymentType()==1) t.setPaymentTypeString("입금");
				else if(t.getPaymentType()==2) t.setPaymentTypeString("출금");
				else t.setPaymentTypeString("환불");
			}
		}

		map.put("pagination", pagination);
		map.put("tradeList", tradeList);

		return map;
	}
	
	// 검색 일치 계좌 내역
	@Override
	public Map<String, Object> selectTradeList(Map<String, Object> pm, int cp) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		int listCount = dao.getTradeListCount(pm);
		Pagination pagination = new Pagination(listCount, cp);

		List<Settlement> tradeList = dao.selectTradeList(pm, pagination);
		
		if(tradeList!=null) {
			for(Settlement t : tradeList) {
				if(t.getWorkStatus()==1) t.setWorkStatusString("진행중");
				else if(t.getWorkStatus()==2) t.setWorkStatusString("정산 완료");
				else if(t.getWorkStatus()==3) t.setWorkStatusString("환불 완료");
				else t.setWorkStatusString("마감");
				
				if(t.getPaymentType()==1) t.setPaymentTypeString("입금");
				else if(t.getPaymentType()==2) t.setPaymentTypeString("출금");
				else t.setPaymentTypeString("환불");
			}
		}

		map.put("pagination", pagination);
		map.put("tradeList", tradeList);

		return map;
	}
	
	// 작업상태별 목록 조회
	@Override
	public Map<String, Object> selectTradeStatusList(int status, int cp) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		int listCount = dao.getTradeListCount(status);
		Pagination pagination = new Pagination(listCount, cp);

		List<Settlement> tradeList = dao.selectTradeList(status, pagination);
		
		if(tradeList!=null) {
			for(Settlement t : tradeList) {
				if(t.getWorkStatus()==1) t.setWorkStatusString("진행중");
				else if(t.getWorkStatus()==2) t.setWorkStatusString("정산 완료");
				else if(t.getWorkStatus()==3) t.setWorkStatusString("환불 완료");
				else t.setWorkStatusString("마감");
				
				if(t.getPaymentType()==1) t.setPaymentTypeString("입금");
				else if(t.getPaymentType()==2) t.setPaymentTypeString("출금");
				else t.setPaymentTypeString("환불");
			}
		}

		map.put("pagination", pagination);
		map.put("tradeList", tradeList);

		return map;
	}
	
	
	
	// 거래 정보 조회
	@Override
	public TradeInfo selectTradeInfo(int tradeNo) {
		
		TradeInfo tradeInfo = dao.selectTradeInfo(tradeNo);
		
		if(tradeInfo.getWorkEditNum()>tradeInfo.getServiceEditNum()) {
			tradeInfo.setWorkEditNum(tradeInfo.getServiceEditNum());
		}
		
		return tradeInfo;
	}
	
	// 환불하기
	@Override
	public int managerRefund(Map<String, Object> pm) {
		
		int freelancerNo = dao.getFreelancerNo(pm);
		int memberNo = dao.getMemberNo(pm);
		int paymentPrice = dao.getPaymentPrice(pm);
		
		pm.put("freelancerNo",freelancerNo);
		pm.put("memberNo",memberNo);
		pm.put("paymentPrice",paymentPrice);
		
		int result;
		
		// refundPercent가 0이면
		if(pm.get("refundPercent").equals(100)){
			result = dao.managerRefund1(pm);
		} else if (pm.get("refundPercent").equals(0)) {
			result = dao.managerRefund2(pm);
		} else {
			result = dao.managerRefund1(pm);
			if(result>0) result = dao.managerRefund2(pm);
		}
		
		if(result>0) {
			result = dao.updateStatus(pm);
		}
		
		
		return result;
	}
	
	
	//정산하기
	@Override
	public int managerCalculate(int tradeNo) {
		
		int freelancerNo = dao.getFreelancerNo2(tradeNo); //프리랜서 번호 얻기
		int paymentPrice = dao.getPaymentPrice2(tradeNo); //가격 얻기
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("freelancerNo", freelancerNo);
		map.put("paymentPrice", paymentPrice);
		map.put("tradeNo", tradeNo);
		
		int result = dao.managerCalculate(map);
		
		if(result>0) result = dao.updateStatus(tradeNo);
		
		return result;
	}
	
	
	
	// 프로젝트 의뢰 목록 조회
	@Override
	public Map<String, Object> managerprojectRequestList(int cp) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int listCount = dao.getRequestCount();
		Pagination pagination = new Pagination(listCount, cp);

		List<ProjectRequest> requestList = dao.selectRequestList(pagination);
		
		if(requestList!=null) {
			for(ProjectRequest s : requestList) {
				if(s.getProjectRequestStatus()==1) s.setProjectRequestStatusString("승인 대기중");
				else if(s.getProjectRequestStatus()==2) s.setProjectRequestStatusString("모집중");
				else if(s.getProjectRequestStatus()==3) s.setProjectRequestStatusString("미승인");
				else s.setProjectRequestStatusString("모집 마감");
			}
		}
		map.put("requestList", requestList);
		map.put("pagination", pagination);
		
		return map;
	}
	
	// 프로젝트 의뢰 상태 ajax
	@Override
	public Map<String, Object> managerprojectRequestType(int status, int cp) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProjectRequest> requestList = new ArrayList<ProjectRequest>();
		Pagination pagination;
		
		if(status !=0) {
			int listCount = dao.getRequestCount2(status);
			pagination = new Pagination(listCount, cp);
			requestList = dao.selectRequestList2(pagination,status);
		} else {
			int listCount = dao.getRequestCount();
			pagination = new Pagination(listCount, cp);
			requestList = dao.selectRequestList(pagination);
		}
		
		if(requestList!=null) {
			for(ProjectRequest s : requestList) {
				if(s.getProjectRequestStatus()==1) s.setProjectRequestStatusString("승인 대기중");
				else if(s.getProjectRequestStatus()==2) s.setProjectRequestStatusString("모집중");
				else if(s.getProjectRequestStatus()==3) s.setProjectRequestStatusString("미승인");
				else s.setProjectRequestStatusString("모집 마감");
			}
		}
		map.put("requestList", requestList);
		map.put("pagination", pagination);
		
		return map;
	}
	
	
	// 프로젝트 의뢰 삭제
	@Override
	public int managerRequestDelete(int projectRequestNo) {
		return dao.managerRequestDelete(projectRequestNo);
	}
	
	// 프로젝트 의뢰 상세보기
	@Override
	public ProjectRequest managerRequestDetail(int projectRequestNo) {
		return dao.managerRequestDetail(projectRequestNo);
	}
	
	// 프로젝트 의뢰 승인
	@Override
	public int managerRequestApproval(int projectRequestNo) {
		return dao.managerRequestApproval(projectRequestNo);
	}
	
	// 프로젝트 의뢰 반려
	@Override
	public int managerRequestRestore(int projectRequestNo) {
		return dao.managerRequestRestore(projectRequestNo);
	}
	
	// 회원 신고 내역
	@Override
	public Map<String, Object> selectMemberReportList(int status, int cp) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		int listCount = dao.getMemberReportListCount(status);
		Pagination pagination = new Pagination(listCount, cp);

		List<MemberReport> memberReportList = dao.selectMemberReportList(status, pagination);
		
		
		map.put("pagination", pagination);
		map.put("memberReportList", memberReportList);

		return map;
	}
	
	// 검색 일치 회원 신고 내역
	@Override
	public Map<String, Object> selectMemberReportList(Map<String, Object> pm, int cp) {
		int listCount = dao.getMemberReportListCount(pm);
		Pagination pagination = new Pagination(listCount, cp);
		List<MemberReport> memberReportList = dao.selectMemberReportList(pagination, pm);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("memberReportList", memberReportList);

		return map;
	}
	
	// 회원 신고 내역 상세 보기
	@Override
	public MemberReport memberReportDetail(int memberReportNo) {
		return dao.memberReportDetail(memberReportNo);
	}
	
	// 회원 신고 내역 답변 등록
	@Override
	public int insertReportRequest(Map<String, Object> map) {
		return dao.insertReportRequest(map);
	}
	
	
	// 거래 신고 내역 조회
	@Override
	public Map<String, Object> selectMemberTradeList(int status, int cp) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		int listCount = dao.getMemberTradeListCount(status);
		Pagination pagination = new Pagination(listCount, cp);

		List<TradeReport> tradeReportList = dao.selectMemberTradeList(status, pagination);
		
		if(tradeReportList!=null) {
			for(TradeReport t: tradeReportList) {
				if(t.getTradeReportTypeNo()==1) t.setTradeReportTypeName("거래 신고");
				else t.setTradeReportTypeName("주문 취소");
			} 
		}
		
		
		map.put("pagination", pagination);
		map.put("tradeReportList", tradeReportList);

		return map;
	}
	
	
	// 검색 일치 거래 신고 내역 조회
	@Override
	public Map<String, Object> selectMemberTradeList(Map<String, Object> pm, int cp) {
		int listCount = dao.getMemberTradeListCount(pm);
		Pagination pagination = new Pagination(listCount, cp);
		List<TradeReport> tradeReportList = dao.selectMemberTradeList(pagination, pm);
		
		if(tradeReportList!=null) {
			for(TradeReport t: tradeReportList) {
				if(t.getTradeReportTypeNo()==1) t.setTradeReportTypeName("거래 신고");
				else t.setTradeReportTypeName("주문 취소");
			} 
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("tradeReportList", tradeReportList);

		return map;
	}
	
	
	// 상태별 거래 신고 조회
	@Override
	public Map<String, Object> selectReportStatusList(Map<String, Object> map, int cp) {
		
		int listCount = dao.getReportStatusListCount(map);
		Pagination pagination = new Pagination(listCount, cp);
		List<TradeReport> tradeReportList = dao.selectReportStatusList(pagination, map);
		
		if(tradeReportList!=null) {
			for(TradeReport t: tradeReportList) {
				if(t.getTradeReportTypeNo()==1) t.setTradeReportTypeName("거래 신고");
				else t.setTradeReportTypeName("주문 취소");
			} 
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pagination", pagination);
		resultMap.put("tradeReportList", tradeReportList);
		
		return resultMap;
	}
	
	
	// 거래 신고 상세 보기
	@Override
	public TradeReport tradeReportDetail(int tradeReportNo) {
		
		TradeReport tradeReport = dao.tradeReportDetail(tradeReportNo);
				
		if(tradeReport.getTradeReportTypeNo()==1) tradeReport.setTradeReportTypeName("거래 신고");
		else tradeReport.setTradeReportTypeName("주문 취소");		
		
		return tradeReport;
	}
	
	
	
	
	
	

}























