package com.jf.sharding.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jf.sharding.jdbc.domain.entity.OrderConfigEntity;
import com.jf.sharding.jdbc.mapper.OrderConfigMapper;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-05-28 10:27
 * @since: 2.20.1.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderConfigMapperTest {
	@Autowired
	private OrderConfigMapper orderConfigMapper;

	@Test
	public void testSelectById() {
		OrderConfigEntity orderConfig = orderConfigMapper.selectById(1);
		System.out.println(orderConfig);
	}

}
