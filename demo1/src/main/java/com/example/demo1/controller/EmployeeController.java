package com.example.demo1.controller;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.entity.Employee;
import com.example.demo1.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.GET)
	public Employee saveEmployee(){
		return employeeService.saveEmployee();
	}
	
	@RequestMapping(value = "/updateEmployee/{employeeId}", method = RequestMethod.GET)
	public Employee updateEmployee(@NotEmpty @PathVariable ("employeeId") Integer employeeId){
		return employeeService.updateEmployee(employeeId);
	}
}
