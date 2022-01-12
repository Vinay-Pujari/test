package com.company.EmployeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.EmployeeManagement.entity.Employee;
import com.company.EmployeeManagement.services.implementation.ServicesImpl;

@RestController
public class EmployeeController {
	
	@GetMapping(path = "/")
	private String hello() {
		return "Hello";
	}
	
	@Autowired
	ServicesImpl servicesImpl;
	
	@PostMapping(path = "/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return servicesImpl.addEmployee(employee);
	}
	
	@GetMapping(path = "/employee")
	private List<Employee> getEmployees() {
		return servicesImpl.getEmployees();
	}
	
	@PutMapping(path = "/employee/{id}")
	private Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
		return servicesImpl.updateEmployee(id, employee);
	}
	
	@GetMapping(path = "/salary")
	public List<Employee> function(){
		return servicesImpl.descendingSalary();
	}
	
	@GetMapping(path = "/employee/sorted")
	public List<Employee> function2(){
		return servicesImpl.getEmployeesBySorting();
	}
}
