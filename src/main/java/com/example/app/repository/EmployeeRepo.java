package com.example.app.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.app.entity.Employee;  



public interface EmployeeRepo extends CrudRepository<Employee, Integer>  
{  
	
}  

