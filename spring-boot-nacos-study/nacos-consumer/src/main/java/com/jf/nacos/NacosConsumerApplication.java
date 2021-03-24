package com.jf.nacos;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

import com.jf.common.utils.config.JfCommonUtilsConfig;

import java.text.DateFormat;

@SpringBootApplication
@Import({ JfCommonUtilsConfig.class })
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class NacosConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosConsumerApplication.class, args);
	}
}
