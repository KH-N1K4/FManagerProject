package com.manager.freelancer.customerCenter.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	

	
}
