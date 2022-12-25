------------------------------------------------------------------------------------------------------------
--서비스 등록하기 카테고리 1,3 들고오기
SELECT * FROM MAIN_CATEGORY;

SELECT THIRD_CATEGORY_NO,THIRD_CATEGORY_NAME,MAIN_CATEGORY_NO 
FROM CATEGORY 
JOIN SUB_CATEGORY USING(SUB_CATEGORY_NO)
ORDER BY 1;

---서비스 등록하기 서비스 데이터 삽입
INSERT INTO "SERVICE"
VALUES(SEQ_SERVICE_NO.NEXTVAL,#{},#{},#{},#{},#{},#{},DEFAULT,DEFAULT,#{},#{})

----서비스 테이블에서 데이터 들고 오기 --서비스 연관 첨부파일도 처음 하나만 들고오기(메인사진으로 들고 올거임)
SELECT SERVICE_NO,SERVICE_TITLE,SERVICE_SUMMARY,SERNICE_CONTENT,SERVICE_PRICE,TO_CHAR(SERVICE_PRICE, 'FM999,999,999,999') SERVICE_PRICE_STRING, SERVICE_EDIT_NUM,
SERVICE_WORK_PERIOD,SERVICE_STATUS,SERVICE_CREATE_DATE,THIRD_CATEGORY_NO,FREELANCER_NO,REQUEST_FILE_NO,REQUEST_FILE_PATH
FROM SERVICE
LEFT JOIN (SELECT s.*,
ROW_NUMBER() OVER (PARTITION BY SERVICE_NO ORDER BY REQUEST_FILE_NO) rum
FROM SERVICE_FILE s) USING(SERVICE_NO)
WHERE RUM = 1
AND SERVICE_STATUS NOT IN (5)
AND FREELANCER_NO = 30;

--TO_CHAR(SERVICE_PRICE, 'FM999,999,999,999') 스트링 형식
--1:승인 대기 중, 2:판매 중, 3:미승인, 4:판매 중지,5: 의뢰용일회성서비스
SELECT SERVICE_NO,SERVICE_TITLE,SERVICE_SUMMARY,SERNICE_CONTENT,SERVICE_PRICE,TO_CHAR(SERVICE_PRICE, 'FM999,999,999,999') SERVICE_PRICE_STRING, 
	SERVICE_EDIT_NUM,SERVICE_WORK_PERIOD,
	SERVICE_STATUS,
	CASE WHEN SERVICE_STATUS = 1 THEN '승인대기 중'
	     WHEN SERVICE_STATUS = 2 THEN '판매 중'
	     WHEN SERVICE_STATUS = 3 THEN '미승인'
	     WHEN SERVICE_STATUS = 3 THEN '판매 중지'
	END AS SERVICE_STATUS_STRING
	,SERVICE_CREATE_DATE,THIRD_CATEGORY_NO,FREELANCER_NO,REQUEST_FILE_NO,REQUEST_FILE_PATH
FROM SERVICE
LEFT JOIN (SELECT s.*,
ROW_NUMBER() OVER (PARTITION BY SERVICE_NO ORDER BY REQUEST_FILE_NO) rum
FROM SERVICE_FILE s) USING(SERVICE_NO)
WHERE RUM = 1
AND SERVICE_STATUS NOT IN (5)
AND FREELANCER_NO = 30;

--메인 1카테고리 연결해서 메인1 카테고리 별 정렬
SELECT SERVICE_NO,SERVICE_TITLE,SERVICE_SUMMARY,SERNICE_CONTENT,SERVICE_PRICE,TO_CHAR(SERVICE_PRICE, 'FM999,999,999,999') SERVICE_PRICE_STRING, 
	SERVICE_EDIT_NUM,SERVICE_WORK_PERIOD,
	SERVICE_STATUS,
	CASE WHEN SERVICE_STATUS = 1 THEN '승인대기 중'
	     WHEN SERVICE_STATUS = 2 THEN '판매 중'
	     WHEN SERVICE_STATUS = 3 THEN '미승인'
	     WHEN SERVICE_STATUS = 3 THEN '판매 중지'
	END AS SERVICE_STATUS_STRING
	,SERVICE_CREATE_DATE,THIRD_CATEGORY_NO,FREELANCER_NO,REQUEST_FILE_NO,REQUEST_FILE_PATH,MAIN_CATEGORY_NO
FROM (SELECT * 
	FROM SERVICE
	LEFT JOIN CATEGORY USING(THIRD_CATEGORY_NO)
	LEFT JOIN SUB_CATEGORY USING(SUB_CATEGORY_NO))
LEFT JOIN (SELECT s.*,
ROW_NUMBER() OVER (PARTITION BY SERVICE_NO ORDER BY REQUEST_FILE_NO) rum
FROM SERVICE_FILE s) USING(SERVICE_NO)
WHERE RUM = 1
AND SERVICE_STATUS NOT IN (5)
AND FREELANCER_NO = 30;
AND MAIN_CATEGORY_NO = 2;
-----------------------------------------------------------------------
--거래 데이터 삽입
INSERT INTO "TRADE"
VALUES(SEQ_TRADE_NO.NEXTVAL,DEFAULT,DEFAULT,2,17);
--정산 내역 데이터 삽입
INSERT INTO "SETTLEMENT"
VALUES(SEQ_SETTLEMENT_NO.NEXTVAL,1,17,1,SYSDATE,1210000,SEQ_TRADE_NO.CURRVAL);

--거래 데이터 삽입
INSERT INTO "TRADE"
VALUES(SEQ_TRADE_NO.NEXTVAL,DEFAULT,DEFAULT,1,10);
--정산 내역 데이터 삽입
INSERT INTO "SETTLEMENT"
VALUES(SEQ_SETTLEMENT_NO.NEXTVAL,1,10,1,SYSDATE,100000,SEQ_TRADE_NO.CURRVAL);

--거래 데이터 삽입
INSERT INTO "TRADE"
VALUES(SEQ_TRADE_NO.NEXTVAL,DEFAULT,DEFAULT,1,35);
--정산 내역 데이터 삽입
INSERT INTO "SETTLEMENT"
VALUES(SEQ_SETTLEMENT_NO.NEXTVAL,1,35,1,SYSDATE,100000,SEQ_TRADE_NO.CURRVAL);

--거래 데이터 삽입
INSERT INTO "TRADE"
VALUES(SEQ_TRADE_NO.NEXTVAL,DEFAULT,DEFAULT,3,17);
--정산 내역 데이터 삽입
INSERT INTO "SETTLEMENT"
VALUES(SEQ_SETTLEMENT_NO.NEXTVAL,1,17,1,SYSDATE,2560000,SEQ_TRADE_NO.CURRVAL);
--작업물 발송 내역 데이터 삽입
INSERT INTO "WORK"
VALUES(SEQ_WORK_NO.NEXTVAL,DEFAULT,1);


SELECT * FROM TRADE;
SELECT * FROM SETTLEMENT;

-----------------------------------------------------------------------------------------------------
--거래별 서비스 테이블이랑 조인해서 선택해오기
--1:진행 중, 2: 작업 완료
SELECT t.*,
	CASE WHEN FREELANCER_DONE_FL = 1 THEN '진행 중'
	     WHEN FREELANCER_DONE_FL = 2 THEN '작업 완료'
	     WHEN FREELANCER_DONE_FL = 3 THEN '주문 취소'
	END AS FREELANCER_DONE_FL_STRING
FROM (SELECT * FROM TRADE
	JOIN (SELECT * 
		FROM SERVICE
		LEFT JOIN CATEGORY USING(THIRD_CATEGORY_NO)
		LEFT JOIN SUB_CATEGORY USING(SUB_CATEGORY_NO)) USING(SERVICE_NO)
	JOIN (SELECT MEMBER_NO,MEMBER_NICKNAME,MEMBER_NAME FROM "MEMBER") USING(MEMBER_NO)) t
WHERE FREELANCER_NO = 30
ORDER BY TRADE_NO;
AND MAIN_CATEGORY_NO = 2 
AND FREELANCER_DONE_FL = 1
AND SERVICE_TITLE LIKE '%제작%';
------------------------------------------------------------------------------------------------
--거래별 서비스 테이블이랑 조인해서 선택해오기 --- 작업물 발송 횟수 들고오기
--1:진행 중, 2: 작업 완료
SELECT t.*,
	CASE WHEN FREELANCER_DONE_FL = 1 THEN '진행 중'
	     WHEN FREELANCER_DONE_FL = 2 THEN '작업 완료'
	     WHEN FREELANCER_DONE_FL = 3 THEN '주문 취소'
	END AS FREELANCER_DONE_FL_STRING
FROM (SELECT * FROM TRADE
	JOIN (SELECT * 
		FROM SERVICE
		LEFT JOIN CATEGORY USING(THIRD_CATEGORY_NO)
		LEFT JOIN SUB_CATEGORY USING(SUB_CATEGORY_NO)) USING(SERVICE_NO)
	LEFT JOIN (SELECT TRADE_NO, NVL(WORK_COUNT,0) WORK_COUNT
		FROM TRADE 
		LEFT JOIN (SELECT COUNT(*) WORK_COUNT,TRADE_NO 
			FROM TRADE
			JOIN "WORK" USING(TRADE_NO)
			GROUP BY TRADE_NO) USING (TRADE_NO)) USING (TRADE_NO) 
	JOIN (SELECT MEMBER_NO,MEMBER_NICKNAME,MEMBER_NAME FROM "MEMBER") USING(MEMBER_NO)) t
WHERE FREELANCER_NO = 30
ORDER BY TRADE_NO;
AND MAIN_CATEGORY_NO = 2 
AND FREELANCER_DONE_FL = 1
AND SERVICE_TITLE LIKE '%제작%';
---------------------------------------------------------------------------
SELECT * FROM TRADE
	JOIN (SELECT * 
		FROM SERVICE
		LEFT JOIN CATEGORY USING(THIRD_CATEGORY_NO)
		LEFT JOIN SUB_CATEGORY USING(SUB_CATEGORY_NO)) USING(SERVICE_NO)
	LEFT JOIN (SELECT TRADE_NO, NVL(WORK_COUNT,0) WORK_COUNT
				FROM TRADE 
				LEFT JOIN (SELECT COUNT(*) WORK_COUNT,TRADE_NO 
					FROM TRADE
					JOIN "WORK" USING(TRADE_NO)
					GROUP BY TRADE_NO) USING (TRADE_NO)) USING (TRADE_NO) 
	JOIN (SELECT MEMBER_NO,MEMBER_NICKNAME,MEMBER_NAME FROM "MEMBER") USING(MEMBER_NO);
---------------------------------------------------------------------------------------------
SELECT TRADE_NO, NVL(WORK_COUNT,0) WORK_COUNT
FROM TRADE 
LEFT JOIN (SELECT COUNT(*) WORK_COUNT,TRADE_NO 
		FROM TRADE
		JOIN "WORK" USING(TRADE_NO)
		GROUP BY TRADE_NO) USING (TRADE_NO);
----------------------------------------------------------------------------
----환불 상태에 따라 주문 취소 나타내기
SELECT t.*,
	CASE WHEN FREELANCER_DONE_FL = 1 THEN '진행 중'
	     WHEN FREELANCER_DONE_FL = 2 THEN '작업 완료'
	     WHEN WORK_STATUS = 3 THEN '주문 취소'
	END AS FREELANCER_DONE_FL_STRING
FROM (SELECT * FROM TRADE
	JOIN (SELECT * 
		FROM SERVICE
		LEFT JOIN CATEGORY USING(THIRD_CATEGORY_NO)
		LEFT JOIN SUB_CATEGORY USING(SUB_CATEGORY_NO)) USING(SERVICE_NO)
	JOIN SETTLEMENT USING(TRADE_NO)
	JOIN (SELECT MEMBER_NO,MEMBER_NICKNAME,MEMBER_NAME FROM "MEMBER") USING(MEMBER_NO)) t
WHERE FREELANCER_NO = 30
ORDER BY TRADE_NO;
AND MAIN_CATEGORY_NO = 2 
AND FREELANCER_DONE_FL = 1
AND SERVICE_TITLE LIKE '%제작%';
