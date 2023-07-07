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
import com.app.dto.DepartmentDTO;
import com.app.exceptions.CustomException;
import com.app.services.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;

	// add a department
	@PostMapping("/add")
	public ApiResponse addDepartment(@RequestBody DepartmentDTO department) {
		return deptService.addDepartment(department);
	}

	//get all employee
	@GetMapping
	public ResponseEntity<?> getAllDepartment() {
		//return new ResponseEntity<>(deptService.getAllDepartments(), HttpStatus.CREATED);
		return ResponseEntity.status(HttpStatus.OK).body(deptService.getAllDepartments());
		
	}
	
	//update department location
	@PutMapping("/{id}")
	public ApiResponse updateLocation(@PathVariable long id,String location)  throws CustomException{
		
		return deptService.updateLocation(id,location);
	}
	
	//delete department
	@DeleteMapping("/{id}")
	public ApiResponse deleteDept(@PathVariable long id) throws CustomException{
		return deptService.deleteDept(id);
	}
	

}
