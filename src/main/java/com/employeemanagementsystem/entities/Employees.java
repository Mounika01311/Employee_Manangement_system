package com.employeemanagementsystem.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
@Data

public class Employees {

    @Id
    private long empId;
    private String name;
    private int age;
    private String department;
    private String designation;
    private String gender;

    public Employees()
    {
        super();
    }

}
