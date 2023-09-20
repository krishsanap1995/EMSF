package com.EMS.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	@Size(min = 4, max = 10,message = "name must be between 4 -10 charaters")
	private String name;
	
	@Column(nullable = false)
	@Size(min = 4,message = "password must be between 4 -10 charaters")
	private String password;
	
	@Transient
	@JsonProperty(access = Access.WRITE_ONLY)
	@Size(min = 4,message = "conf password must be between 4 -10 charaters")
	private String confpassword;
	
	
	@Column
	@Size(min = 10,max = 10 ,message = "phone number be 10 digit")
	private String phone;
	
	@Email
	@Column(nullable = false,unique = true)
	private String email;
	
	@ElementCollection
	private List<String>roles;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToMany(mappedBy = "employee")
	private List<Account> account;
	
	@ManyToMany
	@JoinTable(
			name = "employee_project",
			joinColumns = @JoinColumn(name="employee_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="project_id",referencedColumnName = "id")
			)
	private List<Project> project;

}





















