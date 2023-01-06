package com.manager.freelancer.myProject.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.myProject.model.vo.TradeReport;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.myProject.model.vo.Review;

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

	/** 회원 작업 완료
	 * @param tradeNo
	 * @return
	 */
	int memberDone(int tradeNo);

	/** 거래 신고하기
	 * @param inputTradeReport
	 * @param filePath 
	 * @param webPath 
	 * @param reportFile 
	 * @return
	 */
	int insertTradeReport(TradeReport inputTradeReport, String webPath, String realPath, MultipartFile reportFile) throws IOException ;

	/** 주문 취소하기
	 * @param inputTradeReport
	 * @param webPath
	 * @param filePath
	 * @param reportFile
	 * @return
	 */
	int insertTradeReportCancel(TradeReport inputTradeReport, String webPath, String realPath,
			MultipartFile reportFile) throws IOException;

	/** 리뷰 등록
	 * @param inputReview
	 * @param webPath
	 * @param realPath
	 * @param reviewFile
	 * @return
	 */
	int insertReview(Review inputReview, String webPath, String realPath, MultipartFile reviewFile) throws IOException;

}
