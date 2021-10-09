package com.jasperreport;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
            ClassLoader classLoader = JasperreportspringbootApplication.class.getClassLoader();
            File file = new File(classLoader.getResource("first_report.jrxml").getFile());
            Map<String,Object> parameters = new HashMap<>();
            parameters.put("studentName","Abdelaaziz");

            Employee employee1=new Employee(1L, "employee1","emloyee1","street1","city1");
            Employee employee2=new Employee(2L, "employee2","emloyee2","street2","city2");

            List<Employee> stringList=new ArrayList<>();
            stringList.add(employee1);
            stringList.add(employee2);
            
            JRBeanCollectionDataSource collectionDataSource=new JRBeanCollectionDataSource(stringList);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

}
