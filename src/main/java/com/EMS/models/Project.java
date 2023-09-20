package com.EMS.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false,unique = true)
	@Size(min = 4, max = 10,message = "title name must be between 4 -10 charaters")
	private String title;
	
	
	@Column(nullable = false)
	@Size(min = 4, max = 10,message = "duration  must be between 4 -10 charaters")
	private String duration;
	
	@ManyToMany(mappedBy = "project")
	private List<Employee> employee;
}
