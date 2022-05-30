package com.abstractandtangibles.springboot._crudspringbootapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abstractandtangibles.springboot._crudspringbootapp.dao.EmployeeDAO;
import com.abstractandtangibles.springboot._crudspringbootapp.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDao) {
		employeeDao = theEmployeeDao;
	}
	
	public EmployeeServiceImpl() {}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return employeeDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDao.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDao.deleteById(theId);
	}
}
