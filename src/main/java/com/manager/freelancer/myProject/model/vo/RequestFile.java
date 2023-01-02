package com.manager.freelancer.myProject.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RequestFile {

	 
	private int projectRequestNo;       // 프로젝트 의뢰 번호
	private int requestFileNo;          // 프로젝트 첨부 파일 번호 
	private String requestFilePath;     // 프로젝트 파일 경로
	private int requestFileOrder;       // 프로젝트 파일 순서
	
}
