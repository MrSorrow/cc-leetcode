# 196. 删除重复的电子邮箱
# https://leetcode-cn.com/problems/delete-duplicate-emails/

create table Person (
  `Id` int(11) auto_increment,
  `Email` varchar(20),
  primary key (`Id`)
) engine innodb;
insert into Person values (1, 'john@example.com'), (2, 'bob@example.com'), (3, 'john@example.com');

# group by去重，去重查询是这个，但题意是让删除重复的
select * from Person group by Email order by Id asc;

# 删除√
delete from Person
where Id in
(select Id from
  (select q.Id from Person p inner join Person q on p.Email = q.Email and p.Id < q.Id) as temp
);

# 这种删除还是有点问题，主要学习创建临时表的方式
delete from Person
where Id in
(select Id from
  (select * from Person group by Email) as temp
);

# 多表连接删除
delete p from Person p, Person q
where p.Email = q.Email and p.Id > q.Id;