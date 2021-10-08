SELECT * FROM TB_STUDENT;           -- 학생 정보 테이블
SELECT * FROM TB_PROFESSOR;         -- 교수 정보 테이블
SELECT * FROM TB_CLASS;             -- 과목 정보 테이블
SELECT * FROM TB_DEPARTMENT;        -- 학과 정보 테이블
SELECT * FROM TB_GRADE;             -- 성적 정보 테이블
SELECT * FROM TB_CLASS_PROFESSOR;   -- 학과별 담당 교수 테이블

-- 조인, 서브쿼리, 집계, 뷰, 프로시저, 함수 등 모든 오라클 객체를 활용.

/*
    학생 정보를 출력할 때 학번, 이름, 학과명, 주민번호, 성별, 집주소 컬럼이 출력될 수 있게 한다.
        - 주민번호는 210101-******* 형식으로 출력되게 한다.
        - 성별은 주민번호 뒷자리의 첫번째 숫자가 1이면 남자, 2이면 여자이다.
*/
CREATE OR REPLACE FUNCTION JUMIN_HIDDEN(jumin_number VARCHAR) RETURN VARCHAR2
IS
BEGIN
    RETURN CONCAT(SUBSTR(jumin_number, 1, 6), '-*******');
END;
/

CREATE OR REPLACE FUNCTION JUMIN_GENDER(jumin_number VARCHAR) RETURN VARCHAR2
IS
    jumin_pattern_error EXCEPTION;
    jumin_length_error EXCEPTION;
BEGIN
    IF LENGTH(jumin_number) = 14 THEN
        IF INSTR(jumin_number, '-') = 7 THEN
            IF SUBSTR(jumin_number, 8, 1) = 1 THEN
                RETURN '남자';
            ELSE
                RETURN '여자';
            END IF;
        ELSE
            RAISE jumin_pattern_error;
        END IF;
    ELSE
        RAISE jumin_length_error;
    END IF;
EXCEPTION
    WHEN jumin_length_error THEN
        DBMS_OUTPUT.PUT_LINE('주민등록 번호 길이가 맞지 않습니다.');
    WHEN jumin_pattern_error THEN
        DBMS_OUTPUT.PUT_LINE('주민등록 번호 형식이 올바르지 않습니다. (123456-1234567)');
END;
/

CREATE OR REPLACE VIEW V_STUDENT_INFO AS
    SELECT STUDENT_NO AS 학번
         , STUDENT_NAME AS 이름
         , DEPARTMENT_NAME AS 학과명
         , JUMIN_HIDDEN(STUDENT_SSN) AS 주민번호
         , JUMIN_GENDER(STUDENT_SSN) AS 성별
         , STUDENT_ADDRESS AS 집주소
      FROM TB_STUDENT A JOIN TB_DEPARTMENT B
        ON A.DEPARTMENT_NO = B.DEPARTMENT_NO
WITH READ ONLY;

SELECT * FROM V_STUDENT_INFO WHERE 성별 = '여자';


/*
    교수 정보를 출력할 때 교번, 이름, 학과명, 주민번호, 성별, 집주소 컬럼이 출력될 수 있게 한다.
        - 주민번호는 210101-******* 형식으로 출력되게 한다.
        - 성별은 주민번호 뒷자리의 첫번째 숫자가 1이면 남자, 2이면 여자이다.
*/
CREATE OR REPLACE VIEW V_PROFESSOR_INFO AS
    SELECT PROFESSOR_NO AS 교번
         , PROFESSOR_NAME AS 이름
         , DEPARTMENT_NAME AS 학과명
         , JUMIN_HIDDEN(PROFESSOR_SSN) AS 주민번호
         , JUMIN_GENDER(PROFESSOR_SSN) AS 성별
         , PROFESSOR_ADDRESS AS 집주소
      FROM TB_PROFESSOR A JOIN TB_DEPARTMENT B
        ON A.DEPARTMENT_NO = B.DEPARTMENT_NO
WITH READ ONLY;

SELECT * FROM V_PROFESSOR_INFO;

/*
    과목 정보를 출력할 때 학과명, 과목명, 구분(CLASS_TYPE) 이 출력되게 한다.
        - 뷰로 생성해서 조건절에 학과명을 입력하면 입력한 학과의 과목 정보가 출력될 수 있게 한다.
        - 구분별로 정렬되어 출력될 수 있게 한다.
*/
CREATE OR REPLACE VIEW V_CLASS_INFO AS
    SELECT DEPARTMENT_NAME AS 학과명
         , CLASS_NAME AS 과목명
         , CLASS_TYPE AS 구분
      FROM TB_CLASS A JOIN TB_DEPARTMENT B
        ON A.DEPARTMENT_NO = B.DEPARTMENT_NO
WITH READ ONLY;

SELECT * FROM V_CLASS_INFO WHERE 학과명 = '컴퓨터공학과';

/*
    성적 정보를 출력할 때 전체 학기에 대한 평균 성적이 집계에 출력될 수 있게 한다.
        - 뷰로 생성해서 조건절에 학생명을 입력하면 입력한 학생의 성적 정보가 출력될 수 있게 한다.
*/
CREATE OR REPLACE VIEW V_GRADE_AVG AS
    SELECT A.STUDENT_NO AS 학번
         , B.STUDENT_NAME AS 이름
         , ROUND(AVG(POINT), 2) AS 평균학점
      FROM TB_GRADE A JOIN TB_STUDENT B
        ON A.STUDENT_NO = B.STUDENT_NO
     GROUP BY A.STUDENT_NO, B.STUDENT_NAME
WITH READ ONLY;


CREATE OR REPLACE VIEW V_GRADE_FOR_YEAR AS
    SELECT SUBSTR(TERM_NO, 1, 4) AS 년도
         , B.STUDENT_NAME AS 이름
         , ROUND(AVG(POINT), 2) AS 평균학점
      FROM TB_GRADE A JOIN TB_STUDENT B
        ON A.STUDENT_NO = B.STUDENT_NO
     GROUP BY ROLLUP(SUBSTR(TERM_NO, 1, 4)), B.STUDENT_NAME
WITH READ ONLY;

SELECT * FROM TB_GRADE WHERE STUDENT_NO = 'A473023';
SELECT 년도, 평균학점 FROM V_GRADE_FOR_YEAR WHERE 이름 = '이용태';


/*
    학생 정보 테이블의 ABSENCE_YN 컬럼은 휴학여부를 구분하는 컬럼이다. 이를 바탕으로 특정 학생이
    휴학신청을 하거나, 복학신청을 하는 경우 이를 처리할 수 있는 프로시저를 생성하도록 한다.
        - 휴학신청을 하는 학생들의 휴학기간을 파악하기 위해 TB_ABSENCES 테이블을 생성하여
          휴학신청을 하는 학생들을 별도로 관리할 수 있게 한다.
        - TB_ABSENCES 테이블은 ID, 학번, 학과, 휴학신청일, 복학신청일, 예상기간 컬럼을 생성하여
          관리한다.(예상기간은 휴학신청을 할 때 작성하는 기간/년 이다.)
*/

CREATE TABLE TB_ABSENCES (
      ID            NUMBER
    , 학번          VARCHAR2(10)
    , 학과          VARCHAR2(10)
    , 휴학신청일    DATE
    , 복학신청일    DATE
    , 예상기간      NUMBER
);
ALTER TABLE TB_ABSENCES ADD CONSTRAINT TB_ABSENCES_ID_PK PRIMARY KEY(ID);
ALTER TABLE TB_ABSENCES ADD CONSTRAINT TB_ABSENCES_학번_FK FOREIGN KEY(학번) REFERENCES TB_STUDENT(STUDENT_NO);
ALTER TABLE TB_ABSENCES ADD CONSTRAINT TB_ABSENCES_학과_FK FOREIGN KEY(학과) REFERENCES TB_DEPARTMENT(DEPARTMENT_NO);
ALTER TABLE TB_ABSENCES MODIFY 예상기간 CONSTRAINT TB_ABSENCES_예상기간_NN NOT NULL;

CREATE SEQUENCE TB_ABSENCES_SEQ;


CREATE OR REPLACE PROCEDURE 휴학처리(학번 IN VARCHAR, 신청일 IN DATE, 예상기간 IN NUMBER)
IS
    data_count NUMBER;
    absence TB_STUDENT.ABSENCE_YN%TYPE;
    row_data TB_STUDENT%ROWTYPE;
    not_found EXCEPTION;
    already_absence EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO data_count FROM TB_STUDENT WHERE STUDENT_NO = 학번;
    IF data_count = 0 THEN
        RAISE not_found;
    END IF;

    SELECT ABSENCE_YN INTO absence FROM TB_STUDENT WHERE STUDENT_NO = 학번;
    IF absence = 'Y' THEN
        RAISE already_absence;
    END IF;

    UPDATE TB_STUDENT
    SET ABSENCE_YN = 'Y'
    WHERE STUDENT_NO = 학번;
    
    SELECT * INTO row_data FROM TB_STUDENT WHERE STUDENT_NO = 학번;

    INSERT INTO TB_ABSENCES
        VALUES(TB_ABSENCES_SEQ.NEXTVAL, 학번
                , row_data.DEPARTMENT_NO, 신청일, NULL, 예상기간);

    COMMIT;
EXCEPTION
    WHEN not_found THEN
        DBMS_OUTPUT.PUT_LINE('해당 학번의 학생이 존재하지 않습니다. 학번을 확인하세요.');
    WHEN already_absence THEN
        DBMS_OUTPUT.PUT_LINE('이미 휴학처리가 된 학생입니다.');
END;
/



CREATE OR REPLACE PROCEDURE 복학처리(i_id IN NUMBER, i_학번 IN VARCHAR, 신청일 IN DATE)
IS
    data_count NUMBER;
    absence TB_STUDENT.ABSENCE_YN%TYPE;
    not_found EXCEPTION;
    already_absence EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO data_count FROM TB_STUDENT WHERE STUDENT_NO = i_학번;
    IF data_count = 0 THEN
        RAISE not_found;
    END IF;

    SELECT ABSENCE_YN INTO absence FROM TB_STUDENT WHERE STUDENT_NO = i_학번;
    IF absence = 'N' THEN
        RAISE already_absence;
    END IF;

    UPDATE TB_STUDENT
       SET ABSENCE_YN = 'N'
     WHERE STUDENT_NO = i_학번;

    SELECT COUNT(*) INTO data_count FROM TB_ABSENCES WHERE ID = i_id AND 학번 = i_학번;
    IF data_count = 0 THEN
        RAISE not_found;
    END IF;

    UPDATE TB_ABSENCES
       SET 복학신청일 = 신청일
     WHERE ID = i_id
       AND 학번 = i_학번;

    COMMIT;
EXCEPTION
    WHEN not_found THEN
        DBMS_OUTPUT.PUT_LINE('복학 신청을 위한 데이터가 존재하지 않습니다. 신청번호와 학번을 확인하세요.');
        ROLLBACK;
    WHEN already_absence THEN
        DBMS_OUTPUT.PUT_LINE('이미 복학처리가 된 학생입니다.');
        ROLLBACK;
END;
/

EXEC 휴학처리('A031290', SYSDATE, 1);
EXEC 휴학처리('A031344', SYSDATE, 1);

EXEC 복학처리(31, 'A031290', SYSDATE);
EXEC 복학처리(29, 'A031344', SYSDATE);


SELECT * FROM TB_STUDENT;
SELECT * FROM TB_PROFESSOR;
SELECT * FROM TB_DEPARTMENT;
SELECT * FROM TB_ABSENCES;

/*
    TB_DEPARTMENT 테이블의 CATEGORY 범주에 속하는 학생들의 인원을 파악하기 위한 쿼리 작성
*/

SELECT B.CATEGORY
     , COUNT(*)
  FROM TB_STUDENT A JOIN TB_DEPARTMENT B
    ON A.DEPARTMENT_NO = B.DEPARTMENT_NO
 GROUP BY B.CATEGORY;


SELECT B.CATEGORY
     , B.DEPARTMENT_NAME
     , COUNT(*)
  FROM TB_STUDENT A JOIN TB_DEPARTMENT B
    ON A.DEPARTMENT_NO = B.DEPARTMENT_NO
 GROUP BY B.CATEGORY, ROLLUP(B.DEPARTMENT_NAME)
 ORDER BY B.CATEGORY;

/*
    학과별 학생수가 CAPACITY 컬럼의 정원과 얼마나 차이가 나는지 조회하기 위한 쿼리 작성
    정원 미달, 정원 초과, 정원 달성으로 구분으로 구분할 수 있게 하고 비율도 계산하여 조회될 수
    있게 한다.
*/
SELECT B.DEPARTMENT_NAME
     , B.CAPACITY AS 정원수
     , COUNT(*) AS 실제인원
     , CASE WHEN COUNT(*) > B.CAPACITY THEN '정원초과'
            WHEN COUNT(*) < B.CAPACITY THEN '정원미달'
            ELSE '정원달성'
        END AS 정원파악
     , ROUND(COUNT(*) / B.CAPACITY * 100, 2) AS 정원비율
  FROM TB_STUDENT A JOIN TB_DEPARTMENT B
    ON A.DEPARTMENT_NO = B.DEPARTMENT_NO
 GROUP BY B.DEPARTMENT_NAME, B.CAPACITY;

CREATE OR REPLACE FUNCTION FN_정원구분(인원수 NUMBER, 정원수 NUMBER) RETURN VARCHAR2
IS
BEGIN
    IF 인원수 > 정원수 THEN
        RETURN '정원초과';
    ELSIF 인원수 < 정원수 THEN
        RETURN '정원미달';
    ELSE
        RETURN '정원달성';
    END IF;
END;
/

CREATE OR REPLACE FUNCTION FN_PERCENTAGE(인원수 NUMBER, 정원수 NUMBER) RETURN NUMBER
IS
BEGIN
    RETURN ROUND(인원수 / 정원수 * 100, 2);
END;
/


SELECT B.DEPARTMENT_NAME
     , B.CAPACITY AS 정원수
     , COUNT(*) AS 실제인원
     , FN_정원구분(COUNT(*), B.CAPACITY) AS 정원파악
     , FN_PERCENTAGE(COUNT(*), B.CAPACITY) AS 정원비율
  FROM TB_STUDENT A JOIN TB_DEPARTMENT B
    ON A.DEPARTMENT_NO = B.DEPARTMENT_NO
 GROUP BY B.DEPARTMENT_NAME, B.CAPACITY;

