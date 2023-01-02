package com.manager.freelancer.common.message.model.service;

import java.util.List;
import java.util.Map;

import com.manager.freelancer.common.message.model.vo.ChattingRoom;

public interface MessageService {

	/**채팅방 있는 지 확인
	 * @param map
	 * @return chatRoomNo
	 */
	ChattingRoom checkChattingRoomNo(Map<String, Integer> map);

	/**없으면 채팅방 생성
	 * @param map
	 * @return chatRoomNo
	 */
	int createChattingRoom(Map<String, Integer> map);

	/**참여중인 채팅방
	 * @param memberNo
	 * @return roomList
	 */
	List<ChattingRoom> selectRoomList(int memberNo);

	/**채팅방 나가기 여부가 Y이면 N로 변경
	 * @param chatRoom
	 */
	int updateChattingRoom(ChattingRoom chatRoom);
	
	/**채팅방 나가기 여부 확인
	 * @param map
	 * @return
	 */
	ChattingRoom delectFLRoomNo(Map<String, Integer> map);
	
}
