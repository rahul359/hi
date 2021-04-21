package com.rahul.program.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.program.employee.exception.EmployeeException;
import com.rahul.program.employee.model.Employee;
import com.rahul.program.employee.repository.EmployeeRepository;
import com.rahul.program.employee.service.EmployeeService;

import java.util.List;


import javax.validation.ConstraintViolationException;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public ResponseEntity<?> getAllEmployee() {
		List<Employee> employee = employeeRepo.findAll();
		if (employee.size() > 0) {
			return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
		}else {
			return new  ResponseEntity<>("No Employees", HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@PostMapping("/employee")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
		try {
			employeeService.createEmployee(employee);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
		catch( ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}catch (EmployeeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping("/employee/{id}")
	public  ResponseEntity<?> getSingleRoom(@PathVariable("id") String id) {
		try {
			return new ResponseEntity<>(employeeService.getSingleEmployee(id), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/employee/{id}")
	public  ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody Employee employee) {
		try {
			employeeService.updateEmployee(id, employee);
			return new ResponseEntity<>("Updated Employee with Id"+id, HttpStatus.OK);
		}catch (ConstraintViolationException e) {
			return new ResponseEntity<> (e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
			
		}catch (EmployeeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
		try {
			employeeService.deleteEmployeeById(id);
			return new ResponseEntity<> ("Successfully deleted with id"+id , HttpStatus.OK);
		} catch (EmployeeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
	
