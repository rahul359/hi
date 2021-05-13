package com.rahul.program.employee.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.ArgumentMatchers.anyString;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.rahul.program.employee.model.Employee;
import com.rahul.program.employee.repository.EmployeeRepository;
import com.rahul.program.employee.service.EmployeeServiceImpl;




@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	EmployeeServiceImpl service;
	
	@Mock
	EmployeeRepository repo;
	

	String empJson = "{\"name\":\"Test\",\"age\":27,\"designation\":\"Receptionist\",\"id\":\"ABC\",\"salary\":28000,\"status\":true}";
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testGetAllEmployee() throws Exception {
		Employee emp1=new Employee();
		emp1.setName("Test1");
		emp1.setAge(28);
		emp1.setDesignation("Receptionist");
		emp1.setId("ABC");
		emp1.setSalary(18000);
		emp1.setStatus(true);
		Employee emp2=new Employee();
		emp2.setName("Test2");
		emp2.setAge(30);
		emp2.setDesignation("Manager");
		emp2.setId("DEF");
		emp2.setSalary(28000);
		emp2.setStatus(true);
		List<Employee> list=new ArrayList<>();
		list.add(emp1);
		list.add(emp2);
		when(repo.findAll()).thenReturn(list);
		this.mockMvc.perform(get("/employee")).andDo(print()).andExpect(status().isOk()).equals(list);
	}
	/*
	@Test
	void testCreateEmployee() throws Exception {
		
		this.mockMvc.perform(post("/employee")
			    .contentType("application/json")
        		.content(objectMapper.writeValueAsString(emp)))
			    .andExpect(status().isOk());
	}*/

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testGetSingleEmployee() throws Exception {
		Employee emp=new Employee();
		emp.setName("Test");
		emp.setAge(28);
		emp.setDesignation("Receptionist");
		emp.setId("ABC");
		emp.setSalary(18000);
		emp.setStatus(true);
		repo.save(emp);
		when(service.getSingleEmployee(anyString())).thenReturn(emp);
		when(repo.findById("ABC").get()).thenReturn(emp);
		/*RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/ABC").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "{id:Course1,name:Spring,description:10Steps}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);*/
		this.mockMvc.perform(get("/employee/{ABC}")).andDo(print()).andExpect(status().isOk()).equals(emp);
		
	}
/*
	@Test
	void testUpdateById() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}
*/
}
