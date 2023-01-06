package com.manager.freelancer.projectRequest.model.service;

import java.util.List;
import java.util.Map;

import com.manager.freelancer.myProject.model.vo.myProjectFreelancer;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancerRequest;

public interface ProjectRequestSerivce {

	/**프로젝트 목록 조회
	 * @param cp
	 * @param mainCategoryNo
	 * @param subCategoryNo
	 * @param thirdCategoryNo
	 * @param budgetInt1 
	 * @param budgetInt0 
	 * @param listOrder 
	 * @return
	 */
	Map<String, Object> getCategotyList(int cp, int mainCategoryNo, int subCategoryNo, int thirdCategoryNo, int budgetInt0, int budgetInt1, int listOrder);

	/**프로젝트 의뢰 상세보기
	 * @param serviceNo
	 * @return
	 */
	myProjectFreelancerRequest selectUserRequest(int projectRequestNo);

	/**프로젝트 의뢰 페이지에서 제안하면 프리랜서 판매건수 들고 옴
	 * @param memberNo
	 * @return
	 */
	myProjectFreelancer selectMyProjectGrade(int memberNo);

	/**프로젝트 의뢰 페이지에서 제안하면 프리랜서 본인 정보
	 * @param memberNo
	 * @return
	 */
	myProjectFreelancer selectFreelancerInfo(int memberNo);

	/**프로젝트 상세 페이지에서 제안하기 버튼(모달)
	 * @param requestNO
	 * @param proposalpriceInput
	 * @param proposaleditInput
	 * @param proposalMemberNo
	 * @return
	 */
	String requestDetailSubmit(int requestNO, int proposalpriceInput, int proposaleditInput, int proposalMemberNo);

	/**프로젝트 상세 페이지에서 판매중지
	 * @param requestNO
	 * @return
	 */
	String requestStopSubmit(int requestNO);

	/**모집 마감입박순 /최신순
	 * @param listOrder
	 * @param thirdCategoryNo 
	 * @param subCategoryNo 
	 * @param mainCategoryNo 
	 * @param cp 
	 * @param budgetInt1 
	 * @param budgetInt0 
	 * @return
	 */
	Map<String, Object> listOrderSelect(int listOrder, int mainCategoryNo, int subCategoryNo, int thirdCategoryNo, int cp, int budgetInt0, int budgetInt1);

}
