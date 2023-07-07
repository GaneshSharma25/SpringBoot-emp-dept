package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.EmployeeDTO;
import com.app.exceptions.CustomException;
import com.app.services.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	
	//Add employee
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeDTO emp) throws CustomException {
		return ResponseEntity.status(HttpStatus.CREATED).body(empService.addEmployee(emp));
	}
	
	//get all employee
	@GetMapping
	public ResponseEntity<?> getAllEmployee(){
		return ResponseEntity.status(HttpStatus.OK).body(empService.getAllEmployee());
	}
	
	//delete employee
	@DeleteMapping("/{id}")
	public ApiResponse deleteEmployee(@PathVariable long id) throws CustomException {
		return empService.deleteEmployee(id);
	}
	
	//update salary
	@PutMapping("/{id}/salary/{sal}")
	public ApiResponse updateSal(@PathVariable long id,@PathVariable double sal) throws CustomException{
		return empService.updateSal(id,sal);
	}

}
