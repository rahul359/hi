package com.rahul.program.employee.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.rahul.program.employee.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection="employee")
public class Employee {
	@Id
    private String id;
	@NotNull(message = "Cannot be null")
	private String name;
	@NotNull(message = "Cannot be null")
	private String designation;
	@NotNull(message = "Cannot be null")
	@Min(value = 25, message = "Age must be greater or equal to 25")
	@Max(value=45, message = "Age must be less than 45")
	private int age;
	@NotNull(message = "Cannot be null")
	@Min(value = 20000, message = "Age must be greater or equal to 20000")
	@Max(value=45000, message = "Age must be less than 45000")
	private int salary;
	@NotNull(message = "Cannot be null")
	private boolean status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
