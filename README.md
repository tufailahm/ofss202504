"# ofss202504" 

oracle 23ai
SQL Plus
https://codeshare.io/tufail

Download , Unzip and Install
Please give password as root
https://download.oracle.com/otn-pub/otn_software/db-express/WINDOWS.X64_238000_free.zip

https://www.oracle.com/database/sqldeveloper/technologies/download/


Download and unzip (No need to install)
// DIRECT LINK (jdk included)
https://download.oracle.com/otn_software/java/sqldeveloper/sqldeveloper-24.3.1.347.1826-x64.zip


Create table products
(
	pId number primary key,
	ssnCode number primary key
)

Error 


SELECT last_name, department_id, salary
FROM   employees
WHERE  department_id = 60
OR     department_id = 80
AND    salary > 10000;

1.	Precedence of the AND Operator: Example 
	In this example, there are two conditions:
The first condition is that the department ID is 80 and the salary is greater than $10,000.
The second condition is that the department ID is 60.
	Therefore, the SELECT statement reads as follows:
	“Select the row if an employee’s department ID is 80 and earns more than $10,000, or if the employee’s department ID is 60.”

SELECT last_name, department_id, salary
FROM   employees
WHERE  (department_id = 60
OR     department_id = 80)
AND    salary > 10000;

2.	Using Parentheses: Example 
	In this example, there are two conditions:
The first condition is that the department ID is 80 or 60.
The second condition is that the salary is greater than $10,000.
	Therefore, the SELECT statement reads as follows:
	“Select the row if an employee’s department ID is 80 or 60, and if the employee earns more than $10,000.”



12-09-25

12-06-11


https://ouconnect.oracle.com/







Enter in user name: 98762526.user01 ... 98762526.user30
Enter in password: 7MTGUYY62r (same for all users)





























select * from departments;

select * from employees;


select employee_id,first_name,salary,department_id from employees;

select sysdate from dual;

select 2+2;

select * from dual;


//Hands on
Print employee_id,first_name, salary, commission_pct
select employee_id, first_name , salary, commission_pct from employees;

//Hands on
select employee_id, first_name , salary, salary+.20*salary , commission_pct from employees;


select employee_id, first_name , salary,  commission_pct from employees;

//Monthly Drawn salary
select employee_id, first_name, salary, commission_pct, salary + commission_pct*salary as "Monthly Salary" from employees;

--Any expression that involves null VALUES, will return NULL only - Solution Later

select employee_id, first_name, salary, commission_pct, salary + commission_pct*salary Monthly from employees;

select employee_id, first_name, salary, commission_pct, salary + commission_pct*salary "Monthly Salary" from employees;

select employee_id, first_name, salary, commission_pct, salary + commission_pct*salary as "Monthly Salary" from employees;

SELECT	first_name || ' ' || last_name as "Full name" FROM 	employees;


SELECT department_name || q'[ Department's Manager Id: ]'
       || manager_id 
       AS "Department and Manager" 
FROM departments;

select department_id from employees;

select distinct department_id from employees;

describe employees;


select * from employees where department_id is NULL;

select * from employees where department_id = 100;


select * from employees where department_id in( 100,110);

select * from employees where salary between 10000 and 20000

select * from employees where salary not between 10000 and 20000


select * from employees where first_name = 'David' AND salary<10000;

select * from employees where first_name = 'david' AND salary<10000;        -- Solution  Later


SELECT	first_name
FROM 	employees
WHERE	first_name LIKE 'S%' ;

SELECT	first_name
FROM 	employees
WHERE	first_name LIKE '%A%' ; -- fetch A from anywhere 


SELECT	first_name
FROM 	employees
WHERE	first_name LIKE 'A%' ;  -- start fom A 


SELECT	first_name
FROM 	employees
WHERE	first_name LIKE '__a%' ;  --second 


select * from employees where first_name = 'David' order by job_id, salary desc;

---OFFSET and FETCH
 SELECT employee_id, first_name
 FROM employees
 ORDER BY employee_id
 OFFSET 5 ROWS FETCH NEXT 5 ROWS ONLY;



SELECT employee_id, last_name, salary, department_id
FROM   employees
WHERE  employee_id = &employee_num ;

---

SELECT employee_id, last_name, job_id,&column_name
FROM   employees
WHERE  &condition
ORDER BY &order_column ;


SELECT   employee_id, last_name, job_id, &&column_name
FROM     employees
ORDER BY &column_name ;

--------------------
DEFINE employee_num = 100

SELECT employee_id, last_name, salary, department_id
FROM   employees
WHERE  employee_id = &employee_num ;

UNDEFINE employee_num

----------------------
--GET ALL EMPLOYEES WHO WORKS IN Department_id =100 but not having job_id 'IT_PROG' and salary > 5000,
--also hired after '01-01-2003'



select * from employees where department_id = 100 and NOT job_id = 'IT_PROG' and salary > 5000 and hire_date>'01-01-2003';

select * from employees where department_id = 100 and job_id != 'IT_PROG' and salary > 5000 and hire_date>'01-01-2003';
SELECT * from employees WHERE (DEPARTMENT_ID = 100 AND job_id <> 'IT_PROG') AND salary > 5000 AND hire_date > '01-01-2003';

select * from employees where department_id = 100 and job_id not like 'IT_PROG' and salary > 5000 and hire_date > '01-01-2003';

select * from employees
where department_id = 100 and job_id <> 'IT_PROG' and salary > 5000 and hire_date > '01-01-2003';


select * from employees where department_id=100 and job_id not in ('IT_PROG') and salary>5000 and hire_date>'01-01-2003';


---Character functions

select * from employees where lower(first_name) = 'david' AND salary<10000;      

select * from employees where upper(first_name) = 'DAVID' AND salary<10000;      

select substr(first_name,2) from employees where lower(first_name) = 'david' AND salary<10000;      

SELECT employee_id AS Even_Numbers, last_name
FROM employees 
WHERE MOD(employee_id,2) == 0;

select sysdate ;



select first_name,hire_date from employees order by hire_date;

select first_name,hire_date from employees order by hire_date desc;


--Hands - on
first_name   Exp(Age)

David          21


SELECT last_name, (SYSDATE-hire_date)/7 AS WEEKS
FROM   employees
WHERE  department_id = 90;

select first_name|| ' '||last_name as Name, round((sysdate - hire_date)/365) as Experience from employees; 

select first_name, trunc((sysdate - hire_date) / (7*52),0) as Exp from employees;

---Print your age
select ROUND(MONTHS_BETWEEN(sysdate,'12-03-93')/12)


select round(sysdate - ('04-05-03')/365);


select round((sysdate - to_date('04-05-03'))/365);


select 








select substr(salary,(length(salary)-2),2) from employees;

select to_char(salary) from employees;


select salary from employees;

Real Time : 

Char --> Number

191818


select employee_id from employees;

select 'A' || employee_id from employees;

select concat ('A' ,to_char(employee_id)) from employees;


----
NVL 

select employee_id, first_name, salary, 
NVL(commission_pct,0), 
salary+NVL(commission_pct,0)*salary as "Monthly Salary" from employees;

select employee_id,first_name,NVL(manager_id,'A') from employees

NVL2 --------

select first_name,salary,commission_pct , NVL2(commission_pct, 'Hello','Bye')
from employees;

select first_name,salary,commission_pct , NVL2(commission_pct, 11,99)
from employees;
select first_name,salary,commission_pct , NVL2(commission_pct, 88,'99')
from employees;
select first_name,salary,commission_pct , NVL2(commission_pct, 'A',99)
from employees;
select first_name,salary,commission_pct , NVL2(commission_pct, 99,'A')
from employees;

select first_name,salary,commission_pct , NVL2(spouse_name,sal+insu, sal)
from employees;


----COALESCE

--Person1
SELECT last_name, salary, commission_pct,
COALESCE((salary+(commission_pct*salary)), salary+2000,8000, employee_id)
AS New_Salary
FROM   employees where employee_id in (100,115);


--Person2
SELECT last_name, salary, commission_pct,
COALESCE((salary+(commission_pct*salary)), salary+2000,NVL2(salary,8000,employee_id))
AS New_Salary
FROM   employees where employee_id in (100,115);



select COALESCE(localaddress,permanentaddress,aadharaddress,panaddress ) from employees;


select * from employees where employee_id in (100,115);
update employees set salary = null where employee_id = 115;

--CASE

SELECT last_name, job_id, salary,
       CASE job_id WHEN 'IT_PROG'  THEN  1.10*salary
                   WHEN 'ST_CLERK' THEN  1.15*salary
                   WHEN 'SA_REP'   THEN  1.20*salary
       ELSE      salary END     AS REVISED_SALARY
FROM   employees;


--DECODE

SELECT last_name, job_id, salary,
       DECODE(job_id, 'IT_PROG',  1.10*salary,
                      'ST_CLERK', 1.15*salary,
                      'SA_REP',   1.20*salary,
              salary)
       REVISED_SALARY
FROM   employees;








-----------

DDL - auto committed
DML - commit/rollback


select count(employee_id) from employees;

-----
select department_id, count(employee_id) from employees 
group by department_id;

select department_id, count(employee_id) 
from employees
where department_id in (90,60)
group by department_id 
order by department_id desc


select department_id, manager_id, count(employee_id) from employees 
group by department_id,manager_id;

select department_id, count(employee_id) from employees 
group by department_id,manager_id;

---Having clause
select department_id, manager_id, count(employee_id) 
from employees
where department_id in (90,60,100) and manager_id > 100  
group by department_id ,manager_id
having count(employee_id) > 3
order by department_id desc


-----------Print job_id wise hiring 
salary > 12000
manager_id (100,101,102,103)
count of employees in each job should be >4

select job_id, count(employee_id) from employees 
where salary > 10000 and manager_id in (100,101,102,103) group by job_id having count(employee_id) > 2
order by job_id;

-------------------------------
---JOINS


--NATURAL JOIN

select * from departments;
select * from employees;

select employee_id, first_name, department_name from employees natural join departments;

select employee_id, first_name, department_name,manager_id ,department_id from employees natural join departments;

-----------USING
------Use the USING clause to match only one column when more than one column matches.

select employee_id, first_name, department_name,departments.manager_id ,department_id from employees join departments
using (department_id)

select employee_id, first_name, department_name,manager_id ,employees.department_id from employees join departments
using (manager_id)


----ON clause

SELECT e.employee_id, e.last_name, e.department_id, 
       d.department_id, d.location_id
FROM   employees e JOIN departments d
ON     e.manager_id = d.manager_id



--3 way joins
SELECT employee_id, city, department_name
FROM   employees e 
JOIN   departments d
ON     d.department_id = e.department_id 
JOIN   locations l
ON     d.location_id = l.location_id;


---outer joins

select employee_id, first_name, department_name
from employees e join departments d
on e.department_id = d.department_id;

--LEFT OUTER JOIN

select employee_id, first_name, department_name
from employees e LEFT OUTER join departments d
on e.department_id = d.department_id;

--RIGHT OUTER JOIN

select employee_id, first_name, department_name
from employees e RIGHT OUTER join departments d
on e.department_id = d.department_id;


--FULL  OUTER JOIN

select employee_id, first_name, department_name
from employees e FULL OUTER join departments d
on e.department_id = d.department_id;


---------SELF JOIN

Employee - Neena reports to Manager - Steven

---Hands on 

select 'Employee - ' || employee.first_name || ' reports to Manager - ' || manager.first_name
from employees employee join employees manager 
on employee.manager_id = manager.employee_id;


select * from customer;

select * from branch;

select * from account;

select * from trandetails;

select * from loan;


------------------SUBQUERY

select employee_id, first_name , department_id from employees
where department_id = ( select department_id from employees where lower(first_name) = 'neena')


select employee_id, first_name , department_id from employees
where department_id = ( select department_id from employees where lower(first_name) = 'neena')

-----Minimum salary

select min(salary) from employees;

----Miminum salary in each department
select department_id , min(salary) from employees group by department_id;

---Print name, email , department_id, salary - Miminum salary in each department

select first_name, email, department_id, salary from employees ;


select first_name, email, department_id, salary from employees where (department_id,salary) IN
(select department_id , min(salary) from employees group by department_id);

select employee_id, first_name, email, department_id, salary from employees where (department_id,salary) IN
(select department_id , max(salary) from employees group by department_id)
order by department_id;


select employee_id, first_name, email, department_id, salary from employees where (department_id,salary) IN
(select department_id , max(salary) from employees group by department_id)
order by department_id;


update employees set salary = 12000 where employee_id = 205;

commit;

-------------null VALUES IN SUBQUERY

SELECT emp.last_name
FROM   employees emp
WHERE  emp.employee_id NOT IN
                           (SELECT mgr.manager_id
                            FROM   employees mgr);


----EMPLOYEE WHO ARE MAANGERS
SELECT emp.last_name
FROM   employees emp
WHERE  emp.employee_id  IN
                           (SELECT mgr.manager_id
                            FROM   employees mgr);

-------eMPLOYEE WHO ARE NOT MAANGERS

SELECT emp.last_name
FROM   employees emp
WHERE  emp.employee_id  not IN
                           (SELECT mgr.manager_id
                            FROM   employees mgr );

SELECT EMPLOYEE_ID FROM EMPLOYEES WHERE MANAGER_ID IS NULL;

DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = 100;


Create table retired_Employees
as
select * from employees where employee_id in (103,104,105)

select * from retired_Employees     -- 102,103,104

delete from employees where employee_id =104;
------------UNION

select * from retired_Employees 
union
select * from Employees 




------------UNION ALL

select * from retired_Employees 
union all
select * from Employees 


------------INTERSECT


select * from retired_Employees 
intersect
select * from Employees 


---------MINUS


select * from retired_Employees 
minus
select * from Employees 




------------------------------------------------------DDL

--Table with column level constraints
create table products1
(
    productId number constraint pkIddd primary key,
    productName varchar2(2) constraint uniPName unique,
    quantity number constraint chkQtyttt check ( quantity > 0 ),
    price number constraint chkPriceeeee check (price >= 0),
    reviews varchar2(20) default 'Good'
)

create table orders1
( 
            orderId number,
            orderdate date,
            city varchar(20),
            productId number,
            constraint pkOrdIddd primary key (orderId),
            -- orderDate should greater than sysdate
            constraint fkpIddd foreign key(productId) references products1(productId) on delete cascade
            
)

--Table with table level constraints
create table products2
(
    productId number,
    ssnCode number ,
    productName varchar2(2) not null,
    quantity number,
    price number,
    constraint pkSSnCodeProduct primary key(productId,ssnCode),
    constraint chkQtyproduct2 check (quantity > 0),
    constraint chkQtyproduct3 check (quantity < 100)
)

insert into products1  values(11,'Gl',4,100,default);


---FK


select * from products1;
select * from orders1;

insert into orders1 values(98181,sysdate,'Pune',11);
insert into orders1 values(98182,sysdate,'Pune',11);
insert into orders1 values(98183,sysdate,'Pune',11);
insert into orders1 values(98184,sysdate,'Pune',11);

delete from products1 where productId = 11;



CREATE TABLE orders100 (
    order_id NUMBER PRIMARY KEY,
    orderdate DATE,
    customer_id NUMBER,
    -- other columns
    CONSTRAINT chk_orderdate_future CHECK (orderdate > SYSDATE)
);




ALTER TABLE employees READ ONLY;


ALTER TABLE employees READ WRITE;



drop table employees;




describe employees;

insert into employees (employee_id, last_name,email,hire_date,job_id)values (1999,'Aadhya','aadhyaa',sysdate,'IT_PROG');

select * from employees;

update employees set (salary, commission_pct, manager_id, department_id) 
= (select salary, commission_pct, manager_id, department_id from employees where first_name = 'Neena')
where employee_id = 1999;


--Give employee a raise of 20% if there department id is same as Neena's department id

update employees set salary = salary + 0.2*salary 
where department_id = (select department_id from employees where first_name = 'Neena')


create table abcd
(
pid number
)










