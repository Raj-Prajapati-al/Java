-- Create Department table
CREATE TABLE dept
(
	deptno INT(2) PRIMARY KEY,
	dname VARCHAR(14),
	loc VARCHAR(13)
);

-- Create Emp table
CREATE TABLE emp 
(
	empno INT(4) PRIMARY KEY,
	ename VARCHAR(10),
	job VARCHAR(19),
	mgr INT(4),
	hiredate DATE,
	sal DECIMAL(7,2),
	comm DECIMAL(7,2),
	deptno INT(2),
	CONSTRAINT deptno_fkey FOREIGN KEY(deptno) REFERENCES dept(deptno)	
);

-- Create student table
CREATE TABLE student
(
	rno INT(2) PRIMARY KEY DEFAULT 0,
	sname VARCHAR(14),
	city VARCHAR(20),
	state VARCHAR(20)
);

-- Create emplog table
CREATE TABLE emplog
(
	emp_id INT(5),
	log_date DATE,
	new_salary INT(10),
	ACTION VARCHAR(20)
);

-- Insert Record in dept table
INSERT INTO dept VALUES(10,"Accounting","New York"),
		(20,"Research","Dallas"),
		(30,"Sales","Chicago"),
		(40,"Operations","Boston");

-- Insert Record in emp table		
INSERT INTO emp VALUES(7369,"Smith","Clerk",7902,"1980-12-17",800.00,NULL,20),
 			(7499,"Allen","Salesman",7698,"1981-02-20",1600.00,300.00,30),
			(7521,"Ward","Salesman",7698,"1981-02-22",1250.00,500.00,30),
			(7566,"Jones","Manager",7839,"1981-04-02",2975.00,NULL,20),
			(7654,"Martin","Salesman",7698,"1981-09-28",1250.00,1400.00,30),
			(7698,"Blake","Manager",7839,"1981-05-01",2850.00,NULL,30),
			(7782,"Clark","Manager",7839,"1981-06-09",2450.00,NULL,10),
			(7788,"Scott","Analyst",7566,"1987-06-11",3000.00,NULL,20),
			(7839,"King","President",NULL,"1981-11-17",5000.00,NULL,10),
			(7844,"Turner","Salesman",7698,"1981-08-09",1500.00,0.00,30),
			(7876,"Adamas","Clerk",7788,"1987-07-13",1100.00,NULL,20),
			(7900,"James","Clerk",7698,"1981-03-12",950.00,NULL,30),
			(7902,"Ford","Analyst",7566,"1981-03-12",3000.00,NULL,20),
			(7934,"Miller","Clerk",7782,"1982-01-23",1300.00,NULL,10);

-- 1. First Query
SELECT DISTINCT job 
FROM emp;

-- 2. Second Query
SELECT * 
FROM emp 
ORDER BY deptno ASC, job DESC;

-- 3. Third Query
SELECT DISTINCT job 
FROM emp 
ORDER BY job DESC;

-- 4. Fourth Query
SELECT * 
FROM emp 
WHERE hiredate < '1981-01-01';

-- 5. fifth Query
SELECT 
    empno, 
    ename, 
    sal, 
    (sal / 365) AS daily_sal
FROM 
    emp
ORDER BY 
    (sal * 12) ASC;

-- 6. Six Query
SELECT 
    empno, 
    ename, 
    sal, 
    YEAR(CURDATE()) - YEAR(hiredate) AS EXP
FROM 
    emp
WHERE 
    mgr = 7369;

-- 7. Seven Query
SELECT * 
FROM emp
WHERE comm > sal;

-- 8. Eight Query
SELECT *
FROM emp
WHERE job IN ("Clerk","Analyst") 
ORDER BY job;

-- 9. Nine Query
SELECT * 
FROM emp 
WHERE (sal * 12) BETWEEN 22000 AND 45000;

-- 10. Ten Query
SELECT ename 
FROM emp 
WHERE ename LIKE 'S____';

-- 11. Eleven Query
SELECT *
FROM emp
WHERE empno NOT LIKE "78%";

-- 12. Twelve Query
SELECT * 
FROM emp 
WHERE job = 'CLERK' 
AND deptno = 20;

-- 13. Thirteen Query
SELECT 
    e1.empno, 
    e1.ename, 
    e1.hiredate AS emp_hiredate, 
    e2.empno AS mgr_empno, 
    e2.ename AS mgr_ename, 
    e2.hiredate AS mgr_hiredate 
FROM 
    emp e1 
JOIN 
    emp e2 
ON 
    e1.mgr = e2.empno 
WHERE 
    e1.hiredate < e2.hiredate;

-- 14. Fourteen Query
SELECT *
FROM emp e1
WHERE deptno = 20
AND job IN (
    SELECT DISTINCT job
    FROM emp
    WHERE deptno = 10
);

-- 15. Fifteen Query
SELECT *
FROM emp
WHERE sal IN (
    SELECT sal
    FROM emp
    WHERE ename IN ('FORD', 'SMITH')
)
ORDER BY sal DESC;

-- 16. Sixteen Query
SELECT *
FROM emp
WHERE job IN (
    SELECT job
    FROM emp
    WHERE ename IN ('SMITH', 'ALLEN');

-- 17. Seventeen Query
SELECT DISTINCT job 
FROM emp
WHERE deptno = 10 
AND job NOT IN (
    SELECT DISTINCT job
    FROM emp
    WHERE deptno = 20
);

-- 18. Eighteen Query
SELECT MAX(sal) AS Highest_Salary 
FROM emp;

-- 19. Nineteen Query
SELECT *
FROM emp
WHERE sal = (SELECT MAX(sal) FROM emp);

-- 20. Twenty Query
SELECT SUM(sal) AS total_salary
FROM emp
WHERE empno IN (SELECT DISTINCT mgr FROM emp);

-- 21. Twenty One Query
SELECT * 
FROM emp 
WHERE ename LIKE "%A%";

-- 22. TwentyTwo Query
SELECT empno, ename, job, sal
FROM emp
WHERE (job, sal) IN (
    SELECT job, MIN(sal)
    FROM emp
    GROUP BY job
)
ORDER BY sal ASC;

-- 23. TwentyThree Query
SELECT *
FROM emp
WHERE sal > (
    SELECT sal
    FROM emp
    WHERE ename = 'BLAKE'
);

-- 24. TwentyFour Query
CREATE VIEW v1
AS
SELECT e.ename, e.job, d.dname, d.loc
FROM emp e
JOIN dept d ON e.deptno = d.deptno; 

-- 25. TwentyFifth Query Procedure Creation
DELIMITER $$

CREATE PROCEDURE fetch_ename_dname (IN p_dno INT)
BEGIN
    SELECT e.ename, d.dname
    FROM emp e
    JOIN dept d ON e.deptno = d.deptno
    WHERE e.deptno = p_dno;
END $$

DELIMITER ;

-- Execution Of Above Procedure
CALL fetch_ename_dname(10);

-- 26. TwentySix Query
ALTER TABLE student
ADD COLUMN Pin BIGINT;


-- 27. TwentySeven query

-- First Part
ALTER TABLE student
MODIFY COLUMN sname VARCHAR(40);

-- Second Part
DELIMITER $$

CREATE TRIGGER after_sal_update
AFTER UPDATE ON emp
FOR EACH ROW
BEGIN
    IF NEW.sal <> OLD.sal THEN
        INSERT INTO emp_log (empno, ACTION, old_sal, new_sal, update_time)
        VALUES (NEW.empno, 'New Salary', OLD.sal, NEW.sal, NOW());
    END IF;
END $$

DELIMITER ;

-- Testing Trigger
UPDATE emp SET sal = 5000.00 WHERE empno = 7521;





