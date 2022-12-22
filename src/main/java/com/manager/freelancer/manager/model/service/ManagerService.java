package com.manager.freelancer.manager.model.service;

import java.util.List;
import java.util.Map;

import com.manager.freelancer.manager.model.vo.Member;

public interface ManagerService {

	/** 회원 목록 조회 + 페이징
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectMemberList(int cp);

}
