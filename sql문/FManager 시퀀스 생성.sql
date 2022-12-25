COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원 번호 SEQUENCE';
COMMENT ON COLUMN "CHAT_ROOM"."CHAT_ROOM_NO" IS '채팅방 번호'; ---
COMMENT ON COLUMN "SERVICE"."SERVICE_NO" IS '서비스 번호 시퀀스';
COMMENT ON COLUMN "PROJECT_REQUEST"."PROJECT_REQUEST_NO" IS '프로젝트 의뢰 번호 SEQUENCE';
COMMENT ON COLUMN "PROJECT_PROPOSAL"."PROJECT_PROPOSAL_NO" IS '프로젝트 제안 번호 SEQUENCE';
COMMENT ON COLUMN "SERVICE_INQUIRY"."SERVICE_INQUIRY_NO" IS '서비스 문의 번호 SEQUENCE';
COMMENT ON COLUMN "USER_INQUIRY"."USER_INQUIRY_NO" IS '이용문의 번호 SEQUENCE';
COMMENT ON COLUMN "REPORT"."REPORT_NO" IS '리뷰 신고 번호'; ---
COMMENT ON COLUMN "WORK"."WORK_NO" IS '작업물 번호';----
COMMENT ON COLUMN "CAREER"."CAREER_NO" IS '경력사항 번호 SEQUENCE';
COMMENT ON COLUMN "LICENSE"."LICENSE_NO" IS '자격증 번호 SEQUENCE';
COMMENT ON COLUMN "PORTFOLIO"."PORTFOLIO_NO" IS '포트폴리오 번호 SEQUENCE';
COMMENT ON COLUMN "REQUEST_FILE"."REQUEST_FILE_NO" IS '의뢰 첨부파일 번호 SEQUENCE';
COMMENT ON COLUMN "SERVICE_FILE"."REQUEST_FILE_NO" IS '서비스 첨부파일 번호 SEQUENCE';
COMMENT ON COLUMN "USER_INQUIRY_FILE"."INQUIRY_FILE_NO" IS '이용문의 첨부파일 번호 SEQUENCE';
COMMENT ON COLUMN "TRADE"."TRADE_NO" IS '거래 번호';
COMMENT ON COLUMN "SETTLEMENT"."SETTLEMENT_NO" IS '거래 내역 번호 SEQUENCE';
COMMENT ON COLUMN "TRADE_REPORT"."TRADE_REPORT_NO" IS '거래 신고 번호 SEQUENCE';
COMMENT ON COLUMN "REGION"."REGION_NO" IS '지역 번호 SEQUENCE';
COMMENT ON COLUMN "CHAT"."CHAT_NO" IS '채팅 메세지 번호';---
COMMENT ON COLUMN "MAJOR"."MAJOR_NO" IS '학력 변호';---
-------------------------------------------
SELECT SEQ_MEMBER_NO.NEXTVAL FROM DUAL;--시퀀스 되돌리기기
ALTER SEQUENCE SEQ_MEMBER_NO INCREMENT BY -2;
ALTER SEQUENCE SEQ_MEMBER_NO INCREMENT BY 1;
-- 시퀀스 생성 생성 기본값 1부터 시작 (총 21개)
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE; -- 회원 번호 SEQUENCE

CREATE SEQUENCE SEQ_CHAT_ROOM_NO NOCACHE; -- 채팅방 번호
CREATE SEQUENCE SEQ_SERVICE_NO NOCACHE; -- 서비스 번호 시퀀스
CREATE SEQUENCE SEQ_PROJECT_REQUEST_NO NOCACHE; --프로젝트 의뢰 번호 SEQUENCE
CREATE SEQUENCE SEQ_PROJECT_PROPOSAL_NO NOCACHE; -- 프로젝트 제안 번호 SEQUENCE
CREATE SEQUENCE SEQ_SERVICE_INQUIRY_NO NOCACHE; -- 서비스 문의 번호 SEQUENCE
CREATE SEQUENCE SEQ_USER_INQUIRY_NO NOCACHE; -- 이용문의 번호 SEQUENCE
CREATE SEQUENCE SEQ_REPORT_NO NOCACHE; -- 리뷰 신고 번호
CREATE SEQUENCE SEQ_WORK_NO NOCACHE; -- 작업물 번호
CREATE SEQUENCE SEQ_CAREER_NO NOCACHE; -- 경력사항 번호 SEQUENCE
CREATE SEQUENCE SEQ_LICENSE_NO NOCACHE; -- 자격증 번호 SEQUENCE
CREATE SEQUENCE SEQ_PORTFOLIO_NO NOCACHE; -- 포트폴리오 번호 SEQUENCE
CREATE SEQUENCE SEQ_REQUEST_FILE_NO NOCACHE; -- 의뢰 첨부파일 번호 SEQUENCE
CREATE SEQUENCE SEQ_SERVICE_FILE_NO NOCACHE; -- 서비스 첨부파일 번호 SEQUENCE
CREATE SEQUENCE SEQ_INQUIRY_FILE_NO NOCACHE; --이용문의 첨부파일 번호 SEQUENCE
CREATE SEQUENCE SEQ_TRADE_NO NOCACHE; -- 거래 번호
CREATE SEQUENCE SEQ_SETTLEMENT_NO NOCACHE; -- 거래 내역 번호 SEQUENCE
CREATE SEQUENCE SEQ_TRADE_REPORT_NO NOCACHE; -- 거래 신고 번호 SEQUENCE
CREATE SEQUENCE SEQ_REGION_NO NOCACHE; -- 지역 번호 SEQUENCE
--SELECT SEQ_REGION_NO.NEXTVAL FROM DUAL;
CREATE SEQUENCE SEQ_CHAT_NO NOCACHE; -- 채팅 메세지 번호
CREATE SEQUENCE SEQ_MAJOR_NO NOCACHE; -- 학력 변호