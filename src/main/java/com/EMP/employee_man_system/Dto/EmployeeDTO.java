package com.EMP.employee_man_system.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO
{
	
	
	private Long empId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
}
