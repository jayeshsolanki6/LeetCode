# Write your MySQL query statement below
select 
distinct num as ConsecutiveNums
from (
    select
    num,
    LAG(num) over(order by id) as one,
    LAG(num, 2) over(order by id) as two
    from Logs
) as x
where num = one and one = two