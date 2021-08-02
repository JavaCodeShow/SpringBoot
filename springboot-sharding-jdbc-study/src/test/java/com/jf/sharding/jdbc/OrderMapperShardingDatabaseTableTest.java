package com.jf.sharding.jdbc;

import com.jf.sharding.jdbc.domain.entity.OrderEntity;
import com.jf.sharding.jdbc.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 描述: 分库分表测试
 *
 * @author: 江峰
 * @create: 2021-05-28 10:34
 * @since: 2.20.1.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperShardingDatabaseTableTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testSelectById() {
        OrderEntity order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Test
    public void testSelectListByUserId() {
        List<OrderEntity> orders = orderMapper.selectListByUserId(1);
        System.out.println(orders.size());
    }

    @Test
    public void testInsert() {
        OrderEntity order = new OrderEntity();
        order.setUserId(1);
        orderMapper.insert(order);
    }
}
