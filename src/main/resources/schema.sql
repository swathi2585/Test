DROP TABLE IF EXISTS EMPLOYEE;  

CREATE TABLE EMPLOYEE(
id INT PRIMARY KEY,
name VARCHAR(50) NOT null,
age int not null,
city VARCHAR(50) not null,
state VARCHAR(50) not null,
zip VARCHAR(20) not null,
dept VARCHAR(50) not null
);
