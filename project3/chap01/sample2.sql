SELECT * FROM EMPLOYEES;

-- 모든 컬럼의 이름은 한글로 변환
-- SALARY 컴럼 오른쪽에 단위(달러) 컬럼을 부여하여 단위 표기가 같이 조회되도록 한다.
-- COMMISSION_PCT 컬럼 오른쪽에 단위(%) 컬럼을 부여하여 단위 표기가 같이 조회되도록 한다.

SELECT EMPLOYEE_ID AS 사원번호
    , FIRST_NAME AS 이름
    , LAST_NAME AS 성
    , EMAIL AS 이메일
    , PHONE_NUMBER AS 전화번호
    , HIRE_DATE AS 입사일
    , JOB_ID AS 직무번호
    , SALARY AS 급여
    , SALARY * 12 AS 연봉
    , '달러' AS 단위
    , COMMISSION_PCT AS 커미션
    , '%' AS 단위
    , MANAGER_ID AS 관리자번호
    , DEPARTMENT_ID AS 부서번호
  FROM EMPLOYEES;

  SELECT JOB_ID
    , DEPARTMENT_ID
   FROM EMPLOYEES;


  SELECT DISTINCT JOB_ID
    , DEPARTMENT_ID
   FROM EMPLOYEES;

 --또는 IS NOT NULL; !=같은거 NULL엔 쓰면안됨.
SELECT *
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NULL; 

SELECT *
  FROM EMPLOYEES
 WHERE SALARY >= 10000;

SELECT *
   FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (70, 80, 90)
    AND SALARY >= 10000
    AND COMMISSION_PCT IS NOT NULL;
   
   -- ;은 문장 마지막에 넣는거.