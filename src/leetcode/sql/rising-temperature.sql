# 197. 上升的温度
# https://leetcode-cn.com/problems/rising-temperature/

create table Weather (
  `Id` int(11) primary key,
  `RecordDate` DATE,
  `Temperature` int(11)
) engine innodb;
insert into Weather values (1, "2015-01-01", 10), (2, "2015-01-02", 25), (3, "2015-01-03", 20), (4, "2015-01-04", 30);


select w1.Id as Id from Weather w1
inner join Weather w2
on DATEDIFF(w1.RecordDate, w2.RecordDate) = 1 and w1.Temperature > w2.Temperature;


select w1.Id as Id from Weather w1
inner join Weather w2
on w1.RecordDate = date_add(w2.RecordDate, interval 1 day) = 1 and w1.Temperature > w2.Temperature;