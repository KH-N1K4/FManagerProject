package com.manager.freelancer.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.category.model.vo.AskService;
import com.manager.freelancer.category.model.vo.Service;
import com.manager.freelancer.member.model.vo.Member;

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


	public List<Service> selectLikeList(int memberNo) {
		return sqlSession.selectList("categoryMapper.selectLikeList", memberNo);
	}
	
}
