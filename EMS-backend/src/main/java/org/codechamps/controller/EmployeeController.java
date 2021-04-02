package org.codechamps.controller;

import java.util.List;

import org.codechamps.entity.Employee;
import org.codechamps.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class EmployeeController 
{
	@Autowired
	EmployeeService service;
	
	@RequestMapping(value = "/allEmployee" , method = RequestMethod.GET)
	public List<Employee> getAllEmployee(){
		return service.getAllEmployee();
		
	}
	
	@RequestMapping(value = "/addEmployee" , 
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addPost(@RequestBody Employee employee)
	{
		service.addEmployee(employee);
	}
	
	@RequestMapping(value = "/updateEmployee", 
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateEmployee(@RequestBody Employee employee) {
		service.updateEmployee(employee);
	}
	
	@RequestMapping(value = "/deleteEmployee/{id}", 
			method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id); 
		
	}

}
