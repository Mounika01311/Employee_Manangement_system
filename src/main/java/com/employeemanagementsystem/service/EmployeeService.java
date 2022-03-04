package com.employeemanagementsystem.service;

import java.util.List;

import com.employeemanagementsystem.entities.Employees;

public interface EmployeeService {

    public List<Employees> getEmployees();
    public Employees addEmployee(Employees employee);
    public Employees updateEmployee(Employees employee);
    public void deleteEmployee(long employeeId);
    Employees getEmployee(long employeeId);
}
