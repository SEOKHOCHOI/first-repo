-- FUNCTION : 함수, 오라클 기본 제공 함수 외의 사용자 정의 함수를 생성
-- 하여 사용하기 위한 객체
CREATE OR REPLACE FUNCTION FUNC_TEST1(val NUMBER) RETURN NUMBER
IS
BEGIN
    RETURN val + 1;
END;
/
SELECT FUNC_TEST1(1) FROM DUAL;

SELECT EMPLOYEE_ID
     , FIRST_NAME || ' ' || LAST_NAME AS NAME
     , SALARY
     , COMMISSION_PCT
     , SALARY * (1 + DECODE(COMMISSION_PCT, NULL, 0, COMMISSION_PCT)) * 12 AS YEAR_SALARY
  FROM EMPLOYEES;

CREATE OR REPLACE FUNCTION FUNC_YEAR_SALARY(salary NUMBER, commission NUMBER) RETURN NUMBER
IS
    val_comm NUMBER;
BEGIN
    IF commission is null THEN
        val_comm := 0;
    ELSE
        val_comm := commission;
    END IF;

    RETURN salary * (1 + val_comm) * 12;
END;
/

SELECT EMPLOYEE_ID
     , FIRST_NAME || ' ' || LAST_NAME AS NAME
     , SALARY
     , COMMISSION_PCT
     , FUNC_YEAR_SALARY(SALARY, COMMISSION_PCT) AS YEAR_SALARY
  FROM EMPLOYEES;


CREATE OR REPLACE FUNCTION FUNC_PROD_OUT_CALC(amount NUMBER, cnt NUMBER) RETURN NUMBER
IS
BEGIN
    RETURN amount * cnt * 1.1;
END;
/

CREATE OR REPLACE FUNCTION FUNC_PROD_IN_CALC(amount NUMBER, cnt NUMBER) RETURN NUMBER
IS
BEGIN
    RETURN amount * cnt * 0.9;
END;
/

UPDATE PROD_INOUT
   SET PRICE = FUNC_PROD_OUT_CALC(AMOUNT, CNT)  -- FUNC_PROD_OUT_CALC(단가, 수량)
 WHERE IN_OUT = 'O';

UPDATE PROD_INOUT
   SET PRICE = FUNC_PROD_IN_CALC(AMOUNT, CNT)  -- FUNC_PROD_IN_CALC(단가, 수량)
 WHERE IN_OUT = 'I';


/* 날짜를 매개변수로 전달하면 해당 월의 가장 첫번째 날짜를 반환 */
CREATE OR REPLACE FUNCTION TO_FIRST_DATE(d DATE) RETURN DATE
IS
    ret VARCHAR(8);
BEGIN
    ret := TO_CHAR(d, 'yyyymm') || '01';
    RETURN TO_DATE(ret, 'yyyymmdd');
END;
/

SELECT TO_FIRST_DATE(SYSDATE) FROM DUAL;

/* 날짜를 매개변수로 전달하면 해당 월의 가장 마지막 날짜를 반환 */
CREATE OR REPLACE FUNCTION TO_LAST_DATE(d DATE) RETURN DATE
IS
BEGIN
    RETURN LAST_DAY(d);
END;
/
