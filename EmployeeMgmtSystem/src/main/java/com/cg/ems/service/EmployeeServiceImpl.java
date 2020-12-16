package com.cg.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ems.bean.Employee;
import com.cg.ems.repo.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao empDao;

	@Override
	public Employee addEmployee(Employee emp) {
		return empDao.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees=(List<Employee>) empDao.findAll();
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		return empDao.findById(id).get();
	}

	@Override
	public List<Employee> sortEmployeeByname() {
		// TODO Auto-generated method stub
		return empDao.giveSortedOrder();
	}

	@Override
	public List<Employee> updateEmployeeNameById(String name) {
		// TODO Auto-generated method stub
		return empDao.updateNameWithId(name);
	}

	

}
