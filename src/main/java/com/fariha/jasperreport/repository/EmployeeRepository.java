package com.fariha.jasperreport.repository;

import com.fariha.jasperreport.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
