package com.rahul.program.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.program.employee.exception.EmployeeException;
import com.rahul.program.employee.model.Employee;
import com.rahul.program.employee.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepo;
	
	
    @Override
	public Employee createEmployee(Employee employee) throws ConstraintViolationException, EmployeeException {
		Optional<Employee>  employeeOptional = employeeRepo.findByEmployee(employee.getName());
		if (employeeOptional.isPresent()) {
			throw new EmployeeException(EmployeeException.EmployeeAlreadyExists());
			
		}else {
			return employeeRepo.save(employee);
		}		
	}

    @Override
	public List<Employee> getAllEmployee() {
		List<Employee> employee = employeeRepo.findAll();
		if (employee.size() > 0) {
			return employee;
		}else {
			return new ArrayList<Employee>();
		}
		
	}

	@Override
	public Employee getSingleEmployee(String id) throws EmployeeException {
		Optional<Employee> optionalEmployee = employeeRepo.findById(id);
		if (!optionalEmployee.isPresent() ) {
			throw new EmployeeException(EmployeeException.NotFoundException(id));
		}else {
			return optionalEmployee.get();
		}
	}

	@Override
	public Employee updateEmployee(String id, Employee employee) throws EmployeeException {
		Optional<Employee> employeeWithId = employeeRepo.findById(id);
		if(employeeWithId.isPresent()) {
	        Employee employeeToUpdate = employeeWithId.get();
			employeeToUpdate.setName(employee.getName());
			employeeToUpdate.setDesignation(employee.getDesignation());
			employeeToUpdate.setAge(employee.getAge());
			employeeToUpdate.setSalary(employee.getSalary());
			
			employeeToUpdate.setStatus(employee.isStatus());
			
			return employeeRepo.save(employeeToUpdate);
	
			
		}else {
			throw new EmployeeException(EmployeeException.NotFoundException(id));
		}		
	}

	@Override
	public String deleteEmployeeById(String id) throws EmployeeException {
		Optional<Employee> employeeOptional = employeeRepo.findById(id);
		if(!employeeOptional.isPresent()) {
			throw new EmployeeException(EmployeeException.NotFoundException(id));
		}else {
			employeeRepo.deleteById(id);
			return "Success";
		}
		
	}

	
	
	
}
