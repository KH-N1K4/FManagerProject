package com.manager.freelancer.customerCenter.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.customerCenter.model.vo.UserInquiry;

@Repository
public class UserInquiryDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 이용문의 등록하기
	 * @param inputInquiry
	 * @return result
	 */
	public int userInquiryInsert(UserInquiry inputInquiry) {
		
		int result = 0; 
		
		result = sqlSession.insert("inquiryMapper.userInquiryInsert",inputInquiry);
		
		if(result > 0) {
			
			if(inputInquiry.getInquiryFileNo() != 0) {
				
				result = sqlSession.insert("inquiryMapper.addImage",inputInquiry);
				
			} 
			
		} 
		
		return result;
	}

	/** 이용문의 내역 조회하기 
	 * @param memberNo
	 * @return userInquiry
	 */
	public List<UserInquiry> selectInquiryList(int memberNo) {
		return sqlSession.selectList("inquiryMapper.selectInquiryList",memberNo);
	} 
}
