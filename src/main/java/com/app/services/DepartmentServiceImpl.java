package com.app.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.DepartmentDTO;
import com.app.entites.Department;
import com.app.exceptions.CustomException;
import com.app.repositories.DepartmentRepository;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public ApiResponse addDepartment(DepartmentDTO deptDto) {
		Department map = mapper.map(deptDto, Department.class);
		deptRepo.save(map);
		return new ApiResponse("Department added successfully!!");
	}

	@Override
	public List<DepartmentDTO> getAllDepartments() {
		List<DepartmentDTO> deptDtoList = new ArrayList<DepartmentDTO>();
		List<Department> deptList = deptRepo.findAll();
		deptList.forEach((d) -> {deptDtoList.add(mapper.map(d, DepartmentDTO.class));});
		return deptDtoList;
	}

	@Override
	public ApiResponse updateLocation(long id,String location) throws CustomException {
		Department dept = deptRepo.findById(id).orElseThrow(() -> new CustomException("Invalid Department ID"));
		dept.setDeptLoc(location);
		deptRepo.save(dept);
		return new ApiResponse("Location updated Successfully!!");
	}

	@Override
	public ApiResponse deleteDept(long id) throws CustomException {
		Department dept = deptRepo.findById(id).orElseThrow(() -> new CustomException("Invalid Department ID"));
		deptRepo.deleteById(id);
		return new ApiResponse("Department deleted successfully!!");
	}
	
	

}
