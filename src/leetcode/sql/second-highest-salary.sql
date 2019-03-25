-- 176. 第二高的薪水
-- https://leetcode-cn.com/problems/second-highest-salary/
select
ifnull((select distinct Salary from Employee order by Salary desc limit 1, 1), null)
as SecondHighestSalary;