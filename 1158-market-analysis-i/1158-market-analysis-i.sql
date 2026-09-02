# Write your MySQL query statement below
-- select 
-- user_id as buyer_id, join_date, 
-- sum(case when item_id is not null then 1 else 0 end) as orders_in_2019
-- from Users u left join Orders o on u.user_id = o.buyer_id
-- where YEAR(o.order_date) = '2019'
-- group by u.user_id

select 
user_id as buyer_id, 
join_date, 
(select count(*) from Orders where buyer_id = user_id and YEAR(order_date) = '2019') as orders_in_2019
from Users
