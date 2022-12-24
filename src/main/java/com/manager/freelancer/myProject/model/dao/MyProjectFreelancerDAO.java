package com.manager.freelancer.myProject.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.vo.FreelancerService;
import com.manager.freelancer.myProject.model.vo.myProjectServiceInquiry;

@Repository
public class MyProjectFreelancerDAO {
	
	@Autowired
	private SqlSession sqlSession;

	/**메인 카데고리 들고오기
	 * @return List<FreelancerService> 카테고리 리스트
	 */
	public List<FreelancerService> selectmaincategoryList() {
		
		return sqlSession.selectList("myProjectFreelancerSerive.selectmaincategoryList");
	}

	/**메인3 카테고리 들고오기
	 * @return List<FreelancerService> 카테고리 리스트
	 */
	public List<FreelancerService> selectcategoryList() {
		
		return sqlSession.selectList("myProjectFreelancerSerive.selectcategoryList");
	}

	/** 나의 서비스 등록하기
	 * @param freelancerVo
	 * @param loginMember
	 * @return serviceNum 등록한 서비스 번호 바로 들고 오기(맞는 지 확인 요망!!!)
	 */
	public int insertService(FreelancerService freelancerVo, Member loginMember) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("freelancerVo", freelancerVo); //게시판 메인 카테고리
		map.put("loginMember", loginMember.getMemberNo());
		sqlSession.insert("myProjectFreelancerSerive.insertService", map);
		int serviceNum = (int)map.get("serviceNo");
		return serviceNum;
	}

	/** 나의 서비스 등록하기에서 들고온 서비스 번호와 합쳐 서비스 이미지 등록하기
	 * @param servicefileList
	 * @return 
	 */
	public int insertFileImageList(List<myProjectServiceInquiry> servicefileList) {
		
		return sqlSession.insert("myProjectFreelancerSerive.insertFileImageList", servicefileList);
	}

	/**나의 서비스 들고오기
	 * @param memberNo
	 * @param mainCategoryNo 
	 * @return
	 */
	public List<FreelancerService> selectMyService(int memberNo, int mainCategoryNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo); //게시판 메인 카테고리
		map.put("mainCategoryNo", mainCategoryNo);
		return sqlSession.selectList("myProjectFreelancerSerive.selectMyService", map);
	}
}
