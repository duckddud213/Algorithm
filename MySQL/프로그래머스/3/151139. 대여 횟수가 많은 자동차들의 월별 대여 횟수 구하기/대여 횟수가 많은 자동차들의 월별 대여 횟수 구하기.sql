# SELECT *
SELECT MONTH(START_DATE) AS MONTH, CAR_ID, count(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE BETWEEN '2022-08-01' AND '2022-11-01'
    AND CAR_ID IN(
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE START_DATE BETWEEN '2022-08-01' AND '2022-11-01'
        GROUP BY CAR_ID
        HAVING count(CAR_ID) >= 5)
GROUP BY CAR_ID, MONTH(START_DATE)
HAVING RECORDS >= 1
ORDER BY MONTH ASC, CAR_ID DESC