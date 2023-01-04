package com.manager.freelancer.myProject.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.customerCenter.model.vo.Pagination;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.myProject.model.vo.MyProjectPayment;
import com.manager.freelancer.myProject.model.vo.myProjectTrade;

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

	/** 구매 내역 수
	 * @param option
	 * @return
	 */
	public int getPurchaseListCount(Map<String, Object> option) {
		return sqlSession.selectOne("myProjectMapper2.getPurchaseListCount",option);
	}

	/** 구매 내역 목록
	 * @param option
	 * @param pagination
	 * @return
	 */
	public List<myProjectTrade> selectPurchaseList(Map<String, Object> option, Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("myProjectMapper2.selectPurchaseList", option, rowBounds);
	}

	public int memberDone(int tradeNo) {
		return sqlSession.update("myProjectMapper2.memberDone",tradeNo);
	}

}
