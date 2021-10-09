/**
 * 
 */
package com.example.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.bean.Emp;
import com.example.app.bean.ResponseBean;
import com.example.app.bo.TestBO;
import com.example.app.entity.Employee;

/**
 * @author ssivarg8
 *
 */
@RestController
@RequestMapping(value = "/test")
public class TestServiceImpl implements TestService {
	
	
	@Value("${emp.age.range.min}")
	private int minRange;
	
	@Value("${emp.age.range.max}")
	private int maxRange;
	
	@Autowired
	@Qualifier("TestBO")
	TestBO testBO;

	@Override
	@RequestMapping(value = "/get/emp/{empId}", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody Employee getEmpInfo(@PathVariable int empId) throws Exception {
		// TODO Auto-generated method stub
		Employee emp = testBO.getEmpInfo(empId);		
		return emp;
	}
	
	
	@Override
	@RequestMapping(value = "/stream/example/{param}", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody ResponseBean getInfo(@PathVariable String param) throws Exception {
		// TODO Auto-generated method stub
		ResponseBean respBean = new ResponseBean();

		List<Employee> emp = testBO.getAllEmployees();
		
		List<Emp> newEmpList = new ArrayList<Emp>();
		List<Employee> empList = new ArrayList<Employee>();
		Employee e1 =new Employee();
		e1.setId(1);
		e1.setAge(35);
		e1.setName("Chris");
		e1.setDept("IT");
		e1.setCity("Buffalo Grove");
		e1.setState("IL");
		e1.setZip("60089");
		empList.add(e1);
		
		Employee e2 =new Employee();
		e2.setId(8);
		e2.setAge(30);
		e2.setName("Jim");
		e2.setDept("WORKER");
		e2.setCity("Naperville");
		e2.setState("IL");
		e2.setZip("60045");
		empList.add(e2);
		
		
		if (param.equalsIgnoreCase("demo1")) {
			newEmpList = emp.stream().filter(oldEmp -> oldEmp.getAge()>=minRange && oldEmp.getAge() <= maxRange)
					.map(oldEmp -> new Emp (oldEmp.getId(), oldEmp.getName(), oldEmp.getAge())).collect(Collectors.toList());
			respBean.setEmpList(newEmpList);
			respBean.setDesc("Subset of Employee obj");
		}else if (param.equalsIgnoreCase("demo2")) {
			respBean.setDesc("Common Elements between 2 list");
			List<Employee> commList = emp.stream().filter(empInfo -> empList.stream().anyMatch(newEmpInfo -> newEmpInfo.getId() == empInfo.getId())).collect(Collectors.toList());
			respBean.setEmployeeList(commList);
		}else if (param.equalsIgnoreCase("demo3")) {
			respBean.setDesc("Unique Elements in list 1");
			List<Employee> diffList1 = emp.stream().filter(empInfo -> empList.stream().noneMatch(newEmpInfo -> newEmpInfo.getId() == empInfo.getId())).collect(Collectors.toList());
			respBean.setEmployeeList(diffList1);
		}else if (param.equalsIgnoreCase("demo4")) {
			respBean.setDesc("Unique Elements in list 2");
			List<Employee> diffList2 = empList.stream().filter(empInfo -> emp.stream().noneMatch(newEmpInfo -> newEmpInfo.getId() == empInfo.getId())).collect(Collectors.toList());
			respBean.setEmployeeList(diffList2);
		}
		
				
		
		return respBean;
	}

}
