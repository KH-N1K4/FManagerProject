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
    private String MaxMessageNo;
    private String sendTime;
    private int clientNo;
    private String clientNickName;
    private String clientProfile;
    private int notReadCount;
    
    private String chatRoomCreateDate;//<result property="chatRoomCreateDate" column="CHAT_ROOM_CREATE_DATE" />	
    private String chatRoomOpenMemDelFL;
    private String chatRoomClientDelFL;
    private String chatRoomDelFL;
    private String chatRoomDelNo;
    
    private String chatRoomOpenUpdateDate;
    private String chatRoomClientUpdateDate;
    
    private String clientGrade;
    private String clientFreeContactTime;
    //<result property="clientGrade" column="CLIENT_GRADE_NAME" />								
  	//<result property="clientFreeContactTime" column="CLIENT_FREE_CONTACT_TIME" />	
    //result property="chatRoomOpenUpdateDate" column="CHAT_ROOM_OPENMEM_UPDATE_DATE" />
    //<result property="chatRoomClientUpdateDate" column="CHAT_ROOM_CLIENT_UPDATE_DATE" />
    
    //<result property="chatRoomOpenMemDelFL" column="CHAT_ROOM_OPENMEM_DEL_FL" />									<!--"CHAT_ROOM" 채팅방 삭제 여부 Y :삭제 N: 개설 -->							
    //<result property="chatRoomClientDelFL" column="CHAT_ROOM_CLIENT_DEL_FL" />
}
