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








