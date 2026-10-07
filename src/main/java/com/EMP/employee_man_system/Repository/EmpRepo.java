package com.EMP.employee_man_system.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.EMP.employee_man_system.Entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Long> {
	
	
	@Query("select p from Employee p where p.firstName LIKE CONCAT(:empName,'%')")
	public List<Employee> findByEmployeeName(@Param("empName")String firstName);
}
