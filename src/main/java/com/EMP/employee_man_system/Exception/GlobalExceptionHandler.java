package com.EMP.employee_man_system.Exception;

import java.util.HashMap;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = EmployeeNotFound.class)
	public ResponseEntity<String> userNotFound(EmployeeNotFound notFound)
	{
		return new ResponseEntity<String>(notFound.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<HashMap<String,String>> handleNotNull(MethodArgumentNotValidException notNUll)
	{
		HashMap<String,String> getErr = new HashMap<>();
		
		notNUll.getBindingResult().getFieldErrors().forEach(ele->
		{
			getErr.put(ele.getField(), ele.getDefaultMessage());
		});
		
		
		return new ResponseEntity<HashMap<String,String>>(getErr,HttpStatus.BAD_REQUEST);
	}

    @ExceptionHandler(value =  ConstraintViolationException.class)
    public ResponseEntity<HashMap<String, String>> handleConstraintViolation(ConstraintViolationException ex) {
    	
    	
    	HashMap<String,String> map = new HashMap<>();
    	
    	ex.getConstraintViolations().forEach(ele->{
    		map.put(ele.getPropertyPath().toString(),ele.getMessage());
    	});
    	
    	return new ResponseEntity<HashMap<String,String>>(map,HttpStatus.BAD_REQUEST);
    	
    	
    }
    
    
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<HashMap<String, String>> handleSameEmail(DataIntegrityViolationException exp)
    {
    	HashMap<String,String> map = new HashMap<>();
    	
    	map.put("dupliEmail","Email already taken");
    	
    	return new ResponseEntity<HashMap<String,String>>(map,HttpStatus.BAD_REQUEST);
    }
	
}
