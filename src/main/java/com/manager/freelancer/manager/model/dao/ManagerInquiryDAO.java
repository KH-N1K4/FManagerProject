package com.manager.freelancer.manager.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.customerCenter.model.vo.Pagination;
import com.manager.freelancer.customerCenter.model.vo.UserInquiry;

@Repository
public class ManagerInquiryDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 1. 특정 게시판의 전체 게시글 수 조회 
	 * @return
	 */
	public int getListCount() {
		return sqlSession.selectOne("managerInquiry.getListCount");
	}

	/** 3. 페이징 처리객체를 이용해서 게시글 목록 조회 
	 * @param pagination
	 * @return
	 */
	public List<UserInquiry> selectManagerInquiryList(Pagination pagination) {
		
		// RowBounds 객체(마이 바티스)
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("managerInquiry.selectManagerInquiryList", rowBounds);
	}

	
	
	
	
	
}
