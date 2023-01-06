package com.manager.freelancer.category.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.category.model.vo.AskService;
import com.manager.freelancer.category.model.vo.Category;
import com.manager.freelancer.category.model.vo.Freelancer1;
import com.manager.freelancer.category.model.vo.ImageFile;
import com.manager.freelancer.category.model.vo.Service;
import com.manager.freelancer.category.model.vo.Trade;
import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.manager.model.vo.Pagination;
import com.manager.freelancer.myProject.model.vo.FreelancerService;

@Repository
public class CategoryDAO {
	
	@Autowired
	private SqlSession sqlSession;

	
	// nav, sub 카테고리 출력용
	public List<Map<String, Object>> selectMainCategoryList() {
		
		return sqlSession.selectList("categoryMapper.selectMainCategoryList");
	}

	public List<Map<String, Object>> selectSubCategoryList() {
		return sqlSession.selectList("categoryMapper.selectSubCategoryList");
	}

	public List<Map<String, Object>> selectThirdCategoryList() {
		return sqlSession.selectList("categoryMapper.selectThirdCategoryList");
	}

	
	// 서비스 상세보기
	public Service viewService(int serviceNo) {
		return sqlSession.selectOne("categoryMapper.viewService",serviceNo);
	}

	// 서비스 문의 
	public int askService(AskService as) {
		return sqlSession.insert("categoryMapper.askService",as);
	}

	// 프리랜서가 서비스 중단하기
	public int pauseService(int serviceNo) {
		return sqlSession.update("categoryMapper.pauseService",serviceNo);
	}

	
	// 찜 확인
	public int serviceLikeCheck(Map<String, Object> map) {
		return sqlSession.selectOne("categoryMapper.serviceLikeCheck",map);
	}

	// 찜하기
	public int boardLikeUp(Map<String, Object> paramMap) {
		return sqlSession.insert("categoryMapper.serviceLikeUp",paramMap);
	}

	
	// 찜 취소하기
	public int boardLikeDown(Map<String, Object> paramMap) {
		return sqlSession.delete("categoryMapper.serviceLikeDown",paramMap);
	}

	
//	ajax 분류에 따라 조회되게
	public List<Service> selectCategoryList(Pagination pagination, Map map) {
		
		int offset=(pagination.getCurrentPage()-1)*pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("categoryMapper.selectCategoryList",map,rowBounds);
	}
	
	
	
	// 페이징 처리를 위한 서비스 개수세기
	public int getListCount(Map<String, Integer> map) {
		
		return sqlSession.selectOne("categoryMapper.getListCount", map);
	}
	
	//
	public List<Service> selectBoardList(Map<String, Integer> map, Pagination pagination) {
		
		int offset=(pagination.getCurrentPage()-1)*pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("categoryMapper.selectBoardList",map,rowBounds);
	}
	
	
	public List<Service> mainServiceList(Pagination pagination, Map<String, Integer> map) {
		
		int offset=(pagination.getCurrentPage()-1)*pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("categoryMapper.serviceList",map,rowBounds);
	}

	public int tradeComplete(Trade temp) {
		
		int result=sqlSession.insert("categoryMapper.tradeComplete",temp);
		
		if(result>0) {
			result=sqlSession.insert("categoryMapper.insertSettlement",temp);
		}
			
			
		result=temp.getTradeNo();
		
		return result;
	}

	public Freelancer1 freelancerDetail(int freelancerNo) {
		
		
		return sqlSession.selectOne("categoryMapper.freelancerInfo", freelancerNo);
	}

	public int reportReview(int reviewNo) {
		return sqlSession.insert("categoryMapper.reportReview", reviewNo);
	}

	public int updateReviewStatus(int reviewNo) {
		return sqlSession.update("categoryMapper.updateReviewStatus", reviewNo);
	}

	public int writeComment(Map<String, Object> map) {
		return sqlSession.insert("categoryMapper.writeComment", map);
	}

	public int selectSaleCount(int freelancerNo) {
		
		return sqlSession.selectOne("categoryMapper.selectFreelancerSalesCoount", freelancerNo);
	}

	

	


}
