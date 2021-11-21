/*
    1. Develop1 계정을 하나 새로 생성한다.
        - 이 계정의 패스워드는 임의로 생성한다.
        - 이 계정은 Oracle DBMS에 접속할 수 있어야 한다.
        - 이 계정은 테이블 생성 및 수정, 삭제 권한과 데이터 조회, 추가, 수정, 삭제 권한이 필요하다.
*/
CREATE USER develop1 IDENTIFIED BY Database1234;
GRANT CONNECT, RESOURCE, INSERT ANY TABLE
    , UPDATE ANY TABLE, DELETE ANY TABLE
    , CREATE VIEW TO develop1;
ALTER USER develop1 quota 10M ON USERS;

/*
    2. 1 번에서 생성한 계정으로 Oracle DBMS 에 접속하여 테이블을 생성하도록 한다.(컬럼에 대한 주석(비고) 반드시 작성)
    - 가계부 작성을 위한 테이블을 생성한다.
        테이블 명 : ACCOUNTS
        컬럼명    데이터타입    제약조건        비고
        ID        NUMBER        PRIMARY KEY     ACCOUNTS 테이블의 행 데이터를 식별하기 위한 값이 저장되는 컬럼이다.
        AMOUNT    NUMBER        NOT NULL        입/출 금액을 저장하기 위한 컬럼이다.
        INOUT     CHAR(1)       CHECK           입금(I), 출금(O) 을 구분하기 위한 컬럼으로 저장 값은 I, O 로 제한한다.
        ACC_DATE  DATE          NOT NULL        입/출 금액이 발생한 일자를 저장 하기 위한 컬럼이다.
        ACC_TYPE  CHAR(3)       FOREIGN KEY     입/출 금액의 용도를 별도로 구분하기 위한 컬럼으로 참조 테이블(ACCTYPES)
                                                의 ID 컬럼의 값을 참조한다.
*/
CREATE TABLE ACCOUNTS (
      ID        NUMBER
    , AMOUNT    NUMBER
    , INOUT     CHAR(1)
    , ACC_DATE  DATE
    , ACC_TYPE  CHAR(3)
);
COMMENT ON COLUMN ACCOUNTS.ID IS 'ACCOUNTS 테이블의 행 데이터를 식별하기 위한 값이 저장되는 컬럼이다.';
COMMENT ON COLUMN ACCOUNTS.AMOUNT IS '입/출 금액을 저장하기 위한 컬럼이다.';
COMMENT ON COLUMN ACCOUNTS.INOUT IS '입금(I), 출금(O) 을 구분하기 위한 컬럼으로 저장 값은 I, O 로 제한한다.';
COMMENT ON COLUMN ACCOUNTS.ACC_DATE IS '입/출 금액이 발생한 일자를 저장 하기 위한 컬럼이다.';
COMMENT ON COLUMN ACCOUNTS.ACC_TYPE IS '입/출 금액의 용도를 별도로 구분하기 위한 컬럼으로 참조 테이블(ACCTYPES)
    의 ID 컬럼의 값을 참조한다.';
ALTER TABLE ACCOUNTS ADD CONSTRAINT ACCOUNTS_ID_PK PRIMARY KEY(ID);
ALTER TABLE ACCOUNTS MODIFY AMOUNT CONSTRAINT ACCOUNTS_AMOUNT_NN NOT NULL;
ALTER TABLE ACCOUNTS ADD CONSTRAINT ACCOUNTS_INOUT_CK CHECK(INOUT IN ('I', 'O'));
ALTER TABLE ACCOUNTS MODIFY ACC_DATE CONSTRAINT ACCOUNTS_ACC_DATE_NN NOT NULL;
ALTER TABLE ACCOUNTS ADD CONSTRAINT ACCOUNTS_ACC_TYPE_FK FOREIGN KEY(ACC_TYPE) REFERENCES ACCTYPES(ID);

-- 기본값 설정
ALTER TABLE ACCOUNTS MODIFY INOUT DEFAULT('O');
ALTER TABLE ACCOUNTS MODIFY ACC_DATE DEFAULT(SYSDATE);


/*
    - ACCTYPES 테이블을 생성한다.
        테이블 명 : ACCTYPES
        컬럼명    데이터타입    제약조건        비고
        ID        CHAR(3)       PRIMARY KEY     ACCTYPES 테이블의 행 데이터를 식별하기 위한 값이 저장되는 컬럼이다.
        TYPE_NAME VARCHAR2(150) NOT NULL        입/출 금액의 용도가 저장되는 컬럼이다.
*/
CREATE TABLE ACCTYPES (
      ID        CHAR(3)
    , TYPE_NAME VARCHAR2(150)
);
COMMENT ON COLUMN ACCTYPES.ID IS 'ACCTYPES 테이블의 행 데이터를 식별하기 위한 값이 저장되는 컬럼이다.';
COMMENT ON COLUMN ACCTYPES.TYPE_NAME IS '입/출 금액의 용도가 저장되는 컬럼이다.';

ALTER TABLE ACCTYPES ADD CONSTRAINT ACCTYPES_ID_PK PRIMARY KEY(ID);
ALTER TABLE ACCTYPES MODIFY TYPE_NAME CONSTRAINT ACCTYPES_TYPE_NAME_NN NOT NULL;

INSERT INTO ACCTYPES VALUES('I01', '급여');
INSERT INTO ACCTYPES VALUES('O01', '통신비');
INSERT INTO ACCTYPES VALUES('O02', '교통비');
INSERT INTO ACCTYPES VALUES('O03', '주유비');
INSERT INTO ACCTYPES VALUES('O04', '식비');
INSERT INTO ACCTYPES VALUES('O05', '여가비');
INSERT INTO ACCTYPES VALUES('I02', '복권당첨');
INSERT INTO ACCTYPES VALUES('O06', '가전제품');


CREATE OR REPLACE VIEW V_ACC
AS
    SELECT ID AS 번호
         , AMOUNT AS 지출액
         , ACC_TYPE AS 지출타입
      FROM ACCOUNTS
     WHERE INOUT = 'O';

INSERT INTO V_ACC VALUES(1, 250000, 'O05');
INSERT INTO V_ACC VALUES(2, 85000, 'O02');
INSERT INTO V_ACC VALUES(3, 55000, 'O01');
INSERT INTO V_ACC VALUES(4, 6500, 'O04');
INSERT INTO V_ACC VALUES(5, 6500, 'O04');

UPDATE V_ACC
   SET 지출액 = 7000
 WHERE 지출타입 = 'O04';

DELETE FROM V_ACC WHERE 지출타입 = 'O04';

SELECT * FROM V_ACC;



CREATE OR REPLACE VIEW V_ACC2
AS
    SELECT A.ID AS 번호
         , A.AMOUNT AS 지출액
         , B.TYPE_NAME AS 지출타입
      FROM ACCOUNTS A JOIN ACCTYPES B
        ON A.ACC_TYPE = B.ID
     WHERE A.INOUT = 'O';

-- INSERT INTO V_ACC2 VALUES(4, 6500, '식비');
-- INSERT INTO V_ACC2 VALUES(5, 6500, '식비');

UPDATE V_ACC2
   SET 지출액 = 90000
 WHERE 지출타입 = '통신비';

-- UPDATE V_ACC2
--    SET 지출타입 = '가전제품'
--  WHERE 지출타입 = '여가비';

DELETE FROM V_ACC2 WHERE 지출타입 = '여가비';

SELECT * FROM V_ACC2;
SELECT * FROM ACCOUNTS;
SELECT * FROM ACCTYPES;



CREATE OR REPLACE FORCE VIEW V_EMP_INFO
AS
    SELECT A.FIRST_NAME AS 이름
         , A.LAST_NAME AS 성
         , A.PHONE_NUMBER AS 전화번호
         , A.SALARY AS 급여액
         , B.DEPARTMENT_NAME AS 부서명
      FROM EMPLOYEES A JOIN DEPARTMENTS B
        ON A.DEPARTMENT_ID = B.DEPARTMENT_ID
     WHERE A.SALARY BETWEEN 2000 AND 8000
WITH CHECK OPTION; -- INSERT/UPDATE 작업시 WHERE 절의 조건을 체크하게 된다.
-- WITH READ ONLY;  -- 읽기 전용 뷰로 생성하는 옵션

SELECT * FROM V_EMP_INFO WHERE 부서명 = 'Marketing';

-- 생성된 뷰의 정보를 확인할 때 사용
SELECT * FROM USER_VIEWS WHERE VIEW_NAME = 'V_EMP_INFO';