package com.jf.redisstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jf.common.utils.result.BaseResult;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {

	@GetMapping("/")
	public BaseResult index() {
		return BaseResult.success("hello sentinel");
	}
}
