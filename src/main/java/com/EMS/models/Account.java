package com.EMS.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	@Size(min = 4, max = 10,message = "name must be between 4 -10 charaters")
	private String type;
	
	@Column(nullable = false,unique = true)
	@Size(min = 4, max = 10,message = "account no must be between 4 -10 charaters")
	private String accountNo;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
}


