package com.jf.css;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jf.css.factory.caseone.plugin.PersonProvider;
import com.jf.css.factory.casetwo.PersonFactory;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-03-24 11:20
 * @since: 2.22.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryPatternTest {

	@Autowired
	private PersonProvider eventRetryPluginProvider;

	@Test
	public void testPersonFactory() {
		PersonFactory.match(1).say();
		PersonFactory.match(2).say();
	}

	@Test
	public void testPlugin() {
		eventRetryPluginProvider.get(1).say();
		eventRetryPluginProvider.get(2).say();
	}

}
