package com.Company.Management.DefaultValueInitializer;

import com.Company.Management.Model.Department;
import com.Company.Management.Model.Employee;
import com.Company.Management.Model.EmployeeDetails;
import com.Company.Management.Model.Project;
import com.Company.Management.Repository.DeptRepository;
import com.Company.Management.Repository.EmpDetailsRepository;
import com.Company.Management.Repository.EmpRepository;
import com.Company.Management.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private EmpDetailsRepository empDetailsRepository;

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Bean
    public CommandLineRunner run(){
        return args -> {
            Employee employee1 = new Employee();
            employee1.setName("PandaBlueee");

            Employee employee2 = new Employee();
            employee2.setName("PandaReddd");

            empRepository.save(employee1);
            empRepository.save(employee2);

            EmployeeDetails employeeDetails1 = new EmployeeDetails();
            employeeDetails1.setBio("Java Developer");

            EmployeeDetails employeeDetails2 = new EmployeeDetails();
            employeeDetails2.setBio("BackEnd Developer");

            empDetailsRepository.save(employeeDetails1);
            empDetailsRepository.save(employeeDetails2);

            employee1.setEmployeeDetails(employeeDetails1);
            employee2.setEmployeeDetails(employeeDetails2);
            employeeDetails1.setEmployee(employee1);
            employeeDetails2.setEmployee(employee2);
            empRepository.save(employee1);
            empRepository.save(employee2);

            Department department1 = new Department();
            Department department2 = new Department();

            department1.setDeptName("Software Developer");
            department2.setDeptName("Server-Side Developer");

            department1.addEmployee(employee1);
            department2.addEmployee(employee2);

            empRepository.save(employee1);
            empRepository.save(employee2);

            Project project1 = new Project();
            project1.setEmployees(List.of(employee1, employee2));

            employee1.setProjects(List.of(project1));

            projectRepository.save(project1);

            empRepository.save(employee1);
            empRepository.save(employee2);


        };
    }
}
