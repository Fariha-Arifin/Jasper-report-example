package com.fariha.jasperreport.service;

import com.fariha.jasperreport.model.Employee;
import com.fariha.jasperreport.repository.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    EmployeeRepository employeeRepository;

    public String exportReport(String format) throws FileNotFoundException, JRException {
        List<Employee> employees = employeeRepository.findAll();
        String path = "C:\\Users\\hp\\Downloads";

        //load the file
        File file = ResourceUtils.getFile("classpath:employee-report.jrxml");

        //compile the file
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        //map the employee data with the file
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);

        HashMap<String,Object> parameter = new HashMap<>();
        parameter.put("Created by","fariha");

        //print the report
        JasperPrint export = JasperFillManager.fillReport(jasperReport,parameter,dataSource);
        JasperViewer jasperViewer = new JasperViewer(export);
        jasperViewer.setVisible(true);

        //check the report format and generate report with the report type
        if (format.equalsIgnoreCase("xls"))
        {
            JasperExportManager.exportReportToHtmlFile(export,path+"\\report.xls");

        }

        if (format.equalsIgnoreCase("pdf"))
        {
            JasperExportManager.exportReportToPdfFile(export,path+"\\report.pdf");

        }


        return "";
    }
}
