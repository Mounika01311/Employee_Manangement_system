package com.employeemanagementsystem.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.employeemanagementsystem.entities.Employees;

@Repository
public interface EmployeeDao extends JpaRepository<Employees, Long> {


}
