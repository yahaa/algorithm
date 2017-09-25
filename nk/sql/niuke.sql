# 1
select * from employees where hire_date=(select max(hire_date) from employees);
# 2
select * from employees order by desc limit 2,1;
# 2 mul
select * from employees where hire_date=(select hire_date from employees order by hire_date desc limit 2,1);
# 3
select salaries.emp_no,salaries.salary,salaries.from_date,salaries.to_date,dept_manager.dept_no from salaries,dept_manager 
where dept_manager.emp_no=salaries.emp_no and salaries.to_date='9999-01-01' and dept_manager.to_date='9999-01-01';

# 3
select s.*,d.dept_no from salaries s,dept_manager d 
where s.to_date='9999-01-01' 
and d.to_date='9999-01-01' 
and s.emp_no=d.emp_no;

# 4
select e.last_name,e.first_name,d.dept_no from employees e left join dept_emp d
where e.emp_no=d.emp_no;

# 5
select e.emp_no,s.salary from employees e,salaries s 
where s.emp_no=e.emp_no and e.hire_date=s.from_date order by e.emp_no desc;

# 6
select a.* from(select emp_no,count(*) as t from salaries group by emp_no) as a where t>15

# 7
select distinct salary from salaries where to_date='9999-01-01' order by salary desc;
# 8
select d.dept_no,d.emp_no,s.salary from dept_manager d,salaries s
where d.emp_no=s.emp_no and d.to_date=s.to_date and s.to_date='9999-01-01';

#9
select emp_no from employees where emp_no not in (
select emp_no from dept_manager);

# 10
select de.emp_no emp_no,dm.emp_no manager_no from dept_emp de,dept_manager dm
where de.dept_no=dm.dept_no and de.emp_no !=dm.emp_no and
dm.to_date=de.to_date and de.to_date='9999-01-01';


# 12
select de.dept_no dept_no,de.emp_no emp_no ,max(s.salary) salary from dept_emp de,salaries s
where de.emp_no=s.emp_no and de.to_date='9999-01-01' and s.to_date='9999-01-01' group by de.dept_no;

#13 
select t.* from (select title,count(*) t from titles group by title) as t where t.t>=2;

# 14
select title,count(distinct emp_no) t from titles group by title having t>=2;

# 15
select * from employees where emp_no%2=1 and last_name!='Mary' order by hire_date desc;

# 16
select t.title,avg(s.salary)  from salaries s,titles t
where t.emp_no=s.emp_no and s.to_date='9999-01-01' and t.to_date='9999-01-01'
group by t.title;


# 17
select emp_no,salary from salaries order by salary desc limit 1,1;


# 18
select e.emp_no,max(s.salary) salary,e.last_name,e.first_name 
from employees e,salaries s where e.emp_no=s.emp_no and
s.to_date='9999-01-01' and salary!=(select max(salary) from salaries where to_date='9999-01-01');

# 19
select e.last_name,e.first_name,dp.dept_name from employees e left join dept_emp de on e.emp_no=de.emp_no
left join departments dp on de.dept_no=dp.dept_no;

# 20
select ((select salary from salaries where emp_no=10001 order by to_date desc limit 1)-
(select salary from salaries where emp_no=10001  order by to_date limit 1)) as growth;

# 21
select a.emp_no, a.salary-b.salary as growth from 
(select e.emp_no,s.salary from employees e, salaries s where e.emp_no=s.emp_no and s.to_date='9999-01-01') as a,
(select e.emp_no,s.salary from employees e, salaries s where e.emp_no=s.emp_no and e.hire_date=s.from_date)
 as b where a.emp_no=b.emp_no order by growth;

 # 22

select dp.dept_no,dp.dept_name,count(s.salary) from dept_emp de inner join salaries s on de.emp_no=s.emp_no
inner join departments dp on de.dept_no=dp.dept_no group by dp.dept_no; 

# 23  very important
select s1.emp_no,s1.salary,count(distinct s2.salary) rank from 
salaries s1,salaries s2 where s1.to_date=s2.to_date and s1.to_date='9999-01-01'
and s1.salary<=s2.salary group by s1.emp_no order by rank;

# 24

select de.dept_no,e.emp_no,s.salary from employees e ,dept_emp de,salaries s where e.emp_no=de.emp_no and s.emp_no=e.emp_no
and e.emp_no not in (select emp_no from dept_manager) and s.to_date='9999-01-01' and de.to_date='9999-01-01'; 

# 25
select a.emp_no emp_no,dm.emp_no manager_no,a.salary emp_salary,s2.salary manager_salary from 
(select de.emp_no,de.dept_no,s1.salary from dept_emp de,salaries s1 where de.emp_no=s1.emp_no and s1.to_date='9999-01-01') as a
,dept_manager as dm,salaries as s2 where
dm.dept_no=a.dept_no and dm.emp_no=s2.emp_no and a.salary>s2.salary and s2.to_date='9999-01-01';

# 26 ********
SELECT de.dept_no, dp.dept_name, t.title, COUNT(t.title) AS count
FROM titles AS t INNER JOIN dept_emp AS de
ON t.emp_no = de.emp_no AND de.to_date = '9999-01-01' AND t.to_date = '9999-01-01'
INNER JOIN departments AS dp
ON de.dept_no = dp.dept_no
GROUP BY de.dept_no, t.title

# 27  *******
SELECT s2.emp_no, s2.from_date, (s2.salary - s1.salary) AS salary_growth
FROM salaries AS s1, salaries AS s2
WHERE s1.emp_no = s2.emp_no 
AND salary_growth > 5000
AND (strftime("%Y",s2.to_date) - strftime("%Y",s1.to_date) = 1 
     OR strftime("%Y",s2.from_date) - strftime("%Y",s1.from_date) = 1 )
ORDER BY salary_growth DESC

# 28
select c.name,count(fc.film_id) as t from film f,category c,film_category fc
where f.description like '%robot%' and f.film_id=fc.film_id
and fc.category_id=c.category_id group by c.category_id having t>=2;

# 29

select f.film_id,f.title from film f where f.film_id not in 
(select film_id from film_category);

select ff.film_id,ff.title from (select f.film_id,f.title ,fc.category_id from film f left join film_category fc on f.film_id=fc.film_id) as ff
where ff.category_id is null;


# 30
select title,description from film where
film_id in (select film_id from film_category where 
category_id in (select category_id from category where name='Action'));

select f.title,f.description from film f inner join 
film_category fc on f.film_id=fc.film_id inner join 
category c on fc.category_id=c.category_id where c.name='Action';

# 31
explain plan for select * from employees;

# 32
SELECT last_name||" "||first_name AS Name FROM employees;   #sqllite
select contact(first_name," ",last_name) from employees;    #mysql

# 33
create table actor(
    actor_id smallint(5) not null,
    first_name varchar(45) not null,
    last_name varchar(45) not null,
    last_update timestamp not null DEFAULT (datetime('now','localtime')),
    primary key(actor_id)
);   

# 34
INSERT INTO actor
VALUES (1, 'PENELOPE', 'GUINESS', '2006-02-15 12:34:33'),
(2, 'NICK', 'WAHLBERG', '2006-02-15 12:34:33');

# 35
insert or ignore into actor
values(3,'ED','CHASE','2006-02-15 12:34:33');

# 36
create table actor_name as select first_name,last_name from actor;


# 37
CREATE UNIQUE INDEX uniq_idx_firstname ON actor(first_name);
CREATE INDEX idx_lastname ON actor(last_name);

# 38
create view actor_name_view as select first_name fist_name_v,last_name last_name_v from actor;


# 39 
# mysql 
SELECT * FROM salaries FORCE INDEX idx_emp_no WHERE emp_no = 10005;
# sqllite
SELECT * FROM salaries INDEXED BY idx_emp_no WHERE emp_no = 10005;

# 40
alter table actor add create_date datetime not null default '0000-00-00 00:00:00';


# 41
create trigger audit_log after insert on employees_test
begin
     insert into audit values(new.id,new.name);
end;

-- 1.create trigger ：创建触发器
-- 2.触发器要说明是在after 还是before事务发生时触发
-- 3.要指明是insert 、delete、update操作
-- 4. on 表名
-- 5.begin和end之间写触发的动作
-- 6. new 关键字表示更新后的表的字段 ，old表示更新前的表的字段 

# 42
DELETE FROM titles_test
WHERE id NOT IN (
  SELECT
    min(id) AS id
  FROM titles_test
  GROUP BY emp_no);


# 43
update titles_test set to_date=NULL,from_date='2001-01-01' where to_date='9999-01-01';


# 44
UPDATE titles_test SET emp_no = REPLACE(emp_no,10001,10005) WHERE id = 5;

# 45
alter table titles_test rename to titles_2017;

# 46

# sqllite
DROP TABLE audit;
CREATE TABLE audit(
    EMP_no INT NOT NULL,
    create_date datetime NOT NULL,
    FOREIGN KEY(EMP_no) REFERENCES employees_test(ID));

# mysql 
-- 实际mysql使用ALTER添加外键的语句表达式为：ALTER TABLE tablename ADD FOREIGN KEY...REFERENCES...


# 47

select * from emp_v;


# 48
update salaries set salary=salary*1.1
where  to_date='9999-01-01';

# 49
SELECT 'select count(*) from "||name||";" AS cnts FROM sqlite_master WHERE type="table"';


# 50
select last_name||"'"||first_name as name from employees; 

# 51
select (length('10,A,B')-length(replace('10,A,B',',','')))/length(',') as cnt

# 52
select first_name from employees order by substr(first_name,-2);

# 53
SELECT dept_no, group_concat(emp_no)
FROM dept_emp GROUP BY dept_no

# 54
select avg(salary) from salaries where to_date='9999-01-01'
and salary != (select max(salary) from salaries)
and salary != (select min(salary) from salaries)

# 55
select *
from employees as e
limit 5 , 5;







