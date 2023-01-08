package com.manager.freelancer.common.scheduling;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.manager.freelancer.myProject.model.service.MyProjectFreelancerService;
import com.manager.freelancer.myProject.model.vo.myProjectFreelancerRequest;

@Component
public class RecruitDateScheduling {
	
	@Autowired // DI
	private MyProjectFreelancerService service;
	
	private Logger logger = LoggerFactory.getLogger(LevelUPScheduling.class);
	
	
	@Scheduled(cron = "0 0 0 * * *") // 매일24:00 자동 등업 스케줄러
	 public void updateRecruitDateScheduling() { 
		logger.debug("*** : " + "모집마감 변경 스케줄러 시작 ");
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());

		logger.debug("*** 시스템 현재시간: "+System.currentTimeMillis());
		logger.debug("*** 변경포맷 현재시간: "+formatter.format(date));
		
		List<myProjectFreelancerRequest> projectRecruitDate= service.selectProjectRecruitDate(formatter.format(date));
		 
		List<myProjectFreelancerRequest> updateProject = new ArrayList<myProjectFreelancerRequest>(); 
	
		if(!projectRecruitDate.isEmpty()) {  
			 for(myProjectFreelancerRequest p : projectRecruitDate) {
				 
				
				logger.debug("*** : " + p);
				updateProject.add(p);  
						 
				 
			 }
			 int result = service.updateRecruitDateScheduling(updateProject);//모집마감 변경
			 logger.info("스케줄러 실행");
			 for(myProjectFreelancerRequest u : updateProject) {
				 logger.info(u.getProjectRequestNo() + "(번호인 프로젝트 의뢰: )" + u.getProjectRecruitDate()+ "모집마감일이 지나 상태변경");
			 }
		}
		
		
	}
}
