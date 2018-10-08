package com.jf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@ImportResource("classpath:beans.xml")
public class SpringBootConfigAutoconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigAutoconfigApplication.class, args);
    }
}
