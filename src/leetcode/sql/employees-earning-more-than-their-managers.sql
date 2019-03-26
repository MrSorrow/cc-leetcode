-- 181. 超过经理收入的员工
-- https://leetcode-cn.com/problems/employees-earning-more-than-their-managers/
select e.Name as Employee
from Employee e
inner join
(select Id, Salary from Employee) as temp
on e.ManagerId = temp.Id
where e.Salary > temp.Salary;

-- 可以直接自己和自己连接
select e.Name as Employee
from Employee e
inner join
Employee temp
on e.ManagerId = temp.Id
where e.Salary > temp.Salary;
