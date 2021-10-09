package com.example.app.bean;

import java.util.List;

import com.example.app.entity.Employee;

public class ResponseBean {
	
	@Override
	public String toString() {
		return "ResponseBean [employeeList=" + employeeList + ", empList=" + empList + ", desc=" + desc + "]";
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private List<Employee> employeeList;
	
	private List<Emp> empList;
	
	private String desc;

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	
	
	

}
