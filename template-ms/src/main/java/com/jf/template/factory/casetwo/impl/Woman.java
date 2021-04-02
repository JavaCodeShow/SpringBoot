package com.jf.template.factory.casetwo.impl;

import org.springframework.stereotype.Component;

import com.jf.template.factory.casetwo.Person;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2020-12-09 10:52:00
 * @since
 */
@Component
public class Woman implements Person {
	@Override
	public Integer getKey() {
		return 2;
	}

	@Override
	public void say() {
		System.out.println("I am woman");
	}
}
