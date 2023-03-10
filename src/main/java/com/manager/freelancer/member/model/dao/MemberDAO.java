package com.manager.freelancer.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.category.model.vo.AskService;
import com.manager.freelancer.category.model.vo.Service;
import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.member.model.vo.Pagination;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	/** 회원가입 DAO
	 * @param inputMember
	 * @return
	 */
	public int signUp(Member inputMember) {
		return sqlSession.insert("memberMapper.signUp",inputMember);
	}

	
	/** 회원가입 관심사 삽입
	 * @param map
	 * @return
	 */
	public int insertInterest(Map map) {
		return sqlSession.insert("memberMapper.insertInterest", map);
	}
	
	
	

	/** 로그인 DAO
	 * @param memberEmail
	 * @return loginMember
	 */
	public Member login(String memberEmail) {
	
		return sqlSession.selectOne("memberMapper.login", memberEmail);
	}


	
	
	
	public int updateMyInfo(Member inputMember) {
		return sqlSession.update("memberMapper.updateMyInfo", inputMember);
	}


	public int updateMyInfoNonPhoto(Member inputMember) {
		return sqlSession.update("memberMapper.updateMyInfoNonPhoto", inputMember);
	}


	public int updateInterest(Member inputMember) {
		
		return sqlSession.delete("memberMapper.updateInterest", inputMember);
	}
	
	/** 암호회된 비밀번호 조회 DAO
	 * @param memberNo
	 * @return encPw
	 */
	public String selectEncPw(int memberNo) {
		
		return sqlSession.selectOne("memberMapper.selectEncPw", memberNo);
	}
	
	/** 회원 탈퇴 DAO
	 * @param memberNo
	 * @return result
	 */
	public int changeDelFl(int memberNo) {
		
		return sqlSession.update("memberMapper.changeDelFl",memberNo);
	}
	
	/** 비밀번호 변경 DAO
	 * @param paramMap
	 * @return result 
	 */
	public int changePw(Map<String, Object> paramMap) {
		return sqlSession.update("memberMapper.changePw",paramMap);
	}


	public List<AskService> selectSendSuggestion(int memberNo) {
		
		return sqlSession.selectList("categoryMapper.selectSendSuggesion", memberNo);
	}


	public AskService selectSendSuggesionContent(String serviceInquiryNo) {
		return  sqlSession.selectOne("categoryMapper.selectSendSuggesionContent", serviceInquiryNo);
	}


	public List<com.manager.freelancer.category.model.vo.Service> selectLikeList(int memberNo, Pagination pagination) {
		
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		
		return sqlSession.selectList("categoryMapper.selectLikeList", memberNo,rowBounds);
	}


	/** 찜 목록 수
	 * @param memberNo
	 * @return
	 */
	public int getLikeListCount(int memberNo) {
		return sqlSession.selectOne("categoryMapper.getLikeListCount", memberNo);
	}


	/** 카테고리 선택 찜 목록 수
	 * @param option
	 * @return
	 */
	public int getLikeListCount2(Map<String, Object> option) {
		return sqlSession.selectOne("categoryMapper.getLikeListCount2", option);
	}


	/** 카테고리 선택 찜 목록
	 * @param option
	 * @return
	 */
	public List<Service> selectLikeList2(Map<String, Object> option, Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		
		//return sqlSession.selectList("categoryMapper.selectLikeList", memberNo,rowBounds);
		
		return sqlSession.selectList("categoryMapper.selectLikeList2", option, rowBounds);
	}


	/** 서비스 문의 수
	 * @param option
	 * @return
	 */
	public int getServiceInquiryListCount(Map<String, Object> option) {
		return sqlSession.selectOne("memberMapper.getServiceInquiryListCount",option);
	}

 
	/** 서비스 문의 목록
	 * @param option
	 * @param pagination
	 * @return
	 */
	public List<AskService> selectServiceInquiryList(Map<String, Object> option, Pagination pagination) {
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("memberMapper.selectServiceInquiryList", option, rowBounds);
	}
	
}
