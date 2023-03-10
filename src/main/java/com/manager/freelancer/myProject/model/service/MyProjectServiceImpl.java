package com.manager.freelancer.myProject.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.common.Util;
import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.dao.MyProjectDAO;
import com.manager.freelancer.myProject.model.vo.MyProject;
import com.manager.freelancer.myProject.model.vo.Pagination;
import com.manager.freelancer.myProject.model.vo.RequestFile;


@Service
public class MyProjectServiceImpl implements MyProjectSerive{
	
	@Autowired
	private MyProjectDAO dao;

	/**
	 * 메인 카테고리 들고 오기
	 */
	@Override
	public List<MyProject> selectmaincategoryList() {
		return dao.selectmaincategoryList();
	}

	/**
	 * 나의 프로젝트 들고오기 페이지 처리
	 */
	@Override
	public Map<String, Object> selectMyProject(int memberNo, int mainCategoryNo, int cp, String optionVal) {
		
		int listCount = dao.getMyProjectListCount( memberNo, mainCategoryNo,optionVal);
		
		Pagination pagination = new Pagination(listCount,cp); 
		
		List<MyProject> myProject = dao.selectMyProject(memberNo,mainCategoryNo,pagination,optionVal);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("myProject",myProject);
		map.put("listCount",listCount);
		map.put("optionVal",optionVal);
		
		
		return map;
	}

	/**
	 * 카테고리3 들고 오기
	 */
	@Override
	public List<MyProject> selectcategoryList() {
		return dao.selectcategoryList();
	}

	/**
	 * 내 프로젝트 등록
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertMyProject(String webPath, String filePath, List<MultipartFile> myProjectFile, Member loginMember,
			MyProject myProject)  throws IOException {
		
		// 1) XSS(크로스 사이트 스크립트 공격), 개행문자 처리
		myProject.setProjectRequestTitle(Util.XSSHandling(myProject.getProjectRequestTitle()));
		myProject.setProjectRequestSummary(Util.XSSHandling(myProject.getProjectRequestSummary()));
		myProject.setProjectRequestContent(Util.newLineHandling(myProject.getProjectRequestContent()));
		
		int projectNo = dao.insertMyProject(myProject,loginMember);
		
		// 2) 첨부만 삽입 
		if(projectNo > 0) { 
			
			List<RequestFile> projectFileList = new ArrayList<RequestFile>();
			List<String> reNameList = new ArrayList<String>();
			
			for (int i = 0; i < myProjectFile.size(); i++) {

				// i번째 파일의 크기가 0보다 크다 == 업로드된 파일이 있다.
				if (myProjectFile.get(i).getSize() > 0) {

					// UserInquiryImage 객체 생성
					RequestFile img = new RequestFile();

					// UserInquiryImage 값 세팅
					img.setRequestFilePath(webPath);

					String reNameImg = Util.fileRename(myProjectFile.get(i).getOriginalFilename());
					img.setRequestFilePath(webPath+reNameImg);
					img.setProjectRequestNo(projectNo); // 첨부된 게시글 번호
					img.setRequestFileOrder(i); // 이미지 순서

					// BoardImageList에 추가
					projectFileList.add(img);
					reNameList.add(reNameImg);

				} // if 끝
			} // for 끝
			
			// boardImageList가 비어있지 않다면
			// == 업로드된 파일이 있어서 분류된 내용이 존재
			if (!projectFileList.isEmpty()) {

				// DB에 업로드된 파일 정보 INSERT
				int result = dao.insertProjectFileList(projectFileList);

				// 삽입 결과 행의 수 == DB에 삽입하려고 분류한 리스트의 크기
				// 전부 다 삽입된 경우
				if (result == projectFileList.size()) {

					// 파일 변환 작업
					for (int i = 0; i < projectFileList.size(); i++) {

						// 순서 == imageList의 인덱스
						int index = projectFileList.get(i).getRequestFileOrder();

						// 실제 파일로 변환
						myProjectFile.get(index).transferTo(new File(filePath + reNameList.get(i)));
					}
				}
			}
		} 
		
		
		return projectNo;
	}

	// 받은 제안 조회 
	@Override
	public Map<String, Object> selectProposal(int memberNo, int cp, int mainCategoryNo, String optionVal) {
		
		int listCount = dao.getSuggestTypeCount(optionVal, memberNo);
		
		Pagination pagination = new Pagination(listCount,cp); 
		
		List<MyProject> proposal = dao.categoryTypeSelect_suggest(optionVal,pagination,memberNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("proposal",proposal);
		map.put("listCount",listCount);
		map.put("optionVal",optionVal);
		
		return map;
	}

	// 내 프로젝트 조회 ajax
	@Override
	public Map<String, Object> categoryTypeSelect(String optionVal,int cp, int memberNo) {
		
		int listCount = dao.getChangeTypeCount(optionVal, memberNo);
		
		Pagination pagination = new Pagination(listCount,cp); 
		
		List<MyProject> myProject = dao.categoryTypeSelect(optionVal,pagination,memberNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("myProject",myProject);
		map.put("listCount",listCount);
		map.put("optionVal",optionVal);
		
		return map;
	}

	// 프로젝트 받은 제안 조회 ajax
	@Override
	public Map<String, Object> categoryTypeSelect_suggest(String optionVal, int cp, int memberNo) {
		
		int listCount = dao.getSuggestTypeCount(optionVal, memberNo);
		
		Pagination pagination = new Pagination(listCount,cp); 
		
		List<MyProject> proposal = dao.categoryTypeSelect_suggest(optionVal,pagination,memberNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("proposal",proposal);
		map.put("listCount",listCount);
		map.put("optionVal",optionVal);
		
		return map;
	}

	// 받은 제안 채택 및 결제 ajax
	@Override
	public int completeSuggetionPay(MyProject myProject) {
		
		myProject.setTradeRequest(Util.newLineHandling(myProject.getProjectRequestContent()));		
		
		return dao.completeSuggetionPay(myProject);
	}

}
