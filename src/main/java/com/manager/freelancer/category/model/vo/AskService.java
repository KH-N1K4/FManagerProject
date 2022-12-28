package com.manager.freelancer.category.model.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class AskService {
	private String serviceInquiryContent;
	private int memberNo;
	private String serviceNo;
}
