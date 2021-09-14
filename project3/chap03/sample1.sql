--함수 사용시 DUAL 테이블 이용! 걍 더미 테이블임
--데이터 저장된게 아니라 테스트용도인 임시테이블로 많이 사용됨.
--즉 함수 기능을 테스트할 때 DUAL 테이블을 사용하여 테스트 진행.
--SELECT 함수명() FROM DUAL; 형식으로 하면됨.
SELECT * FROM DUAL;

--FIRST_NAME의 길이
SELECT FIRST_NAME, LENGTH(FIRST_NAME) FROM EMPLOYEES;

--B라고 적힌건 bite 관련된 처리임. 지원되는 일반함수에 B만 붙여주면 됨.
SELECT LENGTH('안녕하세요'), LENGTHB('안녕하세요') FROM DUAL;

SELECT JOB_ID, INSTR(JOB_ID, '_') FROM EMPLOYEES;
SELECT INSTR('12345_1234_123_12_1', '_') FROM DUAL;
--포지션은 찾을 위치의 시작값! 7로하기 이전은 다 6나옴.
--6번째에 _가 있기 때문임.
SELECT INSTR('12345_1234_123_12_1', '_', 7) FROM DUAL;
--1부터 시작해서 2번째 _를 찾아라. 라는 뜻.
--인덱스 스트림의 약자임 INSTR이!
SELECT INSTR('12345_1234_123_12_1', '_',1 ,2) FROM DUAL;
-- -는 뒤에서부터 시작방향 쪽으로 찾음.
SELECT INSTR('12345_1234_123_12_1', '_',-1, 2) FROM DUAL;

--한글은 한글자당 두글자로 인식됨.
--LPAD는  나머지 자릿수*로 채움
--RPAD는 나머지자리 제외 모자란 부분*로 채움
--L은 왼쪽을 별로 R은 오른쪽을 별로 채우는 차이.
--얘넨 B붙이는거 없음.
--한글로 할거면 6+한글갯수만큼 늘려주면됨
SELECT LPAD('하이', 6, '*'), RPAD('안녕', 6, '*') FROM DUAL;
SELECT LPAD('HI', 6, '*'), RPAD('HELLO', 6, '*') FROM DUAL;

--문자 처리 함수, 오른쪽에 있는 문자가 있으면 제거하는 형태.
--연속적으로 존재는 해야함.
--acb라는 문자가 있으면 제거해라 니까 a있으니 제거
--a있으니 제거 b있으니 제거 이런식임.
SELECT LTRIM('aabbccdd1234', 'acb') FROM DUAL;
SELECT RTRIM('1234ddccbbaa', 'acb') FROM DUAL;

SELECT SUBSTR('쇼우 미 더 머니', 2, 5) FROM DUAL;
--             1 23 45 67 8 9 라서 우 미 더 이렇게나옴.

--두 날짜의 개월차를 구하란뜻. 소숫점은 무시해도 됨. 8개월 차이임.
--앞이 커야해 최근날짜로 나와야해.
SELECT MONTHS_BETWEEN(SYSDATE, TO_DATE('2021/01/01', 'yyyy/mm/dd')) FROM DUAL;
--순서가 바뀌면 음수가 나와.
SELECT MONTHS_BETWEEN(TO_DATE('2021/01/01', 'yyyy/mm/dd'), SYSDATE) FROM DUAL;
--뒤에 소수점은 필요없음. 음수도 날려
SELECT FLOOR(ABS(MONTHS_BETWEEN(TO_DATE('2021/01/01', 'yyyy/mm/dd'), SYSDATE))) FROM DUAL;

SELECT FLOOR(SYSDATE - TO_DATE('2021/01/01', 'yyyy/mm/dd')) FROM DUAL;
--현재 날짜에서 3개월 뒤의 날짜가 필요한 경우. 기본 출력 형태가 일 월 년 순인거임.
SELECT ADD_MONTHS(SYSDATE, 3), TO_CHAR(ADD_MONTHS(SYSDATE, 3), 'yyyy-mm-dd') FROM DUAL;

SELECT SYSDATE + 3, TO_CHAR(SYSDATE + 3, 'yyyy-mm-dd') FROM DUAL;
--현재 날짜를 기준으로 다음 월요일이 언제냐? 라는 뜻.
--시스템에 설정된 언어설정이 다르니 월요일말고 MONDAY 사용.
--그래서 바로밑에 ALTER로 변경 해준거임.
--그러니 가급적 숫자 써라.
SELECT NEXT_DAY(SYSDATE, '월요일') FROM DUAL;
SELECT NEXT_DAY(SYSDATE, 'MONDAY') FROM DUAL;

--언어 설정과 무관하게 동작
--1~7까지 일 월 화 수 목 금 토 순서대로! 
SELECT NEXT_DAY(SYSDATE, 2) FROM DUAL;
--한국어로 설정하기 위한 명령(일시적으로 변경된다.) 재접속하면 다시 기본 언어로 변경됨.
ALTER SESSION SET NLS_LANGUAGE = KOREAN;

SELECT LAST_DAY(SYSDATE) FROM DUAL;

SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;
SELECT EXTRACT(MONTH FROM SYSDATE) FROM DUAL;
SELECT EXTRACT(DAY FROM SYSDATE) FROM DUAL;

SELECT TO_CHAR(SYSDATE), TO_CHAR(SYSDATE, 'yyyy') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'mm'), TO_CHAR(SYSDATE, 'dd') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'hh'), TO_CHAR(SYSDATE, 'mi') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'mon'), TO_CHAR(SYSDATE, 'day') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'yyyy/mm/dd hh:mi:ss') FROM DUAL;

SELECT TO_CHAR(1234567) FROM DUAL;
SELECT TO_CHAR(1234567, '000,000,000') FROM DUAL;
SELECT TO_CHAR(1234567, '999,999,999') FROM DUAL;
SELECT TO_CHAR(1234567, 'L999,999,999') FROM DUAL;
SELECT TO_CHAR(1234567, '999,999,999L') FROM DUAL;

SELECT TO_DATE('2021-09-14', 'yyyy-mm-dd') FROM DUAL;
SELECT TO_DATE('2021/09/14', 'yyyy/mm/dd') FROM DUAL;
SELECT TO_DATE('20210914', 'yyyymmdd') FROM DUAL;
SELECT TO_DATE('2021년 09월 14일', 'yyyy"년" mm"월" dd"일"') FROM DUAL;
SELECT TO_CHAR(TO_DATE('09:14:30', 'hh:mi:ss'), 'hh:mi:ss') FROM DUAL;
SELECT TO_CHAR(TO_DATE('15:14:30', 'hh24:mi:ss'), 'hh:mi:ss') FROM DUAL;
SELECT TO_CHAR(TO_DATE('15:14:30', 'hh24:mi:ss'), 'am hh:mi:ss') FROM DUAL;
SELECT TO_DATE(20210914, 'yyyymmdd') FROM DUAL;
SELECT TO_DATE(210914, 'yymmdd') FROM DUAL;






SELECT * FROM NLS_SESSION_PARAMETERS;
-- SESSION 으로 설정(로그아웃하면 다시 기본설정으로 돌아옴)
ALTER SESSION SET NLS_TERRITORY = KOREA; -- 영역설정
ALTER SESSION SET NLS_LANGUAGE = KOREAN; -- 언어설정


-- 타임존 설정
-- SYSDATE : 시스템의 날짜정보를 가져오기 때문에 시스템 자체 타임존을 변경하지 않는 이상.
--           데이터베이스 상에서의 시간을 UTC(표준시)로만 나온다.
ALTER DATABASE SET TIME_ZONE = '+09:00';    -- 시스템 계정으로 해야 한다.(재부팅 필요)
SELECT dbtimezone FROM DUAL;

ALTER SESSION SET TIME_ZONE = '+09:00';    -- 로그아웃하면 다시 기본설정으로 돌아옴
ALTER SESSION SET TIME_ZONE = 'Asia/Seoul';
SELECT sessiontimezone FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'yyyy/mm/dd hh24:mi:ss') FROM DUAL;
SELECT TO_CHAR(SYSTIMESTAMP, 'yyyy/mm/dd hh24:mi:ss') FROM DUAL;

SELECT TO_CHAR(CURRENT_DATE, 'yyyy/mm/dd hh24:mi:ss') FROM DUAL;
SELECT TO_CHAR(LOCALTIMESTAMP, 'yyyy/mm/dd hh24:mi:ss') FROM DUAL;

SELECT TO_CHAR(1234567, 'L999,999,999') FROM DUAL;