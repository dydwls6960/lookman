---------------------------------------
-------------- DROP -------------------
---------------------------------------
-- SEQ
DROP SEQUENCE SEQ_MEMBER;
DROP SEQUENCE SEQ_ADDRESS;

-- TABLE
DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP TABLE ADDRESS CASCADE CONSTRAINTS;


---------------------------------------
-------------- SEQ --------------------
---------------------------------------
CREATE SEQUENCE SEQ_MEMBER;
CREATE SEQUENCE SEQ_ADDRESS;



---------------------------------------
----------- CREATE TABLE --------------
---------------------------------------
CREATE TABLE MEMBER (
    MEMBER_NO NUMBER PRIMARY KEY
    , ID VARCHAR2(100) NOT NULL UNIQUE
    , PWD VARCHAR2(255) NOT NULL
    , NAME VARCHAR2(20) NOT NULL 
    , PHONE_NO VARCHAR2(11) NOT NULL
    , PREMIUM_YN CHAR(1) DEFAULT 'N' CHECK(PREMIUM_YN IN ('Y', 'N'))
    , DELETED_YN CHAR(1) DEFAULT 'N' CHECK(DELETED_YN IN ('Y', 'N'))
    , CREATED_DATE TIMESTAMP DEFAULT SYSDATE NOT NULL
    , BAN_DATE TIMESTAMP NULL
);



CREATE TABLE ADDRESS (
    ADDRESS_NO NUMBER PRIMARY KEY,
    MEMBER_NO NUMBER NOT NULL,
    POSTCODE VARCHAR2(10) NOT NULL,
    ADDRESS VARCHAR2(200) NOT NULL,
    DETAILED_ADDRESS VARCHAR2(200) NOT NULL,
    EXTRA_ADDRESS VARCHAR2(200),
    DEFAULT_YN CHAR(1) DEFAULT 'N' CHECK (DEFAULT_YN IN ('Y', 'N')),
    DEFAULT_REQ VARCHAR2(100) DEFAULT '조심히 와주세요~'
);


---------------------------------------
----------------- FK ------------------
---------------------------------------
ALTER TABLE ADDRESS
ADD CONSTRAINT FK_ADDRESS2_MEMBER_NO FOREIGN KEY (MEMBER_NO) 
REFERENCES MEMBER (MEMBER_NO);





---------------------------------------
------------- INSERT ------------------
---------------------------------------
INSERT INTO MEMBER (MEMBER_NO, ID, PWD, NAME, PHONE_NO) 
VALUES(
    SEQ_MEMBER.NEXTVAL
    , 'USER01@gmail.com'
    , '1234'
    , '김태우'
    , '01036207737'
);

INSERT INTO ADDRESS(ADDRESS_NO, MEMBER_NO, POSTCODE, ADDRESS, DETAILED_ADDRESS, EXTRA_ADDRESS)
VALUES (
    SEQ_ADDRESS.NEXTVAL
    , 1
    , '10416'
    , '기흥역로 16'
    , '2530동 202호'
    , '(기흥동 15번지)'
);

commit;