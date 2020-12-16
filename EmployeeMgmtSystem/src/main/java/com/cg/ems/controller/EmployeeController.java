package com.cg.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.bean.Employee;
import com.cg.ems.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		empService.addEmployee(employee);
		return "Employee added!!";
	}

	@GetMapping("/allEmployees")
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}
	
	@GetMapping("/viewEmployee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) {
		return empService.getEmployeeById(id);
	}
	
	@GetMapping("/sort")
	public List<Employee> sortEmployeeByName()
	{
		return empService.sortEmployeeByname();
	}
	@GetMapping("/updateEmployee")
	public List<Employee> updateEmployee()
	{
		return empService.updateEmployeeNameById("Ramesh");
	}

}
