package com.visitorLog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visitorLog.entity.Employee;
import com.visitorLog.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	Map<String, String> errors;
	
	/* save an Employee to database*/
	@RequestMapping(value="/addNewEmployee",method=RequestMethod.POST,
	consumes=MediaType.APPLICATION_JSON_VALUE, 
	produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addNewEmployee(@RequestBody @Valid Employee employee, BindingResult bindingResult) {
		
		//catch error if occured
		if(bindingResult.hasErrors()) {
			errors = new HashMap<>();
			for(FieldError error:bindingResult.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
		}
		
		//throw exception if already exist.
		Employee emp = employeeService.findByEmail(employee.getEmail());
		if(emp != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
			
		return new ResponseEntity<>(employeeService.save(employee),HttpStatus.OK);
	
	}
	
	/*get all Employee*/
	@RequestMapping(value="/getAll",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List <Employee> employee = employeeService.findAll();
		System.out.println("---get all employee works");
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	/*get employee by Id*/
	@RequestMapping(value="/findById/{id}",method=RequestMethod.GET,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Employee employee = employeeService.findById(id);
		if(employee == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	/*get employee by email*/
	@RequestMapping(value="/findByEmail",method=RequestMethod.GET,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeByEmail(String email){
		
		Employee employee = employeeService.findByEmail(email);
		if(employee == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	/*Login*/
	@RequestMapping(value="/login",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> login(@RequestBody Employee employee){
		
		Employee emp = employeeService.findByEmail(employee.getEmail());
		if(emp == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			if(emp.getPassword().equals(employee.getPassword())) {
				return new ResponseEntity<>(emp,HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
			
		}
		
	}
	
	
	//update employee information)
	@RequestMapping(value="/update",method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		employeeService.updateEmployee(employee, employee.geteId());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//delete employee
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE,
	consumes=MediaType.APPLICATION_JSON_VALUE, 
	produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable int id){
		employeeService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

//consumes=MediaType.APPLICATION_JSON_VALUE,
//produces = MediaType.APPLICATION_JSON_VALUE
