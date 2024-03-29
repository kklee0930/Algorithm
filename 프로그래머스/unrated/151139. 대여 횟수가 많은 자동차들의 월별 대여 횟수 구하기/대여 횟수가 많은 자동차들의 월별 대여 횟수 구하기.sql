SELECT MONTH(HISTORY.START_DATE) AS MONTH, HISTORY.CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY HISTORY
WHERE HISTORY.CAR_ID IN (
    # 2022-08에서 2022-10까지의 총 대여 횟수가 5회 이상인 자동차아이디 추출
    SELECT H.CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
    WHERE DATE_FORMAT(H.START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
    GROUP BY H.CAR_ID
    HAVING COUNT(*) >= 5
) AND DATE_FORMAT(HISTORY.START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
GROUP BY MONTH, HISTORY.CAR_ID
HAVING COUNT(*) != 0
ORDER BY MONTH, CAR_ID DESC