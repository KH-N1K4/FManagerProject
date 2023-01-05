package com.manager.freelancer.myProject.model.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.common.Util;
import com.manager.freelancer.customerCenter.model.vo.Pagination;
import com.manager.freelancer.myProject.model.vo.TradeReport;
import com.manager.freelancer.myProject.model.dao.MyProjectDAO_2;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.myProject.model.vo.MyProjectPayment;
import com.manager.freelancer.myProject.model.vo.myProjectTrade;

@Service
public class MyProjectServiceImpl_2 implements MyProjectService_2{
	
	@Autowired
	private MyProjectDAO_2 dao;
	
	// 결제 내역
	@Override
	public Map<String, Object> selectPaymentList(Map<String, Object> option, int cp) {
		
		int listCount = dao.getPaymentListCount(option);
		Pagination pagination = new Pagination(listCount, cp);
		List<MyProjectPayment> paymentList = dao.selectPaymentList(option, pagination);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("paymentList", paymentList);
		resultMap.put("pagination", pagination);
		
		return resultMap;
	}
	
	/**
	 * 메인 카테고리 들고 오기
	 */
	@Override
	public List<FreelancerService> selectmaincategoryList() {
		return dao.selectmaincategoryList();
	}

	/**
	 * 카테고리3 들고 오기
	 */
	@Override
	public List<FreelancerService> selectcategoryList() {
		return dao.selectcategoryList();
	}
	
	// 구매 내역 조회
	@Override
	public Map<String, Object> selectPurchaseList(Map<String, Object> option, int cp) {

		int listCount = dao.getPurchaseListCount(option);
		Pagination pagination = new Pagination(listCount, cp);
		List<myProjectTrade> purchaseList = dao.selectPurchaseList(option, pagination);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("purchaseList", purchaseList);
		resultMap.put("pagination", pagination);
		
		return resultMap;
	}
	
	// 회원 작업 완료
	@Override
	public int memberDone(int tradeNo) {
		return dao.memberDone(tradeNo);
	}
	
	
	// 거래 신고하기
	@Override
	public int insertTradeReport(TradeReport inputTradeReport, String webPath, String realPath, MultipartFile reportFile) throws IOException {
		
		
		inputTradeReport.setReportContent(Util.newLineHandling(inputTradeReport.getReportContent()));
		
		// 실패를 대비해서 이전 이미지 경로 저장
		//String temp = reportFile;
		
		// 중복 파일명 업로드를 대비하기 위해서 파일명 변경
		String rename = null;
		String reportFilePath = "";
		
		if(reportFile.getSize() == 0) { // 업로드된 파일이 없는 경우
			inputTradeReport.setFilePath(reportFilePath);
		}else { // 업로드된 파일이 있을 경우
			
			// 원본파일명을 이용해서 새로운 파일명 생성
			rename = Util.fileRename( reportFile.getOriginalFilename() );
			
			reportFilePath = (webPath + rename);
			// /resources/images/memberProfile/변경된파일명
			inputTradeReport.setFilePath(reportFilePath);
		}
		
		int reportedPersonNo = dao.selectReportedPerson(inputTradeReport);
		inputTradeReport.setReportedPersonNo(reportedPersonNo);
		
		int result = dao.insertTradeReport(inputTradeReport);
		if(result>0) {
			
			if (rename != null) {
				// 변경된 이미지명이 있다 == 새로운 파일이 업로드 되었다
				
				reportFile.transferTo(new File(realPath + rename));
				// 메모리에 임시 저장된 파일을 지정된 경로에 파일 형태로 변환
				// == 서버 파일 업로드
			}
		}
		return result;
	}
	
	
	// 주문 취소하기
	@Override
	public int insertTradeReportCancel(TradeReport inputTradeReport, String webPath, String realPath,
			MultipartFile reportFile) throws IOException {
		
		inputTradeReport.setReportContent(Util.newLineHandling(inputTradeReport.getReportContent()));
		
		// 실패를 대비해서 이전 이미지 경로 저장
		//String temp = reportFile;
		
		// 중복 파일명 업로드를 대비하기 위해서 파일명 변경
		String rename = "";
		String reportFilePath = "";
		
		if(reportFile.getSize() == 0) { // 업로드된 파일이 없는 경우
			inputTradeReport.setFilePath(reportFilePath);
		}else { // 업로드된 파일이 있을 경우
			
			// 원본파일명을 이용해서 새로운 파일명 생성
			rename = Util.fileRename( reportFile.getOriginalFilename() );
			
			reportFilePath = (webPath + rename);
			// /resources/images/memberProfile/변경된파일명
			inputTradeReport.setFilePath(reportFilePath);
		}
		
		int reportedPersonNo = dao.selectReportedPerson(inputTradeReport);
		inputTradeReport.setReportedPersonNo(reportedPersonNo);
		
		int result=dao.insertTradeReportCancel(inputTradeReport);
		if(result>0) {
			
			if (rename != null) {
				// 변경된 이미지명이 있다 == 새로운 파일이 업로드 되었다
				
				reportFile.transferTo(new File(realPath + rename));
				// 메모리에 임시 저장된 파일을 지정된 경로에 파일 형태로 변환
				// == 서버 파일 업로드
			}
		}
		
		return result;
	}
	
	
	
	

}















