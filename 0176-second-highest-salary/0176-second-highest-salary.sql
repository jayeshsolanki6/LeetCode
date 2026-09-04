# Write your MySQL query statement below
select 
(select 
    MAX(salary)
    from (
        select
        *, 
        DENSE_RANK() OVER(order by salary desc) as rnk
        from Employee
    ) as x
    where rnk = 2
) as SecondHighestSalary 