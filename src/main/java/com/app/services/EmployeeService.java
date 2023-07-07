package com.app.services;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.EmployeeDTO;
import com.app.exceptions.CustomException;

public interface EmployeeService {

	ApiResponse addEmployee(EmployeeDTO emp)throws CustomException;

	List<EmployeeDTO> getAllEmployee();

	ApiResponse deleteEmployee(long id) throws CustomException;

	ApiResponse updateSal(long id, double sal)throws CustomException;
	
	

}
