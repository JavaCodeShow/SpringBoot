package com.jf.rocketmqstudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {

	@RequestMapping("/")
	public String hello() {
		log.info("hello world");
		return "Hello RockerMQ ";
	}

}
