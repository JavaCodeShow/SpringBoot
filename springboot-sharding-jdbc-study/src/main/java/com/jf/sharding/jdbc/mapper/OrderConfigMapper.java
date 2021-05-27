package com.jf.sharding.jdbc.mapper;

import org.apache.ibatis.annotations.Param;

import com.jf.sharding.jdbc.domain.entity.OrderConfigEntity;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2021-05-27 23:55:54
 * @since
 */
public interface OrderConfigMapper {

    OrderConfigEntity selectById(@Param("id") Integer id);

}