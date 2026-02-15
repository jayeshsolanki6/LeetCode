# Write your MySQL query statement below
with maxNum as (
    select num from MyNumbers
    group by num
    having count(*) = 1
    order by num desc
)
select max(num) as num from maxNum