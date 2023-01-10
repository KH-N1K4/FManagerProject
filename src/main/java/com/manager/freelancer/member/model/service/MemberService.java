package com.manager.freelancer.member.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.category.model.vo.AskService;
import com.manager.freelancer.category.model.vo.Service;
import com.manager.freelancer.member.model.vo.Member;


public interface MemberService {

	int signUp(Member inputMember);

	Member login(Member inputMember);

	// 프로필 사진 있는 경우
	int updateMyInfo(String webPath, String filePath, MultipartFile memberProfile, Member inputMember) throws Exception;

	// 프로필 사진 없는 경우
	int updateMyInfoNonPhoto(Member inputMember);

	int updateInterest(Member inputMember);

	int deleteMember(int memberNo, String memberPw);

	// 비밀번호 변경
	int changePw(Map<String, Object> paramMap);

	Map<String, Object> selectSendServiceInquiry(Map<String, Object> option, int cp);

	AskService selectSendSuggesionContent(String serviceInquiryNo);

	Map<String, Object> selectLikeList(int memberNo, int cp, int category);

	/** 카테고리 선택 찜 목록
	 * @param memberNo
	 * @param cp
	 * @param category
	 * @return
	 */
	Map<String, Object> selectLikeListType(int memberNo, int cp, int category);

}
