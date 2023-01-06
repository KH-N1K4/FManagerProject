package com.manager.freelancer.common.scheduling;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.manager.freelancer.myProject.model.service.MyProjectFreelancerService;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancer;

@Component
public class LevelUPScheduling {
	
	/* -- FN_DT1 (클라이언트용)
			CREATE OR REPLACE FUNCTION FN_DT1
			RETURN DATE
			IS
			   RES DATE;
			BEGIN
			   SELECT CASE WHEN EXTRACT(MONTH FROM SYSDATE) < 7
			      THEN TO_DATE(EXTRACT(YEAR FROM SYSDATE) || '0101')
			   ELSE TO_DATE(EXTRACT(YEAR FROM SYSDATE) || '0701')
			   END DT
			   INTO RES
			   FROM DUAL;   
			   RETURN RES;
			END;
			-- FN_DT1 (클라이언트용)
			CREATE OR REPLACE FUNCTION FN_DT2
			RETURN DATE
			IS
			   RES DATE;
			BEGIN
			   SELECT CASE WHEN EXTRACT(MONTH FROM SYSDATE) < 7
			         THEN TO_DATE(EXTRACT(YEAR FROM SYSDATE) - 1 || '0701')
			      ELSE TO_DATE(EXTRACT(YEAR FROM SYSDATE) || '0101')
			      END DT
			   INTO RES
			   FROM DUAL;
			   RETURN RES;
			END; 
	
			-- (1/86400) == 1초
			SELECT FN_DT1, ADD_MONTHS(FN_DT1, 6) - (1/86400) "FN_DT1 + 6개월",
			      FN_DT2, ADD_MONTHS(FN_DT2, 6) - (1/86400) "FN_DT2 + 6개월" 
			FROM DUAL;
	*/
	
	@Autowired // DI
	private MyProjectFreelancerService service;
	
	private Logger logger = LoggerFactory.getLogger(LevelUPScheduling.class);
	
	 @Scheduled(cron = "0 0 0 1 1,7 *") // 6개월 자동 등업 스케줄러
	 public void updateLevelUPMember() { 
	 
		logger.debug("*** : " + "스케줄러 시작 ");
		 List<myProjectFreelancer> freelancer = service.selectFreelancerListALL(2);//타입: 1 프리랜서용(스케줄러용은 2번)
		 List<myProjectFreelancer> levelTabel = service.selectBasicGrade();
		 
		 List<myProjectFreelancer> seccessMember = new ArrayList<myProjectFreelancer>(); 
		 List<myProjectFreelancer> downMember = new ArrayList<myProjectFreelancer>(); 
	  // 배열 -> List로 변환 List<File> fileList = Arrays.asList(arr);
		/* 만족 되야하는 조건들
		 * private int allGradeNo; //GRADE_NO 등급 번호 
		 * private float allSatisfaction; //SATISFACTION 만족도 
		 * int allInquiryRate; //INQUIRY_RATE 메세지 응답률 
		 * private int allCompletionRate;//COMPLETION_RATE 작업일 준수율
		 *  private int allSaleProceeds; //SALE_PROCEEDS 누적 판매금액 
		 * allSaleCount; //SALE_COUNT 누적 판매 건수
		 */		 
		 if(!freelancer.isEmpty()) {  
			 for(myProjectFreelancer level : levelTabel) {
				 if(level.getGradeNo() <= 1) continue;
				 
				 for(myProjectFreelancer m : freelancer) { 
					if(m.getGradeNo() <= 1) continue;
					 
					 if(m.getGradeNo() < level.getGradeNo()) {//등급 조건 충족시 등급 상승
						 
						 if(level.getGradeSatisfaction() <= m.getGradeSatisfaction() 
								 && level.getGradeInquityRate() <= m.getGradeInquityRate()
								 && level.getGradeCompletionRate() <= m.getGradeCompletionRate()
								 && level.getGradeSaleCount() <= m.getGradeSaleCount()
								 && level.getGradeSaleProceeds() <= m.getGradeSaleProceeds()) {
							 logger.debug("*** : " + m);
							 //m.getBoardCount() //게시글 수
//							 //m.getCommentCount() // 댓글 수
//							 //m.getLogHistoryCount() // 방문수
							  m.setGradeNo(level.getGradeNo());
							  seccessMember.add(m);  
							 
						 }
						 
					 }else {//등급 조건 불 충족시 등급 하락
						 if(level.getGradeSatisfaction() > m.getGradeSatisfaction() 
								 || level.getGradeInquityRate() > m.getGradeInquityRate()
								 || level.getGradeCompletionRate() > m.getGradeCompletionRate()
								 || level.getGradeSaleCount() > m.getGradeSaleCount()
								 || level.getGradeSaleProceeds() > m.getGradeSaleProceeds()) {
							 logger.debug("*** : " + m);
							 //m.getBoardCount() //게시글 수
//							 //m.getCommentCount() // 댓글 수
//							 //m.getLogHistoryCount() // 방문수
							  m.setGradeNo(level.getGradeNo()-1);
							  downMember.add(m);  
							 
						 }
					 }
					 
				 }
				 
			 }
			 
		 }
	 
		 int result = service.LevelUPSchedulingUpdate(seccessMember);//등급 상승 
		 int result2 = service.LevelDownSchedulingUpdate(downMember);//등급 하락
		 
		 for(myProjectFreelancer s : seccessMember) {
			 logger.info(s.getFreelancerNo() + "님이 " + s.getGradeNo()+ " 등급으로 상승되었습니다.");
		 }
		 for(myProjectFreelancer s : downMember) {
			 logger.info(s.getFreelancerNo() + "님이 " + s.getGradeNo()+ " 등급으로 하락되었습니다.");
		 }
		 
		 logger.info("스케줄러 실행");
	  }
}
