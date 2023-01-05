package com.manager.freelancer.projectRequest.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.myProject.model.vo.Pagination;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancer;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancerRequest;

/**
 * @author USER
 *
 */
@Repository
public class ProjectRequestDAO {
	
	@Autowired
	private SqlSession sqlSession;

	/**세번 째 카테고리 들고오기 
	 * @return
	 */
	public List<myProjectFreelancerRequest> getCategoryList() {
		
		return sqlSession.selectList("myProjectRequest.getCategoryList");
	}
	
	/**두번 째 카테고리 들고오기 
	 * @return
	 */
	public List<myProjectFreelancerRequest> getSubCategoryList() {
		
		return sqlSession.selectList("myProjectRequest.getSubCategoryList");
	}
	
	/**메인 카테고리 들고오기
	 * @return
	 */
	public List<myProjectFreelancerRequest> getMainCategoryList() {
		
		return sqlSession.selectList("myProjectRequest.getMainCategoryList");
	}

	/**모든 프로젝트 다 들고 오기
	 * @param pagination 
	 * @param thirdCategoryNo 
	 * @param subCategoryNo 
	 * @param mainCategoryNo 
	 * @return
	 */
	public List<myProjectFreelancerRequest> getProjectRequestList(Pagination pagination, int mainCategoryNo, int subCategoryNo, int thirdCategoryNo) {
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit(); // 5페이지일때 4*10(10개 정렬) -> 40개의 게시글을 건너뛰어라
	    RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("thirdCategoryNo",thirdCategoryNo);
		map.put("subCategoryNo",subCategoryNo);
		map.put("mainCategoryNo",mainCategoryNo);
		return sqlSession.selectList("myProjectRequest.getProjectRequestList",map,rowBounds);
	}

	/**모든 프로젝트 다 들고 오기 페이지
	 * @param thirdCategoryNo 
	 * @param subCategoryNo 
	 * @param mainCategoryNo 
	 * @return
	 */
	public int getProjectRequestListCount(int mainCategoryNo, int subCategoryNo, int thirdCategoryNo) {
		Map<String, Object> map = new HashMap<String, Object>();
	    map.put("thirdCategoryNo",thirdCategoryNo);
		map.put("subCategoryNo",subCategoryNo);
		map.put("mainCategoryNo",mainCategoryNo);
		return sqlSession.selectOne("myProjectRequest.getProjectRequestListCount",map);
	}

	/**프로젝트 의뢰 상세보기
	 * @param serviceNo
	 * @return
	 */
	public myProjectFreelancerRequest selectUserRequest(int projectRequestNo) {
	
		return sqlSession.selectOne("myProjectRequest.selectUserRequest",projectRequestNo);
	}

	/**프리랜서 판매건수 들고 옴
	 * @param memberNo
	 * @return
	 */
	public myProjectFreelancer selectMyProjectGrade(int memberNo) {
		return sqlSession.selectOne("myProjectFreelancerSerive.selectFreelancerSalesCoount",memberNo);
	}

	/**프리랜서 정보 들고 오기
	 * @param memberNo
	 * @return
	 */
	public myProjectFreelancer selectFreelancerInfo(int freelancerNo) {

		return sqlSession.selectOne("myProjectRequest.selectFreelancerInfo",freelancerNo);
	}

	/**프로젝트 상세 페이지에서 제안하기 버튼(모달)
	 * @param requestNO
	 * @param proposalpriceInput
	 * @param proposaleditInput
	 * @param proposalMemberNo
	 * @return
	 */
	public int requestDetailSubmit(int requestNO, int proposalpriceInput, int proposaleditInput,
			int proposalMemberNo) {
		Map<String, Object> map = new HashMap<String, Object>();
	    map.put("requestNO",requestNO);
		map.put("proposalpriceInput",proposalpriceInput);
		map.put("proposaleditInput",proposaleditInput);
		map.put("proposalMemberNo",proposalMemberNo);
		return sqlSession.insert("myProjectRequest.requestDetailSubmit",map);
	}
	
}