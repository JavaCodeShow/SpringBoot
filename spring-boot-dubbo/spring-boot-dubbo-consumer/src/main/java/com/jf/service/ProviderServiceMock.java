package com.jf.service;

/**
 * @author 江峰
 * @create 2020-04-24 14:01
 */
public class ProviderServiceMock implements ProviderService {
	/**
	 * 请求超时的时候会执行这个方法。
	 * 
	 * @return
	 */
	@Override
	public String sendHello() {
		return "服务提供者挂了";
	}
}
