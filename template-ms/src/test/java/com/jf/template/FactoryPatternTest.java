package com.jf.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jf.template.factory.casetwo.PersonFactory;

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

	@Test
	public void testPersonFactory() {
		PersonFactory.match(1).say();
		PersonFactory.match(2).say();
	}

}
