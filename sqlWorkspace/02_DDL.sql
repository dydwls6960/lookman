---------------------------------------
-------------- DROP -------------------
---------------------------------------
-- SEQ
DROP SEQUENCE SEQ_MEMBER;


-- TABLE
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
    , ID VARCHAR2(100) NOT NULL UNIQUE
    , PWD VARCHAR2(255) NOT NULL
    , NAME VARCHAR2(20) NOT NULL 
    , PHONE_NO VARCHAR2(11) NOT NULL
    , PREMIUM_YN CHAR(1) DEFAULT 'N' CHECK(PREMIUM_YN IN ('Y', 'N'))
    , DELETED_YN CHAR(1) DEFAULT 'N' CHECK(DELETED_YN IN ('Y', 'N'))
    , CREATED_DATE TIMESTAMP DEFAULT SYSDATE NOT NULL
    , BAN_DATE TIMESTAMP NULL
);



---------------------------------------
------------- INSERT ------------------
---------------------------------------
INSERT INTO MEMBER (MEMBER_NO, ID, PWD, NAME, PHONE_NO) 
VALUES(
    SEQ_MEMBER.NEXTVAL
    , 'USER01@gmail.com'
    , '1234'
    , '±èÅÂ¿ì'
    , '01036207737'
);

commit;