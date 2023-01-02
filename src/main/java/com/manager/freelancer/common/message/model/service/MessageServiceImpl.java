package com.manager.freelancer.common.message.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.freelancer.common.message.model.dao.MessageDAO;
import com.manager.freelancer.common.message.model.vo.ChattingRoom;


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
}
