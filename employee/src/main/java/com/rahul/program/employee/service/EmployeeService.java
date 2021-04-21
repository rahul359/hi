package com.rahul.program.employee.service;

import java.util.List;


import javax.validation.ConstraintViolationException;

import com.rahul.program.employee.exception.EmployeeException;
import com.rahul.program.employee.model.Employee;

public interface EmployeeService {

	
	public void createEmployee(Employee employee) throws ConstraintViolationException,  EmployeeException;
	
	public List<Employee> getAllEmployee();
	
	public Employee getSingleEmployee(String id) throws EmployeeException;
	
	public void updateEmployee(String id, Employee employee) throws EmployeeException;
	
	public void deleteEmployeeById(String id) throws EmployeeException;
		
	
}
