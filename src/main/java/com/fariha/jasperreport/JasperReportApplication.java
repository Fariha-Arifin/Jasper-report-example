package com.fariha.jasperreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JasperReportApplication {

    public static void main(String[] args) {
      //  SpringApplication.run(JasperReportApplication.class, args);

        SpringApplicationBuilder builder = new SpringApplicationBuilder(JasperReportApplication.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
    }

}
