package com.company.EmployeeManagement.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.company.EmployeeManagement.entity.Employee;
import com.company.EmployeeManagement.repository.EmployeeRepository;
import com.company.EmployeeManagement.services.Services;

@Service
public class ServicesImpl implements Services{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Integer id, Employee employee) {
		
		Employee employee2 = employeeRepository.findById(id).get();
		
		if(0 < employee.getSalary()) {
			employee2.setSalary(employee.getSalary());
		}
		
		return employeeRepository.save(employee2);
	}

	@Override
	public List<Employee> descendingSalary() {
		return employeeRepository.findByOrderBySalaryDesc();
	}

	@Override
	public List<Employee> getEmployeesBySorting() {
		List<Employee> list = employeeRepository.findAll(Sort.by("salary").descending().and(Sort.by("name")));
		return list;
	}
	
	
	

}
