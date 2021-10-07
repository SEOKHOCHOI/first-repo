/*
    1. 재고관리를 위한 테이블 생성
        테이블 명 : PRODUCTS
        컬럼명  데이터타입      제약조건        비고
           PID  VARCHAR2(6)     Primary Key     문자와 숫자의 조합으로 만들어진 코드를 사용한다.
         PNAME  VARCHAR2(30)    NOT NULL        제품 이름
        AMOUNT  NUMBER          NOT NULL        제품의 단가
           CNT  NUMBER          NOT NULL        제품의 수량
*/
CREATE TABLE PRODUCTS (
       PID              VARCHAR2(6)
     , PNAME            VARCHAR2(30)
     , AMOUNT           NUMBER
     , CNT              NUMBER
);

COMMENT ON COLUMN PRODUCTS.PID IS '문자와 숫자의 조합으로 만들어진 코드를 사용한다.';
COMMENT ON COLUMN PRODUCTS.PNAME IS '제품 이름';
COMMENT ON COLUMN PRODUCTS.AMOUNT IS '제품의 단가';
COMMENT ON COLUMN PRODUCTS.CNT IS '제품의 수량';

ALTER TABLE PRODUCTS ADD CONSTRAINT PRODUCTS_PID_PK PRIMARY KEY(PID);
ALTER TABLE PRODUCTS MODIFY PNAME CONSTRAINT PRODUCTS_PNAME_NN NOT NULL;
ALTER TABLE PRODUCTS MODIFY AMOUNT CONSTRAINT PRODUCTS_AMOUNT_NN NOT NULL;
ALTER TABLE PRODUCTS MODIFY CNT CONSTRAINT PRODUCTS_CNT_NN NOT NULL;

/*
        테이블 명 : PROD_INOUT
        컬럼명  데이터타입      제약조건        비고
            ID  NUMBER          Primary Key     제품 입고 출고내역을 식별하기 위한 번호, 자동증가
                                                기능을 활용한다.
        IN_OUT  CHAR(1)         CHECK           I:입고, O:출고 임을 구분하는 컬럼
           PID  VARCHAR2(6)     Foreign Key     PRODUCTS 테이블을 참조하는 외래키로 입출고된 제품을
                                                구분한다.
        AMOUNT  NUMBER          NOT NULL        입출고 시점의 제품 단가
           CNT  NUMBER          NOT NULL        입출고된 제품의 수량, DEFAULT(1)
         PRICE  NUMBER          NOT NULL        입출고 시점의 제품 전체 금액(단가 x 수량)
                                                입고 제품에는 10% 할인된 금액으로 기록되어야 한다.
                                                출고 제품에는 10% 부가세가 포함된 금액으로 기록되어야
                                                한다. 소수점은 절삭한다.
    INOUT_DATE  DATE                            입출고 날짜, DEFAULT(SYSDATE)
*/
CREATE TABLE PROD_INOUT (
       ID               NUMBER
     , IN_OUT           CHAR(1)
     , PID              VARCHAR2(6)
     , AMOUNT           NUMBER
     , CNT              NUMBER          DEFAULT(1)
     , PRICE            NUMBER
     , INOUT_DATE       DATE            DEFAULT(SYSDATE)
);

COMMENT ON COLUMN PROD_INOUT.ID IS '제품 입고 출고내역을 식별하기 위한 번호, 자동증가 기능을 활용한다.';
COMMENT ON COLUMN PROD_INOUT.IN_OUT IS 'I:입고, O:출고 임을 구분하는 컬럼';
COMMENT ON COLUMN PROD_INOUT.PID IS 'PRODUCTS 테이블을 참조하는 외래키로 입출고된 제품을 구분한다.';
COMMENT ON COLUMN PROD_INOUT.AMOUNT IS '입출고 시점의 제품 단가';
COMMENT ON COLUMN PROD_INOUT.CNT IS '입출고된 제품의 수량, DEFAULT(1)';
COMMENT ON COLUMN PROD_INOUT.PRICE IS '입출고 시점의 제품 전체 금액(단가 x 수량)
                                       입고 제품에는 10% 할인된 금액으로 기록되어야 한다.
                                       출고 제품에는 10% 부가세가 포함된 금액으로 기록되어야 한다.
                                       소수점은 절삭한다.';
COMMENT ON COLUMN PROD_INOUT.INOUT_DATE IS '입출고 날짜, DEFAULT(SYSDATE)';

ALTER TABLE PROD_INOUT ADD CONSTRAINT PROD_INOUT_ID_PK PRIMARY KEY(ID);
ALTER TABLE PROD_INOUT ADD CONSTRAINT PROD_INOUT_IN_OUT_CK CHECK(IN_OUT IN ('I', 'O'));
ALTER TABLE PROD_INOUT ADD CONSTRAINT PROD_INOUT_PID_FK FOREIGN KEY(PID) REFERENCES PRODUCTS(PID);
ALTER TABLE PROD_INOUT MODIFY AMOUNT CONSTRAINT PROD_INOUT_AMOUNT_NN NOT NULL;
ALTER TABLE PROD_INOUT MODIFY CNT CONSTRAINT PROD_INOUT_CNT_NN NOT NULL;
ALTER TABLE PROD_INOUT MODIFY PRICE CONSTRAINT PROD_INOUT_PRICE_NN NOT NULL;

CREATE SEQUENCE PROD_INOUT_SEQ;

/*
    2. 1번에서 만든 테이블의 기본 데이터를 추가한다.
        - PRODUCTS 테이블에는 다음의 데이터를 추가한다.
            PID:A00001  PNAME:투명박스       AMOUNT:15,000   CNT:10
            PID:A00002  PNAME:텀블러         AMOUNT:10,000   CNT:15
            PID:A00003  PNAME:마스크(10개입) AMOUNT:5,000    CNT:20
            PID:A00004  PNAME:투명테이프     AMOUNT:1,000    CNT:30
            PID:A00005  PNAME:종이컵(355ml)  AMOUNT:2,000    CNT:40
*/
INSERT INTO PRODUCTS VALUES('A00001', '투명박스', 15000, 10);
INSERT INTO PRODUCTS VALUES('A00002', '텀블러', 10000, 15);
INSERT INTO PRODUCTS VALUES('A00003', '마스크(10개입)', 5000, 20);
INSERT INTO PRODUCTS VALUES('A00004', '투명테이프', 1000, 30);
INSERT INTO PRODUCTS VALUES('A00005', '종이컵(355ml)', 2000, 40);

/*
        - PROD_INOUT과 PRODUCTS 테이블에는 다음 설명에 맞게 데이터가 추가 및 변경될 수 있게 한다.
            투명박스 2개를 2021년 01월 02일에 출고하였다.
            텀블러 1개를 2021년 01월 03일에 출고하였다.
            마스크 10개를 2021년 01월 05일에 출고하였다.
            종이컵 5개를 2021년 01월 12일에 출고하였다.
            마스크 20개를 2021년 01월 15일에 입고하였다.
            투명테이프 2개를 2021년 01월 17일에 출고하였다.
            종이컵 10개를 2021년 01월 21일에 출고하였다.
            투명박스 7개를 2021년 01월 25일에 입고하였다.
*/
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00001', 15000, 2
     , 0, TO_DATE('20210102', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00002', 10000, 1
     , 0, TO_DATE('20210103', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00003', 5000, 10
     , 0, TO_DATE('20210104', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00005', 2000, 5
     , 0, TO_DATE('20210112', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I', 'A00003', 5000, 20
     , 0, TO_DATE('20210115', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00004', 1000, 2
     , 0, TO_DATE('20210117', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00005', 2000, 10
     , 0, TO_DATE('20210121', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I', 'A00001', 15000, 7
     , 0, TO_DATE('20210125', 'yyyymmdd'));

UPDATE PROD_INOUT
   SET PRICE = AMOUNT * CNT * 1.1
 WHERE IN_OUT = 'O';

UPDATE PROD_INOUT
   SET PRICE = AMOUNT * CNT * 0.9
 WHERE IN_OUT = 'I';

SELECT * FROM PROD_INOUT;

/*
    3. 1월 1달간 출고 내역을 조회하시오.
        제품코드    제품명      단가        수량        금액
        A00001      투명박스    15,000      2           33,000
        A00002      텀블러      10,000      1           11,000
        A00003      마스크      5,000       10          55,000
        ....
*/
SELECT A.PID AS 제품코드
     , B.PNAME AS 제품명
     , TO_CHAR(MAX(B.AMOUNT), '999,999,999') AS 단가
     , TO_CHAR(SUM(A.CNT), '999,999,999') AS 수량
     , TO_CHAR(SUM(A.PRICE), '999,999,999') AS 금액
  FROM PROD_INOUT A JOIN PRODUCTS B
    ON A.PID = B.PID
 WHERE A.IN_OUT = 'O'
   AND INOUT_DATE BETWEEN TO_DATE('20210101', 'yyyymmdd')
                      AND TO_DATE('20210131', 'yyyymmdd')
 GROUP BY A.PID, B.PNAME;

/*
    4. 1월 1달간의 입/출고 내역을 다음과 같이 나오도록 조회하시오.
        제품코드    제품명      입고량      출고량
        A00001      투명박스    7           2
        A00002      텀블러      0           1
        A00003      마스크      20          10
        ...
        총합                    xx          xx
*/
SELECT A.PID AS 제품코드
     , B.PNAME AS 제품명
     , SUM(DECODE(A.IN_OUT, 'I', A.CNT, 0)) AS 입고량
     , SUM(DECODE(A.IN_OUT, 'O', A.CNT, 0)) AS 출고량
  FROM PROD_INOUT A JOIN PRODUCTS B
    ON A.PID = B.PID
 WHERE INOUT_DATE BETWEEN TO_DATE('20210101', 'yyyymmdd')
                      AND TO_DATE('20210131', 'yyyymmdd')
 GROUP BY A.PID, B.PNAME
UNION
SELECT '총합' AS 제품코드
     , NULL AS 제품명
     , SUM(DECODE(A.IN_OUT, 'I', A.CNT, 0)) AS 입고량
     , SUM(DECODE(A.IN_OUT, 'O', A.CNT, 0)) AS 출고량
  FROM PROD_INOUT A JOIN PRODUCTS B
    ON A.PID = B.PID
 WHERE INOUT_DATE BETWEEN TO_DATE('20210101', 'yyyymmdd')
                      AND TO_DATE('20210131', 'yyyymmdd');

SELECT DECODE(A.PID, NULL, '총합', A.PID) AS 제품코드
     , B.PNAME AS 제품명
     , SUM(DECODE(A.IN_OUT, 'I', A.CNT, 0)) AS 입고량
     , SUM(DECODE(A.IN_OUT, 'O', A.CNT, 0)) AS 출고량
  FROM PROD_INOUT A JOIN PRODUCTS B
    ON A.PID = B.PID
 WHERE INOUT_DATE BETWEEN TO_DATE('20210101', 'yyyymmdd')
                      AND TO_DATE('20210131', 'yyyymmdd')
 GROUP BY ROLLUP((A.PID, B.PNAME));

/*
    5. 3번, 4번 조회 쿼리 활용한 VIEW를 생성하여 년/월 조회 조건만으로도
       동일한 결과가 조회될 수 있도록 하시오.
*/
CREATE OR REPLACE VIEW V_출고내역
AS
    SELECT EXTRACT(YEAR FROM A.INOUT_DATE) AS 년도
         , EXTRACT(MONTH FROM A.INOUT_DATE) AS 월
         , A.PID AS 제품코드
         , B.PNAME AS 제품명
         , TO_CHAR(MAX(B.AMOUNT), '999,999,999') AS 단가
         , TO_CHAR(SUM(A.CNT), '999,999,999') AS 수량
         , TO_CHAR(SUM(A.PRICE), '999,999,999') AS 금액
      FROM PROD_INOUT A JOIN PRODUCTS B
        ON A.PID = B.PID
     WHERE A.IN_OUT = 'O'
     GROUP BY EXTRACT(YEAR FROM A.INOUT_DATE), EXTRACT(MONTH FROM A.INOUT_DATE), A.PID, B.PNAME
WITH READ ONLY;

SELECT 제품코드, 제품명, 단가, 수량, 금액
  FROM V_출고내역
 WHERE 년도 = 2021 AND 월 = 1;



CREATE OR REPLACE VIEW V_입출고내역
AS
    SELECT EXTRACT(YEAR FROM A.INOUT_DATE) AS 년도
         , EXTRACT(MONTH FROM A.INOUT_DATE) AS 월
         , DECODE(A.PID, NULL, '총합', A.PID) AS 제품코드
         , B.PNAME AS 제품명
         , SUM(DECODE(A.IN_OUT, 'I', A.CNT, 0)) AS 입고량
         , SUM(DECODE(A.IN_OUT, 'O', A.CNT, 0)) AS 출고량
      FROM PROD_INOUT A JOIN PRODUCTS B
        ON A.PID = B.PID
     GROUP BY ROLLUP(
                       (EXTRACT(YEAR FROM A.INOUT_DATE), EXTRACT(MONTH FROM A.INOUT_DATE))
                     , (A.PID, B.PNAME)
                    )
WITH READ ONLY;

SELECT 제품코드, 제품명, 입고량, 출고량
  FROM V_입출고내역
 WHERE 년도 = 2021 AND 월 = 2;

-- 테스트를 위한 추가 데이터 입력
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00002', 10000, 3
     , 10000 * 3 * 1.1, TO_DATE('20210205', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00002', 10000, 2
     , 10000 * 2 * 1.1, TO_DATE('20210209', 'yyyymmdd'));
INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', 'A00003', 5000, 5
     , 5000 * 5 * 1.1, TO_DATE('20210212', 'yyyymmdd'));


/*
    6. 제품이 출고 또는 입고가 될 때 PRODUCTS에 기록된 수량도 같이 반영될 수 있도록 프로시저를
       만들어 동작시키시오. 단, 출고작업 진행시 출고에 필요한 상품의 수량이 부족한 경우에는
       출고작업이 이루어지지 않도록 해야 한다.
*/
CREATE OR REPLACE PROCEDURE PROC_제품입고(i_name IN VARCHAR, i_cnt IN NUMBER, i_date IN DATE)
IS
    p_id PRODUCTS.PID%TYPE;
    amount PRODUCTS.AMOUNT%TYPE;
BEGIN
    SELECT PID, AMOUNT INTO p_id, amount FROM PRODUCTS WHERE PNAME = i_name;
    INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'I', p_id
                                , amount, i_cnt, amount * i_cnt * 0.9, i_date);
    UPDATE PRODUCTS
       SET CNT = CNT + i_cnt
     WHERE PID = p_id;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE PROC_제품출고(i_name IN VARCHAR, i_cnt IN NUMBER, i_date IN DATE)
IS
    p_id PRODUCTS.PID%TYPE;
    amount PRODUCTS.AMOUNT%TYPE;
    cnt PRODUCTS.CNT%TYPE;
    not_enough_count EXCEPTION;
BEGIN
    SELECT PID, AMOUNT INTO p_id, amount FROM PRODUCTS WHERE PNAME = i_name;
    INSERT INTO PROD_INOUT VALUES(PROD_INOUT_SEQ.NEXTVAL, 'O', p_id
                                , amount, i_cnt, amount * i_cnt * 1.1, i_date);
    UPDATE PRODUCTS
       SET CNT = CNT - i_cnt
     WHERE PID = p_id;

    SELECT CNT INTO cnt FROM PRODUCTS WHERE PNAME = i_name;

    IF cnt < 0 THEN
        RAISE not_enough_count;
    ELSE
        COMMIT;
    END IF;
EXCEPTION
    WHEN not_enough_count THEN
        DBMS_OUTPUT.PUT_LINE('제품 출고를 위한 수량이 부족합니다.');
        ROLLBACK;
END;
/

EXEC PROC_제품입고('텀블러', 5, TO_DATE('20210219', 'yyyymmdd'));
EXEC PROC_제품출고('텀블러', 11, TO_DATE('20210220', 'yyyymmdd'));
SELECT * FROM PROD_INOUT;
SELECT * FROM PRODUCTS;