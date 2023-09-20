package com.EMS.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	@Size(min = 4, max = 10,message = "city name must be between 4 -10 charaters")
	private String city;
	
	@Column(nullable = false)
	@Size(min = 6, max = 6,message = "pin code must be between 6 charaters")
	private String pincode;
	
	@OneToOne(mappedBy ="address" )
    private Employee employee;

}
