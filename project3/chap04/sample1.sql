SELECT DEPARTMENT_ID
     , COUNT(*) AS 인원수
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY DEPARTMENT_ID;

SELECT DEPARTMENT_ID
     , COUNT(*) AS 인원수
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY ROLLUP(DEPARTMENT_ID);

SELECT DEPARTMENT_ID
     , COUNT(*) AS 인원수
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY CUBE(DEPARTMENT_ID);


SELECT DEPARTMENT_ID
     , AVG(SALARY) AS 급여평균
     , COUNT(*) AS 인원수
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY ROLLUP(DEPARTMENT_ID);

SELECT DEPARTMENT_ID
     , AVG(SALARY) AS 급여평균
     , COUNT(*) AS 인원수
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY CUBE(DEPARTMENT_ID);


SELECT DEPARTMENT_ID
     , JOB_ID
     , AVG(SALARY) AS 급여평균
     , COUNT(*) AS 인원수
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY ROLLUP(DEPARTMENT_ID, JOB_ID);

SELECT DEPARTMENT_ID
     , JOB_ID
     , AVG(SALARY) AS 급여평균
     , COUNT(*) AS 인원수
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY CUBE(DEPARTMENT_ID, JOB_ID); -- 가능한 모든 조합별 집계


SELECT DEPARTMENT_ID
     , JOB_ID
     , AVG(SALARY) AS 급여평균
     , COUNT(*) AS 인원수
     , CASE WHEN GROUPING(DEPARTMENT_ID) = 0 AND GROUPING(JOB_ID) = 1 THEN '부서별'
            WHEN GROUPING(DEPARTMENT_ID) = 0 AND GROUPING(JOB_ID) = 0 THEN '부서의 직무별'
            ELSE '총합계'
        END AS 집계구분
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY ROLLUP(DEPARTMENT_ID, JOB_ID);


SELECT DEPARTMENT_ID
     , JOB_ID
     , AVG(SALARY) AS 급여평균
     , COUNT(*) AS 인원수
     , CASE WHEN GROUPING(DEPARTMENT_ID) = 0 AND GROUPING(JOB_ID) = 1 THEN '부서별'
            WHEN GROUPING(DEPARTMENT_ID) = 1 AND GROUPING(JOB_ID) = 0 THEN '직무별'
            WHEN GROUPING(DEPARTMENT_ID) = 0 AND GROUPING(JOB_ID) = 0 THEN '부서의 직무별'
            ELSE '총합계'
        END AS 집계구분
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY CUBE(DEPARTMENT_ID, JOB_ID);

/*
    년도별 커미션 유무에 따른 급여 평균 구하기.
        년대        커미션유무      평균
        1980년대    있음            xxx,xxx
        1980년대    없음            xxx,xxx
        1980년대                    xxx,xxx
        1990년대    있음            xxx,xxx
        1990년대    없음            xxx,xxx
        1990년대                    xxx,xxx
        2000년대    있음            xxx,xxx
        2000년대    없음            xxx,xxx
        2000년대                    xxx,xxx
                                    xxx,xxx
*/
SELECT SUBSTR(TO_CHAR(HIRE_DATE, 'yyyy'), 1, 3) || '0' AS 년대
     , NVL2(COMMISSION_PCT, '있음', '없음') AS 커미션유무
     , TO_CHAR(AVG(SALARY), '999,999.99999') AS 평균
  FROM EMPLOYEES
 GROUP BY ROLLUP(SUBSTR(TO_CHAR(HIRE_DATE, 'yyyy'), 1, 3) || '0'
               , NVL2(COMMISSION_PCT, '있음', '없음'));


SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE DEPARTMENT_ID = 10
UNION
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE DEPARTMENT_ID = 20;

-- 컬럼 이름을 다르게 사용한 경우 첫번째 SELECT 문의 컬럼명을 사용하여 결과셋 반환
SELECT EMPLOYEE_ID, FIRST_NAME AS FN, LAST_NAME AS LN FROM EMPLOYEES WHERE DEPARTMENT_ID = 10
UNION
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE DEPARTMENT_ID = 20;

SELECT EMPLOYEE_ID, FIRST_NAME, EMAIL FROM EMPLOYEES WHERE DEPARTMENT_ID = 10
UNION
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE DEPARTMENT_ID = 20;

-- 컬럼 타입이 다른 경우 에러 발생
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY FROM EMPLOYEES WHERE DEPARTMENT_ID = 10
UNION
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE DEPARTMENT_ID = 20;

-- 컬럼의 수가 다른 경우 에러 발생
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY FROM EMPLOYEES WHERE DEPARTMENT_ID = 10
UNION
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE DEPARTMENT_ID = 20;

-- 다른 테이블을 조회한 경우
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID FROM EMPLOYEES WHERE DEPARTMENT_ID = 10
UNION
SELECT LOCATION_ID, DEPARTMENT_NAME, DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_ID = 20;


SELECT DEPARTMENT_ID
     , JOB_ID
     , NVL2(COMMISSION_PCT, 'YES', 'NO') AS COMMISSION_YN
     , AVG(SALARY) AS AVG_SALARY
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY GROUPING SETS((DEPARTMENT_ID, JOB_ID)
                      , (DEPARTMENT_ID, NVL2(COMMISSION_PCT, 'YES', 'NO'))
                      , NULL)
 ORDER BY 1, 2, 3;