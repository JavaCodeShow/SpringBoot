package com.jf.mps.user.mapper;

import com.jf.mps.user.domain.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 江峰
 * @create 2020-03-22 11:41
 */
@Mapper
public interface UserMapper {

    UserEntity findById(String id);


}
