CREATE USER C##LOOKMAN IDENTIFIED BY 1234;
GRANT RESOURCE, CONNECT TO C##LOOKMAN;
ALTER USER C##LOOKMAN DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
