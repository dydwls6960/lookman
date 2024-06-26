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

-- SEARCH
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
    AND P.NAME LIKE '%자켓%' OR S.NAME LIKE '%빈폴%'
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
WHERE P.PRODUCT_NO = 2
GROUP BY S.SELLER_NO, S.NAME, P.PRODUCT_NO, P.NAME, P.PRICE, P.DETAILS, P.HIT, NVL(S.SHIPPING_INFO, '기본 배송')
;

-- INVENTORY FOR SELECT OPTIONS
SELECT I.INVENTORY_NO, I.PRODUCT_NO, I.COLOR_NO, C.NAME COLOR_NAME, I.SIZE_NO, PS.NAME SIZE_NAME, I.QUANTITY INVENTORY_QUANTITY, TO_CHAR(P.PRICE, '999,999,999') PRODUCT_PRICE
FROM INVENTORY I
JOIN COLOR C ON I.COLOR_NO = C.COLOR_NO
JOIN PRODUCT_SIZE PS ON I.SIZE_NO = PS.SIZE_NO
JOIN PRODUCT P ON I.PRODUCT_NO = P.PRODUCT_NO
WHERE I.PRODUCT_NO = 3
;


-- SIZE ON COLOR SELECT
SELECT I.INVENTORY_NO, I.SIZE_NO, PS.NAME SIZE_NAME, I.QUANTITY, TRIM(TO_CHAR(P.PRICE, '999,999,999')) PRODUCT_PRICE
FROM INVENTORY I
JOIN COLOR C ON I.COLOR_NO = C.COLOR_NO 
JOIN PRODUCT_SIZE PS ON I.SIZE_NO = PS.SIZE_NO
JOIN PRODUCT P ON I.PRODUCT_NO = P.PRODUCT_NO
WHERE I.COLOR_NO = 1
AND I.PRODUCT_NO = 1
;

-- 상품 좋아요 했는지 체크
SELECT COUNT(*)
FROM FAVORITE
WHERE MEMBER_NO = 1
AND PRODUCT_NO = 1
;

-- 상품 좋아요 삽입
INSERT INTO FAVORITE(FAVORITE_NO, MEMBER_NO, PRODUCT_NO) 
VALUES(SEQ_FAVORITE.NEXTVAL, 1, 2);

-- 상품 좋아요 삭제
DELETE FROM FAVORITE
WHERE MEMBER_NO = 1
AND PRODUCT_NO = 2
;

-- 장바구니 
INSERT ALL
<foreach collection="list" item="vo" separator=" ">
    INTO CART(CART_NO, MEMBER_NO, INVENTORY_NO, QUANTITY)
    VALUES ((SELECT FN_GET_CART_SEQ_NEXTVAL FROM DUAL), #{vo.memberNo}, #{vo.inventoryNo}, #{vo.quantity})				
</foreach>
SELECT * FROM DUAL



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
-- 장바구니 페이지
-- DTO
SELECT ROWNUM, X.*
FROM (SELECT 
    C.CART_NO
    , I.PRODUCT_NO
    , P.NAME PRODUCT_NAME
    , I.INVENTORY_NO
    , C.COLOR_NO
    , C.NAME COLOR_NAME
    , PS.SIZE_NO
    , PS.NAME SIZE_NAME
    , TRIM(TO_CHAR(P.PRICE, '999,999,999')) PRICE
    , TRIM(TO_CHAR(ROUND(P.PRICE * C.QUANTITY), '999,999,999')) ORDER_PRICE
    , PI.FILENAME THUMBNAIL_FILENAME
    , C.QUANTITY ORDER_QUANTITY
    , I.QUANTITY INVENTORY_QUANTITY
    , C.CREATED_DATE
    , C.MEMBER_NO
    , S.NAME SELLER_NAME
FROM CART C
JOIN INVENTORY I ON C.INVENTORY_NO = I.INVENTORY_NO
JOIN PRODUCT P ON I.PRODUCT_NO = P.PRODUCT_NO
JOIN COLOR C ON I.COLOR_NO = C.COLOR_NO
JOIN PRODUCT_SIZE PS ON I.SIZE_NO = PS.SIZE_NO
JOIN PRODUCT_IMG PI ON P.PRODUCT_NO = PI.PRODUCT_NO AND PI.THUMBNAIL_YN = 'Y'
JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO
WHERE MEMBER_NO = 1
ORDER BY C.CREATED_DATE DESC) X
;


-- 장바구니 개별 아이템 삭제
DELETE FROM CART
WHERE MEMBER_NO = 1
AND CART_NO = 1
;

-- 장바구니 삭제
DELETE FROM CART
<foreach collection="array" item="no" separator="," open="WHERE CART_NO IN (" close=")">
    #{no}
</foreach>
;


--------------------------------------------------------
-- 찜한상품 페이지
SELECT 
    F.FAVORITE_NO
    , S.SELLER_NO
    , S.NAME SELLER_NAME
    , P.PRODUCT_NO
    , P.NAME PRODUCT_NAME
    , TRIM(TO_CHAR(P.PRICE, '999,999,999')) PRICE
    , PI.FILENAME THUMBNAIL_FILENAME
    , (SELECT COUNT(*) FROM FAVORITE F2 WHERE F2.PRODUCT_NO = P.PRODUCT_NO) FAVORITE_CNT
FROM FAVORITE F
JOIN PRODUCT P ON F.PRODUCT_NO = P.PRODUCT_NO
JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO
JOIN PRODUCT_IMG PI ON P.PRODUCT_NO = PI.PRODUCT_NO AND PI.THUMBNAIL_YN = 'Y'
WHERE MEMBER_NO = 1
ORDER BY F.CREATED_DATE DESC
;


--------------------------------------------------------
-- 주문 form 페이지
-- orderFormDetails
SELECT 
    PI.FILENAME THUMBNAIL_FILENAME
    , S.NAME SELLER_NAME
    , P.PRODUCT_NO 
    , P.NAME PRODUCT_NAME
    , S.NAME SIZE_NAME
    , C.NAME COLOR_NAME
    , C.QUANTITY ORDER_QUANTITY
    , TRIM(TO_CHAR(P.PRICE, '999,999,999')) PRODUCT_PRICE
    , TRIM(TO_CHAR(ROUND(C.QUANTITY * P.PRICE), '999,999,999')) ORDER_PRICE
    , I.QUANTITY INVENTORY_QUANTITY
    , I.INVENTORY_NO INVENTORY_NO
FROM CART C
JOIN INVENTORY I ON C.INVENTORY_NO = I.INVENTORY_NO
JOIN PRODUCT P ON I.PRODUCT_NO = P.PRODUCT_NO
JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO
JOIN PRODUCT_IMG PI ON P.PRODUCT_NO = PI.PRODUCT_NO AND PI.THUMBNAIL_YN = 'Y'
LEFT JOIN PRODUCT_SIZE PS ON I.SIZE_NO = PS.SIZE_NO
LEFT JOIN COLOR C ON I.COLOR_NO = C.COLOR_NO
WHERE CART_NO IN (1, 2)
ORDER BY C.CREATED_DATE DESC
;
SELECT * FROM CART;
select * from address;

-- 배송지 하나 셀렉트
SELECT 
    A.ADDRESS_NO
    , M.NAME MEMBER_NAME
    , M.MEMBER_NO
    , M.PHONE_NO
    , A.POSTCODE
    , A.ADDRESS
    , A.DETAILED_ADDRESS
    , A.EXTRA_ADDRESS
    , A.DEFAULT_YN 
    , A.DEFAULT_REQ 
    , A.DELETED_YN
FROM ADDRESS A
JOIN MEMBER M ON A.MEMBER_NO = M.MEMBER_NO
WHERE A.ADDRESS_NO = 1
AND A.DELETED_YN = 'N';

-- Addresses (AddressVo)
SELECT 
    ADDRESS_NO
    , MEMBER_NO
    , POSTCODE
    , ADDRESS
    , DETAILED_ADDRESS
    , EXTRA_ADDRESS
    , DEFAULT_YN DEFAULT_ADDRESS_YN
    , DEFAULT_REQ DEFAULT_SHIPPING_REQ
    , DELETED_YN
FROM ADDRESS
WHERE MEMBER_NO = 1
AND DELETED_YN = 'N'
ORDER BY DEFAULT_YN DESC
;

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
-- 결제 REST API
SELECT *
FROM PAYMENT;
SELECT *
FROM ORDERS;
select * from review;
-- ORDERS테이블에 삽입
SELECT *
FROM ORDERS;
SELECT * FROM STATUS;

INSERT INTO ORDERS
    (ORDERS_NO
    , MEMBER_NO
    , ADDRESS_NO
    , STATUS_NO
    , TOTAL_PRICE
    , SHIPPING_REQ
    , SHIPPING_FEE)
VALUES
    (
    SEQ_ORDERS.NEXTVAL
    , 
    1, 
    1,
    2, 
    180000, 
    '안전하게 와주세용~', 
    0
    )
;

-- ORDER_DETAIL TABLE에 삽입
--<insert id="insertIntoOrderDetail">
--    INSERT ALL
--    <foreach collection="productDetails" item="detail">
--        INTO ORDER_DETAIL (ORDER_DETAIL_NO, ORDERS_NO, PRODUCT_NO, INVENTORY_NO,
--        QUANTITY)
--        VALUES ((SELECT FN_GET_ORDER_DETAIL_SEQ_NEXTVAL FROM DUAL), ${ordersNo}, ${detail.productNo},
--        ${detail.inventoryNo}, ${detail.quantity})
--    </foreach>
--    SELECT 1 FROM DUAL
--</insert>
--;

-- 카트 테이블 삭제 (결제된 것)
--<delete id="deleteCartByMemberNoAndInventory">
--    DELETE FROM CART
--    WHERE MEMBER_NO = ${memberNo}
--    <foreach collection="productDetails" item="detail" open="AND INVENTORY_NO IN (" separator="," close=")">
--        ${detail.inventoryNo}
--    </foreach>
--</delete>
--;

-- 재고 DECREMENT
--<update id="decrementInventories" parameterType="PaymentResponseDto">
--    BEGIN
--    <foreach collection="productDetails" item="detail">
--      UPDATE INVENTORY
--      SET QUANTITY = QUANTITY - ${detail.quantity}
--      WHERE INVENTORY_NO = #{detail.inventoryNo}
--      AND PRODUCT_NO = #{detail.productNo};
--    </foreach>
--    END;
--</update> 
--;

-- 결제 테이블 INSERT
INSERT INTO PAYMENT(PAYMENT_NO, ORDERS_NO, CARD_COMPANY_NO, STATUS_NO, AMOUNT)
VALUES(SEQ_PAYMENT.NEXTVAL, 10, 1, 2, 5000)
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

SELECT *
FROM ORDER_DETAIL;

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
-- 주문문의 
-- 삽입 
INSERT INTO ORDER_INQUIRY (ORDER_INQUIRY_NO, ORDER_DETAIL_NO, MEMBER_NO, SELLER_NO, STATUS_NO, TITLE, QUESTION_CONTENT) 
VALUES (SEQ_ORDER_INQUIRY.NEXTVAL, ${orderDetailNo}, ${memberNo}, ${sellerNo}, 11, '배송 상태 문의', '주문한 상품의 배송 상태는 어떻게 되나요?');


--------------------------------------------------------
-- 내 주문문의 관리 페이지
SELECT 
    OI.ORDER_INQUIRY_NO
    , OD.ORDERS_NO 
    , OI.ORDER_DETAIL_NO
    , OD.INVENTORY_NO
    , P.PRODUCT_NO
    , P.NAME PRODUCT_NAME
    , OI.MEMBER_NO
    , M.NAME MEMBER_NAME
    , SL.SELLER_NO
    , SL.NAME SELLER_NAME
    , PI.FILENAME THUMBNAIL_FILENAME
    , S.NAME STATUS
    , OI.TITLE
    , OI.QUESTION_CONTENT
    , OI.RESPONSE_CONTENT
    , OI.ASK_DATE
    , OI.RESPONSE_DATE
    , OI.DELETED_YN
FROM ORDER_INQUIRY OI
JOIN MEMBER M ON OI.MEMBER_NO = M.MEMBER_NO
JOIN ORDER_DETAIL OD ON OI.ORDER_DETAIL_NO = OD.ORDER_DETAIL_NO
JOIN PRODUCT P ON OD.PRODUCT_NO = P.PRODUCT_NO
JOIN PRODUCT_IMG PI ON OD.PRODUCT_NO = PI.PRODUCT_NO AND PI.THUMBNAIL_YN = 'Y'
JOIN SELLER SL ON P.SELLER_NO = SL.SELLER_NO
JOIN STATUS S ON OI.STATUS_NO = S.STATUS_NO
WHERE OI.MEMBER_NO = 1
AND OI.DELETED_YN = 'N'
;

-- 삭제
UPDATE ORDER_INQUIRY
SET DELETED_YN = 'Y'
WHERE ORDER_INQUIRY_NO = 1
AND MEMBER_NO = 1
;

-- 수정
UPDATE ORDER_INQUIRY
SET TITLE = 'ZZ'
, QUESTION_CONTENT = 'ZZ'
WHERE MEMBER_NO = 1
AND SELLER_NO = 1
AND ORDER_INQUIRY_NO = 11
;

 
--------------------------------------------------------
-- 내 상품문의 관리 페이지
-- 내 상품문의들 
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
WHERE PI.MEMBER_NO = ?
AND PI.DELETED_YN = 'N'
ORDER BY ASK_DATE DESC
;

-- 상품문의 수정
UPDATE PRODUCT_INQUIRY
SET 
    TITLE = #{title},
    QUESTION_CONTENT = #{questionContent},
    PRIVATE_YN = #{privateYn}
WHERE PRODUCT_INQUIRY_NO = ${productInquiryNo}
AND MEMBER_NO = ${memberNo};

-- 상품문의 삭제
UPDATE PRODUCT_INQUIRY
SET
    DELETED_YN = 'Y'
WHERE PRODUCT_INQUIRY_NO = ${productInquiryNo}
AND MEMBER_NO = ${memberNo}

-- 상품문의 삽입
INSERT INTO PRODUCT_INQUIRY 
    (PRODUCT_INQUIRY_NO
    , MEMBER_NO
    , SELLER_NO
    , PRODUCT_NO
    , STATUS_NO
    , TITLE
    , QUESTION_CONTENT
    , PRIVATE_YN) 
VALUES 
    (SEQ_PRODUCT_INQUIRY.NEXTVAL
    , ${memberNo}
    , ${sellerNo}
    , ${productNo}
    , 10
    , #{title}
    , #{questionContent}
    , #{privateYn})
;

--------------------------------------------------------
-- 주문/배송 페이지 (/app/orders/list)
SELECT
    O.MEMBER_NO
    , O.ORDERS_NO
    , OD.ORDER_DETAIL_NO
    , SL.SELLER_NO
    , SL.NAME SELLER_NAME
    , P.PRODUCT_NO
    , P.NAME PRODUCT_NAME
    , TRIM(TO_CHAR(P.PRICE, '999,999,999')) PRODUCT_PRICE
    , TRIM(TO_CHAR(ROUND(P.PRICE * OD.QUANTITY), '999,999,999')) ORDER_DETAIL_PRICE
    , OD.QUANTITY ORDER_DETAIL_QUANTITY
    , S.NAME ORDER_STATUS_NAME
    , S.STATUS_NO ORDER_STATUS_NO
    , ODS.NAME ORDER_DETAIL_STATUS_NAME
    , ODS.STATUS_NO ORDER_DETAIL_STATUS_NO
    , I.INVENTORY_NO 
    , PS.NAME SIZE_NAME
    , C.NAME COLOR_NAME
    , PI.FILENAME THUMBNAIL_FILENAME
    , TO_CHAR(O.CREATED_DATE, 'YYYY.mm.dd') ORDER_DATE
FROM ORDERS O
JOIN STATUS S ON O.STATUS_NO = S.STATUS_NO
JOIN ORDER_DETAIL OD ON O.ORDERS_NO = OD.ORDERS_NO
JOIN INVENTORY I ON OD.INVENTORY_NO = I.INVENTORY_NO
JOIN PRODUCT_SIZE PS ON I.SIZE_NO = PS.SIZE_NO
JOIN COLOR C ON I.COLOR_NO = C.COLOR_NO
JOIN STATUS ODS ON OD.STATUS_NO = ODS.STATUS_NO
JOIN PRODUCT P ON OD.PRODUCT_NO = P.PRODUCT_NO
JOIN PRODUCT_IMG PI ON P.PRODUCT_NO = PI.PRODUCT_NO AND PI.THUMBNAIL_YN = 'Y'
JOIN SELLER SL ON P.SELLER_NO = SL.SELLER_NO
WHERE O.MEMBER_NO = 1 AND OD.STATUS_NO = 1
ORDER BY O.CREATED_DATE DESC, OD.ORDER_DETAIL_NO DESC
;

-- getStatusCount()
SELECT S.STATUS_NO, S.NAME STATUS_NAME, COALESCE(COUNT(OD.STATUS_NO), 0) AS COUNT
FROM STATUS S
LEFT JOIN (
    SELECT OD.STATUS_NO
    FROM ORDER_DETAIL OD
    JOIN ORDERS O ON OD.ORDERS_NO = O.ORDERS_NO
    WHERE O.MEMBER_NO = 1
) OD ON S.STATUS_NO = OD.STATUS_NO
WHERE S.STATUS_NO IN (1, 3, 4, 5, 6)
GROUP BY S.NAME, S.STATUS_NO
ORDER BY S.STATUS_NO
;

select *
from status;

SELECT *
FROM ORDERS O
left JOIN ORDER_DETAIL OD ON O.ORDERS_NO = OD.ORDERS_NO
left JOIN PRODUCT P ON P.PRODUCT_NO = OD.PRODUCT_NO
WHERE O.MEMBER_NO = 1 AND O.STATUS_NO = 2
;

-- Verify ORDER_DETAIL entries
SELECT *
FROM ORDER_DETAIL
WHERE ORDERS_NO = 2; -- Example order number

-- Verify PRODUCT entries
SELECT *
FROM PRODUCT
WHERE PRODUCT_NO IN (SELECT PRODUCT_NO FROM ORDER_DETAIL WHERE ORDERS_NO = 2);

-- Verify ORDER entries
SELECT *
FROM ORDERS
WHERE ORDERS_NO = 2;

--------------------------------------------------------
-- 카테고리 페이지
SELECT CATEGORY_NO, NAME
FROM CATEGORY
ORDER BY CATEGORY_NO;

--------------------------------------------------------
-- 카테고리 별 상품 리스트 페이지
SELECT 
    P.PRODUCT_NO, 
    TO_CHAR(P.PRICE, '999,999,999') PRICE,  
    S.NAME SELLER_NAME,
    P.NAME PRODUCT_NAME, 
    PI.FILENAME, 
    C.NAME CATEGORY_NAME,
    NVL(ROUND(AVG(R.RATING), 1), 0) AVG_RATING, 
    COUNT(R.RATING) REVIEW_CNT
FROM PRODUCT P
LEFT JOIN REVIEW R ON P.PRODUCT_NO = R.PRODUCT_NO
JOIN PRODUCT_IMG PI ON P.PRODUCT_NO = PI.PRODUCT_NO
JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO
JOIN CATEGORY C ON P.CATEGORY_NO = C.CATEGORY_NO
WHERE PI.THUMBNAIL_YN = 'Y'
    AND P.DELETED_YN = 'N' 
    AND PI.DELETED_YN = 'N'
    AND P.CATEGORY_NO = ?
GROUP BY P.PRODUCT_NO, P.PRICE, S.NAME, P.NAME, PI.FILENAME, C.NAME
ORDER BY P.PRODUCT_NO DESC
;

--------------------------------------------------------
-- 스토어 페이지
SELECT SELLER_NO, NAME, INFO
FROM SELLER
WHERE DELETED_YN = 'N';



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