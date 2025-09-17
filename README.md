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





Core Java - SE 21

https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe

Intellij utlimate 

https://www.jetbrains.com/idea/download/?section=windows



JDK
	JVM	-
	JRE

	API's 


JRE	
	JVM


IDE - Integrated 


Packages in java
---------------------------

Access specifiers in java
------------------------------




You can define the main method in different ways:
public static void main (String[] args) { }
public static void main (String args[]) { }
public static void main (String... args) { }
There is no practical difference between these approaches; however, the first one is probably the most common.




Javadoc


javadoc -d docs -sourcepath src -subpackages .


C:\Users\shubhshr\Desktop\Java\loan-app>javadoc -d docs src/main/java/org/example/Employee.java


E:\Trainings\2025\6..OFSS\ofss202504\java_projects\loan-app\src\main\java>javadoc -d docs com.training


byte	 -1
short	-2
*int	-4
long	-8


float	-4
*double	-8


implcit and explicit

int num1=100;		-W
short num2=100;		-W
long num3 = 90.8;		-
float num4 = 98.9f;		


byte b1=10;
byte b2=20;
byte b3 = b1 + b2;


package com.training;

public class DataTypeDemo {

    int num1;
   num1=10;
   
    public static void main(String[] args) {
	 num1++;
	System.out.println(num1);

    }
}


String is immutable	it cannot be changed


String name1 = "neha";
name1 = "riya";
String name2 = "neha";
String name3 = new String("neha");	
String name4 = "neha";

System.out.println(name1==name3);		//false
System.out.println(name2==name3);		//false
System.out.println(name2==name4);		//true









public class Main {
  public static void main(String[] args) {
    Main myObj = new Main();
    System.out.println(myObj instanceof Main); // returns true
  }
}




-------


class Product
{
	private int productId;

	
}



Let's break down your code step by step and analyze **why the instance block of class `Z`** is getting called **after** the **constructor of `W`**.

Here’s your code again for reference:

```java
package com.training.util;

class W {
    public W() {
        System.out.println("4. W 1 constructor");
    }
    public W(String name) {
        System.out.println("4. W 2 constructor");
    }
    static {
        System.out.println("#1. W static block");
    }
}

public class Z extends W {
    {
        System.out.println("5. instance block");
    }
    static {
        System.out.println("#2. Z static block");
    }
    public Z(String name) {
        super(name);
        System.out.println("6. Z constructor");
    }

    public static void main(String args[]) {
        System.out.println("#3. In main");
        new Z("YY");
    }
}
```

---

## **Step 1: Class Loading Sequence**

When you run `Z.main()`:

1. **Class W** is loaded first → static block executes:

   ```
   #1. W static block
   ```
2. **Class Z** is loaded next → static block executes:

   ```
   #2. Z static block
   ```
3. The `main()` method executes:

   ```
   #3. In main
   ```

---

## **Step 2: Object Creation Process**

You are calling:

```java
new Z("YY");
```

Now the object creation process involves **both** the **parent class (`W`)** and the **child class (`Z`)**.
Java follows a strict **order**:

---

### **Step 3: Constructor Execution Flow**

#### **Step 3.1: Memory Allocation**

* JVM allocates memory for the new `Z` object.
* All instance variables of **W** and **Z** are set to their default values.

---

#### **Step 3.2: Parent Constructor Call**

* The **first statement** inside `Z`'s constructor is:

```java
super(name);
```

* This means **before doing anything in `Z`**, Java calls `W(String)` constructor.
* This prints:

  ```
  4. W 2 constructor
  ```

---

#### **Step 3.3: Instance Initializers of Z**

* **After** the parent constructor completes, **before** executing the rest of `Z`’s constructor,
  **instance blocks** and **instance variable initializations** of **Z** are executed.

* That’s why:

  ```
  5. instance block
  ```

  is printed **after** the `W` constructor.

---

#### **Step 3.4: Z Constructor Body**

* Finally, the body of `Z(String)` constructor executes:

  ```
  6. Z constructor
  ```

---

## **Final Output Order**

```
#1. W static block      ← W loaded
#2. Z static block      ← Z loaded
#3. In main             ← main() started
4. W 2 constructor      ← super(name)
5. instance block       ← Z's instance block
6. Z constructor        ← Z's constructor body
```

---

## **Why Z's Instance Block Runs After W's Constructor**

Because **Java guarantees** the following **object construction order**:

1. **Parent class instance variables** → initialized.
2. **Parent class instance blocks** → executed.
3. **Parent constructor** → executed.
4. **Child class instance variables** → initialized.
5. **Child class instance blocks** → executed.
6. **Child constructor** → executed.

Since your **Z** class instance block belongs to the **child**,
it **must** wait until the **parent (`W`) constructor** completes.

---

## **Quick Rule to Remember**

> **Instance blocks** run **after the parent constructor** but **before the child constructor body**.

---

Do you want me to make a **diagram** showing the **complete execution flow** for this program?
It’ll make the sequence crystal clear. Should I?


In Java, **all variables declared in an interface are implicitly**:

```java
public static final
```

That means:

* **`public`** → accessible from anywhere
* **`static`** → belongs to the interface, not to instances
* **`final`** → cannot be reassigned once initialized

Let's break this down step by step with **why** they are **static** and **final**.

---

## **1. Interface variables are `static`**

### **Reason**

* Interfaces **cannot have instance variables** because they **cannot have constructors** (until Java 8 introduced default methods, but still no constructors).
* Since you **cannot create objects** of an interface directly, **instance variables don’t make sense**.
* Hence, interface variables **must belong to the interface itself**, not to any object → **they are `static`**.

### **Example**

```java
interface MyInterface {
    int VALUE = 100;  // implicitly public static final
}

class Test {
    public static void main(String[] args) {
        System.out.println(MyInterface.VALUE);  // Accessed via interface name
    }
}
```

**Output:**

```
100
```

---

## **2. Interface variables are `final`**

### **Reason**

* An interface is meant to define **constants** or **contract values**, **not modifiable states**.
* If variables were **not final**, each implementing class could **change their values**, breaking the contract.
* By making them **final**, Java ensures the value **cannot be changed** after initialization.

### **Example**

```java
interface MyInterface {
    int MAX = 50; // public static final by default
}

class Test implements MyInterface {
    public void print() {
        // MAX = 60;  ❌  Compilation Error: cannot assign a value to final variable MAX
        System.out.println(MAX);
    }
}
```

---

## **3. Interface variables are also `public`**

### **Reason**

* Interfaces define a **contract** that must be visible to all implementing classes.
* If they were `private` or `protected`, implementing classes couldn't access them.
* Therefore, all interface variables are **always public**.

---

## **4. Memory Behavior**

Since interface variables are **`static`**, they are **stored in the method area** (class-level memory), **not in object heap memory**.
Thus, there is **only one copy** of each interface constant, shared by all implementing classes.

---

## **5. Summary Table**

| **Property** | **Reason**                                      |
| ------------ | ----------------------------------------------- |
| `static`     | Belongs to the interface, not to objects.       |
| `final`      | Cannot be changed; ensures constant values.     |
| `public`     | Must be accessible to all implementing classes. |

---

## **6. Quick Demo**

```java
interface Config {
    String APP_NAME = "MyApp";  // public static final
    int MAX_USERS = 100;       // public static final
}

class Demo implements Config {
    public void show() {
        System.out.println(APP_NAME);   // ✅ Allowed
        System.out.println(MAX_USERS);  // ✅ Allowed
    }
}
```

**Output:**

```
MyApp
100
```

---

## **Key Takeaway**

> In Java, **interface variables are always constants** →
> **`public static final`** → shared, immutable, and globally accessible.

---

If you want, I can also show you **how Java internally treats interface variables** by **decompiling bytecode** using `javap`.
It will prove that the compiler **automatically adds** `public static final`.

Do you want me to show you that?








Collection<I>



<I>Set(no dupli)			List		
		

Classes
)
HashSet (no norder)		ArrayList	( not thread safe)
LinkedHashSet (order)		LinkedList
TreeSet (sorted)			Vector ( thread safe)		




Comparator		- compareTo	java.lang



--------------

JDBC
------
Java database connectivity

Table

accountNumber
customerName
mobileNumber
balance


Project

Step 1 : Load the appropriate driver

Map<Key,Value>

HashMap ( not ord)
TreeMap (sorted)
LinkedHashMap ( ordered as you enter)
HashTable	- not  thread safe



Anonymous inner classes























































































 java.util.InputMismatchException



try
catch
finally



Two types of exception

Checked 


Unchecked
Arithmetic
Nullpointer



throw
throws


CustomException




Threading
-----------------

Thread	run
Runnable	run


Hands on :

 Enter your name : ( 20 seconds) : Tufail

Welcome , Tufail

Better Luck next time



Debugging
IO
Modules
Annotations









I/O


Input	- read
Output 	- write


FileInput

ObjectInputStream FileInputStream

Stream

	FileInputStream


Reader

	FileReader


File

Seri














JSON and REST
--------------------------

Java script Object 

Language independent


Web Application	->	End User




amazon		->	ICICIBank
JSON	


Well formed JSON


Rules for JSON

1) 

[
    {
        "employeeid": 1010,
        "employeename": "Tufail",
        "salary": 12000
    },
    {
        "employeeid": 1010,
        "employeename": "Tufail",
        "salary": 22000
    }
]

2) [
    {
        "employeeid": [
            1010,
            1012
        ],
        "employeename": [
            "Tufail",
            "Neha"
        ],
        "salary": [
            12000,
            22000
        ]
    }
]


3. Hands on

Create a JSON file to store accounts details like

private  int   accountNumber;
 private String customerName;
    private String mobileNumber;
            private double balance;

3 bank customers


Quick Checklist for Well-Formed JSON ✅
Rule	Requirement
Root element	Must be {} or []
Key names	Always in double quotes " "
String values	Always in double quotes " "
Numbers	No leading zeros, valid decimals
Boolean & null	Must be true, false, null
Commas	No trailing commas
Nesting	Properly balanced {} and []
Duplicates	Avoid duplicate keys
Encoding	UTF-8 only


{
    "accounts": [
        {
            "accountNumber": 1001,
            "customerName": "Alex",
            "mobileNumber": "982387263",
            "balance": -1001.3
        },
        {
            "accountNumber": 1021,
            "mobileNumber": "93387263",
            "balance": -1004.3
        },
        {
            "customerName": "Alexe",
            "mobileNumber": "987263",
            "balance": 1239812398123981
        }
    ]
}


Invalid according to schema

JSON Schema

{ 
    "properties": {
        "id": {
            "description": "The unique identifier for a product",
            "type": "integer"
        }  ,
          "empname": {
            "description": "emp name",
            "type": "string"
        }  },
	    "required": ["id","empname"]
}
	

------

{
  "id":98,
    "empname":"Yamini"
}




** Please install postman


{
"type": "array",
"properties":{
"balance": {
	"type": "number",
	"minimum": 0
},
"accountNumber": {
	"type": "string"
},
"customerName": {
	"type": "string"
},
"mobileNumber": {
	"type": ["string", "number"]
}
},
"required": ["accountNumber", "customerName", "mobileNumber", "balance"]
}

---------------------------------------

[
        {
            "accountNumber": 1001,
            "customerName": "Alex",
            "mobileNumber": "982387263",
            "balance": -1001.3
        },
        {
            "accountNumber": 1021,
            "customerName": "Alex",
            "mobileNumber": "93387263",
            "balance": -1004.3
        },
        {
           "accountNumber": 1021,
            "customerName": "Alexe",
            "mobileNumber": "987263",
            "balance": 1239812398123981
        }
    ]








Hands on : 

1) Mobile Number must of 10 digits
2) Not other fields are allowed.





REST
-----------
Representational State Transfer

Restful Web Services

Application		     -->		Application
			<--JSON-->

Postman					Softbank-RestAPI


Way 1

http://localhost:9090/softbank/api/accounts/saveAccounts
http://localhost:9090/softbank/api/accounts/updateAccounts
http://localhost:9090/softbank/api/accounts/deleteAccounts


Way 2

http://localhost:9090/softbank/api/accounts				- GET		[ get all accoounts]
http://localhost:9090/softbank/api/accounts/{accountNumber}		- GET		[ get a accoount]
http://localhost:9090/softbank/api/accounts/{accountNumber}		-DELETE		[ delete a account]
http://localhost:9090/softbank/api/accounts				- PUT		[ update]
http://localhost:9090/softbank/api/accounts				- POST		[ create]
http://localhost:9090/softbank/api/accounts/transfer/{from}/{to}/{amount}	- PUT		[ transfer]
http://localhost:9090/softbank/api/accounts/transfer/			- PUT		[ transfer]

http://localhost:9090/softbank/api/accounts?mobileNumber=10919181		- GET		[ get all accoounts]


Spring Boot
----------------------
Rest






Hands on :

http://localhost:9090/softbank/api/accounts/10001			- GET		[ get a account]

http://localhost:9090/softbank/api/accounts/add/12/12			- GET		[ get the sum ]

http://localhost:9090/softbank/api/accounts/random/		- GET		[ get the random number between 1 and 100]

http://localhost:9090/softbank/api/accounts/random/900/960	- GET	  [ get the random number between 900 and 960]



HTTP CODES
--------------------

200	- success	
201	- create
		**		204	- not content
300	- redirection
400	- r



Types of variables in REST
----------------------------------

Query parameters
Path parameters
Header parameters
Body parameters

        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.8.5</version> <!-- Use the latest stable version -->
        </dependency>



http://localhost:9090/swagger-ui/index.html




http://localhost:9090/softbank/api/assets/





CI/CD
-------------


Create 	--> Build(jar/war)	--> maven lifecycle --> 


compile
validate
test
install
package




Create our project
Git 
mvn package		- build jar


CI /CD



What we need

Project	
	git repo		

https://github.com/tufailahm/Softbank-RestAPI
https://github.com/tufailahm/Softbank-RestAPI.git


git 

maven


jenkins


OFSSJDK




A release pipeline in Jenkins refers to an automated process designed to build, test, and deploy software from version control to various environments (e.g., development, staging, production) in a continuous and controlled manner. This process is often implemented using Jenkins Pipeline, which utilizes a domain-specific language (DSL) to define the pipeline stages and steps "as code" within a Jenkinsfile.
Key aspects of a Jenkins release pipeline include:
Pipeline-as-Code:
The entire release process is defined in a Jenkinsfile, a text file stored in the project's source control repository alongside the application code. This provides version control, auditability, and reusability of the pipeline definition.

Stages and Steps:
The pipeline is broken down into distinct stages (e.g., build, test, deploy to staging, deploy to production), with each stage containing a series of steps (e.g., compiling code, running unit tests, deploying artifacts).
Continuous Delivery:
The goal is to enable continuous delivery, where every change committed to source control can potentially be released to users after passing through the defined pipeline stages.
Automation:
The pipeline automates repetitive tasks involved in the release process, reducing manual errors and increasing efficiency.
Integration:
Jenkins can integrate with various tools for source code management (e.g., Git), build tools (e.g., Maven, Gradle), testing frameworks, and deployment platforms.
Artifact Management:
The pipeline handles the creation, storage, and management of release artifacts, ensuring that the correct versions are deployed.
Triggering:
Pipelines can be triggered manually, automatically upon code changes (e.g., using SCM polling or webhooks), or on a scheduled basis.









pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "OFSSMaven"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/tufailahm/Softbank-RestAPI.git'

                // Run Maven on a Unix agent.
            //    sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
  	failure {
                   echo "Build failed, please check "
                }
            }
        }
    }
}

-----------------



pipeline {
    agent any

    tools {
        // Use Maven configured in Jenkins as "OFSSMaven"
        maven "OFSSMaven"
    }

    environment {
        // Custom JAR name using Jenkins Build Number
        PROJECT_NAME = "Softbank-RestAPI"
        NEW_JAR_NAME = "Softbank-RestAPI-${BUILD_NUMBER}.jar"
    }

    stages {

        stage('Checkout') {
            steps {
                echo "🔄 Checking out code from GitHub..."
                git 'https://github.com/tufailahm/Softbank-RestAPI.git'
            }
        }

        stage('Build') {
            steps {
                echo "⚡ Building Maven Project..."
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }

        stage('Rename JAR') {
            steps {
                script {
                    echo "📦 Renaming JAR file..."
                    // Find the generated JAR file (ignore original-*.jar)
                    def originalJar = bat(script: 'for /f "delims=" %i in (\'dir /b target\\*.jar ^| findstr /v "original"\') do @echo %i', returnStdout: true).trim()

                    // Rename it with BUILD_NUMBER
                    bat "rename target\\${originalJar} ${NEW_JAR_NAME}"

                    echo "✅ JAR renamed to: ${NEW_JAR_NAME}"
                }
            }
        }


        stage('Archive Artifact') {
            steps {
                echo "📤 Archiving JAR..."
                archiveArtifacts artifacts: "target/${NEW_JAR_NAME}", fingerprint: true
            }
        }
        stage('Copy to h:\ofssapp') {
            steps {
                echo "📤 Archiving JAR..."
                archiveArtifacts artifacts: "target/${NEW_JAR_NAME}", fingerprint: true
            }
        }
    }

    post {
        success {
            echo "✅ Build Successful!"
            junit '**/target/surefire-reports/TEST-*.xml'
        }
        failure {
            echo "❌ Build Failed! Please check the logs."
        }
    }
}





Javascript
---------------

client side validation framework
add dynamic capabilities to your page


Hands on : Create a external javascript file to accept a number a return true or false, if matched.

The function randomly generate the number and check with the parameter.


Expected Outcome :

The magic number is : 9
Enter number (3 attempts ) : 7
Sorry , try again
Enter number (2 attempts ) : 6
Sorry , try again
Enter number (1 attempts ) : 4
Game Over , Lost
---------------------
Game won if  number is guessed correctly



Hands on :  Display Image  and upon hovering the image should change 


Open eyes should be closed upon hovering




Communicating with a Remote Server











Creating Objects and Methods by Using JavaScript
------------------------------------------------------------------









































Testing
---------------------------


What is Testing ?


expected
actual


@Test
@DisplayName

Stub Methods

@BeforeAll
@AfterAll
@BeforeEach
@AfterEach


Ordering of tests
-------------------------


Parameterized testing
----------------------------------



Timeout
Disable tests

















http://localhost:9090/swagger-ui/index.html





pm.test("At least one product named Monitor exists", function () {
    let products = pm.response.json();
    let found = products.some(p => p.name === "Monitor");
    pm.expect(found).to.be.true;
});

let jsonData = pm.response.json();

pm.test("Product response has required fields", function () {
    pm.expect(jsonData).to.have.property("id");
    pm.expect(jsonData).to.have.property("name");
    pm.expect(jsonData).to.have.property("price");
    pm.expect(jsonData).to.have.property("quantity");
});

pm.test("Product name is 'Monitor'", function () {
    pm.expect(jsonData.name).to.eql("Monitor");
});

pm.test("Product price is 9000", function () {
    pm.expect(jsonData.price).to.eql(9000);
});

pm.test("Product quantity is 20", function () {
    pm.expect(jsonData.quantity).to.eql(20);
});




Selenium


      <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.34.0</version>
        </dependency>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.11.0-RC1</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-params</artifactId>
            <version>5.8.1</version>
            <scope>test</scope>
        </dependency>





        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.27.0</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>7.14.0</version>
            <scope>test</scope>
        </dependency>



Selenium automates web browsers




//*[@id="APjFqb"]

/html/body/div[2]/div[4]/form/div[1]/div[1]/div[1]/div[1]/div[2]/textarea





Keyword : "diamond studded name plate"


name plate








<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="Search Amazon.in" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search Amazon.in" role="searchbox" aria-autocomplete="list" aria-controls="sac-autocomplete-results-container" aria-expanded="true" aria-haspopup="grid" spellcheck="false">





<input id="nav-search-submit-button" type="submit" class="nav-input nav-progressive-attribute" value="Go" tabindex="0">




<h2 aria-label="Sponsored Ad - DLCCREATION Name Plate Personalised Stainless Steel 304 Quality Plate with Engraving and Color Filling with Diamond Studded Stud for Fixing Size : 30cm x 20cm" class="a-size-base-plus a-spacing-none a-color-base a-text-normal"><span>DLCCREATION Name Plate Personalised Stainless Steel 304 Quality Plate with Engraving and Color Filling with Diamond Studded Stud for Fixing Size : 30cm x 20cm</span></h2>


<img class="s-image" src="https://m.media-amazon.com/images/I/61Pw1bPZbGL._AC_UL320_.jpg" srcset="https://m.media-amazon.com/images/I/61Pw1bPZbGL._AC_UL320_.jpg 1x, https://m.media-amazon.com/images/I/61Pw1bPZbGL._AC_UL480_FMwebp_QL65_.jpg 1.5x, https://m.media-amazon.com/images/I/61Pw1bPZbGL._AC_UL640_FMwebp_QL65_.jpg 2x, https://m.media-amazon.com/images/I/61Pw1bPZbGL._AC_UL800_FMwebp_QL65_.jpg 2.5x, https://m.media-amazon.com/images/I/61Pw1bPZbGL._AC_UL960_FMwebp_QL65_.jpg 3x" alt="Sponsored Ad - DLCCREATION Name Plate Personalised Stainless Steel 304 Quality Plate with Engraving and Color Filling with..." aria-hidden="true" data-image-index="1" data-image-load="" data-image-latency="s-product-image" data-image-source-density="1">





BDD -- Behavior Driven Test
----------------------------------------
Cucumber testing

Gherkin language

Feature: Login functionality

 Scenario: Successful login with valid credentials
When user visits the web site
Then user should navigate to login page
And types username and password
When user click on login button
Then user should navigate to the home page


Hands on :

https://onlinetexttools.com/check-text-palindrome



Check online for palindrome 


Data Driven Testing
-----------------------------


10 words





































Spring Boot Fundamentals
-------------------------------------




Dependency Injection

IOC


Spring Boot
------------------

Spring + zero configuration
Embedded Tomcat


bean - 	object managed by spring container



@Component
@Bean
@Configuration



@Service
@Repository
@RestController




http://localhost:9090/randomWeather
http://localhost:9090/random
http://localhost:9090/hello
















Use case : Manage expenses like CRUD 


localhost:9090/expense

Model


GuestUser

guestId
guestName
mobileNumber
monthlyincome		
monthyExpense		
balance			




Problem : Create table -- XX


localhost:9090/expense	- CRUD


Hands on 


localhost:9090/expense	- POST
localhost:9090/expense	- GET 	GET ALL


Hands on :

localhost:9090/expense/100	- GET BY GUEST ID
localhost:9090/expense/100	- DELETE BY GUEST ID	DELETE
localhost:9090/expense	- UPDATE (PUT)



15 minutes 14:08 17-09-2025


JPA custom methods


Some requirements


localhost:9090/expense/balance/10000				
localhost:9090/expense/monthlyIncome/50
localhost:9090/expense/searchByMobileNumber/19191919101
localhost:9090/expense/searchByGuestName/Neha


Hands on :
Delete custom method to delete guest by mobileNumber

http://localhost:9090/expense/mobile/9876543210	- DELETE




















