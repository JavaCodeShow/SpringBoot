package com.jf.mapper;

import com.jf.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 潇潇暮雨
 * @create 2018-10-05   20:10
 */
@Mapper
public interface UserMapper {
    User getUserById(Integer id);
}
