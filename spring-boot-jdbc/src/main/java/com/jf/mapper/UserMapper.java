package com.jf.mapper;

import com.jf.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 潇潇暮雨
 * @create 2018-10-04   14:25
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User getUserById(Integer id);

    @Insert("insert into user(name,sex) values(#{name},#{sex})")
    void insertUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteUserById(Integer id);
}
