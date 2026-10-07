package com.EMP.employee_man_system.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.EMP.employee_man_system.Dto.EmployeeDTO;
import com.EMP.employee_man_system.EmpMapper.EmpMapper;
import com.EMP.employee_man_system.Entity.Employee;
import com.EMP.employee_man_system.Exception.EmployeeNotFound;
import com.EMP.employee_man_system.Repository.EmpRepo;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeSerImple implements EmployeeService {
	
	
	

	private final EmpRepo empRepo;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		
		Employee employee = EmpMapper.mapToEmployee(employeeDTO);
		Employee createEmp = empRepo.save(employee);
		return EmpMapper.mapToEmployeeDTO(createEmp);
	}
	
	
	
	@Override
	public EmployeeDTO getEmployeesById(Long empId) {
		Employee employee = empRepo.findById(empId).orElseThrow(()-> new EmployeeNotFound("Employee not found for this id"+empId));
		
		return EmpMapper.mapToEmployeeDTO(employee);
	}



	@Override
	public List<EmployeeDTO> getAllEmployees() {
		
		List<Employee> employees = empRepo.findAll();
		
		return employees.stream().map(emp -> EmpMapper.mapToEmployeeDTO(emp)).collect(Collectors.toList());
		
	}



	@Override
	public List<EmployeeDTO> getEmployeesbyName(String empName) {
		List<Employee> employee = empRepo.findByEmployeeName(empName);
		
		if(employee.isEmpty())
		{
			throw new EmployeeNotFound("Employee with the Given name "+empName+" is not found");
		}
		
		return employee.stream().map(emp-> EmpMapper.mapToEmployeeDTO(emp)).collect(Collectors.toList());

	}



	@Override
	public EmployeeDTO updateEmployees(Long id, EmployeeDTO employeeDTO) {
		
		Employee existedEmployee = empRepo.findById(id).orElseThrow(()-> new EmployeeNotFound("Employee with this ID "+id+" is not found to update"));
		
		existedEmployee.setFirstName(employeeDTO.getFirstName());
		existedEmployee.setLastName(employeeDTO.getLastName());
		existedEmployee.setEmail(employeeDTO.getEmail());
		
		
		Employee newEmployee = empRepo.save(existedEmployee);
		
		return EmpMapper.mapToEmployeeDTO(newEmployee);
		
	}



	@Override
	public String deleteEmployeeById(Long id) {
	Employee employee =	empRepo.findById(id).orElseThrow(()-> new EmployeeNotFound("Employee with this Id "+id+" is not found"));
		
		empRepo.delete(employee);
		
		return "Deleted Successfully";
		
		
	}
	
	

	
	
	

}
