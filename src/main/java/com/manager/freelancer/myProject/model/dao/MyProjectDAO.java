package com.manager.freelancer.myProject.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.vo.MyProject;
import com.manager.freelancer.myProject.model.vo.Pagination;
import com.manager.freelancer.myProject.model.vo.RequestFile;

@Repository
public class MyProjectDAO {

	@Autowired
	private SqlSession sqlSession;

	/** 메인 카테고리 들고오기
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
		
		int result = sqlSession.selectOne("myProjectMapper.getMyProjectListCount", map);
		
		return result;
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
		
		return sqlSession.selectList("myProjectMapper.selectMyProject", map, rowBounds);
	}
 
	/** 메인3 카테고리 들고오기
	 * @return
	 */
	public List<MyProject> selectcategoryList() {
		return sqlSession.selectList("myProjectMapper.selectcategoryList");
	}

	/** 내 서비스 등록하기 
	 * @param myProject
	 * @param loginMember
	 * @return
	 */
	public int insertMyProject(MyProject myProject, Member loginMember) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("myProject", myProject); //입력한 서비스 값
		map.put("loginMember", loginMember.getMemberNo());
		
		sqlSession.insert("myProjectMapper.insertMyProject",map);
		int projectNum = (int)map.get("projectRequestNo");
		
		return projectNum;
	}
	
	/** 내 서비스 등록하기 (이미지 파일)
	 * @param projectFileList
	 * @return
	 */
	public int insertProjectFileList(List<RequestFile> projectFileList) {
		return sqlSession.insert("myProjectMapper.insertFileImageList", projectFileList);
	}

	/** 받은 제안 카운트 
	 * @param memberNo
	 * @param mainCategoryNo
	 * @return
	 */
	public int getProposalCount(int memberNo, int mainCategoryNo) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); 
		map.put("mainCategoryNo", mainCategoryNo);
		
		return sqlSession.selectOne("myProjectMapper.getProposalCount", map);
	}

	/** 받은 제안 조회 
	 * @param memberNo
	 * @param mainCategoryNo
	 * @param pagination
	 * @return
	 */
	public List<MyProject> selectProposal(int memberNo, int mainCategoryNo, Pagination pagination) {
		
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit(); 
	    
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
	    
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); //로그인 세션 회원 번호
		map.put("mainCategoryNo", mainCategoryNo); //카테고리별 서비스 들고오기
		
		return sqlSession.selectList("myProjectMapper.selectProposalList", map, rowBounds);
	}

	/** 내 프로젝트 조회 ajax 카운트
	 * @param optionVal
	 * @return
	 */
	public int getChangeTypeCount(String optionVal, int memberNo) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); 
		map.put("optionVal", optionVal);
		
		return sqlSession.selectOne("myProjectMapper.getChangeTypeCount", map);
	}

	/** 내 프로젝트 조회 ajax 조회
	 * @param optionVal
	 * @param pagination
	 * @return
	 */
	public List<MyProject> categoryTypeSelect(String optionVal, Pagination pagination,int memberNo) {
		
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit(); 
	    
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); 
		map.put("optionVal", optionVal);
		
		return sqlSession.selectList("myProjectMapper.categoryTypeSelect", map, rowBounds);

	}

	/** 내 프로젝트 받은 제안 카운트 ajax  
	 * @param optionVal
	 * @param memberNo
	 * @return
	 */
	public int getSuggestTypeCount(String optionVal, int memberNo) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("memberNo", memberNo); 
		map.put("optionVal", optionVal);
		
		return sqlSession.selectOne("myProjectMapper.getSuggestTypeCount",map);
	}

	/** 내 프로젝트 받은 제안 조회 ajax
	 * @param optionVal
	 * @param pagination
	 * @param memberNo
	 * @return
	 */
	public List<MyProject> categoryTypeSelect_suggest(String optionVal, Pagination pagination, int memberNo) {
		
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit(); 
	    
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); 
		map.put("optionVal", optionVal);
		
		return sqlSession.selectList("myProjectMapper.categoryTypeSelect_suggest", map, rowBounds);
	}

	/** 받은 제안 채택 및 결제 ajax
	 * @param myProject
	 * @return
	 */
	public int completeSuggetionPay(MyProject myProject) {
		
		// 서비스 테이블 등록
		int result = sqlSession.insert("myProjectMapper.serviceInsert",myProject);
		System.out.println("서비스 테이블 삽입:" +result);
		
		if(result>0){
			// 거래 테이블 등록 
			result = sqlSession.insert("myProjectMapper.tradeInsert",myProject);
			
			System.out.println("거래 테이블 삽입:" +result);
			
			if(result>0) {
				
				// 정산 테이블 등록
				result = sqlSession.insert("myProjectMapper.settlementInsert",myProject);
				System.out.println("정산 테이블 삽입:" +result);
				
				if(result>0) {
					
					// 프로젝트 상태 모집마감으로 변경
					result = sqlSession.update("myProjectMapper.requestStatusChange",myProject);
					System.out.println("프로젝트 상태 변경:" +result);
					
					if(result>0) {
						
						// 채택되지 않은 제안 상태 모집마감으로 변경 
						result = sqlSession.update("myProjectMapper.proposalStatusChange_adopt",myProject);
						System.out.println("채택되지 제안 상태 변경 :" +result);
						
						// 채택된 제안 상태 채택으로 변경 
						result = sqlSession.update("myProjectMapper.proposalStatusChange",myProject);
						System.out.println("채택된 제안 상태 변경 :" +result);
						
						result = myProject.getTradeNo();
					}
					
				}
				
			}
			
		}
		
		System.out.println(result);
		return result;
	}


	
}
