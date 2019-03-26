-- 182. 查找重复的电子邮箱
-- https://leetcode-cn.com/problems/duplicate-emails/

-- 思路1：利用groupby分组选出大于一个记录的
select Email from Person group by Email having count(id) > 1;

-- 思路2：连接表，选出邮箱一致，id不同的元素，并去重
select distinct Email from Person p
inner join
Person q
on p.Email = q.Email and p.Id <> q.Id;