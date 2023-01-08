package com.manager.freelancer.freelancer.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.category.model.vo.Freelancer1;
import com.manager.freelancer.freelancer.model.vo.Bank;
import com.manager.freelancer.freelancer.model.vo.Career;
import com.manager.freelancer.freelancer.model.vo.Field;
import com.manager.freelancer.freelancer.model.vo.Freelancer;
import com.manager.freelancer.freelancer.model.vo.License;
import com.manager.freelancer.freelancer.model.vo.Major;
import com.manager.freelancer.freelancer.model.vo.Portfolio;
import com.manager.freelancer.freelancer.model.vo.Region;

@Repository
public class FreeLancerDAO {

	@Autowired
	private SqlSession sqlSession;

	public int enrollFreelancerSignup(Freelancer inputFreelancer) {
		// TODO Auto-generated method stub
		return sqlSession.insert("freelancerMapper.enrollFreelancer", inputFreelancer);
	}
	
	// 전문가 정보 조회
		public Freelancer freelancerInfo(int freelancerNo) { // inputfreelancer에는 회원번호(프리랜서번호)가 있다.

			return sqlSession.selectOne("freelancerMapper.freelancerInfo", freelancerNo);
		}
	// 전문가 정보 조회(연수)
	public Freelancer1 freelancerInfo1(int freelancerNo) {

		return sqlSession.selectOne("freelancerMapper.freelancerInfo1", freelancerNo);
	}

	public int enrollFreelancerMajor(Major temp1) {
		
		return sqlSession.insert("freelancerMapper.enrollFreelancerMajor", temp1);
	}


//	프리랜서 여부 변경> member테이블 ( N -> Y)
	public int updateFreelancerFlag(Freelancer inputFreelancer) {
		return sqlSession.update("freelancerMapper.updateFreelancerFlag",inputFreelancer);
	}
	// 경력 등록
	public int enrollFreelancerCareer(Career temp2) {
		return sqlSession.insert("freelancerMapper.enrollFreelancerCareer", temp2);
	}

	// 자격증 등록
	public int enrollfreelancerLicense(License temp3) {
		return sqlSession.insert("freelancerMapper.enrollFreelancerLicense", temp3);
	}


	// 프리랜서 계좌등록(insert)
	public int insertFreelancerAccount(Freelancer inputFreelancer) {
		return sqlSession.insert("freelancerMapper.insertFreelancerAccount", inputFreelancer);
	}


	// 전문분야 Insert
	public int insertFreelancerField(Map<String, String> map) {

		return sqlSession.insert("freelancerMapper.insertFreelancerField", map);
	}
	
	public List<Region> getRegionList() {
		return sqlSession.selectList("freelancerMapper.getRegionList");
	}


	public List<Portfolio> getPortfolioList(Freelancer inputFreelancer) {

		return sqlSession.selectList("freelancerMapper.getPortfolioList", inputFreelancer);
	}
	public List<Field> getFieldList(Freelancer inputFreelancer) {

		return sqlSession.selectList("freelancerMapper.getFieldList", inputFreelancer);
	}
	
	public List<Bank> getBankList() {

		return sqlSession.selectList("freelancerMapper.getBankList");
	}


	// 전문가 정보 수정
	public int updateFreelancerInfo(Freelancer inputFreelancer) {

		return sqlSession.update("freelancerMapper.updateFreelancerInfo", inputFreelancer);
	}
	// 전문가 정보 수정(경력사항)
	public int updateFreelancerCareer(Career temp1Career) {

		return sqlSession.update("freelancerMapper.updateFreelancerCareer", temp1Career);
	}
	// 전문자 정보 수정(자격증)
	public int updatefreelancerLicense(License temp2License) {

		return sqlSession.update("freelancerMapper.updateFreelancerLicense", temp2License);
	}
	// 전문가 정보 수정(은행)
	public int updateFreelancerBank(Freelancer inputFreelancer) {

		return sqlSession.update("freelancerMapper.updateFreelancerBank", inputFreelancer);
	}

	// 포트폴리오 등록
	public int addPortfolio(Portfolio inputPortfolio) {

		return sqlSession.insert("freelancerMapper.addPortfolio", inputPortfolio);
	}


	public int updateFreelancerField(Freelancer inputFreelancer) {
		
		return sqlSession.delete("freelancerMapper.updateFreelancerField",inputFreelancer);
	}
	// 포트폴리오 상세조회
	public Portfolio viewPortfolioDetail(Portfolio portfolio) {
		
		return sqlSession.selectOne("freelancerMapper.viewPortfolioDetail", portfolio);
	}

	public int DeletePortfolio(Freelancer1 freelancer1, int freelancerNo, int portfolioNo) {
		// TODO Auto-generated method stub
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("freelancerNo", freelancerNo);
		map.put("portfolioNo", portfolioNo);
		return sqlSession.delete("freelancerMapper.DeletePortfolio",map);
	}


	public int deleteMajor(int freelancerNo) {
		return sqlSession.delete("freelancerMapper.deleteMajor",freelancerNo);
	}

	public int deleteLicense(int freelancerNo) {
		return sqlSession.delete("freelancerMapper.deleteLicense",freelancerNo);
	}

	public int deleteCareer(int freelancerNo) {
		return sqlSession.delete("freelancerMapper.deleteCareer",freelancerNo);
	}

	public int deleteField(int freelancerNo) {
		return sqlSession.delete("freelancerMapper.deleteField",freelancerNo);

	}

	




	

	


	







	
	


	
}
