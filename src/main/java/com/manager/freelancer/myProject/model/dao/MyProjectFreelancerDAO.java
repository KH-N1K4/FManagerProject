package com.manager.freelancer.myProject.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
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

	/**나의 서비스 들고오기
	 * @param memberNo
	 * @param mainCategoryNo 
	 * @return
	 */
	public List<FreelancerService> selectMyService(int memberNo, int mainCategoryNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); //로그인 세션 회원 번호
		map.put("mainCategoryNo", mainCategoryNo); //카테고리별 서비스 들고오기
		return sqlSession.selectList("myProjectFreelancerSerive.selectMyService", map);
	}

	/**판매내역 들고 오기-정렬포함memberNo,freelancerFL,searchInput, mainCategoryNo
	 * @param memberNo
	 * @param freelancerFL
	 * @param searchInput
	 * @param mainCategoryNo
	 * @return
	 */
	public List<FreelancerService> selectSalesList(int memberNo, int freelancerFL, String searchInput,
			int mainCategoryNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); //로그인 세션 회원 번호
		map.put("mainCategoryNo", mainCategoryNo); //카테고리별 판매내역
		map.put("freelancerFL", freelancerFL); //판매 진행상태별 판매내역
		map.put("searchInput", searchInput); //상품명 입력시 상품명으로 판매내역 검색하기
		return sqlSession.selectList("myProjectFreelancerSerive.selectSalesList", map);
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
}
