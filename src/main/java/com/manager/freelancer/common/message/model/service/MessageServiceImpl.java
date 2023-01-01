package com.manager.freelancer.common.message.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.common.Util;
import com.manager.freelancer.common.message.model.dao.MessageDAO;
import com.manager.freelancer.common.message.model.vo.ChattingRoom;
import com.manager.freelancer.common.message.model.vo.Message;


@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageDAO dao;

	/**
	 *채팅방 있는 지 확인
	 */
	@Override
	public ChattingRoom checkChattingRoomNo(Map<String, Integer> map) {
		return dao.checkChattingRoomNo(map);
	}

	/**
	 *없으면 채팅방 생성
	 */
	@Override
	public int createChattingRoom(Map<String, Integer> map) {
		return dao.createChattingRoom(map);
	}

	/**
	 *참여중인 채팅방
	 */
	@Override
	public List<ChattingRoom> selectRoomList(int memberNo) {
		return dao.selectRoomList(memberNo);
	}

	/**채팅방 나가기 여부가 Y이면 N로 변경
	 *
	 */
	@Override
	public int updateChattingRoom(ChattingRoom chatRoom) {
		return dao.updateChattingRoom(chatRoom);
		
	}

	/**
	 *채팅방 나가기 여부 확인
	 */
	@Override
	public ChattingRoom delectFLRoomNo(Map<String, Integer> map) {
		return dao.delectFLRoomNo(map);
	}
	
    /**
     *메세지 삽입
     */
    @Override
    public int insertMessage(Message msg) {
    	//msg.setMessageContent(Util.XSSHandling(msg.getMessageContent()));
        msg.setChatMessage(Util.newLineHandling(msg.getChatMessage()));
        return dao.insertMessage(msg);
    }

    /**
     *읽음 처리로 변경
     */
    @Override
    public int updateReadFlag(Map<String, Object> paramMap) {
        return dao.updateReadFlag(paramMap);
    }

    /**
     *채팅방에 들어갔을 때 메세지 다 들고 오기 
     */
    @Override
    public List<Message> selectMessageList( Map<String, Object> paramMap, int memberNo) {
        System.out.println(paramMap);
        List<Message> messageList = dao.selectMessageList(  Integer.parseInt( String.valueOf(paramMap.get("chatRoomNo") )) , memberNo);
        
        if(!messageList.isEmpty()) {
            int result = dao.updateReadFlag(paramMap);
        }
        return messageList;
    }

	/**
	 *채팅방 나가기
	 */
	@Override
	public int updateOutFL(Map<String, Object> paramMap) {

		return dao.updateOutFL(paramMap);
	}
}
