package com.manager.freelancer.member.model.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.member.model.vo.Member;


public interface MemberService {

	int signUp(Member inputMember);

	Member login(Member inputMember);

	int updateMyInfo(String webPath, String filePath, MultipartFile memberProfile, Member inputMember) throws Exception;

	int updateProfile(String webPath, String filePath, MultipartFile profileImage, Member loginMember) throws Exception;

}
