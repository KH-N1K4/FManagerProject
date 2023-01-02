package com.manager.freelancer.myProject.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.myProject.model.vo.MyProject;
import com.manager.freelancer.myProject.model.vo.Pagination;

@Repository
public class MyProjectDAO {

	@Autowired
	private SqlSession sqlSession;

	/** 메인 카데고리 들고오기
	 *  @return List<MyProject> 카테고리 리스트 
	 */
	public List<MyProject> selectmaincategoryList() {
		
		return sqlSession.selectList("myProjectMapper.selectmaincategoryList");
	}

	/** 나의 프로젝트 페이지 카운트
	 * @param memberNo
	 * @param mainCategoryNo
	 * @return
	 */
	public int getMyProjectListCount(int memberNo, int mainCategoryNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); 
		map.put("mainCategoryNo", mainCategoryNo);
		return sqlSession.selectOne("myProjectMapper.getMyProjectListCount", map);
	}

	/** 나의 프로젝트 들고오기 페이지 처리
	 * @param memberNo
	 * @param mainCategoryNo
	 * @param pagination
	 * @return
	 */
	public List<MyProject> selectMyProject(int memberNo, int mainCategoryNo, Pagination pagination) {
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit(); // 5페이지일때 4*10(10개 정렬) -> 40개의 게시글을 건너뛰어라
	    RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); //로그인 세션 회원 번호
		map.put("mainCategoryNo", mainCategoryNo); //카테고리별 서비스 들고오기
		return sqlSession.selectList("myProjectMapper.selectMyProject", map,rowBounds);
	}
	
}
