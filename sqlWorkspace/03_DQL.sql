-- MemberDao - getMemberNo()
SELECT MEMBER_NO
FROM MEMBER
WHERE ID = 'taewookim02@gmail.com';


-- MemberDao - login()
SELECT * 
FROM MEMBER 
WHERE ID = 'taewookim02@gmail.com' 
AND PWD = '123456789A@'
AND DELETED_YN = 'N' 
AND BAN_DATE IS NULL
;

