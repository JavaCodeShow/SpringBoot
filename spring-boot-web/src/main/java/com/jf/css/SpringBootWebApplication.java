package com.jf.css;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.jf.common.config.JfCommonUtilsConfig;

@SpringBootApplication
@Import({ JfCommonUtilsConfig.class })
public class SpringBootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
}
