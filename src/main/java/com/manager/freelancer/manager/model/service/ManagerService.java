package com.manager.freelancer.manager.model.service;

import java.util.List;

import com.manager.freelancer.manager.model.vo.Member;

public interface ManagerService {

	/** 회원 리스트 조회
	 * @return
	 */
	List<Member> selectMemberList();

}
