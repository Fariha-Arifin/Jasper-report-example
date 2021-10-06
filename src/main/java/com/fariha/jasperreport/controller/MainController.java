package com.fariha.jasperreport.controller;

import com.fariha.jasperreport.model.Employee;
import com.fariha.jasperreport.repository.EmployeeRepository;
import com.fariha.jasperreport.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    EmployeeRepository employeeRepo;

    @Autowired
    ReportService reportService;

    @RequestMapping("/welcome")
    public String welcome()
    {
        return "Welcome page";
    }

    @RequestMapping("/employees")
    public List<Employee> findemployees()
    {
        return employeeRepo.findAll();
    }

    @RequestMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return reportService.exportReport(format);

    }

}
