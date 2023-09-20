package com.EMS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.EMS.employeeServies.EmployeeServies;
import com.EMS.emplyeeResponseWrappers.EmplyeeResponseWrapper;
import com.EMS.models.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeControler {
	
	@Autowired
	EmployeeServies employeeServies;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerEmployee(@RequestBody  Employee employee)
	{
		return employeeServies.registerEmployee(employee);
	}

}
