SELECT distinct c.CAR_ID AS CAR_ID
FROM CAR_RENTAL_COMPANY_CAR c, CAR_RENTAL_COMPANY_RENTAL_HISTORY h
WHERE c.CAR_ID = h.CAR_ID AND c.CAR_TYPE LIKE '세단' AND MONTH(h.START_DATE) = 10
ORDER BY c.CAR_ID DESC