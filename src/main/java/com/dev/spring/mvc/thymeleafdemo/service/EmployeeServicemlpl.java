package com.dev.spring.mvc.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dev.spring.mvc.thymeleafdemo.Repository.EmployeeRepository;
import com.dev.spring.mvc.thymeleafdemo.model.Employee;


@Service
public class EmployeeServicemlpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;

	public EmployeeServicemlpl(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void updateTicket(Employee Emp) {
		
		employeeRepository.save(Emp);
		
	}

	@Override
	public Employee findById(int Empid) {
		Optional<Employee>result = employeeRepository.findById(Empid);
		
		Employee employeeRepository = null;
		if(result.isPresent()) {
			employeeRepository = result.get();
		}
		else {
			//System.out.println("Did not find Employee id"+id);
			throw new RuntimeException("Did not find Employee id - " + Empid);
		}
		return employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}



	@Override
	public Employee save(Employee emp) {
		
		return employeeRepository.save(emp);
	}

	@Override
	public void deleteById(int id) {
		
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> search(String keyword) {
		// TODO Auto-generated method stub
		return employeeRepository.search(keyword);
	}




}


