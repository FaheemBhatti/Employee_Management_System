package org.codechamps.service;

import java.util.List;

import org.codechamps.entity.Employee;
import org.codechamps.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

	public void updateEmployee(Employee employee) {
		repo.save(employee);
	}

	public void deleteEmployee(int id) {
		repo.deleteById(id);
		
	}
}
