package com.jf.sharding.jdbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jf.sharding.jdbc.domain.entity.OrderEntity;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2021-05-27 23:53:44
 * @since
 */
public interface OrderMapper {

	OrderEntity selectById(@Param("id") Integer id);

	List<OrderEntity> selectListByUserId(@Param("userId") Integer userId);

	void insert(OrderEntity order);
}
