package com.employeemanagementsystem.service;

import java.util.List;
import com.employeemanagementsystem.entities.Employees;

public interface EmployeeService {

    List<Employees> getEmployees();
    Employees addEmployee(Employees employee);
    Employees updateEmployee(Employees employee);
    void deleteEmployee(long employeeId);
    Employees getEmployee(long employeeId);

}
