package com.jf.mapper;

import com.jf.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author 潇潇暮雨
 * @create 2018-10-05   21:07
 */
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    User getUserById(Integer id);

    @Update("update user set name=#{name},sex=#{sex} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);

    @Insert("insert into user(name,sex) values (#{name},#{sex})")
    void insertUser(User user);
}
