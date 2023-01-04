package com.manager.freelancer.category.model.vo;

import java.util.List;

import com.manager.freelancer.freelancer.model.vo.Portfolio;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Freelancer {

	private int freelancerNo; 				// 프리랜서 번호
	
	private int gradeNo;					// 등급번호
	private String gradeName;				
	private int regionNo;					// 지역이름(번호)
	private String regionName;
	
	private int freelancerCont; 			// 총 경력기간
	private int contactTime1;				// 연락가능시간 시작
	private int contactTime2;				// 연락가능시간 끝
		
	private String freelancerIntro;			// 자기소개
	
	//학력 전공부분
	private String major; // input값 전체 받을 부분
	
	// 경력사항 부분
	private String career; // input값 전체 받을 부분
	
	// 자격증 부분
	private String license; // input값전체 받을 부분
	
	
	//프리랜서 전문분야
	private String freelancerField;
	
	private List<Portfolio> portfolioList;
	private List<FService> fServiceList;
}
