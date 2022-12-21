package chatting.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chatting.model.dao.ChattingDAO;
import chatting.model.vo.ChattingRoom;

@Service
public class ChattingServiceImpl implements ChattingService{
	
	@Autowired
	private ChattingDAO dao;

	// 채팅방이 있는지 확인
	@Override
	public int checkChattingNo(Map<String, Integer> map) {
		return dao.checkChattingNo(map);
	}

	// 채팅방 생성
	@Override
	public int createChattingRoom(Map<String, Integer> map) {
		return dao.createChattingRoom(map);
	}

	// 참여중인 채팅방 조회
	@Override
    public List<ChattingRoom> selectRoomList(int memberNo) {
        return dao.selectRoomList(memberNo);
    }

}
