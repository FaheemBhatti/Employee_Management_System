package org.codechamps.controller;

import java.util.List;
import org.codechamps.entity.Employee;
import org.codechamps.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(value = "/allEmployee" , 
			method = RequestMethod.GET)
	public List<Employee> getAllEmployee(){
		return service.getAllEmployee();
		
	}
	
	@RequestMapping(value = "/allEmployee/{id}" , 
			method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeById( @PathVariable int id) {
		return service.getEmployeeById(id);
	}
	
	@RequestMapping(value = "/addEmployee" , 
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee addEmployee(@RequestBody Employee employee){
		return service.addEmployee(employee);
	}
	
	@RequestMapping(value = "/updateEmployee/{id}" , 
			method = RequestMethod.PUT , 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee updatedEmployee, @PathVariable int id){
		return service.getUpdatedEmployee(id , updatedEmployee);
	}
	
	@RequestMapping(value = "/deleteEmployee/{id}", 
			method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id); 
		
	}
}
