package com.jf.sharding.jdbc;

import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jf.sharding.jdbc.domain.entity.OrderEntity;
import com.jf.sharding.jdbc.mapper.OrderMapper;

/**
 * 描述: 读写分离测试
 *
 * @author: 江峰
 * @create: 2021-05-28 11:07
 * @since: 2.20.1.1
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperMasterSlaveTest {

	@Autowired
	private OrderMapper orderMapper;

	@Test
	public void testSelectById() { // 测试从库的负载均衡
		for (int i = 0; i < 2; i++) {
			OrderEntity order = orderMapper.selectById(1);
			System.out.println(order);
		}
	}

	@Test
	public void testSelectById02() { // 测试强制访问主库
		try (HintManager hintManager = HintManager.getInstance()) {
			// 设置强制访问主库
			hintManager.setMasterRouteOnly();
			// 执行查询
			OrderEntity order = orderMapper.selectById(1);
			System.out.println(order);
		}
	}

	@Test
	public void testInsert() { // 插入
		OrderEntity order = new OrderEntity();
		order.setUserId(10);
		orderMapper.insert(order);
	}

}
