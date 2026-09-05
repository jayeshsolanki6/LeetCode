# Write your MySQL query statement below
(
    select u.name as results
    from users u join movierating m on u.user_id = m.user_id
    group by u.user_id
    order by count(*) desc, u.name asc
    limit 1
)
union all
(
    select m.title
    from movies m join movierating mr on m.movie_id = mr.movie_id
    where month(mr.created_at) = 2 and year(mr.created_at) = 2020
    group by m.movie_id
    order by avg(mr.rating) desc, m.title asc
    limit 1
)