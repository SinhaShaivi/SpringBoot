package com.cg.ems;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ems.bean.Employee;
import com.cg.ems.repo.EmployeeDao;
import com.cg.ems.service.EmployeeServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMgmtSystemTests {

	@InjectMocks
	private EmployeeServiceImpl service;
	@Mock
	private EmployeeDao repository;
	@Test
	public void getAllEmployeesTest()
	{
		when(repository.findAll()).thenReturn(Stream
				.of(new Employee(1,"Shaivi","9818174726"))
				.collect(Collectors.toList()));
		assertEquals(1,service.getAllEmployees().size());
	}
	
	@Test
	public void addEmployeeTest()
	{
		Employee employee=new Employee(1,"Shaivi","98181818181");
		when(repository.save(employee)).thenReturn(employee);
		assertEquals(employee,service.addEmployee(employee));
	}
	
	@Test 
	public void getEmployeeById()
	{
		int id=1;
	Employee employee=new Employee(1,"Shaivi","98181818181");
		when(repository.findById(id))
		.thenReturn(Optional.of(employee));
		assertEquals(employee,service.getEmployeeById(id));
	}

}
