package com.dev.spring.mvc.thymeleafdemo.service;

import java.util.List;

import com.dev.spring.mvc.thymeleafdemo.model.Employee;

public interface EmployeeService {
	
	void updateTicket(Employee Emp);
	
	Employee findById(int id);
	List<Employee>findAll();
	void deleteById(int id);
	Employee save(Employee emp);
	List<Employee> search(String keyword);

}


