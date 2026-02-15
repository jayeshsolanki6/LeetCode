# Write your MySQL query statement be
with firstYear as (
    select product_id, min(year) as year from Sales
    group by product_id
)

select product_id, year as first_year, quantity, price from Sales s
where (product_id, year) in (select product_id, year from firstYear)