-- 175. 组合两个表
-- https://leetcode-cn.com/problems/combine-two-tables/
select FirstName, LastName, City, State from Person
left join Address
on Person.PersonId = Address.PersonId;