package com.jasperreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.HashMap;
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
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

}
