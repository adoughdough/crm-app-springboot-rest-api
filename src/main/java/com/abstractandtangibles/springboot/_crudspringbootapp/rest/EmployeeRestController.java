package com.abstractandtangibles.springboot._crudspringbootapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abstractandtangibles.springboot._crudspringbootapp.entity.Employee;
import com.abstractandtangibles.springboot._crudspringbootapp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	//quick and dirty: inject employee dao
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	//expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}
	
	//add mapping or endpoint for GET /employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return theEmployee;
	}
	
	//add mapping for POST /employees - add new employee
	@PostMapping("/employees") 
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		//id is set to zero to force hibernate to perform save and not update operation
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	//add mapping for PUT /employees -- update existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}	
	
	
	//add mapping for PUT /employees -- update existing employee
	@DeleteMapping("/employees/{employeeId}")
	public String updateEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee with id: - " + employeeId + "not found");
		}
		
		employeeService.deleteById(employeeId);
		
		return "Employee with id: " + employeeId + " now deleted";
	
	}
}
