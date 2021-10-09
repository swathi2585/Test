package com.example.app.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.app.entity.Employee;
import com.example.app.repository.EmployeeRepo;

@Component("TestBO")
public class TestBOImpl implements TestBO {
	
	@Autowired
	EmployeeRepo empRepo;

	@Override
	public Employee getEmpInfo(int empId) throws Exception {
		// TODO Auto-generated method stub
		
		Employee empInfo = empRepo.findById(empId).get();
		
		return empInfo;
	}
	
	
	@Override
	public List<Employee> getAllEmployees() throws Exception {
		// TODO Auto-generated method stub
				
		List<Employee> empList = new ArrayList<Employee>();  
		empRepo.findAll().forEach(emp -> empList.add(emp));  
		
		return empList;
	}

}
