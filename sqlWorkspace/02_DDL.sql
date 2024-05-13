---------------------------------------
-------------- DROP -------------------
---------------------------------------

DROP SEQUENCE SEQ_MEMBER;

DROP TABLE MEMBER CASCADE CONSTRAINTS;

---------------------------------------
-------------- SEQ --------------------
---------------------------------------
CREATE SEQUENCE SEQ_MEMBER;



---------------------------------------
----------- CREATE TABLE --------------
---------------------------------------
CREATE TABLE MEMBER (
    MEMBER_NO NUMBER PRIMARY KEY
    , ACC_NAME VARCHAR2(100) NOT NULL UNIQUE
    , PWD VARCHAR2(255) NOT NULL
    , "NAME" VARCHAR2(20) NOT NULL UNIQUE
    , PHONE_NO VARCHAR2(11) NULL
    , PREMIUM_YN CHAR(1) DEFAULT 'N' CHECK(PREMIUM_YN IN ('Y', 'N'))
    , DELETED_YN CHAR(1) DEFAULT 'N' CHECK(DELETED_YN IN ('Y', 'N'))
    , CREATED_DATE TIMESTAMP DEFAULT SYSDATE NOT NULL
    , BAN_DATE TIMESTAMP NULL
);

INSERT INTO MEMBER (MEMBER_NO, ACC_NAME, PWD, NAME, PHONE_NO) 
VALUES(
    SEQ_MEMBER.NEXTVAL
    , 'USER01'
    , '1234'
    , '±èÅÂ¿ì'
    , '01036207737'
);
