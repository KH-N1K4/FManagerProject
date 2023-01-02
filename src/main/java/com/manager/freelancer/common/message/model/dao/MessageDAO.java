package com.manager.freelancer.common.message.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manager.freelancer.common.message.model.vo.ChattingRoom;
import com.manager.freelancer.common.message.model.vo.Message;

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

	/**채팅방 들어갈때 나기기 여부가 Y인지 조회
	 * @param map
	 * @return
	 */
	public ChattingRoom delectFLRoomNo(Map<String, Integer> map) {
		return sqlSession.selectOne("messageMapper.delectFLRoomNo", map);
	}
	
	/**메세지 삽입
	 * @param msg
	 * @return
	 */
	public int insertMessage(Message msg) {
	    return sqlSession.insert("messageMapper.insertMessage", msg);
	}

	/**읽음 처리로 변경
	 * @param paramMap
	 * @return
	 */
	public int updateReadFlag(Map<String, Object> paramMap) {
	    return sqlSession.update("messageMapper.updateReadFlag", paramMap);
	}

	/**채팅방에 들어갔을 때 메세지 다 들고 오기
	 * @param chattingNo
	 * @return
	 */
	public List<Message> selectMessageList(int chatRoomNo, int memberNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("chatRoomNo", chatRoomNo); 
		map.put("memberNo", memberNo);
		return sqlSession.selectList("messageMapper.selectMessageList", map);
	}

	/**채팅방 나가기
	 * @param paramMap
	 * @return
	 */
	public int updateOutFL(Map<String, Object> paramMap) {
		return sqlSession.update("messageMapper.updateOutFL", paramMap);
	}

	/**채팅방 나가기
	 * @param paramMap
	 * @return
	 */
	public int updateOutClientFL(Map<String, Object> paramMap) {
		
		return sqlSession.update("messageMapper.updateOutClientFL", paramMap);
	}
}
