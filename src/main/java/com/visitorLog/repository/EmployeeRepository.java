package com.visitorLog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.visitorLog.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value="Select * from Employee where email = ?1", nativeQuery=true)
	public Employee findByEmail(String email);
	
	public Employee findByeId(int id);
}
