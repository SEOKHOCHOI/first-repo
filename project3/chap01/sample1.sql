-- 주석

/*
    주석
*/

--DUAL : 임시테이블, 테스트용으로 사용
SELECT '연결확인' FROM DUAL;

--계정 생성
CREATE USER user1 IDENTIFIED BY Database1234;

--계정암호변경
--ALTER USER user1 IDENTIFIED BY user11
--시스템 계정으로 접근해서 해야함 유저계정안됨.

-- 권한 부여
GRANT CONNECT, RESOURCE, INSERT ANY TABLE, UPDATE ANY TABLE
, DELETE ANY TABLE, CREATE VIEW
TO user1;

--테이블스페이스 (USERS) 사용 권한 부여
ALTER USER user1 quota 50M ON USERS;

--생성된 계정확인
SELECT * FROM ALL_USERS;

--계정에 부여한 권한 확인
SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE = 'USER1';

--계정에 부여한 ROLE(역할) 확인
--ROLE(역할) : 여러 권한들의 집합.
SELECT * FROM DBA_ROLE_PRIVS WHERE GRANTEE = 'USER1';