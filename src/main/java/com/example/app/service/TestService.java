package com.example.app.service;



import com.example.app.bean.ResponseBean;
import com.example.app.entity.Employee;

public interface TestService {
	
	
	public Employee getEmpInfo(int id) throws Exception;
	
	public ResponseBean getInfo(String param) throws Exception ;


}
