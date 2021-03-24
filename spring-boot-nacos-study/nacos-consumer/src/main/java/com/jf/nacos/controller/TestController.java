package com.jf.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jf.common.utils.result.BaseResult;

/**
 * @author 潇潇暮雨
 * @create 2018-09-29 22:12
 */

@RestController
public class TestController {

	@GetMapping("/")
	public BaseResult<String> test() {

		return BaseResult.success();
	}
}
