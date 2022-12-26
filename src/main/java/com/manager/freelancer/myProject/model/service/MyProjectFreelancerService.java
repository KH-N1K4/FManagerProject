package com.manager.freelancer.myProject.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.vo.FreelancerService;

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

	/**나의 서비스 들고오기
	 * @param memberNo
	 * @param mainCategoryNo 
	 * @return
	 */
	List<FreelancerService> selectMyService(int memberNo, int mainCategoryNo);

	/**판매 내역 들고오기,loginMember.getMemberNo(),mainCategoryNo,searchInput,freelancerFL
	 * @param memberNo
	 * @param freelancerFL
	 * @param searchInput
	 * @param mainCategoryNo 
	 * @return
	 */
	List<FreelancerService> selectSalesList(int memberNo, int mainCategoryNo, String searchInput, int freelancerFL);

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

}
