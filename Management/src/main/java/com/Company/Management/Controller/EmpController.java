package com.Company.Management.Controller;

import com.Company.Management.Model.Employee;
import com.Company.Management.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emp/public")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(empService.getAllEmployee(), HttpStatus.OK);
    }

    @PostMapping("/emp/public")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(empService.saveTheEmployee(employee), HttpStatus.CREATED);
    }
}
