package com.Company.Management.Repository;

import com.Company.Management.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Department, Long> {
}
