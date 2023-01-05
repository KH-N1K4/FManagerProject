package com.manager.freelancer.customerCenter.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.customerCenter.model.vo.Pagination;
import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.customerCenter.model.vo.UserInquiryImage;

@Repository
public class UserInquiryDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	/** 이용문의 삽입
	 * @param inputInquiry
	 * @return userInquiryNo
	 */
	public int Inquiryinsert(UserInquiry userInquiry) {
		
		int result = sqlSession.insert("inquiryMapper.userInquiryInsert", userInquiry);
		
		if(result > 0) result = userInquiry.getUserInquiryNo();
		
		return result;
	} 
	
	
	/** 이용문의에 이미지 삽입
	 * @param inquiryImageList
	 * @return
	 */
	public int insertInquiryImageList(List<UserInquiryImage> inquiryImageList) {
		return sqlSession.insert("inquiryMapper.insertInquiryImageList",inquiryImageList);
	}
	
	
	/** 이용 문의 내역 조회하기 
	 * @param memberNo
	 * @return userInquiry
	 */
	public List<UserInquiry> selectInquiryList(int memberNo) {
		return sqlSession.selectList("inquiryMapper.selectInquiryList",memberNo);
	}


	/** 이용 문의 내역 상세보기
	 * @param userInquiryNo
	 * @return
	 */
	public UserInquiry viewInquiryDetail(int userInquiryNo) {
		
		return sqlSession.selectOne("inquiryMapper.viewInquiryDetail",userInquiryNo);
	}


	/** 1. 특정 게시판의 전체 게시글 수 조회 
	 * @param memberNo
	 * @return listCount
	 */
	public int getListCount(int memberNo) {
		return sqlSession.selectOne("inquiryMapper.getListCount", memberNo);
	}


	/** 3. 페이징 처리객체를 이용해서 게시글 목록 조회 
	 * @param pagination
	 * @param memberNo
	 * @return inquiryList
	 */
	public List<UserInquiry> selectInquiryList(Pagination pagination, int memberNo) {
		
		// RowBounds 객체(마이 바티스)
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("inquiryMapper.selectInquiryList", memberNo, rowBounds);
	}


	/** 검색 조건이 일치하는 게시글 수 조회
	 * @param pm
	 * @return getListcount
	 */
	public int getListCount(Map<String, Object> pm) {
		return sqlSession.selectOne("inquiryMapper.getListCount_search", pm);
	}


	/** 검색 조건이 일치하는 게시글 목록 조회 
	 * @param pagination
	 * @param pm
	 * @return inquiryList
	 */
	public List<UserInquiry> selectInquiryList(Pagination pagination, Map<String, Object> pm) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("inquiryMapper.selectInquiryList_search", pm, rowBounds);
	}


	/** 이용문의 내역 조회 (진행상태 변경 시) 리스트 카운트
	 * @param memberNo
	 * @param inquiryStatus
	 * @return
	 */
	public int getStatusListCount(int memberNo, String optionVal) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("optionVal", optionVal);
		
		return sqlSession.selectOne("inquiryMapper.getStatusListCount",map);
	}


	/** 이용문의 내역 조회 (진행상태 변경 시)
	 * @param pagination
	 * @param memberNo
	 * @param inquiryStatus
	 * @return map
	 */
	public List<UserInquiry> userStatusList(Pagination pagination, int memberNo, String optionVal) {
		
		System.out.println("optionVal="+optionVal);
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("memberNo", memberNo);
		map.put("optionVal", optionVal);
		
		return sqlSession.selectList("inquiryMapper.userStatusList",map,rowBounds);
	}

	

	
}
