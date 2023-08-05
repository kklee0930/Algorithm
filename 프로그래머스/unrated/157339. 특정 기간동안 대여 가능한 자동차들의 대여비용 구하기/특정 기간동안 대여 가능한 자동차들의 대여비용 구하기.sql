SELECT C.CAR_ID, C.CAR_TYPE, FLOOR(C.DAILY_FEE * (100 - P.DISCOUNT_RATE) / 100 * 30) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C 
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P 
ON C.CAR_TYPE = P.CAR_TYPE
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H 
ON C.CAR_ID = H.CAR_ID
WHERE C.CAR_TYPE IN ('세단', 'SUV') AND P.DURATION_TYPE = '30일 이상'
GROUP BY C.CAR_ID
HAVING (MAX(END_DATE) < '2022-11-01') AND (FEE BETWEEN 500000 AND 2000000)
ORDER BY FEE DESC, C.CAR_TYPE, C.CAR_ID DESC