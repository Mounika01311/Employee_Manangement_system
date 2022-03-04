package com.employeemanagementsystem.entities;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Employees")
public class Employees {
    @Id

    private long empId;
    private String name;
    private int age;
    private String department;
    private String designation;
    private String gender;
    public Employees(long empId, String name, int age, String department, String designation, String gender) {
        super();
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.designation = designation;
        this.gender = gender;
    }
    public Employees() {
        super();

    }
    public long getEmpId() {
        return empId;
    }
    public void setEmpId(long empId) {
        this.empId = empId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }




}
