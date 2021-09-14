-- 다음의 테이블이 있는지 확인 후 진행(없으면 만들어야 함.)
DROP TABLE 지출내역서T;
CREATE TABLE 지출내역서T (
      날짜      DATE
    , 입금액    NUMBER
    , 출금액    NUMBER
    , 비고      VARCHAR(300)
);

SELECT * FROM 지출내역서T;

INSERT INTO 지출내역서T VALUES(SYSDATE, 1000, 0, '용돈');
INSERT INTO 지출내역서T VALUES(SYSDATE, 0, 100, '과자');
INSERT INTO 지출내역서T VALUES(SYSDATE, 0, 100, '과자');

INSERT INTO 지출내역서T(날짜, 입금액, 비고) VALUES(SYSDATE, 200, '용돈');
INSERT INTO 지출내역서T(비고, 출금액, 날짜) VALUES('볼펜구입', 100, SYSDATE);
INSERT INTO 지출내역서T(비고, 출금액, 날짜) VALUES('연필구입', 100, TO_DATE('2021-09-12', 'YYYY-mm-dd'));
--INSERT INTO 지출내역서T(비고, 출금액, 날짜) VALUES('지우개구입', 100, '2021-09-21');
--Error 날짜 데이터를 다룰 때에는 타입에 맞추어야한다.

UPDATE 지출내역서T
   SET 출금액 = 0
 WHERE 출금액 IS NULL;

 UPDATE 지출내역서T
    SET 입금액 = 0
 WHERE 입금액 IS NULL;

 UPDATE 지출내역서T
    SET 입금액 = 2000
 WHERE 비고 = '용돈'
    AND 입금액 = 1000;

UPDATE 지출내역서T
   SET 날짜 = TO_DATE('2021-09-10', 'yyyy-mm-dd')
    , 출금액 = 출금액 + 50
 WHERE 비고 IN('볼펜구입', '연필구입'); -- 비고 LIKE '__구입';

DELETE FROM 지출내역서T
 WHERE 입금액 = 2000
   AND 비고 = '용돈';
   

 SELECT * FROM 지출내역서T;

