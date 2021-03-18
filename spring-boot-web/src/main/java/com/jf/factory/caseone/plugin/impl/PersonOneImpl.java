package com.jf.factory.caseone.plugin.impl;

import org.springframework.stereotype.Component;

import com.jf.factory.caseone.plugin.PersonPlugin;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2020-12-15 13:45
 * @since: 2.20.1
 */
@Component
public class PersonOneImpl implements PersonPlugin {
	@Override
	public Integer getKey() {
		return 1;
	}

	@Override
	public void say() {
		System.out.println("I am one");
	}
}
