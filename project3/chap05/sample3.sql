-- SET SERVEROUTPUT ON;
-- SET AUTOCOMMIT OFF;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello PL/SQL');
END;
/

DECLARE
    /*
        변수 선언부로 BEGIN 안에 사용 할 변수를 미리 구성한다.
        변수명 데이터타입;
    */
    var1 NUMBER;
    var2 VARCHAR2(10);
    var3 CHAR(1) := 'F';
BEGIN
    var1 := 10;
    var2 := 'abcd';

    DBMS_OUTPUT.PUT_LINE('var1 출력 : ' || (var1 + 10));
    DBMS_OUTPUT.PUT_LINE('var2 출력 : ' || var2);
    DBMS_OUTPUT.PUT_LINE('var3 출력 : ' || var3);
END;
/


DECLARE
    EMP_FNAME EMPLOYEES.FIRST_NAME%TYPE;
    EMP_LNAME EMPLOYEES.LAST_NAME%TYPE;
    EMP_ID NUMBER;
BEGIN
    -- 반드시 1 행의 데이터 필요
    SELECT FIRST_NAME
         , LAST_NAME
         , EMPLOYEE_ID
      INTO EMP_FNAME
         , EMP_LNAME
         , EMP_ID
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 100;

    DBMS_OUTPUT.PUT_LINE('사번 : ' || EMP_ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || EMP_FNAME || ' ' || EMP_LNAME);
END;
/


DECLARE
    row_data EMPLOYEES%ROWTYPE;
BEGIN
    SELECT *
      INTO row_data
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 100;

    DBMS_OUTPUT.PUT_LINE('사번 : ' || row_data.EMPLOYEE_ID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || row_data.FIRST_NAME || ' ' || row_data.LAST_NAME);
END;
/


DECLARE
    cnt NUMBER;
BEGIN
    SELECT COUNT(*) 
      INTO cnt
      FROM EMPLOYEES
    WHERE DEPARTMENT_ID = 80;

    DBMS_OUTPUT.PUT_LINE('부서 인원 : ' || cnt);
    IF(cnt >= 40) THEN
        DBMS_OUTPUT.PUT_LINE('부서 인원이 40명 이상 입니다.');
    ELSIF(cnt >= 30) THEN
        DBMS_OUTPUT.PUT_LINE('부서 인원이 30명 이상 입니다.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('부서 인원이 30명 미만 입니다.');
    END IF;
END;
/

SELECT COUNT(*)
     , DEPARTMENT_ID
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID;