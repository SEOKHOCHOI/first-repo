SELECT JOB_ID
     , SUM(SALARY)
     , AVG(SALARY)
     , MAX(SALARY)
     , MIN(SALARY)
     , COUNT(*)
  FROM EMPLOYEES
 GROUP BY JOB_ID;   -- JOB_ID 컬럼의 값을 사용하여 그룹화 시킴

SELECT JOB_ID, SALARY FROM EMPLOYEES ORDER BY JOB_ID;

-- EMPLOYEES 테이블의 직원이름, 이메일, 전화번호, 고용일을 조회 한다.
--     - 직원이름은 성과 이름을 하나의 컬럼으로 만들어야 한다.
--     - 이메일 뒤에는 @employees.co.kr 을 붙여야 한다.
--     - 전화번호의 구분자는 . 대신 - 이 사용되도록 한다.
--     - 고용일은 xxxx년 xx월 xx일 형식으로 출력되게 한다.
SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
     , CONCAT(LOWER(EMAIL), '@employees.co.kr') AS 이메일
     , REPLACE(PHONE_NUMBER, '.', '-') AS 전화번호
     , TO_CHAR(HIRE_DATE, 'yyyy"년" mm"월" dd"일"') AS 고용일
  FROM EMPLOYEES;

-- EMPLOYEES 테이블에서 직원이름, 급여, 연봉을 조회 한다.
--     - 연봉은 급여에 12개월을 곱하는 것으로 한다.
SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
     , TO_CHAR(SALARY, '999,999,999') || ' 원' AS 급여
     , TO_CHAR(SALARY * 12, '999,999,999') || ' 원' AS 연봉
  FROM EMPLOYEES;

-- EMPLOYEES 테이블에서 전화번호가 011 로 시작하는 직원의 이름과 사원번호를 조회한다.
SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
     , EMPLOYEE_ID AS 사원번호
  FROM EMPLOYEES
 WHERE PHONE_NUMBER LIKE '011%';

-- EMPLOYEES 테이블에서 커미션이 존재하는 직원의 이름과 급여, 연봉을 조회한다.
--     - 연봉에는 커미션이 계산된 연봉으로 조회한다.
SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
     , TO_CHAR(SALARY, '999,999,999') || ' 원' AS 급여
     , TO_CHAR(SALARY * 12 * (1 + COMMISSION_PCT), '999,999,999') || ' 원' AS 연봉
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL;

-- EMPLOYEES 테이블에서 커미션이 존재하는 직원과 커미션이 존재하지 않은 직원의 급여, 연봉을
-- 조회한다.(커미션이 있는 직원은 커미션이 포함된 연봉으로 계산해야 한다.)
SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
     , TO_CHAR(SALARY, '999,999,999') || ' 원' AS 급여
     , TO_CHAR(SALARY * 12 * (1 + NVL(COMMISSION_PCT, 0)), '999,999,999') || ' 원' AS 연봉
  FROM EMPLOYEES;

-- EMPLOYEES 테이블에서 2000년도에 고용된 직원을 조회한다.
SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
     , TO_CHAR(HIRE_DATE, 'yyyy"년" mm"월" dd"일"') AS 고용일
  FROM EMPLOYEES
 WHERE HIRE_DATE BETWEEN TO_DATE('2000-01-01', 'yyyy-mm-dd')
                     AND TO_DATE('2000-12-31', 'yyyy-mm-dd');

SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
     , TO_CHAR(HIRE_DATE, 'yyyy"년" mm"월" dd"일"') AS 고용일
  FROM EMPLOYEES
 WHERE EXTRACT(YEAR FROM HIRE_DATE) = 2000;

SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
     , TO_CHAR(HIRE_DATE, 'yyyy"년" mm"월" dd"일"') AS 고용일
  FROM EMPLOYEES
 WHERE TO_CHAR(HIRE_DATE, 'yyyy') = '2000';

-- EMPLOYEES 테이블에서 2000년도에 고용된 직원 중 급여가 5500 이상인 직원을 조회한다.
SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
     , TO_CHAR(HIRE_DATE, 'yyyy"년" mm"월" dd"일"') AS 고용일
     , TO_CHAR(SALARY, '999,999,999') || ' 원' AS 급여
  FROM EMPLOYEES
 WHERE HIRE_DATE BETWEEN TO_DATE('2000-01-01', 'yyyy-mm-dd')
                     AND TO_DATE('2000-12-31', 'yyyy-mm-dd')
   AND SALARY >= 5500;

-- EMPLOYEES 테이블에서 1999년 12월 31일을 기준으로 근무개월수가 60개월 이상인 직원을 조회한다.
SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
     , TO_CHAR(HIRE_DATE, 'yyyy"년" mm"월" dd"일"') AS 고용일
     , FLOOR(MONTHS_BETWEEN(TO_DATE('1999-12-31', 'yyyy-mm-dd'), HIRE_DATE)) || ' 개월' AS 근무개월수
  FROM EMPLOYEES
 WHERE MONTHS_BETWEEN(TO_DATE('1999-12-31', 'yyyy-mm-dd'), HIRE_DATE) >= 60;

-- EMPLOYEES 테이블에서 1999년 12월 31일을 까지의 근속년이 7년 이상인 직원을 조회한다.
SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
     , TO_CHAR(HIRE_DATE, 'yyyy"년" mm"월" dd"일"') AS 고용일
     , FLOOR(MONTHS_BETWEEN(TO_DATE('1999-12-31', 'yyyy-mm-dd'), HIRE_DATE) / 12) || ' 년' AS 근무년수
  FROM EMPLOYEES
 WHERE MONTHS_BETWEEN(TO_DATE('1999-12-31', 'yyyy-mm-dd'), HIRE_DATE) / 12 >= 7;

-- EMPLOYEES 테이블에서 커미션이 있는 직원과 없는 직원의 인원수를 조회한다.
SELECT NVL2(COMMISSION_PCT, '있음', '없음') AS 커미션유무
     , COUNT(*) AS 인원수
  FROM EMPLOYEES
 GROUP BY NVL2(COMMISSION_PCT, '있음', '없음');

-- EMPLOYEES 테이블에서 부서별 평균 급여를 조회한다.(부서는 부서코드만 나오면 된다.)
SELECT DEPARTMENT_ID AS 부서코드
     , AVG(SALARY) AS 평균급여
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
 ORDER BY DEPARTMENT_ID;

-- EMPLOYEES 테이블에서 80년대 입사자 수와 90년대 입사자 수 2000년대 입사자 수를 조회한다.
SELECT TRUNC(EXTRACT(YEAR FROM HIRE_DATE), -1) AS 고용년대
     , COUNT(*) AS 인원수
  FROM EMPLOYEES
 GROUP BY TRUNC(EXTRACT(YEAR FROM HIRE_DATE), -1);

SELECT SUBSTR(TO_CHAR(HIRE_DATE, 'yyyy'), 1, 3) || '0' AS 고용년대
     , COUNT(*) AS 인원수
  FROM EMPLOYEES
 GROUP BY SUBSTR(TO_CHAR(HIRE_DATE, 'yyyy'), 1, 3) || '0';

SELECT DEPARTMENT_ID AS 부서코드
     , AVG(SALARY) AS 평균급여
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY) >= 9000
 ORDER BY 1 DESC NULLS FIRST;

SELECT DEPARTMENT_ID AS 부서코드
     , AVG(SALARY) AS 평균급여
  FROM EMPLOYEES
 WHERE SALARY >= 9000
 GROUP BY DEPARTMENT_ID
 ORDER BY 1 DESC NULLS FIRST;



-- EMPLOYEES 테이블에서 80년대, 90년대, 2000년대 입사자의 평균급여 8000 이상인 년대를 조회
SELECT TRUNC(EXTRACT(YEAR FROM HIRE_DATE), -1) AS 고용년대
     , AVG(SALARY) AS 평균급여
     , COUNT(SALARY) AS 인원수
  FROM EMPLOYEES
 GROUP BY TRUNC(EXTRACT(YEAR FROM HIRE_DATE), -1)
HAVING AVG(SALARY) >= 8000;
