package com.visitorLog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visitorLog.entity.Employee;
import com.visitorLog.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	/*save an employee */
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
		
	}
	
	
	/*search all employee*/
	public List<Employee> findAll(){
		return employeeRepository.findAll();
		
	}
	
	/*get an employee by id*/
	public Employee findById(int eId) {
		Employee emp = employeeRepository.findByeId(eId);
				 //employeeRepository.findById(eId).orElseThrow(() -> new EntityNotFoundException("Data Not found"));
		return emp;
	}
	
	/*get an employee by email*/
	public Employee findByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}
	
	/*delete an employee */
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}
	
	//update
	public void updateEmployee(Employee employee, int id) {
		Employee emp = employeeRepository.findById(id).orElse(new Employee());
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setEmail(employee.getEmail());
			emp.setPhone(employee.getPhone());
			emp.setPassword(employee.getPassword());
			employeeRepository.save(emp);
	}
	
	
}
