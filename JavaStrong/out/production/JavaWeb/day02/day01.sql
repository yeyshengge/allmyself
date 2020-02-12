SELECT * FROM student01
show tables;
use student01;
update student01 set english=59 where id =5;
update student01 set sum =math+english where id in(2,3,4,5,6,7,8);
alter table student01 add insert_time TIMESTAMP;
insert into student01 (id,name) VALUES (11,'剑圣');
select * from student01 where age like '%5%';
alter table student01 change id uid varchar(20)
alter table student01 add idcard int after name;
update student01 set idcard = 19980521 where uid=1;
alter table student01 modify idcard varchar(20);
alter table student01 change uid id int;