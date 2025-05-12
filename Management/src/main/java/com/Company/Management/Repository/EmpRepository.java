package com.Company.Management.Repository;

import com.Company.Management.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee, Long> {
}
