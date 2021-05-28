package com.jf.sharding.jdbc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jf.common.utils.aspect.log.MethodLogger;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *
 * @author 江峰
 * @create 2021-05-17 14:54
 */
@RestController
@Slf4j
public class HelloController {

	@RequestMapping("/")
	@MethodLogger
	public String hello() {
		return "hello sharding jdbc is running";
	}

}
