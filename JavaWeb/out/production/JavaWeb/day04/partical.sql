-- ---------------day04 work------------
-- 部门表
CREATE TABLE dept (
  id INT PRIMARY KEY PRIMARY KEY, -- 部门id
  dname VARCHAR(50), -- 部门名称
  loc VARCHAR(50) -- 部门所在地
);

-- 添加4个部门
INSERT INTO dept(id,dname,loc) VALUES
(10,'教研部','北京'),
(20,'学工部','上海'),
(30,'销售部','广州'),
(40,'财务部','深圳');



-- 职务表，职务名称，职务描述
CREATE TABLE job (
  id INT PRIMARY KEY,
  jname VARCHAR(20),
  description VARCHAR(50)
);

-- 添加4个职务
INSERT INTO job (id, jname, description) VALUES
(1, '董事长', '管理整个公司，接单'),
(2, '经理', '管理部门员工'),
(3, '销售员', '向客人推销产品'),
(4, '文员', '使用办公软件');



-- 员工表
CREATE TABLE emp (
  id INT PRIMARY KEY, -- 员工id
  ename VARCHAR(50), -- 员工姓名
  job_id INT, -- 职务id
  mgr INT , -- 上级领导
  joindate DATE, -- 入职日期
  salary DECIMAL(7,2), -- 工资
  bonus DECIMAL(7,2), -- 奖金
  dept_id INT, -- 所在部门编号
  CONSTRAINT emp_jobid_ref_job_id_fk FOREIGN KEY (job_id) REFERENCES job (id),
  CONSTRAINT emp_deptid_ref_dept_id_fk FOREIGN KEY (dept_id) REFERENCES dept (id)
);

-- 添加员工
INSERT INTO emp(id,ename,job_id,mgr,joindate,salary,bonus,dept_id) VALUES
(1001,'孙悟空',4,1004,'2000-12-17','8000.00',NULL,20),
(1002,'卢俊义',3,1006,'2001-02-20','16000.00','3000.00',30),
(1003,'林冲',3,1006,'2001-02-22','12500.00','5000.00',30),
(1004,'唐僧',2,1009,'2001-04-02','29750.00',NULL,20),
(1005,'李逵',4,1006,'2001-09-28','12500.00','14000.00',30),
(1006,'宋江',2,1009,'2001-05-01','28500.00',NULL,30),
(1007,'刘备',2,1009,'2001-09-01','24500.00',NULL,10),
(1008,'猪八戒',4,1004,'2007-04-19','30000.00',NULL,20),
(1009,'罗贯中',1,NULL,'2001-11-17','50000.00',NULL,10),
(1010,'吴用',3,1006,'2001-09-08','15000.00','0.00',30),
(1011,'沙僧',4,1004,'2007-05-23','11000.00',NULL,20),
(1012,'李逵',4,1006,'2001-12-03','9500.00',NULL,30),
(1013,'小白龙',4,1004,'2001-12-03','30000.00',NULL,20),
(1014,'关羽',4,1007,'2002-01-23','13000.00',NULL,10);



-- 工资等级表
CREATE TABLE salarygrade (
  grade INT PRIMARY KEY,   -- 级别
  losalary INT,  -- 最低工资
  hisalary INT -- 最高工资
);

-- 添加5个工资等级
INSERT INTO salarygrade(grade,losalary,hisalary) VALUES
(1,7000,12000),
(2,12010,14000),
(3,14010,20000),
(4,20010,30000),
(5,30010,99990);

-- 需求：

-- 1.查询所有员工信息。查询员工编号，员工姓名，工资，职务名称，职务描述
select * from emp;
select * from job;
select * from emp,job where emp.job_id = job.id;
-- 2.查询员工编号，员工姓名，工资，职务名称，职务描述，部门名称，部门位置
select * from emp;
select * from job;
select *from dept;
select * from emp,job where emp.job_id = job.id;
select *from emp,dept where emp.dept_id = dept_id;

select * from dept,(select * from emp,job where emp.job_id = job.id) t2 WHERE dept.id = t2.dept_id;



SELECT emp.id,emp.`ename`,emp.salary,job.jname,job.description,dept.dname,dept.loc
	from
	emp,job,dept
		where emp.dept_id=dept.id and emp.job_id = job.id

select * from emp,dept WHERE emp.dept_id = dept.id AND (select * from emp,job where emp.job_id = job.id);
-- 3.查询员工姓名，工资，工资等级
select emp.ename,emp.salary,salarygrade.grade from emp,salarygrade
where emp.salary>salarygrade.losalary and emp.salary<salarygrade.hisalary;

-- 4.查询员工姓名，工资，职务名称，职务描述，部门名称，部门位置，工资等级

select emp.ename,emp.salary,job.jname,job.description,dept.dname,dept.loc,salarygrade.grade
from emp,dept,job,salarygrade
where 
emp.dept_id=dept.id and emp.job_id = job.id and emp.salary>=salarygrade.losalary and emp.salary<=salarygrade.hisalary;

-- 5.查询出部门编号、部门名称、部门位置、部门人数

select dept_id,t2.count(id) from emp GROUP BY dept_id;


select  
		t1.id,
		t1.dname,
		t1.loc,
		t2.total
from 
		dept t1,
		(select dept_id,count(id) total from emp GROUP BY dept_id) t2 
where 
     t1.id = t2.dept_id;

6.查询所有员工的姓名及其直接上级的姓名,没有领导的员工也需要查询


SELECT emp.id,emp.ename
FROM emp;


 select 
   t1.ename,
	 emp.ename
from
    emp,
		(SELECT emp.ename,emp.mgr from emp) t1
where
     emp.id=t1.mgr;
		 
		 
		 
select 
   t1.ename,
	 emp.ename
from
    emp RIGHT JOIN
		(SELECT emp.ename,emp.mgr from emp) t1
on
     emp.id=t1.mgr;
		 
		 
		 --  自关联
select 
  t1.ename,
	t2.ename
 from
    emp t1 LEFT JOIN emp t2
 on t1.mgr = t2.id;
		 
		
	
	
--  ----------------------day04--------------------
create table sell(
           id int Primary key,    -- 工号
					 name varchar(20),    -- 姓名
					 sellnumbers int ,       -- 销售房源
					 sellmoney int ,          -- 销售额
					 money int                 -- 工资
);
select * from sell;
insert into sell 
					(id,name,sellnumbers,sellmoney,money) 
VALUES 
         (1,'郭凤芝',3,900000,8000),
				 (2,'李清风',1,250000,5000),
				 (3,'杨晓初',0,0,4000),
				 (4,'霍币',5,1000000,6000),
				 (5,'宋明',6,1200000,5000),
				 (6,'杨洋',2,502000,7000);

-- 1.写出创建selldb数据库，及按照以上格式创建sell表的sql语句
-- 2.写出sql语句完成以上表格中数据的插入


-- 5.写出删除10月份0销售额的员工（sql语句）


-- 3.写出统计10月份“我爱你家”一共销售了多少套房源以及总销售额（sql语句）
select 
    sum(sellnumbers), -- 套房，
		sum(sellmoney) -- 销售额
from
     sell;

select 
   avg(sellmoney)
from
     sell;

-- 4.写出计算低于平均销售额的员工姓名输出到控制台上（sql语句）
select
   sell.name
from
     sell
WHERE
	sellmoney<(select avg(sellmoney) from sell);


-- 5.写出删除10月份0销售额的员工（sql语句）
delete from sell where sellmoney=0;
SELECT*from sell;















