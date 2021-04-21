package com.rahul.program.employee.exception;


public class EmployeeException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeException(String message) {
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "Employee With"+id+"not found";
	}

	public static String EmployeeAlreadyExists() {
		return "Employee already Exists";
	}
	
}