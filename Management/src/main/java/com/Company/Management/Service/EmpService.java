package com.Company.Management.Service;

import com.Company.Management.Model.Employee;
import com.Company.Management.Repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public List<Employee> getAllEmployee(){
        return empRepository.findAll();
    }

    public Employee saveTheEmployee(Employee employee){
        empRepository.save(employee);
        return employee;
    }
}
