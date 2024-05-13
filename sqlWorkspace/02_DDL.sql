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
    ADDRESS_NO NUMBER PRIMARY KEY
    , MEMBER_NO NUMBER NOT NULL
    , POSTCODE VARCHAR2(10) NOT NULL
    , ADDRESS VARCHAR2(200) NOT NULL
    , DETAILED_ADDRESS VARCHAR2(200) NOT NULL
    , DEFAULT_ADDRESS_YN CHAR(1) DEFAULT 'Y' CHECK(DEFAULT_ADDRESS_YN IN ('Y', 'N'))
    , DEFAULT_SHIPPING_REQ VARCHAR2(100) DEFAULT '������ ���ּ���~' NULL 
);

---------------------------------------
----------------- FK ------------------
---------------------------------------
ALTER TABLE ADDRESS
ADD CONSTRAINT FK_MEMBER_NO FOREIGN KEY(MEMBER_NO)
REFERENCES MEMBER (MEMBER_NO);



---------------------------------------
------------- INSERT ------------------
---------------------------------------
INSERT INTO MEMBER (MEMBER_NO, ID, PWD, NAME, PHONE_NO) 
VALUES(
    SEQ_MEMBER.NEXTVAL
    , 'USER01@gmail.com'
    , '1234'
    , '���¿�'
    , '01036207737'
);

commit;