------------------------------------------------------------------------------------------------------------
--서비스 등록하기 카테고리 1,3 들고오기
SELECT * FROM MAIN_CATEGORY;

SELECT THIRD_CATEGORY_NO,THIRD_CATEGORY_NAME,MAIN_CATEGORY_NO 
FROM CATEGORY 
JOIN SUB_CATEGORY USING(SUB_CATEGORY_NO)
ORDER BY 1;
