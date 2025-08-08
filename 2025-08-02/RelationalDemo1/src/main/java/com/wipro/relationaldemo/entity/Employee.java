package com.wipro.relationaldemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String empId;

    private String empName;

    @OneToOne(cascade = CascadeType.ALL)
    private Department dept;


    
    
}

