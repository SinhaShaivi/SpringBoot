package com.cg.ems.service;
import java.util.List;
import java.util.Optional;

import com.cg.ems.bean.Employee;

public interface EmployeeService {
public Employee addEmployee(Employee emp);
public List<Employee> getAllEmployees();
public Employee getEmployeeById(int id);
public List<Employee> sortEmployeeByname();
public List<Employee> updateEmployeeNameById(String name);

}
