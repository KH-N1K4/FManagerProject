package com.manager.freelancer.myProject.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.vo.MyProject;

public interface MyProjectSerive {

	/** 메인 카테고리 들고오기
	 * @return
	 */
	List<MyProject> selectmaincategoryList();

	/** 내 프로젝트 들고오기 + 페이징 처리 
	 * @param memberNo
	 * @param mainCategoryNo
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectMyProject(int memberNo, int mainCategoryNo, int cp, String optionVal);

	/** 메인 3 카테고리 들고오기 
	 * @return
	 */
	List<MyProject> selectcategoryList();

	/** 내 프로젝트 등록
	 * @param webPath
	 * @param filePath
	 * @param myProjectFile
	 * @param loginMember
	 * @param myProject
	 * @return
	 * @throws IOException 
	 */
	int insertMyProject(String webPath, String filePath, List<MultipartFile> myProjectFile, Member loginMember,
			MyProject myProject) throws IOException;

	/** 받은 제안 조회
	 * @param memberNo
	 * @param cp
	 * @param mainCategoryNo
	 * @param myProject
	 * @return
	 */
	Map<String, Object> selectProposal(int memberNo, int cp, int mainCategoryNo, String optionVal);

	/** 내 프로젝트 조회 ajax
	 * @return
	 */
	Map<String, Object> categoryTypeSelect(String optionVal, int cp, int memberNo) ;

	/** 프로젝트 받은 제안 조회 ajax
	 * @param optionVal
	 * @param cp
	 * @param memberNo
	 * @return
	 */
	Map<String, Object> categoryTypeSelect_suggest(String optionVal, int cp, int memberNo);

	/** 받은 제안 채택 및 결제 완료 ajax
	 * @param myProject
	 * @return
	 */
	int completeSuggetionPay(MyProject myProject);

}
