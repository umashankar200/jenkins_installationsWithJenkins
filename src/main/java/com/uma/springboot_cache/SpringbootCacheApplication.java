package com.uma.springboot_cache;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.uma.springboot_cache.model.Employee;
import com.uma.springboot_cache.service.repository.EmployeeRepository;

@SpringBootApplication
@EnableCaching
public class SpringbootCacheApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCacheApplication.class, args);
		System.out.println(">>>>>>>>>>>>>>>>>>>Manin method started>>>>>>>>>>>>>>>>>>>>>");

	}

	@PostConstruct
	public void initDb() {

		Employee emp = new Employee(Long.valueOf(12), "uma", "IBM");
		Employee emp_one = new Employee(Long.valueOf(13), "rabindra", "CTS");

		Arrays.asList(emp, emp_one).forEach(employee -> {
			this.employeeRepository.save(employee);
		});

	}
}
