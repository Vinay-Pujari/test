package com.company.EmployeeManagement.services;

import java.util.List;

import com.company.EmployeeManagement.entity.Employee;

public interface Services {
	
	public Employee addEmployee(Employee employee);
	public List<Employee> getEmployees();
	public Employee updateEmployee(Integer id, Employee employee);
	
	public List<Employee> descendingSalary();
	public List<Employee> getEmployeesBySorting();

}
