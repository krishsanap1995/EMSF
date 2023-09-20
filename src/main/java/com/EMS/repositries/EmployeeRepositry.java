package com.EMS.repositries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.EMS.models.Employee;
import java.util.List;


public interface EmployeeRepositry extends JpaRepository<Employee, Integer>{
	@RestResource(exported = false)
	Optional<Employee> findByEmail(String email);
	
	@RestResource
	<S extends Employee> S save(S entities);
	

	

}
