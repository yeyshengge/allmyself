SELECT * FROM student01;
select * from student01 ORDER BY math asc;  -- 默认升序
select * from student01 ORDER BY english desc;  -- 降序
select * from student01 ORDER BY math asc,english desc;
select count(id) from student01; -- 查询id有多少个
SELECT COUNT(IFNULL(age,0)) FROM student01;
Select count(*) from student01;
Select sum(math) from student01;  -- 查询某一列的和
select avg(math) from student01  -- 查询平均分  
SELECT   max(math) from student01 -- 查询最大值
SELECT  * from student01 where math=99
select min(english) from student01    -- 查询最小值
select  sex,avg(math),count(id) from student01 GROUP BY sex;    -- 分组
select sex,avg(math) from student01  where math>80  GROUP BY sex;  -- 给分组加个条件
select sex ,count(id) 人数 ,avg(math) from student01 where math>80 GROUP BY sex HAVING 人数>2 ;
select * from student01 LIMIT 0,5 -- 第一页
select * from student01 LIMIT 5,5 -- 第二页
select * from student01 LIMIT 10,5 -- 第三页     当前索引 = （ 当前页数 - 1 ）* 每页显示的条数
--  新建表--- 非空约束
create table stu ( id int  ,
                            name varchar(20)
														);
select * from stu;
alter table stu MODIFY name VARCHAR(20) not null
insert stu (id,name) values (1,'迪丽热巴');
insert stu (id,name) values (2,'');
alter table stu modify name Varchar(20);
alter table stu modify id int not null;
desc stu;
-- --------新建phone表---唯一约束----
create table phone(
       name varchar(20),
			 phone_num int 
			           );
select * from phone;
alter table phone change phone_num phone_num varchar(20);
insert phone (name,phone_num) values('张三',13812345678);
insert phone (name,phone_num) values('张三',13812345678);
alter table phone MODIFY phone_num Varchar(20) UNIQUE;
alter table phone Drop index phone_num;
desc phone;
alter table phone MODIFY phone_num Varchar(20) UNIQUE
drop table phone;
drop table stu;

-- -------新建学生表-----主键约束--------

create table stu(
          id int  PRIMARY key,
					name varchar(20)
					   );
select * from stu;
alter table stu drop PRIMARY key;
alter table stu MODIFY id int PRIMARY KEY

-- -----外键约束------
CREATE table depart(
     id int  primary key auto_increment,
		 name VARCHAR(20)
		 );
INSERT into depart (id,name) VALUES(1,'研发部');
INSERT into depart (id,name) VALUES(2,'销售部');

CREATE TABLE emp(
        id int PRIMARY key auto_increment,
			  name varchar(20),
				depart_id int,
			  CONSTRAINT fk FOREIGN KEY (depart_id) REFERENCES depart(id) --添加外键
				-- -----（随便取个名字）-----（与自己字段相同）----------（要关联的表（关联表中的主键））  
);
INSERT into emp (id,name,depart_id) VALUES(1,'张三',1);
INSERT into emp (id,name,depart_id) VALUES(2,'张三',1);
 
select * FROM depart;
select * FROM emp;

insert into emp (id,name,depart_id) VALUES (3,'李四',2);

alter table emp drop FOREIGN key fk; -- 删除主键

insert into emp (id,name,depart_id) VALUES (4,'李四',5);
   --  ----------增加主键
alter table emp add CONSTRAINT fk FOREIGN Key (depart_id) REFERENCES depart(id);

desc emp;
desc depart;

-- ------------级联操作-----------
alter table emp drop FOREIGN key fk; -- 删除主键
alter table emp add CONSTRAINT fk FOREIGN key (depart_id) REFERENCES depart(id) on UPDATE CASCADE;   --  增加主键并且添加联级更新
select * from depart
update depart set id = 5 WHERE id=1; 

alter table emp drop FOREIGN key fk;
alter table emp add CONSTRAINT fk FOREIGN key (depart_id) REFERENCES depart(id) on UPDATE CASCADE on DELETE CASCADE;

SELECT * from depart
UPDATE depart set  id = 1 WHERE id =5;
DELETE from depart  WHERE id = 1;


-- -----------------案例--------------------------
create table  lxfl(
               lxfl_id int primary key auto_increment,
							 lxfl_name varchar(20) not null unique
							 );
CREATE table lx(
               lx_id int PRIMARY key auto_increment,
							 lx_name VARCHAR(20),
							 lxfl_id int,
							 FOREIGN key (lxfl_id) REFERENCES lxfl(lxfl_id)
               );
CREATE TABLE user(
              user_id int PRIMARY key auto_increment,
							user_username varchar(20) not null UNIQUE,
							user_password int not null,
							user_phone VARCHAR(11)
							);
Create table user_lx(
              user_id int ,
							lx_id int ,
              PRIMARY key(user_id,lx_id),
							FOREIGN key(user_id) REFERENCES user(user_id),
							FOREIGN key(lx_id) REFERENCES lx(lx_id)
							);	  
										
drop table lx;
drop table lxfl;
drop table user;

show tables;





