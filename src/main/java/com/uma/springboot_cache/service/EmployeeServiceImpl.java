package com.uma.springboot_cache.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.uma.springboot_cache.model.Employee;
import com.uma.springboot_cache.service.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Cacheable("employee")
	public List<Employee> getEmployeeDetails() {
		System.out.println(">>>>>>>> get data from DB .....................");
		return this.employeeRepository.findAll();
	}

}
