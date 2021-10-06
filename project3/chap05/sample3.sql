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
    SELECT FIRST_NAME, LAST_NAME, EMPLOYEE_ID
      INTO EMP_FNAME, EMP_LNAME, EMP_ID
      FROM EMPLOYEES
     WHERE EMPLOYEE_ID = 126;

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

BEGIN
    FOR n IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE('반복 횟수 : ' || n);
    END LOOP;
END;
/

BEGIN
    FOR n IN REVERSE 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE('반복 횟수 : ' || n);
    END LOOP;
END;
/

DECLARE
    n NUMBER := 1;
BEGIN
    WHILE n <= 5 LOOP
        DBMS_OUTPUT.PUT_LINE('반복 횟수 : ' || n);
        n := n + 1;
    END LOOP;
END;
/

DECLARE
    n NUMBER := 1;
BEGIN
    WHILE TRUE LOOP
        DBMS_OUTPUT.PUT_LINE('반복 횟수 : ' || n);
        n := n + 1;
        IF n >= 5 THEN
            EXIT;
        END IF;
    END LOOP;
END;
/

DECLARE
    n NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE('반복 횟수 : ' || n);
        n := n + 1;
        IF n >= 5 THEN
            EXIT;
        END IF;
    END LOOP;
END;
/

DECLARE
    cnt NUMBER := 0;
    emp_id NUMBER;
BEGIN
    emp_id := 1000;
    SELECT COUNT(*) INTO cnt FROM EMPLOYEES WHERE EMPLOYEE_ID >= emp_id;

    IF cnt = 0 THEN
        DBMS_OUTPUT.PUT_LINE('조회 결과가 없습니다.');
    ELSE
        FOR r IN (SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID >= emp_id) LOOP
            DBMS_OUTPUT.PUT_LINE('이름 : ' || CONCAT(r.FIRST_NAME || ' ', r.LAST_NAME));
        END LOOP;
    END IF;
END;
/


DECLARE
    TYPE my_record_type IS RECORD (
         emp_id EMPLOYEES.EMPLOYEE_ID%TYPE
       , f_name EMPLOYEES.FIRST_NAME%TYPE
       , l_name EMPLOYEES.LAST_NAME%TYPE
       , dept_name DEPARTMENTS.DEPARTMENT_NAME%TYPE
       , job_title JOBS.JOB_TITLE%TYPE
    );
    row_data my_record_type;
BEGIN
    SELECT EMPLOYEE_ID
         , FIRST_NAME
         , LAST_NAME
         , DEPARTMENT_NAME
         , JOB_TITLE
      INTO row_data
      FROM EMPLOYEES A JOIN DEPARTMENTS B
        ON A.DEPARTMENT_ID = B.DEPARTMENT_ID
      JOIN JOBS C
        ON A.JOB_ID = C.JOB_ID
     WHERE EMPLOYEE_ID = 100;
    DBMS_OUTPUT.PUT(row_data.emp_id || ' | ' || row_data.f_name || ' | ' || row_data.l_name);
    DBMS_OUTPUT.PUT_LINE(row_data.dept_name || ' | ' || row_data.job_title);
END;
/


DECLARE
    TYPE array_type IS TABLE OF EMPLOYEES.EMPLOYEE_ID%TYPE INDEX BY BINARY_INTEGER;
    arr1 array_type;
    i NUMBER := 1;
BEGIN
    FOR r IN (SELECT EMPLOYEE_ID FROM EMPLOYEES) LOOP
        arr1(i) := r.EMPLOYEE_ID;
        i := i + 1;
    END LOOP;

    FOR n IN 1..i-1 LOOP
        DBMS_OUTPUT.PUT_LINE(n || ': ' || arr1(n));
    END LOOP;
END;
/


DECLARE
    TYPE my_record_type IS RECORD (
         emp_id EMPLOYEES.EMPLOYEE_ID%TYPE
       , f_name EMPLOYEES.FIRST_NAME%TYPE
       , l_name EMPLOYEES.LAST_NAME%TYPE
       , dept_name DEPARTMENTS.DEPARTMENT_NAME%TYPE
       , job_title JOBS.JOB_TITLE%TYPE
    );
    TYPE array_type IS TABLE OF my_record_type INDEX BY BINARY_INTEGER;
    my_table array_type;
    i NUMBER := 1;
BEGIN
    FOR r IN (SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME
                   , DEPARTMENT_NAME, JOB_TITLE
                FROM EMPLOYEES A JOIN DEPARTMENTS B
                  ON A.DEPARTMENT_ID = B.DEPARTMENT_ID
                JOIN JOBS C
                  ON A.JOB_ID = C.JOB_ID) LOOP
        my_table(i).emp_id := r.EMPLOYEE_ID;
        my_table(i).f_name := r.FIRST_NAME;
        my_table(i).l_name := r.LAST_NAME;
        my_table(i).dept_name := r.DEPARTMENT_NAME;
        my_table(i).job_title := r.JOB_TITLE;
        i := i + 1;
    END LOOP;

    FOR n IN 1..i-1 LOOP
        DBMS_OUTPUT.PUT(my_table(n).emp_id || ' | ' || my_table(n).f_name || ' | ' || my_table(n).l_name);
        DBMS_OUTPUT.PUT_LINE(my_table(n).dept_name || ' | ' || my_table(n).job_title);
    END LOOP;
END;
/

/*
    ACCOUNTS 테이블에 다음의 데이터 추가
        - 2021년 01월 한 달간 매주 평일 마다 식비로 6,500원을 사용하였다.
*/

CREATE OR REPLACE PROCEDURE PROC_한달식비일괄저장(i_base_month IN VARCHAR)
IS
    lastday NUMBER;
    weekday NUMBER;
    base_month VARCHAR(6);
BEGIN
    base_month := i_base_month;
    lastday := EXTRACT(DAY FROM LAST_DAY(TO_DATE(base_month, 'yyyymm')));
    FOR d IN 1..lastday LOOP
        weekday := TO_CHAR(TO_DATE(base_month || TO_CHAR(d, '00'), 'yyyymmdd'), 'D');
        IF weekday NOT IN (1, 7) THEN
            INSERT INTO ACCOUNTS VALUES(ACCOUNTS_SEQ.NEXTVAL, 6500, 'O'
                 , TO_DATE(base_month || TO_CHAR(d, '00'), 'yyyymmdd'), 'O04');
        END IF;
    END LOOP;
END;
/

EXEC PROC_한달식비일괄저장('202106');


-- 지출코드가 'O04' 인 데이터를 'O05' 로 변경하는 프로시저
CREATE OR REPLACE PROCEDURE PROC_지출코드일괄변경(i_old_code IN VARCHAR, i_new_code IN VARCHAR)
IS
BEGIN
    UPDATE ACCOUNTS
       SET ACC_TYPE = i_new_code
     WHERE ACC_TYPE = i_old_code;
END;
/
EXEC PROC_지출코드일괄변경('O04', 'O05');
SELECT * FROM ACCOUNTS;


-- 지정된 날짜 범위안에서의 지출코드가 'O05' 인 데이터의 금액을 변경하는 프로시저
CREATE OR REPLACE PROCEDURE PROC_금액변경(i1 IN VARCHAR, i2 IN NUMBER, i3 IN DATE, i4 IN DATE)
IS
BEGIN
    UPDATE ACCOUNTS
       SET AMOUNT = i2
     WHERE ACC_TYPE = i1
       AND ACC_DATE BETWEEN i3 AND i4;
END;
/
EXEC PROC_금액변경('O05', 8000, TO_DATE('20210101', 'yyyymmdd'), TO_DATE('20210131', 'yyyymmdd'));
SELECT * FROM ACCOUNTS;
SELECT * FROM ACCTYPES;


-- 아래에 작성된 프로시저 형식을 보고 올바르게 동작 할 수 있는 프로시저를 만든다.
-- 존재하지 않는 출금/입금 타입은 자동으로 만들어질 수 있게 한다.
CREATE OR REPLACE PROCEDURE PROC_가계부작성(i1 IN NUMBER, i2 IN DATE, i3 IN VARCHAR, i4 IN VARCHAR)
IS
    inout VARCHAR(1);
    type_error EXCEPTION;
    acctype ACCTYPES.ID%TYPE;
    cnt NUMBER;
    code NUMBER;
BEGIN
    IF i3 = '출금' THEN
        inout := 'O';
    ELSIF i3 = '입금' THEN
        inout := 'I';
    ELSE
        RAISE type_error;
    END IF;
    SELECT COUNT(*) INTO cnt FROM ACCTYPES WHERE TYPE_NAME = i4;
    IF cnt = 1 THEN
        SELECT ID INTO acctype FROM ACCTYPES WHERE TYPE_NAME = i4;
    ELSE
        SELECT COUNT(*) INTO code FROM ACCTYPES WHERE ID LIKE inout || '%';
        acctype := inout || TRIM(TO_CHAR(code+1, '00'));
        INSERT INTO ACCTYPES VALUES(acctype, i4);
    END IF;
    INSERT INTO ACCOUNTS VALUES(ACCOUNTS_SEQ.NEXTVAL, i1, inout, i2, acctype);
EXCEPTION
    WHEN type_error THEN
        DBMS_OUTPUT.PUT_LINE('입금/출금만 할 수 있습니다.');
END;
/
EXEC PROC_가계부작성(100000, TO_DATE('20211005', 'yyyymmdd'), '출금', '교통비');
EXEC PROC_가계부작성(3000000, TO_DATE('20211025', 'yyyymmdd'), '입금', '급여');
EXEC PROC_가계부작성(30000, TO_DATE('20211027', 'yyyymmdd'), '출금', '배달음식');