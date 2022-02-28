package com.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagementsystem.entities.Employees;
import com.employeemanagementsystem.service.EmployeeService;

import javax.websocket.server.PathParam;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	@GetMapping("/employees")
	 public List<Employees> getEmployees()
	 {
	return	this.employeeservice.getEmployees();
	 }
    @GetMapping("/employees/{employeeId}")
    public Employees getEmployee(@PathVariable String employeeId)
    {
    	System.out.println(employeeId);
    	return	this.employeeservice.getEmployee(Long.parseLong(employeeId));
    	
    }
    @PostMapping("/employees")
    public Employees addEmployee(@RequestBody Employees employee)
    {
        System.out.println(employee.getEmpId());

        return this.employeeservice.addEmployee(employee);
    }
    @PutMapping("/employees")
    public Employees updateEmployee(@RequestBody Employees employee)
    {
    	return this.employeeservice.updateEmployee(employee);
    }
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String employeeId)
    {
    	try {
    this.employeeservice.deleteEmployee(Long.parseLong(employeeId));
    return new ResponseEntity<>(HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}
