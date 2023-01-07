package com.manager.freelancer.common.message.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.common.message.model.vo.ChattingRoom;
import com.manager.freelancer.common.message.model.vo.MemberReport;
import com.manager.freelancer.common.message.model.vo.Message;

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
	
	/**채팅방 나가기 여부 확인: 나
	 * @param map
	 * @return
	 */
	ChattingRoom delectFLRoomNo(Map<String, Integer> map);

    /**메세지 삽입
     * @param msg
     * @return
     */
    int insertMessage(Message msg);

    /**업데이트 읽음 표시 
     * @param paramMap
     * @return
     */
    int updateReadFlag(Map<String, Object> paramMap);

    /**채팅방 입장할때 메세지 리스트 들고 오기
     * @param paramMap
     * @return
     */
    List<Message> selectMessageList( Map<String, Object> paramMap, int memberNo);

	/**채팅방 나가기
	 * @param paramMap
	 * @return
	 */
	int updateOutFL(Map<String, Object> paramMap);

	/**채팅방 나가기 여부 확인: 상대방
	 * @param map
	 * @return
	 */
	ChattingRoom delectFLRoomNoClient(Map<String, Integer> map);

	/**채팅방 신고하기
	 * @param webPath
	 * @param filePath
	 * @param reportedMemberNo
	 * @param reportMemberNo
	 * @param reportContent
	 * @param file
	 * @param memberReport 
	 * @param reportTitle 
	 * @return
	 * @throws IOException
	 */
	String memberReportUpdate(String webPath, String filePath, String reportedMemberNo, String reportMemberNo,
			String reportContent, List<MultipartFile> file, MemberReport memberReport, String reportTitle) throws IOException;;
	
}
