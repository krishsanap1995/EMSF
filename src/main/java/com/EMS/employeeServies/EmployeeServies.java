package com.EMS.employeeServies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.EMS.emplyeeResponseWrappers.EmplyeeResponseWrapper;
import com.EMS.models.Employee;
import com.EMS.repositries.EmployeeRepositry;

@Service
public class EmployeeServies {
	@Autowired
	EmployeeRepositry employeeRepositry;
	
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	
	public ResponseEntity<?> registerEmployee(Employee employee)
	{
		String email=employee.getEmail();
		boolean isEmployeeExist=employeeRepositry.findByEmail(email).isPresent();
		
		if (isEmployeeExist) 
		{
		throw new ResponseStatusException(HttpStatus.FOUND,"email alrady exit");
			
		} else if(employee.getPassword().equals(employee.getConfpassword()))
		{
			employee.setPassword(passwordEncoder.encode(employee.getConfpassword()));
			Employee insertedEmployee=employeeRepositry.save(employee);
		    EmplyeeResponseWrapper err= new EmplyeeResponseWrapper();
		    err.setMessage("registion sucess");
		    err.setData(insertedEmployee);
		    return new ResponseEntity<>(err,HttpStatus.OK);
		}
		else 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"password does not mach");
			
		}
	}

}
