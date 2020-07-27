package com.uma.springboot_cache.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uma.springboot_cache.model.Employee;
import com.uma.springboot_cache.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping()
	public ResponseEntity<List<Employee>> getEmployee() {

		List<Employee> employeeList = this.employeeService.getEmployeeDetails();

		return ResponseEntity.ok(employeeList);

	}

}
