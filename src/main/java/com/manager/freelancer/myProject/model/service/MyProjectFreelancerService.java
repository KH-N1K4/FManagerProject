package com.manager.freelancer.myProject.model.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancer;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancerProfit;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancerRequest;

public interface MyProjectFreelancerService {

	/**메인 카테고리 들고오기
	 * @return
	 */
	List<FreelancerService> selectmaincategoryList();

	/**메인3 카테고리 들고오기 
	 * @return
	 */
	List<FreelancerService> selectcategoryList();

	/**서비스 등록하기
	 * @param webPath
	 * @param filePath
	 * @param serviceFile
	 * @param loginMember
	 * @param freelancerVo
	 * @return
	 * @throws IOException
	 */
	int insertService(String webPath, String filePath, List<MultipartFile> serviceFile, Member loginMember,
			FreelancerService freelancerVo) throws IOException;
	
	/**페이지 처리 안하는 나의 서비스
	 * @param memberNo
	 * @param i
	 * @return
	 */
	List<FreelancerService> selectMyService(int memberNo, int i);
	
	/**나의 서비스 들고오기 -- 페이지 처리하는 나의 서비스
	 * @param memberNo
	 * @param mainCategoryNo 
	 * @return
	 */
	Map<String, Object> selectMyService(int memberNo, int mainCategoryNo, int cp);

	/**판매 내역 들고오기,loginMember.getMemberNo(),mainCategoryNo,searchInput,freelancerFL
	 * @param memberNo
	 * @param freelancerFL
	 * @param searchInput
	 * @param mainCategoryNo 
	 * @param cp 
	 * @return
	 */
	Map<String, Object> selectSalesList(int memberNo, int mainCategoryNo, String searchInput, int freelancerFL, int cp);

	/** 신고하기
	 * @param filePath 
	 * @param webPath 
	 * @param tradeNo
	 * @param reportPersonNo
	 * @param reportedPersonNo
	 * @param reportContent
	 * @param reportFile
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> insertreportSubmit(String webPath, String filePath, int tradeNo, int reportPersonNo, int reportedPersonNo, String reportContent,
			MultipartFile reportFile)  throws Exception;

	/** 작업물 발송하기
	 * @param tradeNo
	 * @return
	 */
	String insertsendworkSubmit(int tradeNo) throws Exception;

	/**거래 프리랜서 작업상태 완료하기
	 * @param tradeNo
	 * @return
	 */
	String insertfinishSubmit(int tradeNo) throws Exception;

	/**프리랜서가 한 프로젝트 의뢰 제안 들고오기
	 * @param memberNo
	 * @param mainCategoryNo
	 * @param cp 
	 * @return
	 */
	Map<String, Object> selectMyProposal(int memberNo, int mainCategoryNo, int cp);

	/**나의 달별 총 수익 들고오기
	 * @param memberNo
	 * @return
	 */
	List<myProjectFreelancerProfit> selectMonthMyProfit(int memberNo);

	/** 검색해오는 시검의 1년간 총 수익이랑 예상 수익 들고오기
	 * @param memberNo
	 * @return
	 */
	List<myProjectFreelancerProfit> selectMyProfit(int memberNo);

	/** 거래별 정산 내역 출력
	 * @param memberNo
	 * @param cp 
	 * @param endtDate 
	 * @param startDate 
	 * @return
	 */
	Map<String, Object> selectMyProfitEachList(int memberNo, int cp, String startDate, String endtDate);

	/**서비스 문의 내역
	 * @param memberNo
	 * @param cp
	 * @param startDate
	 * @param endtDate
	 * @param mainCategoryNo
	 * @param searchInput
	 * @return
	 */
	Map<String, Object> myServiceInquiry(int memberNo, int cp, String startDate, String endtDate, int mainCategoryNo,
			String searchInput);

	/**나의 등급 조건들고 오기
	 * @param memberNo
	 * @return
	 */
	myProjectFreelancer selectMyProjectGrade(int memberNo,int typeVal);

	/**프매니저 사이트 등급 조건 들고 오기
	 * @return
	 */
	List<myProjectFreelancer> selectBasicGrade();

	/**전체 등급 조건들고 오기
	 * @param memberNo
	 * @return
	 */
	List<myProjectFreelancer> selectFreelancerListALL(int typeVal);

	/**프리랜서 등급 상승
	 * @param seccessMember
	 * @return
	 */
	int LevelUPSchedulingUpdate(List<myProjectFreelancer> seccessMember);

	/**프리랜서 등급 하락
	 * @param downMember
	 * @return
	 */
	int LevelDownSchedulingUpdate(List<myProjectFreelancer> downMember);

	/**스케줄러 모집마감일 지났을 때 상태 변경
	 * @param date
	 * @return
	 */
	List<myProjectFreelancerRequest> selectProjectRecruitDate(String date);

	/**조회해온 것들 모집 마감 상태 값으로 변경
	 * @param updateProject
	 * @return
	 */
	int updateRecruitDateScheduling(List<myProjectFreelancerRequest> updateProject);





}
