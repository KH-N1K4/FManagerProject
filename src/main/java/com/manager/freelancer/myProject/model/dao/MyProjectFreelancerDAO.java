package com.manager.freelancer.myProject.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.myProject.model.vo.Pagination;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancerProfit;
import com.manager.freelancer.myProject.model.vo.myProjectServiceInquiry;

@Repository
public class MyProjectFreelancerDAO {
	
	@Autowired
	private SqlSession sqlSession;

	/**메인 카데고리 들고오기
	 * @return List<FreelancerService> 카테고리 리스트
	 */
	public List<FreelancerService> selectmaincategoryList() {
		
		return sqlSession.selectList("myProjectFreelancerSerive.selectmaincategoryList");
	}

	/**메인3 카테고리 들고오기
	 * @return List<FreelancerService> 카테고리 리스트
	 */
	public List<FreelancerService> selectcategoryList() {
		
		return sqlSession.selectList("myProjectFreelancerSerive.selectcategoryList");
	}

	/** 나의 서비스 등록하기
	 * @param freelancerVo
	 * @param loginMember
	 * @return serviceNum 등록한 서비스 번호 바로 들고 오기(맞는 지 확인 요망!!!)
	 */
	public int insertService(FreelancerService freelancerVo, Member loginMember) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("freelancerVo", freelancerVo); //입력한 서비스 값
		map.put("loginMember", loginMember.getMemberNo());
		sqlSession.insert("myProjectFreelancerSerive.insertService", map);
		int serviceNum = (int)map.get("serviceNo");
		return serviceNum;
	}

	/** 나의 서비스 등록하기에서 들고온 서비스 번호와 합쳐 서비스 이미지 등록하기
	 * @param servicefileList
	 * @return 
	 */
	public int insertFileImageList(List<myProjectServiceInquiry> servicefileList) {
		
		return sqlSession.insert("myProjectFreelancerSerive.insertFileImageList", servicefileList);
	}

	/**나의 서비스 페이지 카운트
	 * @param memberNo
	 * @param mainCategoryNo
	 * @return
	 */
	public int getMyServiceListCount(int memberNo, int mainCategoryNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); 
		map.put("mainCategoryNo", mainCategoryNo);
		return sqlSession.selectOne("myProjectFreelancerSerive.getMyServiceListCount", map);
	}
	
	/**나의 서비스 들고오기 검색 할때 씀
	 * @param memberNo
	 * @param i
	 * @return
	 */
	public List<FreelancerService> selectMyService(int memberNo, int i) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); //로그인 세션 회원 번호
		map.put("mainCategoryNo", i); //카테고리별 서비스 들고오기
		return sqlSession.selectList("myProjectFreelancerSerive.selectMyServiceInput", map);
	}
	
	/**나의 서비스 들고오기 페이지 처리
	 * @param memberNo
	 * @param mainCategoryNo 
	 * @param pagination 
	 * @return
	 */
	public List<FreelancerService> selectMyService(int memberNo, int mainCategoryNo, Pagination pagination) {
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit(); // 5페이지일때 4*10(10개 정렬) -> 40개의 게시글을 건너뛰어라
	    RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); //로그인 세션 회원 번호
		map.put("mainCategoryNo", mainCategoryNo); //카테고리별 서비스 들고오기
		return sqlSession.selectList("myProjectFreelancerSerive.selectMyService", map,rowBounds);
	}

	/**판매내역 들고 오기 페이징 처리
	 * @param memberNo
	 * @param freelancerFL
	 * @param searchInput
	 * @param mainCategoryNo
	 * @return
	 */
	public int getSalesListCount(int memberNo, int freelancerFL, String searchInput, int mainCategoryNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); 
		map.put("mainCategoryNo", mainCategoryNo);
		map.put("freelancerFL", freelancerFL);
		map.put("searchInput", searchInput);
		return sqlSession.selectOne("myProjectFreelancerSerive.getSalesListCount", map);
	}
	
	/**판매내역 들고 오기-정렬포함memberNo,freelancerFL,searchInput, mainCategoryNo
	 * @param memberNo
	 * @param freelancerFL
	 * @param searchInput
	 * @param mainCategoryNo
	 * @return
	 */
	public List<FreelancerService> selectSalesList(int memberNo, int freelancerFL, String searchInput,
			int mainCategoryNo, Pagination pagination) {
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit(); // 5페이지일때 4*10(10개 정렬) -> 40개의 게시글을 건너뛰어라
	    RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); //로그인 세션 회원 번호
		map.put("mainCategoryNo", mainCategoryNo); //카테고리별 판매내역
		map.put("freelancerFL", freelancerFL); //판매 진행상태별 판매내역
		map.put("searchInput", searchInput); //상품명 입력시 상품명으로 판매내역 검색하기
		return sqlSession.selectList("myProjectFreelancerSerive.selectSalesList", map,rowBounds);
	}

	/**신고하기
	 * @param reportFilePath
	 * @param tradeNo
	 * @param reportPersonNo
	 * @param reportedPersonNo
	 * @param reportContent
	 * @return
	 */
	public int insertreportSubmit(String reportFilePath, int tradeNo, int reportPersonNo, int reportedPersonNo,
			String reportContent) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reportFilePath", reportFilePath); 
		map.put("tradeNo", tradeNo); 
		map.put("reportPersonNo", reportPersonNo); 
		map.put("reportedPersonNo", reportedPersonNo); 
		map.put("reportContent", reportContent); 
		sqlSession.insert("myProjectFreelancerSerive.insertreportSubmit", map);
		int tradeReportNo = (int)map.get("tradeReportNo");
		return tradeReportNo;
	}

	/**작업물 발송하기
	 * @param tradeNo
	 * @return
	 */
	public int insertsendworkSubmit(int tradeNo) {
		return sqlSession.insert("myProjectFreelancerSerive.insertsendworkSubmit",tradeNo);
	}

	/**거래 프리랜서 작업상태 완료로 변경하기
	 * @param tradeNo
	 * @return
	 */
	public int insertfinishSubmit(int tradeNo) {
		return sqlSession.update("myProjectFreelancerSerive.insertfinishSubmit",tradeNo);
	}

	/**프리랜서가 한 프로젝트 의뢰 제안 들고오기
	 * @param memberNo
	 * @param mainCategoryNo
	 * @return
	 */
	public List<FreelancerService> selectMyProposal(int memberNo, int mainCategoryNo , Pagination pagination ) {
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit(); // 5페이지일때 4*10(10개 정렬) -> 40개의 게시글을 건너뛰어라
	    RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); 
		map.put("mainCategoryNo", mainCategoryNo); 
		return sqlSession.selectList("myProjectFreelancerSerive.selectMyProposal",map,rowBounds);
	}

	/**프리랜서가 한 프로젝트 의뢰 제안 페이징 카운트 
	 * @param memberNo
	 * @param mainCategoryNo
	 * @return
	 */
	public int getMyProposalListCount(int memberNo, int mainCategoryNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); 
		map.put("mainCategoryNo", mainCategoryNo);
		return sqlSession.selectOne("myProjectFreelancerSerive.getMyProposalListCount", map);
	}

	/**나의 달별 총 수익 들고오기
	 * @param memberNo
	 * @return
	 */
	public List<myProjectFreelancerProfit> selectMonthMyProfit(int memberNo) {
		return sqlSession.selectList("myProjectFreelancerSerive.selectMonthMyProfit", memberNo);
	}

	/**검색해오는 시검의 1년간 총 수익이랑 예상 수익 들고오기
	 * @param memberNo
	 * @return
	 */
	public List<myProjectFreelancerProfit> selectMyProfit(int memberNo) {
		return sqlSession.selectList("myProjectFreelancerSerive.selectMyProfit", memberNo);
	}

	/**거래별 정산 내역 출력
	 * @param memberNo
	 * @param pagination 
	 * @param endtDate 
	 * @param startDate 
	 * @return
	 */
	public List<myProjectFreelancerProfit> selectMyProfitEachList(int memberNo, Pagination pagination, String startDate, String endtDate) {
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit(); // 5페이지일때 4*10(10개 정렬) -> 40개의 게시글을 건너뛰어라
	    RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
	    Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); 
		map.put("startDate", startDate);
		map.put("endtDate", endtDate);
		return sqlSession.selectList("myProjectFreelancerSerive.selectMyProfitEachList", map,rowBounds);
	}

	/**거래별 정산 내역 출력 페이지
	 * @param memberNo
	 * @return
	 */
	public int getMyProfitEachListCount(int memberNo, String startDate, String endtDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); 
		map.put("startDate", startDate);
		map.put("endtDate", endtDate);
		return sqlSession.selectOne("myProjectFreelancerSerive.getMyProfitEachListCount", map);
	}


	
}
