package com.jasperreport;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.base.JRBaseTextField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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


            JasperReport jasperReport= JasperCompileManager.compileReport(file.getPath());

            JRBaseTextField textField=(JRBaseTextField) jasperReport.getTitle().getElementByKey("emp_of_year");
            textField.setForecolor(Color.green);

            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,parameters,chartDataSource);

            String exportFilePath="E:\\first_report.pdf";
            String exportFileHtml="E:\\first_report.html";
            String exportFileExcel="E:\\first_report.xlsx";
            JasperExportManager.exportReportToPdfFile(jasperPrint,exportFilePath);
            JasperExportManager.exportReportToHtmlFile(jasperPrint,exportFileHtml);

            JRXlsxExporter exporter=new JRXlsxExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new FileOutputStream(exportFileExcel)));
            exporter.exportReport();

            System.out.println("report printed");
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public static JasperReport getSubReport() throws JRException, FileNotFoundException {
        ClassLoader classLoader = JasperreportspringbootApplication.class.getClassLoader();
//        File file = new File(classLoader.getResource("first_report.jrxml").getFile());
        String file= ResourceUtils.getFile("classpath:first_report.jrxml").getAbsolutePath();

        JasperReport jasperReport= JasperCompileManager.compileReport(file);
        return jasperReport;
    }

    public static  JRBeanCollectionDataSource getSubDataSource(){
        Employee employee1=new Employee(1L,"mahi","amine","street1","city1","Java",15L);
        Employee employee2=new Employee(2L,"loumi","samir","street2","city2","Angular",18L);

        List<Employee> stringList = new ArrayList<>();
        stringList.add(employee1);
        stringList.add(employee2);

        JRBeanCollectionDataSource collectionDataSource = new JRBeanCollectionDataSource(stringList);

        return collectionDataSource;
    }

    public  static  Map<String,Object>getSupParameters(){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("studentName","Abdelaaziz");
        return parameters;
    }
}
