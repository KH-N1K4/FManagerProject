package com.manager.freelancer.projectRequest.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.myProject.model.vo.myProjectFreelancerRequest;

@Repository
public class ProjectRequestDAO {
	
	@Autowired
	private SqlSession sqlSession;

	/**세번 째 카테고리 들고오기 
	 * @return
	 */
	public List<myProjectFreelancerRequest> getCategotyList() {
		
		return sqlSession.selectList("myProjectRequest.getCategotyList");
	}
	
	/**두번 째 카테고리 들고오기 
	 * @return
	 */
	public List<myProjectFreelancerRequest> getSubCategotyList() {
		
		return sqlSession.selectList("myProjectRequest.getSubCategotyList");
	}
	
	/**메인 카테고리 들고오기
	 * @return
	 */
	public List<myProjectFreelancerRequest> getMainCategotyList() {
		
		return sqlSession.selectList("myProjectRequest.getMainCategotyList");
	}
	
}