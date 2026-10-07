package com.EMP.employee_man_system.EmpMapper;

import com.EMP.employee_man_system.Dto.EmployeeDTO;
import com.EMP.employee_man_system.Entity.Employee;

public class EmpMapper {
	
	public static EmployeeDTO mapToEmployeeDTO(Employee employee)
	{
		return new EmployeeDTO(employee.getEmpId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail());
}
	

	public static Employee mapToEmployee(EmployeeDTO employeeDTO)
	{
		return new Employee(employeeDTO.getEmpId(),
				employeeDTO.getFirstName(),
				employeeDTO.getLastName(),
				employeeDTO.getEmail());
	}
}
