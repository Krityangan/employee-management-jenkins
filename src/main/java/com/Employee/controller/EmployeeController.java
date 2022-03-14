package com.Employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.entity.Employee;
import com.Employee.repo.EmployeeRepository;
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@RequestMapping(value="rest/saveemployee", method = RequestMethod.POST)
	public ResponseEntity<?> saveEmployeeDetails(@Valid @RequestBody Employee employee, BindingResult result){
		
		if(result.hasErrors())
			return new ResponseEntity<List<FieldError>>(result.getFieldErrors(),HttpStatus.BAD_REQUEST);
	
		
		return new ResponseEntity<>(employeeRepository.save(employee),HttpStatus.CREATED);
	}
	
	
	
	@RequestMapping(value="/rest/findAll", method = RequestMethod.GET)
	public ResponseEntity<?> getAllEmployee()
	{
		return new ResponseEntity<>(employeeRepository.findAll(),HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/rest/findById", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployeeById(@RequestParam(value = "empId") Long empId)
	{
		return new ResponseEntity<>(employeeRepository.findById(empId),HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/rest/findContactDetailsById", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployeeContactById(@RequestParam(value = "empId") Long empId)
	{
		return new ResponseEntity<>(employeeRepository.getContactDetailsById(empId),HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/rest/findAddressDetailsById", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployeeAddressById(@RequestParam(value = "empId") Long empId)
	{
		return new ResponseEntity<>(employeeRepository.getAddressDetailsById(empId),HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/rest/updateEmloyeeRecord", method = RequestMethod.POST)
	public ResponseEntity<?> updateEmployeeRecord(@Valid @RequestBody Employee employee, BindingResult result)
	{
		return new ResponseEntity<>(employeeRepository.save(employee),HttpStatus.ACCEPTED);
	}
	
}
