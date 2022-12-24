package com.manager.freelancer.myProject.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.manager.freelancer.member.model.vo.Member;
import com.manager.freelancer.myProject.model.vo.FreelancerService;

public interface MyProjectFreelancerService {

	/**메인 카테고리 들고오기
	 * @return
	 */
	List<FreelancerService> selectmaincategoryList();

	/**메인3 카테고리 들고오기 
	 * @return
	 */
	List<FreelancerService> selectcategoryList();

	/**서비스 등록하기
	 * @param webPath
	 * @param filePath
	 * @param serviceFile
	 * @param loginMember
	 * @param freelancerVo
	 * @return
	 * @throws IOException
	 */
	int insertService(String webPath, String filePath, List<MultipartFile> serviceFile, Member loginMember,
			FreelancerService freelancerVo) throws IOException;

	/**나의 서비스 들고오기
	 * @param memberNo
	 * @return
	 */
	List<FreelancerService> selectMyService(int memberNo);

}
