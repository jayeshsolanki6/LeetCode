# Write your MySQL query statement below
select 
user_id as buyer_id, 
join_date, 
count(o.order_id) as orders_in_2019
from Users u 
left join Orders o on u.user_id = o.buyer_id
and YEAR(o.order_date) = '2019'
group by u.user_id