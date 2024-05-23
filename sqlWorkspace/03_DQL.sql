--------------------------------------------------------
-- 메인페이지
    -- dto
SELECT 
    P.PRODUCT_NO, 
    TO_CHAR(P.PRICE, '999,999,999') PRICE,  
    S.NAME SELLER_NAME,
    P.NAME PRODUCT_NAME, 
    PI.FILENAME, 
    NVL(ROUND(AVG(R.RATING), 1), 0) AVG_RATING, 
    COUNT(R.RATING) REVIEW_CNT
FROM PRODUCT P
LEFT JOIN REVIEW R ON P.PRODUCT_NO = R.PRODUCT_NO
JOIN PRODUCT_IMG PI ON P.PRODUCT_NO = PI.PRODUCT_NO
JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO
WHERE PI.THUMBNAIL_YN = 'Y'
    AND P.DELETED_YN = 'N' 
    AND PI.DELETED_YN = 'N'
GROUP BY P.PRODUCT_NO, P.PRICE, S.NAME, P.NAME, PI.FILENAME
ORDER BY P.PRODUCT_NO DESC
;


--------------------------------------------------------
-- 상세페이지

-- 조회수 증가
UPDATE PRODUCT
SET HIT = HIT + 1
WHERE PRODUCT_NO = 2;

-- dto
SELECT
    S.SELLER_NO SELLER_NO
    , S.NAME SELLER_NAME
    , P.PRODUCT_NO PRODUCT_NO
    , P.NAME PRODUCT_NAME
    , TO_CHAR(P.PRICE, '999,999,999') PRICE
    , P.DETAILS DETAILS
    , P.HIT HIT
    , NVL(S.SHIPPING_INFO, '기본 배송') SHIPPING_DETAILS
    , NVL(ROUND(AVG(R.RATING), 1), 0) AVG_RATING
    , COUNT(R.REVIEW_NO) REVIEW_CNT
FROM PRODUCT P
JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO
LEFT JOIN REVIEW R ON R.PRODUCT_NO = P.PRODUCT_NO
WHERE P.PRODUCT_NO = ?
GROUP BY S.SELLER_NO, S.NAME, P.PRODUCT_NO, P.NAME, P.PRICE, P.DETAILS, P.HIT, NVL(S.SHIPPING_INFO, '기본 배송')
;

-- /products/*
-- IMGS
SELECT IMG_NO, PRODUCT_NO, FILENAME, THUMBNAIL_YN, DELETED_YN, CREATED_DATE
FROM PRODUCT_IMG
WHERE PRODUCT_NO = ?
AND DELETED_YN = 'N'
ORDER BY THUMBNAIL_YN DESC, IMG_NO ASC
;

-- REVIEWS
SELECT 
    R.REVIEW_NO,
    R.MEMBER_NO,
    M.NAME MEMBER_NAME,
    R.PRODUCT_NO,
    R.RATING,
    R.CONTENT,
    R.CREATED_DATE,
    R.DELETED_YN,
    PS.NAME PRODUCT_SIZE,
    C.NAME PRODUCT_COLOR,
    C.HEXCODE COLOR_HEX,
    OD.QUANTITY PRODUCT_QUANTITY
FROM REVIEW R
JOIN MEMBER M ON R.MEMBER_NO = M.MEMBER_NO
JOIN ORDERS O ON R.ORDERS_NO = O.ORDERS_NO
JOIN ORDER_DETAIL OD ON O.ORDERS_NO = OD.ORDERS_NO AND R.PRODUCT_NO = OD.PRODUCT_NO
JOIN INVENTORY I ON OD.INVENTORY_NO = I.INVENTORY_NO
JOIN PRODUCT_SIZE PS ON I.SIZE_NO = PS.SIZE_NO
JOIN COLOR C ON I.COLOR_NO = C.COLOR_NO
WHERE R.PRODUCT_NO = 2
AND R.DELETED_YN = 'N'
ORDER BY R.REVIEW_NO DESC, R.CREATED_DATE DESC
;


-- INQUIRY
SELECT 
PI.PRODUCT_INQUIRY_NO PRODUCT_INQUIRY_NO
, PI.PRODUCT_NO PRODUCT_NO
, M.MEMBER_NO MEMBER_NO
, M.NAME MEMBER_NAME
, S.SELLER_NO SELLER_NO
, S.NAME SELLER_NAME
, ST.NAME STATUS
, PI.TITLE TITLE
, PI.QUESTION_CONTENT QUESTION_CONTENT
, PI.RESPONSE_CONTENT RESPONSE_CONTENT
, TO_CHAR(PI.ASK_DATE, 'YYYY-MM-DD') QUESTION_DATE
, TO_CHAR(PI.RESPONSE_DATE, 'YYYY-MM-DD') RESPONSE_DATE
, PI.PRIVATE_YN PRIVATE_YN
, PI.DELETED_YN DELETED_YN
FROM PRODUCT_INQUIRY PI
JOIN SELLER S ON PI.SELLER_NO = S.SELLER_NO
JOIN STATUS ST ON PI.STATUS_NO = ST.STATUS_NO
JOIN MEMBER M ON PI.MEMBER_NO = M.MEMBER_NO
WHERE PI.PRODUCT_NO = ?
AND PI.DELETED_YN = 'N'
;

-- 상품문의 수정
UPDATE PRODUCT_INQUIRY
SET 
    TITLE = 'ZZZTT',
    QUESTION_CONTENT = 'ZZCC',
    PRIVATE_YN = 'Y'
WHERE PRODUCT_INQUIRY_NO = 1
AND MEMBER_NO = 1
;

    
-- 상품문의 삭제
UPDATE PRODUCT_INQUIRY
SET
    DELETED_YN = 'Y'
WHERE PRODUCT_INQUIRY_NO = 1
AND MEMBER_NO = 1
;

-- 상품문의 삽입
INSERT INTO PRODUCT_INQUIRY (PRODUCT_INQUIRY_NO, MEMBER_NO, SELLER_NO, PRODUCT_NO, STATUS_NO, TITLE, QUESTION_CONTENT, PRIVATE_YN) 
VALUES (SEQ_PRODUCT_INQUIRY.NEXTVAL, ?, ?, ?, 10, ?, ?, ?);



--------------------------------------------------------
-- 랭킹페이지
SELECT 
    P.PRODUCT_NO, 
    TO_CHAR(P.PRICE, '999,999,999') PRICE,  
    S.NAME SELLER_NAME,
    P.NAME PRODUCT_NAME, 
    PI.FILENAME, 
    NVL(ROUND(AVG(R.RATING), 1), 0) AVG_RATING, 
    COUNT(R.REVIEW_NO) REVIEW_CNT
FROM PRODUCT P
LEFT JOIN REVIEW R ON P.PRODUCT_NO = R.PRODUCT_NO
JOIN PRODUCT_IMG PI ON P.PRODUCT_NO = PI.PRODUCT_NO
JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO
WHERE PI.THUMBNAIL_YN = 'Y'
    AND P.DELETED_YN = 'N' 
    AND PI.DELETED_YN = 'N'
GROUP BY P.PRODUCT_NO, P.PRICE, S.NAME, P.NAME, PI.FILENAME
ORDER BY AVG_RATING DESC, REVIEW_CNT DESC
;



--------------------------------------------------------
-- 회원정보 수정 페이지
-- 비밀번호 확인
SELECT COUNT(*) 
FROM MEMBER 
WHERE MEMBER_NO = ? 
AND PWD = ?
;

-- 새 비밀번호 
UPDATE MEMBER 
SET PWD = ? 
WHERE MEMBER_NO = ?
;

-- 회원정보 업데이트
UPDATE MEMBER 
SET NAME = ?, PHONE_NO = ? 
WHERE MEMBER_NO = ?
;


--------------------------------------------------------
-- 내 배송지 관리 페이지
SELECT
    A.ADDRESS_NO
    , M.NAME MEMBER_NAME
    , A.MEMBER_NO MEMBER_NO
    , M.PHONE_NO PHONE_NO
    , A.POSTCODE POSTCODE
    , A.ADDRESS ADDRESS
    , A.DETAILED_ADDRESS DETAILED_ADDRESS
    , NVL(A.EXTRA_ADDRESS, '') EXTRA_ADDRESS
    , A.DEFAULT_YN DEFAULT_YN
    , A.DELETED_YN DELETED_YN
FROM ADDRESS A
JOIN MEMBER M ON A.MEMBER_NO = M.MEMBER_NO
WHERE A.MEMBER_NO = ?
AND A.DELETED_YN = 'N';

-- 주소 업데이트
UPDATE ADDRESS 
SET POSTCODE = ?
, ADDRESS = ?
, DETAILED_ADDRESS = ?
, EXTRA_ADDRESS = ?
WHERE ADDRESS_NO = ?
AND DELETED_YN = 'N';


-- 기본주소 리셋
UPDATE ADDRESS
SET DEFAULT_YN = 'N'
WHERE MEMBER_NO = ?
AND DELETED_YN = 'N'
;

-- 기본주소 설정
UPDATE ADDRESS
SET DEFAULT_YN = 'Y'
WHERE ADDRESS_NO = ?
AND DELETED_YN = 'N'
;

-- 주소 삽입
INSERT INTO ADDRESS(ADDRESS_NO, MEMBER_NO, POSTCODE, ADDRESS, DETAILED_ADDRESS, EXTRA_ADDRESS) 
VALUES(SEQ_ADDRESS.NEXTVAL, 1, '123', '주소1', '주소2', '');


-- 주소 삭제
UPDATE ADDRESS
SET DELETED_YN = 'Y'
WHERE ADDRESS_NO = 12
;


--------------------------------------------------------
-- 내 리뷰 관리 페이지
SELECT 
    R.REVIEW_NO,
    R.MEMBER_NO,
    M.NAME MEMBER_NAME,
    R.PRODUCT_NO,
    P.NAME PRODUCT_NAME,
    R.RATING,
    R.CONTENT,
    R.CREATED_DATE,
    NVL(R.EDITED_DATE, '') EDITED_DATE,
    R.DELETED_YN,
    PS.NAME PRODUCT_SIZE,
    C.NAME PRODUCT_COLOR,
    C.HEXCODE COLOR_HEX,
    OD.QUANTITY PRODUCT_QUANTITY,
    PI.FILENAME THUMBNAIL_FILENAME
FROM REVIEW R
JOIN PRODUCT P ON R.PRODUCT_NO = P.PRODUCT_NO
JOIN MEMBER M ON R.MEMBER_NO = M.MEMBER_NO
JOIN ORDERS O ON R.ORDERS_NO = O.ORDERS_NO
JOIN ORDER_DETAIL OD ON O.ORDERS_NO = OD.ORDERS_NO AND R.PRODUCT_NO = OD.PRODUCT_NO
JOIN INVENTORY I ON OD.INVENTORY_NO = I.INVENTORY_NO
JOIN PRODUCT_SIZE PS ON I.SIZE_NO = PS.SIZE_NO
JOIN COLOR C ON I.COLOR_NO = C.COLOR_NO
LEFT JOIN PRODUCT_IMG PI ON R.PRODUCT_NO = PI.PRODUCT_NO AND PI.THUMBNAIL_YN = 'Y'
WHERE R.MEMBER_NO = 1
AND R.DELETED_YN = 'N'
ORDER BY R.REVIEW_NO DESC, R.CREATED_DATE DESC
;

-- 리뷰 수정
UPDATE REVIEW 
SET 
    RATING = 1,
    CONTENT = 'ZZZZZZ',
    EDITED_DATE = SYSDATE
WHERE REVIEW_NO = 2
AND MEMBER_NO = 1
;

-- 리뷰 삭제
UPDATE REVIEW
SET DELETED_YN = 'N',
EDITED_DATE = SYSDATE
WHERE REVIEW_NO = 2
AND MEMBER_NO = 1
;



--------------------------------------------------------
-- 내 상품문의 관리 페이지
--	private String productInquiryNo;
--	private String productNo;
--	private String memberNo;
--	private String memberName;
--	private String sellerNo;
--	private String sellerName;
--	private String thumbnailFilename;
--	private String status;
--	private String title;
--	private String questionContent;
--	private String responseContent;
--	private String questionDate;
--	private String responseDate;
--	private String privateYn;
--	private String deletedYn;

SELECT 
    PI.PRODUCT_INQUIRY_NO PRODUCT_INQUIRY_NO
    , PI.PRODUCT_NO PRODUCT_NO
    , PI.MEMBER_NO MEMBER_NO
    , M.NAME MEMBER_NAME
    , PI.SELLER_NO SELLER_NO
    , S.NAME SELLER_NAME
    , PIMG.FILENAME THUMBNAIL_FILENAME
    , ST.NAME STATUS
    , PI.TITLE TITLE
    , PI.QUESTION_CONTENT QUESTION_CONTENT
    , PI.RESPONSE_CONTENT RESPONSE_CONTENT
    , PI.ASK_DATE QUESTION_DATE
    , PI.RESPONSE_DATE
    , PI.PRIVATE_YN
    , PI.DELETED_YN
FROM PRODUCT_INQUIRY PI
JOIN MEMBER M ON PI.MEMBER_NO = M.MEMBER_NO
JOIN SELLER S ON PI.SELLER_NO = S.SELLER_NO
JOIN PRODUCT_IMG PIMG ON PI.PRODUCT_NO = PIMG.PRODUCT_NO AND PIMG.THUMBNAIL_YN = 'Y'
JOIN STATUS ST ON PI.STATUS_NO = ST.STATUS_NO
WHERE PI.MEMBER_NO = 1
AND PI.DELETED_YN = 'N'
ORDER BY ASK_DATE DESC
;





--------------------------------------------------------
-- 로그인 페이지
SELECT * 
FROM MEMBER 
WHERE ID = 'taewookim02@gmail.com' 
AND PWD = '123456789A@'
AND DELETED_YN = 'N' 
AND BAN_DATE IS NULL
;


--------------------------------------------------------
-- 회원가입 페이지
INSERT INTO ADDRESS(ADDRESS_NO, MEMBER_NO, POSTCODE, ADDRESS, DETAILED_ADDRESS, EXTRA_ADDRESS, DEFAULT_YN)
VALUES (SEQ_ADDRESS.NEXTVAL, SEQ_MEMBER.CURRVAL, ?, ?, ?, ?, 'Y');


-- DECREMENT INVENTORY QUANTITY
UPDATE INVENTORY
SET QUANTITY = QUANTITY - 1
WHERE PRODUCT_NO = 1 AND COLOR_NO = 2 AND SIZE_NO = 2
;





-- REVIEW 
SELECT P.NAME, M.NAME, R.CONTENT, R.RATING
FROM REVIEW R
JOIN PRODUCT P ON R.PRODUCT_NO = P.PRODUCT_NO
JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO
WHERE P.PRODUCT_NO = 1
;


-- ORDER DETAILS
SELECT M.NAME, P.NAME, P.PRICE, OD.QUANTITY, P.PRICE * OD.QUANTITY
FROM ORDER_DETAIL OD
JOIN ORDERS O ON OD.ORDERS_NO = O.ORDERS_NO
JOIN MEMBER M ON O.MEMBER_NO = M.MEMBER_NO
JOIN PRODUCT P ON OD.PRODUCT_NO = P.PRODUCT_NO
WHERE M.MEMBER_NO = 1
;


-- FAQ
SELECT FA.NAME, A.NICK, F.TITLE, F.CONTENT, F.HIT
FROM FAQ F
JOIN ADMIN A ON F.ADMIN_NO = A.ADMIN_NO
JOIN FAQ_CATEGORY FA ON F.FAQ_CATEGORY_NO = FA.FAQ_CATEGORY_NO;


-- REPORT - BAN