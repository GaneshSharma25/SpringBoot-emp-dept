package com.app.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.ApiResponse;
import com.app.dto.DepartmentDTO;
import com.app.exceptions.CustomException;

public interface DepartmentService {

	ApiResponse addDepartment(DepartmentDTO department);

	List<DepartmentDTO> getAllDepartments();

	ApiResponse updateLocation(long id,String location)  throws CustomException;

	ApiResponse deleteDept(long id) throws CustomException;
    	

}
