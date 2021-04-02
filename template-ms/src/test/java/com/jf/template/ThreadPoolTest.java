package com.jf.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-24 11:16
 * @since: 2.22.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadPoolTest {

	@Autowired
	@Qualifier("baseAsyncExecutor")
	private ThreadPoolTaskExecutor baseAsyncExecutor;

	@Test
	public void testThreadPool() {
		baseAsyncExecutor.execute(() -> {
			System.out.println("hello");
			System.out.println("hello");
			System.out.println("hello");
		});
	}

}
