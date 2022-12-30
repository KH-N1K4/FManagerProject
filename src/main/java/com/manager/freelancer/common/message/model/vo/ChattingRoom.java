package com.manager.freelancer.common.message.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChattingRoom {
	private int chatRoomNo; 
    private String lastMessage;
    private String sendTime;
    private int clientNo;
    private String clientName;
    private String clientProfile;
    private int notReadCount;
}
