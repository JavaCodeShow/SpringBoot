package com.jf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import com.jf.css.factory.caseone.plugin.PersonProvider;
import com.jf.css.factory.casetwo.PersonFactory;
import com.jf.css.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebApplicationTests {

	@Autowired
	private OrderService orderService;

	@Autowired
	private PersonProvider eventRetryPluginProvider;

	// @Autowired()
	// @Qualifier("baseAsyncExecutor")
	// private ThreadPoolTaskExecutor baseAsyncExecutor;

	@Test
	public void testSpringEvent() {
		orderService.order();
	}

	@Test
	public void testPersonFactory() {
		PersonFactory.match(1).say();
		PersonFactory.match(2).say();
	}

	@Test
	public void testThreadPool() {
		// baseAsyncExecutor.execute(() -> {
		// System.out.println("hello");
		// });
		hello();
	}

	@Async("baseAsyncExecutor")
	void hello() {
		System.out.println("hello");
	}

	@Test
	public void testPlugin() {
		eventRetryPluginProvider.get(1).say();
		eventRetryPluginProvider.get(2).say();
	}

}
