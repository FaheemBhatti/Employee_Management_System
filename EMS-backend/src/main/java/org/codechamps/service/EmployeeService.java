package org.codechamps.service;

import java.util.List;

import org.codechamps.entity.Employee;
import org.codechamps.exception.ResourceNotFoundException;
import org.codechamps.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;
	
	public List<Employee> getAllEmployee(){
		return (List<Employee>) repo.findAll();
	}

	public Employee addEmployee(Employee employee) {
		return repo.save(employee);
		
	}

	public void deleteEmployee(int id) {
		repo.deleteById(id);
		
	}

	public ResponseEntity<Employee> getEmployeeById(int id) {
		Employee employee = repo.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Employee not exist by id:"+id));
		
		return ResponseEntity.ok(employee);
	}

	public ResponseEntity<Employee> getUpdatedEmployee(int id, Employee externalEmployee) {
		Employee employee = repo.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("Employee not exist by id:"+id));
		
		employee.setFirstName(externalEmployee.getFirstName());
		employee.setLastName(externalEmployee.getLastName());
		employee.setEmail(externalEmployee.getEmail());
		
		Employee updatedEmployee = repo.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
}
