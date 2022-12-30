package com.manager.freelancer.common.message.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.common.message.model.vo.ChattingRoom;

@Repository
public class MessageDAO {
	@Autowired
	private SqlSession sqlSession;

	/**채팅방 있는 지 확인
	 * @param map
	 * @return chatRoomNo
	 */
	public ChattingRoom checkChattingRoomNo(Map<String, Integer> map) {

		return sqlSession.selectOne("messageMapper.checkChattingRoomNo", map);
	}

	/**없으면 채팅방 생성
	 * @param map
	 * @return chatRoomNo
	 */
	public int createChattingRoom(Map<String, Integer> map) {

		int result = sqlSession.insert("messageMapper.createChattingRoom", map);
        int chattingRoomNo = 0;
        if(result > 0)  chattingRoomNo = (int)map.get("chatRoomNo");
        return chattingRoomNo;
	}

	/**참여중인 채팅방
	 * @param memberNo
	 * @return
	 */
	public List<ChattingRoom> selectRoomList(int memberNo) {
		return sqlSession.selectList("messageMapper.selectRoomList", memberNo);
	}

	/**채팅방 나가기 여부가 Y이면 N로 변경
	 * @param chatRoomNo
	 * @return
	 */
	public int updateChattingRoom(ChattingRoom chatRoom) {
		return sqlSession.update("messageMapper.updateChattingRoom", chatRoom);
	}

	public ChattingRoom delectFLRoomNo(Map<String, Integer> map) {
		return sqlSession.selectOne("messageMapper.delectFLRoomNo", map);
	}
}
