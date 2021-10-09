package com.example.app.bo;

import java.util.List;

import com.example.app.entity.Employee;

public interface TestBO {

	
	public Employee getEmpInfo(int id) throws Exception;
	
	public List<Employee> getAllEmployees() throws Exception;
}
