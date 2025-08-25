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
































