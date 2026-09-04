# Write your MySQL query statement below
select 
id,
case
    when id%2 = 1 and LEAD(student) over (order by id) is NOt null
        then LEAD(student) over (order by id)
    when id%2 = 0 
        then LAG(student) over(order by id)
    else student end as student
from Seat