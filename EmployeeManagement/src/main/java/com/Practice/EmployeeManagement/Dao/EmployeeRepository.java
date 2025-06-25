package com.Practice.EmployeeManagement.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.Practice.EmployeeManagement.Entity.Employee;

import Dtos.EmployeeDto;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
  
    List<Employee> findByNameIgnoreCase(String name);
    List<Employee> findByAge(int age);
	Employee save(EmployeeDto employee);
	List<Employee> findByNameContainingIgnoreCase(String name);
	Optional<Employee> findByFileName(String filename);
	
	
}
