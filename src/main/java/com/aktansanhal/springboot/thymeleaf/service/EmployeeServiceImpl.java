package com.aktansanhal.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aktansanhal.springboot.thymeleaf.dao.EmployeeRepository;
import com.aktansanhal.springboot.thymeleaf.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee =null;
		
		if(result.isPresent()) {
			employee = result.get();
		}else {
			throw new RuntimeException("id not found: " + id);
		}
		
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
		employeeRepository.save(employee);
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		
	}

	
	
}
