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

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeservice;

    @GetMapping("/employees")
    public ResponseEntity<List<Employees>>  getEmployees()
    {
        List<Employees> listOfAllEmps = this.employeeservice.getEmployees();
        return new ResponseEntity<List<Employees>>(listOfAllEmps, HttpStatus.OK);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employees>  getEmployee(@PathVariable String employeeId) {

            Employees empRetrieved = this.employeeservice.getEmployee(Long.parseLong(employeeId));
            return new ResponseEntity<Employees>(empRetrieved, HttpStatus.OK);

    }

    @PostMapping("/employees")
    public ResponseEntity<Employees> addEmployee(@RequestBody Employees employee)
    {
        return new ResponseEntity<Employees>(this.employeeservice.addEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees")
    public  ResponseEntity<Employees> updateEmployee(@RequestBody Employees employee)
    {

            Employees employeeSaved = this.employeeservice.updateEmployee(employee);
            return new ResponseEntity<Employees>(employeeSaved, HttpStatus.CREATED);

    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String employeeId)
    {

        this.employeeservice.deleteEmployee(Long.parseLong(employeeId));
        return new ResponseEntity<>(HttpStatus.OK);


    }
}

