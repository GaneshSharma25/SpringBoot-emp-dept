package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entites.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
