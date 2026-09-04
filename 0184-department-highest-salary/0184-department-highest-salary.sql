# Write your MySQL query statement below

select 
Department, 
Employee, 
salary
from (
    select 
    d.name as Department,
    e.name as Employee,
    e.salary,
    Dense_rank() over(partition by d.id order by e.salary desc) as rnk 
    from
    Department d join Employee e on d.id = e.departmentId
) as x
where rnk = 1;