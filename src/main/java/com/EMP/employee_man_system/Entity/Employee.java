package com.EMP.employee_man_system.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	
	@Column(name = "first_name")
	@NotBlank(message = "FirstName Required")
	private String firstName;
	@Column(name = "last_name")
	@NotBlank(message = "LastName is required")
	private String lastName;
	@Column(name = "email",nullable = false,unique = true)
	@NotBlank(message = "Email is Required")
	private String email;
}
