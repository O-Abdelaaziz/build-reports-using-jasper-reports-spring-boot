package com.jasperreport;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.base.JRBaseTextField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class JasperreportspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JasperreportspringbootApplication.class, args);

        try{
//            ClassLoader classLoader = JasperreportspringbootApplication.class.getClassLoader();
//            File file = new File(classLoader.getResource("first_report.jrxml").getFile());
//            Map<String,Object> parameters = new HashMap<>();
//            parameters.put("studentName","Abdelaaziz");
//
//            Employee employee1=new Employee(1L, "employee1","emloyee1","street1","city1");
//            Employee employee2=new Employee(2L, "employee2","emloyee2","street2","city2");
//
//            List<Employee> stringList=new ArrayList<>();
//            stringList.add(employee1);
//            stringList.add(employee2);
//
//            JRBeanCollectionDataSource collectionDataSource=new JRBeanCollectionDataSource(stringList);
//
//            JasperReport jasperReport= JasperCompileManager.compileReport(file.getPath());
//
//            JRBaseTextField textField=(JRBaseTextField) jasperReport.getTitle().getElementByKey("name");
//            textField.setForecolor(Color.RED);
//
//            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,parameters,collectionDataSource);
//
//            String exportFilePath="E:\\first_report.pdf";
//            JasperExportManager.exportReportToPdfFile(jasperPrint,exportFilePath);
//
//            System.out.println("report printed");


            ClassLoader classLoader = JasperreportspringbootApplication.class.getClassLoader();
            File file = new File(classLoader.getResource("second_report.jrxml").getFile());

            Employee employee1=new Employee(1L,"mahi","amine","street1","city1",15L);
            Employee employee2=new Employee(2L,"loumi","samir","street2","city2",18L);
            Employee employee3=new Employee(3L,"louki","ahmed","street3","city3",14L);

            List<Employee> stringList=new ArrayList<>();
            stringList.add(employee1);
            stringList.add(employee2);
            stringList.add(employee3);

            JRBeanCollectionDataSource collectionDataSource=new JRBeanCollectionDataSource(stringList);

            Map<String,Object> parameters = new HashMap<>();
            parameters.put("employeeName","Abdelaaziz");
            parameters.put("reportName","Employee of The Year");
            parameters.put("tableData",collectionDataSource);


            JasperReport jasperReport= JasperCompileManager.compileReport(file.getPath());

            JRBaseTextField textField=(JRBaseTextField) jasperReport.getTitle().getElementByKey("emp_of_year");
            textField.setForecolor(Color.green);

            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,parameters,new JREmptyDataSource());

            String exportFilePath="E:\\first_report.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint,exportFilePath);

            System.out.println("report printed");
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

}
