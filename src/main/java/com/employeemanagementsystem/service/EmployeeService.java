package com.employeemanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.employeemanagementsystem.employeedao.EmployeeDao;
import com.employeemanagementsystem.entities.Employees;

public interface EmployeeService {
	
	public List<Employees> getEmployees();
	public Employees addEmployee(Employees employee);
	public Employees updateEmployee(Employees employee);
	public void deleteEmployee(long employeeId);
	Employees getEmployee(long employeeId);
}
