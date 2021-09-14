CREATE TABLE SAMPLE_TABLE (
      COL1 NUMBER
    , COL2 VARCHAR2(10)
    , COL3 CHAR(10)
    , COL4 DATE
);
COMMENT ON COLUMN SAMPLE_TABLE.COL1 IS '숫자 타입의 컬럼';
COMMENT ON COLUMN SAMPLE_TABLE.COL2 IS '가변 문자열 컬럼';
COMMENT ON COLUMN SAMPLE_TABLE.COL3 IS '고정 문자열 컬럼';
COMMENT ON COLUMN SAMPLE_TABLE.COL4 IS '날짜 타입의 컬럼';

-- 접속한 계정의 테이블 목록 확인
SELECT * FROM USER_ALL_TABLES;

-- 테이블의 컬럼 정보 확인
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'SAMPLE_TABLE';

-- 테이블 컬럼의 주석 확인
SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = 'SAMPLE_TABLE';

-- 테이블의 간략한 정보 확인 -> 컬럼명, 타입, 크기, NULL 유무
DESC SAMPLE_TABLE;

-- 새로운 컬럼 추가
ALTER TABLE SAMPLE_TABLE ADD COL5 NUMBER(5, 2); -- 최대 5자리(정수 3자리, 소수점 2자리)

-- 기존 컬럼의 타입 및 크기 수정
ALTER TABLE SAMPLE_TABLE MODIFY COL3 VARCHAR2(10);

-- 기존 컬럼의 이름 변경
ALTER TABLE SAMPLE_TABLE RENAME COLUMN COL1 TO ID;

-- 컬럼 삭제
ALTER TABLE SAMPLE_TABLE DROP COLUMN COL3;

-- 테이블 이름 변경
ALTER TABLE SAMPLE_TABLE RENAME TO SAM_T;
DESC SAM_T;

-- 테이블 삭제
DROP TABLE SAM_T;


/*
    지출내역서(가계부)를 위한 테이블을 만들어 본다.
        - "날짜", "입금액", "출금액", "비고"를 저장할 수 있는 컬럼이 필요.
        - 비고의 경우 최대 300자 까지 저장 가능해야 한다.
        - 컬럼의 이름은 한글로 사용하여 만든다.
        - 테이블 이름은 "지출내역서T" 로 만든다.
        - 컬럼에 대한 주석은 반드시 작성하도록 한다.
*/
CREATE TABLE 지출내역서T (
      날짜      DATE
    , 입금액    NUMBER
    , 출금액    NUMBER
    , 비고      VARCHAR(300)
);
COMMENT ON COLUMN 지출내역서T.날짜 IS '입금 또는 출금 날짜 입니다.';
COMMENT ON COLUMN 지출내역서T.입금액 IS '입금액 입니다.';
COMMENT ON COLUMN 지출내역서T.출금액 IS '출금액 입니다.';
COMMENT ON COLUMN 지출내역서T.비고 IS '상세내용을 적어주세요.';

SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME = '지출내역서T';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = '지출내역서T';
SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = '지출내역서T';
DESC 지출내역서T;