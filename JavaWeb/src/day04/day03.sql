CREATE DATABASE test01 SHOW DATABASES;
CREATE TABLE dept ( id INT PRIMARY KEY auto_increment, NAME VARCHAR ( 20 ) );
INSERT INTO dept ( id, NAME )
VALUES
	( 1, '研究部' ),
	( 2, '销售部' );
CREATE TABLE emp (
	id INT PRIMARY KEY auto_increment,
	NAME VARCHAR ( 20 ),
	gender CHAR ( 1 ),
	salary DOUBLE,
	join_date date,
	dept_id INT,
	FOREIGN KEY ( dept_id ) REFERENCES dept ( id ) 
);
INSERT INTO emp
VALUES
	( 1, '张三', '男', 9000, '2005-07-03', 1 );
SHOW TABLES;
SELECT
	* 
FROM
	emp INSERT INTO emp
VALUES
	( 5, '张大', '男', 9000, '2007-07-03', 1 ),
	( 2, '李四', '男', 7000, '2010-07-23', 2 ),
	( 3, '王五', '男', 10000, '2016-08-03', 2 ),
	( 4, '赵敏', '女', 8000, '2015-07-03', 2 );
SELECT
	* 
FROM
	emp,
	dept 
	
	--  隐式内连接去无效数据
SELECT
	* 
FROM
	emp,
	dept 
WHERE
	emp.dept_id = dept.id;
	
SELECT
	* 
FROM
	emp,
	dept;
SELECT
	t1.id,
	t1.`name`,
	t2.`NAME` 
FROM
	emp t1,
	dept t2 
WHERE
	t1.dept_id = t2.id;
	
	--  显式内连接去无效数据
SELECT
	* 
FROM
	emp
	INNER JOIN dept ON emp.dept_id = dept.id;
SELECT
	* 
FROM
	emp
	JOIN dept ON emp.dept_id = dept.id;	-- 去掉inner效果一样
	
	

-- 内连接隐式SELECT * FROM emp,dept where emp.dept_id = dept.id;
-- 内连接显式
Select * from emp Inner join dept on emp.dept_id = dept.id;
	
select * from dept
select * from emp
-- 左外连接 ---左表的全部加两表交集
select * from emp Left JOIN dept on	emp.dept_id = dept.id;   
-- 右外连接--- ---

select * from emp RIGHT JOIN dept on	emp.dept_id = dept.id;
	

-- ------------------ 子查询-----------------
select max(salary) from emp;

SELECT * FROM emp WHERE salary = 10000;

SELECT * FROM emp WHERE emp.salary =(SELECT max(salary) from emp);

Select * from emp where emp.salary < (select avg(salary) from emp);	

--   ---------------复习-----------------
select * from dept;
select * from emp;
--      隐式内连接-------

select * from dept,emp where dept.id=emp.dept_id;

--    隐式外连接------------

select * from emp INNER JOIN dept where dept.id=emp.dept_id;

--  显式左外连接   -----

select * from emp left Outer join dept on dept.id=emp.dept_id;   --  关键字 on

--  显式右外连接   -----

SELECT * FROM emp RIGHT JOIN dept on dept.id = emp.dept_id;

-- 查询员工是研究部，人事部的所有学生对象

select id from dept where `name` in('研究部','人事部');

select * from emp where emp.dept_id in (1,3);

--  子查询
select * from emp where emp.dept_id in (select id from dept where `name` in('研究部','人事部'));

-- 子查询多行多列
-- 使用类连接
select *from emp ,dept where join_date>'2010-1-1' and dept_id = dept.id;
-- 

select * from (select *from emp  where join_date>'2010-1-1') t1,dept t2 WHERE t1.dept_id = t2.id


alter table emp drop FOREIGN key  emp_ibfk_1;-- 删除外键
drop table emp


--   ----------------------事务------------------
create table account(
        id int primary key auto_increment,
        name VARCHAR(20),
				balance int );
SELECT *from account;

insert into account (name,balance) values('张三',1000),('李四',1000);

update account set balance =1000;

start TRANSACTION;
update  account set balance=balance-500 where name='张三';
sa
update  account set balance=balance+500 where name='李四';

COMMIT
ROLLBACK


use mysql;
select * from user;
create user 'zhansan'@'localhost' identified by '123456';


