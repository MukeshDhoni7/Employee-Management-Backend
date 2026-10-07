package com.EMP.employee_man_system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.EMP.employee_man_system.Dto.EmployeeDTO;
import com.EMP.employee_man_system.Services.EmployeeService;

import jakarta.validation.Valid;


@CrossOrigin("*")
@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO)
	{
		EmployeeDTO saveEmployee = employeeService.createEmployee(employeeDTO);
		
		return  new ResponseEntity<EmployeeDTO>(saveEmployee,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getById")
	public ResponseEntity<EmployeeDTO> getEmpById(@RequestParam Long id)
	{
		EmployeeDTO employeeDto = employeeService.getEmployeesById(id);
		
		return new ResponseEntity<EmployeeDTO>(employeeDto,HttpStatus.OK);
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees()
	{
		List<EmployeeDTO> emploDto = employeeService.getAllEmployees();
		
		return new ResponseEntity<List<EmployeeDTO>>(emploDto,HttpStatus.OK);
	}
	
	
	@GetMapping("/getByName")
	public ResponseEntity<List<EmployeeDTO>> getEmployeesByName(@RequestParam String empName)
	{
		List<EmployeeDTO> employees = employeeService.getEmployeesbyName(empName);
		
		return new ResponseEntity<List<EmployeeDTO>>(employees, HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<EmployeeDTO> updateEployees(@RequestParam Long id,@RequestBody EmployeeDTO empDto)
	{
		EmployeeDTO employees = employeeService.updateEmployees(id, empDto);
		
		return new ResponseEntity<EmployeeDTO>(employees,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<String> deleteById(@RequestParam Long id)
	{
		employeeService.deleteEmployeeById(id);
		
		return new ResponseEntity<String>("User with ID "+id+" deleted Successfully",HttpStatus.OK);
	}
}

