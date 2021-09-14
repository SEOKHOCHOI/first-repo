-- 제약조건
DROP TABLE 지출내역서T;
DROP TABLE 지출내역종류T;

-- 컬럼 레벨로 제약조건 생성
CREATE TABLE 지출내역종류T (
      ID      NUMBER      UNIQUE    -- 유니크 제약조건 생성
    , 종류    VARCHAR(50)
);
CREATE TABLE 지출내역서T (
      ID        NUMBER      PRIMARY KEY                     -- 기본키 제약조건 생성
    , 날짜      DATE        NOT NULL                        -- NOT NULL 제약조건 생성
    , 입출금    CHAR(3)     CHECK(입출금 IN ('IN', 'OUT'))  -- CHECK 제약조건 생성
    , 금액      NUMBER      NOT NULL
    , 종류      NUMBER      REFERENCES 지출내역종류T (ID)   -- 외래키 제약조건 생성
    , 비고      VARCHAR(300)
);

DROP TABLE 지출내역서T;
DROP TABLE 지출내역종류T;
-- 테이블 레벨로 제약조건 생성
CREATE TABLE 지출내역종류T (
      ID      NUMBER
    , 종류    VARCHAR(50)
    , UNIQUE (ID)
);
CREATE TABLE 지출내역서T (
      ID        NUMBER
    , 날짜      DATE        NOT NULL        -- 컬럼 레벨만 지원
    , 입출금    CHAR(3)     CHECK(입출금 IN ('IN', 'OUT'))  -- 컬럼 레벨만 지원
    , 금액      NUMBER      NOT NULL
    , 종류      NUMBER
    , 비고      VARCHAR(300)
    , PRIMARY KEY (ID)
    , FOREIGN KEY(종류) REFERENCES 지출내역종류T(ID)
);

DROP TABLE 지출내역서T;
DROP TABLE 지출내역종류T;
-- 제약 조건 없이 테이블 생성 후 ALTER 로 제약 조건 추가.
CREATE TABLE 지출내역종류T (
      ID      NUMBER
    , 종류    VARCHAR(50)
);
ALTER TABLE 지출내역종류T ADD CONSTRAINT 지출내역종류T_ID_UK UNIQUE(ID);

INSERT INTO 지출내역종류T VALUES(NULL, '급여');
INSERT INTO 지출내역종류T VALUES(NULL, '상여금');
INSERT INTO 지출내역종류T VALUES(1, '도서구입');
INSERT INTO 지출내역종류T VALUES(2, '식료품구입');
INSERT INTO 지출내역종류T VALUES(2, '통신비');
SELECT * FROM 지출내역종류T;

CREATE TABLE 지출내역서T (
      ID        NUMBER
    , 날짜      DATE
    , 입출금    CHAR(3)     DEFAULT('IN')
    , 금액      NUMBER      DEFAULT(0)  -- 기본값
    , 종류      NUMBER
    , 비고      VARCHAR(300)
);
--                                  별도의 제약조건이름을 명시
ALTER TABLE 지출내역서T ADD CONSTRAINT 지출내역서T_ID_PK PRIMARY KEY(ID);
ALTER TABLE 지출내역서T MODIFY 날짜 CONSTRAINT 지출내역서T_날짜_NN NOT NULL;
ALTER TABLE 지출내역서T ADD CONSTRAINT 지출내역서T_입출금_CK CHECK(입출금 IN ('IN', 'OUT'));
ALTER TABLE 지출내역서T MODIFY 금액 CONSTRAINT 지출내역서T_금액_NN NOT NULL;
ALTER TABLE 지출내역서T ADD CONSTRAINT 지출내역서T_종류_FK FOREIGN KEY(종류)
 REFERENCES 지출내역종류T(ID);

-- 기본값 설정
ALTER TABLE 지출내역서T MODIFY 날짜 DATE DEFAULT(SYSDATE);
ALTER TABLE 지출내역서T MODIFY 금액 NUMBER DEFAULT(0);
ALTER TABLE 지출내역서T MODIFY 입출금 CHAR(3) DEFAULT('IN');

INSERT INTO 지출내역서T VALUES(NULL, SYSDATE, 'IN', 1000, 1, '');
INSERT INTO 지출내역서T VALUES(1, SYSDATE, 'IN', 1000, 1, '');
INSERT INTO 지출내역서T VALUES(1, SYSDATE, 'OUT', 100, 2, '');

INSERT INTO 지출내역서T VALUES(2, SYSDATE, 'in', 1000, 2, '');
INSERT INTO 지출내역서T VALUES(2, SYSDATE, 'IN', 1000, 2, '');

INSERT INTO 지출내역서T VALUES(3, SYSDATE, 'OUT', NULL, 2, '');
INSERT INTO 지출내역서T(ID, 날짜, 입출금, 종류, 비고) VALUES(3, SYSDATE, 'OUT', 2, '');
INSERT INTO 지출내역서T(ID, 날짜, 종류, 비고) VALUES(4, SYSDATE, 2, '');
INSERT INTO 지출내역서T(ID, 종류, 비고) VALUES(6, 2, '');

INSERT INTO 지출내역서T VALUES(4, SYSDATE, 'OUT', 0, 3, '');
INSERT INTO 지출내역서T VALUES(4, SYSDATE, 'OUT', 0, 2, '');
INSERT INTO 지출내역서T VALUES(5, SYSDATE, 'OUT', 0, NULL, '');

SELECT * FROM 지출내역서T;

-- 기존 제약 조건 삭제
ALTER TABLE 지출내역서T DROP CONSTRAINT 지출내역서T_종류_FK;
-- 외래키 제약조건에 옵션(ON DELETE SET NULL) 부여
-- 부모 테이블의 데이터가 삭제되면 자식 테이블의 값을 NULL 로 설정
ALTER TABLE 지출내역서T ADD CONSTRAINT 지출내역서T_종류_FK FOREIGN KEY(종류)
 REFERENCES 지출내역종류T(ID) ON DELETE SET NULL;

-- 외래키 제약조건에 옵션(ON DELETE CASCADE) 부여
-- 부모 테이블의 데이터가 삭제되면 자식 테이블의 데이터도 삭제
ALTER TABLE 지출내역서T ADD CONSTRAINT 지출내역서T_종류_FK FOREIGN KEY(종류)
 REFERENCES 지출내역종류T(ID) ON DELETE CASCADE;


UPDATE 지출내역서T
   SET 종류 = 1
 WHERE ID IN (2, 3);

DELETE FROM 지출내역종류T
 WHERE ID = 1;

ALTER TABLE 지출내역서T DISABLE CONSTRAINT 지출내역서T_종류_FK;
ALTER TABLE 지출내역서T ENABLE NOVALIDATE CONSTRAINT 지출내역서T_종류_FK;
ALTER TABLE 지출내역서T ENABLE VALIDATE CONSTRAINT 지출내역서T_종류_FK;


-- 제약조건을 해제하기 위해서 자식의 제약조건을 같이 해제할 필요가 있는 경우 CASCADE 사용
-- 외래키 설정 시 참조하는 부모 테이블의 컬럼은 유니크 또는 기본키여야 한다.
ALTER TABLE 지출내역종류T DISABLE CONSTRAINT 지출내역종류T_ID_UK CASCADE;
ALTER TABLE 지출내역종류T ENABLE CONSTRAINT 지출내역종류T_ID_UK;

SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = '지출내역서T';
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = '지출내역종류T';


SELECT * FROM 지출내역종류T;
SELECT * FROM 지출내역서T;




SELECT * FROM 지출내역서T;