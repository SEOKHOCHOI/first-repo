/*
    1. EMPLOYEES 테이블에서 커미션이 있는 부서와 직무가 어떻게 되는지 조회 하시오.
*/
SELECT DISTINCT DEPARTMENT_ID
     , JOB_ID
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
   AND COMMISSION_PCT IS NOT NULL;

/*
    2. 1번에서 확인한 부서와 직무의 인원 수를 조회하시오.
*/
SELECT DEPARTMENT_ID
     , JOB_ID
     , COUNT(*) AS 인원수
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
   AND COMMISSION_PCT IS NOT NULL
 GROUP BY DEPARTMENT_ID, JOB_ID;

/*
    3. EMPLOYEES 테이블을 조회할 때 부서코드에 대응하는 값과 동일하게 출력하시오.
        10 -> 관리부        20 -> 마케팅부      30 -> 구매부       40 -> 인사부
        50 -> 무역부        60 -> 전산부        70 -> 홍보부       80 -> 판매부
        90 -> 총무부        100 -> 재무부       110 -> 회계부
*/
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , DECODE(DEPARTMENT_ID, 10, '관리부', 20, '마케팅부', 30, '구매부'
                           , 40, '인사부', 50, '무역부', 60, '전산부'
                           , 70, '홍보부', 80, '판매부', 90, '총무부'
                           , 100, '재무부', 110, '회계부') AS 부서
     , CASE WHEN DEPARTMENT_ID = 10 THEN '관리부'
            WHEN DEPARTMENT_ID = 20 THEN '마케팅부'
            WHEN DEPARTMENT_ID = 30 THEN '구매부'
            WHEN DEPARTMENT_ID = 40 THEN '인사부'
            WHEN DEPARTMENT_ID = 50 THEN '무역부'
            WHEN DEPARTMENT_ID = 60 THEN '전산부'
            WHEN DEPARTMENT_ID = 70 THEN '홍보부'
            WHEN DEPARTMENT_ID = 80 THEN '판매부'
            WHEN DEPARTMENT_ID = 90 THEN '총무부'
            WHEN DEPARTMENT_ID = 100 THEN '재무부'
            WHEN DEPARTMENT_ID = 110 THEN '회계부'
        END AS 부서2
  FROM EMPLOYEES;

/*
    4. 커미션이 있는 직원과 없는 직원별 최고급여액, 최저급여액이 얼마인지 조회하시오.
*/
SELECT NVL2(COMMISSION_PCT, '커미션이 있는 직원', '커미션이 없는 직원 없음') AS 커미션유무
     , MAX(DECODE(COMMISSION_PCT, NULL, SALARY, SALARY * (1 + COMMISSION_PCT))) AS 최고급여액
     , MIN(DECODE(COMMISSION_PCT, NULL, SALARY, SALARY * (1 + COMMISSION_PCT))) AS 최저급여액
  FROM EMPLOYEES
 GROUP BY NVL2(COMMISSION_PCT, '커미션이 있는 직원', '커미션이 없는 직원 없음');

/*
    5. 다음의 요구사항에 적합한 데이터를 저장하기 위한 테이블을 생성하시오.
        - 부서별 법인 카드 사용 내역을 관리하기 위한 테이블이 필요하다.
        - 카드 내역에는 사용금액, 사용처, 결제일 정보가 저장되어야 한다.
        - 데이터가 누적된 후에는 부서별 사용금액이 얼마인지 월별 집계를 진행할 것이다.
        - 사용처의 경우 회식, 접대, 식대, 행사, 출장, 주유, 복리후생으로 제한한다.
*/
CREATE TABLE PAYMENTS (
      PAYMENT_ID      NUMBER
    , DEPARTMENT_ID   NUMBER
    , AMOUNT          NUMBER
    , PAY_TYPE        VARCHAR2(12)
    , PAY_DATE        DATE            DEFAULT(SYSDATE)
);
ALTER TABLE PAYMENTS ADD CONSTRAINT PAYMENTS_PAYMENT_ID_PK PRIMARY KEY(PAYMENT_ID);
ALTER TABLE PAYMENTS ADD CONSTRAINT PAYMENTS_DEPARTMENT_ID_FK FOREIGN KEY(DEPARTMENT_ID)
      REFERENCES DEPARTMENTS(DEPARTMENT_ID);
-- ALTER TABLE PAYMENTS MODIFY DEPARTMENT_ID CONSTRAINT PAYMENTS_DEPARTMENT_ID_NN NOT NULL;
ALTER TABLE PAYMENTS MODIFY AMOUNT CONSTRAINT PAYMENTS_AMOUNT_NN NOT NULL;
ALTER TABLE PAYMENTS ADD CONSTRAINT PAYMENTS_PAY_TYPE_CK
      CHECK(PAY_TYPE IN ('회식', '접대', '식대', '행사', '출장', '주유', '복리후생'));
ALTER TABLE PAYMENTS MODIFY PAY_DATE CONSTRAINT PAYMENTS_PAY_DATE_NN NOT NULL;

COMMENT ON COLUMN PAYMENTS.PAYMENT_ID IS '식별번호로 사용하는 컬럼';
COMMENT ON COLUMN PAYMENTS.DEPARTMENT_ID IS '부서번호';
COMMENT ON COLUMN PAYMENTS.AMOUNT IS '결제금액';
COMMENT ON COLUMN PAYMENTS.PAY_TYPE IS '결제종류로 회식, 접대, 식대, 행사, 출장, 주유, 복리후생이 있다.';
COMMENT ON COLUMN PAYMENTS.PAY_DATE IS '결제일자';

/*
    6. 5번 문제에서 생성한 테이블에 데이터를 저장하기 위한 INSERT 구문을 작성하여 저장하시오.
        - 2021년 1월 10일에 홍보부에서 기업 홍보를 위한 행사를 진행하였으며 이때 법인 카드로
          1,500,000 원을 사용하였다.
        - 2021년 2월 12일에 전산부 직원들의 멤버쉽 강화를 위한 회식을 하였으며 이때 300,000 원을
          사용하였다.
        - 2021년 2월 15일에 홍보부에서도 회식을 하였으며, 500,000 원을 사용하였다.
        - 2021년 3월 5일에 무역부에서 부산 출장 비용으로 100,000 원을 주유비로 80,000원을 사용하였다.
        - 2021년 3월 25일에 마케팅부에서 회식비로 200,000 원을 사용하였다.

        10 -> 관리부        20 -> 마케팅부      30 -> 구매부       40 -> 인사부
        50 -> 무역부        60 -> 전산부        70 -> 홍보부       80 -> 판매부
        90 -> 총무부        100 -> 재무부       110 -> 회계부
*/
INSERT INTO PAYMENTS VALUES(1, 70, 1500000, '행사', TO_DATE('2021-01-10', 'yyyy-mm-dd'));
INSERT INTO PAYMENTS VALUES(2, 60, 300000, '회식', TO_DATE('2021-02-12', 'yyyy-mm-dd'));
INSERT INTO PAYMENTS VALUES(3, 70, 500000, '회식', TO_DATE('2021-02-15', 'yyyy-mm-dd'));
INSERT INTO PAYMENTS VALUES(4, 50, 100000, '출장', TO_DATE('2021-03-05', 'yyyy-mm-dd'));
INSERT INTO PAYMENTS VALUES(5, 50, 80000, '주유', TO_DATE('2021-03-05', 'yyyy-mm-dd'));
INSERT INTO PAYMENTS VALUES(6, 20, 200000, '회식', TO_DATE('2021-03-25', 'yyyy-mm-dd'));


/*  부서별 법인카드 사용내역(총계)을 확인하기 위한 조회 구문을 만드시오. */
SELECT DEPARTMENT_ID
     , TO_CHAR(SUM(AMOUNT), '999,999,999') || ' 원' AS 총액
  FROM PAYMENTS
 GROUP BY DEPARTMENT_ID;

/* 사용처별 사용내역(총계)을 확인하기 위한 조회 구문을 만드시오. */
SELECT PAY_TYPE
     , TO_CHAR(SUM(AMOUNT), '999,999,999') || ' 원' AS 총액
  FROM PAYMENTS
 GROUP BY PAY_TYPE;

/* 부서별 1년간 사용 금액을 확인 할 수 있는 조회 구문을 만드시오. */
SELECT DEPARTMENT_ID
     , TO_CHAR(SUM(AMOUNT), '999,999,999') || ' 원' AS 총액
  FROM PAYMENTS
 WHERE PAY_DATE BETWEEN TO_DATE('2021-01-01', 'yyyy-mm-dd')
                    AND TO_DATE('2021-12-31', 'yyyy-mm-dd')
 GROUP BY DEPARTMENT_ID;

/* 사용처별 1년간 사용 금액을 확인 할 수 있는 조회 구문을 만드시오. */
SELECT PAY_TYPE
     , TO_CHAR(SUM(AMOUNT), '999,999,999') || ' 원' AS 총액
  FROM PAYMENTS
 WHERE PAY_DATE BETWEEN TO_DATE('2021-01-01', 'yyyy-mm-dd')
                    AND TO_DATE('2021-12-31', 'yyyy-mm-dd')
 GROUP BY PAY_TYPE;

/*
    사용처를 별도로 관리하기 위한 테이블을 새로 만들고 기존 PAYMENTS 테이블의 CHEKC 제약조건을
    외래키 제약조건으로 변경하도록 한다.
    (가급적 기존 테이블에 저장된 데이터를 삭제하지 않고 진행한다.)
*/
-- 테이블 생성 및 제약조건 생성
CREATE TABLE PAYTYPES (
      PAYTYPE_ID      VARCHAR(2)
    , PAYTYPE_NAME    VARCHAR(12)
);
ALTER TABLE PAYTYPES ADD CONSTRAINT PAYTYPES_PAYTYPE_ID_PK PRIMARY KEY(PAYTYPE_ID);
ALTER TABLE PAYTYPES MODIFY PAYTYPE_NAME CONSTRAINT PAYTYPES_PAYTYPE_NAME_NN NOT NULL;

-- 테이블에 데이터 추가
INSERT INTO PAYTYPES VALUES(1, '회식');
INSERT INTO PAYTYPES VALUES(2, '접대');
INSERT INTO PAYTYPES VALUES(3, '식대');
INSERT INTO PAYTYPES VALUES(4, '행사');
INSERT INTO PAYTYPES VALUES(5, '출장');
INSERT INTO PAYTYPES VALUES(6, '주유');
INSERT INTO PAYTYPES VALUES(7, '복리후생');

-- 기존 체크 제약조건을 제거
ALTER TABLE PAYMENTS DROP CONSTRAINT PAYMENTS_PAY_TYPE_CK;

-- 기존 저장 데이터 외래 제약 조건에 맞추어 데이터 변경
UPDATE PAYMENTS SET PAY_TYPE = '1' WHERE PAY_TYPE = '회식';
UPDATE PAYMENTS SET PAY_TYPE = '2' WHERE PAY_TYPE = '접대';
UPDATE PAYMENTS SET PAY_TYPE = '3' WHERE PAY_TYPE = '식대';
UPDATE PAYMENTS SET PAY_TYPE = '4' WHERE PAY_TYPE = '행사';
UPDATE PAYMENTS SET PAY_TYPE = '5' WHERE PAY_TYPE = '출장';
UPDATE PAYMENTS SET PAY_TYPE = '6' WHERE PAY_TYPE = '주유';
UPDATE PAYMENTS SET PAY_TYPE = '7' WHERE PAY_TYPE = '복리후생';

-- 임시테이블을 생성하여 데이터를 복사후 컬럼 타입 변경
- -ALTER TABLE PAYMENTS MODIFY PAY_TYPE NUMBER; 

-- 외래키 제약조건 추가
ALTER TABLE PAYMENTS ADD CONSTRAINT PAYMENTS_PAY_TYPE_FK FOREIGN KEY(PAY_TYPE)
      REFERENCES PAYTYPES(PAYTYPE_ID);



SELECT * FROM PAYMENTS;
SELECT * FROM DEPARTMENTS;