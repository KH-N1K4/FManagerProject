package com.manager.freelancer.myProject.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyProjectImage {

	// 의뢰 첨부파일
	private int requestFileNo;		        // REQUEST_FILE_NO 프로젝트 첨부 파일 번호 
	private String requestFilePath;		    // REQUEST_FILE_PATH 프로젝트 첨부 파일 경로
	private int requestFileOrder;		    // REQUEST_FILE_ORDER 프로젝트 첨부 파일 순서
	private int projectRequestNo;		    // PROJECT_REQUEST_NO 프로젝트 의뢰 번호
}
