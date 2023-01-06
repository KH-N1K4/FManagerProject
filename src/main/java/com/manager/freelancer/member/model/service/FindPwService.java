package com.manager.freelancer.member.model.service;

import java.util.Map;

import com.manager.freelancer.member.model.vo.Member;

public interface FindPwService {

	/** 입력된 정보로 회원 찾기
	 * @param inputMember
	 * @return
	 */
	int findInfo(Member inputMember);

	/** 새 비밀번호
	 * @param map
	 * @return
	 */
	int changeRanPw(Map<String, Object> map);
	

}
