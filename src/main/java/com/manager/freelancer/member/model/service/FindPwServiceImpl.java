package com.manager.freelancer.member.model.service;

import java.util.Map;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.manager.freelancer.member.model.dao.FindPwDAO;
import com.manager.freelancer.member.model.vo.Member;

@Service
public class FindPwServiceImpl implements FindPwService {

	@Autowired
	private FindPwDAO dao;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Autowired
	private JavaMailSender mailSender; // email-context.xml에서 생성한 bean

	private String fromEmail = "raura980616@gmail.com";
	private String fromUsername = "프매니저 관리자";

	// 입력된 정보로 회원 찾기
	@Override
	public int findInfo(Member inputMember) {
		return dao.findInfo(inputMember);
	}

	// 새 비밀번호
	@Override
	public int changeRanPw(Map<String, Object> map) {
		String encPw = bcrypt.encode((CharSequence) map.get("randomString")); // 암호화된 비밀번호
		map.put("memberPw", encPw);

		try {

			// 인증메일 보내기
			MimeMessage mail = mailSender.createMimeMessage();

			// 제목
			String subject = "[FManager]새로운 비밀번호";

			// 문자 인코딩
			String charset = "UTF-8";

			String mailContent = "<div id=\"emailMain\" style=\" width: 800px; position: relative; margin: auto;\">\n"
					+ "        <div id=\"emailMiddle\" style=\" border-top:2px solid black;\"><strong style=\"display: inline-block; font-size:20px; padding:20px;\">"+map.get("memberName")
					+ "님께서 요청하신 정보입니다.</strong></div>"
					+ "        <div id=\"emailInput\" style=\" display: flex; flex-direction: column; min-height: 200px;border-top: 1px solid black; border-bottom: 2px solid black; padding:20px 0;\">\n"
					+ "                        <div style=\" display: block;\n"
					+ "            margin: auto;padding:10px 20px;\n"
					+ "            color:green;\n"
					+ "            font-weight: 900;\">\n" 
					+ "                임시 비밀번호 : " + map.get("randomString") + "\n" + "            </div>\n" + "\n"
					+ "            <span style=\" font-size:12px; display: block;\n"
					+ "            margin: auto;\">FManager 사이트를 이용해 주셔서 감사합니다.</span>\n"
					+ "        </div>\n" + "    </div>";


			// 송신자(보내는 사람) 지정
			mail.setFrom(new InternetAddress(fromEmail, fromUsername));

			// 수신자(받는사람) 지정
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress((String) map.get("memberEmail")));

			// 이메일 제목 세팅
			mail.setSubject(subject, charset);

			// 내용 세팅
			mail.setText(mailContent, charset, "html"); // "html" 추가 시 HTML 태그가 해석됨

			mailSender.send(mail);// 메일 발송
		} catch (Exception e) {
			e.printStackTrace();

		}

		return dao.changeRanPw(map);
	}

}
