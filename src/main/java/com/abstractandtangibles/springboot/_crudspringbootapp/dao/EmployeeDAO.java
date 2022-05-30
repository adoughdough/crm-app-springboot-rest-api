package com.abstractandtangibles.springboot._crudspringbootapp.dao;

import java.util.List;

import com.abstractandtangibles.springboot._crudspringbootapp.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
}
