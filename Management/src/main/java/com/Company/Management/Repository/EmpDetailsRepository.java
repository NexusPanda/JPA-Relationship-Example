package com.Company.Management.Repository;

import com.Company.Management.Model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpDetailsRepository extends JpaRepository<EmployeeDetails, Long> {
}
