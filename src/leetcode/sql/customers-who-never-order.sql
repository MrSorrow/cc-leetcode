# 183. 从不订购的客户
# https://leetcode-cn.com/problems/customers-who-never-order/

# 表
CREATE TABLE `customers` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

create table `orders` (
  `Id` int(11) not null auto_increment,
  `CustomerId` int(11) not null,
  primary key (`Id`)
) ENGINE=InnoDB DEFAULT charset=utf8;
INSERT INTO orders VALUES (1,3), (2,1);


# not in的方法
select Name as Customers from Customers c where c.Id not in (select CustomerId from Orders);

# 连接的方式
select temp.Name as Customers from
(select c.Id, c.Name, o.CustomerId from Customers c
left join Orders o
on c.Id = o.CustomerId) as temp
where temp.CustomerId is null;
