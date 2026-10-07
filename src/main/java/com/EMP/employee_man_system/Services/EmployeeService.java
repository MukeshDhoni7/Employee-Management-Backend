package com.EMP.employee_man_system.Services;

import java.util.List;

import com.EMP.employee_man_system.Dto.EmployeeDTO;

public interface EmployeeService {
	
	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	
	EmployeeDTO getEmployeesById(Long empId);
	
	List<EmployeeDTO> getAllEmployees();
	
	List<EmployeeDTO> getEmployeesbyName(String empName);
	
	EmployeeDTO updateEmployees(Long id,EmployeeDTO employeeDTO);
	
	String deleteEmployeeById(Long id);
}
