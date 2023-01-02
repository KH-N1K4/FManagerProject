package com.manager.freelancer.manager.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.customerCenter.model.vo.Pagination;
import com.manager.freelancer.customerCenter.model.vo.UserInquiry;
import com.manager.freelancer.member.model.vo.Member;

@Repository
public class ManagerInquiryDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 1. 특정 게시판의 전체 게시글 수 조회 
	 * @return
	 */
	public int getListCount() {
		return sqlSession.selectOne("inquiryMapper.getListCount_manager");
	}

	/** 3. 페이징 처리객체를 이용해서 게시글 목록 조회 
	 * @param pagination
	 * @return
	 */
	public List<UserInquiry> selectManagerInquiryList(Pagination pagination) {
		
		// RowBounds 객체(마이 바티스)
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("inquiryMapper.selectInquiryList_manager", rowBounds);
	}

	
	
	/** 검색 조건이 일치하는 게시글 수 조회
	 * @param pm
	 * @return getListcount
	 */
	public int getListCount(Map<String, Object> pm) {
		return sqlSession.selectOne("inquiryMapper.getListCount_searchManager", pm);
	}

	/** 검색 조건이 일치하는 게시글 목록 조회
	 * @param pagination
	 * @param pm
	 * @return inquiryList
	 */
	public List<UserInquiry> selectManagerInquiryList(Pagination pagination, Map<String, Object> pm) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("inquiryMapper.selectManagerInquiryList_search", pm, rowBounds);
	}

	
	/** 관리자 이용문의 내역 상세 보기 조회
	 * @param userInquiryNo
	 * @return result
	 */
	public UserInquiry viewManagerInquiryDetail(int userInquiryNo) {
		return sqlSession.selectOne("inquiryMapper.viewManagerInquiryDetail",userInquiryNo);
	}

	/** 관리자 이용문의 답글 삽입
	 * @param userInquiryNo
	 * @return result
	 */
	public int updateComment(int userInquiryNo, String inputComment, Member loginMember) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", loginMember.getMemberNo());
		map.put("userInquiryNo",userInquiryNo);
		map.put("inputComment",inputComment);
		int result = sqlSession.update("inquiryMapper.updateComment",map);
		
		return result;
	}

	
	
	
	
	
	/** ajax 실험 중 
	 * @param value
	 * @return
	 */
	public int getListCount(String value) {
		return sqlSession.selectOne("inquiryMapper.getMemberListCount", value);
	}

	/** ajax 실험 중 
	 * @param value
	 * @param pagination
	 * @return
	 */
	public List<UserInquiry> selectManagerInquiryList(String value, Pagination pagination) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
}
