package com.Company.Management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeDetails.id")
    private EmployeeDetails employeeDetails;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department.id")
    private Department department;

    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employee.id"),
            inverseJoinColumns = @JoinColumn(name = "projects.id")
            )
    @JsonIgnore
    List<Project> projects = new ArrayList<>();
}
