package com.manager.freelancer.myProject.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.customerCenter.model.vo.Pagination;
import com.manager.freelancer.myProject.model.vo.MyProjectPayment;

@Repository
public class MyProjectDAO_2 {
	
	@Autowired 
	private SqlSessionTemplate sqlSession;

	/** 결제 내역 수
	 * @param option
	 * @return
	 */
	public int getPaymentListCount(Map<String, Object> option) {
		return sqlSession.selectOne("myProjectMapper2.getPaymentListCount",option);
	}

	/** 결제 내역 조회
	 * @param option
	 * @param pagination
	 * @return
	 */
	public List<MyProjectPayment> selectPaymentList(Map<String, Object> option, Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("myProjectMapper2.selectPaymentList", option, rowBounds);
	}

}
