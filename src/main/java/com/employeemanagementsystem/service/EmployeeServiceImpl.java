package com.employeemanagementsystem.service;

import java.util.List;
import com.employeemanagementsystem.Dao.EmployeeDao;
import com.employeemanagementsystem.exception.EmployeeListEmptyException;
import com.employeemanagementsystem.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeemanagementsystem.entities.Employees;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeedao;

    @Override
    public List<Employees> getEmployees() {

        if(employeedao.count()==0)
            throw new EmployeeListEmptyException();
        return employeedao.findAll();

    }

    @Override
    public Employees addEmployee(Employees employee) {

        employeedao.save(employee);
        return employee;

    }

    @Override
    public Employees updateEmployee(Employees employee) {

    if(!employeedao.existsById(employee.getEmpId()))  throw new EmployeeNotFoundException();
        employeedao.save(employee);
        return employee;

    }

    @Override
    public void deleteEmployee(long employeeId) {

        if(!employeedao.existsById(employeeId))  throw new EmployeeNotFoundException();
        employeedao.deleteById(employeeId);

    }

    @Override
    public Employees getEmployee(long employeeId) {

      if(!employeedao.existsById(employeeId))  throw new EmployeeNotFoundException();
        return employeedao.findById(employeeId).get();

    }

}
