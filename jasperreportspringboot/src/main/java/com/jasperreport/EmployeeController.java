package com.jasperreport;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.base.JRBaseTextField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jasperreport.JasperreportspringbootApplication.*;

/**
 * @Created 14/10/2021 - 19:08
 * @Package com.jasperreport
 * @Project jasperreportspringboot
 * @User LegendDZ
 * @Author Abdelaaziz Ouakala
 **/
@RestController
@RequestMapping("/emloyees")
public class EmployeeController {

    @GetMapping
    public ResponseEntity<byte[]> getReports() throws FileNotFoundException, JRException {
        String file= ResourceUtils.getFile("classpath:second_report.jrxml").getAbsolutePath();
        Employee employee1=new Employee(1L,"mahi","amine","street1","city1","Java",15L);
        Employee employee2=new Employee(2L,"loumi","samir","street2","city2","Angular",18L);
        Employee employee3=new Employee(3L,"louki","ahmed","street3","city3","Laravel",14L);
        Employee employee4=new Employee(3L,"masi","islam","street4","city4","ReactJs",16L);

        List<Employee> stringList=new ArrayList<>();
        stringList.add(employee1);
        stringList.add(employee2);
        stringList.add(employee3);
        stringList.add(employee4);

        JRBeanCollectionDataSource collectionDataSource=new JRBeanCollectionDataSource(stringList);

        JRBeanCollectionDataSource chartDataSource=new JRBeanCollectionDataSource(stringList);

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("employeeName","Abdelaaziz");
        parameters.put("reportName","Employee of The Year");
        parameters.put("tableData",collectionDataSource);
        parameters.put("subReport",getSubReport());
        parameters.put("subDataSource",getSubDataSource());
        parameters.put("studentName",getSupParameters());


        JasperReport jasperReport= JasperCompileManager.compileReport(file);

        JRBaseTextField textField=(JRBaseTextField) jasperReport.getTitle().getElementByKey("emp_of_year");
        textField.setForecolor(Color.green);

        JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,parameters,chartDataSource);

        byte[] byteArray= JasperExportManager.exportReportToPdf(jasperPrint);

        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_PDF);
        httpHeaders.setContentDispositionFormData("fileName","student.pdf");

        System.out.println("report printed");
        return new ResponseEntity<byte[]>  (byteArray,httpHeaders, HttpStatus.OK);
    }
}
