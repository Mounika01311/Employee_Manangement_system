package com.employeemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagementsystem.employeedao.EmployeeDao;
import com.employeemanagementsystem.entities.Employees;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeedao;
	
	
	@Override
	public List<Employees> getEmployees() {

		return employeedao.findAll();
	}

	@Override
	public Employees addEmployee(Employees employee) {


		employeedao.save(employee);
		return employee;
	}
	@Override
	public Employees updateEmployee(Employees employee) {

		employeedao.save(employee);
		return employee;
	}
	@Override
	public void deleteEmployee(long employeeId) {

		
		employeedao.deleteById(employeeId);
		
	}

	@Override
	public Employees getEmployee(long employeeId) {
		System.out.println(employeeId);

		return employeedao.findById(employeeId).get();
	}


}
