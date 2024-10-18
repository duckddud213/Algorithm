-- 코드를 입력하세요
select a.author_id, a.author_name, b.category, SUM(s.sales * b.price) AS TOTAL_SALES
from author a, book b, book_sales s
where a.author_id = b.author_id and b.book_id = s.book_id and YEAR(sales_date) = 2022 and MONTH(sales_date) = 1
# and a.author_name like '홍길동'
group by a.author_id, a.author_name, b.category
order by a.author_id asc, b.category desc
