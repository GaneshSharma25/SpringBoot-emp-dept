package com.app.services;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.EmployeeDTO;
import com.app.entites.Department;
import com.app.entites.Employee;
import com.app.exceptions.CustomException;
import com.app.repositories.DepartmentRepository;
import com.app.repositories.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private DepartmentRepository deptRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addEmployee(EmployeeDTO emp) throws CustomException {
		System.out.println("In emp : "+emp.getDeptId());
		Department dept = deptRepo.findById(emp.getDeptId())
				.orElseThrow(() -> new CustomException("Invalid Department Id"));
		Employee emp1 = new Employee(emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getSal());
		emp1.setDept(dept);
		empRepo.save(emp1);
		return new ApiResponse("Employee Added Successfully!!");
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<Employee> empList = empRepo.findAll();
		List<EmployeeDTO> empDtoList = new ArrayList<EmployeeDTO>();
		empList.forEach((e) -> {
			empDtoList.add(mapper.map(e, EmployeeDTO.class));
		});
		return empDtoList;
	}

	@Override
	public ApiResponse deleteEmployee(long id) throws CustomException {
		
		if(empRepo.existsById(id)) {
			empRepo.deleteById(id);
			return new ApiResponse("Employee Deleted successfully!!");
		}
		return new ApiResponse("Delete Failed..No employee found by given id.");
	}

	@Override
	public ApiResponse updateSal(long id, double sal) throws CustomException {
		Employee emp = empRepo.findById(id).orElseThrow(() -> new CustomException("Invalid Employee Id"));
		emp.setSal(sal);
		return new ApiResponse("Employee Salary Updated successfully!!");
	}
	
	
	
	

}
